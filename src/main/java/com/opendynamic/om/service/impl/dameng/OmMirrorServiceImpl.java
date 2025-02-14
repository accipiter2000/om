package com.opendynamic.om.service.impl.dameng;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.opendynamic.OdUtils;
import com.opendynamic.om.service.OmMainServerService;
import com.opendynamic.om.service.OmMirrorService;
import com.opendynamic.om.service.OmOrgnSetService;
import com.opendynamic.om.vo.OrgnChange;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OmMirrorServiceImpl implements OmMirrorService {
    @Autowired
    private OmOrgnSetService omOrgnSetService;
    @Autowired
    private OmMainServerService omMainServerService;
    @Autowired
    private JdbcTemplate omJdbcTemplate;

    @Override
    public int pullCopyMainServerOrgnSet(String ORGN_SET_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        DataSource mainServerDataSource = getMainServerDataSource();
        JdbcTemplate mainServerJdbcTemplate = new JdbcTemplate(mainServerDataSource);
        String sql;
        BatchPreparedStatementSetter batch;

        omJdbcTemplate.execute("alter table OM_ORG disable constraint FK_OM_ORG_PARENT");

        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(mainServerDataSource);
        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            sql = "delete from OM_TAG where ORGN_SET_ID_ = ?";
            omJdbcTemplate.update(sql, ORGN_SET_ID_);
            sql = "delete from OM_EMP_RELATION where ORGN_SET_ID_ = ?";
            omJdbcTemplate.update(sql, ORGN_SET_ID_);
            sql = "delete from OM_POSI_EMP where ORGN_SET_ID_ = ?";
            omJdbcTemplate.update(sql, ORGN_SET_ID_);
            sql = "delete from OM_EMP where ORGN_SET_ID_ = ?";
            omJdbcTemplate.update(sql, ORGN_SET_ID_);
            sql = "delete from OM_POSI where ORGN_SET_ID_ = ?";
            omJdbcTemplate.update(sql, ORGN_SET_ID_);
            sql = "delete from OM_DUTY where ORGN_SET_ID_ = ?";
            omJdbcTemplate.update(sql, ORGN_SET_ID_);
            sql = "delete from OM_ORG where ORGN_SET_ID_ = ?";
            omJdbcTemplate.update(sql, ORGN_SET_ID_);

            sql = "select * from OM_ORGN_SET where ORGN_SET_ID_ = ?";
            Map<String, Object> orgnSet = mainServerJdbcTemplate.queryForList(sql, ORGN_SET_ID_).get(0);
            if (omOrgnSetService.loadOrgnSet(ORGN_SET_ID_, OPERATOR_ID_, OPERATOR_NAME_) == null) {// 如果没有ORGN_SET，新增一个。并计算其PARENT_ORGN_SET_ID_
                String PARENT_ORGN_SET_ID_ = null;
                if (orgnSet.get("PARENT_ORGN_SET_ID_") != null) {
                    if (omOrgnSetService.loadOrgnSet((String) orgnSet.get("PARENT_ORGN_SET_ID_"), OPERATOR_ID_, OPERATOR_NAME_) != null) {
                        PARENT_ORGN_SET_ID_ = (String) orgnSet.get("PARENT_ORGN_SET_ID_");
                    }
                }
                sql = "insert into OM_ORGN_SET (ORGN_SET_ID_, PARENT_ORGN_SET_ID_, ORGN_SET_CODE_, ORGN_SET_NAME_, ALLOW_SYNC_, MEMO_, ORDER_, ORGN_SET_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                omJdbcTemplate.update(sql, ORGN_SET_ID_, PARENT_ORGN_SET_ID_, orgnSet.get("ORGN_SET_CODE_"), orgnSet.get("ORGN_SET_NAME_"), orgnSet.get("ALLOW_SYNC_"), orgnSet.get("MEMO_"), orgnSet.get("ORDER_"), orgnSet.get("ORGN_SET_STATUS_"), orgnSet.get("CREATION_DATE_"), orgnSet.get("UPDATE_DATE_"), orgnSet.get("OPERATOR_ID_"), orgnSet.get("OPERATOR_NAME_"));
            }

            final List<Map<String, Object>> orgList = mainServerJdbcTemplate.queryForList("select * from OM_ORG where ORGN_SET_ID_ = ?", ORGN_SET_ID_);
            sql = "insert into OM_ORG (ORGN_SET_ID_, ORG_ID_, PARENT_ORG_ID_, ORG_CODE_, ORG_NAME_, ORG_ABBR_NAME_, ORG_TYPE_, ORG_CATEGORY_, MEMO_, ORG_TAG_, ORG_EXT_ATTR_1_, ORG_EXT_ATTR_2_, ORG_EXT_ATTR_3_, ORG_EXT_ATTR_4_, ORG_EXT_ATTR_5_, ORG_EXT_ATTR_6_, ORG_EXT_ATTR_7_, ORG_EXT_ATTR_8_, ORDER_, ORG_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            batch = new BatchPreparedStatementSetter() {
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Map<String, Object> org = orgList.get(i);
                    ps.setObject(1, org.get("ORGN_SET_ID_"));
                    ps.setObject(2, org.get("ORG_ID_"));
                    ps.setObject(3, org.get("PARENT_ORG_ID_"));
                    ps.setObject(4, org.get("ORG_CODE_"));
                    ps.setObject(5, org.get("ORG_NAME_"));
                    ps.setObject(6, org.get("ORG_ABBR_NAME_"));
                    ps.setObject(7, org.get("ORG_TYPE_"));
                    ps.setObject(8, org.get("ORG_CATEGORY_"));
                    ps.setObject(9, org.get("MEMO_"));
                    ps.setObject(10, org.get("ORG_TAG_"));
                    ps.setObject(11, org.get("ORG_EXT_ATTR_1_"));
                    ps.setObject(12, org.get("ORG_EXT_ATTR_2_"));
                    ps.setObject(13, org.get("ORG_EXT_ATTR_3_"));
                    ps.setObject(14, org.get("ORG_EXT_ATTR_4_"));
                    ps.setObject(15, org.get("ORG_EXT_ATTR_5_"));
                    ps.setObject(16, org.get("ORG_EXT_ATTR_6_"));
                    ps.setObject(17, org.get("ORG_EXT_ATTR_7_"));
                    ps.setObject(18, org.get("ORG_EXT_ATTR_8_"));
                    ps.setObject(19, org.get("ORDER_"));
                    ps.setObject(20, org.get("ORG_STATUS_"));
                    ps.setObject(21, org.get("CREATION_DATE_"));
                    ps.setObject(22, org.get("UPDATE_DATE_"));
                    ps.setObject(23, org.get("OPERATOR_ID_"));
                    ps.setObject(24, org.get("OPERATOR_NAME_"));
                }

                public int getBatchSize() {
                    return orgList.size();
                }
            };
            omJdbcTemplate.batchUpdate(sql, batch);

            final List<Map<String, Object>> dutyList = mainServerJdbcTemplate.queryForList("select * from OM_DUTY where ORGN_SET_ID_ = ?", ORGN_SET_ID_);
            sql = "insert into OM_DUTY (ORGN_SET_ID_, DUTY_ID_, DUTY_CODE_, DUTY_NAME_, DUTY_CATEGORY_, MEMO_, DUTY_TAG_, DUTY_EXT_ATTR_1_, DUTY_EXT_ATTR_2_, DUTY_EXT_ATTR_3_, DUTY_EXT_ATTR_4_, DUTY_EXT_ATTR_5_, DUTY_EXT_ATTR_6_, DUTY_EXT_ATTR_7_, DUTY_EXT_ATTR_8_, ORDER_, DUTY_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            batch = new BatchPreparedStatementSetter() {
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Map<String, Object> duty = dutyList.get(i);
                    ps.setObject(1, duty.get("ORGN_SET_ID_"));
                    ps.setObject(2, duty.get("DUTY_ID_"));
                    ps.setObject(3, duty.get("DUTY_CODE_"));
                    ps.setObject(4, duty.get("DUTY_NAME_"));
                    ps.setObject(5, duty.get("DUTY_CATEGORY_"));
                    ps.setObject(6, duty.get("MEMO_"));
                    ps.setObject(7, duty.get("DUTY_TAG_"));
                    ps.setObject(8, duty.get("DUTY_EXT_ATTR_1_"));
                    ps.setObject(9, duty.get("DUTY_EXT_ATTR_2_"));
                    ps.setObject(10, duty.get("DUTY_EXT_ATTR_3_"));
                    ps.setObject(11, duty.get("DUTY_EXT_ATTR_4_"));
                    ps.setObject(12, duty.get("DUTY_EXT_ATTR_5_"));
                    ps.setObject(13, duty.get("DUTY_EXT_ATTR_6_"));
                    ps.setObject(14, duty.get("DUTY_EXT_ATTR_7_"));
                    ps.setObject(15, duty.get("DUTY_EXT_ATTR_8_"));
                    ps.setObject(16, duty.get("ORDER_"));
                    ps.setObject(17, duty.get("DUTY_STATUS_"));
                    ps.setObject(18, duty.get("CREATION_DATE_"));
                    ps.setObject(19, duty.get("UPDATE_DATE_"));
                    ps.setObject(20, duty.get("OPERATOR_ID_"));
                    ps.setObject(21, duty.get("OPERATOR_NAME_"));
                }

                public int getBatchSize() {
                    return dutyList.size();
                }
            };
            omJdbcTemplate.batchUpdate(sql, batch);

            final List<Map<String, Object>> posiList = mainServerJdbcTemplate.queryForList("select * from OM_POSI where ORGN_SET_ID_ = ?", ORGN_SET_ID_);
            sql = "insert into OM_POSI (ORGN_SET_ID_, POSI_ID_, ORG_ID_, DUTY_ID_, POSI_CODE_, POSI_NAME_, ORG_LEADER_TYPE_, POSI_CATEGORY_, MEMO_, POSI_TAG_, POSI_EXT_ATTR_1_, POSI_EXT_ATTR_2_, POSI_EXT_ATTR_3_, POSI_EXT_ATTR_4_, POSI_EXT_ATTR_5_, POSI_EXT_ATTR_6_, POSI_EXT_ATTR_7_, POSI_EXT_ATTR_8_, ORDER_, POSI_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            batch = new BatchPreparedStatementSetter() {
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Map<String, Object> posi = posiList.get(i);
                    ps.setObject(1, posi.get("ORGN_SET_ID_"));
                    ps.setObject(2, posi.get("POSI_ID_"));
                    ps.setObject(3, posi.get("ORG_ID_"));
                    ps.setObject(4, posi.get("DUTY_ID_"));
                    ps.setObject(5, posi.get("POSI_CODE_"));
                    ps.setObject(6, posi.get("POSI_NAME_"));
                    ps.setObject(7, posi.get("ORG_LEADER_TYPE_"));
                    ps.setObject(8, posi.get("POSI_CATEGORY_"));
                    ps.setObject(9, posi.get("MEMO_"));
                    ps.setObject(10, posi.get("POSI_TAG_"));
                    ps.setObject(11, posi.get("POSI_EXT_ATTR_1_"));
                    ps.setObject(12, posi.get("POSI_EXT_ATTR_2_"));
                    ps.setObject(13, posi.get("POSI_EXT_ATTR_3_"));
                    ps.setObject(14, posi.get("POSI_EXT_ATTR_4_"));
                    ps.setObject(15, posi.get("POSI_EXT_ATTR_5_"));
                    ps.setObject(16, posi.get("POSI_EXT_ATTR_6_"));
                    ps.setObject(17, posi.get("POSI_EXT_ATTR_7_"));
                    ps.setObject(18, posi.get("POSI_EXT_ATTR_8_"));
                    ps.setObject(19, posi.get("ORDER_"));
                    ps.setObject(20, posi.get("POSI_STATUS_"));
                    ps.setObject(21, posi.get("CREATION_DATE_"));
                    ps.setObject(22, posi.get("UPDATE_DATE_"));
                    ps.setObject(23, posi.get("OPERATOR_ID_"));
                    ps.setObject(24, posi.get("OPERATOR_NAME_"));
                }

                public int getBatchSize() {
                    return posiList.size();
                }
            };
            omJdbcTemplate.batchUpdate(sql, batch);

            final List<Map<String, Object>> empList = mainServerJdbcTemplate.queryForList("select * from OM_EMP where ORGN_SET_ID_ = ?", ORGN_SET_ID_);
            sql = "insert into OM_EMP (ORGN_SET_ID_, EMP_ID_, ORG_ID_, EMP_CODE_, EMP_NAME_, PASSWORD_, PASSWORD_RESET_REQ_, PARTY_, EMP_LEVEL_, GENDER_, BIRTH_DATE_, TEL_, EMAIL_, IN_DATE_, OUT_DATE_, EMP_CATEGORY_, MEMO_, EMP_TAG_, EMP_EXT_ATTR_1_, EMP_EXT_ATTR_2_, EMP_EXT_ATTR_3_, EMP_EXT_ATTR_4_, EMP_EXT_ATTR_5_, EMP_EXT_ATTR_6_, EMP_EXT_ATTR_7_, EMP_EXT_ATTR_8_, ORDER_, EMP_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            batch = new BatchPreparedStatementSetter() {
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Map<String, Object> emp = empList.get(i);
                    ps.setObject(1, emp.get("ORGN_SET_ID_"));
                    ps.setObject(2, emp.get("EMP_ID_"));
                    ps.setObject(3, emp.get("ORG_ID_"));
                    ps.setObject(4, emp.get("EMP_CODE_"));
                    ps.setObject(5, emp.get("EMP_NAME_"));
                    ps.setObject(6, emp.get("PASSWORD_"));
                    ps.setObject(7, emp.get("PASSWORD_RESET_REQ_"));
                    ps.setObject(8, emp.get("PARTY_"));
                    ps.setObject(9, emp.get("EMP_LEVEL_"));
                    ps.setObject(10, emp.get("GENDER_"));
                    ps.setObject(11, emp.get("BIRTH_DATE_"));
                    ps.setObject(12, emp.get("TEL_"));
                    ps.setObject(13, emp.get("EMAIL_"));
                    ps.setObject(14, emp.get("IN_DATE_"));
                    ps.setObject(15, emp.get("OUT_DATE_"));
                    ps.setObject(16, emp.get("EMP_CATEGORY_"));
                    ps.setObject(17, emp.get("MEMO_"));
                    ps.setObject(18, emp.get("EMP_TAG_"));
                    ps.setObject(19, emp.get("EMP_EXT_ATTR_1_"));
                    ps.setObject(20, emp.get("EMP_EXT_ATTR_2_"));
                    ps.setObject(21, emp.get("EMP_EXT_ATTR_3_"));
                    ps.setObject(22, emp.get("EMP_EXT_ATTR_4_"));
                    ps.setObject(23, emp.get("EMP_EXT_ATTR_5_"));
                    ps.setObject(24, emp.get("EMP_EXT_ATTR_6_"));
                    ps.setObject(25, emp.get("EMP_EXT_ATTR_7_"));
                    ps.setObject(26, emp.get("EMP_EXT_ATTR_8_"));
                    ps.setObject(27, emp.get("ORDER_"));
                    ps.setObject(28, emp.get("EMP_STATUS_"));
                    ps.setObject(29, emp.get("CREATION_DATE_"));
                    ps.setObject(30, emp.get("UPDATE_DATE_"));
                    ps.setObject(31, emp.get("OPERATOR_ID_"));
                    ps.setObject(32, emp.get("OPERATOR_NAME_"));
                }

                public int getBatchSize() {
                    return empList.size();
                }
            };
            omJdbcTemplate.batchUpdate(sql, batch);

            final List<Map<String, Object>> posiEmpList = mainServerJdbcTemplate.queryForList("select * from OM_POSI_EMP where ORGN_SET_ID_ = ?", ORGN_SET_ID_);
            sql = "insert into OM_POSI_EMP (ORGN_SET_ID_, POSI_EMP_ID_, POSI_ID_, EMP_ID_, MAIN_, POSI_EMP_CATEGORY_, MEMO_, POSI_EMP_TAG_, POSI_EMP_EXT_ATTR_1_, POSI_EMP_EXT_ATTR_2_, POSI_EMP_EXT_ATTR_3_, POSI_EMP_EXT_ATTR_4_, POSI_EMP_EXT_ATTR_5_, POSI_EMP_EXT_ATTR_6_, POSI_EMP_EXT_ATTR_7_, POSI_EMP_EXT_ATTR_8_, ORDER_, POSI_EMP_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            batch = new BatchPreparedStatementSetter() {
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Map<String, Object> posiEmp = posiEmpList.get(i);
                    ps.setObject(1, posiEmp.get("ORGN_SET_ID_"));
                    ps.setObject(2, posiEmp.get("POSI_EMP_ID_"));
                    ps.setObject(3, posiEmp.get("POSI_ID_"));
                    ps.setObject(4, posiEmp.get("EMP_ID_"));
                    ps.setObject(5, posiEmp.get("MAIN_"));
                    ps.setObject(6, posiEmp.get("POSI_EMP_CATEGORY_"));
                    ps.setObject(7, posiEmp.get("MEMO_"));
                    ps.setObject(8, posiEmp.get("POSI_EMP_TAG_"));
                    ps.setObject(9, posiEmp.get("POSI_EMP_EXT_ATTR_1_"));
                    ps.setObject(10, posiEmp.get("POSI_EMP_EXT_ATTR_2_"));
                    ps.setObject(11, posiEmp.get("POSI_EMP_EXT_ATTR_3_"));
                    ps.setObject(12, posiEmp.get("POSI_EMP_EXT_ATTR_4_"));
                    ps.setObject(13, posiEmp.get("POSI_EMP_EXT_ATTR_5_"));
                    ps.setObject(14, posiEmp.get("POSI_EMP_EXT_ATTR_6_"));
                    ps.setObject(15, posiEmp.get("POSI_EMP_EXT_ATTR_7_"));
                    ps.setObject(16, posiEmp.get("POSI_EMP_EXT_ATTR_8_"));
                    ps.setObject(17, posiEmp.get("ORDER_"));
                    ps.setObject(18, posiEmp.get("POSI_EMP_STATUS_"));
                    ps.setObject(19, posiEmp.get("CREATION_DATE_"));
                    ps.setObject(20, posiEmp.get("UPDATE_DATE_"));
                    ps.setObject(21, posiEmp.get("OPERATOR_ID_"));
                    ps.setObject(22, posiEmp.get("OPERATOR_NAME_"));
                }

                public int getBatchSize() {
                    return posiEmpList.size();
                }
            };
            omJdbcTemplate.batchUpdate(sql, batch);

            final List<Map<String, Object>> empRelationList = mainServerJdbcTemplate.queryForList("select * from OM_EMP_RELATION where ORGN_SET_ID_ = ?", ORGN_SET_ID_);
            sql = "insert into OM_EMP_RELATION (ORGN_SET_ID_, EMP_RELATION_ID_, UPPER_EMP_ID_, LOWER_EMP_ID_, EMP_RELATION_, EMP_RELATION_CATEGORY_, MEMO_, EMP_RELATION_TAG_, EMP_RELATION_EXT_ATTR_1_, EMP_RELATION_EXT_ATTR_2_, EMP_RELATION_EXT_ATTR_3_, EMP_RELATION_EXT_ATTR_4_, EMP_RELATION_EXT_ATTR_5_, EMP_RELATION_EXT_ATTR_6_, EMP_RELATION_EXT_ATTR_7_, EMP_RELATION_EXT_ATTR_8_, ORDER_, EMP_RELATION_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            batch = new BatchPreparedStatementSetter() {
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Map<String, Object> empRelation = empRelationList.get(i);
                    ps.setObject(1, empRelation.get("ORGN_SET_ID_"));
                    ps.setObject(2, empRelation.get("EMP_RELATION_ID_"));
                    ps.setObject(3, empRelation.get("UPPER_EMP_ID_"));
                    ps.setObject(4, empRelation.get("LOWER_EMP_ID_"));
                    ps.setObject(5, empRelation.get("EMP_RELATION_"));
                    ps.setObject(6, empRelation.get("EMP_RELATION_CATEGORY_"));
                    ps.setObject(7, empRelation.get("MEMO_"));
                    ps.setObject(8, empRelation.get("EMP_RELATION_TAG_"));
                    ps.setObject(9, empRelation.get("EMP_RELATION_EXT_ATTR_1_"));
                    ps.setObject(10, empRelation.get("EMP_RELATION_EXT_ATTR_2_"));
                    ps.setObject(11, empRelation.get("EMP_RELATION_EXT_ATTR_3_"));
                    ps.setObject(12, empRelation.get("EMP_RELATION_EXT_ATTR_4_"));
                    ps.setObject(13, empRelation.get("EMP_RELATION_EXT_ATTR_5_"));
                    ps.setObject(14, empRelation.get("EMP_RELATION_EXT_ATTR_6_"));
                    ps.setObject(15, empRelation.get("EMP_RELATION_EXT_ATTR_7_"));
                    ps.setObject(16, empRelation.get("EMP_RELATION_EXT_ATTR_8_"));
                    ps.setObject(17, empRelation.get("ORDER_"));
                    ps.setObject(18, empRelation.get("EMP_RELATION_STATUS_"));
                    ps.setObject(19, empRelation.get("CREATION_DATE_"));
                    ps.setObject(20, empRelation.get("UPDATE_DATE_"));
                    ps.setObject(21, empRelation.get("OPERATOR_ID_"));
                    ps.setObject(22, empRelation.get("OPERATOR_NAME_"));
                }

                public int getBatchSize() {
                    return empRelationList.size();
                }
            };
            omJdbcTemplate.batchUpdate(sql, batch);

            final List<Map<String, Object>> tagList = mainServerJdbcTemplate.queryForList("select * from OM_TAG where ORGN_SET_ID_ = ?", ORGN_SET_ID_);
            sql = "insert into OM_TAG (ORGN_SET_ID_, TAG_ID_, OBJ_ID_, OBJ_TYPE_, TAG_) values (?, ?, ?, ?, ?)";
            batch = new BatchPreparedStatementSetter() {
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Map<String, Object> tag = tagList.get(i);
                    ps.setObject(1, tag.get("ORGN_SET_ID_"));
                    ps.setObject(2, tag.get("TAG_ID_"));
                    ps.setObject(3, tag.get("OBJ_ID_"));
                    ps.setObject(4, tag.get("OBJ_TYPE_"));
                    ps.setObject(5, tag.get("TAG_"));
                }

                public int getBatchSize() {
                    return tagList.size();
                }
            };
            omJdbcTemplate.batchUpdate(sql, batch);

            transactionManager.commit(transactionStatus);

            omJdbcTemplate.execute("alter table OM_ORG enable constraint FK_OM_ORG_PARENT");
        }
        catch (Exception e) {
            transactionManager.rollback(transactionStatus);
            throw new RuntimeException(e);
        }

        return 1;
    }

    @Override
    public OrgnChange pullCompareMainServerOrgnSet(String ORGN_SET_ID_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OrgnChange orgnChange = new OrgnChange();

        JdbcTemplate mainServerJdbcTemplate = new JdbcTemplate(getMainServerDataSource());
        String sql;

        sql = "select * from OM_ORG where ORGN_SET_ID_ = ?";
        List<Map<String, Object>> insertOrgList = new ArrayList<>();
        List<Map<String, Object>> updateOrgList = new ArrayList<>();
        List<Map<String, Object>> deleteOrgList = new ArrayList<>();
        List<Map<String, Object>> orgList = mainServerJdbcTemplate.queryForList(sql, ORGN_SET_ID_);
        List<Map<String, Object>> mirrorServerOrgList = omJdbcTemplate.queryForList(sql, ORGN_SET_ID_);
        List<String> orgIdList = OdUtils.collect(orgList, "ORG_ID_", String.class);
        List<String> mirrorServerOrgIdList = OdUtils.collect(mirrorServerOrgList, "ORG_ID_", String.class);
        Map<String, Object> org;
        Map<String, Object> mirrorServerOrg;
        for (int i = 0; i < orgIdList.size(); i++) {
            if (!mirrorServerOrgIdList.contains(orgIdList.get(i))) {
                insertOrgList.add(orgList.get(i));
            }
            else {
                org = orgList.get(i);
                mirrorServerOrg = mirrorServerOrgList.get(mirrorServerOrgIdList.indexOf(orgIdList.get(i)));
                if ((org.get("ORG_ID_") == null && mirrorServerOrg.get("ORG_ID_") != null) || (org.get("ORG_ID_") != null && !org.get("ORG_ID_").equals(mirrorServerOrg.get("ORG_ID_"))) || (org.get("ORGN_SET_ID_") == null && mirrorServerOrg.get("ORGN_SET_ID_") != null) || (org.get("ORGN_SET_ID_") != null && !org.get("ORGN_SET_ID_").equals(mirrorServerOrg.get("ORGN_SET_ID_"))) || (org.get("PARENT_ORG_ID_") == null && mirrorServerOrg.get("PARENT_ORG_ID_") != null) || (org.get("PARENT_ORG_ID_") != null && !org.get("PARENT_ORG_ID_").equals(mirrorServerOrg.get("PARENT_ORG_ID_"))) || (org.get("ORG_CODE_") == null && mirrorServerOrg.get("ORG_CODE_") != null) || (org.get("ORG_CODE_") != null && !org.get("ORG_CODE_").equals(mirrorServerOrg.get("ORG_CODE_")))
                        || (org.get("ORG_NAME_") == null && mirrorServerOrg.get("ORG_NAME_") != null) || (org.get("ORG_NAME_") != null && !org.get("ORG_NAME_").equals(mirrorServerOrg.get("ORG_NAME_"))) || (org.get("ORG_ABBR_NAME_") == null && mirrorServerOrg.get("ORG_ABBR_NAME_") != null) || (org.get("ORG_ABBR_NAME_") != null && !org.get("ORG_ABBR_NAME_").equals(mirrorServerOrg.get("ORG_ABBR_NAME_"))) || (org.get("ORG_TYPE_") == null && mirrorServerOrg.get("ORG_TYPE_") != null) || (org.get("ORG_TYPE_") != null && !org.get("ORG_TYPE_").equals(mirrorServerOrg.get("ORG_TYPE_"))) || (org.get("ORG_CATEGORY_") == null && mirrorServerOrg.get("ORG_CATEGORY_") != null) || (org.get("ORG_CATEGORY_") != null && !org.get("ORG_CATEGORY_").equals(mirrorServerOrg.get("ORG_CATEGORY_")))
                        || (org.get("MEMO_") == null && mirrorServerOrg.get("MEMO_") != null) || (org.get("MEMO_") != null && !org.get("MEMO_").equals(mirrorServerOrg.get("MEMO_"))) || (org.get("ORG_TAG_") == null && mirrorServerOrg.get("ORG_TAG_") != null) || (org.get("ORG_TAG_") != null && !org.get("ORG_TAG_").equals(mirrorServerOrg.get("ORG_TAG_"))) || (org.get("ORG_EXT_ATTR_1_") == null && mirrorServerOrg.get("ORG_EXT_ATTR_1_") != null) || (org.get("ORG_EXT_ATTR_1_") != null && !org.get("ORG_EXT_ATTR_1_").equals(mirrorServerOrg.get("ORG_EXT_ATTR_1_"))) || (org.get("ORG_EXT_ATTR_2_") == null && mirrorServerOrg.get("ORG_EXT_ATTR_2_") != null) || (org.get("ORG_EXT_ATTR_2_") != null && !org.get("ORG_EXT_ATTR_2_").equals(mirrorServerOrg.get("ORG_EXT_ATTR_2_")))
                        || (org.get("ORG_EXT_ATTR_3_") == null && mirrorServerOrg.get("ORG_EXT_ATTR_3_") != null) || (org.get("ORG_EXT_ATTR_3_") != null && !org.get("ORG_EXT_ATTR_3_").equals(mirrorServerOrg.get("ORG_EXT_ATTR_3_"))) || (org.get("ORG_EXT_ATTR_4_") == null && mirrorServerOrg.get("ORG_EXT_ATTR_4_") != null) || (org.get("ORG_EXT_ATTR_4_") != null && !org.get("ORG_EXT_ATTR_4_").equals(mirrorServerOrg.get("ORG_EXT_ATTR_4_"))) || (org.get("ORG_EXT_ATTR_5_") == null && mirrorServerOrg.get("ORG_EXT_ATTR_5_") != null) || (org.get("ORG_EXT_ATTR_5_") != null && !org.get("ORG_EXT_ATTR_5_").equals(mirrorServerOrg.get("ORG_EXT_ATTR_5_"))) || (org.get("ORG_EXT_ATTR_6_") == null && mirrorServerOrg.get("ORG_EXT_ATTR_6_") != null)
                        || (org.get("ORG_EXT_ATTR_6_") != null && !org.get("ORG_EXT_ATTR_6_").equals(mirrorServerOrg.get("ORG_EXT_ATTR_6_"))) || (org.get("ORG_EXT_ATTR_7_") == null && mirrorServerOrg.get("ORG_EXT_ATTR_7_") != null) || (org.get("ORG_EXT_ATTR_7_") != null && !org.get("ORG_EXT_ATTR_7_").equals(mirrorServerOrg.get("ORG_EXT_ATTR_7_"))) || (org.get("ORG_EXT_ATTR_8_") == null && mirrorServerOrg.get("ORG_EXT_ATTR_8_") != null) || (org.get("ORG_EXT_ATTR_8_") != null && !org.get("ORG_EXT_ATTR_8_").equals(mirrorServerOrg.get("ORG_EXT_ATTR_8_"))) || (org.get("ORDER_") == null && mirrorServerOrg.get("ORDER_") != null) || (org.get("ORDER_") != null && !org.get("ORDER_").equals(mirrorServerOrg.get("ORDER_")))
                        || (org.get("ORG_STATUS_") == null && mirrorServerOrg.get("ORG_STATUS_") != null) || (org.get("ORG_STATUS_") != null && !org.get("ORG_STATUS_").equals(mirrorServerOrg.get("ORG_STATUS_"))) || (org.get("CREATION_DATE_") == null && mirrorServerOrg.get("CREATION_DATE_") != null) || (org.get("CREATION_DATE_") != null && !org.get("CREATION_DATE_").equals(mirrorServerOrg.get("CREATION_DATE_"))) || (org.get("UPDATE_DATE_") == null && mirrorServerOrg.get("UPDATE_DATE_") != null) || (org.get("UPDATE_DATE_") != null && !org.get("UPDATE_DATE_").equals(mirrorServerOrg.get("UPDATE_DATE_"))) || (org.get("OPERATOR_ID_") == null && mirrorServerOrg.get("OPERATOR_ID_") != null) || (org.get("OPERATOR_ID_") != null && !org.get("OPERATOR_ID_").equals(mirrorServerOrg.get("OPERATOR_ID_")))
                        || (org.get("OPERATOR_NAME_") == null && mirrorServerOrg.get("OPERATOR_NAME_") != null) || (org.get("OPERATOR_NAME_") != null && !org.get("OPERATOR_NAME_").equals(mirrorServerOrg.get("OPERATOR_NAME_")))) {
                    updateOrgList.add(orgList.get(i));
                }
            }
        }
        for (int i = 0; i < mirrorServerOrgIdList.size(); i++) {
            if (!orgIdList.contains(mirrorServerOrgIdList.get(i))) {
                deleteOrgList.add(mirrorServerOrgList.get(i));
            }
        }
        orgnChange.setInsertOrgList(insertOrgList);
        orgnChange.setUpdateOrgList(updateOrgList);
        orgnChange.setDeleteOrgList(deleteOrgList);

        sql = "select * from OM_DUTY where ORGN_SET_ID_ = ?";
        List<Map<String, Object>> insertDutyList = new ArrayList<>();
        List<Map<String, Object>> updateDutyList = new ArrayList<>();
        List<Map<String, Object>> deleteDutyList = new ArrayList<>();
        List<Map<String, Object>> dutyList = mainServerJdbcTemplate.queryForList(sql, ORGN_SET_ID_);
        List<Map<String, Object>> mirrorServerDutyList = omJdbcTemplate.queryForList(sql, ORGN_SET_ID_);
        List<String> dutyIdList = OdUtils.collect(dutyList, "DUTY_ID_", String.class);
        List<String> mirrorServerDutyIdList = OdUtils.collect(mirrorServerDutyList, "DUTY_ID_", String.class);
        Map<String, Object> duty;
        Map<String, Object> mirrorServerDuty;
        for (int i = 0; i < dutyIdList.size(); i++) {
            if (!mirrorServerDutyIdList.contains(dutyIdList.get(i))) {
                insertDutyList.add(dutyList.get(i));
            }
            else {
                duty = dutyList.get(i);
                mirrorServerDuty = mirrorServerDutyList.get(mirrorServerDutyIdList.indexOf(dutyIdList.get(i)));
                if ((duty.get("DUTY_ID_") == null && mirrorServerDuty.get("DUTY_ID_") != null) || (duty.get("DUTY_ID_") != null && !duty.get("DUTY_ID_").equals(mirrorServerDuty.get("DUTY_ID_"))) || (duty.get("ORGN_SET_ID_") == null && mirrorServerDuty.get("ORGN_SET_ID_") != null) || (duty.get("ORGN_SET_ID_") != null && !duty.get("ORGN_SET_ID_").equals(mirrorServerDuty.get("ORGN_SET_ID_"))) || (duty.get("DUTY_CODE_") == null && mirrorServerDuty.get("DUTY_CODE_") != null) || (duty.get("DUTY_CODE_") != null && !duty.get("DUTY_CODE_").equals(mirrorServerDuty.get("DUTY_CODE_"))) || (duty.get("DUTY_NAME_") == null && mirrorServerDuty.get("DUTY_NAME_") != null) || (duty.get("DUTY_NAME_") != null && !duty.get("DUTY_NAME_").equals(mirrorServerDuty.get("DUTY_NAME_")))
                        || (duty.get("DUTY_CATEGORY_") == null && mirrorServerDuty.get("DUTY_CATEGORY_") != null) || (duty.get("DUTY_CATEGORY_") != null && !duty.get("DUTY_CATEGORY_").equals(mirrorServerDuty.get("DUTY_CATEGORY_"))) || (duty.get("MEMO_") == null && mirrorServerDuty.get("MEMO_") != null) || (duty.get("MEMO_") != null && !duty.get("MEMO_").equals(mirrorServerDuty.get("MEMO_"))) || (duty.get("DUTY_TAG_") == null && mirrorServerDuty.get("DUTY_TAG_") != null) || (duty.get("DUTY_TAG_") != null && !duty.get("DUTY_TAG_").equals(mirrorServerDuty.get("DUTY_TAG_"))) || (duty.get("DUTY_EXT_ATTR_1_") == null && mirrorServerDuty.get("DUTY_EXT_ATTR_1_") != null) || (duty.get("DUTY_EXT_ATTR_1_") != null && !duty.get("DUTY_EXT_ATTR_1_").equals(mirrorServerDuty.get("DUTY_EXT_ATTR_1_")))
                        || (duty.get("DUTY_EXT_ATTR_2_") == null && mirrorServerDuty.get("DUTY_EXT_ATTR_2_") != null) || (duty.get("DUTY_EXT_ATTR_2_") != null && !duty.get("DUTY_EXT_ATTR_2_").equals(mirrorServerDuty.get("DUTY_EXT_ATTR_2_"))) || (duty.get("DUTY_EXT_ATTR_3_") == null && mirrorServerDuty.get("DUTY_EXT_ATTR_3_") != null) || (duty.get("DUTY_EXT_ATTR_3_") != null && !duty.get("DUTY_EXT_ATTR_3_").equals(mirrorServerDuty.get("DUTY_EXT_ATTR_3_"))) || (duty.get("DUTY_EXT_ATTR_4_") == null && mirrorServerDuty.get("DUTY_EXT_ATTR_4_") != null) || (duty.get("DUTY_EXT_ATTR_4_") != null && !duty.get("DUTY_EXT_ATTR_4_").equals(mirrorServerDuty.get("DUTY_EXT_ATTR_4_"))) || (duty.get("DUTY_EXT_ATTR_5_") == null && mirrorServerDuty.get("DUTY_EXT_ATTR_5_") != null)
                        || (duty.get("DUTY_EXT_ATTR_5_") != null && !duty.get("DUTY_EXT_ATTR_5_").equals(mirrorServerDuty.get("DUTY_EXT_ATTR_5_"))) || (duty.get("DUTY_EXT_ATTR_6_") == null && mirrorServerDuty.get("DUTY_EXT_ATTR_6_") != null) || (duty.get("DUTY_EXT_ATTR_6_") != null && !duty.get("DUTY_EXT_ATTR_6_").equals(mirrorServerDuty.get("DUTY_EXT_ATTR_6_"))) || (duty.get("DUTY_EXT_ATTR_7_") == null && mirrorServerDuty.get("DUTY_EXT_ATTR_7_") != null) || (duty.get("DUTY_EXT_ATTR_7_") != null && !duty.get("DUTY_EXT_ATTR_7_").equals(mirrorServerDuty.get("DUTY_EXT_ATTR_7_"))) || (duty.get("DUTY_EXT_ATTR_8_") == null && mirrorServerDuty.get("DUTY_EXT_ATTR_8_") != null)
                        || (duty.get("DUTY_EXT_ATTR_8_") != null && !duty.get("DUTY_EXT_ATTR_8_").equals(mirrorServerDuty.get("DUTY_EXT_ATTR_8_"))) || (duty.get("ORDER_") == null && mirrorServerDuty.get("ORDER_") != null) || (duty.get("ORDER_") != null && !duty.get("ORDER_").equals(mirrorServerDuty.get("ORDER_"))) || (duty.get("DUTY_STATUS_") == null && mirrorServerDuty.get("DUTY_STATUS_") != null) || (duty.get("DUTY_STATUS_") != null && !duty.get("DUTY_STATUS_").equals(mirrorServerDuty.get("DUTY_STATUS_"))) || (duty.get("CREATION_DATE_") == null && mirrorServerDuty.get("CREATION_DATE_") != null) || (duty.get("CREATION_DATE_") != null && !duty.get("CREATION_DATE_").equals(mirrorServerDuty.get("CREATION_DATE_")))
                        || (duty.get("UPDATE_DATE_") == null && mirrorServerDuty.get("UPDATE_DATE_") != null) || (duty.get("UPDATE_DATE_") != null && !duty.get("UPDATE_DATE_").equals(mirrorServerDuty.get("UPDATE_DATE_"))) || (duty.get("OPERATOR_ID_") == null && mirrorServerDuty.get("OPERATOR_ID_") != null) || (duty.get("OPERATOR_ID_") != null && !duty.get("OPERATOR_ID_").equals(mirrorServerDuty.get("OPERATOR_ID_"))) || (duty.get("OPERATOR_NAME_") == null && mirrorServerDuty.get("OPERATOR_NAME_") != null) || (duty.get("OPERATOR_NAME_") != null && !duty.get("OPERATOR_NAME_").equals(mirrorServerDuty.get("OPERATOR_NAME_")))) {
                    updateDutyList.add(dutyList.get(i));
                }
            }
        }
        for (int i = 0; i < mirrorServerDutyIdList.size(); i++) {
            if (!dutyIdList.contains(mirrorServerDutyIdList.get(i))) {
                deleteDutyList.add(mirrorServerDutyList.get(i));
            }
        }
        orgnChange.setInsertDutyList(insertDutyList);
        orgnChange.setUpdateDutyList(updateDutyList);
        orgnChange.setDeleteDutyList(deleteDutyList);

        sql = "select * from OM_POSI where ORGN_SET_ID_ = ?";
        List<Map<String, Object>> insertPosiList = new ArrayList<>();
        List<Map<String, Object>> updatePosiList = new ArrayList<>();
        List<Map<String, Object>> deletePosiList = new ArrayList<>();
        List<Map<String, Object>> posiList = mainServerJdbcTemplate.queryForList(sql, ORGN_SET_ID_);
        List<Map<String, Object>> mirrorServerPosiList = omJdbcTemplate.queryForList(sql, ORGN_SET_ID_);
        List<String> posiIdList = OdUtils.collect(posiList, "POSI_ID_", String.class);
        List<String> mirrorServerPosiIdList = OdUtils.collect(mirrorServerPosiList, "POSI_ID_", String.class);
        Map<String, Object> posi;
        Map<String, Object> mirrorServerPosi;
        for (int i = 0; i < posiIdList.size(); i++) {
            if (!mirrorServerPosiIdList.contains(posiIdList.get(i))) {
                insertPosiList.add(posiList.get(i));
            }
            else {
                posi = posiList.get(i);
                mirrorServerPosi = mirrorServerPosiList.get(mirrorServerPosiIdList.indexOf(posiIdList.get(i)));
                if ((posi.get("POSI_ID_") == null && mirrorServerPosi.get("POSI_ID_") != null) || (posi.get("POSI_ID_") != null && !posi.get("POSI_ID_").equals(mirrorServerPosi.get("POSI_ID_"))) || (posi.get("ORGN_SET_ID_") == null && mirrorServerPosi.get("ORGN_SET_ID_") != null) || (posi.get("ORGN_SET_ID_") != null && !posi.get("ORGN_SET_ID_").equals(mirrorServerPosi.get("ORGN_SET_ID_"))) || (posi.get("ORG_ID_") == null && mirrorServerPosi.get("ORG_ID_") != null) || (posi.get("ORG_ID_") != null && !posi.get("ORG_ID_").equals(mirrorServerPosi.get("ORG_ID_"))) || (posi.get("DUTY_ID_") == null && mirrorServerPosi.get("DUTY_ID_") != null) || (posi.get("DUTY_ID_") != null && !posi.get("DUTY_ID_").equals(mirrorServerPosi.get("DUTY_ID_")))
                        || (posi.get("POSI_CODE_") == null && mirrorServerPosi.get("POSI_CODE_") != null) || (posi.get("POSI_CODE_") != null && !posi.get("POSI_CODE_").equals(mirrorServerPosi.get("POSI_CODE_"))) || (posi.get("POSI_NAME_") == null && mirrorServerPosi.get("POSI_NAME_") != null) || (posi.get("POSI_NAME_") != null && !posi.get("POSI_NAME_").equals(mirrorServerPosi.get("POSI_NAME_"))) || (posi.get("ORG_LEADER_TYPE_") == null && mirrorServerPosi.get("ORG_LEADER_TYPE_") != null) || (posi.get("ORG_LEADER_TYPE_") != null && !posi.get("ORG_LEADER_TYPE_").equals(mirrorServerPosi.get("ORG_LEADER_TYPE_"))) || (posi.get("POSI_CATEGORY_") == null && mirrorServerPosi.get("POSI_CATEGORY_") != null)
                        || (posi.get("POSI_CATEGORY_") != null && !posi.get("POSI_CATEGORY_").equals(mirrorServerPosi.get("POSI_CATEGORY_"))) || (posi.get("MEMO_") == null && mirrorServerPosi.get("MEMO_") != null) || (posi.get("MEMO_") != null && !posi.get("MEMO_").equals(mirrorServerPosi.get("MEMO_"))) || (posi.get("POSI_TAG_") == null && mirrorServerPosi.get("POSI_TAG_") != null) || (posi.get("POSI_TAG_") != null && !posi.get("POSI_TAG_").equals(mirrorServerPosi.get("POSI_TAG_"))) || (posi.get("POSI_EXT_ATTR_1_") == null && mirrorServerPosi.get("POSI_EXT_ATTR_1_") != null) || (posi.get("POSI_EXT_ATTR_1_") != null && !posi.get("POSI_EXT_ATTR_1_").equals(mirrorServerPosi.get("POSI_EXT_ATTR_1_"))) || (posi.get("POSI_EXT_ATTR_2_") == null && mirrorServerPosi.get("POSI_EXT_ATTR_2_") != null)
                        || (posi.get("POSI_EXT_ATTR_2_") != null && !posi.get("POSI_EXT_ATTR_2_").equals(mirrorServerPosi.get("POSI_EXT_ATTR_2_"))) || (posi.get("POSI_EXT_ATTR_3_") == null && mirrorServerPosi.get("POSI_EXT_ATTR_3_") != null) || (posi.get("POSI_EXT_ATTR_3_") != null && !posi.get("POSI_EXT_ATTR_3_").equals(mirrorServerPosi.get("POSI_EXT_ATTR_3_"))) || (posi.get("POSI_EXT_ATTR_4_") == null && mirrorServerPosi.get("POSI_EXT_ATTR_4_") != null) || (posi.get("POSI_EXT_ATTR_4_") != null && !posi.get("POSI_EXT_ATTR_4_").equals(mirrorServerPosi.get("POSI_EXT_ATTR_4_"))) || (posi.get("POSI_EXT_ATTR_5_") == null && mirrorServerPosi.get("POSI_EXT_ATTR_5_") != null)
                        || (posi.get("POSI_EXT_ATTR_5_") != null && !posi.get("POSI_EXT_ATTR_5_").equals(mirrorServerPosi.get("POSI_EXT_ATTR_5_"))) || (posi.get("POSI_EXT_ATTR_6_") == null && mirrorServerPosi.get("POSI_EXT_ATTR_6_") != null) || (posi.get("POSI_EXT_ATTR_6_") != null && !posi.get("POSI_EXT_ATTR_6_").equals(mirrorServerPosi.get("POSI_EXT_ATTR_6_"))) || (posi.get("POSI_EXT_ATTR_7_") == null && mirrorServerPosi.get("POSI_EXT_ATTR_7_") != null) || (posi.get("POSI_EXT_ATTR_7_") != null && !posi.get("POSI_EXT_ATTR_7_").equals(mirrorServerPosi.get("POSI_EXT_ATTR_7_"))) || (posi.get("POSI_EXT_ATTR_8_") == null && mirrorServerPosi.get("POSI_EXT_ATTR_8_") != null)
                        || (posi.get("POSI_EXT_ATTR_8_") != null && !posi.get("POSI_EXT_ATTR_8_").equals(mirrorServerPosi.get("POSI_EXT_ATTR_8_"))) || (posi.get("ORDER_") == null && mirrorServerPosi.get("ORDER_") != null) || (posi.get("ORDER_") != null && !posi.get("ORDER_").equals(mirrorServerPosi.get("ORDER_"))) || (posi.get("POSI_STATUS_") == null && mirrorServerPosi.get("POSI_STATUS_") != null) || (posi.get("POSI_STATUS_") != null && !posi.get("POSI_STATUS_").equals(mirrorServerPosi.get("POSI_STATUS_"))) || (posi.get("CREATION_DATE_") == null && mirrorServerPosi.get("CREATION_DATE_") != null) || (posi.get("CREATION_DATE_") != null && !posi.get("CREATION_DATE_").equals(mirrorServerPosi.get("CREATION_DATE_")))
                        || (posi.get("UPDATE_DATE_") == null && mirrorServerPosi.get("UPDATE_DATE_") != null) || (posi.get("UPDATE_DATE_") != null && !posi.get("UPDATE_DATE_").equals(mirrorServerPosi.get("UPDATE_DATE_"))) || (posi.get("OPERATOR_ID_") == null && mirrorServerPosi.get("OPERATOR_ID_") != null) || (posi.get("OPERATOR_ID_") != null && !posi.get("OPERATOR_ID_").equals(mirrorServerPosi.get("OPERATOR_ID_"))) || (posi.get("OPERATOR_NAME_") == null && mirrorServerPosi.get("OPERATOR_NAME_") != null) || (posi.get("OPERATOR_NAME_") != null && !posi.get("OPERATOR_NAME_").equals(mirrorServerPosi.get("OPERATOR_NAME_")))) {
                    updatePosiList.add(posiList.get(i));
                }
            }
        }
        for (int i = 0; i < mirrorServerPosiIdList.size(); i++) {
            if (!posiIdList.contains(mirrorServerPosiIdList.get(i))) {
                deletePosiList.add(mirrorServerPosiList.get(i));
            }
        }
        orgnChange.setInsertPosiList(insertPosiList);
        orgnChange.setUpdatePosiList(updatePosiList);
        orgnChange.setDeletePosiList(deletePosiList);

        sql = "select * from OM_EMP where ORGN_SET_ID_ = ?";
        List<Map<String, Object>> insertEmpList = new ArrayList<>();
        List<Map<String, Object>> updateEmpList = new ArrayList<>();
        List<Map<String, Object>> deleteEmpList = new ArrayList<>();
        List<Map<String, Object>> empList = mainServerJdbcTemplate.queryForList(sql, ORGN_SET_ID_);
        List<Map<String, Object>> mirrorServerEmpList = omJdbcTemplate.queryForList(sql, ORGN_SET_ID_);
        List<String> empIdList = OdUtils.collect(empList, "EMP_ID_", String.class);
        List<String> mirrorServerEmpIdList = OdUtils.collect(mirrorServerEmpList, "EMP_ID_", String.class);
        Map<String, Object> emp;
        Map<String, Object> mirrorServerEmp;
        for (int i = 0; i < empIdList.size(); i++) {
            if (!mirrorServerEmpIdList.contains(empIdList.get(i))) {
                insertEmpList.add(empList.get(i));
            }
            else {
                emp = empList.get(i);
                mirrorServerEmp = mirrorServerEmpList.get(mirrorServerEmpIdList.indexOf(empIdList.get(i)));
                if ((emp.get("EMP_ID_") == null && mirrorServerEmp.get("EMP_ID_") != null) || (emp.get("EMP_ID_") != null && !emp.get("EMP_ID_").equals(mirrorServerEmp.get("EMP_ID_"))) || (emp.get("ORGN_SET_ID_") == null && mirrorServerEmp.get("ORGN_SET_ID_") != null) || (emp.get("ORGN_SET_ID_") != null && !emp.get("ORGN_SET_ID_").equals(mirrorServerEmp.get("ORGN_SET_ID_"))) || (emp.get("ORG_ID_") == null && mirrorServerEmp.get("ORG_ID_") != null) || (emp.get("ORG_ID_") != null && !emp.get("ORG_ID_").equals(mirrorServerEmp.get("ORG_ID_"))) || (emp.get("EMP_CODE_") == null && mirrorServerEmp.get("EMP_CODE_") != null) || (emp.get("EMP_CODE_") != null && !emp.get("EMP_CODE_").equals(mirrorServerEmp.get("EMP_CODE_")))
                        || (emp.get("EMP_NAME_") == null && mirrorServerEmp.get("EMP_NAME_") != null) || (emp.get("EMP_NAME_") != null && !emp.get("EMP_NAME_").equals(mirrorServerEmp.get("EMP_NAME_"))) || (emp.get("PASSWORD_") == null && mirrorServerEmp.get("PASSWORD_") != null) || (emp.get("PASSWORD_") != null && !emp.get("PASSWORD_").equals(mirrorServerEmp.get("PASSWORD_"))) || (emp.get("PASSWORD_RESET_REQ_") == null && mirrorServerEmp.get("PASSWORD_RESET_REQ_") != null) || (emp.get("PASSWORD_RESET_REQ_") != null && !emp.get("PASSWORD_RESET_REQ_").equals(mirrorServerEmp.get("PASSWORD_RESET_REQ_"))) || (emp.get("PARTY_") == null && mirrorServerEmp.get("PARTY_") != null) || (emp.get("PARTY_") != null && !emp.get("PARTY_").equals(mirrorServerEmp.get("PARTY_")))
                        || (emp.get("EMP_LEVEL_") == null && mirrorServerEmp.get("EMP_LEVEL_") != null) || (emp.get("EMP_LEVEL_") != null && !emp.get("EMP_LEVEL_").equals(mirrorServerEmp.get("EMP_LEVEL_"))) || (emp.get("GENDER_") == null && mirrorServerEmp.get("GENDER_") != null) || (emp.get("GENDER_") != null && !emp.get("GENDER_").equals(mirrorServerEmp.get("GENDER_"))) || (emp.get("BIRTH_DATE_") == null && mirrorServerEmp.get("BIRTH_DATE_") != null) || (emp.get("BIRTH_DATE_") != null && !emp.get("BIRTH_DATE_").equals(mirrorServerEmp.get("BIRTH_DATE_"))) || (emp.get("TEL_") == null && mirrorServerEmp.get("TEL_") != null) || (emp.get("TEL_") != null && !emp.get("TEL_").equals(mirrorServerEmp.get("TEL_"))) || (emp.get("EMAIL_") == null && mirrorServerEmp.get("EMAIL_") != null)
                        || (emp.get("EMAIL_") != null && !emp.get("EMAIL_").equals(mirrorServerEmp.get("EMAIL_"))) || (emp.get("IN_DATE_") == null && mirrorServerEmp.get("IN_DATE_") != null) || (emp.get("IN_DATE_") != null && !emp.get("IN_DATE_").equals(mirrorServerEmp.get("IN_DATE_"))) || (emp.get("OUT_DATE_") == null && mirrorServerEmp.get("OUT_DATE_") != null) || (emp.get("OUT_DATE_") != null && !emp.get("OUT_DATE_").equals(mirrorServerEmp.get("OUT_DATE_"))) || (emp.get("EMP_CATEGORY_") == null && mirrorServerEmp.get("EMP_CATEGORY_") != null) || (emp.get("EMP_CATEGORY_") != null && !emp.get("EMP_CATEGORY_").equals(mirrorServerEmp.get("EMP_CATEGORY_"))) || (emp.get("MEMO_") == null && mirrorServerEmp.get("MEMO_") != null)
                        || (emp.get("MEMO_") != null && !emp.get("MEMO_").equals(mirrorServerEmp.get("MEMO_"))) || (emp.get("EMP_TAG_") == null && mirrorServerEmp.get("EMP_TAG_") != null) || (emp.get("EMP_TAG_") != null && !emp.get("EMP_TAG_").equals(mirrorServerEmp.get("EMP_TAG_"))) || (emp.get("EMP_EXT_ATTR_1_") == null && mirrorServerEmp.get("EMP_EXT_ATTR_1_") != null) || (emp.get("EMP_EXT_ATTR_1_") != null && !emp.get("EMP_EXT_ATTR_1_").equals(mirrorServerEmp.get("EMP_EXT_ATTR_1_"))) || (emp.get("EMP_EXT_ATTR_2_") == null && mirrorServerEmp.get("EMP_EXT_ATTR_2_") != null) || (emp.get("EMP_EXT_ATTR_2_") != null && !emp.get("EMP_EXT_ATTR_2_").equals(mirrorServerEmp.get("EMP_EXT_ATTR_2_"))) || (emp.get("EMP_EXT_ATTR_3_") == null && mirrorServerEmp.get("EMP_EXT_ATTR_3_") != null)
                        || (emp.get("EMP_EXT_ATTR_3_") != null && !emp.get("EMP_EXT_ATTR_3_").equals(mirrorServerEmp.get("EMP_EXT_ATTR_3_"))) || (emp.get("EMP_EXT_ATTR_4_") == null && mirrorServerEmp.get("EMP_EXT_ATTR_4_") != null) || (emp.get("EMP_EXT_ATTR_4_") != null && !emp.get("EMP_EXT_ATTR_4_").equals(mirrorServerEmp.get("EMP_EXT_ATTR_4_"))) || (emp.get("EMP_EXT_ATTR_5_") == null && mirrorServerEmp.get("EMP_EXT_ATTR_5_") != null) || (emp.get("EMP_EXT_ATTR_5_") != null && !emp.get("EMP_EXT_ATTR_5_").equals(mirrorServerEmp.get("EMP_EXT_ATTR_5_"))) || (emp.get("EMP_EXT_ATTR_6_") == null && mirrorServerEmp.get("EMP_EXT_ATTR_6_") != null) || (emp.get("EMP_EXT_ATTR_6_") != null && !emp.get("EMP_EXT_ATTR_6_").equals(mirrorServerEmp.get("EMP_EXT_ATTR_6_")))
                        || (emp.get("EMP_EXT_ATTR_7_") == null && mirrorServerEmp.get("EMP_EXT_ATTR_7_") != null) || (emp.get("EMP_EXT_ATTR_7_") != null && !emp.get("EMP_EXT_ATTR_7_").equals(mirrorServerEmp.get("EMP_EXT_ATTR_7_"))) || (emp.get("EMP_EXT_ATTR_8_") == null && mirrorServerEmp.get("EMP_EXT_ATTR_8_") != null) || (emp.get("EMP_EXT_ATTR_8_") != null && !emp.get("EMP_EXT_ATTR_8_").equals(mirrorServerEmp.get("EMP_EXT_ATTR_8_"))) || (emp.get("ORDER_") == null && mirrorServerEmp.get("ORDER_") != null) || (emp.get("ORDER_") != null && !emp.get("ORDER_").equals(mirrorServerEmp.get("ORDER_"))) || (emp.get("EMP_STATUS_") == null && mirrorServerEmp.get("EMP_STATUS_") != null) || (emp.get("EMP_STATUS_") != null && !emp.get("EMP_STATUS_").equals(mirrorServerEmp.get("EMP_STATUS_")))
                        || (emp.get("CREATION_DATE_") == null && mirrorServerEmp.get("CREATION_DATE_") != null) || (emp.get("CREATION_DATE_") != null && !emp.get("CREATION_DATE_").equals(mirrorServerEmp.get("CREATION_DATE_"))) || (emp.get("UPDATE_DATE_") == null && mirrorServerEmp.get("UPDATE_DATE_") != null) || (emp.get("UPDATE_DATE_") != null && !emp.get("UPDATE_DATE_").equals(mirrorServerEmp.get("UPDATE_DATE_"))) || (emp.get("OPERATOR_ID_") == null && mirrorServerEmp.get("OPERATOR_ID_") != null) || (emp.get("OPERATOR_ID_") != null && !emp.get("OPERATOR_ID_").equals(mirrorServerEmp.get("OPERATOR_ID_"))) || (emp.get("OPERATOR_NAME_") == null && mirrorServerEmp.get("OPERATOR_NAME_") != null)
                        || (emp.get("OPERATOR_NAME_") != null && !emp.get("OPERATOR_NAME_").equals(mirrorServerEmp.get("OPERATOR_NAME_")))) {
                    updateEmpList.add(empList.get(i));
                }
            }
        }
        for (int i = 0; i < mirrorServerEmpIdList.size(); i++) {
            if (!empIdList.contains(mirrorServerEmpIdList.get(i))) {
                deleteEmpList.add(mirrorServerEmpList.get(i));
            }
        }
        orgnChange.setInsertEmpList(insertEmpList);
        orgnChange.setUpdateEmpList(updateEmpList);
        orgnChange.setDeleteEmpList(deleteEmpList);

        sql = "select PE.*, E.EMP_NAME_, P.POSI_NAME_ from OM_POSI_EMP PE inner join OM_EMP E on E.ORGN_SET_ID_ = PE.ORGN_SET_ID_ and E.EMP_ID_ = PE.EMP_ID_ inner join OM_POSI P on P.ORGN_SET_ID_ = PE.ORGN_SET_ID_ and P.POSI_ID_ = PE.POSI_ID_ where PE.ORGN_SET_ID_ = ?";
        List<Map<String, Object>> insertPosiEmpList = new ArrayList<>();
        List<Map<String, Object>> updatePosiEmpList = new ArrayList<>();
        List<Map<String, Object>> deletePosiEmpList = new ArrayList<>();
        List<Map<String, Object>> posiEmpList = mainServerJdbcTemplate.queryForList(sql, ORGN_SET_ID_);
        List<Map<String, Object>> mirrorServerPosiEmpList = omJdbcTemplate.queryForList(sql, ORGN_SET_ID_);
        List<String> posiEmpIdList = OdUtils.collect(posiEmpList, "POSI_EMP_ID_", String.class);
        List<String> mirrorServerPosiEmpIdList = OdUtils.collect(mirrorServerPosiEmpList, "POSI_EMP_ID_", String.class);
        Map<String, Object> posiEmp;
        Map<String, Object> mirrorServerPosiEmp;
        for (int i = 0; i < posiEmpIdList.size(); i++) {
            if (!mirrorServerPosiEmpIdList.contains(posiEmpIdList.get(i))) {
                insertPosiEmpList.add(posiEmpList.get(i));
            }
            else {
                posiEmp = posiEmpList.get(i);
                mirrorServerPosiEmp = mirrorServerPosiEmpList.get(mirrorServerPosiEmpIdList.indexOf(posiEmpIdList.get(i)));
                if ((posiEmp.get("POSI_EMP_ID_") == null && mirrorServerPosiEmp.get("POSI_EMP_ID_") != null) || (posiEmp.get("POSI_EMP_ID_") != null && !posiEmp.get("POSI_EMP_ID_").equals(mirrorServerPosiEmp.get("POSI_EMP_ID_"))) || (posiEmp.get("ORGN_SET_ID_") == null && mirrorServerPosiEmp.get("ORGN_SET_ID_") != null) || (posiEmp.get("ORGN_SET_ID_") != null && !posiEmp.get("ORGN_SET_ID_").equals(mirrorServerPosiEmp.get("ORGN_SET_ID_"))) || (posiEmp.get("POSI_ID_") == null && mirrorServerPosiEmp.get("POSI_ID_") != null) || (posiEmp.get("POSI_ID_") != null && !posiEmp.get("POSI_ID_").equals(mirrorServerPosiEmp.get("POSI_ID_"))) || (posiEmp.get("EMP_ID_") == null && mirrorServerPosiEmp.get("EMP_ID_") != null)
                        || (posiEmp.get("EMP_ID_") != null && !posiEmp.get("EMP_ID_").equals(mirrorServerPosiEmp.get("EMP_ID_"))) || (posiEmp.get("MAIN_") == null && mirrorServerPosiEmp.get("MAIN_") != null) || (posiEmp.get("MAIN_") != null && !posiEmp.get("MAIN_").equals(mirrorServerPosiEmp.get("MAIN_"))) || (posiEmp.get("POSI_EMP_CATEGORY_") == null && mirrorServerPosiEmp.get("POSI_EMP_CATEGORY_") != null) || (posiEmp.get("POSI_EMP_CATEGORY_") != null && !posiEmp.get("POSI_EMP_CATEGORY_").equals(mirrorServerPosiEmp.get("POSI_EMP_CATEGORY_"))) || (posiEmp.get("MEMO_") == null && mirrorServerPosiEmp.get("MEMO_") != null) || (posiEmp.get("MEMO_") != null && !posiEmp.get("MEMO_").equals(mirrorServerPosiEmp.get("MEMO_")))
                        || (posiEmp.get("POSI_EMP_TAG_") == null && mirrorServerPosiEmp.get("POSI_EMP_TAG_") != null) || (posiEmp.get("POSI_EMP_TAG_") != null && !posiEmp.get("POSI_EMP_TAG_").equals(mirrorServerPosiEmp.get("POSI_EMP_TAG_"))) || (posiEmp.get("POSI_EMP_EXT_ATTR_1_") == null && mirrorServerPosiEmp.get("POSI_EMP_EXT_ATTR_1_") != null) || (posiEmp.get("POSI_EMP_EXT_ATTR_1_") != null && !posiEmp.get("POSI_EMP_EXT_ATTR_1_").equals(mirrorServerPosiEmp.get("POSI_EMP_EXT_ATTR_1_"))) || (posiEmp.get("POSI_EMP_EXT_ATTR_2_") == null && mirrorServerPosiEmp.get("POSI_EMP_EXT_ATTR_2_") != null) || (posiEmp.get("POSI_EMP_EXT_ATTR_2_") != null && !posiEmp.get("POSI_EMP_EXT_ATTR_2_").equals(mirrorServerPosiEmp.get("POSI_EMP_EXT_ATTR_2_")))
                        || (posiEmp.get("POSI_EMP_EXT_ATTR_3_") == null && mirrorServerPosiEmp.get("POSI_EMP_EXT_ATTR_3_") != null) || (posiEmp.get("POSI_EMP_EXT_ATTR_3_") != null && !posiEmp.get("POSI_EMP_EXT_ATTR_3_").equals(mirrorServerPosiEmp.get("POSI_EMP_EXT_ATTR_3_"))) || (posiEmp.get("POSI_EMP_EXT_ATTR_4_") == null && mirrorServerPosiEmp.get("POSI_EMP_EXT_ATTR_4_") != null) || (posiEmp.get("POSI_EMP_EXT_ATTR_4_") != null && !posiEmp.get("POSI_EMP_EXT_ATTR_4_").equals(mirrorServerPosiEmp.get("POSI_EMP_EXT_ATTR_4_"))) || (posiEmp.get("POSI_EMP_EXT_ATTR_5_") == null && mirrorServerPosiEmp.get("POSI_EMP_EXT_ATTR_5_") != null) || (posiEmp.get("POSI_EMP_EXT_ATTR_5_") != null && !posiEmp.get("POSI_EMP_EXT_ATTR_5_").equals(mirrorServerPosiEmp.get("POSI_EMP_EXT_ATTR_5_")))
                        || (posiEmp.get("POSI_EMP_EXT_ATTR_6_") == null && mirrorServerPosiEmp.get("POSI_EMP_EXT_ATTR_6_") != null) || (posiEmp.get("POSI_EMP_EXT_ATTR_6_") != null && !posiEmp.get("POSI_EMP_EXT_ATTR_6_").equals(mirrorServerPosiEmp.get("POSI_EMP_EXT_ATTR_6_"))) || (posiEmp.get("POSI_EMP_EXT_ATTR_7_") == null && mirrorServerPosiEmp.get("POSI_EMP_EXT_ATTR_7_") != null) || (posiEmp.get("POSI_EMP_EXT_ATTR_7_") != null && !posiEmp.get("POSI_EMP_EXT_ATTR_7_").equals(mirrorServerPosiEmp.get("POSI_EMP_EXT_ATTR_7_"))) || (posiEmp.get("POSI_EMP_EXT_ATTR_8_") == null && mirrorServerPosiEmp.get("POSI_EMP_EXT_ATTR_8_") != null) || (posiEmp.get("POSI_EMP_EXT_ATTR_8_") != null && !posiEmp.get("POSI_EMP_EXT_ATTR_8_").equals(mirrorServerPosiEmp.get("POSI_EMP_EXT_ATTR_8_")))
                        || (posiEmp.get("ORDER_") == null && mirrorServerPosiEmp.get("ORDER_") != null) || (posiEmp.get("ORDER_") != null && !posiEmp.get("ORDER_").equals(mirrorServerPosiEmp.get("ORDER_"))) || (posiEmp.get("POSI_EMP_STATUS_") == null && mirrorServerPosiEmp.get("POSI_EMP_STATUS_") != null) || (posiEmp.get("POSI_EMP_STATUS_") != null && !posiEmp.get("POSI_EMP_STATUS_").equals(mirrorServerPosiEmp.get("POSI_EMP_STATUS_"))) || (posiEmp.get("CREATION_DATE_") == null && mirrorServerPosiEmp.get("CREATION_DATE_") != null) || (posiEmp.get("CREATION_DATE_") != null && !posiEmp.get("CREATION_DATE_").equals(mirrorServerPosiEmp.get("CREATION_DATE_"))) || (posiEmp.get("UPDATE_DATE_") == null && mirrorServerPosiEmp.get("UPDATE_DATE_") != null)
                        || (posiEmp.get("UPDATE_DATE_") != null && !posiEmp.get("UPDATE_DATE_").equals(mirrorServerPosiEmp.get("UPDATE_DATE_"))) || (posiEmp.get("OPERATOR_ID_") == null && mirrorServerPosiEmp.get("OPERATOR_ID_") != null) || (posiEmp.get("OPERATOR_ID_") != null && !posiEmp.get("OPERATOR_ID_").equals(mirrorServerPosiEmp.get("OPERATOR_ID_"))) || (posiEmp.get("OPERATOR_NAME_") == null && mirrorServerPosiEmp.get("OPERATOR_NAME_") != null) || (posiEmp.get("OPERATOR_NAME_") != null && !posiEmp.get("OPERATOR_NAME_").equals(mirrorServerPosiEmp.get("OPERATOR_NAME_")))) {
                    updatePosiEmpList.add(posiEmpList.get(i));
                }
            }
        }
        for (int i = 0; i < mirrorServerPosiEmpIdList.size(); i++) {
            if (!posiEmpIdList.contains(mirrorServerPosiEmpIdList.get(i))) {
                deletePosiEmpList.add(mirrorServerPosiEmpList.get(i));
            }
        }
        orgnChange.setInsertPosiEmpList(insertPosiEmpList);
        orgnChange.setUpdatePosiEmpList(updatePosiEmpList);
        orgnChange.setDeletePosiEmpList(deletePosiEmpList);

        sql = "select ER.*, E1.EMP_NAME_ as UPPER_EMP_NAME_, E2.EMP_NAME_ as LOWER_EMP_NAME_ from OM_EMP_RELATION ER inner join OM_EMP E1 on E1.ORGN_SET_ID_ = ER.ORGN_SET_ID_ and E1.EMP_ID_ = ER.UPPER_EMP_ID_ inner join OM_EMP E2 on E2.ORGN_SET_ID_ = ER.ORGN_SET_ID_ and E2.EMP_ID_ = ER.LOWER_EMP_ID_ where ER.ORGN_SET_ID_ = ?";
        List<Map<String, Object>> insertEmpRelationList = new ArrayList<>();
        List<Map<String, Object>> updateEmpRelationList = new ArrayList<>();
        List<Map<String, Object>> deleteEmpRelationList = new ArrayList<>();
        List<Map<String, Object>> empRelationList = mainServerJdbcTemplate.queryForList(sql, ORGN_SET_ID_);
        List<Map<String, Object>> mirrorServerEmpRelationList = omJdbcTemplate.queryForList(sql, ORGN_SET_ID_);
        List<String> empRelationIdList = OdUtils.collect(empRelationList, "EMP_RELATION_ID_", String.class);
        List<String> mirrorServerEmpRelationIdList = OdUtils.collect(mirrorServerEmpRelationList, "EMP_RELATION_ID_", String.class);
        Map<String, Object> empRelation;
        Map<String, Object> mirrorServerEmpRelation;
        for (int i = 0; i < empRelationIdList.size(); i++) {
            if (!mirrorServerEmpRelationIdList.contains(empRelationIdList.get(i))) {
                insertEmpRelationList.add(empRelationList.get(i));
            }
            else {
                empRelation = empRelationList.get(i);
                mirrorServerEmpRelation = mirrorServerEmpRelationList.get(mirrorServerEmpRelationIdList.indexOf(empRelationIdList.get(i)));
                if ((empRelation.get("EMP_RELATION_ID_") == null && mirrorServerEmpRelation.get("EMP_RELATION_ID_") != null) || (empRelation.get("EMP_RELATION_ID_") != null && !empRelation.get("EMP_RELATION_ID_").equals(mirrorServerEmpRelation.get("EMP_RELATION_ID_"))) || (empRelation.get("ORGN_SET_ID_") == null && mirrorServerEmpRelation.get("ORGN_SET_ID_") != null) || (empRelation.get("ORGN_SET_ID_") != null && !empRelation.get("ORGN_SET_ID_").equals(mirrorServerEmpRelation.get("ORGN_SET_ID_"))) || (empRelation.get("UPPER_EMP_ID_") == null && mirrorServerEmpRelation.get("UPPER_EMP_ID_") != null) || (empRelation.get("UPPER_EMP_ID_") != null && !empRelation.get("UPPER_EMP_ID_").equals(mirrorServerEmpRelation.get("UPPER_EMP_ID_")))
                        || (empRelation.get("LOWER_EMP_ID_") == null && mirrorServerEmpRelation.get("LOWER_EMP_ID_") != null) || (empRelation.get("LOWER_EMP_ID_") != null && !empRelation.get("LOWER_EMP_ID_").equals(mirrorServerEmpRelation.get("LOWER_EMP_ID_"))) || (empRelation.get("EMP_RELATION_") == null && mirrorServerEmpRelation.get("EMP_RELATION_") != null) || (empRelation.get("EMP_RELATION_") != null && !empRelation.get("EMP_RELATION_").equals(mirrorServerEmpRelation.get("EMP_RELATION_"))) || (empRelation.get("EMP_RELATION_CATEGORY_") == null && mirrorServerEmpRelation.get("EMP_RELATION_CATEGORY_") != null) || (empRelation.get("EMP_RELATION_CATEGORY_") != null && !empRelation.get("EMP_RELATION_CATEGORY_").equals(mirrorServerEmpRelation.get("EMP_RELATION_CATEGORY_")))
                        || (empRelation.get("MEMO_") == null && mirrorServerEmpRelation.get("MEMO_") != null) || (empRelation.get("MEMO_") != null && !empRelation.get("MEMO_").equals(mirrorServerEmpRelation.get("MEMO_"))) || (empRelation.get("EMP_RELATION_TAG_") == null && mirrorServerEmpRelation.get("EMP_RELATION_TAG_") != null) || (empRelation.get("EMP_RELATION_TAG_") != null && !empRelation.get("EMP_RELATION_TAG_").equals(mirrorServerEmpRelation.get("EMP_RELATION_TAG_"))) || (empRelation.get("EMP_RELATION_EXT_ATTR_1_") == null && mirrorServerEmpRelation.get("EMP_RELATION_EXT_ATTR_1_") != null) || (empRelation.get("EMP_RELATION_EXT_ATTR_1_") != null && !empRelation.get("EMP_RELATION_EXT_ATTR_1_").equals(mirrorServerEmpRelation.get("EMP_RELATION_EXT_ATTR_1_")))
                        || (empRelation.get("EMP_RELATION_EXT_ATTR_2_") == null && mirrorServerEmpRelation.get("EMP_RELATION_EXT_ATTR_2_") != null) || (empRelation.get("EMP_RELATION_EXT_ATTR_2_") != null && !empRelation.get("EMP_RELATION_EXT_ATTR_2_").equals(mirrorServerEmpRelation.get("EMP_RELATION_EXT_ATTR_2_"))) || (empRelation.get("EMP_RELATION_EXT_ATTR_3_") == null && mirrorServerEmpRelation.get("EMP_RELATION_EXT_ATTR_3_") != null) || (empRelation.get("EMP_RELATION_EXT_ATTR_3_") != null && !empRelation.get("EMP_RELATION_EXT_ATTR_3_").equals(mirrorServerEmpRelation.get("EMP_RELATION_EXT_ATTR_3_"))) || (empRelation.get("EMP_RELATION_EXT_ATTR_4_") == null && mirrorServerEmpRelation.get("EMP_RELATION_EXT_ATTR_4_") != null)
                        || (empRelation.get("EMP_RELATION_EXT_ATTR_4_") != null && !empRelation.get("EMP_RELATION_EXT_ATTR_4_").equals(mirrorServerEmpRelation.get("EMP_RELATION_EXT_ATTR_4_"))) || (empRelation.get("EMP_RELATION_EXT_ATTR_5_") == null && mirrorServerEmpRelation.get("EMP_RELATION_EXT_ATTR_5_") != null) || (empRelation.get("EMP_RELATION_EXT_ATTR_5_") != null && !empRelation.get("EMP_RELATION_EXT_ATTR_5_").equals(mirrorServerEmpRelation.get("EMP_RELATION_EXT_ATTR_5_"))) || (empRelation.get("EMP_RELATION_EXT_ATTR_6_") == null && mirrorServerEmpRelation.get("EMP_RELATION_EXT_ATTR_6_") != null) || (empRelation.get("EMP_RELATION_EXT_ATTR_6_") != null && !empRelation.get("EMP_RELATION_EXT_ATTR_6_").equals(mirrorServerEmpRelation.get("EMP_RELATION_EXT_ATTR_6_")))
                        || (empRelation.get("EMP_RELATION_EXT_ATTR_7_") == null && mirrorServerEmpRelation.get("EMP_RELATION_EXT_ATTR_7_") != null) || (empRelation.get("EMP_RELATION_EXT_ATTR_7_") != null && !empRelation.get("EMP_RELATION_EXT_ATTR_7_").equals(mirrorServerEmpRelation.get("EMP_RELATION_EXT_ATTR_7_"))) || (empRelation.get("EMP_RELATION_EXT_ATTR_8_") == null && mirrorServerEmpRelation.get("EMP_RELATION_EXT_ATTR_8_") != null) || (empRelation.get("EMP_RELATION_EXT_ATTR_8_") != null && !empRelation.get("EMP_RELATION_EXT_ATTR_8_").equals(mirrorServerEmpRelation.get("EMP_RELATION_EXT_ATTR_8_"))) || (empRelation.get("ORDER_") == null && mirrorServerEmpRelation.get("ORDER_") != null)
                        || (empRelation.get("ORDER_") != null && !empRelation.get("ORDER_").equals(mirrorServerEmpRelation.get("ORDER_"))) || (empRelation.get("EMP_RELATION_STATUS_") == null && mirrorServerEmpRelation.get("EMP_RELATION_STATUS_") != null) || (empRelation.get("EMP_RELATION_STATUS_") != null && !empRelation.get("EMP_RELATION_STATUS_").equals(mirrorServerEmpRelation.get("EMP_RELATION_STATUS_"))) || (empRelation.get("CREATION_DATE_") == null && mirrorServerEmpRelation.get("CREATION_DATE_") != null) || (empRelation.get("CREATION_DATE_") != null && !empRelation.get("CREATION_DATE_").equals(mirrorServerEmpRelation.get("CREATION_DATE_"))) || (empRelation.get("UPDATE_DATE_") == null && mirrorServerEmpRelation.get("UPDATE_DATE_") != null)
                        || (empRelation.get("UPDATE_DATE_") != null && !empRelation.get("UPDATE_DATE_").equals(mirrorServerEmpRelation.get("UPDATE_DATE_"))) || (empRelation.get("OPERATOR_ID_") == null && mirrorServerEmpRelation.get("OPERATOR_ID_") != null) || (empRelation.get("OPERATOR_ID_") != null && !empRelation.get("OPERATOR_ID_").equals(mirrorServerEmpRelation.get("OPERATOR_ID_"))) || (empRelation.get("OPERATOR_NAME_") == null && mirrorServerEmpRelation.get("OPERATOR_NAME_") != null) || (empRelation.get("OPERATOR_NAME_") != null && !empRelation.get("OPERATOR_NAME_").equals(mirrorServerEmpRelation.get("OPERATOR_NAME_")))) {
                    updateEmpRelationList.add(empRelationList.get(i));
                }
            }
        }
        for (int i = 0; i < mirrorServerEmpRelationIdList.size(); i++) {
            if (!empRelationIdList.contains(mirrorServerEmpRelationIdList.get(i))) {
                deleteEmpRelationList.add(mirrorServerEmpRelationList.get(i));
            }
        }
        orgnChange.setInsertEmpRelationList(insertEmpRelationList);
        orgnChange.setUpdateEmpRelationList(updateEmpRelationList);
        orgnChange.setDeleteEmpRelationList(deleteEmpRelationList);

        return orgnChange;
    }

    @Override
    public int pullReplaceMainServerOrgnSet(final String ORGN_SET_ID_, List<String> INSERT_ORG_ID_LIST, List<String> UPDATE_ORG_ID_LIST, List<String> DELETE_ORG_ID_LIST, List<String> INSERT_DUTY_ID_LIST, List<String> UPDATE_DUTY_ID_LIST, List<String> DELETE_DUTY_ID_LIST, List<String> INSERT_POSI_ID_LIST, List<String> UPDATE_POSI_ID_LIST, List<String> DELETE_POSI_ID_LIST, List<String> INSERT_EMP_ID_LIST, List<String> UPDATE_EMP_ID_LIST, List<String> DELETE_EMP_ID_LIST, List<String> INSERT_POSI_EMP_ID_LIST, List<String> UPDATE_POSI_EMP_ID_LIST, List<String> DELETE_POSI_EMP_ID_LIST, List<String> INSERT_EMP_RELATION_ID_LIST, List<String> UPDATE_EMP_RELATION_ID_LIST, List<String> DELETE_EMP_RELATION_ID_LIST, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        DataSource mainServerDataSource = getMainServerDataSource();
        JdbcTemplate mainServerJdbcTemplate = new JdbcTemplate(mainServerDataSource);

        String sql;
        BatchPreparedStatementSetter batch;
        NamedParameterJdbcTemplate namedParameterMirrorServerJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        NamedParameterJdbcTemplate namedParameterMainServerJdbcTemplate = new NamedParameterJdbcTemplate(mainServerJdbcTemplate);
        Map<String, Object> paramMap = new HashMap<>();

        omJdbcTemplate.execute("alter table OM_ORG disable constraint FK_OM_ORG_PARENT");

        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(mainServerDataSource);
        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            // 删除TAG
            int cycle;
            int startIndex;
            int endIndex;
            List<String> OBJ_ID_LIST = new ArrayList<>();
            if (UPDATE_ORG_ID_LIST != null) {
                OBJ_ID_LIST.addAll(UPDATE_ORG_ID_LIST);
            }
            if (UPDATE_DUTY_ID_LIST != null) {
                OBJ_ID_LIST.addAll(UPDATE_DUTY_ID_LIST);
            }
            if (UPDATE_POSI_ID_LIST != null) {
                OBJ_ID_LIST.addAll(UPDATE_POSI_ID_LIST);
            }
            if (UPDATE_EMP_ID_LIST != null) {
                OBJ_ID_LIST.addAll(UPDATE_EMP_ID_LIST);
            }
            if (UPDATE_POSI_EMP_ID_LIST != null) {
                OBJ_ID_LIST.addAll(UPDATE_POSI_EMP_ID_LIST);
            }
            if (UPDATE_EMP_RELATION_ID_LIST != null) {
                OBJ_ID_LIST.addAll(UPDATE_EMP_RELATION_ID_LIST);
            }
            if (DELETE_ORG_ID_LIST != null) {
                OBJ_ID_LIST.addAll(DELETE_ORG_ID_LIST);
            }
            if (DELETE_DUTY_ID_LIST != null) {
                OBJ_ID_LIST.addAll(DELETE_DUTY_ID_LIST);
            }
            if (DELETE_POSI_ID_LIST != null) {
                OBJ_ID_LIST.addAll(DELETE_POSI_ID_LIST);
            }
            if (DELETE_EMP_ID_LIST != null) {
                OBJ_ID_LIST.addAll(DELETE_EMP_ID_LIST);
            }
            if (DELETE_POSI_EMP_ID_LIST != null) {
                OBJ_ID_LIST.addAll(DELETE_POSI_EMP_ID_LIST);
            }
            if (DELETE_EMP_RELATION_ID_LIST != null) {
                OBJ_ID_LIST.addAll(DELETE_EMP_RELATION_ID_LIST);
            }
            String deleteTagSql = "delete from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and (";
            Map<String, Object> deleteTagParamMap = new HashMap<>();
            deleteTagParamMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
            cycle = (int) Math.ceil(OBJ_ID_LIST.size() / 1000.0);
            for (int i = 0; i < cycle; i++) {
                deleteTagSql += "OBJ_ID_ in (:OBJ_ID_LIST" + i + ") or ";
                startIndex = i * 1000;
                if (i < cycle - 1) {
                    endIndex = (i + 1) * 1000;
                }
                else {
                    endIndex = OBJ_ID_LIST.size();
                }
                deleteTagParamMap.put("OBJ_ID_LIST" + i, OBJ_ID_LIST.subList(startIndex, endIndex));
            }
            deleteTagSql = deleteTagSql.substring(0, deleteTagSql.length() - 4);
            deleteTagSql += ")";
            if (!OBJ_ID_LIST.isEmpty()) {
                namedParameterMirrorServerJdbcTemplate.update(deleteTagSql, deleteTagParamMap);
            }

            // 新增
            if (INSERT_ORG_ID_LIST != null && !INSERT_ORG_ID_LIST.isEmpty()) {
                sql = "select * from OM_ORG where ORGN_SET_ID_ = :ORGN_SET_ID_ and ORG_ID_ in (:INSERT_ORG_ID_LIST)";
                paramMap.clear();
                paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
                paramMap.put("INSERT_ORG_ID_LIST", INSERT_ORG_ID_LIST);
                final List<Map<String, Object>> insertOrgList = namedParameterMainServerJdbcTemplate.queryForList(sql, paramMap);
                sql = "insert into OM_ORG (ORGN_SET_ID_, ORG_ID_, PARENT_ORG_ID_, ORG_CODE_, ORG_NAME_, ORG_ABBR_NAME_, ORG_TYPE_, ORG_CATEGORY_, MEMO_, ORG_TAG_, ORG_EXT_ATTR_1_, ORG_EXT_ATTR_2_, ORG_EXT_ATTR_3_, ORG_EXT_ATTR_4_, ORG_EXT_ATTR_5_, ORG_EXT_ATTR_6_, ORG_EXT_ATTR_7_, ORG_EXT_ATTR_8_, ORDER_, ORG_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                batch = new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Map<String, Object> org = insertOrgList.get(i);
                        ps.setObject(1, org.get("ORGN_SET_ID_"));
                        ps.setObject(2, org.get("ORG_ID_"));
                        ps.setObject(3, org.get("PARENT_ORG_ID_"));
                        ps.setObject(4, org.get("ORG_CODE_"));
                        ps.setObject(5, org.get("ORG_NAME_"));
                        ps.setObject(6, org.get("ORG_ABBR_NAME_"));
                        ps.setObject(7, org.get("ORG_TYPE_"));
                        ps.setObject(8, org.get("ORG_CATEGORY_"));
                        ps.setObject(9, org.get("MEMO_"));
                        ps.setObject(10, org.get("ORG_TAG_"));
                        ps.setObject(11, org.get("ORG_EXT_ATTR_1_"));
                        ps.setObject(12, org.get("ORG_EXT_ATTR_2_"));
                        ps.setObject(13, org.get("ORG_EXT_ATTR_3_"));
                        ps.setObject(14, org.get("ORG_EXT_ATTR_4_"));
                        ps.setObject(15, org.get("ORG_EXT_ATTR_5_"));
                        ps.setObject(16, org.get("ORG_EXT_ATTR_6_"));
                        ps.setObject(17, org.get("ORG_EXT_ATTR_7_"));
                        ps.setObject(18, org.get("ORG_EXT_ATTR_8_"));
                        ps.setObject(19, org.get("ORDER_"));
                        ps.setObject(20, org.get("ORG_STATUS_"));
                        ps.setObject(21, org.get("CREATION_DATE_"));
                        ps.setObject(22, org.get("UPDATE_DATE_"));
                        ps.setObject(23, org.get("OPERATOR_ID_"));
                        ps.setObject(24, org.get("OPERATOR_NAME_"));
                    }

                    public int getBatchSize() {
                        return insertOrgList.size();
                    }
                };
                omJdbcTemplate.batchUpdate(sql, batch);
            }
            if (INSERT_DUTY_ID_LIST != null && !INSERT_DUTY_ID_LIST.isEmpty()) {
                sql = "select * from OM_DUTY where ORGN_SET_ID_ = :ORGN_SET_ID_ and DUTY_ID_ in (:INSERT_DUTY_ID_LIST)";
                paramMap.clear();
                paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
                paramMap.put("INSERT_DUTY_ID_LIST", INSERT_DUTY_ID_LIST);
                final List<Map<String, Object>> insertDutyList = namedParameterMainServerJdbcTemplate.queryForList(sql, paramMap);
                sql = "insert into OM_DUTY (ORGN_SET_ID_, DUTY_ID_, DUTY_CODE_, DUTY_NAME_, DUTY_CATEGORY_, MEMO_, DUTY_TAG_, DUTY_EXT_ATTR_1_, DUTY_EXT_ATTR_2_, DUTY_EXT_ATTR_3_, DUTY_EXT_ATTR_4_, DUTY_EXT_ATTR_5_, DUTY_EXT_ATTR_6_, DUTY_EXT_ATTR_7_, DUTY_EXT_ATTR_8_, ORDER_, DUTY_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                batch = new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Map<String, Object> duty = insertDutyList.get(i);
                        ps.setObject(1, duty.get("ORGN_SET_ID_"));
                        ps.setObject(2, duty.get("DUTY_ID_"));
                        ps.setObject(3, duty.get("DUTY_CODE_"));
                        ps.setObject(4, duty.get("DUTY_NAME_"));
                        ps.setObject(5, duty.get("DUTY_CATEGORY_"));
                        ps.setObject(6, duty.get("MEMO_"));
                        ps.setObject(7, duty.get("DUTY_TAG_"));
                        ps.setObject(8, duty.get("DUTY_EXT_ATTR_1_"));
                        ps.setObject(9, duty.get("DUTY_EXT_ATTR_2_"));
                        ps.setObject(10, duty.get("DUTY_EXT_ATTR_3_"));
                        ps.setObject(11, duty.get("DUTY_EXT_ATTR_4_"));
                        ps.setObject(12, duty.get("DUTY_EXT_ATTR_5_"));
                        ps.setObject(13, duty.get("DUTY_EXT_ATTR_6_"));
                        ps.setObject(14, duty.get("DUTY_EXT_ATTR_7_"));
                        ps.setObject(15, duty.get("DUTY_EXT_ATTR_8_"));
                        ps.setObject(16, duty.get("ORDER_"));
                        ps.setObject(17, duty.get("DUTY_STATUS_"));
                        ps.setObject(18, duty.get("CREATION_DATE_"));
                        ps.setObject(19, duty.get("UPDATE_DATE_"));
                        ps.setObject(20, duty.get("OPERATOR_ID_"));
                        ps.setObject(21, duty.get("OPERATOR_NAME_"));
                    }

                    public int getBatchSize() {
                        return insertDutyList.size();
                    }
                };
                omJdbcTemplate.batchUpdate(sql, batch);
            }
            if (INSERT_POSI_ID_LIST != null && !INSERT_POSI_ID_LIST.isEmpty()) {
                sql = "select * from OM_POSI where ORGN_SET_ID_ = :ORGN_SET_ID_ and POSI_ID_ in (:INSERT_POSI_ID_LIST)";
                paramMap.clear();
                paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
                paramMap.put("INSERT_POSI_ID_LIST", INSERT_POSI_ID_LIST);
                final List<Map<String, Object>> insertPosiList = namedParameterMainServerJdbcTemplate.queryForList(sql, paramMap);
                sql = "insert into OM_POSI (ORGN_SET_ID_, POSI_ID_, ORG_ID_, DUTY_ID_, POSI_CODE_, POSI_NAME_, ORG_LEADER_TYPE_, POSI_CATEGORY_, MEMO_, POSI_TAG_, POSI_EXT_ATTR_1_, POSI_EXT_ATTR_2_, POSI_EXT_ATTR_3_, POSI_EXT_ATTR_4_, POSI_EXT_ATTR_5_, POSI_EXT_ATTR_6_, POSI_EXT_ATTR_7_, POSI_EXT_ATTR_8_, ORDER_, POSI_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                batch = new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Map<String, Object> posi = insertPosiList.get(i);
                        ps.setObject(1, posi.get("ORGN_SET_ID_"));
                        ps.setObject(2, posi.get("POSI_ID_"));
                        ps.setObject(3, posi.get("ORG_ID_"));
                        ps.setObject(4, posi.get("DUTY_ID_"));
                        ps.setObject(5, posi.get("POSI_CODE_"));
                        ps.setObject(6, posi.get("POSI_NAME_"));
                        ps.setObject(7, posi.get("ORG_LEADER_TYPE_"));
                        ps.setObject(8, posi.get("POSI_CATEGORY_"));
                        ps.setObject(9, posi.get("MEMO_"));
                        ps.setObject(10, posi.get("POSI_TAG_"));
                        ps.setObject(11, posi.get("POSI_EXT_ATTR_1_"));
                        ps.setObject(12, posi.get("POSI_EXT_ATTR_2_"));
                        ps.setObject(13, posi.get("POSI_EXT_ATTR_3_"));
                        ps.setObject(14, posi.get("POSI_EXT_ATTR_4_"));
                        ps.setObject(15, posi.get("POSI_EXT_ATTR_5_"));
                        ps.setObject(16, posi.get("POSI_EXT_ATTR_6_"));
                        ps.setObject(17, posi.get("POSI_EXT_ATTR_7_"));
                        ps.setObject(18, posi.get("POSI_EXT_ATTR_8_"));
                        ps.setObject(19, posi.get("ORDER_"));
                        ps.setObject(20, posi.get("POSI_STATUS_"));
                        ps.setObject(21, posi.get("CREATION_DATE_"));
                        ps.setObject(22, posi.get("UPDATE_DATE_"));
                        ps.setObject(23, posi.get("OPERATOR_ID_"));
                        ps.setObject(24, posi.get("OPERATOR_NAME_"));
                    }

                    public int getBatchSize() {
                        return insertPosiList.size();
                    }
                };
                omJdbcTemplate.batchUpdate(sql, batch);
            }
            if (INSERT_EMP_ID_LIST != null && !INSERT_EMP_ID_LIST.isEmpty()) {
                sql = "select * from OM_EMP where ORGN_SET_ID_ = :ORGN_SET_ID_ and EMP_ID_ in (:INSERT_EMP_ID_LIST)";
                paramMap.clear();
                paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
                paramMap.put("INSERT_EMP_ID_LIST", INSERT_EMP_ID_LIST);
                final List<Map<String, Object>> insertEmpList = namedParameterMainServerJdbcTemplate.queryForList(sql, paramMap);
                sql = "insert into OM_EMP (ORGN_SET_ID_, EMP_ID_, ORG_ID_, EMP_CODE_, EMP_NAME_, PASSWORD_, PASSWORD_RESET_REQ_, PARTY_, EMP_LEVEL_, GENDER_, BIRTH_DATE_, TEL_, EMAIL_, IN_DATE_, OUT_DATE_, EMP_CATEGORY_, MEMO_, EMP_TAG_, EMP_EXT_ATTR_1_, EMP_EXT_ATTR_2_, EMP_EXT_ATTR_3_, EMP_EXT_ATTR_4_, EMP_EXT_ATTR_5_, EMP_EXT_ATTR_6_, EMP_EXT_ATTR_7_, EMP_EXT_ATTR_8_, ORDER_, EMP_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                batch = new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Map<String, Object> emp = insertEmpList.get(i);
                        ps.setObject(1, emp.get("ORGN_SET_ID_"));
                        ps.setObject(2, emp.get("EMP_ID_"));
                        ps.setObject(3, emp.get("ORG_ID_"));
                        ps.setObject(4, emp.get("EMP_CODE_"));
                        ps.setObject(5, emp.get("EMP_NAME_"));
                        ps.setObject(6, emp.get("PASSWORD_"));
                        ps.setObject(7, emp.get("PASSWORD_RESET_REQ_"));
                        ps.setObject(8, emp.get("PARTY_"));
                        ps.setObject(9, emp.get("EMP_LEVEL_"));
                        ps.setObject(10, emp.get("GENDER_"));
                        ps.setObject(11, emp.get("BIRTH_DATE_"));
                        ps.setObject(12, emp.get("TEL_"));
                        ps.setObject(13, emp.get("EMAIL_"));
                        ps.setObject(14, emp.get("IN_DATE_"));
                        ps.setObject(15, emp.get("OUT_DATE_"));
                        ps.setObject(16, emp.get("EMP_CATEGORY_"));
                        ps.setObject(17, emp.get("MEMO_"));
                        ps.setObject(18, emp.get("EMP_TAG_"));
                        ps.setObject(19, emp.get("EMP_EXT_ATTR_1_"));
                        ps.setObject(20, emp.get("EMP_EXT_ATTR_2_"));
                        ps.setObject(21, emp.get("EMP_EXT_ATTR_3_"));
                        ps.setObject(22, emp.get("EMP_EXT_ATTR_4_"));
                        ps.setObject(23, emp.get("EMP_EXT_ATTR_5_"));
                        ps.setObject(24, emp.get("EMP_EXT_ATTR_6_"));
                        ps.setObject(25, emp.get("EMP_EXT_ATTR_7_"));
                        ps.setObject(26, emp.get("EMP_EXT_ATTR_8_"));
                        ps.setObject(27, emp.get("ORDER_"));
                        ps.setObject(28, emp.get("EMP_STATUS_"));
                        ps.setObject(29, emp.get("CREATION_DATE_"));
                        ps.setObject(30, emp.get("UPDATE_DATE_"));
                        ps.setObject(31, emp.get("OPERATOR_ID_"));
                        ps.setObject(32, emp.get("OPERATOR_NAME_"));
                    }

                    public int getBatchSize() {
                        return insertEmpList.size();
                    }
                };
                omJdbcTemplate.batchUpdate(sql, batch);
            }
            if (INSERT_POSI_EMP_ID_LIST != null && !INSERT_POSI_EMP_ID_LIST.isEmpty()) {
                sql = "select * from OM_POSI_EMP where ORGN_SET_ID_ = :ORGN_SET_ID_ and POSI_EMP_ID_ in (:INSERT_POSI_EMP_ID_LIST)";
                paramMap.clear();
                paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
                paramMap.put("INSERT_POSI_EMP_ID_LIST", INSERT_POSI_EMP_ID_LIST);
                final List<Map<String, Object>> insertPosiEmpList = namedParameterMainServerJdbcTemplate.queryForList(sql, paramMap);
                sql = "insert into OM_POSI_EMP (ORGN_SET_ID_, POSI_EMP_ID_, POSI_ID_, EMP_ID_, MAIN_, POSI_EMP_CATEGORY_, MEMO_, POSI_EMP_TAG_, POSI_EMP_EXT_ATTR_1_, POSI_EMP_EXT_ATTR_2_, POSI_EMP_EXT_ATTR_3_, POSI_EMP_EXT_ATTR_4_, POSI_EMP_EXT_ATTR_5_, POSI_EMP_EXT_ATTR_6_, POSI_EMP_EXT_ATTR_7_, POSI_EMP_EXT_ATTR_8_, ORDER_, POSI_EMP_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                batch = new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Map<String, Object> posiEmp = insertPosiEmpList.get(i);
                        ps.setObject(1, posiEmp.get("ORGN_SET_ID_"));
                        ps.setObject(2, posiEmp.get("POSI_EMP_ID_"));
                        ps.setObject(3, posiEmp.get("POSI_ID_"));
                        ps.setObject(4, posiEmp.get("EMP_ID_"));
                        ps.setObject(5, posiEmp.get("MAIN_"));
                        ps.setObject(6, posiEmp.get("POSI_EMP_CATEGORY_"));
                        ps.setObject(7, posiEmp.get("MEMO_"));
                        ps.setObject(8, posiEmp.get("POSI_EMP_TAG_"));
                        ps.setObject(9, posiEmp.get("POSI_EMP_EXT_ATTR_1_"));
                        ps.setObject(10, posiEmp.get("POSI_EMP_EXT_ATTR_2_"));
                        ps.setObject(11, posiEmp.get("POSI_EMP_EXT_ATTR_3_"));
                        ps.setObject(12, posiEmp.get("POSI_EMP_EXT_ATTR_4_"));
                        ps.setObject(13, posiEmp.get("POSI_EMP_EXT_ATTR_5_"));
                        ps.setObject(14, posiEmp.get("POSI_EMP_EXT_ATTR_6_"));
                        ps.setObject(15, posiEmp.get("POSI_EMP_EXT_ATTR_7_"));
                        ps.setObject(16, posiEmp.get("POSI_EMP_EXT_ATTR_8_"));
                        ps.setObject(17, posiEmp.get("ORDER_"));
                        ps.setObject(18, posiEmp.get("POSI_EMP_STATUS_"));
                        ps.setObject(19, posiEmp.get("CREATION_DATE_"));
                        ps.setObject(20, posiEmp.get("UPDATE_DATE_"));
                        ps.setObject(21, posiEmp.get("OPERATOR_ID_"));
                        ps.setObject(22, posiEmp.get("OPERATOR_NAME_"));
                    }

                    public int getBatchSize() {
                        return insertPosiEmpList.size();
                    }
                };
                omJdbcTemplate.batchUpdate(sql, batch);
            }
            if (INSERT_EMP_RELATION_ID_LIST != null && !INSERT_EMP_RELATION_ID_LIST.isEmpty()) {
                sql = "select * from OM_EMP_RELATION where ORGN_SET_ID_ = :ORGN_SET_ID_ and EMP_RELATION_ID_ in (:INSERT_EMP_RELATION_ID_LIST)";
                paramMap.clear();
                paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
                paramMap.put("INSERT_EMP_RELATION_ID_LIST", INSERT_EMP_RELATION_ID_LIST);
                final List<Map<String, Object>> insertEmpRelationList = namedParameterMainServerJdbcTemplate.queryForList(sql, paramMap);
                sql = "insert into OM_EMP_RELATION (ORGN_SET_ID_, EMP_RELATION_ID_, UPPER_EMP_ID_, LOWER_EMP_ID_, EMP_RELATION_, EMP_RELATION_CATEGORY_, MEMO_, EMP_RELATION_TAG_, EMP_RELATION_EXT_ATTR_1_, EMP_RELATION_EXT_ATTR_2_, EMP_RELATION_EXT_ATTR_3_, EMP_RELATION_EXT_ATTR_4_, EMP_RELATION_EXT_ATTR_5_, EMP_RELATION_EXT_ATTR_6_, EMP_RELATION_EXT_ATTR_7_, EMP_RELATION_EXT_ATTR_8_, ORDER_, EMP_RELATION_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                batch = new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Map<String, Object> empRelation = insertEmpRelationList.get(i);
                        ps.setObject(1, empRelation.get("ORGN_SET_ID_"));
                        ps.setObject(2, empRelation.get("EMP_RELATION_ID_"));
                        ps.setObject(3, empRelation.get("UPPER_EMP_ID_"));
                        ps.setObject(4, empRelation.get("LOWER_EMP_ID_"));
                        ps.setObject(5, empRelation.get("EMP_RELATION_"));
                        ps.setObject(6, empRelation.get("EMP_RELATION_CATEGORY_"));
                        ps.setObject(7, empRelation.get("MEMO_"));
                        ps.setObject(8, empRelation.get("EMP_RELATION_TAG_"));
                        ps.setObject(9, empRelation.get("EMP_RELATION_EXT_ATTR_1_"));
                        ps.setObject(10, empRelation.get("EMP_RELATION_EXT_ATTR_2_"));
                        ps.setObject(11, empRelation.get("EMP_RELATION_EXT_ATTR_3_"));
                        ps.setObject(12, empRelation.get("EMP_RELATION_EXT_ATTR_4_"));
                        ps.setObject(13, empRelation.get("EMP_RELATION_EXT_ATTR_5_"));
                        ps.setObject(14, empRelation.get("EMP_RELATION_EXT_ATTR_6_"));
                        ps.setObject(15, empRelation.get("EMP_RELATION_EXT_ATTR_7_"));
                        ps.setObject(16, empRelation.get("EMP_RELATION_EXT_ATTR_8_"));
                        ps.setObject(17, empRelation.get("ORDER_"));
                        ps.setObject(18, empRelation.get("EMP_RELATION_STATUS_"));
                        ps.setObject(19, empRelation.get("CREATION_DATE_"));
                        ps.setObject(20, empRelation.get("UPDATE_DATE_"));
                        ps.setObject(21, empRelation.get("OPERATOR_ID_"));
                        ps.setObject(22, empRelation.get("OPERATOR_NAME_"));
                    }

                    public int getBatchSize() {
                        return insertEmpRelationList.size();
                    }
                };
                omJdbcTemplate.batchUpdate(sql, batch);
            }

            // 修改
            if (UPDATE_ORG_ID_LIST != null && !UPDATE_ORG_ID_LIST.isEmpty()) {
                sql = "select * from OM_ORG where ORGN_SET_ID_ = :ORGN_SET_ID_ and ORG_ID_ in (:UPDATE_ORG_ID_LIST)";
                paramMap.clear();
                paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
                paramMap.put("UPDATE_ORG_ID_LIST", UPDATE_ORG_ID_LIST);
                final List<Map<String, Object>> updateOrgList = namedParameterMainServerJdbcTemplate.queryForList(sql, paramMap);
                sql = "update OM_ORG set PARENT_ORG_ID_ = ?, ORG_CODE_ = ?, ORG_NAME_ = ?, ORG_ABBR_NAME_ = ?, ORG_TYPE_ = ?, ORG_CATEGORY_ = ?, MEMO_ = ?, ORG_TAG_ = ?, ORG_EXT_ATTR_1_ = ?, ORG_EXT_ATTR_2_ = ?, ORG_EXT_ATTR_3_ = ?, ORG_EXT_ATTR_4_ = ?, ORG_EXT_ATTR_5_ = ?, ORG_EXT_ATTR_6_ = ?, ORG_EXT_ATTR_7_ = ?, ORG_EXT_ATTR_8_ = ?, ORDER_ = ?, ORG_STATUS_ = ?, CREATION_DATE_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and ORG_ID_ = ?";
                batch = new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Map<String, Object> org = updateOrgList.get(i);
                        ps.setObject(1, org.get("PARENT_ORG_ID_"));
                        ps.setObject(2, org.get("ORG_CODE_"));
                        ps.setObject(3, org.get("ORG_NAME_"));
                        ps.setObject(4, org.get("ORG_ABBR_NAME_"));
                        ps.setObject(5, org.get("ORG_TYPE_"));
                        ps.setObject(6, org.get("ORG_CATEGORY_"));
                        ps.setObject(7, org.get("MEMO_"));
                        ps.setObject(8, org.get("ORG_TAG_"));
                        ps.setObject(9, org.get("ORG_EXT_ATTR_1_"));
                        ps.setObject(10, org.get("ORG_EXT_ATTR_2_"));
                        ps.setObject(11, org.get("ORG_EXT_ATTR_3_"));
                        ps.setObject(12, org.get("ORG_EXT_ATTR_4_"));
                        ps.setObject(13, org.get("ORG_EXT_ATTR_5_"));
                        ps.setObject(14, org.get("ORG_EXT_ATTR_6_"));
                        ps.setObject(15, org.get("ORG_EXT_ATTR_7_"));
                        ps.setObject(16, org.get("ORG_EXT_ATTR_8_"));
                        ps.setObject(17, org.get("ORDER_"));
                        ps.setObject(18, org.get("ORG_STATUS_"));
                        ps.setObject(19, org.get("CREATION_DATE_"));
                        ps.setObject(20, org.get("UPDATE_DATE_"));
                        ps.setObject(21, org.get("OPERATOR_ID_"));
                        ps.setObject(22, org.get("OPERATOR_NAME_"));
                        ps.setObject(23, org.get("ORGN_SET_ID_"));
                        ps.setObject(24, org.get("ORG_ID_"));
                    }

                    public int getBatchSize() {
                        return updateOrgList.size();
                    }
                };
                omJdbcTemplate.batchUpdate(sql, batch);
            }
            if (UPDATE_DUTY_ID_LIST != null && !UPDATE_DUTY_ID_LIST.isEmpty()) {
                sql = "select * from OM_DUTY where ORGN_SET_ID_ = :ORGN_SET_ID_ and DUTY_ID_ in (:UPDATE_DUTY_ID_LIST)";
                paramMap.clear();
                paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
                paramMap.put("UPDATE_DUTY_ID_LIST", UPDATE_DUTY_ID_LIST);
                final List<Map<String, Object>> updateDutyList = namedParameterMainServerJdbcTemplate.queryForList(sql, paramMap);
                sql = "update OM_DUTY set DUTY_CODE_ = ?, DUTY_NAME_ = ?, DUTY_CATEGORY_ = ?, MEMO_ = ?, DUTY_TAG_ = ?, DUTY_EXT_ATTR_1_ = ?, DUTY_EXT_ATTR_2_ = ?, DUTY_EXT_ATTR_3_ = ?, DUTY_EXT_ATTR_4_ = ?, DUTY_EXT_ATTR_5_ = ?, DUTY_EXT_ATTR_6_ = ?, DUTY_EXT_ATTR_7_ = ?, DUTY_EXT_ATTR_8_ = ?, ORDER_ = ?, DUTY_STATUS_ = ?, CREATION_DATE_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and DUTY_ID_ = ?";
                batch = new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Map<String, Object> duty = updateDutyList.get(i);
                        ps.setObject(1, duty.get("DUTY_CODE_"));
                        ps.setObject(2, duty.get("DUTY_NAME_"));
                        ps.setObject(3, duty.get("DUTY_CATEGORY_"));
                        ps.setObject(4, duty.get("MEMO_"));
                        ps.setObject(5, duty.get("DUTY_TAG_"));
                        ps.setObject(6, duty.get("DUTY_EXT_ATTR_1_"));
                        ps.setObject(7, duty.get("DUTY_EXT_ATTR_2_"));
                        ps.setObject(8, duty.get("DUTY_EXT_ATTR_3_"));
                        ps.setObject(9, duty.get("DUTY_EXT_ATTR_4_"));
                        ps.setObject(10, duty.get("DUTY_EXT_ATTR_5_"));
                        ps.setObject(11, duty.get("DUTY_EXT_ATTR_6_"));
                        ps.setObject(12, duty.get("DUTY_EXT_ATTR_7_"));
                        ps.setObject(13, duty.get("DUTY_EXT_ATTR_8_"));
                        ps.setObject(14, duty.get("ORDER_"));
                        ps.setObject(15, duty.get("DUTY_STATUS_"));
                        ps.setObject(16, duty.get("CREATION_DATE_"));
                        ps.setObject(17, duty.get("UPDATE_DATE_"));
                        ps.setObject(18, duty.get("OPERATOR_ID_"));
                        ps.setObject(19, duty.get("OPERATOR_NAME_"));
                        ps.setObject(20, duty.get("ORGN_SET_ID_"));
                        ps.setObject(21, duty.get("DUTY_ID_"));
                    }

                    public int getBatchSize() {
                        return updateDutyList.size();
                    }
                };
                omJdbcTemplate.batchUpdate(sql, batch);
            }
            if (UPDATE_POSI_ID_LIST != null && !UPDATE_POSI_ID_LIST.isEmpty()) {
                sql = "select * from OM_POSI where ORGN_SET_ID_ = :ORGN_SET_ID_ and POSI_ID_ in (:UPDATE_POSI_ID_LIST)";
                paramMap.clear();
                paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
                paramMap.put("UPDATE_POSI_ID_LIST", UPDATE_POSI_ID_LIST);
                final List<Map<String, Object>> updatePosiList = namedParameterMainServerJdbcTemplate.queryForList(sql, paramMap);
                sql = "update OM_POSI set ORG_ID_ = ?, DUTY_ID_ = ?, POSI_CODE_ = ?, POSI_NAME_ = ?, ORG_LEADER_TYPE_ = ?, POSI_CATEGORY_ = ?, MEMO_ = ?, POSI_TAG_ = ?, POSI_EXT_ATTR_1_ = ?, POSI_EXT_ATTR_2_ = ?, POSI_EXT_ATTR_3_ = ?, POSI_EXT_ATTR_4_ = ?, POSI_EXT_ATTR_5_ = ?, POSI_EXT_ATTR_6_ = ?, POSI_EXT_ATTR_7_ = ?, POSI_EXT_ATTR_8_ = ?, ORDER_ = ?, POSI_STATUS_ = ?, CREATION_DATE_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and POSI_ID_ = ?";
                batch = new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Map<String, Object> posi = updatePosiList.get(i);
                        ps.setObject(1, posi.get("ORG_ID_"));
                        ps.setObject(2, posi.get("DUTY_ID_"));
                        ps.setObject(3, posi.get("POSI_CODE_"));
                        ps.setObject(4, posi.get("POSI_NAME_"));
                        ps.setObject(5, posi.get("ORG_LEADER_TYPE_"));
                        ps.setObject(6, posi.get("POSI_CATEGORY_"));
                        ps.setObject(7, posi.get("MEMO_"));
                        ps.setObject(8, posi.get("POSI_TAG_"));
                        ps.setObject(9, posi.get("POSI_EXT_ATTR_1_"));
                        ps.setObject(10, posi.get("POSI_EXT_ATTR_2_"));
                        ps.setObject(11, posi.get("POSI_EXT_ATTR_3_"));
                        ps.setObject(12, posi.get("POSI_EXT_ATTR_4_"));
                        ps.setObject(13, posi.get("POSI_EXT_ATTR_5_"));
                        ps.setObject(14, posi.get("POSI_EXT_ATTR_6_"));
                        ps.setObject(15, posi.get("POSI_EXT_ATTR_7_"));
                        ps.setObject(16, posi.get("POSI_EXT_ATTR_8_"));
                        ps.setObject(17, posi.get("ORDER_"));
                        ps.setObject(18, posi.get("POSI_STATUS_"));
                        ps.setObject(19, posi.get("CREATION_DATE_"));
                        ps.setObject(20, posi.get("UPDATE_DATE_"));
                        ps.setObject(21, posi.get("OPERATOR_ID_"));
                        ps.setObject(22, posi.get("OPERATOR_NAME_"));
                        ps.setObject(23, posi.get("ORGN_SET_ID_"));
                        ps.setObject(24, posi.get("POSI_ID_"));
                    }

                    public int getBatchSize() {
                        return updatePosiList.size();
                    }
                };
                omJdbcTemplate.batchUpdate(sql, batch);
            }
            if (UPDATE_EMP_ID_LIST != null && !UPDATE_EMP_ID_LIST.isEmpty()) {
                sql = "select * from OM_EMP where ORGN_SET_ID_ = :ORGN_SET_ID_ and EMP_ID_ in (:UPDATE_EMP_ID_LIST)";
                paramMap.clear();
                paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
                paramMap.put("UPDATE_EMP_ID_LIST", UPDATE_EMP_ID_LIST);
                final List<Map<String, Object>> updateEmpList = namedParameterMainServerJdbcTemplate.queryForList(sql, paramMap);
                sql = "update OM_EMP set ORG_ID_ = ?, EMP_CODE_ = ?, EMP_NAME_ = ?, PASSWORD_ = ?, PASSWORD_RESET_REQ_ = ?, PARTY_ = ?, EMP_LEVEL_ = ?, GENDER_ = ?, BIRTH_DATE_ = ?, TEL_ = ?, EMAIL_ = ?, IN_DATE_ = ?, OUT_DATE_ = ?, EMP_CATEGORY_ = ?, MEMO_ = ?, EMP_TAG_ = ?, EMP_EXT_ATTR_1_ = ?, EMP_EXT_ATTR_2_ = ?, EMP_EXT_ATTR_3_ = ?, EMP_EXT_ATTR_4_ = ?, EMP_EXT_ATTR_5_ = ?, EMP_EXT_ATTR_6_ = ?, EMP_EXT_ATTR_7_ = ?, EMP_EXT_ATTR_8_ = ?, ORDER_ = ?, EMP_STATUS_ = ?, CREATION_DATE_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and EMP_ID_ = ?";
                batch = new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Map<String, Object> emp = updateEmpList.get(i);
                        ps.setObject(1, emp.get("ORG_ID_"));
                        ps.setObject(2, emp.get("EMP_CODE_"));
                        ps.setObject(3, emp.get("EMP_NAME_"));
                        ps.setObject(4, emp.get("PASSWORD_"));
                        ps.setObject(5, emp.get("PASSWORD_RESET_REQ_"));
                        ps.setObject(6, emp.get("PARTY_"));
                        ps.setObject(7, emp.get("EMP_LEVEL_"));
                        ps.setObject(8, emp.get("GENDER_"));
                        ps.setObject(9, emp.get("BIRTH_DATE_"));
                        ps.setObject(10, emp.get("TEL_"));
                        ps.setObject(11, emp.get("EMAIL_"));
                        ps.setObject(12, emp.get("IN_DATE_"));
                        ps.setObject(13, emp.get("OUT_DATE_"));
                        ps.setObject(14, emp.get("EMP_CATEGORY_"));
                        ps.setObject(15, emp.get("MEMO_"));
                        ps.setObject(16, emp.get("EMP_TAG_"));
                        ps.setObject(17, emp.get("EMP_EXT_ATTR_1_"));
                        ps.setObject(18, emp.get("EMP_EXT_ATTR_2_"));
                        ps.setObject(19, emp.get("EMP_EXT_ATTR_3_"));
                        ps.setObject(20, emp.get("EMP_EXT_ATTR_4_"));
                        ps.setObject(21, emp.get("EMP_EXT_ATTR_5_"));
                        ps.setObject(22, emp.get("EMP_EXT_ATTR_6_"));
                        ps.setObject(23, emp.get("EMP_EXT_ATTR_7_"));
                        ps.setObject(24, emp.get("EMP_EXT_ATTR_8_"));
                        ps.setObject(25, emp.get("ORDER_"));
                        ps.setObject(26, emp.get("EMP_STATUS_"));
                        ps.setObject(27, emp.get("CREATION_DATE_"));
                        ps.setObject(28, emp.get("UPDATE_DATE_"));
                        ps.setObject(29, emp.get("OPERATOR_ID_"));
                        ps.setObject(30, emp.get("OPERATOR_NAME_"));
                        ps.setObject(31, emp.get("ORGN_SET_ID_"));
                        ps.setObject(32, emp.get("EMP_ID_"));
                    }

                    public int getBatchSize() {
                        return updateEmpList.size();
                    }
                };
                omJdbcTemplate.batchUpdate(sql, batch);
            }
            if (UPDATE_POSI_EMP_ID_LIST != null && !UPDATE_POSI_EMP_ID_LIST.isEmpty()) {
                sql = "select * from OM_POSI_EMP where ORGN_SET_ID_ = :ORGN_SET_ID_ and POSI_EMP_ID_ in (:UPDATE_POSI_EMP_ID_LIST)";
                paramMap.clear();
                paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
                paramMap.put("UPDATE_POSI_EMP_ID_LIST", UPDATE_POSI_EMP_ID_LIST);
                final List<Map<String, Object>> updatePosiEmpList = namedParameterMainServerJdbcTemplate.queryForList(sql, paramMap);
                sql = "update OM_POSI_EMP set POSI_ID_ = ?, EMP_ID_ = ?, MAIN_ = ?, POSI_EMP_CATEGORY_ = ?, MEMO_ = ?, POSI_EMP_TAG_ = ?, POSI_EMP_EXT_ATTR_1_ = ?, POSI_EMP_EXT_ATTR_2_ = ?, POSI_EMP_EXT_ATTR_3_ = ?, POSI_EMP_EXT_ATTR_4_ = ?, POSI_EMP_EXT_ATTR_5_ = ?, POSI_EMP_EXT_ATTR_6_ = ?, POSI_EMP_EXT_ATTR_7_ = ?, POSI_EMP_EXT_ATTR_8_ = ?, ORDER_ = ?, POSI_EMP_STATUS_ = ?, CREATION_DATE_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and POSI_EMP_ID_ = ?";
                batch = new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Map<String, Object> posiEmp = updatePosiEmpList.get(i);
                        ps.setObject(1, posiEmp.get("POSI_ID_"));
                        ps.setObject(2, posiEmp.get("EMP_ID_"));
                        ps.setObject(3, posiEmp.get("MAIN_"));
                        ps.setObject(4, posiEmp.get("POSI_EMP_CATEGORY_"));
                        ps.setObject(5, posiEmp.get("MEMO_"));
                        ps.setObject(6, posiEmp.get("POSI_EMP_TAG_"));
                        ps.setObject(7, posiEmp.get("POSI_EMP_EXT_ATTR_1_"));
                        ps.setObject(8, posiEmp.get("POSI_EMP_EXT_ATTR_2_"));
                        ps.setObject(9, posiEmp.get("POSI_EMP_EXT_ATTR_3_"));
                        ps.setObject(10, posiEmp.get("POSI_EMP_EXT_ATTR_4_"));
                        ps.setObject(11, posiEmp.get("POSI_EMP_EXT_ATTR_5_"));
                        ps.setObject(12, posiEmp.get("POSI_EMP_EXT_ATTR_6_"));
                        ps.setObject(13, posiEmp.get("POSI_EMP_EXT_ATTR_7_"));
                        ps.setObject(14, posiEmp.get("POSI_EMP_EXT_ATTR_8_"));
                        ps.setObject(15, posiEmp.get("ORDER_"));
                        ps.setObject(16, posiEmp.get("POSI_EMP_STATUS_"));
                        ps.setObject(17, posiEmp.get("CREATION_DATE_"));
                        ps.setObject(18, posiEmp.get("UPDATE_DATE_"));
                        ps.setObject(19, posiEmp.get("OPERATOR_ID_"));
                        ps.setObject(20, posiEmp.get("OPERATOR_NAME_"));
                        ps.setObject(21, posiEmp.get("ORGN_SET_ID_"));
                        ps.setObject(22, posiEmp.get("POSI_EMP_ID_"));
                    }

                    public int getBatchSize() {
                        return updatePosiEmpList.size();
                    }
                };
                omJdbcTemplate.batchUpdate(sql, batch);
            }
            if (UPDATE_EMP_RELATION_ID_LIST != null && !UPDATE_EMP_RELATION_ID_LIST.isEmpty()) {
                sql = "select * from OM_EMP_RELATION where ORGN_SET_ID_ = :ORGN_SET_ID_ and EMP_RELATION_ID_ in (:UPDATE_EMP_RELATION_ID_LIST)";
                paramMap.clear();
                paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
                paramMap.put("UPDATE_EMP_RELATION_ID_LIST", UPDATE_EMP_RELATION_ID_LIST);
                final List<Map<String, Object>> updateEmpRelationList = namedParameterMainServerJdbcTemplate.queryForList(sql, paramMap);
                sql = "update OM_EMP_RELATION set UPPER_EMP_ID_ = ?, LOWER_EMP_ID_ = ?, EMP_RELATION_ = ?, EMP_RELATION_CATEGORY_ = ?, MEMO_ = ?, EMP_RELATION_TAG_ = ?, EMP_RELATION_EXT_ATTR_1_ = ?, EMP_RELATION_EXT_ATTR_2_ = ?, EMP_RELATION_EXT_ATTR_3_ = ?, EMP_RELATION_EXT_ATTR_4_ = ?, EMP_RELATION_EXT_ATTR_5_ = ?, EMP_RELATION_EXT_ATTR_6_ = ?, EMP_RELATION_EXT_ATTR_7_ = ?, EMP_RELATION_EXT_ATTR_8_ = ?, ORDER_ = ?, EMP_RELATION_STATUS_ = ?, CREATION_DATE_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and EMP_RELATION_ID_ = ?";
                batch = new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Map<String, Object> empRelation = updateEmpRelationList.get(i);
                        ps.setObject(1, empRelation.get("UPPER_EMP_ID_"));
                        ps.setObject(2, empRelation.get("LOWER_EMP_ID_"));
                        ps.setObject(3, empRelation.get("EMP_RELATION_"));
                        ps.setObject(4, empRelation.get("EMP_RELATION_CATEGORY_"));
                        ps.setObject(5, empRelation.get("MEMO_"));
                        ps.setObject(6, empRelation.get("EMP_RELATION_TAG_"));
                        ps.setObject(7, empRelation.get("EMP_RELATION_EXT_ATTR_1_"));
                        ps.setObject(8, empRelation.get("EMP_RELATION_EXT_ATTR_2_"));
                        ps.setObject(9, empRelation.get("EMP_RELATION_EXT_ATTR_3_"));
                        ps.setObject(10, empRelation.get("EMP_RELATION_EXT_ATTR_4_"));
                        ps.setObject(11, empRelation.get("EMP_RELATION_EXT_ATTR_5_"));
                        ps.setObject(12, empRelation.get("EMP_RELATION_EXT_ATTR_6_"));
                        ps.setObject(13, empRelation.get("EMP_RELATION_EXT_ATTR_7_"));
                        ps.setObject(14, empRelation.get("EMP_RELATION_EXT_ATTR_8_"));
                        ps.setObject(15, empRelation.get("ORDER_"));
                        ps.setObject(16, empRelation.get("EMP_RELATION_STATUS_"));
                        ps.setObject(17, empRelation.get("CREATION_DATE_"));
                        ps.setObject(18, empRelation.get("UPDATE_DATE_"));
                        ps.setObject(19, empRelation.get("OPERATOR_ID_"));
                        ps.setObject(20, empRelation.get("OPERATOR_NAME_"));
                        ps.setObject(21, empRelation.get("ORGN_SET_ID_"));
                        ps.setObject(22, empRelation.get("EMP_RELATION_ID_"));
                    }

                    public int getBatchSize() {
                        return updateEmpRelationList.size();
                    }
                };
                omJdbcTemplate.batchUpdate(sql, batch);
            }

            // 删除
            if (DELETE_EMP_RELATION_ID_LIST != null && !DELETE_EMP_RELATION_ID_LIST.isEmpty()) {
                sql = "delete from OM_EMP_RELATION where ORGN_SET_ID_ = :ORGN_SET_ID_ and (";
                paramMap.clear();
                paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
                cycle = (int) Math.ceil(DELETE_EMP_RELATION_ID_LIST.size() / 1000.0);
                for (int i = 0; i < cycle; i++) {
                    sql += "EMP_RELATION_ID_ in (:EMP_RELATION_ID_LIST" + i + ") or ";
                    startIndex = i * 1000;
                    if (i < cycle - 1) {
                        endIndex = (i + 1) * 1000;
                    }
                    else {
                        endIndex = DELETE_EMP_RELATION_ID_LIST.size();
                    }
                    paramMap.put("EMP_RELATION_ID_LIST" + i, DELETE_EMP_RELATION_ID_LIST.subList(startIndex, endIndex));
                }
                sql = sql.substring(0, sql.length() - 4);
                sql += ")";
                namedParameterMirrorServerJdbcTemplate.update(sql, paramMap);
            }
            if (DELETE_POSI_EMP_ID_LIST != null && !DELETE_POSI_EMP_ID_LIST.isEmpty()) {
                sql = "delete from OM_POSI_EMP where ORGN_SET_ID_ = :ORGN_SET_ID_ and (";
                paramMap.clear();
                paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
                cycle = (int) Math.ceil(DELETE_POSI_EMP_ID_LIST.size() / 1000.0);
                for (int i = 0; i < cycle; i++) {
                    sql += "POSI_EMP_ID_ in (:POSI_EMP_ID_LIST" + i + ") or ";
                    startIndex = i * 1000;
                    if (i < cycle - 1) {
                        endIndex = (i + 1) * 1000;
                    }
                    else {
                        endIndex = DELETE_POSI_EMP_ID_LIST.size();
                    }
                    paramMap.put("POSI_EMP_ID_LIST" + i, DELETE_POSI_EMP_ID_LIST.subList(startIndex, endIndex));
                }
                sql = sql.substring(0, sql.length() - 4);
                sql += ")";
                namedParameterMirrorServerJdbcTemplate.update(sql, paramMap);
            }
            if (DELETE_EMP_ID_LIST != null && !DELETE_EMP_ID_LIST.isEmpty()) {
                sql = "delete from OM_EMP where ORGN_SET_ID_ = :ORGN_SET_ID_ and (";
                paramMap.clear();
                paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
                cycle = (int) Math.ceil(DELETE_EMP_ID_LIST.size() / 1000.0);
                for (int i = 0; i < cycle; i++) {
                    sql += "EMP_ID_ in (:EMP_ID_LIST" + i + ") or ";
                    startIndex = i * 1000;
                    if (i < cycle - 1) {
                        endIndex = (i + 1) * 1000;
                    }
                    else {
                        endIndex = DELETE_EMP_ID_LIST.size();
                    }
                    paramMap.put("EMP_ID_LIST" + i, DELETE_EMP_ID_LIST.subList(startIndex, endIndex));
                }
                sql = sql.substring(0, sql.length() - 4);
                sql += ")";
                namedParameterMirrorServerJdbcTemplate.update(sql, paramMap);
            }
            if (DELETE_POSI_ID_LIST != null && !DELETE_POSI_ID_LIST.isEmpty()) {
                sql = "delete from OM_POSI where ORGN_SET_ID_ = :ORGN_SET_ID_ and (";
                paramMap.clear();
                paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
                cycle = (int) Math.ceil(DELETE_POSI_ID_LIST.size() / 1000.0);
                for (int i = 0; i < cycle; i++) {
                    sql += "POSI_ID_ in (:POSI_ID_LIST" + i + ") or ";
                    startIndex = i * 1000;
                    if (i < cycle - 1) {
                        endIndex = (i + 1) * 1000;
                    }
                    else {
                        endIndex = DELETE_POSI_ID_LIST.size();
                    }
                    paramMap.put("POSI_ID_LIST" + i, DELETE_POSI_ID_LIST.subList(startIndex, endIndex));
                }
                sql = sql.substring(0, sql.length() - 4);
                sql += ")";
                namedParameterMirrorServerJdbcTemplate.update(sql, paramMap);
            }
            if (DELETE_DUTY_ID_LIST != null && !DELETE_DUTY_ID_LIST.isEmpty()) {
                sql = "delete from OM_DUTY where ORGN_SET_ID_ = :ORGN_SET_ID_ and (";
                paramMap.clear();
                paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
                cycle = (int) Math.ceil(DELETE_DUTY_ID_LIST.size() / 1000.0);
                for (int i = 0; i < cycle; i++) {
                    sql += "DUTY_ID_ in (:DUTY_ID_LIST" + i + ") or ";
                    startIndex = i * 1000;
                    if (i < cycle - 1) {
                        endIndex = (i + 1) * 1000;
                    }
                    else {
                        endIndex = DELETE_DUTY_ID_LIST.size();
                    }
                    paramMap.put("DUTY_ID_LIST" + i, DELETE_DUTY_ID_LIST.subList(startIndex, endIndex));
                }
                sql = sql.substring(0, sql.length() - 4);
                sql += ")";
                namedParameterMirrorServerJdbcTemplate.update(sql, paramMap);

            }
            if (DELETE_ORG_ID_LIST != null && !DELETE_ORG_ID_LIST.isEmpty()) {
                sql = "delete from OM_ORG where ORGN_SET_ID_ = :ORGN_SET_ID_ and (";
                paramMap.clear();
                paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
                cycle = (int) Math.ceil(DELETE_ORG_ID_LIST.size() / 1000.0);
                for (int i = 0; i < cycle; i++) {
                    sql += "ORG_ID_ in (:ORG_ID_LIST" + i + ") or ";
                    startIndex = i * 1000;
                    if (i < cycle - 1) {
                        endIndex = (i + 1) * 1000;
                    }
                    else {
                        endIndex = DELETE_ORG_ID_LIST.size();
                    }
                    paramMap.put("ORG_ID_LIST" + i, DELETE_ORG_ID_LIST.subList(startIndex, endIndex));
                }
                sql = sql.substring(0, sql.length() - 4);
                sql += ")";
                namedParameterMirrorServerJdbcTemplate.update(sql, paramMap);
            }

            // 新增TAG
            OBJ_ID_LIST = new ArrayList<>();
            if (INSERT_ORG_ID_LIST != null) {
                OBJ_ID_LIST.addAll(INSERT_ORG_ID_LIST);
            }
            if (INSERT_DUTY_ID_LIST != null) {
                OBJ_ID_LIST.addAll(INSERT_DUTY_ID_LIST);
            }
            if (INSERT_POSI_ID_LIST != null) {
                OBJ_ID_LIST.addAll(INSERT_POSI_ID_LIST);
            }
            if (INSERT_EMP_ID_LIST != null) {
                OBJ_ID_LIST.addAll(INSERT_EMP_ID_LIST);
            }
            if (INSERT_POSI_EMP_ID_LIST != null) {
                OBJ_ID_LIST.addAll(INSERT_POSI_EMP_ID_LIST);
            }
            if (INSERT_EMP_RELATION_ID_LIST != null) {
                OBJ_ID_LIST.addAll(INSERT_EMP_RELATION_ID_LIST);
            }
            if (UPDATE_ORG_ID_LIST != null) {
                OBJ_ID_LIST.addAll(UPDATE_ORG_ID_LIST);
            }
            if (UPDATE_DUTY_ID_LIST != null) {
                OBJ_ID_LIST.addAll(UPDATE_DUTY_ID_LIST);
            }
            if (UPDATE_POSI_ID_LIST != null) {
                OBJ_ID_LIST.addAll(UPDATE_POSI_ID_LIST);
            }
            if (UPDATE_EMP_ID_LIST != null) {
                OBJ_ID_LIST.addAll(UPDATE_EMP_ID_LIST);
            }
            if (UPDATE_POSI_EMP_ID_LIST != null) {
                OBJ_ID_LIST.addAll(UPDATE_POSI_EMP_ID_LIST);
            }
            if (UPDATE_EMP_RELATION_ID_LIST != null) {
                OBJ_ID_LIST.addAll(UPDATE_EMP_RELATION_ID_LIST);
            }
            String selectTagSql = "select * from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and (";
            Map<String, Object> selectTagParamMap = new HashMap<>();
            selectTagParamMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
            cycle = (int) Math.ceil(OBJ_ID_LIST.size() / 1000.0);
            for (int i = 0; i < cycle; i++) {
                selectTagSql += "OBJ_ID_ in (:OBJ_ID_LIST" + i + ") or ";
                startIndex = i * 1000;
                if (i < cycle - 1) {
                    endIndex = (i + 1) * 1000;
                }
                else {
                    endIndex = OBJ_ID_LIST.size();
                }
                selectTagParamMap.put("OBJ_ID_LIST" + i, OBJ_ID_LIST.subList(startIndex, endIndex));
            }
            selectTagSql = selectTagSql.substring(0, selectTagSql.length() - 4);
            selectTagSql += ")";
            if (!OBJ_ID_LIST.isEmpty()) {
                final List<Map<String, Object>> tagList = namedParameterMainServerJdbcTemplate.queryForList(selectTagSql, selectTagParamMap);
                sql = "insert into OM_TAG (ORGN_SET_ID_, TAG_ID_, OBJ_ID_, OBJ_TYPE_, TAG_) values (?, ?, ?, ?, ?)";
                batch = new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Map<String, Object> tag = tagList.get(i);
                        ps.setObject(1, ORGN_SET_ID_);
                        ps.setObject(2, tag.get("TAG_ID_"));
                        ps.setObject(3, tag.get("OBJ_ID_"));
                        ps.setObject(4, tag.get("OBJ_TYPE_"));
                        ps.setObject(5, tag.get("TAG_"));
                    }

                    public int getBatchSize() {
                        return tagList.size();
                    }
                };
                omJdbcTemplate.batchUpdate(sql, batch);
            }

            transactionManager.commit(transactionStatus);

            omJdbcTemplate.execute("alter table OM_ORG enable constraint FK_OM_ORG_PARENT");
        }
        catch (Exception e) {
            transactionManager.rollback(transactionStatus);
            throw new RuntimeException(e);
        }

        return 1;
    }

    private DataSource getMainServerDataSource() {
        List<Map<String, Object>> mainServerList = omMainServerService.selectMainServer(null, null, Collections.singletonList("1"), 1, -1);
        if (mainServerList.size() == 1) {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName((String) mainServerList.get(0).get("DRIVER_CLASS_NAME_"));
            dataSource.setUrl((String) mainServerList.get(0).get("URL_"));
            dataSource.setUsername((String) mainServerList.get(0).get("USERNAME_"));
            dataSource.setPassword((String) mainServerList.get(0).get("PASSWORD_"));

            return dataSource;
        }

        return null;
    }
}