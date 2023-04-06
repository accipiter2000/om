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
import com.opendynamic.om.service.OmOrgnSetService;
import com.opendynamic.om.service.OmPosiService;
import com.opendynamic.om.service.OmTagService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OmPosiServiceImpl implements OmPosiService {
    @Autowired
    private OmOrgnSetService omOrgnSetService;
    @Autowired
    private OmTagService omTagService;
    @Autowired
    private JdbcTemplate omJdbcTemplate;

    @Override
    public Map<String, Object> loadPosi(String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_ID_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_) && StringUtils.isEmpty(ORGN_SET_CODE_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }
        if (StringUtils.isEmpty(POSI_ID_)) {
            throw new RuntimeException("errors.idRequired");
        }

        String sql = "select * from OMV_POSI where POSI_ID_ = :POSI_ID_";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("POSI_ID_", POSI_ID_);

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
    public Map<String, Object> loadPosiByCode(String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_CODE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_) && StringUtils.isEmpty(ORGN_SET_CODE_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }
        if (StringUtils.isEmpty(POSI_CODE_)) {
            throw new RuntimeException("errors.codeRequired");
        }

        String sql = "select * from OMV_POSI where POSI_CODE_ = :POSI_CODE_";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("POSI_CODE_", POSI_CODE_);

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
    public List<Map<String, Object>> selectPosi(String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_ID_, String ORG_ID_, String DUTY_ID_, String POSI_CODE_, String POSI_NAME_, List<String> DUTY_LEVEL_LIST, List<String> CATEGORY_LIST, String POSI_TAG_, List<String> POSI_STATUS_LIST, Boolean tagUnion, String withinOrgId, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaPosi(false, ORGN_SET_ID_, ORGN_SET_CODE_, POSI_ID_, ORG_ID_, DUTY_ID_, POSI_CODE_, POSI_NAME_, DUTY_LEVEL_LIST, CATEGORY_LIST, POSI_TAG_, POSI_STATUS_LIST, tagUnion, withinOrgId, OPERATOR_ID_, OPERATOR_NAME_);// 根据查询条件组装查询SQL语句
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
    public int countPosi(String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_ID_, String ORG_ID_, String DUTY_ID_, String POSI_CODE_, String POSI_NAME_, List<String> DUTY_LEVEL_LIST, List<String> CATEGORY_LIST, String POSI_TAG_, List<String> POSI_STATUS_LIST, Boolean tagUnion, String withinOrgId, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaPosi(true, ORGN_SET_ID_, ORGN_SET_CODE_, POSI_ID_, ORG_ID_, DUTY_ID_, POSI_CODE_, POSI_NAME_, DUTY_LEVEL_LIST, CATEGORY_LIST, POSI_TAG_, POSI_STATUS_LIST, tagUnion, withinOrgId, OPERATOR_ID_, OPERATOR_NAME_);// 根据查询条件组装总数查询SQL语句
        String sql = odSqlCriteria.getSql();
        Map<String, Object> paramMap = odSqlCriteria.getParamMap();

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    private OdSqlCriteria buildSqlCriteriaPosi(boolean count, String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_ID_, String ORG_ID_, String DUTY_ID_, String POSI_CODE_, String POSI_NAME_, List<String> DUTY_LEVEL_LIST, List<String> CATEGORY_LIST, String POSI_TAG_, List<String> POSI_STATUS_LIST, Boolean tagUnion, String withinOrgId, String OPERATOR_ID_, String OPERATOR_NAME_) {// 组装查询SQL语句
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
            sql = "select count(*) from OMV_POSI P where 1 = 1";
        }
        else {
            sql = "select * from OMV_POSI P where 1 = 1";
        }

        if (StringUtils.isNotEmpty(ORGN_SET_ID_)) {
            sql += " and ORGN_SET_ID_ = :ORGN_SET_ID_";
            paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        }
        if (StringUtils.isNotEmpty(ORGN_SET_CODE_)) {
            sql += " and ORGN_SET_CODE_ = :ORGN_SET_CODE_";
            paramMap.put("ORGN_SET_CODE_", ORGN_SET_CODE_);
        }
        if (StringUtils.isNotEmpty(POSI_ID_)) {
            sql += " and POSI_ID_ = :POSI_ID_";
            paramMap.put("POSI_ID_", POSI_ID_);
        }
        if (StringUtils.isNotEmpty(ORG_ID_)) {
            sql += " and ORG_ID_ = :ORG_ID_";
            paramMap.put("ORG_ID_", ORG_ID_);
        }
        if (StringUtils.isNotEmpty(DUTY_ID_)) {
            sql += " and DUTY_ID_ = :DUTY_ID_";
            paramMap.put("DUTY_ID_", DUTY_ID_);
        }
        if (StringUtils.isNotEmpty(POSI_CODE_)) {
            sql += " and POSI_CODE_ = :POSI_CODE_";
            paramMap.put("POSI_CODE_", POSI_CODE_);
        }
        if (StringUtils.isNotEmpty(POSI_NAME_)) {
            sql += " and POSI_NAME_ like '%' || :POSI_NAME_ || '%'";
            paramMap.put("POSI_NAME_", POSI_NAME_);
        }
        if (DUTY_LEVEL_LIST != null && DUTY_LEVEL_LIST.size() > 0) {
            sql += " and DUTY_LEVEL_ in (:DUTY_LEVEL_LIST)";
            paramMap.put("DUTY_LEVEL_LIST", DUTY_LEVEL_LIST);
        }
        if (CATEGORY_LIST != null && CATEGORY_LIST.size() > 0) {
            sql += " and CATEGORY_ in (:CATEGORY_LIST)";
            paramMap.put("CATEGORY_LIST", CATEGORY_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_TAG_)) {
            List<String> tagList = omTagService.splitTag(POSI_TAG_);
            if (tagList.size() > 0) {
                if (tagUnion != null && tagUnion.equals(false)) {
                    sql += " and POSI_ID_ in (select POSI_ID_ from (select OBJ_ID_ as POSI_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'POSI' and TAG_ in (:POSI_TAG_LIST)) T group by POSI_ID_ having count(*) >= 1)";
                    paramMap.put("POSI_TAG_LIST", tagList);
                }
                else {
                    sql += " and POSI_ID_ in (select POSI_ID_ from (select OBJ_ID_ as POSI_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'POSI' and TAG_ in (:POSI_TAG_LIST)) T group by POSI_ID_ having count(*) >= :tagCount)";
                    paramMap.put("POSI_TAG_LIST", tagList);
                    paramMap.put("tagCount", tagList.size());
                }
            }
        }
        if (POSI_STATUS_LIST != null && POSI_STATUS_LIST.size() > 0) {
            sql += " and POSI_STATUS_ in (:POSI_STATUS_LIST)";
            paramMap.put("POSI_STATUS_LIST", POSI_STATUS_LIST);
        }

        if (StringUtils.isNotEmpty(withinOrgId)) {
            sql = "with TMP as (select /*+ materialize*/ ORG_ID_ from (select ORG_ID_, PARENT_ORG_ID_ from OM_ORG where ORGN_SET_ID_ = :ORGN_SET_ID_) connect by prior ORG_ID_ = PARENT_ORG_ID_ start with ORG_ID_ = :withinOrgId)" + sql;
            sql += " and exists (select ORG_ID_ from TMP T where T.ORG_ID_ = P.ORG_ID_)";
            paramMap.put("withinOrgId", withinOrgId);
        }

        if (!count) {
            sql += " order by ORG_ID_, ORDER_";
        }

        return new OdSqlCriteria(sql, paramMap);
    }

    @Override
    public List<Map<String, Object>> selectPosiByIdList(String ORGN_SET_ID_, List<String> POSI_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (POSI_ID_LIST == null || POSI_ID_LIST.size() == 0) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder(POSI_ID_LIST.size() * 50 + 200);
        Map<String, Object> paramMap = new HashMap<String, Object>();

        sql.append("select * from OMV_POSI where ORGN_SET_ID_ = :ORGN_SET_ID_ and POSI_ID_ in (:POSI_ID_LIST)");
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        paramMap.put("POSI_ID_LIST", POSI_ID_LIST);
        sql.append(" order by DECODE(POSI_ID_,");// 按主键列表顺序排序
        for (int i = 0; i < POSI_ID_LIST.size(); i++) {
            sql.append(" '").append(POSI_ID_LIST.get(i)).append("', ").append(i);
            if (i < POSI_ID_LIST.size() - 1) {
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
    public List<Map<String, Object>> selectProtoPosiByIdList(String ORGN_SET_ID_, List<String> POSI_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (POSI_ID_LIST == null || POSI_ID_LIST.size() == 0) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder(POSI_ID_LIST.size() * 50 + 200);
        Map<String, Object> paramMap = new HashMap<String, Object>();

        sql.append("select * from OM_POSI where ORGN_SET_ID_ = :ORGN_SET_ID_ and POSI_ID_ in (:POSI_ID_LIST)");
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        paramMap.put("POSI_ID_LIST", POSI_ID_LIST);
        sql.append(" order by DECODE(POSI_ID_,");// 按主键列表顺序排序
        for (int i = 0; i < POSI_ID_LIST.size(); i++) {
            sql.append(" '").append(POSI_ID_LIST.get(i)).append("', ").append(i);
            if (i < POSI_ID_LIST.size() - 1) {
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
    public int insertPosi(String ORGN_SET_ID_, String POSI_ID_, String ORG_ID_, String DUTY_ID_, String POSI_CODE_, String POSI_NAME_, String DUTY_LEVEL_, String CATEGORY_, String MEMO_, String POSI_TAG_, Integer ORDER_, String POSI_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        POSI_TAG_ = StringUtils.join(omTagService.splitTag(POSI_TAG_), ",");
        omTagService.updateTagByObjId(ORGN_SET_ID_, POSI_ID_, "POSI", POSI_TAG_);

        String sql = "insert into OM_POSI (ORGN_SET_ID_, POSI_ID_, ORG_ID_, DUTY_ID_, POSI_CODE_, POSI_NAME_, DUTY_LEVEL_, CATEGORY_, MEMO_, POSI_TAG_, ORDER_, POSI_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return omJdbcTemplate.update(sql, ORGN_SET_ID_, POSI_ID_, ORG_ID_, DUTY_ID_, POSI_CODE_, POSI_NAME_, DUTY_LEVEL_, CATEGORY_, MEMO_, POSI_TAG_, ORDER_, POSI_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_);
    }

    @Override
    public int updatePosi(String ORGN_SET_ID_, String POSI_ID_, String DUTY_ID_, String POSI_CODE_, String POSI_NAME_, String DUTY_LEVEL_, String CATEGORY_, String MEMO_, String POSI_TAG_, Integer ORDER_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        POSI_TAG_ = StringUtils.join(omTagService.splitTag(POSI_TAG_), ",");
        omTagService.updateTagByObjId(ORGN_SET_ID_, POSI_ID_, "POSI", POSI_TAG_);

        String sql = "update OM_POSI set DUTY_ID_ = ?, POSI_CODE_ = ?, POSI_NAME_ = ?, DUTY_LEVEL_ = ?, CATEGORY_ = ?, MEMO_ = ?, POSI_TAG_ = ?, ORDER_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and POSI_ID_ = ?";
        return omJdbcTemplate.update(sql, DUTY_ID_, POSI_CODE_, POSI_NAME_, DUTY_LEVEL_, CATEGORY_, MEMO_, POSI_TAG_, ORDER_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, POSI_ID_);
    }

    @Override
    public int updatePosiOrder(final String ORGN_SET_ID_, final List<String> POSI_ID_LIST, final List<Integer> ORDER_LIST, final Date UPDATE_DATE_, final String OPERATOR_ID_, final String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (POSI_ID_LIST == null || POSI_ID_LIST.size() == 0) {
            return 0;
        }
        if (POSI_ID_LIST.size() != ORDER_LIST.size()) {
            return 0;
        }

        String sql = "update OM_POSI set ORDER_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and POSI_ID_ = ?";
        BatchPreparedStatementSetter batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, ORDER_LIST.get(i));
                ps.setTimestamp(2, UPDATE_DATE_ == null ? null : new java.sql.Timestamp(UPDATE_DATE_.getTime()));
                ps.setString(3, OPERATOR_ID_);
                ps.setString(4, OPERATOR_NAME_);
                ps.setString(5, ORGN_SET_ID_);
                ps.setString(6, POSI_ID_LIST.get(i));
            }

            public int getBatchSize() {
                return POSI_ID_LIST.size();
            }
        };

        return omJdbcTemplate.batchUpdate(sql, batch).length;
    }

    @Override
    public int movePosi(String ORGN_SET_ID_, String POSI_ID_, String ORG_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql = "update OM_POSI set ORG_ID_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and POSI_ID_ = ?";
        return omJdbcTemplate.update(sql, ORG_ID_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, POSI_ID_);
    }

    @Override
    public int disablePosi(String ORGN_SET_ID_, String POSI_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql = "update OM_POSI set POSI_STATUS_ = '0', UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and POSI_ID_ = ?";
        return omJdbcTemplate.update(sql, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, POSI_ID_);
    }

    @Override
    public int enablePosi(String ORGN_SET_ID_, String POSI_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql = "update OM_POSI set POSI_STATUS_ = '1', UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and POSI_ID_ = ?";
        return omJdbcTemplate.update(sql, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, POSI_ID_);
    }

    @Override
    public int deletePosi(String ORGN_SET_ID_, String POSI_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        omTagService.deleteTagByObjId(ORGN_SET_ID_, POSI_ID_);

        String sql = "delete from OM_POSI where ORGN_SET_ID_ = ? and POSI_ID_ = ?";
        return omJdbcTemplate.update(sql, ORGN_SET_ID_, POSI_ID_);
    }
}