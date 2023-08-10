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
import com.opendynamic.om.service.OmDutyService;
import com.opendynamic.om.service.OmOrgnSetService;
import com.opendynamic.om.service.OmTagService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OmDutyServiceImpl implements OmDutyService {
    @Autowired
    private OmOrgnSetService omOrgnSetService;
    @Autowired
    private OmTagService omTagService;
    @Autowired
    private JdbcTemplate omJdbcTemplate;

    @Override
    public Map<String, Object> loadDuty(String ORGN_SET_ID_, String ORGN_SET_CODE_, String DUTY_ID_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_) && StringUtils.isEmpty(ORGN_SET_CODE_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }
        if (StringUtils.isEmpty(DUTY_ID_)) {
            throw new RuntimeException("errors.idRequired");
        }

        String sql = "select * from OMV_DUTY where DUTY_ID_ = :DUTY_ID_";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("DUTY_ID_", DUTY_ID_);

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
    public Map<String, Object> loadDutyByCode(String ORGN_SET_ID_, String ORGN_SET_CODE_, String DUTY_CODE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_) && StringUtils.isEmpty(ORGN_SET_CODE_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }
        if (StringUtils.isEmpty(DUTY_CODE_)) {
            throw new RuntimeException("errors.codeRequired");
        }

        String sql = "select * from OMV_DUTY where DUTY_CODE_ = :DUTY_CODE_";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("DUTY_CODE_", DUTY_CODE_);

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
    public List<Map<String, Object>> selectDuty(String ORGN_SET_ID_, String ORGN_SET_CODE_, String DUTY_ID_, List<String> DUTY_ID_LIST, String DUTY_CODE_, List<String> DUTY_CODE_LIST, String DUTY_NAME_, List<String> DUTY_NAME_LIST, String DUTY_CATEGORY_, List<String> DUTY_CATEGORY_LIST, String DUTY_TAG_, String DUTY_EXT_ATTR_1_, List<String> DUTY_EXT_ATTR_1_LIST, String DUTY_EXT_ATTR_2_, List<String> DUTY_EXT_ATTR_2_LIST, String DUTY_EXT_ATTR_3_, List<String> DUTY_EXT_ATTR_3_LIST, String DUTY_EXT_ATTR_4_, List<String> DUTY_EXT_ATTR_4_LIST, String DUTY_EXT_ATTR_5_, List<String> DUTY_EXT_ATTR_5_LIST, String DUTY_EXT_ATTR_6_, List<String> DUTY_EXT_ATTR_6_LIST, String DUTY_EXT_ATTR_7_, List<String> DUTY_EXT_ATTR_7_LIST, String DUTY_EXT_ATTR_8_, List<String> DUTY_EXT_ATTR_8_LIST,
            String DUTY_STATUS_, List<String> DUTY_STATUS_LIST, Boolean dutyTagUnion, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaDuty(false, ORGN_SET_ID_, ORGN_SET_CODE_, DUTY_ID_, DUTY_ID_LIST, DUTY_CODE_, DUTY_CODE_LIST, DUTY_NAME_, DUTY_NAME_LIST, DUTY_CATEGORY_, DUTY_CATEGORY_LIST, DUTY_TAG_, DUTY_EXT_ATTR_1_, DUTY_EXT_ATTR_1_LIST, DUTY_EXT_ATTR_2_, DUTY_EXT_ATTR_2_LIST, DUTY_EXT_ATTR_3_, DUTY_EXT_ATTR_3_LIST, DUTY_EXT_ATTR_4_, DUTY_EXT_ATTR_4_LIST, DUTY_EXT_ATTR_5_, DUTY_EXT_ATTR_5_LIST, DUTY_EXT_ATTR_6_, DUTY_EXT_ATTR_6_LIST, DUTY_EXT_ATTR_7_, DUTY_EXT_ATTR_7_LIST, DUTY_EXT_ATTR_8_, DUTY_EXT_ATTR_8_LIST, DUTY_STATUS_, DUTY_STATUS_LIST, dutyTagUnion, OPERATOR_ID_, OPERATOR_NAME_);// 根据查询条件组装查询SQL语句
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
    public int countDuty(String ORGN_SET_ID_, String ORGN_SET_CODE_, String DUTY_ID_, List<String> DUTY_ID_LIST, String DUTY_CODE_, List<String> DUTY_CODE_LIST, String DUTY_NAME_, List<String> DUTY_NAME_LIST, String DUTY_CATEGORY_, List<String> DUTY_CATEGORY_LIST, String DUTY_TAG_, String DUTY_EXT_ATTR_1_, List<String> DUTY_EXT_ATTR_1_LIST, String DUTY_EXT_ATTR_2_, List<String> DUTY_EXT_ATTR_2_LIST, String DUTY_EXT_ATTR_3_, List<String> DUTY_EXT_ATTR_3_LIST, String DUTY_EXT_ATTR_4_, List<String> DUTY_EXT_ATTR_4_LIST, String DUTY_EXT_ATTR_5_, List<String> DUTY_EXT_ATTR_5_LIST, String DUTY_EXT_ATTR_6_, List<String> DUTY_EXT_ATTR_6_LIST, String DUTY_EXT_ATTR_7_, List<String> DUTY_EXT_ATTR_7_LIST, String DUTY_EXT_ATTR_8_, List<String> DUTY_EXT_ATTR_8_LIST, String DUTY_STATUS_,
            List<String> DUTY_STATUS_LIST, Boolean dutyTagUnion, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaDuty(true, ORGN_SET_ID_, ORGN_SET_CODE_, DUTY_ID_, DUTY_ID_LIST, DUTY_CODE_, DUTY_CODE_LIST, DUTY_NAME_, DUTY_NAME_LIST, DUTY_CATEGORY_, DUTY_CATEGORY_LIST, DUTY_TAG_, DUTY_EXT_ATTR_1_, DUTY_EXT_ATTR_1_LIST, DUTY_EXT_ATTR_2_, DUTY_EXT_ATTR_2_LIST, DUTY_EXT_ATTR_3_, DUTY_EXT_ATTR_3_LIST, DUTY_EXT_ATTR_4_, DUTY_EXT_ATTR_4_LIST, DUTY_EXT_ATTR_5_, DUTY_EXT_ATTR_5_LIST, DUTY_EXT_ATTR_6_, DUTY_EXT_ATTR_6_LIST, DUTY_EXT_ATTR_7_, DUTY_EXT_ATTR_7_LIST, DUTY_EXT_ATTR_8_, DUTY_EXT_ATTR_8_LIST, DUTY_STATUS_, DUTY_STATUS_LIST, dutyTagUnion, OPERATOR_ID_, OPERATOR_NAME_);// 根据查询条件组装总数查询SQL语句
        String sql = odSqlCriteria.getSql();
        Map<String, Object> paramMap = odSqlCriteria.getParamMap();

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    private OdSqlCriteria buildSqlCriteriaDuty(boolean count, String ORGN_SET_ID_, String ORGN_SET_CODE_, String DUTY_ID_, List<String> DUTY_ID_LIST, String DUTY_CODE_, List<String> DUTY_CODE_LIST, String DUTY_NAME_, List<String> DUTY_NAME_LIST, String DUTY_CATEGORY_, List<String> DUTY_CATEGORY_LIST, String DUTY_TAG_, String DUTY_EXT_ATTR_1_, List<String> DUTY_EXT_ATTR_1_LIST, String DUTY_EXT_ATTR_2_, List<String> DUTY_EXT_ATTR_2_LIST, String DUTY_EXT_ATTR_3_, List<String> DUTY_EXT_ATTR_3_LIST, String DUTY_EXT_ATTR_4_, List<String> DUTY_EXT_ATTR_4_LIST, String DUTY_EXT_ATTR_5_, List<String> DUTY_EXT_ATTR_5_LIST, String DUTY_EXT_ATTR_6_, List<String> DUTY_EXT_ATTR_6_LIST, String DUTY_EXT_ATTR_7_, List<String> DUTY_EXT_ATTR_7_LIST, String DUTY_EXT_ATTR_8_, List<String> DUTY_EXT_ATTR_8_LIST,
            String DUTY_STATUS_, List<String> DUTY_STATUS_LIST, Boolean dutyTagUnion, String OPERATOR_ID_, String OPERATOR_NAME_) {// 组装查询SQL语句
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
            sql = "select count(*) from OMV_DUTY where 1 = 1";
        }
        else {
            sql = "select * from OMV_DUTY where 1 = 1";
        }

        if (StringUtils.isNotEmpty(ORGN_SET_ID_)) {
            sql += " and ORGN_SET_ID_ = :ORGN_SET_ID_";
            paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        }
        if (StringUtils.isNotEmpty(ORGN_SET_CODE_)) {
            sql += " and ORGN_SET_CODE_ = :ORGN_SET_CODE_";
            paramMap.put("ORGN_SET_CODE_", ORGN_SET_CODE_);
        }
        if (StringUtils.isNotEmpty(DUTY_ID_)) {
            sql += " and DUTY_ID_ = :DUTY_ID_";
            paramMap.put("DUTY_ID_", DUTY_ID_);
        }
        if (DUTY_ID_LIST != null && DUTY_ID_LIST.size() > 0) {
            sql += " and DUTY_ID_ in (:DUTY_ID_LIST)";
            paramMap.put("DUTY_ID_LIST", DUTY_ID_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_CODE_)) {
            sql += " and DUTY_CODE_ = :DUTY_CODE_";
            paramMap.put("DUTY_CODE_", DUTY_CODE_);
        }
        if (DUTY_CODE_LIST != null && DUTY_CODE_LIST.size() > 0) {
            sql += " and DUTY_CODE_ in (:DUTY_CODE_LIST)";
            paramMap.put("DUTY_CODE_LIST", DUTY_CODE_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_NAME_)) {
            sql += " and DUTY_NAME_ like '%' || :DUTY_NAME_ || '%'";
            paramMap.put("DUTY_NAME_", DUTY_NAME_);
        }
        if (DUTY_NAME_LIST != null && DUTY_NAME_LIST.size() > 0) {
            sql += " and DUTY_NAME_ in (:DUTY_NAME_LIST)";
            paramMap.put("DUTY_NAME_LIST", DUTY_NAME_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_CATEGORY_)) {
            sql += " and DUTY_CATEGORY_ = :DUTY_CATEGORY_";
            paramMap.put("DUTY_CATEGORY_", DUTY_CATEGORY_);
        }
        if (DUTY_CATEGORY_LIST != null && DUTY_CATEGORY_LIST.size() > 0) {
            sql += " and DUTY_CATEGORY_ in (:DUTY_CATEGORY_LIST)";
            paramMap.put("DUTY_CATEGORY_LIST", DUTY_CATEGORY_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_TAG_)) {
            List<String> tagList = omTagService.splitTag(DUTY_TAG_);
            if (tagList.size() > 0) {
                if (dutyTagUnion != null && dutyTagUnion.equals(false)) {
                    sql += " and DUTY_ID_ in (select DUTY_ID_ from (select OBJ_ID_ as DUTY_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'DUTY' and TAG_ in (:DUTY_TAG_LIST)) T group by DUTY_ID_ having count(*) >= 1)";
                    paramMap.put("DUTY_TAG_LIST", tagList);
                }
                else {
                    sql += " and DUTY_ID_ in (select DUTY_ID_ from (select OBJ_ID_ as DUTY_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'DUTY' and TAG_ in (:DUTY_TAG_LIST)) T group by DUTY_ID_ having count(*) >= :dutyTagCount)";
                    paramMap.put("DUTY_TAG_LIST", tagList);
                    paramMap.put("dutyTagCount", tagList.size());
                }
            }
        }
        if (StringUtils.isNotEmpty(DUTY_EXT_ATTR_1_)) {
            sql += " and DUTY_EXT_ATTR_1_ = :DUTY_EXT_ATTR_1_";
            paramMap.put("DUTY_EXT_ATTR_1_", DUTY_EXT_ATTR_1_);
        }
        if (DUTY_EXT_ATTR_1_LIST != null && DUTY_EXT_ATTR_1_LIST.size() > 0) {
            sql += " and DUTY_EXT_ATTR_1_ in (:DUTY_EXT_ATTR_1_LIST)";
            paramMap.put("DUTY_EXT_ATTR_1_LIST", DUTY_EXT_ATTR_1_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_EXT_ATTR_2_)) {
            sql += " and DUTY_EXT_ATTR_2_ = :DUTY_EXT_ATTR_2_";
            paramMap.put("DUTY_EXT_ATTR_2_", DUTY_EXT_ATTR_2_);
        }
        if (DUTY_EXT_ATTR_2_LIST != null && DUTY_EXT_ATTR_2_LIST.size() > 0) {
            sql += " and DUTY_EXT_ATTR_2_ in (:DUTY_EXT_ATTR_2_LIST)";
            paramMap.put("DUTY_EXT_ATTR_2_LIST", DUTY_EXT_ATTR_2_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_EXT_ATTR_3_)) {
            sql += " and DUTY_EXT_ATTR_3_ = :DUTY_EXT_ATTR_3_";
            paramMap.put("DUTY_EXT_ATTR_3_", DUTY_EXT_ATTR_3_);
        }
        if (DUTY_EXT_ATTR_3_LIST != null && DUTY_EXT_ATTR_3_LIST.size() > 0) {
            sql += " and DUTY_EXT_ATTR_3_ in (:DUTY_EXT_ATTR_3_LIST)";
            paramMap.put("DUTY_EXT_ATTR_3_LIST", DUTY_EXT_ATTR_3_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_EXT_ATTR_4_)) {
            sql += " and DUTY_EXT_ATTR_4_ = :DUTY_EXT_ATTR_4_";
            paramMap.put("DUTY_EXT_ATTR_4_", DUTY_EXT_ATTR_4_);
        }
        if (DUTY_EXT_ATTR_4_LIST != null && DUTY_EXT_ATTR_4_LIST.size() > 0) {
            sql += " and DUTY_EXT_ATTR_4_ in (:DUTY_EXT_ATTR_4_LIST)";
            paramMap.put("DUTY_EXT_ATTR_4_LIST", DUTY_EXT_ATTR_4_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_EXT_ATTR_5_)) {
            sql += " and DUTY_EXT_ATTR_5_ = :DUTY_EXT_ATTR_5_";
            paramMap.put("DUTY_EXT_ATTR_5_", DUTY_EXT_ATTR_5_);
        }
        if (DUTY_EXT_ATTR_5_LIST != null && DUTY_EXT_ATTR_5_LIST.size() > 0) {
            sql += " and DUTY_EXT_ATTR_5_ in (:DUTY_EXT_ATTR_5_LIST)";
            paramMap.put("DUTY_EXT_ATTR_5_LIST", DUTY_EXT_ATTR_5_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_EXT_ATTR_6_)) {
            sql += " and DUTY_EXT_ATTR_6_ = :DUTY_EXT_ATTR_6_";
            paramMap.put("DUTY_EXT_ATTR_6_", DUTY_EXT_ATTR_6_);
        }
        if (DUTY_EXT_ATTR_6_LIST != null && DUTY_EXT_ATTR_6_LIST.size() > 0) {
            sql += " and DUTY_EXT_ATTR_6_ in (:DUTY_EXT_ATTR_6_LIST)";
            paramMap.put("DUTY_EXT_ATTR_6_LIST", DUTY_EXT_ATTR_6_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_EXT_ATTR_7_)) {
            sql += " and DUTY_EXT_ATTR_7_ = :DUTY_EXT_ATTR_7_";
            paramMap.put("DUTY_EXT_ATTR_7_", DUTY_EXT_ATTR_7_);
        }
        if (DUTY_EXT_ATTR_7_LIST != null && DUTY_EXT_ATTR_7_LIST.size() > 0) {
            sql += " and DUTY_EXT_ATTR_7_ in (:DUTY_EXT_ATTR_7_LIST)";
            paramMap.put("DUTY_EXT_ATTR_7_LIST", DUTY_EXT_ATTR_7_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_EXT_ATTR_8_)) {
            sql += " and DUTY_EXT_ATTR_8_ = :DUTY_EXT_ATTR_8_";
            paramMap.put("DUTY_EXT_ATTR_8_", DUTY_EXT_ATTR_8_);
        }
        if (DUTY_EXT_ATTR_8_LIST != null && DUTY_EXT_ATTR_8_LIST.size() > 0) {
            sql += " and DUTY_EXT_ATTR_8_ in (:DUTY_EXT_ATTR_8_LIST)";
            paramMap.put("DUTY_EXT_ATTR_8_LIST", DUTY_EXT_ATTR_8_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_STATUS_)) {
            sql += " and DUTY_STATUS_ = :DUTY_STATUS_";
            paramMap.put("DUTY_STATUS_", DUTY_STATUS_);
        }
        if (DUTY_STATUS_LIST != null && DUTY_STATUS_LIST.size() > 0) {
            sql += " and DUTY_STATUS_ in (:DUTY_STATUS_LIST)";
            paramMap.put("DUTY_STATUS_LIST", DUTY_STATUS_LIST);
        }

        if (!count) {
            sql += " order by ORDER_, DUTY_ID_";
        }

        return new OdSqlCriteria(sql, paramMap);
    }

    @Override
    public List<Map<String, Object>> selectDutyByIdList(String ORGN_SET_ID_, List<String> DUTY_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (DUTY_ID_LIST == null || DUTY_ID_LIST.size() == 0) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder(DUTY_ID_LIST.size() * 50 + 200);
        Map<String, Object> paramMap = new HashMap<String, Object>();

        sql.append("select * from OMV_DUTY where ORGN_SET_ID_ = :ORGN_SET_ID_ and DUTY_ID_ in (:DUTY_ID_LIST)");
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        paramMap.put("DUTY_ID_LIST", DUTY_ID_LIST);
        sql.append(" order by DECODE(DUTY_ID_,");// 按主键列表顺序排序
        for (int i = 0; i < DUTY_ID_LIST.size(); i++) {
            sql.append(" '").append(DUTY_ID_LIST.get(i)).append("', ").append(i);
            if (i < DUTY_ID_LIST.size() - 1) {
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
    public List<Map<String, Object>> selectProtoDutyByIdList(String ORGN_SET_ID_, List<String> DUTY_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (DUTY_ID_LIST == null || DUTY_ID_LIST.size() == 0) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder(DUTY_ID_LIST.size() * 50 + 200);
        Map<String, Object> paramMap = new HashMap<String, Object>();

        sql.append("select * from OM_DUTY where ORGN_SET_ID_ = :ORGN_SET_ID_ and DUTY_ID_ in (:DUTY_ID_LIST)");
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        paramMap.put("DUTY_ID_LIST", DUTY_ID_LIST);
        sql.append(" order by DECODE(DUTY_ID_,");// 按主键列表顺序排序
        for (int i = 0; i < DUTY_ID_LIST.size(); i++) {
            sql.append(" '").append(DUTY_ID_LIST.get(i)).append("', ").append(i);
            if (i < DUTY_ID_LIST.size() - 1) {
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
    public int insertDuty(String ORGN_SET_ID_, String DUTY_ID_, String DUTY_CODE_, String DUTY_NAME_, String DUTY_CATEGORY_, String MEMO_, String DUTY_TAG_, String DUTY_EXT_ATTR_1_, String DUTY_EXT_ATTR_2_, String DUTY_EXT_ATTR_3_, String DUTY_EXT_ATTR_4_, String DUTY_EXT_ATTR_5_, String DUTY_EXT_ATTR_6_, String DUTY_EXT_ATTR_7_, String DUTY_EXT_ATTR_8_, Integer ORDER_, String DUTY_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        DUTY_TAG_ = StringUtils.join(omTagService.splitTag(DUTY_TAG_), ",");
        omTagService.updateTagByObjId(ORGN_SET_ID_, DUTY_ID_, "DUTY", DUTY_TAG_);

        String sql = "insert into OM_DUTY (ORGN_SET_ID_, DUTY_ID_, DUTY_CODE_, DUTY_NAME_, DUTY_CATEGORY_, MEMO_, DUTY_TAG_, DUTY_EXT_ATTR_1_, DUTY_EXT_ATTR_2_, DUTY_EXT_ATTR_3_, DUTY_EXT_ATTR_4_, DUTY_EXT_ATTR_5_, DUTY_EXT_ATTR_6_, DUTY_EXT_ATTR_7_, DUTY_EXT_ATTR_8_, ORDER_, DUTY_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return omJdbcTemplate.update(sql, ORGN_SET_ID_, DUTY_ID_, DUTY_CODE_, DUTY_NAME_, DUTY_CATEGORY_, MEMO_, DUTY_TAG_, DUTY_EXT_ATTR_1_, DUTY_EXT_ATTR_2_, DUTY_EXT_ATTR_3_, DUTY_EXT_ATTR_4_, DUTY_EXT_ATTR_5_, DUTY_EXT_ATTR_6_, DUTY_EXT_ATTR_7_, DUTY_EXT_ATTR_8_, ORDER_, DUTY_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_);
    }

    @Override
    public int updateDuty(String ORGN_SET_ID_, String DUTY_ID_, String DUTY_CODE_, String DUTY_NAME_, String DUTY_CATEGORY_, String MEMO_, String DUTY_TAG_, String DUTY_EXT_ATTR_1_, String DUTY_EXT_ATTR_2_, String DUTY_EXT_ATTR_3_, String DUTY_EXT_ATTR_4_, String DUTY_EXT_ATTR_5_, String DUTY_EXT_ATTR_6_, String DUTY_EXT_ATTR_7_, String DUTY_EXT_ATTR_8_, Integer ORDER_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        DUTY_TAG_ = StringUtils.join(omTagService.splitTag(DUTY_TAG_), ",");
        omTagService.updateTagByObjId(ORGN_SET_ID_, DUTY_ID_, "DUTY", DUTY_TAG_);

        String sql = "update OM_DUTY set DUTY_CODE_ = ?, DUTY_NAME_ = ?, DUTY_CATEGORY_ = ?, MEMO_ = ?, DUTY_TAG_ = ?, DUTY_EXT_ATTR_1_ = ?, DUTY_EXT_ATTR_2_ = ?, DUTY_EXT_ATTR_3_ = ?, DUTY_EXT_ATTR_4_ = ?, DUTY_EXT_ATTR_5_ = ?, DUTY_EXT_ATTR_6_ = ?, DUTY_EXT_ATTR_7_ = ?, DUTY_EXT_ATTR_8_ = ?, ORDER_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and DUTY_ID_ = ?";
        return omJdbcTemplate.update(sql, DUTY_CODE_, DUTY_NAME_, DUTY_CATEGORY_, MEMO_, DUTY_TAG_, DUTY_EXT_ATTR_1_, DUTY_EXT_ATTR_2_, DUTY_EXT_ATTR_3_, DUTY_EXT_ATTR_4_, DUTY_EXT_ATTR_5_, DUTY_EXT_ATTR_6_, DUTY_EXT_ATTR_7_, DUTY_EXT_ATTR_8_, ORDER_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, DUTY_ID_);
    }

    @Override
    public int updateDutyOrder(final String ORGN_SET_ID_, final List<String> DUTY_ID_LIST, final List<Integer> ORDER_LIST, final Date UPDATE_DATE_, final String OPERATOR_ID_, final String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (DUTY_ID_LIST == null || DUTY_ID_LIST.size() == 0) {
            return 0;
        }
        if (DUTY_ID_LIST.size() != ORDER_LIST.size()) {
            return 0;
        }

        String sql = "update OM_DUTY set ORDER_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and DUTY_ID_ = ?";
        BatchPreparedStatementSetter batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, ORDER_LIST.get(i));
                ps.setTimestamp(2, UPDATE_DATE_ == null ? null : new java.sql.Timestamp(UPDATE_DATE_.getTime()));
                ps.setString(3, OPERATOR_ID_);
                ps.setString(4, OPERATOR_NAME_);
                ps.setString(5, ORGN_SET_ID_);
                ps.setString(6, DUTY_ID_LIST.get(i));
            }

            public int getBatchSize() {
                return DUTY_ID_LIST.size();
            }
        };

        return omJdbcTemplate.batchUpdate(sql, batch).length;
    }

    @Override
    public int disableDuty(String ORGN_SET_ID_, String DUTY_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql = "update OM_DUTY set DUTY_STATUS_ = '0', UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and DUTY_ID_ = ?";
        return omJdbcTemplate.update(sql, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, DUTY_ID_);
    }

    @Override
    public int enableDuty(String ORGN_SET_ID_, String DUTY_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql = "update OM_DUTY set DUTY_STATUS_ = '1', UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and DUTY_ID_ = ?";
        return omJdbcTemplate.update(sql, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, DUTY_ID_);
    }

    @Override
    public int deleteDuty(String ORGN_SET_ID_, String DUTY_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        omTagService.deleteTagByObjId(ORGN_SET_ID_, DUTY_ID_);

        String sql = "delete from OM_DUTY where ORGN_SET_ID_ = ? and DUTY_ID_ = ?";
        return omJdbcTemplate.update(sql, ORGN_SET_ID_, DUTY_ID_);
    }
}