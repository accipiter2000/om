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
        Map<String, Object> paramMap = new HashMap<>();
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
    public List<Map<String, Object>> selectPosiEmp(String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_EMP_ID_, List<String> POSI_EMP_ID_LIST, String MAIN_, List<String> MAIN_LIST, String POSI_EMP_CATEGORY_, List<String> POSI_EMP_CATEGORY_LIST, String POSI_EMP_TAG_, String POSI_EMP_EXT_ATTR_1_, List<String> POSI_EMP_EXT_ATTR_1_LIST, String POSI_EMP_EXT_ATTR_2_, List<String> POSI_EMP_EXT_ATTR_2_LIST, String POSI_EMP_EXT_ATTR_3_, List<String> POSI_EMP_EXT_ATTR_3_LIST, String POSI_EMP_EXT_ATTR_4_, List<String> POSI_EMP_EXT_ATTR_4_LIST, String POSI_EMP_EXT_ATTR_5_, List<String> POSI_EMP_EXT_ATTR_5_LIST, String POSI_EMP_EXT_ATTR_6_, List<String> POSI_EMP_EXT_ATTR_6_LIST, String POSI_EMP_EXT_ATTR_7_, List<String> POSI_EMP_EXT_ATTR_7_LIST, String POSI_EMP_EXT_ATTR_8_,
            List<String> POSI_EMP_EXT_ATTR_8_LIST, String POSI_EMP_STATUS_, List<String> POSI_EMP_STATUS_LIST, String EMP_ID_, List<String> EMP_ID_LIST, String EMP_CODE_, List<String> EMP_CODE_LIST, String EMP_NAME_, List<String> EMP_NAME_LIST, String EMP_CATEGORY_, List<String> EMP_CATEGORY_LIST, String EMP_TAG_, String EMP_EXT_ATTR_1_, List<String> EMP_EXT_ATTR_1_LIST, String EMP_EXT_ATTR_2_, List<String> EMP_EXT_ATTR_2_LIST, String EMP_EXT_ATTR_3_, List<String> EMP_EXT_ATTR_3_LIST, String EMP_EXT_ATTR_4_, List<String> EMP_EXT_ATTR_4_LIST, String EMP_EXT_ATTR_5_, List<String> EMP_EXT_ATTR_5_LIST, String EMP_EXT_ATTR_6_, List<String> EMP_EXT_ATTR_6_LIST, String EMP_EXT_ATTR_7_, List<String> EMP_EXT_ATTR_7_LIST, String EMP_EXT_ATTR_8_, List<String> EMP_EXT_ATTR_8_LIST, String EMP_STATUS_,
            List<String> EMP_STATUS_LIST, String POSI_ID_, List<String> POSI_ID_LIST, String POSI_CODE_, List<String> POSI_CODE_LIST, String POSI_NAME_, List<String> POSI_NAME_LIST, String ORG_LEADER_TYPE_, List<String> ORG_LEADER_TYPE_LIST, String POSI_CATEGORY_, List<String> POSI_CATEGORY_LIST, String POSI_TAG_, String POSI_EXT_ATTR_1_, List<String> POSI_EXT_ATTR_1_LIST, String POSI_EXT_ATTR_2_, List<String> POSI_EXT_ATTR_2_LIST, String POSI_EXT_ATTR_3_, List<String> POSI_EXT_ATTR_3_LIST, String POSI_EXT_ATTR_4_, List<String> POSI_EXT_ATTR_4_LIST, String POSI_EXT_ATTR_5_, List<String> POSI_EXT_ATTR_5_LIST, String POSI_EXT_ATTR_6_, List<String> POSI_EXT_ATTR_6_LIST, String POSI_EXT_ATTR_7_, List<String> POSI_EXT_ATTR_7_LIST, String POSI_EXT_ATTR_8_, List<String> POSI_EXT_ATTR_8_LIST,
            String POSI_STATUS_, List<String> POSI_STATUS_LIST, String DUTY_ID_, List<String> DUTY_ID_LIST, String DUTY_CODE_, List<String> DUTY_CODE_LIST, String DUTY_NAME_, List<String> DUTY_NAME_LIST, String DUTY_CATEGORY_, List<String> DUTY_CATEGORY_LIST, String DUTY_TAG_, String DUTY_EXT_ATTR_1_, List<String> DUTY_EXT_ATTR_1_LIST, String DUTY_EXT_ATTR_2_, List<String> DUTY_EXT_ATTR_2_LIST, String DUTY_EXT_ATTR_3_, List<String> DUTY_EXT_ATTR_3_LIST, String DUTY_EXT_ATTR_4_, List<String> DUTY_EXT_ATTR_4_LIST, String DUTY_EXT_ATTR_5_, List<String> DUTY_EXT_ATTR_5_LIST, String DUTY_EXT_ATTR_6_, List<String> DUTY_EXT_ATTR_6_LIST, String DUTY_EXT_ATTR_7_, List<String> DUTY_EXT_ATTR_7_LIST, String DUTY_EXT_ATTR_8_, List<String> DUTY_EXT_ATTR_8_LIST, String DUTY_STATUS_,
            List<String> DUTY_STATUS_LIST, String ORG_ID_, List<String> ORG_ID_LIST, String PARENT_ORG_ID_, List<String> PARENT_ORG_ID_LIST, String ORG_CODE_, List<String> ORG_CODE_LIST, String ORG_NAME_, List<String> ORG_NAME_LIST, String ORG_TYPE_, List<String> ORG_TYPE_LIST, String ORG_CATEGORY_, List<String> ORG_CATEGORY_LIST, String ORG_TAG_, String ORG_EXT_ATTR_1_, List<String> ORG_EXT_ATTR_1_LIST, String ORG_EXT_ATTR_2_, List<String> ORG_EXT_ATTR_2_LIST, String ORG_EXT_ATTR_3_, List<String> ORG_EXT_ATTR_3_LIST, String ORG_EXT_ATTR_4_, List<String> ORG_EXT_ATTR_4_LIST, String ORG_EXT_ATTR_5_, List<String> ORG_EXT_ATTR_5_LIST, String ORG_EXT_ATTR_6_, List<String> ORG_EXT_ATTR_6_LIST, String ORG_EXT_ATTR_7_, List<String> ORG_EXT_ATTR_7_LIST, String ORG_EXT_ATTR_8_,
            List<String> ORG_EXT_ATTR_8_LIST, String ORG_STATUS_, List<String> ORG_STATUS_LIST, Boolean posiEmpTagUnion, Boolean empTagUnion, Boolean posiTagUnion, Boolean dutyTagUnion, Boolean orgTagUnion, String withinOrgId, Boolean orgRootOnly, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaPosiEmp(false, ORGN_SET_ID_, ORGN_SET_CODE_, POSI_EMP_ID_, POSI_EMP_ID_LIST, MAIN_, MAIN_LIST, POSI_EMP_CATEGORY_, POSI_EMP_CATEGORY_LIST, POSI_EMP_TAG_, POSI_EMP_EXT_ATTR_1_, POSI_EMP_EXT_ATTR_1_LIST, POSI_EMP_EXT_ATTR_2_, POSI_EMP_EXT_ATTR_2_LIST, POSI_EMP_EXT_ATTR_3_, POSI_EMP_EXT_ATTR_3_LIST, POSI_EMP_EXT_ATTR_4_, POSI_EMP_EXT_ATTR_4_LIST, POSI_EMP_EXT_ATTR_5_, POSI_EMP_EXT_ATTR_5_LIST, POSI_EMP_EXT_ATTR_6_, POSI_EMP_EXT_ATTR_6_LIST, POSI_EMP_EXT_ATTR_7_, POSI_EMP_EXT_ATTR_7_LIST, POSI_EMP_EXT_ATTR_8_, POSI_EMP_EXT_ATTR_8_LIST, POSI_EMP_STATUS_, POSI_EMP_STATUS_LIST, EMP_ID_, EMP_ID_LIST, EMP_CODE_, EMP_CODE_LIST, EMP_NAME_, EMP_NAME_LIST, EMP_CATEGORY_, EMP_CATEGORY_LIST, EMP_TAG_, EMP_EXT_ATTR_1_, EMP_EXT_ATTR_1_LIST,
                EMP_EXT_ATTR_2_, EMP_EXT_ATTR_2_LIST, EMP_EXT_ATTR_3_, EMP_EXT_ATTR_3_LIST, EMP_EXT_ATTR_4_, EMP_EXT_ATTR_4_LIST, EMP_EXT_ATTR_5_, EMP_EXT_ATTR_5_LIST, EMP_EXT_ATTR_6_, EMP_EXT_ATTR_6_LIST, EMP_EXT_ATTR_7_, EMP_EXT_ATTR_7_LIST, EMP_EXT_ATTR_8_, EMP_EXT_ATTR_8_LIST, EMP_STATUS_, EMP_STATUS_LIST, POSI_ID_, POSI_ID_LIST, POSI_CODE_, POSI_CODE_LIST, POSI_NAME_, POSI_NAME_LIST, ORG_LEADER_TYPE_, ORG_LEADER_TYPE_LIST, POSI_CATEGORY_, POSI_CATEGORY_LIST, POSI_TAG_, POSI_EXT_ATTR_1_, POSI_EXT_ATTR_1_LIST, POSI_EXT_ATTR_2_, POSI_EXT_ATTR_2_LIST, POSI_EXT_ATTR_3_, POSI_EXT_ATTR_3_LIST, POSI_EXT_ATTR_4_, POSI_EXT_ATTR_4_LIST, POSI_EXT_ATTR_5_, POSI_EXT_ATTR_5_LIST, POSI_EXT_ATTR_6_, POSI_EXT_ATTR_6_LIST, POSI_EXT_ATTR_7_, POSI_EXT_ATTR_7_LIST, POSI_EXT_ATTR_8_, POSI_EXT_ATTR_8_LIST,
                POSI_STATUS_, POSI_STATUS_LIST, DUTY_ID_, DUTY_ID_LIST, DUTY_CODE_, DUTY_CODE_LIST, DUTY_NAME_, DUTY_NAME_LIST, DUTY_CATEGORY_, DUTY_CATEGORY_LIST, DUTY_TAG_, DUTY_EXT_ATTR_1_, DUTY_EXT_ATTR_1_LIST, DUTY_EXT_ATTR_2_, DUTY_EXT_ATTR_2_LIST, DUTY_EXT_ATTR_3_, DUTY_EXT_ATTR_3_LIST, DUTY_EXT_ATTR_4_, DUTY_EXT_ATTR_4_LIST, DUTY_EXT_ATTR_5_, DUTY_EXT_ATTR_5_LIST, DUTY_EXT_ATTR_6_, DUTY_EXT_ATTR_6_LIST, DUTY_EXT_ATTR_7_, DUTY_EXT_ATTR_7_LIST, DUTY_EXT_ATTR_8_, DUTY_EXT_ATTR_8_LIST, DUTY_STATUS_, DUTY_STATUS_LIST, ORG_ID_, ORG_ID_LIST, PARENT_ORG_ID_, PARENT_ORG_ID_LIST, ORG_CODE_, ORG_CODE_LIST, ORG_NAME_, ORG_NAME_LIST, ORG_TYPE_, ORG_TYPE_LIST, ORG_CATEGORY_, ORG_CATEGORY_LIST, ORG_TAG_, ORG_EXT_ATTR_1_, ORG_EXT_ATTR_1_LIST, ORG_EXT_ATTR_2_, ORG_EXT_ATTR_2_LIST, ORG_EXT_ATTR_3_,
                ORG_EXT_ATTR_3_LIST, ORG_EXT_ATTR_4_, ORG_EXT_ATTR_4_LIST, ORG_EXT_ATTR_5_, ORG_EXT_ATTR_5_LIST, ORG_EXT_ATTR_6_, ORG_EXT_ATTR_6_LIST, ORG_EXT_ATTR_7_, ORG_EXT_ATTR_7_LIST, ORG_EXT_ATTR_8_, ORG_EXT_ATTR_8_LIST, ORG_STATUS_, ORG_STATUS_LIST, posiEmpTagUnion, empTagUnion, posiTagUnion, dutyTagUnion, orgTagUnion, withinOrgId, orgRootOnly, OPERATOR_ID_, OPERATOR_NAME_);// 根据查询条件组装查询SQL语句
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
    public int countPosiEmp(String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_EMP_ID_, List<String> POSI_EMP_ID_LIST, String MAIN_, List<String> MAIN_LIST, String POSI_EMP_CATEGORY_, List<String> POSI_EMP_CATEGORY_LIST, String POSI_EMP_TAG_, String POSI_EMP_EXT_ATTR_1_, List<String> POSI_EMP_EXT_ATTR_1_LIST, String POSI_EMP_EXT_ATTR_2_, List<String> POSI_EMP_EXT_ATTR_2_LIST, String POSI_EMP_EXT_ATTR_3_, List<String> POSI_EMP_EXT_ATTR_3_LIST, String POSI_EMP_EXT_ATTR_4_, List<String> POSI_EMP_EXT_ATTR_4_LIST, String POSI_EMP_EXT_ATTR_5_, List<String> POSI_EMP_EXT_ATTR_5_LIST, String POSI_EMP_EXT_ATTR_6_, List<String> POSI_EMP_EXT_ATTR_6_LIST, String POSI_EMP_EXT_ATTR_7_, List<String> POSI_EMP_EXT_ATTR_7_LIST, String POSI_EMP_EXT_ATTR_8_, List<String> POSI_EMP_EXT_ATTR_8_LIST,
            String POSI_EMP_STATUS_, List<String> POSI_EMP_STATUS_LIST, String EMP_ID_, List<String> EMP_ID_LIST, String EMP_CODE_, List<String> EMP_CODE_LIST, String EMP_NAME_, List<String> EMP_NAME_LIST, String EMP_CATEGORY_, List<String> EMP_CATEGORY_LIST, String EMP_TAG_, String EMP_EXT_ATTR_1_, List<String> EMP_EXT_ATTR_1_LIST, String EMP_EXT_ATTR_2_, List<String> EMP_EXT_ATTR_2_LIST, String EMP_EXT_ATTR_3_, List<String> EMP_EXT_ATTR_3_LIST, String EMP_EXT_ATTR_4_, List<String> EMP_EXT_ATTR_4_LIST, String EMP_EXT_ATTR_5_, List<String> EMP_EXT_ATTR_5_LIST, String EMP_EXT_ATTR_6_, List<String> EMP_EXT_ATTR_6_LIST, String EMP_EXT_ATTR_7_, List<String> EMP_EXT_ATTR_7_LIST, String EMP_EXT_ATTR_8_, List<String> EMP_EXT_ATTR_8_LIST, String EMP_STATUS_, List<String> EMP_STATUS_LIST,
            String POSI_ID_, List<String> POSI_ID_LIST, String POSI_CODE_, List<String> POSI_CODE_LIST, String POSI_NAME_, List<String> POSI_NAME_LIST, String ORG_LEADER_TYPE_, List<String> ORG_LEADER_TYPE_LIST, String POSI_CATEGORY_, List<String> POSI_CATEGORY_LIST, String POSI_TAG_, String POSI_EXT_ATTR_1_, List<String> POSI_EXT_ATTR_1_LIST, String POSI_EXT_ATTR_2_, List<String> POSI_EXT_ATTR_2_LIST, String POSI_EXT_ATTR_3_, List<String> POSI_EXT_ATTR_3_LIST, String POSI_EXT_ATTR_4_, List<String> POSI_EXT_ATTR_4_LIST, String POSI_EXT_ATTR_5_, List<String> POSI_EXT_ATTR_5_LIST, String POSI_EXT_ATTR_6_, List<String> POSI_EXT_ATTR_6_LIST, String POSI_EXT_ATTR_7_, List<String> POSI_EXT_ATTR_7_LIST, String POSI_EXT_ATTR_8_, List<String> POSI_EXT_ATTR_8_LIST, String POSI_STATUS_,
            List<String> POSI_STATUS_LIST, String DUTY_ID_, List<String> DUTY_ID_LIST, String DUTY_CODE_, List<String> DUTY_CODE_LIST, String DUTY_NAME_, List<String> DUTY_NAME_LIST, String DUTY_CATEGORY_, List<String> DUTY_CATEGORY_LIST, String DUTY_TAG_, String DUTY_EXT_ATTR_1_, List<String> DUTY_EXT_ATTR_1_LIST, String DUTY_EXT_ATTR_2_, List<String> DUTY_EXT_ATTR_2_LIST, String DUTY_EXT_ATTR_3_, List<String> DUTY_EXT_ATTR_3_LIST, String DUTY_EXT_ATTR_4_, List<String> DUTY_EXT_ATTR_4_LIST, String DUTY_EXT_ATTR_5_, List<String> DUTY_EXT_ATTR_5_LIST, String DUTY_EXT_ATTR_6_, List<String> DUTY_EXT_ATTR_6_LIST, String DUTY_EXT_ATTR_7_, List<String> DUTY_EXT_ATTR_7_LIST, String DUTY_EXT_ATTR_8_, List<String> DUTY_EXT_ATTR_8_LIST, String DUTY_STATUS_, List<String> DUTY_STATUS_LIST,
            String ORG_ID_, List<String> ORG_ID_LIST, String PARENT_ORG_ID_, List<String> PARENT_ORG_ID_LIST, String ORG_CODE_, List<String> ORG_CODE_LIST, String ORG_NAME_, List<String> ORG_NAME_LIST, String ORG_TYPE_, List<String> ORG_TYPE_LIST, String ORG_CATEGORY_, List<String> ORG_CATEGORY_LIST, String ORG_TAG_, String ORG_EXT_ATTR_1_, List<String> ORG_EXT_ATTR_1_LIST, String ORG_EXT_ATTR_2_, List<String> ORG_EXT_ATTR_2_LIST, String ORG_EXT_ATTR_3_, List<String> ORG_EXT_ATTR_3_LIST, String ORG_EXT_ATTR_4_, List<String> ORG_EXT_ATTR_4_LIST, String ORG_EXT_ATTR_5_, List<String> ORG_EXT_ATTR_5_LIST, String ORG_EXT_ATTR_6_, List<String> ORG_EXT_ATTR_6_LIST, String ORG_EXT_ATTR_7_, List<String> ORG_EXT_ATTR_7_LIST, String ORG_EXT_ATTR_8_, List<String> ORG_EXT_ATTR_8_LIST,
            String ORG_STATUS_, List<String> ORG_STATUS_LIST, Boolean posiEmpTagUnion, Boolean empTagUnion, Boolean posiTagUnion, Boolean dutyTagUnion, Boolean orgTagUnion, String withinOrgId, Boolean orgRootOnly, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaPosiEmp(true, ORGN_SET_ID_, ORGN_SET_CODE_, POSI_EMP_ID_, POSI_EMP_ID_LIST, MAIN_, MAIN_LIST, POSI_EMP_CATEGORY_, POSI_EMP_CATEGORY_LIST, POSI_EMP_TAG_, POSI_EMP_EXT_ATTR_1_, POSI_EMP_EXT_ATTR_1_LIST, POSI_EMP_EXT_ATTR_2_, POSI_EMP_EXT_ATTR_2_LIST, POSI_EMP_EXT_ATTR_3_, POSI_EMP_EXT_ATTR_3_LIST, POSI_EMP_EXT_ATTR_4_, POSI_EMP_EXT_ATTR_4_LIST, POSI_EMP_EXT_ATTR_5_, POSI_EMP_EXT_ATTR_5_LIST, POSI_EMP_EXT_ATTR_6_, POSI_EMP_EXT_ATTR_6_LIST, POSI_EMP_EXT_ATTR_7_, POSI_EMP_EXT_ATTR_7_LIST, POSI_EMP_EXT_ATTR_8_, POSI_EMP_EXT_ATTR_8_LIST, POSI_EMP_STATUS_, POSI_EMP_STATUS_LIST, EMP_ID_, EMP_ID_LIST, EMP_CODE_, EMP_CODE_LIST, EMP_NAME_, EMP_NAME_LIST, EMP_CATEGORY_, EMP_CATEGORY_LIST, EMP_TAG_, EMP_EXT_ATTR_1_, EMP_EXT_ATTR_1_LIST,
                EMP_EXT_ATTR_2_, EMP_EXT_ATTR_2_LIST, EMP_EXT_ATTR_3_, EMP_EXT_ATTR_3_LIST, EMP_EXT_ATTR_4_, EMP_EXT_ATTR_4_LIST, EMP_EXT_ATTR_5_, EMP_EXT_ATTR_5_LIST, EMP_EXT_ATTR_6_, EMP_EXT_ATTR_6_LIST, EMP_EXT_ATTR_7_, EMP_EXT_ATTR_7_LIST, EMP_EXT_ATTR_8_, EMP_EXT_ATTR_8_LIST, EMP_STATUS_, EMP_STATUS_LIST, POSI_ID_, POSI_ID_LIST, POSI_CODE_, POSI_CODE_LIST, POSI_NAME_, POSI_NAME_LIST, ORG_LEADER_TYPE_, ORG_LEADER_TYPE_LIST, POSI_CATEGORY_, POSI_CATEGORY_LIST, POSI_TAG_, POSI_EXT_ATTR_1_, POSI_EXT_ATTR_1_LIST, POSI_EXT_ATTR_2_, POSI_EXT_ATTR_2_LIST, POSI_EXT_ATTR_3_, POSI_EXT_ATTR_3_LIST, POSI_EXT_ATTR_4_, POSI_EXT_ATTR_4_LIST, POSI_EXT_ATTR_5_, POSI_EXT_ATTR_5_LIST, POSI_EXT_ATTR_6_, POSI_EXT_ATTR_6_LIST, POSI_EXT_ATTR_7_, POSI_EXT_ATTR_7_LIST, POSI_EXT_ATTR_8_, POSI_EXT_ATTR_8_LIST,
                POSI_STATUS_, POSI_STATUS_LIST, DUTY_ID_, DUTY_ID_LIST, DUTY_CODE_, DUTY_CODE_LIST, DUTY_NAME_, DUTY_NAME_LIST, DUTY_CATEGORY_, DUTY_CATEGORY_LIST, DUTY_TAG_, DUTY_EXT_ATTR_1_, DUTY_EXT_ATTR_1_LIST, DUTY_EXT_ATTR_2_, DUTY_EXT_ATTR_2_LIST, DUTY_EXT_ATTR_3_, DUTY_EXT_ATTR_3_LIST, DUTY_EXT_ATTR_4_, DUTY_EXT_ATTR_4_LIST, DUTY_EXT_ATTR_5_, DUTY_EXT_ATTR_5_LIST, DUTY_EXT_ATTR_6_, DUTY_EXT_ATTR_6_LIST, DUTY_EXT_ATTR_7_, DUTY_EXT_ATTR_7_LIST, DUTY_EXT_ATTR_8_, DUTY_EXT_ATTR_8_LIST, DUTY_STATUS_, DUTY_STATUS_LIST, ORG_ID_, ORG_ID_LIST, PARENT_ORG_ID_, PARENT_ORG_ID_LIST, ORG_CODE_, ORG_CODE_LIST, ORG_NAME_, ORG_NAME_LIST, ORG_TYPE_, ORG_TYPE_LIST, ORG_CATEGORY_, ORG_CATEGORY_LIST, ORG_TAG_, ORG_EXT_ATTR_1_, ORG_EXT_ATTR_1_LIST, ORG_EXT_ATTR_2_, ORG_EXT_ATTR_2_LIST, ORG_EXT_ATTR_3_,
                ORG_EXT_ATTR_3_LIST, ORG_EXT_ATTR_4_, ORG_EXT_ATTR_4_LIST, ORG_EXT_ATTR_5_, ORG_EXT_ATTR_5_LIST, ORG_EXT_ATTR_6_, ORG_EXT_ATTR_6_LIST, ORG_EXT_ATTR_7_, ORG_EXT_ATTR_7_LIST, ORG_EXT_ATTR_8_, ORG_EXT_ATTR_8_LIST, ORG_STATUS_, ORG_STATUS_LIST, posiEmpTagUnion, empTagUnion, posiTagUnion, dutyTagUnion, orgTagUnion, withinOrgId, orgRootOnly, OPERATOR_ID_, OPERATOR_NAME_);// 根据查询条件组装总数查询SQL语句
        String sql = odSqlCriteria.getSql();
        Map<String, Object> paramMap = odSqlCriteria.getParamMap();

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    private OdSqlCriteria buildSqlCriteriaPosiEmp(boolean count, String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_EMP_ID_, List<String> POSI_EMP_ID_LIST, String MAIN_, List<String> MAIN_LIST, String POSI_EMP_CATEGORY_, List<String> POSI_EMP_CATEGORY_LIST, String POSI_EMP_TAG_, String POSI_EMP_EXT_ATTR_1_, List<String> POSI_EMP_EXT_ATTR_1_LIST, String POSI_EMP_EXT_ATTR_2_, List<String> POSI_EMP_EXT_ATTR_2_LIST, String POSI_EMP_EXT_ATTR_3_, List<String> POSI_EMP_EXT_ATTR_3_LIST, String POSI_EMP_EXT_ATTR_4_, List<String> POSI_EMP_EXT_ATTR_4_LIST, String POSI_EMP_EXT_ATTR_5_, List<String> POSI_EMP_EXT_ATTR_5_LIST, String POSI_EMP_EXT_ATTR_6_, List<String> POSI_EMP_EXT_ATTR_6_LIST, String POSI_EMP_EXT_ATTR_7_, List<String> POSI_EMP_EXT_ATTR_7_LIST, String POSI_EMP_EXT_ATTR_8_,
            List<String> POSI_EMP_EXT_ATTR_8_LIST, String POSI_EMP_STATUS_, List<String> POSI_EMP_STATUS_LIST, String EMP_ID_, List<String> EMP_ID_LIST, String EMP_CODE_, List<String> EMP_CODE_LIST, String EMP_NAME_, List<String> EMP_NAME_LIST, String EMP_CATEGORY_, List<String> EMP_CATEGORY_LIST, String EMP_TAG_, String EMP_EXT_ATTR_1_, List<String> EMP_EXT_ATTR_1_LIST, String EMP_EXT_ATTR_2_, List<String> EMP_EXT_ATTR_2_LIST, String EMP_EXT_ATTR_3_, List<String> EMP_EXT_ATTR_3_LIST, String EMP_EXT_ATTR_4_, List<String> EMP_EXT_ATTR_4_LIST, String EMP_EXT_ATTR_5_, List<String> EMP_EXT_ATTR_5_LIST, String EMP_EXT_ATTR_6_, List<String> EMP_EXT_ATTR_6_LIST, String EMP_EXT_ATTR_7_, List<String> EMP_EXT_ATTR_7_LIST, String EMP_EXT_ATTR_8_, List<String> EMP_EXT_ATTR_8_LIST, String EMP_STATUS_,
            List<String> EMP_STATUS_LIST, String POSI_ID_, List<String> POSI_ID_LIST, String POSI_CODE_, List<String> POSI_CODE_LIST, String POSI_NAME_, List<String> POSI_NAME_LIST, String ORG_LEADER_TYPE_, List<String> ORG_LEADER_TYPE_LIST, String POSI_CATEGORY_, List<String> POSI_CATEGORY_LIST, String POSI_TAG_, String POSI_EXT_ATTR_1_, List<String> POSI_EXT_ATTR_1_LIST, String POSI_EXT_ATTR_2_, List<String> POSI_EXT_ATTR_2_LIST, String POSI_EXT_ATTR_3_, List<String> POSI_EXT_ATTR_3_LIST, String POSI_EXT_ATTR_4_, List<String> POSI_EXT_ATTR_4_LIST, String POSI_EXT_ATTR_5_, List<String> POSI_EXT_ATTR_5_LIST, String POSI_EXT_ATTR_6_, List<String> POSI_EXT_ATTR_6_LIST, String POSI_EXT_ATTR_7_, List<String> POSI_EXT_ATTR_7_LIST, String POSI_EXT_ATTR_8_, List<String> POSI_EXT_ATTR_8_LIST,
            String POSI_STATUS_, List<String> POSI_STATUS_LIST, String DUTY_ID_, List<String> DUTY_ID_LIST, String DUTY_CODE_, List<String> DUTY_CODE_LIST, String DUTY_NAME_, List<String> DUTY_NAME_LIST, String DUTY_CATEGORY_, List<String> DUTY_CATEGORY_LIST, String DUTY_TAG_, String DUTY_EXT_ATTR_1_, List<String> DUTY_EXT_ATTR_1_LIST, String DUTY_EXT_ATTR_2_, List<String> DUTY_EXT_ATTR_2_LIST, String DUTY_EXT_ATTR_3_, List<String> DUTY_EXT_ATTR_3_LIST, String DUTY_EXT_ATTR_4_, List<String> DUTY_EXT_ATTR_4_LIST, String DUTY_EXT_ATTR_5_, List<String> DUTY_EXT_ATTR_5_LIST, String DUTY_EXT_ATTR_6_, List<String> DUTY_EXT_ATTR_6_LIST, String DUTY_EXT_ATTR_7_, List<String> DUTY_EXT_ATTR_7_LIST, String DUTY_EXT_ATTR_8_, List<String> DUTY_EXT_ATTR_8_LIST, String DUTY_STATUS_,
            List<String> DUTY_STATUS_LIST, String ORG_ID_, List<String> ORG_ID_LIST, String PARENT_ORG_ID_, List<String> PARENT_ORG_ID_LIST, String ORG_CODE_, List<String> ORG_CODE_LIST, String ORG_NAME_, List<String> ORG_NAME_LIST, String ORG_TYPE_, List<String> ORG_TYPE_LIST, String ORG_CATEGORY_, List<String> ORG_CATEGORY_LIST, String ORG_TAG_, String ORG_EXT_ATTR_1_, List<String> ORG_EXT_ATTR_1_LIST, String ORG_EXT_ATTR_2_, List<String> ORG_EXT_ATTR_2_LIST, String ORG_EXT_ATTR_3_, List<String> ORG_EXT_ATTR_3_LIST, String ORG_EXT_ATTR_4_, List<String> ORG_EXT_ATTR_4_LIST, String ORG_EXT_ATTR_5_, List<String> ORG_EXT_ATTR_5_LIST, String ORG_EXT_ATTR_6_, List<String> ORG_EXT_ATTR_6_LIST, String ORG_EXT_ATTR_7_, List<String> ORG_EXT_ATTR_7_LIST, String ORG_EXT_ATTR_8_,
            List<String> ORG_EXT_ATTR_8_LIST, String ORG_STATUS_, List<String> ORG_STATUS_LIST, Boolean posiEmpTagUnion, Boolean empTagUnion, Boolean posiTagUnion, Boolean dutyTagUnion, Boolean orgTagUnion, String withinOrgId, Boolean orgRootOnly, String OPERATOR_ID_, String OPERATOR_NAME_) {// 组装查询SQL语句
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
        if (POSI_EMP_ID_LIST != null && !POSI_EMP_ID_LIST.isEmpty()) {
            sql += " and POSI_EMP_ID_ in (:POSI_EMP_ID_LIST)";
            paramMap.put("POSI_EMP_ID_LIST", POSI_EMP_ID_LIST);
        }
        if (StringUtils.isNotEmpty(MAIN_)) {
            sql += " and MAIN_ = :MAIN_";
            paramMap.put("MAIN_", MAIN_);
        }
        if (MAIN_LIST != null && !MAIN_LIST.isEmpty()) {
            sql += " and MAIN_ in (:MAIN_LIST)";
            paramMap.put("MAIN_LIST", MAIN_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_EMP_CATEGORY_)) {
            sql += " and POSI_EMP_CATEGORY_ = :POSI_EMP_CATEGORY_";
            paramMap.put("POSI_EMP_CATEGORY_", POSI_EMP_CATEGORY_);
        }
        if (POSI_EMP_CATEGORY_LIST != null && !POSI_EMP_CATEGORY_LIST.isEmpty()) {
            sql += " and POSI_EMP_CATEGORY_ in (:POSI_EMP_CATEGORY_LIST)";
            paramMap.put("POSI_EMP_CATEGORY_LIST", POSI_EMP_CATEGORY_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_EMP_TAG_)) {
            List<String> tagList = omTagService.splitTag(POSI_EMP_TAG_);
            if (!tagList.isEmpty()) {
                if (posiEmpTagUnion != null && posiEmpTagUnion.equals(false)) {
                    sql += " and POSI_EMP_ID_ in (select POSI_EMP_ID_ from (select OBJ_ID_ as POSI_EMP_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'POSI_EMP' and TAG_ in (:POSI_EMP_TAG_LIST)) T group by POSI_EMP_ID_ having count(*) >= 1)";
                    paramMap.put("POSI_EMP_TAG_LIST", tagList);
                }
                else {
                    sql += " and POSI_EMP_ID_ in (select POSI_EMP_ID_ from (select OBJ_ID_ as POSI_EMP_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'POSI_EMP' and TAG_ in (:POSI_EMP_TAG_LIST)) T group by POSI_EMP_ID_ having count(*) >= :posiEmpTagCount)";
                    paramMap.put("POSI_EMP_TAG_LIST", tagList);
                    paramMap.put("posiEmpTagCount", tagList.size());
                }
            }
        }
        if (StringUtils.isNotEmpty(POSI_EMP_EXT_ATTR_1_)) {
            sql += " and POSI_EMP_EXT_ATTR_1_ = :POSI_EMP_EXT_ATTR_1_";
            paramMap.put("POSI_EMP_EXT_ATTR_1_", POSI_EMP_EXT_ATTR_1_);
        }
        if (POSI_EMP_EXT_ATTR_1_LIST != null && !POSI_EMP_EXT_ATTR_1_LIST.isEmpty()) {
            sql += " and POSI_EMP_EXT_ATTR_1_ in (:POSI_EMP_EXT_ATTR_1_LIST)";
            paramMap.put("POSI_EMP_EXT_ATTR_1_LIST", POSI_EMP_EXT_ATTR_1_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_EMP_EXT_ATTR_2_)) {
            sql += " and POSI_EMP_EXT_ATTR_2_ = :POSI_EMP_EXT_ATTR_2_";
            paramMap.put("POSI_EMP_EXT_ATTR_2_", POSI_EMP_EXT_ATTR_2_);
        }
        if (POSI_EMP_EXT_ATTR_2_LIST != null && !POSI_EMP_EXT_ATTR_2_LIST.isEmpty()) {
            sql += " and POSI_EMP_EXT_ATTR_2_ in (:POSI_EMP_EXT_ATTR_2_LIST)";
            paramMap.put("POSI_EMP_EXT_ATTR_2_LIST", POSI_EMP_EXT_ATTR_2_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_EMP_EXT_ATTR_3_)) {
            sql += " and POSI_EMP_EXT_ATTR_3_ = :POSI_EMP_EXT_ATTR_3_";
            paramMap.put("POSI_EMP_EXT_ATTR_3_", POSI_EMP_EXT_ATTR_3_);
        }
        if (POSI_EMP_EXT_ATTR_3_LIST != null && !POSI_EMP_EXT_ATTR_3_LIST.isEmpty()) {
            sql += " and POSI_EMP_EXT_ATTR_3_ in (:POSI_EMP_EXT_ATTR_3_LIST)";
            paramMap.put("POSI_EMP_EXT_ATTR_3_LIST", POSI_EMP_EXT_ATTR_3_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_EMP_EXT_ATTR_4_)) {
            sql += " and POSI_EMP_EXT_ATTR_4_ = :POSI_EMP_EXT_ATTR_4_";
            paramMap.put("POSI_EMP_EXT_ATTR_4_", POSI_EMP_EXT_ATTR_4_);
        }
        if (POSI_EMP_EXT_ATTR_4_LIST != null && !POSI_EMP_EXT_ATTR_4_LIST.isEmpty()) {
            sql += " and POSI_EMP_EXT_ATTR_4_ in (:POSI_EMP_EXT_ATTR_4_LIST)";
            paramMap.put("POSI_EMP_EXT_ATTR_4_LIST", POSI_EMP_EXT_ATTR_4_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_EMP_EXT_ATTR_5_)) {
            sql += " and POSI_EMP_EXT_ATTR_5_ = :POSI_EMP_EXT_ATTR_5_";
            paramMap.put("POSI_EMP_EXT_ATTR_5_", POSI_EMP_EXT_ATTR_5_);
        }
        if (POSI_EMP_EXT_ATTR_5_LIST != null && !POSI_EMP_EXT_ATTR_5_LIST.isEmpty()) {
            sql += " and POSI_EMP_EXT_ATTR_5_ in (:POSI_EMP_EXT_ATTR_5_LIST)";
            paramMap.put("POSI_EMP_EXT_ATTR_5_LIST", POSI_EMP_EXT_ATTR_5_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_EMP_EXT_ATTR_6_)) {
            sql += " and POSI_EMP_EXT_ATTR_6_ = :POSI_EMP_EXT_ATTR_6_";
            paramMap.put("POSI_EMP_EXT_ATTR_6_", POSI_EMP_EXT_ATTR_6_);
        }
        if (POSI_EMP_EXT_ATTR_6_LIST != null && !POSI_EMP_EXT_ATTR_6_LIST.isEmpty()) {
            sql += " and POSI_EMP_EXT_ATTR_6_ in (:POSI_EMP_EXT_ATTR_6_LIST)";
            paramMap.put("POSI_EMP_EXT_ATTR_6_LIST", POSI_EMP_EXT_ATTR_6_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_EMP_EXT_ATTR_7_)) {
            sql += " and POSI_EMP_EXT_ATTR_7_ = :POSI_EMP_EXT_ATTR_7_";
            paramMap.put("POSI_EMP_EXT_ATTR_7_", POSI_EMP_EXT_ATTR_7_);
        }
        if (POSI_EMP_EXT_ATTR_7_LIST != null && !POSI_EMP_EXT_ATTR_7_LIST.isEmpty()) {
            sql += " and POSI_EMP_EXT_ATTR_7_ in (:POSI_EMP_EXT_ATTR_7_LIST)";
            paramMap.put("POSI_EMP_EXT_ATTR_7_LIST", POSI_EMP_EXT_ATTR_7_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_EMP_EXT_ATTR_8_)) {
            sql += " and POSI_EMP_EXT_ATTR_8_ = :POSI_EMP_EXT_ATTR_8_";
            paramMap.put("POSI_EMP_EXT_ATTR_8_", POSI_EMP_EXT_ATTR_8_);
        }
        if (POSI_EMP_EXT_ATTR_8_LIST != null && !POSI_EMP_EXT_ATTR_8_LIST.isEmpty()) {
            sql += " and POSI_EMP_EXT_ATTR_8_ in (:POSI_EMP_EXT_ATTR_8_LIST)";
            paramMap.put("POSI_EMP_EXT_ATTR_8_LIST", POSI_EMP_EXT_ATTR_8_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_EMP_STATUS_)) {
            sql += " and POSI_EMP_STATUS_ = :POSI_EMP_STATUS_";
            paramMap.put("POSI_EMP_STATUS_", POSI_EMP_STATUS_);
        }
        if (POSI_EMP_STATUS_LIST != null && !POSI_EMP_STATUS_LIST.isEmpty()) {
            sql += " and POSI_EMP_STATUS_ in (:POSI_EMP_STATUS_LIST)";
            paramMap.put("POSI_EMP_STATUS_LIST", POSI_EMP_STATUS_LIST);
        }

        if (StringUtils.isNotEmpty(EMP_ID_)) {
            sql += " and EMP_ID_ = :EMP_ID_";
            paramMap.put("EMP_ID_", EMP_ID_);
        }
        if (EMP_ID_LIST != null && !EMP_ID_LIST.isEmpty()) {
            sql += " and EMP_ID_ in (:EMP_ID_LIST)";
            paramMap.put("EMP_ID_LIST", EMP_ID_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_CODE_)) {
            sql += " and EMP_CODE_ = :EMP_CODE_";
            paramMap.put("EMP_CODE_", EMP_CODE_);
        }
        if (EMP_CODE_LIST != null && !EMP_CODE_LIST.isEmpty()) {
            sql += " and EMP_CODE_ in (:EMP_CODE_LIST)";
            paramMap.put("EMP_CODE_LIST", EMP_CODE_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_NAME_)) {
            sql += " and EMP_NAME_ like '%' || :EMP_NAME_ || '%'";
            paramMap.put("EMP_NAME_", EMP_NAME_);
        }
        if (EMP_NAME_LIST != null && !EMP_NAME_LIST.isEmpty()) {
            sql += " and EMP_NAME_ in (:EMP_NAME_LIST)";
            paramMap.put("EMP_NAME_LIST", EMP_NAME_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_CATEGORY_)) {
            sql += " and EMP_CATEGORY_ = :EMP_CATEGORY_";
            paramMap.put("EMP_CATEGORY_", EMP_CATEGORY_);
        }
        if (EMP_CATEGORY_LIST != null && !EMP_CATEGORY_LIST.isEmpty()) {
            sql += " and EMP_CATEGORY_ in (:EMP_CATEGORY_LIST)";
            paramMap.put("EMP_CATEGORY_LIST", EMP_CATEGORY_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_TAG_)) {
            List<String> tagList = omTagService.splitTag(EMP_TAG_);
            if (!tagList.isEmpty()) {
                if (empTagUnion != null && empTagUnion.equals(false)) {
                    sql += " and EMP_ID_ in (select EMP_ID_ from (select OBJ_ID_ as EMP_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'EMP' and TAG_ in (:EMP_TAG_LIST)) T group by EMP_ID_ having count(*) >= 1)";
                    paramMap.put("EMP_TAG_LIST", tagList);
                }
                else {
                    sql += " and EMP_ID_ in (select EMP_ID_ from (select OBJ_ID_ as EMP_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'EMP' and TAG_ in (:EMP_TAG_LIST)) T group by EMP_ID_ having count(*) >= :empTagCount)";
                    paramMap.put("EMP_TAG_LIST", tagList);
                    paramMap.put("empTagCount", tagList.size());
                }
            }
        }
        if (StringUtils.isNotEmpty(EMP_EXT_ATTR_1_)) {
            sql += " and EMP_EXT_ATTR_1_ = :EMP_EXT_ATTR_1_";
            paramMap.put("EMP_EXT_ATTR_1_", EMP_EXT_ATTR_1_);
        }
        if (EMP_EXT_ATTR_1_LIST != null && !EMP_EXT_ATTR_1_LIST.isEmpty()) {
            sql += " and EMP_EXT_ATTR_1_ in (:EMP_EXT_ATTR_1_LIST)";
            paramMap.put("EMP_EXT_ATTR_1_LIST", EMP_EXT_ATTR_1_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_EXT_ATTR_2_)) {
            sql += " and EMP_EXT_ATTR_2_ = :EMP_EXT_ATTR_2_";
            paramMap.put("EMP_EXT_ATTR_2_", EMP_EXT_ATTR_2_);
        }
        if (EMP_EXT_ATTR_2_LIST != null && !EMP_EXT_ATTR_2_LIST.isEmpty()) {
            sql += " and EMP_EXT_ATTR_2_ in (:EMP_EXT_ATTR_2_LIST)";
            paramMap.put("EMP_EXT_ATTR_2_LIST", EMP_EXT_ATTR_2_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_EXT_ATTR_3_)) {
            sql += " and EMP_EXT_ATTR_3_ = :EMP_EXT_ATTR_3_";
            paramMap.put("EMP_EXT_ATTR_3_", EMP_EXT_ATTR_3_);
        }
        if (EMP_EXT_ATTR_3_LIST != null && !EMP_EXT_ATTR_3_LIST.isEmpty()) {
            sql += " and EMP_EXT_ATTR_3_ in (:EMP_EXT_ATTR_3_LIST)";
            paramMap.put("EMP_EXT_ATTR_3_LIST", EMP_EXT_ATTR_3_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_EXT_ATTR_4_)) {
            sql += " and EMP_EXT_ATTR_4_ = :EMP_EXT_ATTR_4_";
            paramMap.put("EMP_EXT_ATTR_4_", EMP_EXT_ATTR_4_);
        }
        if (EMP_EXT_ATTR_4_LIST != null && !EMP_EXT_ATTR_4_LIST.isEmpty()) {
            sql += " and EMP_EXT_ATTR_4_ in (:EMP_EXT_ATTR_4_LIST)";
            paramMap.put("EMP_EXT_ATTR_4_LIST", EMP_EXT_ATTR_4_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_EXT_ATTR_5_)) {
            sql += " and EMP_EXT_ATTR_5_ = :EMP_EXT_ATTR_5_";
            paramMap.put("EMP_EXT_ATTR_5_", EMP_EXT_ATTR_5_);
        }
        if (EMP_EXT_ATTR_5_LIST != null && !EMP_EXT_ATTR_5_LIST.isEmpty()) {
            sql += " and EMP_EXT_ATTR_5_ in (:EMP_EXT_ATTR_5_LIST)";
            paramMap.put("EMP_EXT_ATTR_5_LIST", EMP_EXT_ATTR_5_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_EXT_ATTR_6_)) {
            sql += " and EMP_EXT_ATTR_6_ = :EMP_EXT_ATTR_6_";
            paramMap.put("EMP_EXT_ATTR_6_", EMP_EXT_ATTR_6_);
        }
        if (EMP_EXT_ATTR_6_LIST != null && !EMP_EXT_ATTR_6_LIST.isEmpty()) {
            sql += " and EMP_EXT_ATTR_6_ in (:EMP_EXT_ATTR_6_LIST)";
            paramMap.put("EMP_EXT_ATTR_6_LIST", EMP_EXT_ATTR_6_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_EXT_ATTR_7_)) {
            sql += " and EMP_EXT_ATTR_7_ = :EMP_EXT_ATTR_7_";
            paramMap.put("EMP_EXT_ATTR_7_", EMP_EXT_ATTR_7_);
        }
        if (EMP_EXT_ATTR_7_LIST != null && !EMP_EXT_ATTR_7_LIST.isEmpty()) {
            sql += " and EMP_EXT_ATTR_7_ in (:EMP_EXT_ATTR_7_LIST)";
            paramMap.put("EMP_EXT_ATTR_7_LIST", EMP_EXT_ATTR_7_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_EXT_ATTR_8_)) {
            sql += " and EMP_EXT_ATTR_8_ = :EMP_EXT_ATTR_8_";
            paramMap.put("EMP_EXT_ATTR_8_", EMP_EXT_ATTR_8_);
        }
        if (EMP_EXT_ATTR_8_LIST != null && !EMP_EXT_ATTR_8_LIST.isEmpty()) {
            sql += " and EMP_EXT_ATTR_8_ in (:EMP_EXT_ATTR_8_LIST)";
            paramMap.put("EMP_EXT_ATTR_8_LIST", EMP_EXT_ATTR_8_LIST);
        }
        if (StringUtils.isNotEmpty(EMP_STATUS_)) {
            sql += " and EMP_STATUS_ = :EMP_STATUS_";
            paramMap.put("EMP_STATUS_", EMP_STATUS_);
        }
        if (EMP_STATUS_LIST != null && !EMP_STATUS_LIST.isEmpty()) {
            sql += " and EMP_STATUS_ in (:EMP_STATUS_LIST)";
            paramMap.put("EMP_STATUS_LIST", EMP_STATUS_LIST);
        }

        if (StringUtils.isNotEmpty(POSI_ID_)) {
            sql += " and POSI_ID_ = :POSI_ID_";
            paramMap.put("POSI_ID_", POSI_ID_);
        }
        if (POSI_ID_LIST != null && !POSI_ID_LIST.isEmpty()) {
            sql += " and POSI_ID_ in (:POSI_ID_LIST)";
            paramMap.put("POSI_ID_LIST", POSI_ID_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_CODE_)) {
            sql += " and POSI_CODE_ = :POSI_CODE_";
            paramMap.put("POSI_CODE_", POSI_CODE_);
        }
        if (POSI_CODE_LIST != null && !POSI_CODE_LIST.isEmpty()) {
            sql += " and POSI_CODE_ in (:POSI_CODE_LIST)";
            paramMap.put("POSI_CODE_LIST", POSI_CODE_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_NAME_)) {
            sql += " and POSI_NAME_ like '%' || :POSI_NAME_ || '%'";
            paramMap.put("POSI_NAME_", POSI_NAME_);
        }
        if (POSI_NAME_LIST != null && !POSI_NAME_LIST.isEmpty()) {
            sql += " and POSI_NAME_ in (:POSI_NAME_LIST)";
            paramMap.put("POSI_NAME_LIST", POSI_NAME_LIST);
        }
        if (StringUtils.isNotEmpty(ORG_LEADER_TYPE_)) {
            sql += " and ORG_LEADER_TYPE_ = :ORG_LEADER_TYPE_";
            paramMap.put("ORG_LEADER_TYPE_", ORG_LEADER_TYPE_);
        }
        if (ORG_LEADER_TYPE_LIST != null && !ORG_LEADER_TYPE_LIST.isEmpty()) {
            sql += " and ORG_LEADER_TYPE_ in (:ORG_LEADER_TYPE_LIST)";
            paramMap.put("ORG_LEADER_TYPE_LIST", ORG_LEADER_TYPE_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_CATEGORY_)) {
            sql += " and POSI_CATEGORY_ = :POSI_CATEGORY_";
            paramMap.put("POSI_CATEGORY_", POSI_CATEGORY_);
        }
        if (POSI_CATEGORY_LIST != null && !POSI_CATEGORY_LIST.isEmpty()) {
            sql += " and POSI_CATEGORY_ in (:POSI_CATEGORY_LIST)";
            paramMap.put("POSI_CATEGORY_LIST", POSI_CATEGORY_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_TAG_)) {
            List<String> tagList = omTagService.splitTag(POSI_TAG_);
            if (!tagList.isEmpty()) {
                if (posiTagUnion != null && posiTagUnion.equals(false)) {
                    sql += " and POSI_ID_ in (select POSI_ID_ from (select OBJ_ID_ as POSI_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'POSI' and TAG_ in (:POSI_TAG_LIST)) T group by POSI_ID_ having count(*) >= 1)";
                    paramMap.put("POSI_TAG_LIST", tagList);
                }
                else {
                    sql += " and POSI_ID_ in (select POSI_ID_ from (select OBJ_ID_ as POSI_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'POSI' and TAG_ in (:POSI_TAG_LIST)) T group by POSI_ID_ having count(*) >= :posiTagCount)";
                    paramMap.put("POSI_TAG_LIST", tagList);
                    paramMap.put("posiTagCount", tagList.size());
                }
            }
        }
        if (StringUtils.isNotEmpty(POSI_EXT_ATTR_1_)) {
            sql += " and POSI_EXT_ATTR_1_ = :POSI_EXT_ATTR_1_";
            paramMap.put("POSI_EXT_ATTR_1_", POSI_EXT_ATTR_1_);
        }
        if (POSI_EXT_ATTR_1_LIST != null && !POSI_EXT_ATTR_1_LIST.isEmpty()) {
            sql += " and POSI_EXT_ATTR_1_ in (:POSI_EXT_ATTR_1_LIST)";
            paramMap.put("POSI_EXT_ATTR_1_LIST", POSI_EXT_ATTR_1_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_EXT_ATTR_2_)) {
            sql += " and POSI_EXT_ATTR_2_ = :POSI_EXT_ATTR_2_";
            paramMap.put("POSI_EXT_ATTR_2_", POSI_EXT_ATTR_2_);
        }
        if (POSI_EXT_ATTR_2_LIST != null && !POSI_EXT_ATTR_2_LIST.isEmpty()) {
            sql += " and POSI_EXT_ATTR_2_ in (:POSI_EXT_ATTR_2_LIST)";
            paramMap.put("POSI_EXT_ATTR_2_LIST", POSI_EXT_ATTR_2_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_EXT_ATTR_3_)) {
            sql += " and POSI_EXT_ATTR_3_ = :POSI_EXT_ATTR_3_";
            paramMap.put("POSI_EXT_ATTR_3_", POSI_EXT_ATTR_3_);
        }
        if (POSI_EXT_ATTR_3_LIST != null && !POSI_EXT_ATTR_3_LIST.isEmpty()) {
            sql += " and POSI_EXT_ATTR_3_ in (:POSI_EXT_ATTR_3_LIST)";
            paramMap.put("POSI_EXT_ATTR_3_LIST", POSI_EXT_ATTR_3_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_EXT_ATTR_4_)) {
            sql += " and POSI_EXT_ATTR_4_ = :POSI_EXT_ATTR_4_";
            paramMap.put("POSI_EXT_ATTR_4_", POSI_EXT_ATTR_4_);
        }
        if (POSI_EXT_ATTR_4_LIST != null && !POSI_EXT_ATTR_4_LIST.isEmpty()) {
            sql += " and POSI_EXT_ATTR_4_ in (:POSI_EXT_ATTR_4_LIST)";
            paramMap.put("POSI_EXT_ATTR_4_LIST", POSI_EXT_ATTR_4_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_EXT_ATTR_5_)) {
            sql += " and POSI_EXT_ATTR_5_ = :POSI_EXT_ATTR_5_";
            paramMap.put("POSI_EXT_ATTR_5_", POSI_EXT_ATTR_5_);
        }
        if (POSI_EXT_ATTR_5_LIST != null && !POSI_EXT_ATTR_5_LIST.isEmpty()) {
            sql += " and POSI_EXT_ATTR_5_ in (:POSI_EXT_ATTR_5_LIST)";
            paramMap.put("POSI_EXT_ATTR_5_LIST", POSI_EXT_ATTR_5_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_EXT_ATTR_6_)) {
            sql += " and POSI_EXT_ATTR_6_ = :POSI_EXT_ATTR_6_";
            paramMap.put("POSI_EXT_ATTR_6_", POSI_EXT_ATTR_6_);
        }
        if (POSI_EXT_ATTR_6_LIST != null && !POSI_EXT_ATTR_6_LIST.isEmpty()) {
            sql += " and POSI_EXT_ATTR_6_ in (:POSI_EXT_ATTR_6_LIST)";
            paramMap.put("POSI_EXT_ATTR_6_LIST", POSI_EXT_ATTR_6_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_EXT_ATTR_7_)) {
            sql += " and POSI_EXT_ATTR_7_ = :POSI_EXT_ATTR_7_";
            paramMap.put("POSI_EXT_ATTR_7_", POSI_EXT_ATTR_7_);
        }
        if (POSI_EXT_ATTR_7_LIST != null && !POSI_EXT_ATTR_7_LIST.isEmpty()) {
            sql += " and POSI_EXT_ATTR_7_ in (:POSI_EXT_ATTR_7_LIST)";
            paramMap.put("POSI_EXT_ATTR_7_LIST", POSI_EXT_ATTR_7_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_EXT_ATTR_8_)) {
            sql += " and POSI_EXT_ATTR_8_ = :POSI_EXT_ATTR_8_";
            paramMap.put("POSI_EXT_ATTR_8_", POSI_EXT_ATTR_8_);
        }
        if (POSI_EXT_ATTR_8_LIST != null && !POSI_EXT_ATTR_8_LIST.isEmpty()) {
            sql += " and POSI_EXT_ATTR_8_ in (:POSI_EXT_ATTR_8_LIST)";
            paramMap.put("POSI_EXT_ATTR_8_LIST", POSI_EXT_ATTR_8_LIST);
        }
        if (StringUtils.isNotEmpty(POSI_STATUS_)) {
            sql += " and POSI_STATUS_ = :POSI_STATUS_";
            paramMap.put("POSI_STATUS_", POSI_STATUS_);
        }
        if (POSI_STATUS_LIST != null && !POSI_STATUS_LIST.isEmpty()) {
            sql += " and POSI_STATUS_ in (:POSI_STATUS_LIST)";
            paramMap.put("POSI_STATUS_LIST", POSI_STATUS_LIST);
        }

        if (StringUtils.isNotEmpty(DUTY_ID_)) {
            sql += " and DUTY_ID_ = :DUTY_ID_";
            paramMap.put("DUTY_ID_", DUTY_ID_);
        }
        if (DUTY_ID_LIST != null && !DUTY_ID_LIST.isEmpty()) {
            sql += " and DUTY_ID_ in (:DUTY_ID_LIST)";
            paramMap.put("DUTY_ID_LIST", DUTY_ID_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_CODE_)) {
            sql += " and DUTY_CODE_ = :DUTY_CODE_";
            paramMap.put("DUTY_CODE_", DUTY_CODE_);
        }
        if (DUTY_CODE_LIST != null && !DUTY_CODE_LIST.isEmpty()) {
            sql += " and DUTY_CODE_ in (:DUTY_CODE_LIST)";
            paramMap.put("DUTY_CODE_LIST", DUTY_CODE_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_NAME_)) {
            sql += " and DUTY_NAME_ like '%' || :DUTY_NAME_ || '%'";
            paramMap.put("DUTY_NAME_", DUTY_NAME_);
        }
        if (DUTY_NAME_LIST != null && !DUTY_NAME_LIST.isEmpty()) {
            sql += " and DUTY_NAME_ in (:DUTY_NAME_LIST)";
            paramMap.put("DUTY_NAME_LIST", DUTY_NAME_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_CATEGORY_)) {
            sql += " and DUTY_CATEGORY_ = :DUTY_CATEGORY_";
            paramMap.put("DUTY_CATEGORY_", DUTY_CATEGORY_);
        }
        if (DUTY_CATEGORY_LIST != null && !DUTY_CATEGORY_LIST.isEmpty()) {
            sql += " and DUTY_CATEGORY_ in (:DUTY_CATEGORY_LIST)";
            paramMap.put("DUTY_CATEGORY_LIST", DUTY_CATEGORY_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_TAG_)) {
            List<String> tagList = omTagService.splitTag(DUTY_TAG_);
            if (!tagList.isEmpty()) {
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
        if (DUTY_EXT_ATTR_1_LIST != null && !DUTY_EXT_ATTR_1_LIST.isEmpty()) {
            sql += " and DUTY_EXT_ATTR_1_ in (:DUTY_EXT_ATTR_1_LIST)";
            paramMap.put("DUTY_EXT_ATTR_1_LIST", DUTY_EXT_ATTR_1_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_EXT_ATTR_2_)) {
            sql += " and DUTY_EXT_ATTR_2_ = :DUTY_EXT_ATTR_2_";
            paramMap.put("DUTY_EXT_ATTR_2_", DUTY_EXT_ATTR_2_);
        }
        if (DUTY_EXT_ATTR_2_LIST != null && !DUTY_EXT_ATTR_2_LIST.isEmpty()) {
            sql += " and DUTY_EXT_ATTR_2_ in (:DUTY_EXT_ATTR_2_LIST)";
            paramMap.put("DUTY_EXT_ATTR_2_LIST", DUTY_EXT_ATTR_2_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_EXT_ATTR_3_)) {
            sql += " and DUTY_EXT_ATTR_3_ = :DUTY_EXT_ATTR_3_";
            paramMap.put("DUTY_EXT_ATTR_3_", DUTY_EXT_ATTR_3_);
        }
        if (DUTY_EXT_ATTR_3_LIST != null && !DUTY_EXT_ATTR_3_LIST.isEmpty()) {
            sql += " and DUTY_EXT_ATTR_3_ in (:DUTY_EXT_ATTR_3_LIST)";
            paramMap.put("DUTY_EXT_ATTR_3_LIST", DUTY_EXT_ATTR_3_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_EXT_ATTR_4_)) {
            sql += " and DUTY_EXT_ATTR_4_ = :DUTY_EXT_ATTR_4_";
            paramMap.put("DUTY_EXT_ATTR_4_", DUTY_EXT_ATTR_4_);
        }
        if (DUTY_EXT_ATTR_4_LIST != null && !DUTY_EXT_ATTR_4_LIST.isEmpty()) {
            sql += " and DUTY_EXT_ATTR_4_ in (:DUTY_EXT_ATTR_4_LIST)";
            paramMap.put("DUTY_EXT_ATTR_4_LIST", DUTY_EXT_ATTR_4_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_EXT_ATTR_5_)) {
            sql += " and DUTY_EXT_ATTR_5_ = :DUTY_EXT_ATTR_5_";
            paramMap.put("DUTY_EXT_ATTR_5_", DUTY_EXT_ATTR_5_);
        }
        if (DUTY_EXT_ATTR_5_LIST != null && !DUTY_EXT_ATTR_5_LIST.isEmpty()) {
            sql += " and DUTY_EXT_ATTR_5_ in (:DUTY_EXT_ATTR_5_LIST)";
            paramMap.put("DUTY_EXT_ATTR_5_LIST", DUTY_EXT_ATTR_5_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_EXT_ATTR_6_)) {
            sql += " and DUTY_EXT_ATTR_6_ = :DUTY_EXT_ATTR_6_";
            paramMap.put("DUTY_EXT_ATTR_6_", DUTY_EXT_ATTR_6_);
        }
        if (DUTY_EXT_ATTR_6_LIST != null && !DUTY_EXT_ATTR_6_LIST.isEmpty()) {
            sql += " and DUTY_EXT_ATTR_6_ in (:DUTY_EXT_ATTR_6_LIST)";
            paramMap.put("DUTY_EXT_ATTR_6_LIST", DUTY_EXT_ATTR_6_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_EXT_ATTR_7_)) {
            sql += " and DUTY_EXT_ATTR_7_ = :DUTY_EXT_ATTR_7_";
            paramMap.put("DUTY_EXT_ATTR_7_", DUTY_EXT_ATTR_7_);
        }
        if (DUTY_EXT_ATTR_7_LIST != null && !DUTY_EXT_ATTR_7_LIST.isEmpty()) {
            sql += " and DUTY_EXT_ATTR_7_ in (:DUTY_EXT_ATTR_7_LIST)";
            paramMap.put("DUTY_EXT_ATTR_7_LIST", DUTY_EXT_ATTR_7_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_EXT_ATTR_8_)) {
            sql += " and DUTY_EXT_ATTR_8_ = :DUTY_EXT_ATTR_8_";
            paramMap.put("DUTY_EXT_ATTR_8_", DUTY_EXT_ATTR_8_);
        }
        if (DUTY_EXT_ATTR_8_LIST != null && !DUTY_EXT_ATTR_8_LIST.isEmpty()) {
            sql += " and DUTY_EXT_ATTR_8_ in (:DUTY_EXT_ATTR_8_LIST)";
            paramMap.put("DUTY_EXT_ATTR_8_LIST", DUTY_EXT_ATTR_8_LIST);
        }
        if (StringUtils.isNotEmpty(DUTY_STATUS_)) {
            sql += " and DUTY_STATUS_ = :DUTY_STATUS_";
            paramMap.put("DUTY_STATUS_", DUTY_STATUS_);
        }
        if (DUTY_STATUS_LIST != null && !DUTY_STATUS_LIST.isEmpty()) {
            sql += " and DUTY_STATUS_ in (:DUTY_STATUS_LIST)";
            paramMap.put("DUTY_STATUS_LIST", DUTY_STATUS_LIST);
        }

        if (StringUtils.isNotEmpty(ORG_ID_)) {
            sql += " and ORG_ID_ = :ORG_ID_";
            paramMap.put("ORG_ID_", ORG_ID_);
        }
        if (ORG_ID_LIST != null && !ORG_ID_LIST.isEmpty()) {
            sql += " and ORG_ID_ in (:ORG_ID_LIST)";
            paramMap.put("ORG_ID_LIST", ORG_ID_LIST);
        }
        if (StringUtils.isNotEmpty(PARENT_ORG_ID_)) {
            sql += " and PARENT_ORG_ID_ = :PARENT_ORG_ID_";
            paramMap.put("PARENT_ORG_ID_", PARENT_ORG_ID_);
        }
        if (PARENT_ORG_ID_LIST != null && !PARENT_ORG_ID_LIST.isEmpty()) {
            sql += " and PARENT_ORG_ID_ in (:PARENT_ORG_ID_LIST)";
            paramMap.put("PARENT_ORG_ID_LIST", PARENT_ORG_ID_LIST);
        }
        if (StringUtils.isNotEmpty(ORG_CODE_)) {
            sql += " and ORG_CODE_ = :ORG_CODE_";
            paramMap.put("ORG_CODE_", ORG_CODE_);
        }
        if (ORG_CODE_LIST != null && !ORG_CODE_LIST.isEmpty()) {
            sql += " and ORG_CODE_ in (:ORG_CODE_LIST)";
            paramMap.put("ORG_CODE_LIST", ORG_CODE_LIST);
        }
        if (StringUtils.isNotEmpty(ORG_NAME_)) {
            sql += " and ORG_NAME_ like '%' || :ORG_NAME_ || '%'";
            paramMap.put("ORG_NAME_", ORG_NAME_);
        }
        if (ORG_NAME_LIST != null && !ORG_NAME_LIST.isEmpty()) {
            sql += " and ORG_NAME_ in (:ORG_NAME_LIST)";
            paramMap.put("ORG_NAME_LIST", ORG_NAME_LIST);
        }
        if (StringUtils.isNotEmpty(ORG_TYPE_)) {
            sql += " and ORG_TYPE_ = :ORG_TYPE_";
            paramMap.put("ORG_TYPE_", ORG_TYPE_);
        }
        if (ORG_TYPE_LIST != null && !ORG_TYPE_LIST.isEmpty()) {
            sql += " and ORG_TYPE_ in (:ORG_TYPE_LIST)";
            paramMap.put("ORG_TYPE_LIST", ORG_TYPE_LIST);
        }
        if (StringUtils.isNotEmpty(ORG_CATEGORY_)) {
            sql += " and ORG_CATEGORY_ = :ORG_CATEGORY_";
            paramMap.put("ORG_CATEGORY_", ORG_CATEGORY_);
        }
        if (ORG_CATEGORY_LIST != null && !ORG_CATEGORY_LIST.isEmpty()) {
            sql += " and ORG_CATEGORY_ in (:ORG_CATEGORY_LIST)";
            paramMap.put("ORG_CATEGORY_LIST", ORG_CATEGORY_LIST);
        }
        if (StringUtils.isNotEmpty(ORG_TAG_)) {
            List<String> tagList = omTagService.splitTag(ORG_TAG_);
            if (!tagList.isEmpty()) {
                if (orgTagUnion != null && orgTagUnion.equals(false)) {
                    sql += " and ORG_ID_ in (select ORG_ID_ from (select OBJ_ID_ as ORG_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'ORG' and TAG_ in (:ORG_TAG_LIST)) T group by ORG_ID_ having count(*) >= 1)";
                    paramMap.put("ORG_TAG_LIST", tagList);
                }
                else {
                    sql += " and ORG_ID_ in (select ORG_ID_ from (select OBJ_ID_ as ORG_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'ORG' and TAG_ in (:ORG_TAG_LIST)) T group by ORG_ID_ having count(*) >= :orgTagCount)";
                    paramMap.put("ORG_TAG_LIST", tagList);
                    paramMap.put("orgTagCount", tagList.size());
                }
            }
        }
        if (StringUtils.isNotEmpty(ORG_EXT_ATTR_1_)) {
            sql += " and ORG_EXT_ATTR_1_ = :ORG_EXT_ATTR_1_";
            paramMap.put("ORG_EXT_ATTR_1_", ORG_EXT_ATTR_1_);
        }
        if (ORG_EXT_ATTR_1_LIST != null && !ORG_EXT_ATTR_1_LIST.isEmpty()) {
            sql += " and ORG_EXT_ATTR_1_ in (:ORG_EXT_ATTR_1_LIST)";
            paramMap.put("ORG_EXT_ATTR_1_LIST", ORG_EXT_ATTR_1_LIST);
        }
        if (StringUtils.isNotEmpty(ORG_EXT_ATTR_2_)) {
            sql += " and ORG_EXT_ATTR_2_ = :ORG_EXT_ATTR_2_";
            paramMap.put("ORG_EXT_ATTR_2_", ORG_EXT_ATTR_2_);
        }
        if (ORG_EXT_ATTR_2_LIST != null && !ORG_EXT_ATTR_2_LIST.isEmpty()) {
            sql += " and ORG_EXT_ATTR_2_ in (:ORG_EXT_ATTR_2_LIST)";
            paramMap.put("ORG_EXT_ATTR_2_LIST", ORG_EXT_ATTR_2_LIST);
        }
        if (StringUtils.isNotEmpty(ORG_EXT_ATTR_3_)) {
            sql += " and ORG_EXT_ATTR_3_ = :ORG_EXT_ATTR_3_";
            paramMap.put("ORG_EXT_ATTR_3_", ORG_EXT_ATTR_3_);
        }
        if (ORG_EXT_ATTR_3_LIST != null && !ORG_EXT_ATTR_3_LIST.isEmpty()) {
            sql += " and ORG_EXT_ATTR_3_ in (:ORG_EXT_ATTR_3_LIST)";
            paramMap.put("ORG_EXT_ATTR_3_LIST", ORG_EXT_ATTR_3_LIST);
        }
        if (StringUtils.isNotEmpty(ORG_EXT_ATTR_4_)) {
            sql += " and ORG_EXT_ATTR_4_ = :ORG_EXT_ATTR_4_";
            paramMap.put("ORG_EXT_ATTR_4_", ORG_EXT_ATTR_4_);
        }
        if (ORG_EXT_ATTR_4_LIST != null && !ORG_EXT_ATTR_4_LIST.isEmpty()) {
            sql += " and ORG_EXT_ATTR_4_ in (:ORG_EXT_ATTR_4_LIST)";
            paramMap.put("ORG_EXT_ATTR_4_LIST", ORG_EXT_ATTR_4_LIST);
        }
        if (StringUtils.isNotEmpty(ORG_EXT_ATTR_5_)) {
            sql += " and ORG_EXT_ATTR_5_ = :ORG_EXT_ATTR_5_";
            paramMap.put("ORG_EXT_ATTR_5_", ORG_EXT_ATTR_5_);
        }
        if (ORG_EXT_ATTR_5_LIST != null && !ORG_EXT_ATTR_5_LIST.isEmpty()) {
            sql += " and ORG_EXT_ATTR_5_ in (:ORG_EXT_ATTR_5_LIST)";
            paramMap.put("ORG_EXT_ATTR_5_LIST", ORG_EXT_ATTR_5_LIST);
        }
        if (StringUtils.isNotEmpty(ORG_EXT_ATTR_6_)) {
            sql += " and ORG_EXT_ATTR_6_ = :ORG_EXT_ATTR_6_";
            paramMap.put("ORG_EXT_ATTR_6_", ORG_EXT_ATTR_6_);
        }
        if (ORG_EXT_ATTR_6_LIST != null && !ORG_EXT_ATTR_6_LIST.isEmpty()) {
            sql += " and ORG_EXT_ATTR_6_ in (:ORG_EXT_ATTR_6_LIST)";
            paramMap.put("ORG_EXT_ATTR_6_LIST", ORG_EXT_ATTR_6_LIST);
        }
        if (StringUtils.isNotEmpty(ORG_EXT_ATTR_7_)) {
            sql += " and ORG_EXT_ATTR_7_ = :ORG_EXT_ATTR_7_";
            paramMap.put("ORG_EXT_ATTR_7_", ORG_EXT_ATTR_7_);
        }
        if (ORG_EXT_ATTR_7_LIST != null && !ORG_EXT_ATTR_7_LIST.isEmpty()) {
            sql += " and ORG_EXT_ATTR_7_ in (:ORG_EXT_ATTR_7_LIST)";
            paramMap.put("ORG_EXT_ATTR_7_LIST", ORG_EXT_ATTR_7_LIST);
        }
        if (StringUtils.isNotEmpty(ORG_EXT_ATTR_8_)) {
            sql += " and ORG_EXT_ATTR_8_ = :ORG_EXT_ATTR_8_";
            paramMap.put("ORG_EXT_ATTR_8_", ORG_EXT_ATTR_8_);
        }
        if (ORG_EXT_ATTR_8_LIST != null && !ORG_EXT_ATTR_8_LIST.isEmpty()) {
            sql += " and ORG_EXT_ATTR_8_ in (:ORG_EXT_ATTR_8_LIST)";
            paramMap.put("ORG_EXT_ATTR_8_LIST", ORG_EXT_ATTR_8_LIST);
        }
        if (StringUtils.isNotEmpty(ORG_STATUS_)) {
            sql += " and ORG_STATUS_ = :ORG_STATUS_";
            paramMap.put("ORG_STATUS_", ORG_STATUS_);
        }
        if (ORG_STATUS_LIST != null && !ORG_STATUS_LIST.isEmpty()) {
            sql += " and ORG_STATUS_ in (:ORG_STATUS_LIST)";
            paramMap.put("ORG_STATUS_LIST", ORG_STATUS_LIST);
        }

        if (StringUtils.isNotEmpty(withinOrgId)) {
            sql = "with TMP as (select /*+ materialize*/ ORG_ID_ from (select ORG_ID_, PARENT_ORG_ID_ from OM_ORG where ORGN_SET_ID_ = :ORGN_SET_ID_) connect by prior ORG_ID_ = PARENT_ORG_ID_ start with ORG_ID_ = :withinOrgId) " + sql;
            sql += " and exists (select ORG_ID_ from TMP T where T.ORG_ID_ = PE.ORG_ID_)";
            paramMap.put("withinOrgId", withinOrgId);
        }
        if (orgRootOnly != null && orgRootOnly) {
            sql += " and (PARENT_ORG_ID_ is null or PARENT_ORG_ID_ = '')";
        }

        if (!count) {
            sql += " order by ORG_ID_, POSI_ID_, ORDER_, POSI_EMP_ID_";
        }

        return new OdSqlCriteria(sql, paramMap);
    }

    @Override
    public List<Map<String, Object>> selectPosiEmpByIdList(String ORGN_SET_ID_, List<String> POSI_EMP_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (POSI_EMP_ID_LIST == null || POSI_EMP_ID_LIST.isEmpty()) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder(POSI_EMP_ID_LIST.size() * 50 + 200);
        Map<String, Object> paramMap = new HashMap<>();

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

        if (POSI_EMP_ID_LIST == null || POSI_EMP_ID_LIST.isEmpty()) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder(POSI_EMP_ID_LIST.size() * 50 + 200);
        Map<String, Object> paramMap = new HashMap<>();

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
    public int insertPosiEmp(String ORGN_SET_ID_, String POSI_EMP_ID_, String POSI_ID_, String EMP_ID_, String MAIN_, String POSI_EMP_CATEGORY_, String MEMO_, String POSI_EMP_TAG_, String POSI_EMP_EXT_ATTR_1_, String POSI_EMP_EXT_ATTR_2_, String POSI_EMP_EXT_ATTR_3_, String POSI_EMP_EXT_ATTR_4_, String POSI_EMP_EXT_ATTR_5_, String POSI_EMP_EXT_ATTR_6_, String POSI_EMP_EXT_ATTR_7_, String POSI_EMP_EXT_ATTR_8_, Integer ORDER_, String POSI_EMP_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        POSI_EMP_TAG_ = StringUtils.join(omTagService.splitTag(POSI_EMP_TAG_), ",");
        omTagService.updateTagByObjId(ORGN_SET_ID_, POSI_EMP_ID_, "POSI_EMP", POSI_EMP_TAG_);

        String sql = "insert into OM_POSI_EMP (ORGN_SET_ID_, POSI_EMP_ID_, POSI_ID_, EMP_ID_, MAIN_, POSI_EMP_CATEGORY_, MEMO_, POSI_EMP_TAG_, POSI_EMP_EXT_ATTR_1_, POSI_EMP_EXT_ATTR_2_, POSI_EMP_EXT_ATTR_3_, POSI_EMP_EXT_ATTR_4_, POSI_EMP_EXT_ATTR_5_, POSI_EMP_EXT_ATTR_6_, POSI_EMP_EXT_ATTR_7_, POSI_EMP_EXT_ATTR_8_, ORDER_, POSI_EMP_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return omJdbcTemplate.update(sql, ORGN_SET_ID_, POSI_EMP_ID_, POSI_ID_, EMP_ID_, MAIN_, POSI_EMP_CATEGORY_, MEMO_, POSI_EMP_TAG_, POSI_EMP_EXT_ATTR_1_, POSI_EMP_EXT_ATTR_2_, POSI_EMP_EXT_ATTR_3_, POSI_EMP_EXT_ATTR_4_, POSI_EMP_EXT_ATTR_5_, POSI_EMP_EXT_ATTR_6_, POSI_EMP_EXT_ATTR_7_, POSI_EMP_EXT_ATTR_8_, ORDER_, POSI_EMP_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_);
    }

    @Override
    public int insertPosiEmpByEmpIdList(final String ORGN_SET_ID_, final String POSI_ID_, final List<String> EMP_ID_LIST, final Date CREATION_DATE_, final Date UPDATE_DATE_, final String OPERATOR_ID_, final String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (EMP_ID_LIST == null || EMP_ID_LIST.isEmpty()) {
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

        if (POSI_ID_LIST == null || POSI_ID_LIST.isEmpty()) {
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
    public int updatePosiEmp(String ORGN_SET_ID_, String POSI_EMP_ID_, String MAIN_, String POSI_EMP_CATEGORY_, String MEMO_, String POSI_EMP_TAG_, String POSI_EMP_EXT_ATTR_1_, String POSI_EMP_EXT_ATTR_2_, String POSI_EMP_EXT_ATTR_3_, String POSI_EMP_EXT_ATTR_4_, String POSI_EMP_EXT_ATTR_5_, String POSI_EMP_EXT_ATTR_6_, String POSI_EMP_EXT_ATTR_7_, String POSI_EMP_EXT_ATTR_8_, Integer ORDER_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        POSI_EMP_TAG_ = StringUtils.join(omTagService.splitTag(POSI_EMP_TAG_), ",");
        omTagService.updateTagByObjId(ORGN_SET_ID_, POSI_EMP_ID_, "POSI_EMP", POSI_EMP_TAG_);

        String sql = "update OM_POSI_EMP set MAIN_ = ?, POSI_EMP_CATEGORY_ = ?, MEMO_ = ?, POSI_EMP_TAG_ = ?, POSI_EMP_EXT_ATTR_1_ = ?, POSI_EMP_EXT_ATTR_2_ = ?, POSI_EMP_EXT_ATTR_3_ = ?, POSI_EMP_EXT_ATTR_4_ = ?, POSI_EMP_EXT_ATTR_5_ = ?, POSI_EMP_EXT_ATTR_6_ = ?, POSI_EMP_EXT_ATTR_7_ = ?, POSI_EMP_EXT_ATTR_8_ = ?, ORDER_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and POSI_EMP_ID_ = ?";
        return omJdbcTemplate.update(sql, MAIN_, POSI_EMP_CATEGORY_, MEMO_, POSI_EMP_TAG_, POSI_EMP_EXT_ATTR_1_, POSI_EMP_EXT_ATTR_2_, POSI_EMP_EXT_ATTR_3_, POSI_EMP_EXT_ATTR_4_, POSI_EMP_EXT_ATTR_5_, POSI_EMP_EXT_ATTR_6_, POSI_EMP_EXT_ATTR_7_, POSI_EMP_EXT_ATTR_8_, ORDER_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, POSI_EMP_ID_);
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