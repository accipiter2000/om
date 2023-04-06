package com.opendynamic.om.service.impl.mysql;

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
import com.opendynamic.om.service.OmEmpRelationService;
import com.opendynamic.om.service.OmTagService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OmEmpRelationServiceImpl implements OmEmpRelationService {
    @Autowired
    private OmTagService omTagService;
    @Autowired
    private JdbcTemplate omJdbcTemplate;

    @Override
    public Map<String, Object> loadEmpRelation(String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_RELATION_ID_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_) && StringUtils.isEmpty(ORGN_SET_CODE_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }
        if (StringUtils.isEmpty(EMP_RELATION_ID_)) {
            throw new RuntimeException("errors.idRequired");
        }

        String sql = "select * from OMV_EMP_RELATION where EMP_RELATION_ID_ = :EMP_RELATION_ID_";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("EMP_RELATION_ID_", EMP_RELATION_ID_);

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
    public List<Map<String, Object>> selectEmpRelation(String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_RELATION_ID_, String UPPER_EMP_ID_, String LOWER_EMP_ID_, List<String> EMP_RELATION_LIST, String EMP_RELATION_TAG_, List<String> EMP_RELATION_STATUS_LIST, Boolean tagUnion, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaEmpRelation(false, ORGN_SET_ID_, ORGN_SET_CODE_, EMP_RELATION_ID_, UPPER_EMP_ID_, LOWER_EMP_ID_, EMP_RELATION_LIST, EMP_RELATION_TAG_, EMP_RELATION_STATUS_LIST, tagUnion, OPERATOR_ID_, OPERATOR_NAME_);// 根据查询条件组装查询SQL语句
        String sql = odSqlCriteria.getSql();
        Map<String, Object> paramMap = odSqlCriteria.getParamMap();

        if (page != null && limit != null && limit > 0) {// 分页
            sql = sql + " limit " + (page - 1) * limit + ", " + limit;
        }

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForList(sql, paramMap);
    }

    @Override
    public int countEmpRelation(String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_RELATION_ID_, String UPPER_EMP_ID_, String LOWER_EMP_ID_, List<String> EMP_RELATION_LIST, String EMP_RELATION_TAG_, List<String> EMP_RELATION_STATUS_LIST, Boolean tagUnion, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaEmpRelation(true, ORGN_SET_ID_, ORGN_SET_CODE_, EMP_RELATION_ID_, UPPER_EMP_ID_, LOWER_EMP_ID_, EMP_RELATION_LIST, EMP_RELATION_TAG_, EMP_RELATION_STATUS_LIST, tagUnion, OPERATOR_ID_, OPERATOR_NAME_);// 根据查询条件组装总数查询SQL语句
        String sql = odSqlCriteria.getSql();
        Map<String, Object> paramMap = odSqlCriteria.getParamMap();

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    private OdSqlCriteria buildSqlCriteriaEmpRelation(boolean count, String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_RELATION_ID_, String UPPER_EMP_ID_, String LOWER_EMP_ID_, List<String> EMP_RELATION_LIST, String EMP_RELATION_TAG_, List<String> EMP_RELATION_STATUS_LIST, Boolean tagUnion, String OPERATOR_ID_, String OPERATOR_NAME_) {// 组装查询SQL语句
        if (StringUtils.isEmpty(ORGN_SET_ID_) && StringUtils.isEmpty(ORGN_SET_CODE_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql;
        Map<String, Object> paramMap = new HashMap<String, Object>();

        if (count) {
            sql = "select count(*) from OMV_EMP_RELATION where 1 = 1";
        }
        else {
            sql = "select * from OMV_EMP_RELATION where 1 = 1";
        }

        if (StringUtils.isNotEmpty(ORGN_SET_ID_)) {
            sql += " and ORGN_SET_ID_ = :ORGN_SET_ID_";
            paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        }
        if (StringUtils.isNotEmpty(ORGN_SET_CODE_)) {
            sql += " and ORGN_SET_CODE_ = :ORGN_SET_CODE_";
            paramMap.put("ORGN_SET_CODE_", ORGN_SET_CODE_);
        }
        if (StringUtils.isNotEmpty(EMP_RELATION_ID_)) {
            sql += " and EMP_RELATION_ID_ = :EMP_RELATION_ID_";
            paramMap.put("EMP_RELATION_ID_", EMP_RELATION_ID_);
        }
        if (StringUtils.isNotEmpty(UPPER_EMP_ID_)) {
            sql += " and UPPER_EMP_ID_ = :UPPER_EMP_ID_";
            paramMap.put("UPPER_EMP_ID_", UPPER_EMP_ID_);
        }
        if (StringUtils.isNotEmpty(LOWER_EMP_ID_)) {
            sql += " and LOWER_EMP_ID_ = :LOWER_EMP_ID_";
            paramMap.put("LOWER_EMP_ID_", LOWER_EMP_ID_);
        }
        if (EMP_RELATION_LIST != null && EMP_RELATION_LIST.size() > 0) {
            sql += " and EMP_RELATION_ in (:EMP_RELATION_LIST)";
            paramMap.put("EMP_RELATION_LIST", EMP_RELATION_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_RELATION_TAG_)) {
            List<String> tagList = omTagService.splitTag(EMP_RELATION_TAG_);
            if (tagList.size() > 0) {
                if (tagUnion != null && tagUnion.equals(false)) {
                    sql += " and EMP_RELATION_ID_ in (select EMP_RELATION_ID_ from (select OBJ_ID_ as EMP_RELATION_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'EMP_RELATION' and TAG_ in (:EMP_RELATION_TAG_LIST)) T group by EMP_RELATION_ID_ having count(*) >= 1)";
                    paramMap.put("EMP_RELATION_TAG_LIST", tagList);
                }
                else {
                    sql += " and EMP_RELATION_ID_ in (select EMP_RELATION_ID_ from (select OBJ_ID_ as EMP_RELATION_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'EMP_RELATION' and TAG_ in (:EMP_RELATION_TAG_LIST)) T group by EMP_RELATION_ID_ having count(*) >= :tagCount)";
                    paramMap.put("EMP_RELATION_TAG_LIST", tagList);
                    paramMap.put("tagCount", tagList.size());
                }
            }
        }
        if (EMP_RELATION_STATUS_LIST != null && EMP_RELATION_STATUS_LIST.size() > 0) {
            sql += " and EMP_RELATION_STATUS_ in (:EMP_RELATION_STATUS_LIST)";
            paramMap.put("EMP_RELATION_STATUS_LIST", EMP_RELATION_STATUS_LIST);
        }

        return new OdSqlCriteria(sql, paramMap);
    }

    @Override
    public List<Map<String, Object>> selectEmpRelationByIdList(String ORGN_SET_ID_, List<String> EMP_RELATION_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (EMP_RELATION_ID_LIST == null || EMP_RELATION_ID_LIST.size() == 0) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder(EMP_RELATION_ID_LIST.size() * 50 + 200);
        Map<String, Object> paramMap = new HashMap<String, Object>();

        sql.append("select * from OMV_EMP_RELATION where ORGN_SET_ID_ = :ORGN_SET_ID_ and EMP_RELATION_ID_ in (:EMP_RELATION_ID_LIST)");
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        paramMap.put("EMP_RELATION_ID_LIST", EMP_RELATION_ID_LIST);
        sql.append(" order by FIELD(EMP_RELATION_ID_,");// 按主键列表顺序排序
        for (int i = 0; i < EMP_RELATION_ID_LIST.size(); i++) {
            sql.append(" '").append(EMP_RELATION_ID_LIST.get(i)).append("'");
            if (i < EMP_RELATION_ID_LIST.size() - 1) {
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
    public List<Map<String, Object>> selectProtoEmpRelationByIdList(String ORGN_SET_ID_, List<String> EMP_RELATION_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (EMP_RELATION_ID_LIST == null || EMP_RELATION_ID_LIST.size() == 0) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder(EMP_RELATION_ID_LIST.size() * 50 + 200);
        Map<String, Object> paramMap = new HashMap<String, Object>();

        sql.append("select * from OM_EMP_RELATION where ORGN_SET_ID_ = :ORGN_SET_ID_ and EMP_RELATION_ID_ in (:EMP_RELATION_ID_LIST)");
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        paramMap.put("EMP_RELATION_ID_LIST", EMP_RELATION_ID_LIST);
        sql.append(" order by FIELD(EMP_RELATION_ID_,");// 按主键列表顺序排序
        for (int i = 0; i < EMP_RELATION_ID_LIST.size(); i++) {
            sql.append(" '").append(EMP_RELATION_ID_LIST.get(i)).append("'");
            if (i < EMP_RELATION_ID_LIST.size() - 1) {
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
    public int insertEmpRelation(String ORGN_SET_ID_, String EMP_RELATION_ID_, String UPPER_EMP_ID_, String LOWER_EMP_ID_, String EMP_RELATION_, String EMP_RELATION_TAG_, String EMP_RELATION_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        EMP_RELATION_TAG_ = StringUtils.join(omTagService.splitTag(EMP_RELATION_TAG_), ",");
        omTagService.updateTagByObjId(ORGN_SET_ID_, EMP_RELATION_ID_, "EMP_RELATION", EMP_RELATION_TAG_);

        String sql = "insert into OM_EMP_RELATION (ORGN_SET_ID_, EMP_RELATION_ID_, UPPER_EMP_ID_, LOWER_EMP_ID_, EMP_RELATION_, EMP_RELATION_TAG_, EMP_RELATION_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''))";
        return omJdbcTemplate.update(sql, ORGN_SET_ID_, EMP_RELATION_ID_, UPPER_EMP_ID_, LOWER_EMP_ID_, EMP_RELATION_, EMP_RELATION_TAG_, EMP_RELATION_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_);
    }

    @Override
    public int updateEmpRelation(String ORGN_SET_ID_, String EMP_RELATION_ID_, String EMP_RELATION_, String EMP_RELATION_TAG_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        EMP_RELATION_TAG_ = StringUtils.join(omTagService.splitTag(EMP_RELATION_TAG_), ",");
        omTagService.updateTagByObjId(ORGN_SET_ID_, EMP_RELATION_ID_, "EMP_RELATION", EMP_RELATION_TAG_);

        String sql = "update OM_EMP_RELATION set EMP_RELATION_ = NULLIF(?, ''), EMP_RELATION_TAG_ = NULLIF(?, ''), UPDATE_DATE_ = NULLIF(?, ''), OPERATOR_ID_ = NULLIF(?, ''), OPERATOR_NAME_ = NULLIF(?, '') where ORGN_SET_ID_ = ? and EMP_RELATION_ID_ = ?";
        return omJdbcTemplate.update(sql, EMP_RELATION_, EMP_RELATION_TAG_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, EMP_RELATION_ID_);
    }

    @Override
    public int updateEmpRelationOrder(final String ORGN_SET_ID_, final List<String> EMP_RELATION_ID_LIST, final List<Integer> ORDER_LIST, final Date UPDATE_DATE_, final String OPERATOR_ID_, final String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (EMP_RELATION_ID_LIST == null || EMP_RELATION_ID_LIST.size() == 0) {
            return 0;
        }
        if (EMP_RELATION_ID_LIST.size() != ORDER_LIST.size()) {
            return 0;
        }

        String sql = "update OM_EMP_RELATION set ORDER_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and EMP_RELATION_ID_ = ?";
        BatchPreparedStatementSetter batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, ORDER_LIST.get(i));
                ps.setTimestamp(2, UPDATE_DATE_ == null ? null : new java.sql.Timestamp(UPDATE_DATE_.getTime()));
                ps.setString(3, OPERATOR_ID_);
                ps.setString(4, OPERATOR_NAME_);
                ps.setString(5, ORGN_SET_ID_);
                ps.setString(6, EMP_RELATION_ID_LIST.get(i));
            }

            public int getBatchSize() {
                return EMP_RELATION_ID_LIST.size();
            }
        };

        return omJdbcTemplate.batchUpdate(sql, batch).length;
    }

    @Override
    public int disableEmpRelation(String ORGN_SET_ID_, String EMP_RELATION_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql = "update OM_EMP_RELATION set EMP_RELATION_STATUS_ = '0', UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and EMP_RELATION_ID_ = ?";
        return omJdbcTemplate.update(sql, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, EMP_RELATION_ID_);
    }

    @Override
    public int enableEmpRelation(String ORGN_SET_ID_, String EMP_RELATION_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql = "update OM_EMP_RELATION set EMP_RELATION_STATUS_ = '1', UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and EMP_RELATION_ID_ = ?";
        return omJdbcTemplate.update(sql, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, EMP_RELATION_ID_);
    }

    @Override
    public int deleteEmpRelation(String ORGN_SET_ID_, String EMP_RELATION_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        omTagService.deleteTagByObjId(ORGN_SET_ID_, EMP_RELATION_ID_);

        String sql = "delete from OM_EMP_RELATION where ORGN_SET_ID_ = ? and EMP_RELATION_ID_ = ?";
        return omJdbcTemplate.update(sql, ORGN_SET_ID_, EMP_RELATION_ID_);
    }

    @Override
    public int deleteEmpRelationByEmpId(String ORGN_SET_ID_, String EMP_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        List<Map<String, Object>> upperEmpRelationList = selectEmpRelation(null, null, null, EMP_ID_, null, null, null, null, null, 1, -1, OPERATOR_ID_, OPERATOR_NAME_);
        for (Map<String, Object> empRelation : upperEmpRelationList) {
            deleteEmpRelation(ORGN_SET_ID_, (String) empRelation.get("EMP_RELATION_ID_"), UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_);
        }
        List<Map<String, Object>> lowerEmpRelationList = selectEmpRelation(null, null, null, null, EMP_ID_, null, null, null, null, 1, -1, OPERATOR_ID_, OPERATOR_NAME_);
        for (Map<String, Object> empRelation : lowerEmpRelationList) {
            deleteEmpRelation(ORGN_SET_ID_, (String) empRelation.get("EMP_RELATION_ID_"), UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_);
        }

        return upperEmpRelationList.size() + lowerEmpRelationList.size();
    }
}