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
import com.opendynamic.om.service.OmEmpRelationService;
import com.opendynamic.om.service.OmOrgnSetService;
import com.opendynamic.om.service.OmTagService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OmEmpRelationServiceImpl implements OmEmpRelationService {
    @Autowired
    private OmOrgnSetService omOrgnSetService;
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
        Map<String, Object> paramMap = new HashMap<>();
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
    public List<Map<String, Object>> selectEmpRelation(String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_RELATION_ID_, List<String> EMP_RELATION_ID_LIST, String EMP_RELATION_, List<String> EMP_RELATION_LIST, String EMP_RELATION_CATEGORY_, List<String> EMP_RELATION_CATEGORY_LIST, String EMP_RELATION_TAG_, String EMP_RELATION_EXT_ATTR_1_, List<String> EMP_RELATION_EXT_ATTR_1_LIST, String EMP_RELATION_EXT_ATTR_2_, List<String> EMP_RELATION_EXT_ATTR_2_LIST, String EMP_RELATION_EXT_ATTR_3_, List<String> EMP_RELATION_EXT_ATTR_3_LIST, String EMP_RELATION_EXT_ATTR_4_, List<String> EMP_RELATION_EXT_ATTR_4_LIST, String EMP_RELATION_EXT_ATTR_5_, List<String> EMP_RELATION_EXT_ATTR_5_LIST, String EMP_RELATION_EXT_ATTR_6_, List<String> EMP_RELATION_EXT_ATTR_6_LIST, String EMP_RELATION_EXT_ATTR_7_,
            List<String> EMP_RELATION_EXT_ATTR_7_LIST, String EMP_RELATION_EXT_ATTR_8_, List<String> EMP_RELATION_EXT_ATTR_8_LIST, String EMP_RELATION_STATUS_, List<String> EMP_RELATION_STATUS_LIST, String UPPER_EMP_ID_, List<String> UPPER_EMP_ID_LIST, String UPPER_EMP_CODE_, List<String> UPPER_EMP_CODE_LIST, String UPPER_EMP_NAME_, List<String> UPPER_EMP_NAME_LIST, String UPPER_EMP_CATEGORY_, List<String> UPPER_EMP_CATEGORY_LIST, String UPPER_EMP_TAG_, String UPPER_EMP_EXT_ATTR_1_, List<String> UPPER_EMP_EXT_ATTR_1_LIST, String UPPER_EMP_EXT_ATTR_2_, List<String> UPPER_EMP_EXT_ATTR_2_LIST, String UPPER_EMP_EXT_ATTR_3_, List<String> UPPER_EMP_EXT_ATTR_3_LIST, String UPPER_EMP_EXT_ATTR_4_, List<String> UPPER_EMP_EXT_ATTR_4_LIST, String UPPER_EMP_EXT_ATTR_5_,
            List<String> UPPER_EMP_EXT_ATTR_5_LIST, String UPPER_EMP_EXT_ATTR_6_, List<String> UPPER_EMP_EXT_ATTR_6_LIST, String UPPER_EMP_EXT_ATTR_7_, List<String> UPPER_EMP_EXT_ATTR_7_LIST, String UPPER_EMP_EXT_ATTR_8_, List<String> UPPER_EMP_EXT_ATTR_8_LIST, String UPPER_EMP_STATUS_, List<String> UPPER_EMP_STATUS_LIST, String UPPER_ORG_ID_, List<String> UPPER_ORG_ID_LIST, String UPPER_PARENT_ORG_ID_, List<String> UPPER_PARENT_ORG_ID_LIST, String UPPER_ORG_CODE_, List<String> UPPER_ORG_CODE_LIST, String UPPER_ORG_NAME_, List<String> UPPER_ORG_NAME_LIST, String UPPER_ORG_TYPE_, List<String> UPPER_ORG_TYPE_LIST, String UPPER_ORG_CATEGORY_, List<String> UPPER_ORG_CATEGORY_LIST, String UPPER_ORG_TAG_, String UPPER_ORG_EXT_ATTR_1_, List<String> UPPER_ORG_EXT_ATTR_1_LIST,
            String UPPER_ORG_EXT_ATTR_2_, List<String> UPPER_ORG_EXT_ATTR_2_LIST, String UPPER_ORG_EXT_ATTR_3_, List<String> UPPER_ORG_EXT_ATTR_3_LIST, String UPPER_ORG_EXT_ATTR_4_, List<String> UPPER_ORG_EXT_ATTR_4_LIST, String UPPER_ORG_EXT_ATTR_5_, List<String> UPPER_ORG_EXT_ATTR_5_LIST, String UPPER_ORG_EXT_ATTR_6_, List<String> UPPER_ORG_EXT_ATTR_6_LIST, String UPPER_ORG_EXT_ATTR_7_, List<String> UPPER_ORG_EXT_ATTR_7_LIST, String UPPER_ORG_EXT_ATTR_8_, List<String> UPPER_ORG_EXT_ATTR_8_LIST, String UPPER_ORG_STATUS_, List<String> UPPER_ORG_STATUS_LIST, String LOWER_EMP_ID_, List<String> LOWER_EMP_ID_LIST, String LOWER_EMP_CODE_, List<String> LOWER_EMP_CODE_LIST, String LOWER_EMP_NAME_, List<String> LOWER_EMP_NAME_LIST, String LOWER_EMP_CATEGORY_, List<String> LOWER_EMP_CATEGORY_LIST,
            String LOWER_EMP_TAG_, String LOWER_EMP_EXT_ATTR_1_, List<String> LOWER_EMP_EXT_ATTR_1_LIST, String LOWER_EMP_EXT_ATTR_2_, List<String> LOWER_EMP_EXT_ATTR_2_LIST, String LOWER_EMP_EXT_ATTR_3_, List<String> LOWER_EMP_EXT_ATTR_3_LIST, String LOWER_EMP_EXT_ATTR_4_, List<String> LOWER_EMP_EXT_ATTR_4_LIST, String LOWER_EMP_EXT_ATTR_5_, List<String> LOWER_EMP_EXT_ATTR_5_LIST, String LOWER_EMP_EXT_ATTR_6_, List<String> LOWER_EMP_EXT_ATTR_6_LIST, String LOWER_EMP_EXT_ATTR_7_, List<String> LOWER_EMP_EXT_ATTR_7_LIST, String LOWER_EMP_EXT_ATTR_8_, List<String> LOWER_EMP_EXT_ATTR_8_LIST, String LOWER_EMP_STATUS_, List<String> LOWER_EMP_STATUS_LIST, String LOWER_ORG_ID_, List<String> LOWER_ORG_ID_LIST, String LOWER_PARENT_ORG_ID_, List<String> LOWER_PARENT_ORG_ID_LIST,
            String LOWER_ORG_CODE_, List<String> LOWER_ORG_CODE_LIST, String LOWER_ORG_NAME_, List<String> LOWER_ORG_NAME_LIST, String LOWER_ORG_TYPE_, List<String> LOWER_ORG_TYPE_LIST, String LOWER_ORG_CATEGORY_, List<String> LOWER_ORG_CATEGORY_LIST, String LOWER_ORG_TAG_, String LOWER_ORG_EXT_ATTR_1_, List<String> LOWER_ORG_EXT_ATTR_1_LIST, String LOWER_ORG_EXT_ATTR_2_, List<String> LOWER_ORG_EXT_ATTR_2_LIST, String LOWER_ORG_EXT_ATTR_3_, List<String> LOWER_ORG_EXT_ATTR_3_LIST, String LOWER_ORG_EXT_ATTR_4_, List<String> LOWER_ORG_EXT_ATTR_4_LIST, String LOWER_ORG_EXT_ATTR_5_, List<String> LOWER_ORG_EXT_ATTR_5_LIST, String LOWER_ORG_EXT_ATTR_6_, List<String> LOWER_ORG_EXT_ATTR_6_LIST, String LOWER_ORG_EXT_ATTR_7_, List<String> LOWER_ORG_EXT_ATTR_7_LIST, String LOWER_ORG_EXT_ATTR_8_,
            List<String> LOWER_ORG_EXT_ATTR_8_LIST, String LOWER_ORG_STATUS_, List<String> LOWER_ORG_STATUS_LIST, Boolean empRelationTagUnion, Boolean upperEmpTagUnion, Boolean upperOrgTagUnion, String upperWithinOrgId, Boolean upperOrgRootOnly, Boolean lowerEmpTagUnion, Boolean lowerOrgTagUnion, String lowerWithinOrgId, Boolean lowerOrgRootOnly, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaEmpRelation(false, ORGN_SET_ID_, ORGN_SET_CODE_, EMP_RELATION_ID_, EMP_RELATION_ID_LIST, EMP_RELATION_, EMP_RELATION_LIST, EMP_RELATION_CATEGORY_, EMP_RELATION_CATEGORY_LIST, EMP_RELATION_TAG_, EMP_RELATION_EXT_ATTR_1_, EMP_RELATION_EXT_ATTR_1_LIST, EMP_RELATION_EXT_ATTR_2_, EMP_RELATION_EXT_ATTR_2_LIST, EMP_RELATION_EXT_ATTR_3_, EMP_RELATION_EXT_ATTR_3_LIST, EMP_RELATION_EXT_ATTR_4_, EMP_RELATION_EXT_ATTR_4_LIST, EMP_RELATION_EXT_ATTR_5_, EMP_RELATION_EXT_ATTR_5_LIST, EMP_RELATION_EXT_ATTR_6_, EMP_RELATION_EXT_ATTR_6_LIST, EMP_RELATION_EXT_ATTR_7_, EMP_RELATION_EXT_ATTR_7_LIST, EMP_RELATION_EXT_ATTR_8_, EMP_RELATION_EXT_ATTR_8_LIST, EMP_RELATION_STATUS_, EMP_RELATION_STATUS_LIST, UPPER_EMP_ID_, UPPER_EMP_ID_LIST, UPPER_EMP_CODE_,
                UPPER_EMP_CODE_LIST, UPPER_EMP_NAME_, UPPER_EMP_NAME_LIST, UPPER_EMP_CATEGORY_, UPPER_EMP_CATEGORY_LIST, UPPER_EMP_TAG_, UPPER_EMP_EXT_ATTR_1_, UPPER_EMP_EXT_ATTR_1_LIST, UPPER_EMP_EXT_ATTR_2_, UPPER_EMP_EXT_ATTR_2_LIST, UPPER_EMP_EXT_ATTR_3_, UPPER_EMP_EXT_ATTR_3_LIST, UPPER_EMP_EXT_ATTR_4_, UPPER_EMP_EXT_ATTR_4_LIST, UPPER_EMP_EXT_ATTR_5_, UPPER_EMP_EXT_ATTR_5_LIST, UPPER_EMP_EXT_ATTR_6_, UPPER_EMP_EXT_ATTR_6_LIST, UPPER_EMP_EXT_ATTR_7_, UPPER_EMP_EXT_ATTR_7_LIST, UPPER_EMP_EXT_ATTR_8_, UPPER_EMP_EXT_ATTR_8_LIST, UPPER_EMP_STATUS_, UPPER_EMP_STATUS_LIST, UPPER_ORG_ID_, UPPER_ORG_ID_LIST, UPPER_PARENT_ORG_ID_, UPPER_PARENT_ORG_ID_LIST, UPPER_ORG_CODE_, UPPER_ORG_CODE_LIST, UPPER_ORG_NAME_, UPPER_ORG_NAME_LIST, UPPER_ORG_TYPE_, UPPER_ORG_TYPE_LIST, UPPER_ORG_CATEGORY_,
                UPPER_ORG_CATEGORY_LIST, UPPER_ORG_TAG_, UPPER_ORG_EXT_ATTR_1_, UPPER_ORG_EXT_ATTR_1_LIST, UPPER_ORG_EXT_ATTR_2_, UPPER_ORG_EXT_ATTR_2_LIST, UPPER_ORG_EXT_ATTR_3_, UPPER_ORG_EXT_ATTR_3_LIST, UPPER_ORG_EXT_ATTR_4_, UPPER_ORG_EXT_ATTR_4_LIST, UPPER_ORG_EXT_ATTR_5_, UPPER_ORG_EXT_ATTR_5_LIST, UPPER_ORG_EXT_ATTR_6_, UPPER_ORG_EXT_ATTR_6_LIST, UPPER_ORG_EXT_ATTR_7_, UPPER_ORG_EXT_ATTR_7_LIST, UPPER_ORG_EXT_ATTR_8_, UPPER_ORG_EXT_ATTR_8_LIST, UPPER_ORG_STATUS_, UPPER_ORG_STATUS_LIST, LOWER_EMP_ID_, LOWER_EMP_ID_LIST, LOWER_EMP_CODE_, LOWER_EMP_CODE_LIST, LOWER_EMP_NAME_, LOWER_EMP_NAME_LIST, LOWER_EMP_CATEGORY_, LOWER_EMP_CATEGORY_LIST, LOWER_EMP_TAG_, LOWER_EMP_EXT_ATTR_1_, LOWER_EMP_EXT_ATTR_1_LIST, LOWER_EMP_EXT_ATTR_2_, LOWER_EMP_EXT_ATTR_2_LIST, LOWER_EMP_EXT_ATTR_3_,
                LOWER_EMP_EXT_ATTR_3_LIST, LOWER_EMP_EXT_ATTR_4_, LOWER_EMP_EXT_ATTR_4_LIST, LOWER_EMP_EXT_ATTR_5_, LOWER_EMP_EXT_ATTR_5_LIST, LOWER_EMP_EXT_ATTR_6_, LOWER_EMP_EXT_ATTR_6_LIST, LOWER_EMP_EXT_ATTR_7_, LOWER_EMP_EXT_ATTR_7_LIST, LOWER_EMP_EXT_ATTR_8_, LOWER_EMP_EXT_ATTR_8_LIST, LOWER_EMP_STATUS_, LOWER_EMP_STATUS_LIST, LOWER_ORG_ID_, LOWER_ORG_ID_LIST, LOWER_PARENT_ORG_ID_, LOWER_PARENT_ORG_ID_LIST, LOWER_ORG_CODE_, LOWER_ORG_CODE_LIST, LOWER_ORG_NAME_, LOWER_ORG_NAME_LIST, LOWER_ORG_TYPE_, LOWER_ORG_TYPE_LIST, LOWER_ORG_CATEGORY_, LOWER_ORG_CATEGORY_LIST, LOWER_ORG_TAG_, LOWER_ORG_EXT_ATTR_1_, LOWER_ORG_EXT_ATTR_1_LIST, LOWER_ORG_EXT_ATTR_2_, LOWER_ORG_EXT_ATTR_2_LIST, LOWER_ORG_EXT_ATTR_3_, LOWER_ORG_EXT_ATTR_3_LIST, LOWER_ORG_EXT_ATTR_4_, LOWER_ORG_EXT_ATTR_4_LIST,
                LOWER_ORG_EXT_ATTR_5_, LOWER_ORG_EXT_ATTR_5_LIST, LOWER_ORG_EXT_ATTR_6_, LOWER_ORG_EXT_ATTR_6_LIST, LOWER_ORG_EXT_ATTR_7_, LOWER_ORG_EXT_ATTR_7_LIST, LOWER_ORG_EXT_ATTR_8_, LOWER_ORG_EXT_ATTR_8_LIST, LOWER_ORG_STATUS_, LOWER_ORG_STATUS_LIST, empRelationTagUnion, upperEmpTagUnion, upperOrgTagUnion, upperWithinOrgId, upperOrgRootOnly, lowerEmpTagUnion, lowerOrgTagUnion, lowerWithinOrgId, lowerOrgRootOnly, OPERATOR_ID_, OPERATOR_NAME_);// 根据查询条件组装查询SQL语句
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
    public int countEmpRelation(String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_RELATION_ID_, List<String> EMP_RELATION_ID_LIST, String EMP_RELATION_, List<String> EMP_RELATION_LIST, String EMP_RELATION_CATEGORY_, List<String> EMP_RELATION_CATEGORY_LIST, String EMP_RELATION_TAG_, String EMP_RELATION_EXT_ATTR_1_, List<String> EMP_RELATION_EXT_ATTR_1_LIST, String EMP_RELATION_EXT_ATTR_2_, List<String> EMP_RELATION_EXT_ATTR_2_LIST, String EMP_RELATION_EXT_ATTR_3_, List<String> EMP_RELATION_EXT_ATTR_3_LIST, String EMP_RELATION_EXT_ATTR_4_, List<String> EMP_RELATION_EXT_ATTR_4_LIST, String EMP_RELATION_EXT_ATTR_5_, List<String> EMP_RELATION_EXT_ATTR_5_LIST, String EMP_RELATION_EXT_ATTR_6_, List<String> EMP_RELATION_EXT_ATTR_6_LIST, String EMP_RELATION_EXT_ATTR_7_,
            List<String> EMP_RELATION_EXT_ATTR_7_LIST, String EMP_RELATION_EXT_ATTR_8_, List<String> EMP_RELATION_EXT_ATTR_8_LIST, String EMP_RELATION_STATUS_, List<String> EMP_RELATION_STATUS_LIST, String UPPER_EMP_ID_, List<String> UPPER_EMP_ID_LIST, String UPPER_EMP_CODE_, List<String> UPPER_EMP_CODE_LIST, String UPPER_EMP_NAME_, List<String> UPPER_EMP_NAME_LIST, String UPPER_EMP_CATEGORY_, List<String> UPPER_EMP_CATEGORY_LIST, String UPPER_EMP_TAG_, String UPPER_EMP_EXT_ATTR_1_, List<String> UPPER_EMP_EXT_ATTR_1_LIST, String UPPER_EMP_EXT_ATTR_2_, List<String> UPPER_EMP_EXT_ATTR_2_LIST, String UPPER_EMP_EXT_ATTR_3_, List<String> UPPER_EMP_EXT_ATTR_3_LIST, String UPPER_EMP_EXT_ATTR_4_, List<String> UPPER_EMP_EXT_ATTR_4_LIST, String UPPER_EMP_EXT_ATTR_5_,
            List<String> UPPER_EMP_EXT_ATTR_5_LIST, String UPPER_EMP_EXT_ATTR_6_, List<String> UPPER_EMP_EXT_ATTR_6_LIST, String UPPER_EMP_EXT_ATTR_7_, List<String> UPPER_EMP_EXT_ATTR_7_LIST, String UPPER_EMP_EXT_ATTR_8_, List<String> UPPER_EMP_EXT_ATTR_8_LIST, String UPPER_EMP_STATUS_, List<String> UPPER_EMP_STATUS_LIST, String UPPER_ORG_ID_, List<String> UPPER_ORG_ID_LIST, String UPPER_PARENT_ORG_ID_, List<String> UPPER_PARENT_ORG_ID_LIST, String UPPER_ORG_CODE_, List<String> UPPER_ORG_CODE_LIST, String UPPER_ORG_NAME_, List<String> UPPER_ORG_NAME_LIST, String UPPER_ORG_TYPE_, List<String> UPPER_ORG_TYPE_LIST, String UPPER_ORG_CATEGORY_, List<String> UPPER_ORG_CATEGORY_LIST, String UPPER_ORG_TAG_, String UPPER_ORG_EXT_ATTR_1_, List<String> UPPER_ORG_EXT_ATTR_1_LIST,
            String UPPER_ORG_EXT_ATTR_2_, List<String> UPPER_ORG_EXT_ATTR_2_LIST, String UPPER_ORG_EXT_ATTR_3_, List<String> UPPER_ORG_EXT_ATTR_3_LIST, String UPPER_ORG_EXT_ATTR_4_, List<String> UPPER_ORG_EXT_ATTR_4_LIST, String UPPER_ORG_EXT_ATTR_5_, List<String> UPPER_ORG_EXT_ATTR_5_LIST, String UPPER_ORG_EXT_ATTR_6_, List<String> UPPER_ORG_EXT_ATTR_6_LIST, String UPPER_ORG_EXT_ATTR_7_, List<String> UPPER_ORG_EXT_ATTR_7_LIST, String UPPER_ORG_EXT_ATTR_8_, List<String> UPPER_ORG_EXT_ATTR_8_LIST, String UPPER_ORG_STATUS_, List<String> UPPER_ORG_STATUS_LIST, String LOWER_EMP_ID_, List<String> LOWER_EMP_ID_LIST, String LOWER_EMP_CODE_, List<String> LOWER_EMP_CODE_LIST, String LOWER_EMP_NAME_, List<String> LOWER_EMP_NAME_LIST, String LOWER_EMP_CATEGORY_, List<String> LOWER_EMP_CATEGORY_LIST,
            String LOWER_EMP_TAG_, String LOWER_EMP_EXT_ATTR_1_, List<String> LOWER_EMP_EXT_ATTR_1_LIST, String LOWER_EMP_EXT_ATTR_2_, List<String> LOWER_EMP_EXT_ATTR_2_LIST, String LOWER_EMP_EXT_ATTR_3_, List<String> LOWER_EMP_EXT_ATTR_3_LIST, String LOWER_EMP_EXT_ATTR_4_, List<String> LOWER_EMP_EXT_ATTR_4_LIST, String LOWER_EMP_EXT_ATTR_5_, List<String> LOWER_EMP_EXT_ATTR_5_LIST, String LOWER_EMP_EXT_ATTR_6_, List<String> LOWER_EMP_EXT_ATTR_6_LIST, String LOWER_EMP_EXT_ATTR_7_, List<String> LOWER_EMP_EXT_ATTR_7_LIST, String LOWER_EMP_EXT_ATTR_8_, List<String> LOWER_EMP_EXT_ATTR_8_LIST, String LOWER_EMP_STATUS_, List<String> LOWER_EMP_STATUS_LIST, String LOWER_ORG_ID_, List<String> LOWER_ORG_ID_LIST, String LOWER_PARENT_ORG_ID_, List<String> LOWER_PARENT_ORG_ID_LIST,
            String LOWER_ORG_CODE_, List<String> LOWER_ORG_CODE_LIST, String LOWER_ORG_NAME_, List<String> LOWER_ORG_NAME_LIST, String LOWER_ORG_TYPE_, List<String> LOWER_ORG_TYPE_LIST, String LOWER_ORG_CATEGORY_, List<String> LOWER_ORG_CATEGORY_LIST, String LOWER_ORG_TAG_, String LOWER_ORG_EXT_ATTR_1_, List<String> LOWER_ORG_EXT_ATTR_1_LIST, String LOWER_ORG_EXT_ATTR_2_, List<String> LOWER_ORG_EXT_ATTR_2_LIST, String LOWER_ORG_EXT_ATTR_3_, List<String> LOWER_ORG_EXT_ATTR_3_LIST, String LOWER_ORG_EXT_ATTR_4_, List<String> LOWER_ORG_EXT_ATTR_4_LIST, String LOWER_ORG_EXT_ATTR_5_, List<String> LOWER_ORG_EXT_ATTR_5_LIST, String LOWER_ORG_EXT_ATTR_6_, List<String> LOWER_ORG_EXT_ATTR_6_LIST, String LOWER_ORG_EXT_ATTR_7_, List<String> LOWER_ORG_EXT_ATTR_7_LIST, String LOWER_ORG_EXT_ATTR_8_,
            List<String> LOWER_ORG_EXT_ATTR_8_LIST, String LOWER_ORG_STATUS_, List<String> LOWER_ORG_STATUS_LIST, Boolean empRelationTagUnion, Boolean upperEmpTagUnion, Boolean upperOrgTagUnion, String upperWithinOrgId, Boolean upperOrgRootOnly, Boolean lowerEmpTagUnion, Boolean lowerOrgTagUnion, String lowerWithinOrgId, Boolean lowerOrgRootOnly, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaEmpRelation(true, ORGN_SET_ID_, ORGN_SET_CODE_, EMP_RELATION_ID_, EMP_RELATION_ID_LIST, EMP_RELATION_, EMP_RELATION_LIST, EMP_RELATION_CATEGORY_, EMP_RELATION_CATEGORY_LIST, EMP_RELATION_TAG_, EMP_RELATION_EXT_ATTR_1_, EMP_RELATION_EXT_ATTR_1_LIST, EMP_RELATION_EXT_ATTR_2_, EMP_RELATION_EXT_ATTR_2_LIST, EMP_RELATION_EXT_ATTR_3_, EMP_RELATION_EXT_ATTR_3_LIST, EMP_RELATION_EXT_ATTR_4_, EMP_RELATION_EXT_ATTR_4_LIST, EMP_RELATION_EXT_ATTR_5_, EMP_RELATION_EXT_ATTR_5_LIST, EMP_RELATION_EXT_ATTR_6_, EMP_RELATION_EXT_ATTR_6_LIST, EMP_RELATION_EXT_ATTR_7_, EMP_RELATION_EXT_ATTR_7_LIST, EMP_RELATION_EXT_ATTR_8_, EMP_RELATION_EXT_ATTR_8_LIST, EMP_RELATION_STATUS_, EMP_RELATION_STATUS_LIST, UPPER_EMP_ID_, UPPER_EMP_ID_LIST, UPPER_EMP_CODE_,
                UPPER_EMP_CODE_LIST, UPPER_EMP_NAME_, UPPER_EMP_NAME_LIST, UPPER_EMP_CATEGORY_, UPPER_EMP_CATEGORY_LIST, UPPER_EMP_TAG_, UPPER_EMP_EXT_ATTR_1_, UPPER_EMP_EXT_ATTR_1_LIST, UPPER_EMP_EXT_ATTR_2_, UPPER_EMP_EXT_ATTR_2_LIST, UPPER_EMP_EXT_ATTR_3_, UPPER_EMP_EXT_ATTR_3_LIST, UPPER_EMP_EXT_ATTR_4_, UPPER_EMP_EXT_ATTR_4_LIST, UPPER_EMP_EXT_ATTR_5_, UPPER_EMP_EXT_ATTR_5_LIST, UPPER_EMP_EXT_ATTR_6_, UPPER_EMP_EXT_ATTR_6_LIST, UPPER_EMP_EXT_ATTR_7_, UPPER_EMP_EXT_ATTR_7_LIST, UPPER_EMP_EXT_ATTR_8_, UPPER_EMP_EXT_ATTR_8_LIST, UPPER_EMP_STATUS_, UPPER_EMP_STATUS_LIST, UPPER_ORG_ID_, UPPER_ORG_ID_LIST, UPPER_PARENT_ORG_ID_, UPPER_PARENT_ORG_ID_LIST, UPPER_ORG_CODE_, UPPER_ORG_CODE_LIST, UPPER_ORG_NAME_, UPPER_ORG_NAME_LIST, UPPER_ORG_TYPE_, UPPER_ORG_TYPE_LIST, UPPER_ORG_CATEGORY_,
                UPPER_ORG_CATEGORY_LIST, UPPER_ORG_TAG_, UPPER_ORG_EXT_ATTR_1_, UPPER_ORG_EXT_ATTR_1_LIST, UPPER_ORG_EXT_ATTR_2_, UPPER_ORG_EXT_ATTR_2_LIST, UPPER_ORG_EXT_ATTR_3_, UPPER_ORG_EXT_ATTR_3_LIST, UPPER_ORG_EXT_ATTR_4_, UPPER_ORG_EXT_ATTR_4_LIST, UPPER_ORG_EXT_ATTR_5_, UPPER_ORG_EXT_ATTR_5_LIST, UPPER_ORG_EXT_ATTR_6_, UPPER_ORG_EXT_ATTR_6_LIST, UPPER_ORG_EXT_ATTR_7_, UPPER_ORG_EXT_ATTR_7_LIST, UPPER_ORG_EXT_ATTR_8_, UPPER_ORG_EXT_ATTR_8_LIST, UPPER_ORG_STATUS_, UPPER_ORG_STATUS_LIST, LOWER_EMP_ID_, LOWER_EMP_ID_LIST, LOWER_EMP_CODE_, LOWER_EMP_CODE_LIST, LOWER_EMP_NAME_, LOWER_EMP_NAME_LIST, LOWER_EMP_CATEGORY_, LOWER_EMP_CATEGORY_LIST, LOWER_EMP_TAG_, LOWER_EMP_EXT_ATTR_1_, LOWER_EMP_EXT_ATTR_1_LIST, LOWER_EMP_EXT_ATTR_2_, LOWER_EMP_EXT_ATTR_2_LIST, LOWER_EMP_EXT_ATTR_3_,
                LOWER_EMP_EXT_ATTR_3_LIST, LOWER_EMP_EXT_ATTR_4_, LOWER_EMP_EXT_ATTR_4_LIST, LOWER_EMP_EXT_ATTR_5_, LOWER_EMP_EXT_ATTR_5_LIST, LOWER_EMP_EXT_ATTR_6_, LOWER_EMP_EXT_ATTR_6_LIST, LOWER_EMP_EXT_ATTR_7_, LOWER_EMP_EXT_ATTR_7_LIST, LOWER_EMP_EXT_ATTR_8_, LOWER_EMP_EXT_ATTR_8_LIST, LOWER_EMP_STATUS_, LOWER_EMP_STATUS_LIST, LOWER_ORG_ID_, LOWER_ORG_ID_LIST, LOWER_PARENT_ORG_ID_, LOWER_PARENT_ORG_ID_LIST, LOWER_ORG_CODE_, LOWER_ORG_CODE_LIST, LOWER_ORG_NAME_, LOWER_ORG_NAME_LIST, LOWER_ORG_TYPE_, LOWER_ORG_TYPE_LIST, LOWER_ORG_CATEGORY_, LOWER_ORG_CATEGORY_LIST, LOWER_ORG_TAG_, LOWER_ORG_EXT_ATTR_1_, LOWER_ORG_EXT_ATTR_1_LIST, LOWER_ORG_EXT_ATTR_2_, LOWER_ORG_EXT_ATTR_2_LIST, LOWER_ORG_EXT_ATTR_3_, LOWER_ORG_EXT_ATTR_3_LIST, LOWER_ORG_EXT_ATTR_4_, LOWER_ORG_EXT_ATTR_4_LIST,
                LOWER_ORG_EXT_ATTR_5_, LOWER_ORG_EXT_ATTR_5_LIST, LOWER_ORG_EXT_ATTR_6_, LOWER_ORG_EXT_ATTR_6_LIST, LOWER_ORG_EXT_ATTR_7_, LOWER_ORG_EXT_ATTR_7_LIST, LOWER_ORG_EXT_ATTR_8_, LOWER_ORG_EXT_ATTR_8_LIST, LOWER_ORG_STATUS_, LOWER_ORG_STATUS_LIST, empRelationTagUnion, upperEmpTagUnion, upperOrgTagUnion, upperWithinOrgId, upperOrgRootOnly, lowerEmpTagUnion, lowerOrgTagUnion, lowerWithinOrgId, lowerOrgRootOnly, OPERATOR_ID_, OPERATOR_NAME_);// 根据查询条件组装总数查询SQL语句
        String sql = odSqlCriteria.getSql();
        Map<String, Object> paramMap = odSqlCriteria.getParamMap();

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    private OdSqlCriteria buildSqlCriteriaEmpRelation(boolean count, String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_RELATION_ID_, List<String> EMP_RELATION_ID_LIST, String EMP_RELATION_, List<String> EMP_RELATION_LIST, String EMP_RELATION_CATEGORY_, List<String> EMP_RELATION_CATEGORY_LIST, String EMP_RELATION_TAG_, String EMP_RELATION_EXT_ATTR_1_, List<String> EMP_RELATION_EXT_ATTR_1_LIST, String EMP_RELATION_EXT_ATTR_2_, List<String> EMP_RELATION_EXT_ATTR_2_LIST, String EMP_RELATION_EXT_ATTR_3_, List<String> EMP_RELATION_EXT_ATTR_3_LIST, String EMP_RELATION_EXT_ATTR_4_, List<String> EMP_RELATION_EXT_ATTR_4_LIST, String EMP_RELATION_EXT_ATTR_5_, List<String> EMP_RELATION_EXT_ATTR_5_LIST, String EMP_RELATION_EXT_ATTR_6_, List<String> EMP_RELATION_EXT_ATTR_6_LIST,
            String EMP_RELATION_EXT_ATTR_7_, List<String> EMP_RELATION_EXT_ATTR_7_LIST, String EMP_RELATION_EXT_ATTR_8_, List<String> EMP_RELATION_EXT_ATTR_8_LIST, String EMP_RELATION_STATUS_, List<String> EMP_RELATION_STATUS_LIST, String UPPER_EMP_ID_, List<String> UPPER_EMP_ID_LIST, String UPPER_EMP_CODE_, List<String> UPPER_EMP_CODE_LIST, String UPPER_EMP_NAME_, List<String> UPPER_EMP_NAME_LIST, String UPPER_EMP_CATEGORY_, List<String> UPPER_EMP_CATEGORY_LIST, String UPPER_EMP_TAG_, String UPPER_EMP_EXT_ATTR_1_, List<String> UPPER_EMP_EXT_ATTR_1_LIST, String UPPER_EMP_EXT_ATTR_2_, List<String> UPPER_EMP_EXT_ATTR_2_LIST, String UPPER_EMP_EXT_ATTR_3_, List<String> UPPER_EMP_EXT_ATTR_3_LIST, String UPPER_EMP_EXT_ATTR_4_, List<String> UPPER_EMP_EXT_ATTR_4_LIST, String UPPER_EMP_EXT_ATTR_5_,
            List<String> UPPER_EMP_EXT_ATTR_5_LIST, String UPPER_EMP_EXT_ATTR_6_, List<String> UPPER_EMP_EXT_ATTR_6_LIST, String UPPER_EMP_EXT_ATTR_7_, List<String> UPPER_EMP_EXT_ATTR_7_LIST, String UPPER_EMP_EXT_ATTR_8_, List<String> UPPER_EMP_EXT_ATTR_8_LIST, String UPPER_EMP_STATUS_, List<String> UPPER_EMP_STATUS_LIST, String UPPER_ORG_ID_, List<String> UPPER_ORG_ID_LIST, String UPPER_PARENT_ORG_ID_, List<String> UPPER_PARENT_ORG_ID_LIST, String UPPER_ORG_CODE_, List<String> UPPER_ORG_CODE_LIST, String UPPER_ORG_NAME_, List<String> UPPER_ORG_NAME_LIST, String UPPER_ORG_TYPE_, List<String> UPPER_ORG_TYPE_LIST, String UPPER_ORG_CATEGORY_, List<String> UPPER_ORG_CATEGORY_LIST, String UPPER_ORG_TAG_, String UPPER_ORG_EXT_ATTR_1_, List<String> UPPER_ORG_EXT_ATTR_1_LIST,
            String UPPER_ORG_EXT_ATTR_2_, List<String> UPPER_ORG_EXT_ATTR_2_LIST, String UPPER_ORG_EXT_ATTR_3_, List<String> UPPER_ORG_EXT_ATTR_3_LIST, String UPPER_ORG_EXT_ATTR_4_, List<String> UPPER_ORG_EXT_ATTR_4_LIST, String UPPER_ORG_EXT_ATTR_5_, List<String> UPPER_ORG_EXT_ATTR_5_LIST, String UPPER_ORG_EXT_ATTR_6_, List<String> UPPER_ORG_EXT_ATTR_6_LIST, String UPPER_ORG_EXT_ATTR_7_, List<String> UPPER_ORG_EXT_ATTR_7_LIST, String UPPER_ORG_EXT_ATTR_8_, List<String> UPPER_ORG_EXT_ATTR_8_LIST, String UPPER_ORG_STATUS_, List<String> UPPER_ORG_STATUS_LIST, String LOWER_EMP_ID_, List<String> LOWER_EMP_ID_LIST, String LOWER_EMP_CODE_, List<String> LOWER_EMP_CODE_LIST, String LOWER_EMP_NAME_, List<String> LOWER_EMP_NAME_LIST, String LOWER_EMP_CATEGORY_, List<String> LOWER_EMP_CATEGORY_LIST,
            String LOWER_EMP_TAG_, String LOWER_EMP_EXT_ATTR_1_, List<String> LOWER_EMP_EXT_ATTR_1_LIST, String LOWER_EMP_EXT_ATTR_2_, List<String> LOWER_EMP_EXT_ATTR_2_LIST, String LOWER_EMP_EXT_ATTR_3_, List<String> LOWER_EMP_EXT_ATTR_3_LIST, String LOWER_EMP_EXT_ATTR_4_, List<String> LOWER_EMP_EXT_ATTR_4_LIST, String LOWER_EMP_EXT_ATTR_5_, List<String> LOWER_EMP_EXT_ATTR_5_LIST, String LOWER_EMP_EXT_ATTR_6_, List<String> LOWER_EMP_EXT_ATTR_6_LIST, String LOWER_EMP_EXT_ATTR_7_, List<String> LOWER_EMP_EXT_ATTR_7_LIST, String LOWER_EMP_EXT_ATTR_8_, List<String> LOWER_EMP_EXT_ATTR_8_LIST, String LOWER_EMP_STATUS_, List<String> LOWER_EMP_STATUS_LIST, String LOWER_ORG_ID_, List<String> LOWER_ORG_ID_LIST, String LOWER_PARENT_ORG_ID_, List<String> LOWER_PARENT_ORG_ID_LIST,
            String LOWER_ORG_CODE_, List<String> LOWER_ORG_CODE_LIST, String LOWER_ORG_NAME_, List<String> LOWER_ORG_NAME_LIST, String LOWER_ORG_TYPE_, List<String> LOWER_ORG_TYPE_LIST, String LOWER_ORG_CATEGORY_, List<String> LOWER_ORG_CATEGORY_LIST, String LOWER_ORG_TAG_, String LOWER_ORG_EXT_ATTR_1_, List<String> LOWER_ORG_EXT_ATTR_1_LIST, String LOWER_ORG_EXT_ATTR_2_, List<String> LOWER_ORG_EXT_ATTR_2_LIST, String LOWER_ORG_EXT_ATTR_3_, List<String> LOWER_ORG_EXT_ATTR_3_LIST, String LOWER_ORG_EXT_ATTR_4_, List<String> LOWER_ORG_EXT_ATTR_4_LIST, String LOWER_ORG_EXT_ATTR_5_, List<String> LOWER_ORG_EXT_ATTR_5_LIST, String LOWER_ORG_EXT_ATTR_6_, List<String> LOWER_ORG_EXT_ATTR_6_LIST, String LOWER_ORG_EXT_ATTR_7_, List<String> LOWER_ORG_EXT_ATTR_7_LIST, String LOWER_ORG_EXT_ATTR_8_,
            List<String> LOWER_ORG_EXT_ATTR_8_LIST, String LOWER_ORG_STATUS_, List<String> LOWER_ORG_STATUS_LIST, Boolean empRelationTagUnion, Boolean upperEmpTagUnion, Boolean upperOrgTagUnion, String upperWithinOrgId, Boolean upperOrgRootOnly, Boolean lowerEmpTagUnion, Boolean lowerOrgTagUnion, String lowerWithinOrgId, Boolean lowerOrgRootOnly, String OPERATOR_ID_, String OPERATOR_NAME_) {// 组装查询SQL语句
        if (StringUtils.isEmpty(ORGN_SET_ID_) && StringUtils.isEmpty(ORGN_SET_CODE_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            Map<String, Object> orgnSet = omOrgnSetService.loadOrgnSetByCode(ORGN_SET_CODE_, OPERATOR_ID_, OPERATOR_NAME_);
            ORGN_SET_ID_ = (String) orgnSet.get("ORGN_SET_ID_");
        }

        String sql;
        Map<String, Object> paramMap = new HashMap<>();

        if (count) {
            sql = "select count(*) from OMV_EMP_RELATION ER where 1 = 1";
        }
        else {
            sql = "select * from OMV_EMP_RELATION ER where 1 = 1";
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
        if (EMP_RELATION_ID_LIST != null && !EMP_RELATION_ID_LIST.isEmpty()) {
            sql += " and EMP_RELATION_ID_ in (:EMP_RELATION_ID_LIST)";
            paramMap.put("EMP_RELATION_ID_LIST", EMP_RELATION_ID_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_RELATION_)) {
            sql += " and EMP_RELATION_ = :EMP_RELATION_";
            paramMap.put("EMP_RELATION_", EMP_RELATION_);
        }
        if (EMP_RELATION_LIST != null && !EMP_RELATION_LIST.isEmpty()) {
            sql += " and EMP_RELATION_ in (:EMP_RELATION_LIST)";
            paramMap.put("EMP_RELATION_LIST", EMP_RELATION_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_RELATION_CATEGORY_)) {
            sql += " and EMP_RELATION_CATEGORY_ = :EMP_RELATION_CATEGORY_";
            paramMap.put("EMP_RELATION_CATEGORY_", EMP_RELATION_CATEGORY_);
        }
        if (EMP_RELATION_CATEGORY_LIST != null && !EMP_RELATION_CATEGORY_LIST.isEmpty()) {
            sql += " and EMP_RELATION_CATEGORY_ in (:EMP_RELATION_CATEGORY_LIST)";
            paramMap.put("EMP_RELATION_CATEGORY_LIST", EMP_RELATION_CATEGORY_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_RELATION_TAG_)) {
            List<String> tagList = omTagService.splitTag(EMP_RELATION_TAG_);
            if (!tagList.isEmpty()) {
                if (empRelationTagUnion != null && empRelationTagUnion.equals(false)) {
                    sql += " and EMP_RELATION_ID_ in (select EMP_RELATION_ID_ from (select OBJ_ID_ as EMP_RELATION_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'EMP_RELATION' and TAG_ in (:EMP_RELATION_TAG_LIST)) T group by EMP_RELATION_ID_ having count(*) >= 1)";
                    paramMap.put("EMP_RELATION_TAG_LIST", tagList);
                }
                else {
                    sql += " and EMP_RELATION_ID_ in (select EMP_RELATION_ID_ from (select OBJ_ID_ as EMP_RELATION_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'EMP_RELATION' and TAG_ in (:EMP_RELATION_TAG_LIST)) T group by EMP_RELATION_ID_ having count(*) >= :empRelationTagCount)";
                    paramMap.put("EMP_RELATION_TAG_LIST", tagList);
                    paramMap.put("empRelationTagCount", tagList.size());
                }
            }
        }
        if (StringUtils.isNotEmpty(EMP_RELATION_EXT_ATTR_1_)) {
            sql += " and EMP_RELATION_EXT_ATTR_1_ = :EMP_RELATION_EXT_ATTR_1_";
            paramMap.put("EMP_RELATION_EXT_ATTR_1_", EMP_RELATION_EXT_ATTR_1_);
        }
        if (EMP_RELATION_EXT_ATTR_1_LIST != null && !EMP_RELATION_EXT_ATTR_1_LIST.isEmpty()) {
            sql += " and EMP_RELATION_EXT_ATTR_1_ in (:EMP_RELATION_EXT_ATTR_1_LIST)";
            paramMap.put("EMP_RELATION_EXT_ATTR_1_LIST", EMP_RELATION_EXT_ATTR_1_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_RELATION_EXT_ATTR_2_)) {
            sql += " and EMP_RELATION_EXT_ATTR_2_ = :EMP_RELATION_EXT_ATTR_2_";
            paramMap.put("EMP_RELATION_EXT_ATTR_2_", EMP_RELATION_EXT_ATTR_2_);
        }
        if (EMP_RELATION_EXT_ATTR_2_LIST != null && !EMP_RELATION_EXT_ATTR_2_LIST.isEmpty()) {
            sql += " and EMP_RELATION_EXT_ATTR_2_ in (:EMP_RELATION_EXT_ATTR_2_LIST)";
            paramMap.put("EMP_RELATION_EXT_ATTR_2_LIST", EMP_RELATION_EXT_ATTR_2_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_RELATION_EXT_ATTR_3_)) {
            sql += " and EMP_RELATION_EXT_ATTR_3_ = :EMP_RELATION_EXT_ATTR_3_";
            paramMap.put("EMP_RELATION_EXT_ATTR_3_", EMP_RELATION_EXT_ATTR_3_);
        }
        if (EMP_RELATION_EXT_ATTR_3_LIST != null && !EMP_RELATION_EXT_ATTR_3_LIST.isEmpty()) {
            sql += " and EMP_RELATION_EXT_ATTR_3_ in (:EMP_RELATION_EXT_ATTR_3_LIST)";
            paramMap.put("EMP_RELATION_EXT_ATTR_3_LIST", EMP_RELATION_EXT_ATTR_3_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_RELATION_EXT_ATTR_4_)) {
            sql += " and EMP_RELATION_EXT_ATTR_4_ = :EMP_RELATION_EXT_ATTR_4_";
            paramMap.put("EMP_RELATION_EXT_ATTR_4_", EMP_RELATION_EXT_ATTR_4_);
        }
        if (EMP_RELATION_EXT_ATTR_4_LIST != null && !EMP_RELATION_EXT_ATTR_4_LIST.isEmpty()) {
            sql += " and EMP_RELATION_EXT_ATTR_4_ in (:EMP_RELATION_EXT_ATTR_4_LIST)";
            paramMap.put("EMP_RELATION_EXT_ATTR_4_LIST", EMP_RELATION_EXT_ATTR_4_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_RELATION_EXT_ATTR_5_)) {
            sql += " and EMP_RELATION_EXT_ATTR_5_ = :EMP_RELATION_EXT_ATTR_5_";
            paramMap.put("EMP_RELATION_EXT_ATTR_5_", EMP_RELATION_EXT_ATTR_5_);
        }
        if (EMP_RELATION_EXT_ATTR_5_LIST != null && !EMP_RELATION_EXT_ATTR_5_LIST.isEmpty()) {
            sql += " and EMP_RELATION_EXT_ATTR_5_ in (:EMP_RELATION_EXT_ATTR_5_LIST)";
            paramMap.put("EMP_RELATION_EXT_ATTR_5_LIST", EMP_RELATION_EXT_ATTR_5_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_RELATION_EXT_ATTR_6_)) {
            sql += " and EMP_RELATION_EXT_ATTR_6_ = :EMP_RELATION_EXT_ATTR_6_";
            paramMap.put("EMP_RELATION_EXT_ATTR_6_", EMP_RELATION_EXT_ATTR_6_);
        }
        if (EMP_RELATION_EXT_ATTR_6_LIST != null && !EMP_RELATION_EXT_ATTR_6_LIST.isEmpty()) {
            sql += " and EMP_RELATION_EXT_ATTR_6_ in (:EMP_RELATION_EXT_ATTR_6_LIST)";
            paramMap.put("EMP_RELATION_EXT_ATTR_6_LIST", EMP_RELATION_EXT_ATTR_6_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_RELATION_EXT_ATTR_7_)) {
            sql += " and EMP_RELATION_EXT_ATTR_7_ = :EMP_RELATION_EXT_ATTR_7_";
            paramMap.put("EMP_RELATION_EXT_ATTR_7_", EMP_RELATION_EXT_ATTR_7_);
        }
        if (EMP_RELATION_EXT_ATTR_7_LIST != null && !EMP_RELATION_EXT_ATTR_7_LIST.isEmpty()) {
            sql += " and EMP_RELATION_EXT_ATTR_7_ in (:EMP_RELATION_EXT_ATTR_7_LIST)";
            paramMap.put("EMP_RELATION_EXT_ATTR_7_LIST", EMP_RELATION_EXT_ATTR_7_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_RELATION_EXT_ATTR_8_)) {
            sql += " and EMP_RELATION_EXT_ATTR_8_ = :EMP_RELATION_EXT_ATTR_8_";
            paramMap.put("EMP_RELATION_EXT_ATTR_8_", EMP_RELATION_EXT_ATTR_8_);
        }
        if (EMP_RELATION_EXT_ATTR_8_LIST != null && !EMP_RELATION_EXT_ATTR_8_LIST.isEmpty()) {
            sql += " and EMP_RELATION_EXT_ATTR_8_ in (:EMP_RELATION_EXT_ATTR_8_LIST)";
            paramMap.put("EMP_RELATION_EXT_ATTR_8_LIST", EMP_RELATION_EXT_ATTR_8_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_RELATION_STATUS_)) {
            sql += " and EMP_RELATION_STATUS_ = :EMP_RELATION_STATUS_";
            paramMap.put("EMP_RELATION_STATUS_", EMP_RELATION_STATUS_);
        }
        if (EMP_RELATION_STATUS_LIST != null && !EMP_RELATION_STATUS_LIST.isEmpty()) {
            sql += " and EMP_RELATION_STATUS_ in (:EMP_RELATION_STATUS_LIST)";
            paramMap.put("EMP_RELATION_STATUS_LIST", EMP_RELATION_STATUS_LIST);
        }

        if (StringUtils.isNotEmpty(UPPER_EMP_ID_)) {
            sql += " and UPPER_EMP_ID_ = :UPPER_EMP_ID_";
            paramMap.put("UPPER_EMP_ID_", UPPER_EMP_ID_);
        }
        if (UPPER_EMP_ID_LIST != null && !UPPER_EMP_ID_LIST.isEmpty()) {
            sql += " and UPPER_EMP_ID_ in (:UPPER_EMP_ID_LIST)";
            paramMap.put("UPPER_EMP_ID_LIST", UPPER_EMP_ID_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_EMP_CODE_)) {
            sql += " and UPPER_EMP_CODE_ = :UPPER_EMP_CODE_";
            paramMap.put("UPPER_EMP_CODE_", UPPER_EMP_CODE_);
        }
        if (UPPER_EMP_CODE_LIST != null && !UPPER_EMP_CODE_LIST.isEmpty()) {
            sql += " and UPPER_EMP_CODE_ in (:UPPER_EMP_CODE_LIST)";
            paramMap.put("UPPER_EMP_CODE_LIST", UPPER_EMP_CODE_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_EMP_NAME_)) {
            sql += " and UPPER_EMP_NAME_ like '%' || :UPPER_EMP_NAME_ || '%'";
            paramMap.put("UPPER_EMP_NAME_", UPPER_EMP_NAME_);
        }
        if (UPPER_EMP_NAME_LIST != null && !UPPER_EMP_NAME_LIST.isEmpty()) {
            sql += " and UPPER_EMP_NAME_ in (:UPPER_EMP_NAME_LIST)";
            paramMap.put("UPPER_EMP_NAME_LIST", UPPER_EMP_NAME_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_EMP_CATEGORY_)) {
            sql += " and UPPER_EMP_CATEGORY_ = :UPPER_EMP_CATEGORY_";
            paramMap.put("UPPER_EMP_CATEGORY_", UPPER_EMP_CATEGORY_);
        }
        if (UPPER_EMP_CATEGORY_LIST != null && !UPPER_EMP_CATEGORY_LIST.isEmpty()) {
            sql += " and UPPER_EMP_CATEGORY_ in (:UPPER_EMP_CATEGORY_LIST)";
            paramMap.put("UPPER_EMP_CATEGORY_LIST", UPPER_EMP_CATEGORY_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_EMP_TAG_)) {
            List<String> tagList = omTagService.splitTag(UPPER_EMP_TAG_);
            if (!tagList.isEmpty()) {
                if (upperEmpTagUnion != null && upperEmpTagUnion.equals(false)) {
                    sql += " and UPPER_EMP_ID_ in (select EMP_ID_ from (select OBJ_ID_ as EMP_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'EMP' and TAG_ in (:UPPER_EMP_TAG_LIST)) T group by EMP_ID_ having count(*) >= 1)";
                    paramMap.put("UPPER_EMP_TAG_LIST", tagList);
                }
                else {
                    sql += " and UPPER_EMP_ID_ in (select EMP_ID_ from (select OBJ_ID_ as EMP_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'EMP' and TAG_ in (:UPPER_EMP_TAG_LIST)) T group by EMP_ID_ having count(*) >= :upperEmpTagCount)";
                    paramMap.put("UPPER_EMP_TAG_LIST", tagList);
                    paramMap.put("upperEmpTagCount", tagList.size());
                }
            }
        }
        if (StringUtils.isNotEmpty(UPPER_EMP_EXT_ATTR_1_)) {
            sql += " and UPPER_EMP_EXT_ATTR_1_ = :UPPER_EMP_EXT_ATTR_1_";
            paramMap.put("UPPER_EMP_EXT_ATTR_1_", UPPER_EMP_EXT_ATTR_1_);
        }
        if (UPPER_EMP_EXT_ATTR_1_LIST != null && !UPPER_EMP_EXT_ATTR_1_LIST.isEmpty()) {
            sql += " and UPPER_EMP_EXT_ATTR_1_ in (:UPPER_EMP_EXT_ATTR_1_LIST)";
            paramMap.put("UPPER_EMP_EXT_ATTR_1_LIST", UPPER_EMP_EXT_ATTR_1_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_EMP_EXT_ATTR_2_)) {
            sql += " and UPPER_EMP_EXT_ATTR_2_ = :UPPER_EMP_EXT_ATTR_2_";
            paramMap.put("UPPER_EMP_EXT_ATTR_2_", UPPER_EMP_EXT_ATTR_2_);
        }
        if (UPPER_EMP_EXT_ATTR_2_LIST != null && !UPPER_EMP_EXT_ATTR_2_LIST.isEmpty()) {
            sql += " and UPPER_EMP_EXT_ATTR_2_ in (:UPPER_EMP_EXT_ATTR_2_LIST)";
            paramMap.put("UPPER_EMP_EXT_ATTR_2_LIST", UPPER_EMP_EXT_ATTR_2_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_EMP_EXT_ATTR_3_)) {
            sql += " and UPPER_EMP_EXT_ATTR_3_ = :UPPER_EMP_EXT_ATTR_3_";
            paramMap.put("UPPER_EMP_EXT_ATTR_3_", UPPER_EMP_EXT_ATTR_3_);
        }
        if (UPPER_EMP_EXT_ATTR_3_LIST != null && !UPPER_EMP_EXT_ATTR_3_LIST.isEmpty()) {
            sql += " and UPPER_EMP_EXT_ATTR_3_ in (:UPPER_EMP_EXT_ATTR_3_LIST)";
            paramMap.put("UPPER_EMP_EXT_ATTR_3_LIST", UPPER_EMP_EXT_ATTR_3_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_EMP_EXT_ATTR_4_)) {
            sql += " and UPPER_EMP_EXT_ATTR_4_ = :UPPER_EMP_EXT_ATTR_4_";
            paramMap.put("UPPER_EMP_EXT_ATTR_4_", UPPER_EMP_EXT_ATTR_4_);
        }
        if (UPPER_EMP_EXT_ATTR_4_LIST != null && !UPPER_EMP_EXT_ATTR_4_LIST.isEmpty()) {
            sql += " and UPPER_EMP_EXT_ATTR_4_ in (:UPPER_EMP_EXT_ATTR_4_LIST)";
            paramMap.put("UPPER_EMP_EXT_ATTR_4_LIST", UPPER_EMP_EXT_ATTR_4_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_EMP_EXT_ATTR_5_)) {
            sql += " and UPPER_EMP_EXT_ATTR_5_ = :UPPER_EMP_EXT_ATTR_5_";
            paramMap.put("UPPER_EMP_EXT_ATTR_5_", UPPER_EMP_EXT_ATTR_5_);
        }
        if (UPPER_EMP_EXT_ATTR_5_LIST != null && !UPPER_EMP_EXT_ATTR_5_LIST.isEmpty()) {
            sql += " and UPPER_EMP_EXT_ATTR_5_ in (:UPPER_EMP_EXT_ATTR_5_LIST)";
            paramMap.put("UPPER_EMP_EXT_ATTR_5_LIST", UPPER_EMP_EXT_ATTR_5_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_EMP_EXT_ATTR_6_)) {
            sql += " and UPPER_EMP_EXT_ATTR_6_ = :UPPER_EMP_EXT_ATTR_6_";
            paramMap.put("UPPER_EMP_EXT_ATTR_6_", UPPER_EMP_EXT_ATTR_6_);
        }
        if (UPPER_EMP_EXT_ATTR_6_LIST != null && !UPPER_EMP_EXT_ATTR_6_LIST.isEmpty()) {
            sql += " and UPPER_EMP_EXT_ATTR_6_ in (:UPPER_EMP_EXT_ATTR_6_LIST)";
            paramMap.put("UPPER_EMP_EXT_ATTR_6_LIST", UPPER_EMP_EXT_ATTR_6_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_EMP_EXT_ATTR_7_)) {
            sql += " and UPPER_EMP_EXT_ATTR_7_ = :UPPER_EMP_EXT_ATTR_7_";
            paramMap.put("UPPER_EMP_EXT_ATTR_7_", UPPER_EMP_EXT_ATTR_7_);
        }
        if (UPPER_EMP_EXT_ATTR_7_LIST != null && !UPPER_EMP_EXT_ATTR_7_LIST.isEmpty()) {
            sql += " and UPPER_EMP_EXT_ATTR_7_ in (:UPPER_EMP_EXT_ATTR_7_LIST)";
            paramMap.put("UPPER_EMP_EXT_ATTR_7_LIST", UPPER_EMP_EXT_ATTR_7_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_EMP_EXT_ATTR_8_)) {
            sql += " and UPPER_EMP_EXT_ATTR_8_ = :UPPER_EMP_EXT_ATTR_8_";
            paramMap.put("UPPER_EMP_EXT_ATTR_8_", UPPER_EMP_EXT_ATTR_8_);
        }
        if (UPPER_EMP_EXT_ATTR_8_LIST != null && !UPPER_EMP_EXT_ATTR_8_LIST.isEmpty()) {
            sql += " and UPPER_EMP_EXT_ATTR_8_ in (:UPPER_EMP_EXT_ATTR_8_LIST)";
            paramMap.put("UPPER_EMP_EXT_ATTR_8_LIST", UPPER_EMP_EXT_ATTR_8_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_EMP_STATUS_)) {
            sql += " and UPPER_EMP_STATUS_ = :UPPER_EMP_STATUS_";
            paramMap.put("UPPER_EMP_STATUS_", UPPER_EMP_STATUS_);
        }
        if (UPPER_EMP_STATUS_LIST != null && !UPPER_EMP_STATUS_LIST.isEmpty()) {
            sql += " and UPPER_EMP_STATUS_ in (:UPPER_EMP_STATUS_LIST)";
            paramMap.put("UPPER_EMP_STATUS_LIST", UPPER_EMP_STATUS_LIST);
        }

        if (StringUtils.isNotEmpty(UPPER_ORG_ID_)) {
            sql += " and UPPER_ORG_ID_ = :UPPER_ORG_ID_";
            paramMap.put("UPPER_ORG_ID_", UPPER_ORG_ID_);
        }
        if (UPPER_ORG_ID_LIST != null && !UPPER_ORG_ID_LIST.isEmpty()) {
            sql += " and UPPER_ORG_ID_ in (:UPPER_ORG_ID_LIST)";
            paramMap.put("UPPER_ORG_ID_LIST", UPPER_ORG_ID_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_PARENT_ORG_ID_)) {
            sql += " and UPPER_PARENT_ORG_ID_ = :UPPER_PARENT_ORG_ID_";
            paramMap.put("UPPER_PARENT_ORG_ID_", UPPER_PARENT_ORG_ID_);
        }
        if (UPPER_PARENT_ORG_ID_LIST != null && !UPPER_PARENT_ORG_ID_LIST.isEmpty()) {
            sql += " and UPPER_PARENT_ORG_ID_ in (:UPPER_PARENT_ORG_ID_LIST)";
            paramMap.put("UPPER_PARENT_ORG_ID_LIST", UPPER_PARENT_ORG_ID_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_ORG_CODE_)) {
            sql += " and UPPER_ORG_CODE_ = :UPPER_ORG_CODE_";
            paramMap.put("UPPER_ORG_CODE_", UPPER_ORG_CODE_);
        }
        if (UPPER_ORG_CODE_LIST != null && !UPPER_ORG_CODE_LIST.isEmpty()) {
            sql += " and UPPER_ORG_CODE_ in (:UPPER_ORG_CODE_LIST)";
            paramMap.put("UPPER_ORG_CODE_LIST", UPPER_ORG_CODE_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_ORG_NAME_)) {
            sql += " and UPPER_ORG_NAME_ like '%' || :UPPER_ORG_NAME_ || '%'";
            paramMap.put("UPPER_ORG_NAME_", UPPER_ORG_NAME_);
        }
        if (UPPER_ORG_NAME_LIST != null && !UPPER_ORG_NAME_LIST.isEmpty()) {
            sql += " and UPPER_ORG_NAME_ in (:UPPER_ORG_NAME_LIST)";
            paramMap.put("UPPER_ORG_NAME_LIST", UPPER_ORG_NAME_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_ORG_TYPE_)) {
            sql += " and UPPER_ORG_TYPE_ = :UPPER_ORG_TYPE_";
            paramMap.put("UPPER_ORG_TYPE_", UPPER_ORG_TYPE_);
        }
        if (UPPER_ORG_TYPE_LIST != null && !UPPER_ORG_TYPE_LIST.isEmpty()) {
            sql += " and UPPER_ORG_TYPE_ in (:UPPER_ORG_TYPE_LIST)";
            paramMap.put("UPPER_ORG_TYPE_LIST", UPPER_ORG_TYPE_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_ORG_CATEGORY_)) {
            sql += " and UPPER_ORG_CATEGORY_ = :UPPER_ORG_CATEGORY_";
            paramMap.put("UPPER_ORG_CATEGORY_", UPPER_ORG_CATEGORY_);
        }
        if (UPPER_ORG_CATEGORY_LIST != null && !UPPER_ORG_CATEGORY_LIST.isEmpty()) {
            sql += " and UPPER_ORG_CATEGORY_ in (:UPPER_ORG_CATEGORY_LIST)";
            paramMap.put("UPPER_ORG_CATEGORY_LIST", UPPER_ORG_CATEGORY_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_ORG_TAG_)) {
            List<String> tagList = omTagService.splitTag(UPPER_ORG_TAG_);
            if (!tagList.isEmpty()) {
                if (upperOrgTagUnion != null && upperOrgTagUnion.equals(false)) {
                    sql += " and UPPER_ORG_ID_ in (select ORG_ID_ from (select OBJ_ID_ as ORG_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'ORG' and TAG_ in (:UPPER_ORG_TAG_LIST)) T group by ORG_ID_ having count(*) >= 1)";
                    paramMap.put("UPPER_ORG_TAG_LIST", tagList);
                }
                else {
                    sql += " and UPPER_ORG_ID_ in (select ORG_ID_ from (select OBJ_ID_ as ORG_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'ORG' and TAG_ in (:UPPER_ORG_TAG_LIST)) T group by ORG_ID_ having count(*) >= :upperOrgTagCount)";
                    paramMap.put("UPPER_ORG_TAG_LIST", tagList);
                    paramMap.put("upperOrgTagCount", tagList.size());
                }
            }
        }
        if (StringUtils.isNotEmpty(UPPER_ORG_EXT_ATTR_1_)) {
            sql += " and UPPER_ORG_EXT_ATTR_1_ = :UPPER_ORG_EXT_ATTR_1_";
            paramMap.put("UPPER_ORG_EXT_ATTR_1_", UPPER_ORG_EXT_ATTR_1_);
        }
        if (UPPER_ORG_EXT_ATTR_1_LIST != null && !UPPER_ORG_EXT_ATTR_1_LIST.isEmpty()) {
            sql += " and UPPER_ORG_EXT_ATTR_1_ in (:UPPER_ORG_EXT_ATTR_1_LIST)";
            paramMap.put("UPPER_ORG_EXT_ATTR_1_LIST", UPPER_ORG_EXT_ATTR_1_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_ORG_EXT_ATTR_2_)) {
            sql += " and UPPER_ORG_EXT_ATTR_2_ = :UPPER_ORG_EXT_ATTR_2_";
            paramMap.put("UPPER_ORG_EXT_ATTR_2_", UPPER_ORG_EXT_ATTR_2_);
        }
        if (UPPER_ORG_EXT_ATTR_2_LIST != null && !UPPER_ORG_EXT_ATTR_2_LIST.isEmpty()) {
            sql += " and UPPER_ORG_EXT_ATTR_2_ in (:UPPER_ORG_EXT_ATTR_2_LIST)";
            paramMap.put("UPPER_ORG_EXT_ATTR_2_LIST", UPPER_ORG_EXT_ATTR_2_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_ORG_EXT_ATTR_3_)) {
            sql += " and UPPER_ORG_EXT_ATTR_3_ = :UPPER_ORG_EXT_ATTR_3_";
            paramMap.put("UPPER_ORG_EXT_ATTR_3_", UPPER_ORG_EXT_ATTR_3_);
        }
        if (UPPER_ORG_EXT_ATTR_3_LIST != null && !UPPER_ORG_EXT_ATTR_3_LIST.isEmpty()) {
            sql += " and UPPER_ORG_EXT_ATTR_3_ in (:UPPER_ORG_EXT_ATTR_3_LIST)";
            paramMap.put("UPPER_ORG_EXT_ATTR_3_LIST", UPPER_ORG_EXT_ATTR_3_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_ORG_EXT_ATTR_4_)) {
            sql += " and UPPER_ORG_EXT_ATTR_4_ = :UPPER_ORG_EXT_ATTR_4_";
            paramMap.put("UPPER_ORG_EXT_ATTR_4_", UPPER_ORG_EXT_ATTR_4_);
        }
        if (UPPER_ORG_EXT_ATTR_4_LIST != null && !UPPER_ORG_EXT_ATTR_4_LIST.isEmpty()) {
            sql += " and UPPER_ORG_EXT_ATTR_4_ in (:UPPER_ORG_EXT_ATTR_4_LIST)";
            paramMap.put("UPPER_ORG_EXT_ATTR_4_LIST", UPPER_ORG_EXT_ATTR_4_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_ORG_EXT_ATTR_5_)) {
            sql += " and UPPER_ORG_EXT_ATTR_5_ = :UPPER_ORG_EXT_ATTR_5_";
            paramMap.put("UPPER_ORG_EXT_ATTR_5_", UPPER_ORG_EXT_ATTR_5_);
        }
        if (UPPER_ORG_EXT_ATTR_5_LIST != null && !UPPER_ORG_EXT_ATTR_5_LIST.isEmpty()) {
            sql += " and UPPER_ORG_EXT_ATTR_5_ in (:UPPER_ORG_EXT_ATTR_5_LIST)";
            paramMap.put("UPPER_ORG_EXT_ATTR_5_LIST", UPPER_ORG_EXT_ATTR_5_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_ORG_EXT_ATTR_6_)) {
            sql += " and UPPER_ORG_EXT_ATTR_6_ = :UPPER_ORG_EXT_ATTR_6_";
            paramMap.put("UPPER_ORG_EXT_ATTR_6_", UPPER_ORG_EXT_ATTR_6_);
        }
        if (UPPER_ORG_EXT_ATTR_6_LIST != null && !UPPER_ORG_EXT_ATTR_6_LIST.isEmpty()) {
            sql += " and UPPER_ORG_EXT_ATTR_6_ in (:UPPER_ORG_EXT_ATTR_6_LIST)";
            paramMap.put("UPPER_ORG_EXT_ATTR_6_LIST", UPPER_ORG_EXT_ATTR_6_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_ORG_EXT_ATTR_7_)) {
            sql += " and UPPER_ORG_EXT_ATTR_7_ = :UPPER_ORG_EXT_ATTR_7_";
            paramMap.put("UPPER_ORG_EXT_ATTR_7_", UPPER_ORG_EXT_ATTR_7_);
        }
        if (UPPER_ORG_EXT_ATTR_7_LIST != null && !UPPER_ORG_EXT_ATTR_7_LIST.isEmpty()) {
            sql += " and UPPER_ORG_EXT_ATTR_7_ in (:UPPER_ORG_EXT_ATTR_7_LIST)";
            paramMap.put("UPPER_ORG_EXT_ATTR_7_LIST", UPPER_ORG_EXT_ATTR_7_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_ORG_EXT_ATTR_8_)) {
            sql += " and UPPER_ORG_EXT_ATTR_8_ = :UPPER_ORG_EXT_ATTR_8_";
            paramMap.put("UPPER_ORG_EXT_ATTR_8_", UPPER_ORG_EXT_ATTR_8_);
        }
        if (UPPER_ORG_EXT_ATTR_8_LIST != null && !UPPER_ORG_EXT_ATTR_8_LIST.isEmpty()) {
            sql += " and UPPER_ORG_EXT_ATTR_8_ in (:UPPER_ORG_EXT_ATTR_8_LIST)";
            paramMap.put("UPPER_ORG_EXT_ATTR_8_LIST", UPPER_ORG_EXT_ATTR_8_LIST);
        }
        if (StringUtils.isNotEmpty(UPPER_ORG_STATUS_)) {
            sql += " and UPPER_ORG_STATUS_ = :UPPER_ORG_STATUS_";
            paramMap.put("UPPER_ORG_STATUS_", UPPER_ORG_STATUS_);
        }
        if (UPPER_ORG_STATUS_LIST != null && !UPPER_ORG_STATUS_LIST.isEmpty()) {
            sql += " and UPPER_ORG_STATUS_ in (:UPPER_ORG_STATUS_LIST)";
            paramMap.put("UPPER_ORG_STATUS_LIST", UPPER_ORG_STATUS_LIST);
        }

        if (StringUtils.isNotEmpty(upperWithinOrgId)) {
            sql = "with UPPER_TMP as (select /*+ materialize*/ ORG_ID_ from (select ORG_ID_, PARENT_ORG_ID_ from OM_ORG where ORGN_SET_ID_ = :ORGN_SET_ID_) connect by prior ORG_ID_ = PARENT_ORG_ID_ start with ORG_ID_ = :upperWithinOrgId) " + sql;
            sql += " and exists (select ORG_ID_ from UPPER_TMP T where T.ORG_ID_ = ER.UPPER_ORG_ID_)";
            paramMap.put("upperWithinOrgId", upperWithinOrgId);
        }
        if (upperOrgRootOnly != null && upperOrgRootOnly) {
            sql += " and (UPPER_PARENT_ORG_ID_ is null or UPPER_PARENT_ORG_ID_ = '')";
        }

        if (StringUtils.isNotEmpty(LOWER_EMP_ID_)) {
            sql += " and LOWER_EMP_ID_ = :LOWER_EMP_ID_";
            paramMap.put("LOWER_EMP_ID_", LOWER_EMP_ID_);
        }
        if (LOWER_EMP_ID_LIST != null && !LOWER_EMP_ID_LIST.isEmpty()) {
            sql += " and LOWER_EMP_ID_ in (:LOWER_EMP_ID_LIST)";
            paramMap.put("LOWER_EMP_ID_LIST", LOWER_EMP_ID_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_EMP_CODE_)) {
            sql += " and LOWER_EMP_CODE_ = :LOWER_EMP_CODE_";
            paramMap.put("LOWER_EMP_CODE_", LOWER_EMP_CODE_);
        }
        if (LOWER_EMP_CODE_LIST != null && !LOWER_EMP_CODE_LIST.isEmpty()) {
            sql += " and LOWER_EMP_CODE_ in (:LOWER_EMP_CODE_LIST)";
            paramMap.put("LOWER_EMP_CODE_LIST", LOWER_EMP_CODE_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_EMP_NAME_)) {
            sql += " and LOWER_EMP_NAME_ like '%' || :LOWER_EMP_NAME_ || '%'";
            paramMap.put("LOWER_EMP_NAME_", LOWER_EMP_NAME_);
        }
        if (LOWER_EMP_NAME_LIST != null && !LOWER_EMP_NAME_LIST.isEmpty()) {
            sql += " and LOWER_EMP_NAME_ in (:LOWER_EMP_NAME_LIST)";
            paramMap.put("LOWER_EMP_NAME_LIST", LOWER_EMP_NAME_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_EMP_CATEGORY_)) {
            sql += " and LOWER_EMP_CATEGORY_ = :LOWER_EMP_CATEGORY_";
            paramMap.put("LOWER_EMP_CATEGORY_", LOWER_EMP_CATEGORY_);
        }
        if (LOWER_EMP_CATEGORY_LIST != null && !LOWER_EMP_CATEGORY_LIST.isEmpty()) {
            sql += " and LOWER_EMP_CATEGORY_ in (:LOWER_EMP_CATEGORY_LIST)";
            paramMap.put("LOWER_EMP_CATEGORY_LIST", LOWER_EMP_CATEGORY_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_EMP_TAG_)) {
            List<String> tagList = omTagService.splitTag(LOWER_EMP_TAG_);
            if (!tagList.isEmpty()) {
                if (lowerEmpTagUnion != null && lowerEmpTagUnion.equals(false)) {
                    sql += " and LOWER_EMP_ID_ in (select EMP_ID_ from (select OBJ_ID_ as EMP_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'EMP' and TAG_ in (:LOWER_EMP_TAG_LIST)) T group by EMP_ID_ having count(*) >= 1)";
                    paramMap.put("LOWER_EMP_TAG_LIST", tagList);
                }
                else {
                    sql += " and LOWER_EMP_ID_ in (select EMP_ID_ from (select OBJ_ID_ as EMP_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'EMP' and TAG_ in (:LOWER_EMP_TAG_LIST)) T group by EMP_ID_ having count(*) >= :lowerEmpTagCount)";
                    paramMap.put("LOWER_EMP_TAG_LIST", tagList);
                    paramMap.put("lowerEmpTagCount", tagList.size());
                }
            }
        }
        if (StringUtils.isNotEmpty(LOWER_EMP_EXT_ATTR_1_)) {
            sql += " and LOWER_EMP_EXT_ATTR_1_ = :LOWER_EMP_EXT_ATTR_1_";
            paramMap.put("LOWER_EMP_EXT_ATTR_1_", LOWER_EMP_EXT_ATTR_1_);
        }
        if (LOWER_EMP_EXT_ATTR_1_LIST != null && !LOWER_EMP_EXT_ATTR_1_LIST.isEmpty()) {
            sql += " and LOWER_EMP_EXT_ATTR_1_ in (:LOWER_EMP_EXT_ATTR_1_LIST)";
            paramMap.put("LOWER_EMP_EXT_ATTR_1_LIST", LOWER_EMP_EXT_ATTR_1_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_EMP_EXT_ATTR_2_)) {
            sql += " and LOWER_EMP_EXT_ATTR_2_ = :LOWER_EMP_EXT_ATTR_2_";
            paramMap.put("LOWER_EMP_EXT_ATTR_2_", LOWER_EMP_EXT_ATTR_2_);
        }
        if (LOWER_EMP_EXT_ATTR_2_LIST != null && !LOWER_EMP_EXT_ATTR_2_LIST.isEmpty()) {
            sql += " and LOWER_EMP_EXT_ATTR_2_ in (:LOWER_EMP_EXT_ATTR_2_LIST)";
            paramMap.put("LOWER_EMP_EXT_ATTR_2_LIST", LOWER_EMP_EXT_ATTR_2_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_EMP_EXT_ATTR_3_)) {
            sql += " and LOWER_EMP_EXT_ATTR_3_ = :LOWER_EMP_EXT_ATTR_3_";
            paramMap.put("LOWER_EMP_EXT_ATTR_3_", LOWER_EMP_EXT_ATTR_3_);
        }
        if (LOWER_EMP_EXT_ATTR_3_LIST != null && !LOWER_EMP_EXT_ATTR_3_LIST.isEmpty()) {
            sql += " and LOWER_EMP_EXT_ATTR_3_ in (:LOWER_EMP_EXT_ATTR_3_LIST)";
            paramMap.put("LOWER_EMP_EXT_ATTR_3_LIST", LOWER_EMP_EXT_ATTR_3_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_EMP_EXT_ATTR_4_)) {
            sql += " and LOWER_EMP_EXT_ATTR_4_ = :LOWER_EMP_EXT_ATTR_4_";
            paramMap.put("LOWER_EMP_EXT_ATTR_4_", LOWER_EMP_EXT_ATTR_4_);
        }
        if (LOWER_EMP_EXT_ATTR_4_LIST != null && !LOWER_EMP_EXT_ATTR_4_LIST.isEmpty()) {
            sql += " and LOWER_EMP_EXT_ATTR_4_ in (:LOWER_EMP_EXT_ATTR_4_LIST)";
            paramMap.put("LOWER_EMP_EXT_ATTR_4_LIST", LOWER_EMP_EXT_ATTR_4_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_EMP_EXT_ATTR_5_)) {
            sql += " and LOWER_EMP_EXT_ATTR_5_ = :LOWER_EMP_EXT_ATTR_5_";
            paramMap.put("LOWER_EMP_EXT_ATTR_5_", LOWER_EMP_EXT_ATTR_5_);
        }
        if (LOWER_EMP_EXT_ATTR_5_LIST != null && !LOWER_EMP_EXT_ATTR_5_LIST.isEmpty()) {
            sql += " and LOWER_EMP_EXT_ATTR_5_ in (:LOWER_EMP_EXT_ATTR_5_LIST)";
            paramMap.put("LOWER_EMP_EXT_ATTR_5_LIST", LOWER_EMP_EXT_ATTR_5_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_EMP_EXT_ATTR_6_)) {
            sql += " and LOWER_EMP_EXT_ATTR_6_ = :LOWER_EMP_EXT_ATTR_6_";
            paramMap.put("LOWER_EMP_EXT_ATTR_6_", LOWER_EMP_EXT_ATTR_6_);
        }
        if (LOWER_EMP_EXT_ATTR_6_LIST != null && !LOWER_EMP_EXT_ATTR_6_LIST.isEmpty()) {
            sql += " and LOWER_EMP_EXT_ATTR_6_ in (:LOWER_EMP_EXT_ATTR_6_LIST)";
            paramMap.put("LOWER_EMP_EXT_ATTR_6_LIST", LOWER_EMP_EXT_ATTR_6_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_EMP_EXT_ATTR_7_)) {
            sql += " and LOWER_EMP_EXT_ATTR_7_ = :LOWER_EMP_EXT_ATTR_7_";
            paramMap.put("LOWER_EMP_EXT_ATTR_7_", LOWER_EMP_EXT_ATTR_7_);
        }
        if (LOWER_EMP_EXT_ATTR_7_LIST != null && !LOWER_EMP_EXT_ATTR_7_LIST.isEmpty()) {
            sql += " and LOWER_EMP_EXT_ATTR_7_ in (:LOWER_EMP_EXT_ATTR_7_LIST)";
            paramMap.put("LOWER_EMP_EXT_ATTR_7_LIST", LOWER_EMP_EXT_ATTR_7_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_EMP_EXT_ATTR_8_)) {
            sql += " and LOWER_EMP_EXT_ATTR_8_ = :LOWER_EMP_EXT_ATTR_8_";
            paramMap.put("LOWER_EMP_EXT_ATTR_8_", LOWER_EMP_EXT_ATTR_8_);
        }
        if (LOWER_EMP_EXT_ATTR_8_LIST != null && !LOWER_EMP_EXT_ATTR_8_LIST.isEmpty()) {
            sql += " and LOWER_EMP_EXT_ATTR_8_ in (:LOWER_EMP_EXT_ATTR_8_LIST)";
            paramMap.put("LOWER_EMP_EXT_ATTR_8_LIST", LOWER_EMP_EXT_ATTR_8_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_EMP_STATUS_)) {
            sql += " and LOWER_EMP_STATUS_ = :LOWER_EMP_STATUS_";
            paramMap.put("LOWER_EMP_STATUS_", LOWER_EMP_STATUS_);
        }
        if (LOWER_EMP_STATUS_LIST != null && !LOWER_EMP_STATUS_LIST.isEmpty()) {
            sql += " and LOWER_EMP_STATUS_ in (:LOWER_EMP_STATUS_LIST)";
            paramMap.put("LOWER_EMP_STATUS_LIST", LOWER_EMP_STATUS_LIST);
        }

        if (StringUtils.isNotEmpty(LOWER_ORG_ID_)) {
            sql += " and LOWER_ORG_ID_ = :LOWER_ORG_ID_";
            paramMap.put("LOWER_ORG_ID_", LOWER_ORG_ID_);
        }
        if (LOWER_ORG_ID_LIST != null && !LOWER_ORG_ID_LIST.isEmpty()) {
            sql += " and LOWER_ORG_ID_ in (:LOWER_ORG_ID_LIST)";
            paramMap.put("LOWER_ORG_ID_LIST", LOWER_ORG_ID_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_PARENT_ORG_ID_)) {
            sql += " and LOWER_PARENT_ORG_ID_ = :LOWER_PARENT_ORG_ID_";
            paramMap.put("LOWER_PARENT_ORG_ID_", LOWER_PARENT_ORG_ID_);
        }
        if (LOWER_PARENT_ORG_ID_LIST != null && !LOWER_PARENT_ORG_ID_LIST.isEmpty()) {
            sql += " and LOWER_PARENT_ORG_ID_ in (:LOWER_PARENT_ORG_ID_LIST)";
            paramMap.put("LOWER_PARENT_ORG_ID_LIST", LOWER_PARENT_ORG_ID_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_ORG_CODE_)) {
            sql += " and LOWER_ORG_CODE_ = :LOWER_ORG_CODE_";
            paramMap.put("LOWER_ORG_CODE_", LOWER_ORG_CODE_);
        }
        if (LOWER_ORG_CODE_LIST != null && !LOWER_ORG_CODE_LIST.isEmpty()) {
            sql += " and LOWER_ORG_CODE_ in (:LOWER_ORG_CODE_LIST)";
            paramMap.put("LOWER_ORG_CODE_LIST", LOWER_ORG_CODE_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_ORG_NAME_)) {
            sql += " and LOWER_ORG_NAME_ like '%' || :LOWER_ORG_NAME_ || '%'";
            paramMap.put("LOWER_ORG_NAME_", LOWER_ORG_NAME_);
        }
        if (LOWER_ORG_NAME_LIST != null && !LOWER_ORG_NAME_LIST.isEmpty()) {
            sql += " and LOWER_ORG_NAME_ in (:LOWER_ORG_NAME_LIST)";
            paramMap.put("LOWER_ORG_NAME_LIST", LOWER_ORG_NAME_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_ORG_TYPE_)) {
            sql += " and LOWER_ORG_TYPE_ = :LOWER_ORG_TYPE_";
            paramMap.put("LOWER_ORG_TYPE_", LOWER_ORG_TYPE_);
        }
        if (LOWER_ORG_TYPE_LIST != null && !LOWER_ORG_TYPE_LIST.isEmpty()) {
            sql += " and LOWER_ORG_TYPE_ in (:LOWER_ORG_TYPE_LIST)";
            paramMap.put("LOWER_ORG_TYPE_LIST", LOWER_ORG_TYPE_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_ORG_CATEGORY_)) {
            sql += " and LOWER_ORG_CATEGORY_ = :LOWER_ORG_CATEGORY_";
            paramMap.put("LOWER_ORG_CATEGORY_", LOWER_ORG_CATEGORY_);
        }
        if (LOWER_ORG_CATEGORY_LIST != null && !LOWER_ORG_CATEGORY_LIST.isEmpty()) {
            sql += " and LOWER_ORG_CATEGORY_ in (:LOWER_ORG_CATEGORY_LIST)";
            paramMap.put("LOWER_ORG_CATEGORY_LIST", LOWER_ORG_CATEGORY_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_ORG_TAG_)) {
            List<String> tagList = omTagService.splitTag(LOWER_ORG_TAG_);
            if (!tagList.isEmpty()) {
                if (lowerOrgTagUnion != null && lowerOrgTagUnion.equals(false)) {
                    sql += " and LOWER_ORG_ID_ in (select ORG_ID_ from (select OBJ_ID_ as ORG_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'ORG' and TAG_ in (:LOWER_ORG_TAG_LIST)) T group by ORG_ID_ having count(*) >= 1)";
                    paramMap.put("LOWER_ORG_TAG_LIST", tagList);
                }
                else {
                    sql += " and LOWER_ORG_ID_ in (select ORG_ID_ from (select OBJ_ID_ as ORG_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'ORG' and TAG_ in (:LOWER_ORG_TAG_LIST)) T group by ORG_ID_ having count(*) >= :lowerOrgTagCount)";
                    paramMap.put("LOWER_ORG_TAG_LIST", tagList);
                    paramMap.put("lowerOrgTagCount", tagList.size());
                }
            }
        }
        if (StringUtils.isNotEmpty(LOWER_ORG_EXT_ATTR_1_)) {
            sql += " and LOWER_ORG_EXT_ATTR_1_ = :LOWER_ORG_EXT_ATTR_1_";
            paramMap.put("LOWER_ORG_EXT_ATTR_1_", LOWER_ORG_EXT_ATTR_1_);
        }
        if (LOWER_ORG_EXT_ATTR_1_LIST != null && !LOWER_ORG_EXT_ATTR_1_LIST.isEmpty()) {
            sql += " and LOWER_ORG_EXT_ATTR_1_ in (:LOWER_ORG_EXT_ATTR_1_LIST)";
            paramMap.put("LOWER_ORG_EXT_ATTR_1_LIST", LOWER_ORG_EXT_ATTR_1_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_ORG_EXT_ATTR_2_)) {
            sql += " and LOWER_ORG_EXT_ATTR_2_ = :LOWER_ORG_EXT_ATTR_2_";
            paramMap.put("LOWER_ORG_EXT_ATTR_2_", LOWER_ORG_EXT_ATTR_2_);
        }
        if (LOWER_ORG_EXT_ATTR_2_LIST != null && !LOWER_ORG_EXT_ATTR_2_LIST.isEmpty()) {
            sql += " and LOWER_ORG_EXT_ATTR_2_ in (:LOWER_ORG_EXT_ATTR_2_LIST)";
            paramMap.put("LOWER_ORG_EXT_ATTR_2_LIST", LOWER_ORG_EXT_ATTR_2_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_ORG_EXT_ATTR_3_)) {
            sql += " and LOWER_ORG_EXT_ATTR_3_ = :LOWER_ORG_EXT_ATTR_3_";
            paramMap.put("LOWER_ORG_EXT_ATTR_3_", LOWER_ORG_EXT_ATTR_3_);
        }
        if (LOWER_ORG_EXT_ATTR_3_LIST != null && !LOWER_ORG_EXT_ATTR_3_LIST.isEmpty()) {
            sql += " and LOWER_ORG_EXT_ATTR_3_ in (:LOWER_ORG_EXT_ATTR_3_LIST)";
            paramMap.put("LOWER_ORG_EXT_ATTR_3_LIST", LOWER_ORG_EXT_ATTR_3_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_ORG_EXT_ATTR_4_)) {
            sql += " and LOWER_ORG_EXT_ATTR_4_ = :LOWER_ORG_EXT_ATTR_4_";
            paramMap.put("LOWER_ORG_EXT_ATTR_4_", LOWER_ORG_EXT_ATTR_4_);
        }
        if (LOWER_ORG_EXT_ATTR_4_LIST != null && !LOWER_ORG_EXT_ATTR_4_LIST.isEmpty()) {
            sql += " and LOWER_ORG_EXT_ATTR_4_ in (:LOWER_ORG_EXT_ATTR_4_LIST)";
            paramMap.put("LOWER_ORG_EXT_ATTR_4_LIST", LOWER_ORG_EXT_ATTR_4_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_ORG_EXT_ATTR_5_)) {
            sql += " and LOWER_ORG_EXT_ATTR_5_ = :LOWER_ORG_EXT_ATTR_5_";
            paramMap.put("LOWER_ORG_EXT_ATTR_5_", LOWER_ORG_EXT_ATTR_5_);
        }
        if (LOWER_ORG_EXT_ATTR_5_LIST != null && !LOWER_ORG_EXT_ATTR_5_LIST.isEmpty()) {
            sql += " and LOWER_ORG_EXT_ATTR_5_ in (:LOWER_ORG_EXT_ATTR_5_LIST)";
            paramMap.put("LOWER_ORG_EXT_ATTR_5_LIST", LOWER_ORG_EXT_ATTR_5_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_ORG_EXT_ATTR_6_)) {
            sql += " and LOWER_ORG_EXT_ATTR_6_ = :LOWER_ORG_EXT_ATTR_6_";
            paramMap.put("LOWER_ORG_EXT_ATTR_6_", LOWER_ORG_EXT_ATTR_6_);
        }
        if (LOWER_ORG_EXT_ATTR_6_LIST != null && !LOWER_ORG_EXT_ATTR_6_LIST.isEmpty()) {
            sql += " and LOWER_ORG_EXT_ATTR_6_ in (:LOWER_ORG_EXT_ATTR_6_LIST)";
            paramMap.put("LOWER_ORG_EXT_ATTR_6_LIST", LOWER_ORG_EXT_ATTR_6_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_ORG_EXT_ATTR_7_)) {
            sql += " and LOWER_ORG_EXT_ATTR_7_ = :LOWER_ORG_EXT_ATTR_7_";
            paramMap.put("LOWER_ORG_EXT_ATTR_7_", LOWER_ORG_EXT_ATTR_7_);
        }
        if (LOWER_ORG_EXT_ATTR_7_LIST != null && !LOWER_ORG_EXT_ATTR_7_LIST.isEmpty()) {
            sql += " and LOWER_ORG_EXT_ATTR_7_ in (:LOWER_ORG_EXT_ATTR_7_LIST)";
            paramMap.put("LOWER_ORG_EXT_ATTR_7_LIST", LOWER_ORG_EXT_ATTR_7_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_ORG_EXT_ATTR_8_)) {
            sql += " and LOWER_ORG_EXT_ATTR_8_ = :LOWER_ORG_EXT_ATTR_8_";
            paramMap.put("LOWER_ORG_EXT_ATTR_8_", LOWER_ORG_EXT_ATTR_8_);
        }
        if (LOWER_ORG_EXT_ATTR_8_LIST != null && !LOWER_ORG_EXT_ATTR_8_LIST.isEmpty()) {
            sql += " and LOWER_ORG_EXT_ATTR_8_ in (:LOWER_ORG_EXT_ATTR_8_LIST)";
            paramMap.put("LOWER_ORG_EXT_ATTR_8_LIST", LOWER_ORG_EXT_ATTR_8_LIST);
        }
        if (StringUtils.isNotEmpty(LOWER_ORG_STATUS_)) {
            sql += " and LOWER_ORG_STATUS_ = :LOWER_ORG_STATUS_";
            paramMap.put("LOWER_ORG_STATUS_", LOWER_ORG_STATUS_);
        }
        if (LOWER_ORG_STATUS_LIST != null && !LOWER_ORG_STATUS_LIST.isEmpty()) {
            sql += " and LOWER_ORG_STATUS_ in (:LOWER_ORG_STATUS_LIST)";
            paramMap.put("LOWER_ORG_STATUS_LIST", LOWER_ORG_STATUS_LIST);
        }

        if (StringUtils.isNotEmpty(lowerWithinOrgId)) {
            if (sql.startsWith("with")) {
                sql = "with LOWER_TMP as (select /*+ materialize*/ ORG_ID_ from (select ORG_ID_, PARENT_ORG_ID_ from OM_ORG where ORGN_SET_ID_ = :ORGN_SET_ID_) connect by prior ORG_ID_ = PARENT_ORG_ID_ start with ORG_ID_ = :lowerWithinOrgId), " + sql.substring(4);
            }
            else {
                sql = "with LOWER_TMP as (select /*+ materialize*/ ORG_ID_ from (select ORG_ID_, PARENT_ORG_ID_ from OM_ORG where ORGN_SET_ID_ = :ORGN_SET_ID_) connect by prior ORG_ID_ = PARENT_ORG_ID_ start with ORG_ID_ = :lowerWithinOrgId) " + sql;
            }
            sql += " and exists (select ORG_ID_ from LOWER_TMP T where T.ORG_ID_ = ER.LOWER_ORG_ID_)";
            paramMap.put("lowerWithinOrgId", lowerWithinOrgId);
        }
        if (lowerOrgRootOnly != null && lowerOrgRootOnly) {
            sql += " and (LOWER_PARENT_ORG_ID_ is null or LOWER_PARENT_ORG_ID_ = '')";
        }

        if (!count) {
            sql += " order by UPPER_ORG_ID_, LOWER_ORG_ID_, UPPER_EMP_ID_, LOWER_EMP_ID_";
        }

        return new OdSqlCriteria(sql, paramMap);
    }

    @Override
    public List<Map<String, Object>> selectEmpRelationByIdList(String ORGN_SET_ID_, List<String> EMP_RELATION_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (EMP_RELATION_ID_LIST == null || EMP_RELATION_ID_LIST.isEmpty()) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder(EMP_RELATION_ID_LIST.size() * 50 + 200);
        Map<String, Object> paramMap = new HashMap<>();

        sql.append("select * from OMV_EMP_RELATION where ORGN_SET_ID_ = :ORGN_SET_ID_ and EMP_RELATION_ID_ in (:EMP_RELATION_ID_LIST)");
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        paramMap.put("EMP_RELATION_ID_LIST", EMP_RELATION_ID_LIST);
        sql.append(" order by DECODE(EMP_RELATION_ID_,");// 按主键列表顺序排序
        for (int i = 0; i < EMP_RELATION_ID_LIST.size(); i++) {
            sql.append(" '").append(EMP_RELATION_ID_LIST.get(i)).append("', ").append(i);
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

        if (EMP_RELATION_ID_LIST == null || EMP_RELATION_ID_LIST.isEmpty()) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder(EMP_RELATION_ID_LIST.size() * 50 + 200);
        Map<String, Object> paramMap = new HashMap<>();

        sql.append("select * from OM_EMP_RELATION where ORGN_SET_ID_ = :ORGN_SET_ID_ and EMP_RELATION_ID_ in (:EMP_RELATION_ID_LIST)");
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        paramMap.put("EMP_RELATION_ID_LIST", EMP_RELATION_ID_LIST);
        sql.append(" order by DECODE(EMP_RELATION_ID_,");// 按主键列表顺序排序
        for (int i = 0; i < EMP_RELATION_ID_LIST.size(); i++) {
            sql.append(" '").append(EMP_RELATION_ID_LIST.get(i)).append("', ").append(i);
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
    public int insertEmpRelation(String ORGN_SET_ID_, String EMP_RELATION_ID_, String UPPER_EMP_ID_, String LOWER_EMP_ID_, String EMP_RELATION_, String EMP_RELATION_CATEGORY_, String MEMO_, String EMP_RELATION_TAG_, String EMP_RELATION_EXT_ATTR_1_, String EMP_RELATION_EXT_ATTR_2_, String EMP_RELATION_EXT_ATTR_3_, String EMP_RELATION_EXT_ATTR_4_, String EMP_RELATION_EXT_ATTR_5_, String EMP_RELATION_EXT_ATTR_6_, String EMP_RELATION_EXT_ATTR_7_, String EMP_RELATION_EXT_ATTR_8_, Integer ORDER_, String EMP_RELATION_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        EMP_RELATION_TAG_ = StringUtils.join(omTagService.splitTag(EMP_RELATION_TAG_), ",");
        omTagService.updateTagByObjId(ORGN_SET_ID_, EMP_RELATION_ID_, "EMP_RELATION", EMP_RELATION_TAG_);

        String sql = "insert into OM_EMP_RELATION (ORGN_SET_ID_, EMP_RELATION_ID_, UPPER_EMP_ID_, LOWER_EMP_ID_, EMP_RELATION_, EMP_RELATION_CATEGORY_, MEMO_, EMP_RELATION_TAG_, EMP_RELATION_EXT_ATTR_1_, EMP_RELATION_EXT_ATTR_2_, EMP_RELATION_EXT_ATTR_3_, EMP_RELATION_EXT_ATTR_4_, EMP_RELATION_EXT_ATTR_5_, EMP_RELATION_EXT_ATTR_6_, EMP_RELATION_EXT_ATTR_7_, EMP_RELATION_EXT_ATTR_8_, ORDER_, EMP_RELATION_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return omJdbcTemplate.update(sql, ORGN_SET_ID_, EMP_RELATION_ID_, UPPER_EMP_ID_, LOWER_EMP_ID_, EMP_RELATION_, EMP_RELATION_CATEGORY_, MEMO_, EMP_RELATION_TAG_, EMP_RELATION_EXT_ATTR_1_, EMP_RELATION_EXT_ATTR_2_, EMP_RELATION_EXT_ATTR_3_, EMP_RELATION_EXT_ATTR_4_, EMP_RELATION_EXT_ATTR_5_, EMP_RELATION_EXT_ATTR_6_, EMP_RELATION_EXT_ATTR_7_, EMP_RELATION_EXT_ATTR_8_, ORDER_, EMP_RELATION_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_);
    }

    @Override
    public int updateEmpRelation(String ORGN_SET_ID_, String EMP_RELATION_ID_, String EMP_RELATION_, String EMP_RELATION_CATEGORY_, String MEMO_, String EMP_RELATION_TAG_, String EMP_RELATION_EXT_ATTR_1_, String EMP_RELATION_EXT_ATTR_2_, String EMP_RELATION_EXT_ATTR_3_, String EMP_RELATION_EXT_ATTR_4_, String EMP_RELATION_EXT_ATTR_5_, String EMP_RELATION_EXT_ATTR_6_, String EMP_RELATION_EXT_ATTR_7_, String EMP_RELATION_EXT_ATTR_8_, Integer ORDER_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        EMP_RELATION_TAG_ = StringUtils.join(omTagService.splitTag(EMP_RELATION_TAG_), ",");
        omTagService.updateTagByObjId(ORGN_SET_ID_, EMP_RELATION_ID_, "EMP_RELATION", EMP_RELATION_TAG_);

        String sql = "update OM_EMP_RELATION set EMP_RELATION_ = ?, EMP_RELATION_CATEGORY_ = ?, MEMO_ = ?, EMP_RELATION_TAG_ = ?, EMP_RELATION_EXT_ATTR_1_ = ?, EMP_RELATION_EXT_ATTR_2_ = ?, EMP_RELATION_EXT_ATTR_3_ = ?, EMP_RELATION_EXT_ATTR_4_ = ?, EMP_RELATION_EXT_ATTR_5_ = ?, EMP_RELATION_EXT_ATTR_6_ = ?, EMP_RELATION_EXT_ATTR_7_ = ?, EMP_RELATION_EXT_ATTR_8_ = ?, ORDER_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and EMP_RELATION_ID_ = ?";
        return omJdbcTemplate.update(sql, EMP_RELATION_, EMP_RELATION_CATEGORY_, MEMO_, EMP_RELATION_TAG_, EMP_RELATION_EXT_ATTR_1_, EMP_RELATION_EXT_ATTR_2_, EMP_RELATION_EXT_ATTR_3_, EMP_RELATION_EXT_ATTR_4_, EMP_RELATION_EXT_ATTR_5_, EMP_RELATION_EXT_ATTR_6_, EMP_RELATION_EXT_ATTR_7_, EMP_RELATION_EXT_ATTR_8_, ORDER_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, EMP_RELATION_ID_);
    }

    @Override
    public int updateEmpRelationOrder(final String ORGN_SET_ID_, final List<String> EMP_RELATION_ID_LIST, final List<Integer> ORDER_LIST, final Date UPDATE_DATE_, final String OPERATOR_ID_, final String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (EMP_RELATION_ID_LIST == null || EMP_RELATION_ID_LIST.isEmpty()) {
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

        List<Map<String, Object>> upperEmpRelationList = selectEmpRelation(ORGN_SET_ID_, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, EMP_ID_, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1, -1, OPERATOR_ID_, OPERATOR_NAME_);
        for (Map<String, Object> empRelation : upperEmpRelationList) {
            deleteEmpRelation(ORGN_SET_ID_, (String) empRelation.get("EMP_RELATION_ID_"), UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_);
        }
        List<Map<String, Object>> lowerEmpRelationList = selectEmpRelation(ORGN_SET_ID_, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, EMP_ID_, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1, -1, OPERATOR_ID_, OPERATOR_NAME_);
        for (Map<String, Object> empRelation : lowerEmpRelationList) {
            deleteEmpRelation(ORGN_SET_ID_, (String) empRelation.get("EMP_RELATION_ID_"), UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_);
        }

        return upperEmpRelationList.size() + lowerEmpRelationList.size();
    }
}