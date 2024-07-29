package com.opendynamic.om.service.impl.oracle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.opendynamic.OdSqlCriteria;
import com.opendynamic.OdUtils;
import com.opendynamic.om.service.OmDutyService;
import com.opendynamic.om.service.OmEmpRelationService;
import com.opendynamic.om.service.OmEmpService;
import com.opendynamic.om.service.OmOrgService;
import com.opendynamic.om.service.OmOrgnSetService;
import com.opendynamic.om.service.OmPosiEmpService;
import com.opendynamic.om.service.OmPosiService;
import com.opendynamic.om.vo.OrgnChange;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OmOrgnSetServiceImpl implements OmOrgnSetService {
    @Autowired
    private OmDutyService omDutyService;
    @Autowired
    private OmOrgService omOrgService;
    @Autowired
    private OmPosiService omPosiService;
    @Autowired
    private OmEmpService omEmpService;
    @Autowired
    private OmPosiEmpService omPosiEmpService;
    @Autowired
    private OmEmpRelationService omEmpRelationService;
    @Autowired
    private JdbcTemplate omJdbcTemplate;

    @Override
    public Map<String, Object> loadOrgnSet(String ORGN_SET_ID_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql = "select * from OMV_ORGN_SET where ORGN_SET_ID_ = ?";
        List<Map<String, Object>> result = omJdbcTemplate.queryForList(sql, ORGN_SET_ID_);
        if (result.size() == 1) {
            return result.get(0);
        }
        else {
            return null;
        }
    }

    @Override
    public Map<String, Object> loadOrgnSetByCode(String ORGN_SET_CODE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql = "select * from OMV_ORGN_SET where ORGN_SET_CODE_ = ?";
        List<Map<String, Object>> result = omJdbcTemplate.queryForList(sql, ORGN_SET_CODE_);
        if (result.size() == 1) {
            return result.get(0);
        }
        else {
            return null;
        }
    }

    @Override
    public List<Map<String, Object>> selectOrgnSet(String ORGN_SET_ID_, List<String> ORGN_SET_ID_LIST, String PARENT_ORGN_SET_ID_, List<String> PARENT_ORGN_SET_ID_LIST, String ORGN_SET_CODE_, List<String> ORGN_SET_CODE_LIST, String ORGN_SET_NAME_, List<String> ORGN_SET_NAME_LIST, String ORGN_SET_STATUS_, List<String> ORGN_SET_STATUS_LIST, Boolean orgnSetRootOnly, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaOrgnSet(false, ORGN_SET_ID_, ORGN_SET_ID_LIST, PARENT_ORGN_SET_ID_, PARENT_ORGN_SET_ID_LIST, ORGN_SET_CODE_, ORGN_SET_CODE_LIST, ORGN_SET_NAME_, ORGN_SET_NAME_LIST, ORGN_SET_STATUS_, ORGN_SET_STATUS_LIST, orgnSetRootOnly, OPERATOR_ID_, OPERATOR_NAME_);// 根据查询条件组装查询SQL语句
        String sql = odSqlCriteria.getSql();
        Map<String, Object> paramMap = odSqlCriteria.getParamMap();

        if (page != null && limit != null && limit > 0) {// 分页
            int start = (page - 1) * limit + 1;
            int end = page * limit;
            sql = "select * from (select FULLTABLE.*, ROWNUM RN from (" + sql + ") FULLTABLE where ROWNUM <= " + end + ") where RN >= " + start;
        }

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForList(sql, paramMap);
    }

    @Override
    public int countOrgnSet(String ORGN_SET_ID_, List<String> ORGN_SET_ID_LIST, String PARENT_ORGN_SET_ID_, List<String> PARENT_ORGN_SET_ID_LIST, String ORGN_SET_CODE_, List<String> ORGN_SET_CODE_LIST, String ORGN_SET_NAME_, List<String> ORGN_SET_NAME_LIST, String ORGN_SET_STATUS_, List<String> ORGN_SET_STATUS_LIST, Boolean orgnSetRootOnly, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaOrgnSet(true, ORGN_SET_ID_, ORGN_SET_ID_LIST, PARENT_ORGN_SET_ID_, PARENT_ORGN_SET_ID_LIST, ORGN_SET_CODE_, ORGN_SET_CODE_LIST, ORGN_SET_NAME_, ORGN_SET_NAME_LIST, ORGN_SET_STATUS_, ORGN_SET_STATUS_LIST, orgnSetRootOnly, OPERATOR_ID_, OPERATOR_NAME_);// 根据查询条件组装总数查询SQL语句
        String sql = odSqlCriteria.getSql();
        Map<String, Object> paramMap = odSqlCriteria.getParamMap();

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    private OdSqlCriteria buildSqlCriteriaOrgnSet(boolean count, String ORGN_SET_ID_, List<String> ORGN_SET_ID_LIST, String PARENT_ORGN_SET_ID_, List<String> PARENT_ORGN_SET_ID_LIST, String ORGN_SET_CODE_, List<String> ORGN_SET_CODE_LIST, String ORGN_SET_NAME_, List<String> ORGN_SET_NAME_LIST, String ORGN_SET_STATUS_, List<String> ORGN_SET_STATUS_LIST, Boolean orgnSetRootOnly, String OPERATOR_ID_, String OPERATOR_NAME_) {// 组装查询SQL语句
        String sql;
        Map<String, Object> paramMap = new HashMap<>();

        if (count) {
            sql = "select count(*) from OMV_ORGN_SET where 1 = 1";
        }
        else {
            sql = "select * from OMV_ORGN_SET where 1 = 1";
        }

        if (StringUtils.isNotEmpty(ORGN_SET_ID_)) {
            sql += " and ORGN_SET_ID_ = :ORGN_SET_ID_";
            paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        }
        if (ORGN_SET_ID_LIST != null && !ORGN_SET_ID_LIST.isEmpty()) {
            sql += " and ORGN_SET_ID_ in (:ORGN_SET_ID_LIST)";
            paramMap.put("ORGN_SET_ID_LIST", ORGN_SET_ID_LIST);
        }
        if (StringUtils.isNotEmpty(PARENT_ORGN_SET_ID_)) {
            sql += " and PARENT_ORGN_SET_ID_ = :PARENT_ORGN_SET_ID_";
            paramMap.put("PARENT_ORGN_SET_ID_", PARENT_ORGN_SET_ID_);
        }
        if (PARENT_ORGN_SET_ID_LIST != null && !PARENT_ORGN_SET_ID_LIST.isEmpty()) {
            sql += " and PARENT_ORGN_SET_ID_ in (:PARENT_ORGN_SET_ID_LIST)";
            paramMap.put("PARENT_ORGN_SET_ID_LIST", PARENT_ORGN_SET_ID_LIST);
        }
        if (StringUtils.isNotEmpty(ORGN_SET_CODE_)) {
            sql += " and ORGN_SET_CODE_ = :ORGN_SET_CODE_";
            paramMap.put("ORGN_SET_CODE_", ORGN_SET_CODE_);
        }
        if (ORGN_SET_CODE_LIST != null && !ORGN_SET_CODE_LIST.isEmpty()) {
            sql += " and ORGN_SET_CODE_ in (:ORGN_SET_CODE_LIST)";
            paramMap.put("ORGN_SET_CODE_LIST", ORGN_SET_CODE_LIST);
        }
        if (StringUtils.isNotEmpty(ORGN_SET_NAME_)) {
            sql += " and ORGN_SET_NAME_ like '%' || :ORGN_SET_NAME_ || '%'";
            paramMap.put("ORGN_SET_NAME_", ORGN_SET_NAME_);
        }
        if (ORGN_SET_NAME_LIST != null && !ORGN_SET_NAME_LIST.isEmpty()) {
            sql += " and ORGN_SET_NAME_ in (:ORGN_SET_NAME_LIST)";
            paramMap.put("ORGN_SET_NAME_LIST", ORGN_SET_NAME_LIST);
        }
        if (StringUtils.isNotEmpty(ORGN_SET_STATUS_)) {
            sql += " and ORGN_SET_STATUS_ = :ORGN_SET_STATUS_";
            paramMap.put("ORGN_SET_STATUS_", ORGN_SET_STATUS_);
        }
        if (ORGN_SET_STATUS_LIST != null && !ORGN_SET_STATUS_LIST.isEmpty()) {
            sql += " and ORGN_SET_STATUS_ in (:ORGN_SET_STATUS_LIST)";
            paramMap.put("ORGN_SET_STATUS_LIST", ORGN_SET_STATUS_LIST);
        }

        if (orgnSetRootOnly != null && orgnSetRootOnly) {
            sql += " and (PARENT_ORGN_SET_ID_ is null or PARENT_ORGN_SET_ID_ = '')";
        }

        if (!count) {
            sql += " order by ORDER_, ORGN_SET_ID_";
        }

        return new OdSqlCriteria(sql, paramMap);
    }

    @Override
    public List<Map<String, Object>> selectParentOrgnSet(String ORGN_SET_ID_, String ORGN_SET_CODE_, List<String> ORGN_SET_CODE_LIST, String ORGN_SET_NAME_, List<String> ORGN_SET_NAME_LIST, String ORGN_SET_STATUS_, List<String> ORGN_SET_STATUS_LIST, Boolean orgnSetRootOnly, Boolean recursive, Boolean includeSelf, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.idRequired");
        }

        String sql = "select * from OMV_ORGN_SET where 1 = 1";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);

        if (StringUtils.isNotEmpty(ORGN_SET_CODE_)) {
            sql += " and ORGN_SET_CODE_ = :ORGN_SET_CODE_";
            paramMap.put("ORGN_SET_CODE_", ORGN_SET_CODE_);
        }
        if (ORGN_SET_CODE_LIST != null && !ORGN_SET_CODE_LIST.isEmpty()) {
            sql += " and ORGN_SET_CODE_ in (:ORGN_SET_CODE_LIST)";
            paramMap.put("ORGN_SET_CODE_LIST", ORGN_SET_CODE_LIST);
        }
        if (StringUtils.isNotEmpty(ORGN_SET_NAME_)) {
            sql += " and ORGN_SET_NAME_ like '%' || :ORGN_SET_NAME_ || '%'";
            paramMap.put("ORGN_SET_NAME_", ORGN_SET_NAME_);
        }
        if (ORGN_SET_NAME_LIST != null && !ORGN_SET_NAME_LIST.isEmpty()) {
            sql += " and ORGN_SET_NAME_ in (:ORGN_SET_NAME_LIST)";
            paramMap.put("ORGN_SET_NAME_LIST", ORGN_SET_NAME_LIST);
        }
        if (StringUtils.isNotEmpty(ORGN_SET_STATUS_)) {
            sql += " and ORGN_SET_STATUS_ = :ORGN_SET_STATUS_";
            paramMap.put("ORGN_SET_STATUS_", ORGN_SET_STATUS_);
        }
        if (ORGN_SET_STATUS_LIST != null && !ORGN_SET_STATUS_LIST.isEmpty()) {
            sql += " and ORGN_SET_STATUS_ in (:ORGN_SET_STATUS_LIST)";
            paramMap.put("ORGN_SET_STATUS_LIST", ORGN_SET_STATUS_LIST);
        }

        if (orgnSetRootOnly != null && orgnSetRootOnly) {
            sql += " and (PARENT_ORGN_SET_ID_ is null or PARENT_ORGN_SET_ID_ = '')";
        }
        if (includeSelf == null || includeSelf.equals(false)) {
            sql += " and ORGN_SET_ID_ != :ORGN_SET_ID_";
        }
        if (recursive == null || recursive.equals(false)) {
            sql += " and (ORGN_SET_ID_ = (select PARENT_ORGN_SET_ID_ from OM_ORGN_SET where ORGN_SET_ID_ = :ORGN_SET_ID_) or ORGN_SET_ID_ = :ORGN_SET_ID_)";
        }
        else {
            sql += " connect by prior PARENT_ORGN_SET_ID_ = ORGN_SET_ID_ start with ORGN_SET_ID_ = :ORGN_SET_ID_";
        }

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForList(sql, paramMap);
    }

    @Override
    public List<Map<String, Object>> selectChildOrgnSet(String ORGN_SET_ID_, String ORGN_SET_CODE_, List<String> ORGN_SET_CODE_LIST, String ORGN_SET_NAME_, List<String> ORGN_SET_NAME_LIST, String ORGN_SET_STATUS_, List<String> ORGN_SET_STATUS_LIST, Boolean orgnSetRootOnly, Boolean recursive, Boolean includeSelf, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.idRequired");
        }

        String sql = "select * from OMV_ORGN_SET where 1 = 1";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);

        if (StringUtils.isNotEmpty(ORGN_SET_CODE_)) {
            sql += " and ORGN_SET_CODE_ = :ORGN_SET_CODE_";
            paramMap.put("ORGN_SET_CODE_", ORGN_SET_CODE_);
        }
        if (ORGN_SET_CODE_LIST != null && !ORGN_SET_CODE_LIST.isEmpty()) {
            sql += " and ORGN_SET_CODE_ in (:ORGN_SET_CODE_LIST)";
            paramMap.put("ORGN_SET_CODE_LIST", ORGN_SET_CODE_LIST);
        }
        if (StringUtils.isNotEmpty(ORGN_SET_NAME_)) {
            sql += " and ORGN_SET_NAME_ like '%' || :ORGN_SET_NAME_ || '%'";
            paramMap.put("ORGN_SET_NAME_", ORGN_SET_NAME_);
        }
        if (ORGN_SET_NAME_LIST != null && !ORGN_SET_NAME_LIST.isEmpty()) {
            sql += " and ORGN_SET_NAME_ in (:ORGN_SET_NAME_LIST)";
            paramMap.put("ORGN_SET_NAME_LIST", ORGN_SET_NAME_LIST);
        }
        if (StringUtils.isNotEmpty(ORGN_SET_STATUS_)) {
            sql += " and ORGN_SET_STATUS_ = :ORGN_SET_STATUS_";
            paramMap.put("ORGN_SET_STATUS_", ORGN_SET_STATUS_);
        }
        if (ORGN_SET_STATUS_LIST != null && !ORGN_SET_STATUS_LIST.isEmpty()) {
            sql += " and ORGN_SET_STATUS_ in (:ORGN_SET_STATUS_LIST)";
            paramMap.put("ORGN_SET_STATUS_LIST", ORGN_SET_STATUS_LIST);
        }

        if (orgnSetRootOnly != null && orgnSetRootOnly) {
            sql += " and (PARENT_ORGN_SET_ID_ is null or PARENT_ORGN_SET_ID_ = '')";
        }
        if (includeSelf == null || includeSelf.equals(false)) {
            sql += " and ORGN_SET_ID_ != :ORGN_SET_ID_";
        }
        if (recursive == null || recursive.equals(false)) {
            sql += " and (PARENT_ORGN_SET_ID_ = :ORGN_SET_ID_ or ORGN_SET_ID_ = :ORGN_SET_ID_)";
        }
        else {
            sql += " connect by prior ORGN_SET_ID_ = PARENT_ORGN_SET_ID_ start with ORGN_SET_ID_ = :ORGN_SET_ID_";
        }

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForList(sql, paramMap);
    }

    @Override
    public List<Map<String, Object>> selectOrgnSetByIdList(List<String> ORGN_SET_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (ORGN_SET_ID_LIST == null || ORGN_SET_ID_LIST.isEmpty()) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder(ORGN_SET_ID_LIST.size() * 50 + 200);
        Map<String, Object> paramMap = new HashMap<>();

        sql.append("select * from OMV_ORGN_SET where ORGN_SET_ID_ in (:ORGN_SET_ID_LIST)");
        paramMap.put("ORGN_SET_ID_LIST", ORGN_SET_ID_LIST);
        sql.append(" order by DECODE(ORGN_SET_ID_,");// 按主键列表顺序排序
        for (int i = 0; i < ORGN_SET_ID_LIST.size(); i++) {
            sql.append(" '").append(ORGN_SET_ID_LIST.get(i)).append("', ").append(i);
            if (i < ORGN_SET_ID_LIST.size() - 1) {
                sql.append(",");
            }
            else {
                sql.append(")");
            }
        }

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForList(sql.toString(), paramMap);
    }

    @Override
    public int insertOrgnSet(String ORGN_SET_ID_, String PARENT_ORGN_SET_ID_, String ORGN_SET_CODE_, String ORGN_SET_NAME_, String ALLOW_SYNC_, String MEMO_, Integer ORDER_, String ORGN_SET_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql = "insert into OM_ORGN_SET (ORGN_SET_ID_, PARENT_ORGN_SET_ID_, ORGN_SET_CODE_, ORGN_SET_NAME_, ALLOW_SYNC_, MEMO_, ORDER_, ORGN_SET_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return omJdbcTemplate.update(sql, ORGN_SET_ID_, PARENT_ORGN_SET_ID_, ORGN_SET_CODE_, ORGN_SET_NAME_, ALLOW_SYNC_, MEMO_, ORDER_, ORGN_SET_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_);
    }

    @Override
    public int updateOrgnSet(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORGN_SET_NAME_, String ALLOW_SYNC_, String MEMO_, Integer ORDER_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql = "update OM_ORGN_SET set ORGN_SET_CODE_ = ?, ORGN_SET_NAME_ = ?, ALLOW_SYNC_ = ?, MEMO_ = ?, ORDER_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ?";
        return omJdbcTemplate.update(sql, ORGN_SET_CODE_, ORGN_SET_NAME_, ALLOW_SYNC_, MEMO_, ORDER_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_);
    }

    @Override
    public int updateOrgnSetOrder(final List<String> ORGN_SET_ID_LIST, final List<Integer> ORDER_LIST, final Date UPDATE_DATE_, final String OPERATOR_ID_, final String OPERATOR_NAME_) {
        if (ORGN_SET_ID_LIST == null || ORGN_SET_ID_LIST.isEmpty()) {
            return 0;
        }
        if (ORGN_SET_ID_LIST.size() != ORDER_LIST.size()) {
            return 0;
        }

        String sql = "update OM_ORGN_SET set ORDER_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ?";
        BatchPreparedStatementSetter batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, ORDER_LIST.get(i));
                ps.setTimestamp(2, UPDATE_DATE_ == null ? null : new java.sql.Timestamp(UPDATE_DATE_.getTime()));
                ps.setString(3, OPERATOR_ID_);
                ps.setString(4, OPERATOR_NAME_);
                ps.setString(5, ORGN_SET_ID_LIST.get(i));
            }

            public int getBatchSize() {
                return ORGN_SET_ID_LIST.size();
            }
        };

        return omJdbcTemplate.batchUpdate(sql, batch).length;
    }

    @Override
    public int moveOrgnSet(String ORGN_SET_ID_, String PARENT_ORGN_SET_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql = "update OM_ORGN_SET set PARENT_ORGN_SET_ID_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and not exists (select 1 from OM_ORGN_SET where ORGN_SET_ID_ = ? connect by prior ORGN_SET_ID_ = PARENT_ORGN_SET_ID_ start with ORGN_SET_ID_ = ?)";
        return omJdbcTemplate.update(sql, PARENT_ORGN_SET_ID_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, PARENT_ORGN_SET_ID_, ORGN_SET_ID_);
    }

    @Override
    public int disableOrgnSet(String ORGN_SET_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql = "update OM_ORGN_SET set ORGN_SET_STATUS_ = '0', UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ?";
        return omJdbcTemplate.update(sql, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_);
    }

    @Override
    public int enableOrgnSet(String ORGN_SET_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql = "update OM_ORGN_SET set ORGN_SET_STATUS_ = '1', UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ?";
        return omJdbcTemplate.update(sql, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_);
    }

    @Override
    public int deleteOrgnSet(String ORGN_SET_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql = "delete from OM_ORGN_SET where ORGN_SET_ID_ = ?";
        return omJdbcTemplate.update(sql, ORGN_SET_ID_);
    }

    @Override
    public int trunkOrgnSet(String ORGN_SET_ID_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql;

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
        sql = "delete from OM_ORG where ORGN_SET_ID_ = ?";
        omJdbcTemplate.update(sql, ORGN_SET_ID_);
        sql = "delete from OM_DUTY where ORGN_SET_ID_ = ?";
        omJdbcTemplate.update(sql, ORGN_SET_ID_);
        sql = "delete from OM_ORGN_SET where ORGN_SET_ID_ = ?";
        omJdbcTemplate.update(sql, ORGN_SET_ID_);

        return 1;
    }

    @Override
    public int copyOrgnSet(String BASE_ORGN_SET_ID_, final String ORGN_SET_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql;
        BatchPreparedStatementSetter batch;

        omJdbcTemplate.execute("alter table OM_ORG disable constraint FK_OM_ORG_PARENT");

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

        final List<Map<String, Object>> orgList = omJdbcTemplate.queryForList("select * from (select * from OM_ORG where ORGN_SET_ID_ = ?) connect by prior ORG_ID_ = PARENT_ORG_ID_ start with PARENT_ORG_ID_ is null", BASE_ORGN_SET_ID_);
        sql = "insert into OM_ORG (ORGN_SET_ID_, ORG_ID_, PARENT_ORG_ID_, ORG_CODE_, ORG_NAME_, ORG_ABBR_NAME_, ORG_TYPE_, ORG_CATEGORY_, MEMO_, ORG_TAG_, ORG_EXT_ATTR_1_, ORG_EXT_ATTR_2_, ORG_EXT_ATTR_3_, ORG_EXT_ATTR_4_, ORG_EXT_ATTR_5_, ORG_EXT_ATTR_6_, ORG_EXT_ATTR_7_, ORG_EXT_ATTR_8_, ORDER_, ORG_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Map<String, Object> org = orgList.get(i);
                ps.setObject(1, ORGN_SET_ID_);
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

        final List<Map<String, Object>> dutyList = omJdbcTemplate.queryForList("select * from OM_DUTY where ORGN_SET_ID_ = ?", BASE_ORGN_SET_ID_);
        sql = "insert into OM_DUTY (ORGN_SET_ID_, DUTY_ID_, DUTY_CODE_, DUTY_NAME_, DUTY_CATEGORY_, MEMO_, DUTY_TAG_, DUTY_EXT_ATTR_1_, DUTY_EXT_ATTR_2_, DUTY_EXT_ATTR_3_, DUTY_EXT_ATTR_4_, DUTY_EXT_ATTR_5_, DUTY_EXT_ATTR_6_, DUTY_EXT_ATTR_7_, DUTY_EXT_ATTR_8_, ORDER_, DUTY_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Map<String, Object> duty = dutyList.get(i);
                ps.setObject(1, ORGN_SET_ID_);
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

        final List<Map<String, Object>> posiList = omJdbcTemplate.queryForList("select * from OM_POSI where ORGN_SET_ID_ = ?", BASE_ORGN_SET_ID_);
        sql = "insert into OM_POSI (ORGN_SET_ID_, POSI_ID_, ORG_ID_, DUTY_ID_, POSI_CODE_, POSI_NAME_, ORG_LEADER_TYPE_, POSI_CATEGORY_, MEMO_, POSI_TAG_, POSI_EXT_ATTR_1_, POSI_EXT_ATTR_2_, POSI_EXT_ATTR_3_, POSI_EXT_ATTR_4_, POSI_EXT_ATTR_5_, POSI_EXT_ATTR_6_, POSI_EXT_ATTR_7_, POSI_EXT_ATTR_8_, ORDER_, POSI_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Map<String, Object> posi = posiList.get(i);
                ps.setObject(1, ORGN_SET_ID_);
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

        final List<Map<String, Object>> empList = omJdbcTemplate.queryForList("select * from OM_EMP where ORGN_SET_ID_ = ?", BASE_ORGN_SET_ID_);
        sql = "insert into OM_EMP (ORGN_SET_ID_, EMP_ID_, ORG_ID_, EMP_CODE_, EMP_NAME_, PASSWORD_, PASSWORD_RESET_REQ_, PARTY_, EMP_LEVEL_, GENDER_, BIRTH_DATE_, TEL_, EMAIL_, IN_DATE_, OUT_DATE_, EMP_CATEGORY_, MEMO_, EMP_TAG_, EMP_EXT_ATTR_1_, EMP_EXT_ATTR_2_, EMP_EXT_ATTR_3_, EMP_EXT_ATTR_4_, EMP_EXT_ATTR_5_, EMP_EXT_ATTR_6_, EMP_EXT_ATTR_7_, EMP_EXT_ATTR_8_, ORDER_, EMP_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Map<String, Object> emp = empList.get(i);
                ps.setObject(1, ORGN_SET_ID_);
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

        final List<Map<String, Object>> posiEmpList = omJdbcTemplate.queryForList("select * from OM_POSI_EMP where ORGN_SET_ID_ = ?", BASE_ORGN_SET_ID_);
        sql = "insert into OM_POSI_EMP (ORGN_SET_ID_, POSI_EMP_ID_, POSI_ID_, EMP_ID_, MAIN_, POSI_EMP_CATEGORY_, MEMO_, POSI_EMP_TAG_, POSI_EMP_EXT_ATTR_1_, POSI_EMP_EXT_ATTR_2_, POSI_EMP_EXT_ATTR_3_, POSI_EMP_EXT_ATTR_4_, POSI_EMP_EXT_ATTR_5_, POSI_EMP_EXT_ATTR_6_, POSI_EMP_EXT_ATTR_7_, POSI_EMP_EXT_ATTR_8_, ORDER_, POSI_EMP_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Map<String, Object> posiEmp = posiEmpList.get(i);
                ps.setObject(1, ORGN_SET_ID_);
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

        final List<Map<String, Object>> empRelationList = omJdbcTemplate.queryForList("select * from OM_EMP_RELATION where ORGN_SET_ID_ = ?", BASE_ORGN_SET_ID_);
        sql = "insert into OM_EMP_RELATION (ORGN_SET_ID_, EMP_RELATION_ID_, UPPER_EMP_ID_, LOWER_EMP_ID_, EMP_RELATION_, EMP_RELATION_CATEGORY_, MEMO_, EMP_RELATION_TAG_, EMP_RELATION_EXT_ATTR_1_, EMP_RELATION_EXT_ATTR_2_, EMP_RELATION_EXT_ATTR_3_, EMP_RELATION_EXT_ATTR_4_, EMP_RELATION_EXT_ATTR_5_, EMP_RELATION_EXT_ATTR_6_, EMP_RELATION_EXT_ATTR_7_, EMP_RELATION_EXT_ATTR_8_, ORDER_, EMP_RELATION_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Map<String, Object> empRelation = empRelationList.get(i);
                ps.setObject(1, ORGN_SET_ID_);
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

        final List<Map<String, Object>> tagList = omJdbcTemplate.queryForList("select * from OM_TAG where ORGN_SET_ID_ = ?", BASE_ORGN_SET_ID_);
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

        omJdbcTemplate.execute("alter table OM_ORG enable constraint FK_OM_ORG_PARENT");

        return 1;
    }

    @Override
    public OrgnChange compareOrgnSet(String BASE_ORGN_SET_ID_, String ORGN_SET_ID_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OrgnChange orgnChange = new OrgnChange();

        String sql;

        sql = "select * from (select * from OM_ORG where ORGN_SET_ID_ = ?) connect by prior ORG_ID_ = PARENT_ORG_ID_ start with PARENT_ORG_ID_ is null";
        List<Map<String, Object>> insertOrgList = new ArrayList<>();
        List<Map<String, Object>> updateOrgList = new ArrayList<>();
        List<Map<String, Object>> deleteOrgList = new ArrayList<>();
        List<Map<String, Object>> orgList = omJdbcTemplate.queryForList(sql, BASE_ORGN_SET_ID_);
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
                if ((org.get("PARENT_ORG_ID_") == null && mirrorServerOrg.get("PARENT_ORG_ID_") != null) || (org.get("PARENT_ORG_ID_") != null && !org.get("PARENT_ORG_ID_").equals(mirrorServerOrg.get("PARENT_ORG_ID_"))) || (org.get("ORG_CODE_") == null && mirrorServerOrg.get("ORG_CODE_") != null) || (org.get("ORG_CODE_") != null && !org.get("ORG_CODE_").equals(mirrorServerOrg.get("ORG_CODE_"))) || (org.get("ORG_NAME_") == null && mirrorServerOrg.get("ORG_NAME_") != null) || (org.get("ORG_NAME_") != null && !org.get("ORG_NAME_").equals(mirrorServerOrg.get("ORG_NAME_"))) || (org.get("ORG_ABBR_NAME_") == null && mirrorServerOrg.get("ORG_ABBR_NAME_") != null) || (org.get("ORG_ABBR_NAME_") != null && !org.get("ORG_ABBR_NAME_").equals(mirrorServerOrg.get("ORG_ABBR_NAME_")))
                        || (org.get("ORG_TYPE_") == null && mirrorServerOrg.get("ORG_TYPE_") != null) || (org.get("ORG_TYPE_") != null && !org.get("ORG_TYPE_").equals(mirrorServerOrg.get("ORG_TYPE_"))) || (org.get("ORG_CATEGORY_") == null && mirrorServerOrg.get("ORG_CATEGORY_") != null) || (org.get("ORG_CATEGORY_") != null && !org.get("ORG_CATEGORY_").equals(mirrorServerOrg.get("ORG_CATEGORY_"))) || (org.get("MEMO_") == null && mirrorServerOrg.get("MEMO_") != null) || (org.get("MEMO_") != null && !org.get("MEMO_").equals(mirrorServerOrg.get("MEMO_"))) || (org.get("ORDER_") == null && mirrorServerOrg.get("ORDER_") != null) || (org.get("ORDER_") != null && !org.get("ORDER_").equals(mirrorServerOrg.get("ORDER_")))
                        || (org.get("ORG_STATUS_") == null && mirrorServerOrg.get("ORG_STATUS_") != null) || (org.get("ORG_STATUS_") != null && !org.get("ORG_STATUS_").equals(mirrorServerOrg.get("ORG_STATUS_"))) || (org.get("CREATION_DATE_") == null && mirrorServerOrg.get("CREATION_DATE_") != null) || (org.get("CREATION_DATE_") != null && !org.get("CREATION_DATE_").equals(mirrorServerOrg.get("CREATION_DATE_")))) {
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
        List<Map<String, Object>> dutyList = omJdbcTemplate.queryForList(sql, BASE_ORGN_SET_ID_);
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
                if ((duty.get("DUTY_CODE_") == null && mirrorServerDuty.get("DUTY_CODE_") != null) || (duty.get("DUTY_CODE_") != null && !duty.get("DUTY_CODE_").equals(mirrorServerDuty.get("DUTY_CODE_"))) || (duty.get("DUTY_NAME_") == null && mirrorServerDuty.get("DUTY_NAME_") != null) || (duty.get("DUTY_NAME_") != null && !duty.get("DUTY_NAME_").equals(mirrorServerDuty.get("DUTY_NAME_"))) || (duty.get("DUTY_CATEGORY_") == null && mirrorServerDuty.get("DUTY_CATEGORY_") != null) || (duty.get("DUTY_CATEGORY_") != null && !duty.get("DUTY_CATEGORY_").equals(mirrorServerDuty.get("DUTY_CATEGORY_"))) || (duty.get("MEMO_") == null && mirrorServerDuty.get("MEMO_") != null) || (duty.get("MEMO_") != null && !duty.get("MEMO_").equals(mirrorServerDuty.get("MEMO_")))
                        || (duty.get("ORDER_") == null && mirrorServerDuty.get("ORDER_") != null) || (duty.get("ORDER_") != null && !duty.get("ORDER_").equals(mirrorServerDuty.get("ORDER_"))) || (duty.get("DUTY_STATUS_") == null && mirrorServerDuty.get("DUTY_STATUS_") != null) || (duty.get("DUTY_STATUS_") != null && !duty.get("DUTY_STATUS_").equals(mirrorServerDuty.get("DUTY_STATUS_"))) || (duty.get("CREATION_DATE_") == null && mirrorServerDuty.get("CREATION_DATE_") != null) || (duty.get("CREATION_DATE_") != null && !duty.get("CREATION_DATE_").equals(mirrorServerDuty.get("CREATION_DATE_")))) {
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
        List<Map<String, Object>> posiList = omJdbcTemplate.queryForList(sql, BASE_ORGN_SET_ID_);
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
                if ((posi.get("ORG_ID_") == null && mirrorServerPosi.get("ORG_ID_") != null) || (posi.get("ORG_ID_") != null && !posi.get("ORG_ID_").equals(mirrorServerPosi.get("ORG_ID_"))) || (posi.get("DUTY_ID_") == null && mirrorServerPosi.get("DUTY_ID_") != null) || (posi.get("DUTY_ID_") != null && !posi.get("DUTY_ID_").equals(mirrorServerPosi.get("DUTY_ID_"))) || (posi.get("POSI_CODE_") == null && mirrorServerPosi.get("POSI_CODE_") != null) || (posi.get("POSI_CODE_") != null && !posi.get("POSI_CODE_").equals(mirrorServerPosi.get("POSI_CODE_"))) || (posi.get("POSI_NAME_") == null && mirrorServerPosi.get("POSI_NAME_") != null) || (posi.get("POSI_NAME_") != null && !posi.get("POSI_NAME_").equals(mirrorServerPosi.get("POSI_NAME_")))
                        || (posi.get("ORG_LEADER_TYPE_") == null && mirrorServerPosi.get("ORG_LEADER_TYPE_") != null) || (posi.get("ORG_LEADER_TYPE_") != null && !posi.get("ORG_LEADER_TYPE_").equals(mirrorServerPosi.get("ORG_LEADER_TYPE_"))) || (posi.get("POSI_CATEGORY_") == null && mirrorServerPosi.get("POSI_CATEGORY_") != null) || (posi.get("POSI_CATEGORY_") != null && !posi.get("POSI_CATEGORY_").equals(mirrorServerPosi.get("POSI_CATEGORY_"))) || (posi.get("MEMO_") == null && mirrorServerPosi.get("MEMO_") != null) || (posi.get("MEMO_") != null && !posi.get("MEMO_").equals(mirrorServerPosi.get("MEMO_"))) || (posi.get("ORDER_") == null && mirrorServerPosi.get("ORDER_") != null) || (posi.get("ORDER_") != null && !posi.get("ORDER_").equals(mirrorServerPosi.get("ORDER_")))
                        || (posi.get("POSI_STATUS_") == null && mirrorServerPosi.get("POSI_STATUS_") != null) || (posi.get("POSI_STATUS_") != null && !posi.get("POSI_STATUS_").equals(mirrorServerPosi.get("POSI_STATUS_"))) || (posi.get("CREATION_DATE_") == null && mirrorServerPosi.get("CREATION_DATE_") != null) || (posi.get("CREATION_DATE_") != null && !posi.get("CREATION_DATE_").equals(mirrorServerPosi.get("CREATION_DATE_")))) {
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
        List<Map<String, Object>> empList = omJdbcTemplate.queryForList(sql, BASE_ORGN_SET_ID_);
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
                if ((emp.get("ORG_ID_") == null && mirrorServerEmp.get("ORG_ID_") != null) || (emp.get("ORG_ID_") != null && !emp.get("ORG_ID_").equals(mirrorServerEmp.get("ORG_ID_"))) || (emp.get("EMP_CODE_") == null && mirrorServerEmp.get("EMP_CODE_") != null) || (emp.get("EMP_CODE_") != null && !emp.get("EMP_CODE_").equals(mirrorServerEmp.get("EMP_CODE_"))) || (emp.get("EMP_NAME_") == null && mirrorServerEmp.get("EMP_NAME_") != null) || (emp.get("EMP_NAME_") != null && !emp.get("EMP_NAME_").equals(mirrorServerEmp.get("EMP_NAME_"))) || (emp.get("PARTY_") == null && mirrorServerEmp.get("PARTY_") != null) || (emp.get("PARTY_") != null && !emp.get("PARTY_").equals(mirrorServerEmp.get("PARTY_"))) || (emp.get("EMP_LEVEL_") == null && mirrorServerEmp.get("EMP_LEVEL_") != null)
                        || (emp.get("EMP_LEVEL_") != null && !emp.get("EMP_LEVEL_").equals(mirrorServerEmp.get("EMP_LEVEL_"))) || (emp.get("GENDER_") == null && mirrorServerEmp.get("GENDER_") != null) || (emp.get("GENDER_") != null && !emp.get("GENDER_").equals(mirrorServerEmp.get("GENDER_"))) || (emp.get("BIRTH_DATE_") == null && mirrorServerEmp.get("BIRTH_DATE_") != null) || (emp.get("BIRTH_DATE_") != null && !emp.get("BIRTH_DATE_").equals(mirrorServerEmp.get("BIRTH_DATE_"))) || (emp.get("TEL_") == null && mirrorServerEmp.get("TEL_") != null) || (emp.get("TEL_") != null && !emp.get("TEL_").equals(mirrorServerEmp.get("TEL_"))) || (emp.get("EMAIL_") == null && mirrorServerEmp.get("EMAIL_") != null) || (emp.get("EMAIL_") != null && !emp.get("EMAIL_").equals(mirrorServerEmp.get("EMAIL_")))
                        || (emp.get("IN_DATE_") == null && mirrorServerEmp.get("IN_DATE_") != null) || (emp.get("IN_DATE_") != null && !emp.get("IN_DATE_").equals(mirrorServerEmp.get("IN_DATE_"))) || (emp.get("OUT_DATE_") == null && mirrorServerEmp.get("OUT_DATE_") != null) || (emp.get("OUT_DATE_") != null && !emp.get("OUT_DATE_").equals(mirrorServerEmp.get("OUT_DATE_"))) || (emp.get("EMP_CATEGORY_") == null && mirrorServerEmp.get("EMP_CATEGORY_") != null) || (emp.get("EMP_CATEGORY_") != null && !emp.get("EMP_CATEGORY_").equals(mirrorServerEmp.get("EMP_CATEGORY_"))) || (emp.get("MEMO_") == null && mirrorServerEmp.get("MEMO_") != null) || (emp.get("MEMO_") != null && !emp.get("MEMO_").equals(mirrorServerEmp.get("MEMO_")))
                        || (emp.get("ORDER_") == null && mirrorServerEmp.get("ORDER_") != null) || (emp.get("ORDER_") != null && !emp.get("ORDER_").equals(mirrorServerEmp.get("ORDER_"))) || (emp.get("EMP_STATUS_") == null && mirrorServerEmp.get("EMP_STATUS_") != null) || (emp.get("EMP_STATUS_") != null && !emp.get("EMP_STATUS_").equals(mirrorServerEmp.get("EMP_STATUS_"))) || (emp.get("CREATION_DATE_") == null && mirrorServerEmp.get("CREATION_DATE_") != null) || (emp.get("CREATION_DATE_") != null && !emp.get("CREATION_DATE_").equals(mirrorServerEmp.get("CREATION_DATE_")))) {
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
        List<Map<String, Object>> posiEmpList = omJdbcTemplate.queryForList(sql, BASE_ORGN_SET_ID_);
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
                if ((posiEmp.get("POSI_ID_") == null && mirrorServerPosiEmp.get("POSI_ID_") != null) || (posiEmp.get("POSI_ID_") != null && !posiEmp.get("POSI_ID_").equals(mirrorServerPosiEmp.get("POSI_ID_"))) || (posiEmp.get("EMP_ID_") == null && mirrorServerPosiEmp.get("EMP_ID_") != null) || (posiEmp.get("EMP_ID_") != null && !posiEmp.get("EMP_ID_").equals(mirrorServerPosiEmp.get("EMP_ID_"))) || (posiEmp.get("MAIN_") == null && mirrorServerPosiEmp.get("MAIN_") != null) || (posiEmp.get("MAIN_") != null && !posiEmp.get("MAIN_").equals(mirrorServerPosiEmp.get("MAIN_"))) || (posiEmp.get("POSI_EMP_STATUS_") == null && mirrorServerPosiEmp.get("POSI_EMP_STATUS_") != null)
                        || (posiEmp.get("POSI_EMP_STATUS_") != null && !posiEmp.get("POSI_EMP_STATUS_").equals(mirrorServerPosiEmp.get("POSI_EMP_STATUS_"))) || (posiEmp.get("CREATION_DATE_") == null && mirrorServerPosiEmp.get("CREATION_DATE_") != null) || (posiEmp.get("CREATION_DATE_") != null && !posiEmp.get("CREATION_DATE_").equals(mirrorServerPosiEmp.get("CREATION_DATE_")))) {
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
        List<Map<String, Object>> empRelationList = omJdbcTemplate.queryForList(sql, BASE_ORGN_SET_ID_);
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
                if ((empRelation.get("UPPER_EMP_ID_") == null && mirrorServerEmpRelation.get("UPPER_EMP_ID_") != null) || (empRelation.get("UPPER_EMP_ID_") != null && !empRelation.get("UPPER_EMP_ID_").equals(mirrorServerEmpRelation.get("UPPER_EMP_ID_"))) || (empRelation.get("LOWER_EMP_ID_") == null && mirrorServerEmpRelation.get("LOWER_EMP_ID_") != null) || (empRelation.get("LOWER_EMP_ID_") != null && !empRelation.get("LOWER_EMP_ID_").equals(mirrorServerEmpRelation.get("LOWER_EMP_ID_"))) || (empRelation.get("EMP_RELATION_") == null && mirrorServerEmpRelation.get("EMP_RELATION_") != null) || (empRelation.get("EMP_RELATION_") != null && !empRelation.get("EMP_RELATION_").equals(mirrorServerEmpRelation.get("EMP_RELATION_")))
                        || (empRelation.get("MEMO_") == null && mirrorServerEmpRelation.get("MEMO_") != null) || (empRelation.get("MEMO_") != null && !empRelation.get("MEMO_").equals(mirrorServerEmpRelation.get("MEMO_"))) || (empRelation.get("ORDER_") == null && mirrorServerEmpRelation.get("ORDER_") != null) || (empRelation.get("ORDER_") != null && !empRelation.get("ORDER_").equals(mirrorServerEmpRelation.get("ORDER_"))) || (empRelation.get("EMP_RELATION_STATUS_") == null && mirrorServerEmpRelation.get("EMP_RELATION_STATUS_") != null) || (empRelation.get("EMP_RELATION_STATUS_") != null && !empRelation.get("EMP_RELATION_STATUS_").equals(mirrorServerEmpRelation.get("EMP_RELATION_STATUS_")))
                        || (empRelation.get("CREATION_DATE_") == null && mirrorServerEmpRelation.get("CREATION_DATE_") != null) || (empRelation.get("CREATION_DATE_") != null && !empRelation.get("CREATION_DATE_").equals(mirrorServerEmpRelation.get("CREATION_DATE_")))) {
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
    public int replaceOrgnSet(String BASE_ORGN_SET_ID_, final String ORGN_SET_ID_, List<String> INSERT_ORG_ID_LIST, List<String> UPDATE_ORG_ID_LIST, List<String> DELETE_ORG_ID_LIST, List<String> INSERT_DUTY_ID_LIST, List<String> UPDATE_DUTY_ID_LIST, List<String> DELETE_DUTY_ID_LIST, List<String> INSERT_POSI_ID_LIST, List<String> UPDATE_POSI_ID_LIST, List<String> DELETE_POSI_ID_LIST, List<String> INSERT_EMP_ID_LIST, List<String> UPDATE_EMP_ID_LIST, List<String> DELETE_EMP_ID_LIST, List<String> INSERT_POSI_EMP_ID_LIST, List<String> UPDATE_POSI_EMP_ID_LIST, List<String> DELETE_POSI_EMP_ID_LIST, List<String> INSERT_EMP_RELATION_ID_LIST, List<String> UPDATE_EMP_RELATION_ID_LIST, List<String> DELETE_EMP_RELATION_ID_LIST, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql;
        BatchPreparedStatementSetter batch;
        NamedParameterJdbcTemplate namedParameterMirrorServerJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        Map<String, Object> paramMap = new HashMap<>();

        omJdbcTemplate.execute("alter table OM_ORG disable constraint FK_OM_ORG_PARENT");

        final List<Map<String, Object>> insertOrgList = omOrgService.selectProtoOrgByIdList(BASE_ORGN_SET_ID_, INSERT_ORG_ID_LIST, OPERATOR_ID_, OPERATOR_NAME_);
        final List<Map<String, Object>> insertDutyList = omDutyService.selectProtoDutyByIdList(BASE_ORGN_SET_ID_, INSERT_DUTY_ID_LIST, OPERATOR_ID_, OPERATOR_NAME_);
        final List<Map<String, Object>> insertPosiList = omPosiService.selectProtoPosiByIdList(BASE_ORGN_SET_ID_, INSERT_POSI_ID_LIST, OPERATOR_ID_, OPERATOR_NAME_);
        final List<Map<String, Object>> insertEmpList = omEmpService.selectProtoEmpByIdList(BASE_ORGN_SET_ID_, INSERT_EMP_ID_LIST, OPERATOR_ID_, OPERATOR_NAME_);
        final List<Map<String, Object>> insertPosiEmpList = omPosiEmpService.selectProtoPosiEmpByIdList(BASE_ORGN_SET_ID_, INSERT_POSI_EMP_ID_LIST, OPERATOR_ID_, OPERATOR_NAME_);
        final List<Map<String, Object>> insertEmpRelationList = omEmpRelationService.selectProtoEmpRelationByIdList(BASE_ORGN_SET_ID_, INSERT_EMP_RELATION_ID_LIST, OPERATOR_ID_, OPERATOR_NAME_);
        final List<Map<String, Object>> updateOrgList = omOrgService.selectProtoOrgByIdList(BASE_ORGN_SET_ID_, UPDATE_ORG_ID_LIST, OPERATOR_ID_, OPERATOR_NAME_);
        final List<Map<String, Object>> updateDutyList = omDutyService.selectProtoDutyByIdList(BASE_ORGN_SET_ID_, UPDATE_DUTY_ID_LIST, OPERATOR_ID_, OPERATOR_NAME_);
        final List<Map<String, Object>> updatePosiList = omPosiService.selectProtoPosiByIdList(BASE_ORGN_SET_ID_, UPDATE_POSI_ID_LIST, OPERATOR_ID_, OPERATOR_NAME_);
        final List<Map<String, Object>> updateEmpList = omEmpService.selectProtoEmpByIdList(BASE_ORGN_SET_ID_, UPDATE_EMP_ID_LIST, OPERATOR_ID_, OPERATOR_NAME_);
        final List<Map<String, Object>> updatePosiEmpList = omPosiEmpService.selectProtoPosiEmpByIdList(BASE_ORGN_SET_ID_, UPDATE_POSI_EMP_ID_LIST, OPERATOR_ID_, OPERATOR_NAME_);
        final List<Map<String, Object>> updateEmpRelationList = omEmpRelationService.selectProtoEmpRelationByIdList(BASE_ORGN_SET_ID_, UPDATE_EMP_RELATION_ID_LIST, OPERATOR_ID_, OPERATOR_NAME_);

        // 删除TAG
        int cycle;
        int startIndex;
        int endIndex;
        List<String> OBJ_ID_LIST = new ArrayList<>();
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
        sql = "insert into OM_ORG (ORGN_SET_ID_, ORG_ID_, PARENT_ORG_ID_, ORG_CODE_, ORG_NAME_, ORG_ABBR_NAME_, ORG_TYPE_, ORG_CATEGORY_, MEMO_, ORG_TAG_, ORG_EXT_ATTR_1_, ORG_EXT_ATTR_2_, ORG_EXT_ATTR_3_, ORG_EXT_ATTR_4_, ORG_EXT_ATTR_5_, ORG_EXT_ATTR_6_, ORG_EXT_ATTR_7_, ORG_EXT_ATTR_8_, ORDER_, ORG_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Map<String, Object> org = insertOrgList.get(i);
                ps.setObject(1, ORGN_SET_ID_);
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
        sql = "insert into OM_DUTY (ORGN_SET_ID_, DUTY_ID_, DUTY_CODE_, DUTY_NAME_, DUTY_CATEGORY_, MEMO_, DUTY_TAG_, DUTY_EXT_ATTR_1_, DUTY_EXT_ATTR_2_, DUTY_EXT_ATTR_3_, DUTY_EXT_ATTR_4_, DUTY_EXT_ATTR_5_, DUTY_EXT_ATTR_6_, DUTY_EXT_ATTR_7_, DUTY_EXT_ATTR_8_, ORDER_, DUTY_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Map<String, Object> duty = insertDutyList.get(i);
                ps.setObject(1, ORGN_SET_ID_);
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
        sql = "insert into OM_POSI (ORGN_SET_ID_, POSI_ID_, ORG_ID_, DUTY_ID_, POSI_CODE_, POSI_NAME_, ORG_LEADER_TYPE_, POSI_CATEGORY_, MEMO_, POSI_TAG_, POSI_EXT_ATTR_1_, POSI_EXT_ATTR_2_, POSI_EXT_ATTR_3_, POSI_EXT_ATTR_4_, POSI_EXT_ATTR_5_, POSI_EXT_ATTR_6_, POSI_EXT_ATTR_7_, POSI_EXT_ATTR_8_, ORDER_, POSI_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Map<String, Object> posi = insertPosiList.get(i);
                ps.setObject(1, ORGN_SET_ID_);
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
        sql = "insert into OM_EMP (ORGN_SET_ID_, EMP_ID_, ORG_ID_, EMP_CODE_, EMP_NAME_, PASSWORD_, PASSWORD_RESET_REQ_, PARTY_, EMP_LEVEL_, GENDER_, BIRTH_DATE_, TEL_, EMAIL_, IN_DATE_, OUT_DATE_, EMP_CATEGORY_, MEMO_, EMP_TAG_, EMP_EXT_ATTR_1_, EMP_EXT_ATTR_2_, EMP_EXT_ATTR_3_, EMP_EXT_ATTR_4_, EMP_EXT_ATTR_5_, EMP_EXT_ATTR_6_, EMP_EXT_ATTR_7_, EMP_EXT_ATTR_8_, ORDER_, EMP_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Map<String, Object> emp = insertEmpList.get(i);
                ps.setObject(1, ORGN_SET_ID_);
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
        sql = "insert into OM_POSI_EMP (ORGN_SET_ID_, POSI_EMP_ID_, POSI_ID_, EMP_ID_, MAIN_, POSI_EMP_CATEGORY_, MEMO_, POSI_EMP_TAG_, POSI_EMP_EXT_ATTR_1_, POSI_EMP_EXT_ATTR_2_, POSI_EMP_EXT_ATTR_3_, POSI_EMP_EXT_ATTR_4_, POSI_EMP_EXT_ATTR_5_, POSI_EMP_EXT_ATTR_6_, POSI_EMP_EXT_ATTR_7_, POSI_EMP_EXT_ATTR_8_, ORDER_, POSI_EMP_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Map<String, Object> posiEmp = insertPosiEmpList.get(i);
                ps.setObject(1, ORGN_SET_ID_);
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
        sql = "insert into OM_EMP_RELATION (ORGN_SET_ID_, EMP_RELATION_ID_, UPPER_EMP_ID_, LOWER_EMP_ID_, EMP_RELATION_, EMP_RELATION_CATEGORY_, MEMO_, EMP_RELATION_TAG_, EMP_RELATION_EXT_ATTR_1_, EMP_RELATION_EXT_ATTR_2_, EMP_RELATION_EXT_ATTR_3_, EMP_RELATION_EXT_ATTR_4_, EMP_RELATION_EXT_ATTR_5_, EMP_RELATION_EXT_ATTR_6_, EMP_RELATION_EXT_ATTR_7_, EMP_RELATION_EXT_ATTR_8_, ORDER_, EMP_RELATION_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Map<String, Object> empRelation = insertEmpRelationList.get(i);
                ps.setObject(1, ORGN_SET_ID_);
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

        // 修改
        sql = "update OM_ORG set PARENT_ORG_ID_ = ?, ORG_CODE_ = ?, ORG_NAME_ = ?, ORG_ABBR_NAME_ = ?, ORG_TYPE_ = ?, ORG_CATEGORY_ = ?, MEMO_ = ?, ORDER_ = ?, ORG_STATUS_ = ?, CREATION_DATE_ = ? where ORGN_SET_ID_ = ? and ORG_ID_ = ?";
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
                ps.setObject(8, org.get("ORDER_"));
                ps.setObject(9, org.get("ORG_STATUS_"));
                ps.setObject(10, org.get("CREATION_DATE_"));
                ps.setObject(11, ORGN_SET_ID_);
                ps.setObject(12, org.get("ORG_ID_"));
            }

            public int getBatchSize() {
                return updateOrgList.size();
            }
        };
        omJdbcTemplate.batchUpdate(sql, batch);
        sql = "update OM_DUTY set DUTY_CODE_ = ?, DUTY_NAME_ = ?, DUTY_CATEGORY_ = ?, MEMO_ = ?, ORDER_ = ?, DUTY_STATUS_ = ?, CREATION_DATE_ = ? where ORGN_SET_ID_ = ? and DUTY_ID_ = ?";
        batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Map<String, Object> duty = updateDutyList.get(i);
                ps.setObject(1, duty.get("DUTY_CODE_"));
                ps.setObject(2, duty.get("DUTY_NAME_"));
                ps.setObject(3, duty.get("DUTY_CATEGORY_"));
                ps.setObject(4, duty.get("MEMO_"));
                ps.setObject(5, duty.get("ORDER_"));
                ps.setObject(6, duty.get("DUTY_STATUS_"));
                ps.setObject(7, duty.get("CREATION_DATE_"));
                ps.setObject(8, ORGN_SET_ID_);
                ps.setObject(9, duty.get("DUTY_ID_"));
            }

            public int getBatchSize() {
                return updateDutyList.size();
            }
        };
        omJdbcTemplate.batchUpdate(sql, batch);
        sql = "update OM_POSI set ORG_ID_ = ?, DUTY_ID_ = ?, POSI_CODE_ = ?, POSI_NAME_ = ?, ORG_LEADER_TYPE_ = ?, POSI_CATEGORY_ = ?, MEMO_ = ?, ORDER_ = ?, POSI_STATUS_ = ?, CREATION_DATE_ = ? where ORGN_SET_ID_ = ? and POSI_ID_ = ?";
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
                ps.setObject(8, posi.get("ORDER_"));
                ps.setObject(9, posi.get("POSI_STATUS_"));
                ps.setObject(10, posi.get("CREATION_DATE_"));
                ps.setObject(11, ORGN_SET_ID_);
                ps.setObject(12, posi.get("POSI_ID_"));
            }

            public int getBatchSize() {
                return updatePosiList.size();
            }
        };
        omJdbcTemplate.batchUpdate(sql, batch);
        sql = "update OM_EMP set ORG_ID_ = ?, EMP_CODE_ = ?, EMP_NAME_ = ?, PARTY_ = ?, EMP_LEVEL_ = ?, GENDER_ = ?, BIRTH_DATE_ = ?, TEL_ = ?, EMAIL_ = ?, IN_DATE_ = ?, OUT_DATE_ = ?, EMP_CATEGORY_ = ?, MEMO_ = ?, ORDER_ = ?, EMP_STATUS_ = ?, CREATION_DATE_ = ? where ORGN_SET_ID_ = ? and EMP_ID_ = ?";
        batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Map<String, Object> emp = updateEmpList.get(i);
                ps.setObject(1, emp.get("ORG_ID_"));
                ps.setObject(2, emp.get("EMP_CODE_"));
                ps.setObject(3, emp.get("EMP_NAME_"));
                ps.setObject(4, emp.get("PARTY_"));
                ps.setObject(5, emp.get("EMP_LEVEL_"));
                ps.setObject(6, emp.get("GENDER_"));
                ps.setObject(7, emp.get("BIRTH_DATE_"));
                ps.setObject(8, emp.get("TEL_"));
                ps.setObject(9, emp.get("EMAIL_"));
                ps.setObject(10, emp.get("IN_DATE_"));
                ps.setObject(11, emp.get("OUT_DATE_"));
                ps.setObject(12, emp.get("EMP_CATEGORY_"));
                ps.setObject(13, emp.get("MEMO_"));
                ps.setObject(14, emp.get("ORDER_"));
                ps.setObject(15, emp.get("EMP_STATUS_"));
                ps.setObject(16, emp.get("CREATION_DATE_"));
                ps.setObject(17, ORGN_SET_ID_);
                ps.setObject(18, emp.get("EMP_ID_"));
            }

            public int getBatchSize() {
                return updateEmpList.size();
            }
        };
        omJdbcTemplate.batchUpdate(sql, batch);
        sql = "update OM_POSI_EMP set POSI_ID_ = ?, EMP_ID_ = ?, MAIN_ = ?, POSI_EMP_STATUS_ = ?, CREATION_DATE_ = ? where ORGN_SET_ID_ = ? and POSI_EMP_ID_ = ?";
        batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Map<String, Object> posiEmp = updatePosiEmpList.get(i);
                ps.setObject(1, posiEmp.get("POSI_ID_"));
                ps.setObject(2, posiEmp.get("EMP_ID_"));
                ps.setObject(3, posiEmp.get("MAIN_"));
                ps.setObject(4, posiEmp.get("POSI_EMP_STATUS_"));
                ps.setObject(5, posiEmp.get("CREATION_DATE_"));
                ps.setObject(6, ORGN_SET_ID_);
                ps.setObject(7, posiEmp.get("POSI_EMP_ID_"));
            }

            public int getBatchSize() {
                return updatePosiEmpList.size();
            }
        };
        omJdbcTemplate.batchUpdate(sql, batch);
        sql = "update OM_EMP_RELATION set UPPER_EMP_ID_ = ?, LOWER_EMP_ID_ = ?, EMP_RELATION_ = ?, EMP_RELATION_STATUS_ = ?, CREATION_DATE_ = ? where ORGN_SET_ID_ = ? and EMP_RELATION_ID_ = ?";
        batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Map<String, Object> empRelation = updateEmpRelationList.get(i);
                ps.setObject(1, empRelation.get("UPPER_EMP_ID_"));
                ps.setObject(2, empRelation.get("LOWER_EMP_ID_"));
                ps.setObject(3, empRelation.get("EMP_RELATION_"));
                ps.setObject(4, empRelation.get("EMP_RELATION_STATUS_"));
                ps.setObject(5, empRelation.get("CREATION_DATE_"));
                ps.setObject(6, ORGN_SET_ID_);
                ps.setObject(7, empRelation.get("EMP_RELATION_ID_"));
            }

            public int getBatchSize() {
                return updateEmpRelationList.size();
            }
        };
        omJdbcTemplate.batchUpdate(sql, batch);

        // 删除
        if (DELETE_EMP_RELATION_ID_LIST != null && !DELETE_EMP_RELATION_ID_LIST.isEmpty()) {
            sql = "delete from OM_EMP_RELATION where ORGN_SET_ID_ = :ORGN_SET_ID_ and (";
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
        String selectTagSql = "select * from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and (";
        Map<String, Object> selectTagParamMap = new HashMap<>();
        selectTagParamMap.put("ORGN_SET_ID_", BASE_ORGN_SET_ID_);
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
            final List<Map<String, Object>> tagList = namedParameterMirrorServerJdbcTemplate.queryForList(selectTagSql, selectTagParamMap);
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

        omJdbcTemplate.execute("alter table OM_ORG enable constraint FK_OM_ORG_PARENT");

        return 1;
    }
}