package com.opendynamic.om.service.impl.oracle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
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
import com.opendynamic.om.service.OmOrgnSetService;
import com.opendynamic.om.service.OmPosiEmpService;
import com.opendynamic.om.service.OmTagService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OmPosiEmpServiceImpl implements OmPosiEmpService {
    @Autowired
    private OmOrgnSetService omOrgnSetService;
    @Autowired
    private OmTagService omTagService;
    @Autowired
    private JdbcTemplate omJdbcTemplate;

    @Override
    public Map<String, Object> loadPosiEmp(String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_EMP_ID_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_) && StringUtils.isEmpty(ORGN_SET_CODE_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }
        if (StringUtils.isEmpty(POSI_EMP_ID_)) {
            throw new RuntimeException("errors.idRequired");
        }

        String sql = "select * from OMV_POSI_EMP where POSI_EMP_ID_ = :POSI_EMP_ID_";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("POSI_EMP_ID_", POSI_EMP_ID_);

        if (StringUtils.isNotEmpty(ORGN_SET_ID_)) {
            sql += " and ORGN_SET_ID_ = :ORGN_SET_ID_";
            paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        }
        if (StringUtils.isNotEmpty(ORGN_SET_CODE_)) {
            sql += " and ORGN_SET_CODE_ = :ORGN_SET_CODE_";
            paramMap.put("ORGN_SET_CODE_", ORGN_SET_CODE_);
        }

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        List<Map<String, Object>> result = namedParameterJdbcTemplate.queryForList(sql, paramMap);
        if (result.size() == 1) {
            return result.get(0);
        }
        else {
            return null;
        }
    }

    @Override
    public List<Map<String, Object>> selectPosiEmp(String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_EMP_ID_, String ORG_ID_, String DUTY_ID_, String POSI_ID_, String EMP_ID_, List<String> ORG_CODE_LIST, List<String> DUTY_CODE_LIST, List<String> POSI_CODE_LIST, List<String> EMP_CODE_LIST, List<String> MAIN_LIST, String POSI_EMP_TAG_, List<String> POSI_EMP_STATUS_LIST, String EMP_NAME_, List<String> CATEGORY_LIST, String EMP_TAG_, List<String> EMP_STATUS_LIST, Boolean tagUnion, String withinOrgId, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaPosiEmp(false, ORGN_SET_ID_, ORGN_SET_CODE_, POSI_EMP_ID_, ORG_ID_, DUTY_ID_, POSI_ID_, EMP_ID_, ORG_CODE_LIST, DUTY_CODE_LIST, POSI_CODE_LIST, EMP_CODE_LIST, MAIN_LIST, POSI_EMP_TAG_, POSI_EMP_STATUS_LIST, EMP_NAME_, CATEGORY_LIST, EMP_TAG_, EMP_STATUS_LIST, tagUnion, withinOrgId, OPERATOR_ID_, OPERATOR_NAME_);// 根据查询条件组装查询SQL语句
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
    public int countPosiEmp(String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_EMP_ID_, String ORG_ID_, String DUTY_ID_, String POSI_ID_, String EMP_ID_, List<String> ORG_CODE_LIST, List<String> DUTY_CODE_LIST, List<String> POSI_CODE_LIST, List<String> EMP_CODE_LIST, List<String> MAIN_LIST, String POSI_EMP_TAG_, List<String> POSI_EMP_STATUS_LIST, String EMP_NAME_, List<String> CATEGORY_LIST, String EMP_TAG_, List<String> EMP_STATUS_LIST, Boolean tagUnion, String withinOrgId, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaPosiEmp(true, ORGN_SET_ID_, ORGN_SET_CODE_, POSI_EMP_ID_, ORG_ID_, DUTY_ID_, POSI_ID_, EMP_ID_, ORG_CODE_LIST, DUTY_CODE_LIST, POSI_CODE_LIST, EMP_CODE_LIST, MAIN_LIST, POSI_EMP_TAG_, POSI_EMP_STATUS_LIST, EMP_NAME_, CATEGORY_LIST, EMP_TAG_, EMP_STATUS_LIST, tagUnion, withinOrgId, OPERATOR_ID_, OPERATOR_NAME_);// 根据查询条件组装总数查询SQL语句
        String sql = odSqlCriteria.getSql();
        Map<String, Object> paramMap = odSqlCriteria.getParamMap();

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    private OdSqlCriteria buildSqlCriteriaPosiEmp(boolean count, String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_EMP_ID_, String ORG_ID_, String DUTY_ID_, String POSI_ID_, String EMP_ID_, List<String> ORG_CODE_LIST, List<String> DUTY_CODE_LIST, List<String> POSI_CODE_LIST, List<String> EMP_CODE_LIST, List<String> MAIN_LIST, String POSI_EMP_TAG_, List<String> POSI_EMP_STATUS_LIST, String EMP_NAME_, List<String> CATEGORY_LIST, String EMP_TAG_, List<String> EMP_STATUS_LIST, Boolean tagUnion, String withinOrgId, String OPERATOR_ID_, String OPERATOR_NAME_) {// 组装查询SQL语句
        if (StringUtils.isEmpty(ORGN_SET_ID_) && StringUtils.isEmpty(ORGN_SET_CODE_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            Map<String, Object> orgnSet = omOrgnSetService.loadOrgnSetByCode(ORGN_SET_CODE_, OPERATOR_ID_, OPERATOR_NAME_);
            ORGN_SET_ID_ = (String) orgnSet.get("ORGN_SET_ID_");
        }

        String sql;
        Map<String, Object> paramMap = new HashMap<String, Object>();

        if (count) {
            sql = "select count(*) from OMV_POSI_EMP PE where 1 = 1";
        }
        else {
            sql = "select * from OMV_POSI_EMP PE where 1 = 1";
        }

        if (StringUtils.isNotEmpty(ORGN_SET_ID_)) {
            sql += " and ORGN_SET_ID_ = :ORGN_SET_ID_";
            paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        }
        if (StringUtils.isNotEmpty(ORGN_SET_CODE_)) {
            sql += " and ORGN_SET_CODE_ = :ORGN_SET_CODE_";
            paramMap.put("ORGN_SET_CODE_", ORGN_SET_CODE_);
        }
        if (StringUtils.isNotEmpty(POSI_EMP_ID_)) {
            sql += " and POSI_EMP_ID_ = :POSI_EMP_ID_";
            paramMap.put("POSI_EMP_ID_", POSI_EMP_ID_);
        }
        if (StringUtils.isNotEmpty(ORG_ID_)) {
            sql += " and ORG_ID_ = :ORG_ID_";
            paramMap.put("ORG_ID_", ORG_ID_);
        }
        if (StringUtils.isNotEmpty(DUTY_ID_)) {
            sql += " and DUTY_ID_ = :DUTY_ID_";
            paramMap.put("DUTY_ID_", DUTY_ID_);
        }
        if (StringUtils.isNotEmpty(POSI_ID_)) {
            sql += " and POSI_ID_ = :POSI_ID_";
            paramMap.put("POSI_ID_", POSI_ID_);
        }
        if (StringUtils.isNotEmpty(EMP_ID_)) {
            sql += " and EMP_ID_ = :EMP_ID_";
            paramMap.put("EMP_ID_", EMP_ID_);
        }
        if (ORG_CODE_LIST != null && ORG_CODE_LIST.size() > 0) {
            sql += " and ORG_CODE_ in (:ORG_CODE_LIST)";
            paramMap.put("ORG_CODE_LIST", ORG_CODE_LIST);
        }
        if (DUTY_CODE_LIST != null && DUTY_CODE_LIST.size() > 0) {
            sql += " and DUTY_CODE_ in (:DUTY_CODE_LIST)";
            paramMap.put("DUTY_CODE_LIST", DUTY_CODE_LIST);
        }
        if (POSI_CODE_LIST != null && POSI_CODE_LIST.size() > 0) {
            sql += " and POSI_CODE_ in (:POSI_CODE_LIST)";
            paramMap.put("POSI_CODE_LIST", POSI_CODE_LIST);
        }
        if (EMP_CODE_LIST != null && EMP_CODE_LIST.size() > 0) {
            sql += " and EMP_CODE_ in (:EMP_CODE_LIST)";
            paramMap.put("EMP_CODE_LIST", EMP_CODE_LIST);
        }
        if (MAIN_LIST != null && MAIN_LIST.size() > 0) {
            sql += " and MAIN_ in (:MAIN_LIST)";
            paramMap.put("MAIN_LIST", MAIN_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_EMP_TAG_)) {
            List<String> tagList = omTagService.splitTag(POSI_EMP_TAG_);
            if (tagList.size() > 0) {
                if (tagUnion != null && tagUnion.equals(false)) {
                    sql += " and POSI_EMP_ID_ in (select POSI_EMP_ID_ from (select OBJ_ID_ as POSI_EMP_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'POSI_EMP' and TAG_ in (:POSI_EMP_TAG_LIST)) T group by POSI_EMP_ID_ having count(*) >= 1)";
                    paramMap.put("POSI_EMP_TAG_LIST", tagList);
                }
                else {
                    sql += " and POSI_EMP_ID_ in (select POSI_EMP_ID_ from (select OBJ_ID_ as POSI_EMP_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'POSI_EMP' and TAG_ in (:POSI_EMP_TAG_LIST)) T group by POSI_EMP_ID_ having count(*) >= :tagCount)";
                    paramMap.put("POSI_EMP_TAG_LIST", tagList);
                    paramMap.put("tagCount", tagList.size());
                }
            }
        }
        if (POSI_EMP_STATUS_LIST != null && POSI_EMP_STATUS_LIST.size() > 0) {
            sql += " and POSI_EMP_STATUS_ in (:POSI_EMP_STATUS_LIST)";
            paramMap.put("POSI_EMP_STATUS_LIST", POSI_EMP_STATUS_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_NAME_)) {
            sql += " and EMP_NAME_ like '%' || :EMP_NAME_ || '%'";
            paramMap.put("EMP_NAME_", EMP_NAME_);
        }
        if (CATEGORY_LIST != null && CATEGORY_LIST.size() > 0) {
            sql += " and CATEGORY_ in (:CATEGORY_LIST)";
            paramMap.put("CATEGORY_LIST", CATEGORY_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_TAG_)) {
            List<String> tagList = omTagService.splitTag(EMP_TAG_);
            if (tagList.size() > 0) {
                if (tagUnion != null && tagUnion.equals(false)) {
                    sql += " and EMP_ID_ in (select EMP_ID_ from (select OBJ_ID_ as EMP_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'EMP' and TAG_ in (:EMP_TAG_LIST)) T group by EMP_ID_ having count(*) >= 1)";
                    paramMap.put("EMP_TAG_LIST", tagList);
                }
                else {
                    sql += " and EMP_ID_ in (select EMP_ID_ from (select OBJ_ID_ as EMP_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'EMP' and TAG_ in (:EMP_TAG_LIST)) T group by EMP_ID_ having count(*) >= :tagCount)";
                    paramMap.put("EMP_TAG_LIST", tagList);
                    paramMap.put("tagCount", tagList.size());
                }
            }
        }
        if (EMP_STATUS_LIST != null && EMP_STATUS_LIST.size() > 0) {
            sql += " and EMP_STATUS_ in (:EMP_STATUS_LIST)";
            paramMap.put("EMP_STATUS_LIST", EMP_STATUS_LIST);
        }

        if (StringUtils.isNotEmpty(withinOrgId)) {
            sql = "with TMP as (select /*+ materialize*/ ORG_ID_ from (select ORG_ID_, PARENT_ORG_ID_ from OM_ORG where ORGN_SET_ID_ = :ORGN_SET_ID_) connect by prior ORG_ID_ = PARENT_ORG_ID_ start with ORG_ID_ = :withinOrgId)" + sql;
            sql += " and exists (select ORG_ID_ from TMP T where T.ORG_ID_ = PE.ORG_ID_)";
            paramMap.put("withinOrgId", withinOrgId);
        }

        if (!count) {
            sql += " order by ORDER_";
        }

        return new OdSqlCriteria(sql, paramMap);
    }

    @Override
    public List<Map<String, Object>> selectPosiEmpByIdList(String ORGN_SET_ID_, List<String> POSI_EMP_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (POSI_EMP_ID_LIST == null || POSI_EMP_ID_LIST.size() == 0) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder(POSI_EMP_ID_LIST.size() * 50 + 200);
        Map<String, Object> paramMap = new HashMap<String, Object>();

        sql.append("select * from OMV_POSI_EMP where ORGN_SET_ID_ = :ORGN_SET_ID_ and POSI_EMP_ID_ in (:POSI_EMP_ID_LIST)");
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        paramMap.put("POSI_EMP_ID_LIST", POSI_EMP_ID_LIST);
        sql.append(" order by DECODE(POSI_EMP_ID_,");// 按主键列表顺序排序
        for (int i = 0; i < POSI_EMP_ID_LIST.size(); i++) {
            sql.append(" '").append(POSI_EMP_ID_LIST.get(i)).append("', ").append(i);
            if (i < POSI_EMP_ID_LIST.size() - 1) {
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
    public List<Map<String, Object>> selectProtoPosiEmpByIdList(String ORGN_SET_ID_, List<String> POSI_EMP_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (POSI_EMP_ID_LIST == null || POSI_EMP_ID_LIST.size() == 0) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder(POSI_EMP_ID_LIST.size() * 50 + 200);
        Map<String, Object> paramMap = new HashMap<String, Object>();

        sql.append("select * from OM_POSI_EMP where ORGN_SET_ID_ = :ORGN_SET_ID_ and POSI_EMP_ID_ in (:POSI_EMP_ID_LIST)");
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        paramMap.put("POSI_EMP_ID_LIST", POSI_EMP_ID_LIST);
        sql.append(" order by DECODE(POSI_EMP_ID_,");// 按主键列表顺序排序
        for (int i = 0; i < POSI_EMP_ID_LIST.size(); i++) {
            sql.append(" '").append(POSI_EMP_ID_LIST.get(i)).append("', ").append(i);
            if (i < POSI_EMP_ID_LIST.size() - 1) {
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
    public int insertPosiEmp(String ORGN_SET_ID_, String POSI_EMP_ID_, String POSI_ID_, String EMP_ID_, String MAIN_, String POSI_EMP_TAG_, String POSI_EMP_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        POSI_EMP_TAG_ = StringUtils.join(omTagService.splitTag(POSI_EMP_TAG_), ",");
        omTagService.updateTagByObjId(ORGN_SET_ID_, POSI_EMP_ID_, "POSI_EMP", POSI_EMP_TAG_);

        String sql = "insert into OM_POSI_EMP (ORGN_SET_ID_, POSI_EMP_ID_, POSI_ID_, EMP_ID_, MAIN_, POSI_EMP_TAG_, POSI_EMP_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return omJdbcTemplate.update(sql, ORGN_SET_ID_, POSI_EMP_ID_, POSI_ID_, EMP_ID_, MAIN_, POSI_EMP_TAG_, POSI_EMP_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_);
    }

    @Override
    public int insertPosiEmpByEmpIdList(final String ORGN_SET_ID_, final String POSI_ID_, final List<String> EMP_ID_LIST, final Date CREATION_DATE_, final Date UPDATE_DATE_, final String OPERATOR_ID_, final String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (EMP_ID_LIST == null || EMP_ID_LIST.size() == 0) {
            return 0;
        }

        final List<String> POSI_EMP_ID_LIST = new ArrayList<>();
        String sql = "insert into OM_POSI_EMP(ORGN_SET_ID_, POSI_EMP_ID_, POSI_ID_, EMP_ID_, MAIN_, POSI_EMP_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        BatchPreparedStatementSetter batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                String POSI_EMP_ID_ = OdUtils.getUuid();
                POSI_EMP_ID_LIST.add(POSI_EMP_ID_);

                ps.setString(1, ORGN_SET_ID_);
                ps.setString(2, POSI_EMP_ID_);
                ps.setString(3, POSI_ID_);
                ps.setString(4, EMP_ID_LIST.get(i));
                ps.setString(5, "0");
                ps.setString(6, "1");
                ps.setTimestamp(7, CREATION_DATE_ == null ? null : new Timestamp(CREATION_DATE_.getTime()));
                ps.setTimestamp(8, UPDATE_DATE_ == null ? null : new Timestamp(UPDATE_DATE_.getTime()));
                ps.setString(9, OPERATOR_ID_);
                ps.setString(10, OPERATOR_NAME_);
            }

            public int getBatchSize() {
                return EMP_ID_LIST.size();
            }
        };

        return omJdbcTemplate.batchUpdate(sql, batch).length;
    }

    @Override
    public int insertPosiEmpByPosiIdList(final String ORGN_SET_ID_, final String EMP_ID_, final List<String> POSI_ID_LIST, final Date CREATION_DATE_, final Date UPDATE_DATE_, final String OPERATOR_ID_, final String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (POSI_ID_LIST == null || POSI_ID_LIST.size() == 0) {
            return 0;
        }

        final List<String> POSI_EMP_ID_LIST = new ArrayList<>();
        String sql = "insert into OM_POSI_EMP(ORGN_SET_ID_, POSI_EMP_ID_, POSI_ID_, EMP_ID_, MAIN_, POSI_EMP_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        BatchPreparedStatementSetter batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                String POSI_EMP_ID_ = OdUtils.getUuid();
                POSI_EMP_ID_LIST.add(POSI_EMP_ID_);

                ps.setString(1, ORGN_SET_ID_);
                ps.setString(2, POSI_EMP_ID_);
                ps.setString(3, POSI_ID_LIST.get(i));
                ps.setString(4, EMP_ID_);
                ps.setString(5, "0");
                ps.setString(6, "1");
                ps.setTimestamp(7, CREATION_DATE_ == null ? null : new Timestamp(CREATION_DATE_.getTime()));
                ps.setTimestamp(8, UPDATE_DATE_ == null ? null : new Timestamp(UPDATE_DATE_.getTime()));
                ps.setString(9, OPERATOR_ID_);
                ps.setString(10, OPERATOR_NAME_);
            }

            public int getBatchSize() {
                return POSI_ID_LIST.size();
            }
        };

        return omJdbcTemplate.batchUpdate(sql, batch).length;
    }

    @Override
    public int updatePosiEmp(String ORGN_SET_ID_, String POSI_EMP_ID_, String MAIN_, String POSI_EMP_TAG_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        POSI_EMP_TAG_ = StringUtils.join(omTagService.splitTag(POSI_EMP_TAG_), ",");
        omTagService.updateTagByObjId(ORGN_SET_ID_, POSI_EMP_ID_, "POSI_EMP", POSI_EMP_TAG_);

        String sql = "update OM_POSI_EMP set MAIN_ = ?, POSI_EMP_TAG_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and POSI_EMP_ID_ = ?";
        return omJdbcTemplate.update(sql, MAIN_, POSI_EMP_TAG_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, POSI_EMP_ID_);
    }

    @Override
    public int updatePosiEmpMain(String ORGN_SET_ID_, String POSI_EMP_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        Map<String, Object> posiEmp = loadPosiEmp(ORGN_SET_ID_, null, POSI_EMP_ID_, OPERATOR_ID_, OPERATOR_NAME_);

        String sql = "update OM_POSI_EMP set MAIN_ = '0', UPDATE_DATE_ = ? where ORGN_SET_ID_ = ? and EMP_ID_ = ?";
        omJdbcTemplate.update(sql, UPDATE_DATE_, ORGN_SET_ID_, posiEmp.get("EMP_ID_"));

        sql = "update OM_POSI_EMP set MAIN_ = '1', UPDATE_DATE_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and POSI_EMP_ID_ = ?";
        return omJdbcTemplate.update(sql, UPDATE_DATE_, OPERATOR_NAME_, ORGN_SET_ID_, POSI_EMP_ID_);
    }

    @Override
    public int disablePosiEmp(String ORGN_SET_ID_, String POSI_EMP_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql = "update OM_POSI_EMP set POSI_EMP_STATUS_ = '0', UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and POSI_EMP_ID_ = ?";
        return omJdbcTemplate.update(sql, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, POSI_EMP_ID_);
    }

    @Override
    public int enablePosiEmp(String ORGN_SET_ID_, String POSI_EMP_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql = "update OM_POSI_EMP set POSI_EMP_STATUS_ = '1', UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and POSI_EMP_ID_ = ?";
        return omJdbcTemplate.update(sql, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, POSI_EMP_ID_);
    }

    @Override
    public int deletePosiEmp(String ORGN_SET_ID_, String POSI_EMP_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        omTagService.deleteTagByObjId(ORGN_SET_ID_, POSI_EMP_ID_);

        String sql = "delete from OM_POSI_EMP where ORGN_SET_ID_ = ? and POSI_EMP_ID_ = ?";
        return omJdbcTemplate.update(sql, ORGN_SET_ID_, POSI_EMP_ID_);
    }

    @Override
    public int deletePosiEmpByIdList(String ORGN_SET_ID_, List<String> POSI_EMP_ID_LIST, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (POSI_EMP_ID_LIST == null) {
            return 0;
        }

        for (String POSI_EMP_ID_ : POSI_EMP_ID_LIST) {
            deletePosiEmp(ORGN_SET_ID_, POSI_EMP_ID_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_);
        }

        return POSI_EMP_ID_LIST.size();
    }
}