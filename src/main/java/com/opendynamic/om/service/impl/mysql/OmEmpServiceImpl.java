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
import com.opendynamic.om.service.OmEmpService;
import com.opendynamic.om.service.OmTagService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OmEmpServiceImpl implements OmEmpService {
    @Autowired
    private OmTagService omTagService;
    @Autowired
    private JdbcTemplate omJdbcTemplate;

    @Override
    public Map<String, Object> loadEmp(String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_ID_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_) && StringUtils.isEmpty(ORGN_SET_CODE_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }
        if (StringUtils.isEmpty(EMP_ID_)) {
            throw new RuntimeException("errors.idRequired");
        }

        String sql = "select * from OMV_EMP where EMP_ID_ = :EMP_ID_";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("EMP_ID_", EMP_ID_);

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
    public Map<String, Object> loadEmpByCode(String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_CODE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_) && StringUtils.isEmpty(ORGN_SET_CODE_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }
        if (StringUtils.isEmpty(EMP_CODE_)) {
            throw new RuntimeException("errors.codeRequired");
        }

        String sql = "select * from OMV_EMP where EMP_CODE_ = :EMP_CODE_";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("EMP_CODE_", EMP_CODE_);

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
    public Map<String, Object> loadEmpByPassword(String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_CODE_, String PASSWORD_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_) && StringUtils.isEmpty(ORGN_SET_CODE_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }
        if (StringUtils.isEmpty(EMP_CODE_)) {
            throw new RuntimeException("errors.codeRequired");
        }

        Map<String, Object> emp = loadEmpByCode(ORGN_SET_ID_, ORGN_SET_CODE_, EMP_CODE_, OPERATOR_ID_, OPERATOR_NAME_);
        if (emp == null) {
            return null;
        }
        String sql = "select * from OM_EMP where ORGN_SET_ID_ = ? and EMP_ID_ = ? and PASSWORD_ = ?";
        List<Map<String, Object>> result = omJdbcTemplate.queryForList(sql, emp.get("ORGN_SET_ID_"), emp.get("EMP_ID_"), PASSWORD_);
        if (result.size() == 1) {
            return emp;
        }
        else {
            return null;
        }
    }

    @Override
    public List<Map<String, Object>> selectEmp(String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_ID_, String ORG_ID_, String EMP_CODE_, String EMP_NAME_, List<String> CATEGORY_LIST, String EMP_TAG_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, String EXT_ATTR_7_, String EXT_ATTR_8_, List<String> EMP_STATUS_LIST, Boolean tagUnion, String withinOrgId, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaEmp(false, ORGN_SET_ID_, ORGN_SET_CODE_, EMP_ID_, ORG_ID_, EMP_CODE_, EMP_NAME_, CATEGORY_LIST, EMP_TAG_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, EXT_ATTR_7_, EXT_ATTR_8_, EMP_STATUS_LIST, tagUnion, withinOrgId, OPERATOR_ID_, OPERATOR_NAME_);// 根据查询条件组装查询SQL语句
        String sql = odSqlCriteria.getSql();
        Map<String, Object> paramMap = odSqlCriteria.getParamMap();

        if (page != null && limit != null && limit > 0) {// 分页
            sql = sql + " limit " + (page - 1) * limit + ", " + limit;
        }

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForList(sql, paramMap);
    }

    @Override
    public int countEmp(String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_ID_, String ORG_ID_, String EMP_CODE_, String EMP_NAME_, List<String> CATEGORY_LIST, String EMP_TAG_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, String EXT_ATTR_7_, String EXT_ATTR_8_, List<String> EMP_STATUS_LIST, Boolean tagUnion, String withinOrgId, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaEmp(true, ORGN_SET_ID_, ORGN_SET_CODE_, EMP_ID_, ORG_ID_, EMP_CODE_, EMP_NAME_, CATEGORY_LIST, EMP_TAG_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, EXT_ATTR_7_, EXT_ATTR_8_, EMP_STATUS_LIST, tagUnion, withinOrgId, OPERATOR_ID_, OPERATOR_NAME_);// 根据查询条件组装总数查询SQL语句
        String sql = odSqlCriteria.getSql();
        Map<String, Object> paramMap = odSqlCriteria.getParamMap();

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    private OdSqlCriteria buildSqlCriteriaEmp(boolean count, String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_ID_, String ORG_ID_, String EMP_CODE_, String EMP_NAME_, List<String> CATEGORY_LIST, String EMP_TAG_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, String EXT_ATTR_7_, String EXT_ATTR_8_, List<String> EMP_STATUS_LIST, Boolean tagUnion, String withinOrgId, String OPERATOR_ID_, String OPERATOR_NAME_) {// 组装查询SQL语句
        if (StringUtils.isEmpty(ORGN_SET_ID_) && StringUtils.isEmpty(ORGN_SET_CODE_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql;
        Map<String, Object> paramMap = new HashMap<String, Object>();

        if (count) {
            sql = "select count(*) from OMV_EMP where 1 = 1";
        }
        else {
            sql = "select * from OMV_EMP where 1 = 1";
        }

        if (StringUtils.isNotEmpty(ORGN_SET_ID_)) {
            sql += " and ORGN_SET_ID_ = :ORGN_SET_ID_";
            paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        }
        if (StringUtils.isNotEmpty(ORGN_SET_CODE_)) {
            sql += " and ORGN_SET_CODE_ = :ORGN_SET_CODE_";
            paramMap.put("ORGN_SET_CODE_", ORGN_SET_CODE_);
        }
        if (StringUtils.isNotEmpty(EMP_ID_)) {
            sql += " and EMP_ID_ = :EMP_ID_";
            paramMap.put("EMP_ID_", EMP_ID_);
        }
        if (StringUtils.isNotEmpty(ORG_ID_)) {
            sql += " and ORG_ID_ = :ORG_ID_";
            paramMap.put("ORG_ID_", ORG_ID_);
        }
        if (StringUtils.isNotEmpty(EMP_CODE_)) {
            sql += " and EMP_CODE_ = :EMP_CODE_";
            paramMap.put("EMP_CODE_", EMP_CODE_);
        }
        if (StringUtils.isNotEmpty(EMP_NAME_)) {
            sql += " and EMP_NAME_like concat('%',:EMP_NAME_,'%')";
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
        if (StringUtils.isNotEmpty(EXT_ATTR_1_)) {
            sql += " and EXT_ATTR_1_ = :EXT_ATTR_1_";
            paramMap.put("EXT_ATTR_1_", EXT_ATTR_1_);
        }
        if (StringUtils.isNotEmpty(EXT_ATTR_2_)) {
            sql += " and EXT_ATTR_2_ = :EXT_ATTR_2_";
            paramMap.put("EXT_ATTR_2_", EXT_ATTR_2_);
        }
        if (StringUtils.isNotEmpty(EXT_ATTR_3_)) {
            sql += " and EXT_ATTR_3_ = :EXT_ATTR_3_";
            paramMap.put("EXT_ATTR_3_", EXT_ATTR_3_);
        }
        if (StringUtils.isNotEmpty(EXT_ATTR_4_)) {
            sql += " and EXT_ATTR_4_ = :EXT_ATTR_4_";
            paramMap.put("EXT_ATTR_4_", EXT_ATTR_4_);
        }
        if (StringUtils.isNotEmpty(EXT_ATTR_5_)) {
            sql += " and EXT_ATTR_5_ = :EXT_ATTR_5_";
            paramMap.put("EXT_ATTR_5_", EXT_ATTR_5_);
        }
        if (StringUtils.isNotEmpty(EXT_ATTR_6_)) {
            sql += " and EXT_ATTR_6_ = :EXT_ATTR_6_";
            paramMap.put("EXT_ATTR_6_", EXT_ATTR_6_);
        }
        if (StringUtils.isNotEmpty(EXT_ATTR_7_)) {
            sql += " and EXT_ATTR_7_ = :EXT_ATTR_7_";
            paramMap.put("EXT_ATTR_7_", EXT_ATTR_7_);
        }
        if (StringUtils.isNotEmpty(EXT_ATTR_8_)) {
            sql += " and EXT_ATTR_8_ = :EXT_ATTR_8_";
            paramMap.put("EXT_ATTR_8_", EXT_ATTR_8_);
        }
        if (EMP_STATUS_LIST != null && EMP_STATUS_LIST.size() > 0) {
            sql += " and EMP_STATUS_ in (:EMP_STATUS_LIST)";
            paramMap.put("EMP_STATUS_LIST", EMP_STATUS_LIST);
        }

        if (StringUtils.isNotEmpty(withinOrgId)) {
            sql += " and ORG_ID_ in (with recursive CTE as (select ORG_ID_, PARENT_ORG_ID_ from OM_ORG where ORGN_SET_ID_ = :ORGN_SET_ID_ and ORG_ID_ = :withinOrgId union all select OM_ORG.ORG_ID_, OM_ORG.PARENT_ORG_ID_ from OM_ORG inner join CTE on ORGN_SET_ID_ = :ORGN_SET_ID_ and CTE.ORG_ID_ = OM_ORG.PARENT_ORG_ID_) select ORG_ID_ from CTE)";
            paramMap.put("withinOrgId", withinOrgId);
        }

        if (!count) {
            sql += " order by ORDER_";
        }

        return new OdSqlCriteria(sql, paramMap);
    }

    @Override
    public List<Map<String, Object>> selectEmpByIdList(String ORGN_SET_ID_, List<String> EMP_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (EMP_ID_LIST == null || EMP_ID_LIST.size() == 0) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder(EMP_ID_LIST.size() * 50 + 200);
        Map<String, Object> paramMap = new HashMap<String, Object>();

        sql.append("select * from OMV_EMP where ORGN_SET_ID_ = :ORGN_SET_ID_ and EMP_ID_ in (:EMP_ID_LIST)");
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        paramMap.put("EMP_ID_LIST", EMP_ID_LIST);
        sql.append(" order by FIELD(EMP_ID_,");// 按主键列表顺序排序
        for (int i = 0; i < EMP_ID_LIST.size(); i++) {
            sql.append(" '").append(EMP_ID_LIST.get(i)).append("'");
            if (i < EMP_ID_LIST.size() - 1) {
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
    public List<Map<String, Object>> selectProtoEmpByIdList(String ORGN_SET_ID_, List<String> EMP_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (EMP_ID_LIST == null || EMP_ID_LIST.size() == 0) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder(EMP_ID_LIST.size() * 50 + 200);
        Map<String, Object> paramMap = new HashMap<String, Object>();

        sql.append("select * from OM_EMP where ORGN_SET_ID_ = :ORGN_SET_ID_ and EMP_ID_ in (:EMP_ID_LIST)");
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        paramMap.put("EMP_ID_LIST", EMP_ID_LIST);
        sql.append(" order by FIELD(EMP_ID_,");// 按主键列表顺序排序
        for (int i = 0; i < EMP_ID_LIST.size(); i++) {
            sql.append(" '").append(EMP_ID_LIST.get(i)).append("'");
            if (i < EMP_ID_LIST.size() - 1) {
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
    public int insertEmp(String ORGN_SET_ID_, String EMP_ID_, String ORG_ID_, String EMP_CODE_, String EMP_NAME_, String PASSWORD_, String PASSWORD_RESET_REQ_, String PARTY_, String EMP_LEVEL_, String GENDER_, Date BIRTH_DATE_, String TEL_, String EMAIL_, Date IN_DATE_, Date OUT_DATE_, String CATEGORY_, String MEMO_, String EMP_TAG_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, String EXT_ATTR_7_, String EXT_ATTR_8_, Integer ORDER_, String EMP_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        EMP_TAG_ = StringUtils.join(omTagService.splitTag(EMP_TAG_), ",");
        omTagService.updateTagByObjId(ORGN_SET_ID_, EMP_ID_, "EMP", EMP_TAG_);

        String sql = "insert into OM_EMP (ORGN_SET_ID_, EMP_ID_, ORG_ID_, EMP_CODE_, EMP_NAME_, PASSWORD_, PASSWORD_RESET_REQ_, PARTY_, EMP_LEVEL_, GENDER_, BIRTH_DATE_, TEL_, EMAIL_, IN_DATE_, OUT_DATE_, CATEGORY_, MEMO_, EMP_TAG_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, EXT_ATTR_7_, EXT_ATTR_8_, ORDER_, EMP_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''))";
        return omJdbcTemplate.update(sql, ORGN_SET_ID_, EMP_ID_, ORG_ID_, EMP_CODE_, EMP_NAME_, PASSWORD_, PASSWORD_RESET_REQ_, PARTY_, EMP_LEVEL_, GENDER_, BIRTH_DATE_, TEL_, EMAIL_, IN_DATE_, OUT_DATE_, CATEGORY_, MEMO_, EMP_TAG_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, EXT_ATTR_7_, EXT_ATTR_8_, ORDER_, EMP_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_);
    }

    @Override
    public int updateEmp(String ORGN_SET_ID_, String EMP_ID_, String EMP_CODE_, String EMP_NAME_, String PARTY_, String EMP_LEVEL_, String GENDER_, Date BIRTH_DATE_, String TEL_, String EMAIL_, Date IN_DATE_, Date OUT_DATE_, String CATEGORY_, String MEMO_, String EMP_TAG_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, String EXT_ATTR_7_, String EXT_ATTR_8_, Integer ORDER_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        EMP_TAG_ = StringUtils.join(omTagService.splitTag(EMP_TAG_), ",");
        omTagService.updateTagByObjId(ORGN_SET_ID_, EMP_ID_, "EMP", EMP_TAG_);

        String sql = "update OM_EMP set EMP_CODE_ = NULLIF(?, ''), EMP_NAME_ = NULLIF(?, ''), PARTY_ = NULLIF(?, ''), EMP_LEVEL_ = NULLIF(?, ''), GENDER_ = NULLIF(?, ''), BIRTH_DATE_ = NULLIF(?, ''), TEL_ = NULLIF(?, ''), EMAIL_ = NULLIF(?, ''), IN_DATE_ = NULLIF(?, ''), OUT_DATE_ = NULLIF(?, ''), CATEGORY_ = NULLIF(?, ''), MEMO_ = NULLIF(?, ''), EMP_TAG_ = NULLIF(?, ''), EXT_ATTR_1_ = NULLIF(?, ''), EXT_ATTR_2_ = NULLIF(?, ''), EXT_ATTR_3_ = NULLIF(?, ''), EXT_ATTR_4_ = NULLIF(?, ''), EXT_ATTR_5_ = NULLIF(?, ''), EXT_ATTR_6_ = NULLIF(?, ''), EXT_ATTR_7_ = NULLIF(?, ''), EXT_ATTR_8_ = NULLIF(?, ''), ORDER_ = NULLIF(?, ''), UPDATE_DATE_ = NULLIF(?, ''), OPERATOR_ID_ = NULLIF(?, ''), OPERATOR_NAME_ = NULLIF(?, '') where ORGN_SET_ID_ = ? and EMP_ID_ = ?";
        return omJdbcTemplate.update(sql, EMP_CODE_, EMP_NAME_, PARTY_, EMP_LEVEL_, GENDER_, BIRTH_DATE_, TEL_, EMAIL_, IN_DATE_, OUT_DATE_, CATEGORY_, MEMO_, EMP_TAG_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, EXT_ATTR_7_, EXT_ATTR_8_, ORDER_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, EMP_ID_);
    }

    @Override
    public int updateEmpPassword(String ORGN_SET_ID_, String EMP_ID_, String OLD_PASSWORD_, String NEW_PASSWORD_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql = "update OM_EMP set PASSWORD_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and EMP_ID_ = ? and PASSWORD_ = ?";
        return omJdbcTemplate.update(sql, NEW_PASSWORD_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, EMP_ID_, OLD_PASSWORD_);
    }

    @Override
    public int resetEmpPassword(String ORGN_SET_ID_, String EMP_ID_, String PASSWORD_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql = "update OM_EMP set PASSWORD_ = ?, PASSWORD_RESET_REQ_ = '1', UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and EMP_ID_ = ?";
        return omJdbcTemplate.update(sql, PASSWORD_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, EMP_ID_);
    }

    @Override
    public int updateEmpOrder(final String ORGN_SET_ID_, final List<String> EMP_ID_LIST, final List<Integer> ORDER_LIST, final Date UPDATE_DATE_, final String OPERATOR_ID_, final String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (EMP_ID_LIST == null || EMP_ID_LIST.size() == 0) {
            return 0;
        }
        if (EMP_ID_LIST.size() != ORDER_LIST.size()) {
            return 0;
        }

        String sql = "update OM_EMP set ORDER_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and EMP_ID_ = ?";
        BatchPreparedStatementSetter batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, ORDER_LIST.get(i));
                ps.setTimestamp(2, UPDATE_DATE_ == null ? null : new java.sql.Timestamp(UPDATE_DATE_.getTime()));
                ps.setString(3, OPERATOR_ID_);
                ps.setString(4, OPERATOR_NAME_);
                ps.setString(5, ORGN_SET_ID_);
                ps.setString(6, EMP_ID_LIST.get(i));
            }

            public int getBatchSize() {
                return EMP_ID_LIST.size();
            }
        };

        return omJdbcTemplate.batchUpdate(sql, batch).length;
    }

    @Override
    public int moveEmp(String ORGN_SET_ID_, String EMP_ID_, String ORG_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql = "update OM_EMP set ORG_ID_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and EMP_ID_ = ?";
        return omJdbcTemplate.update(sql, ORG_ID_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, EMP_ID_);
    }

    @Override
    public int disableEmp(String ORGN_SET_ID_, String EMP_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql = "update OM_EMP set EMP_STATUS_ = '0', UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and EMP_ID_ = ?";
        return omJdbcTemplate.update(sql, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, EMP_ID_);
    }

    @Override
    public int enableEmp(String ORGN_SET_ID_, String EMP_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql = "update OM_EMP set EMP_STATUS_ = '1', UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and EMP_ID_ = ?";
        return omJdbcTemplate.update(sql, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, EMP_ID_);
    }

    @Override
    public int deleteEmp(String ORGN_SET_ID_, String EMP_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        omTagService.deleteTagByObjId(ORGN_SET_ID_, EMP_ID_);

        String sql = "delete from OM_EMP where ORGN_SET_ID_ = ? and EMP_ID_ = ?";
        return omJdbcTemplate.update(sql, ORGN_SET_ID_, EMP_ID_);
    }
}