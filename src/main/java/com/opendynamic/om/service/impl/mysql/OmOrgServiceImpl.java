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
import com.opendynamic.om.service.OmOrgService;
import com.opendynamic.om.service.OmOrgnSetService;
import com.opendynamic.om.service.OmTagService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OmOrgServiceImpl implements OmOrgService {
    @Autowired
    private OmOrgnSetService omOrgnSetService;
    @Autowired
    private OmTagService omTagService;
    @Autowired
    private JdbcTemplate omJdbcTemplate;

    @Override
    public Map<String, Object> loadOrg(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORG_ID_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_) && StringUtils.isEmpty(ORGN_SET_CODE_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }
        if (StringUtils.isEmpty(ORG_ID_)) {
            throw new RuntimeException("errors.idRequired");
        }

        String sql = "select * from OMV_ORG where ORG_ID_ = :ORG_ID_";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ORG_ID_", ORG_ID_);

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
    public Map<String, Object> loadOrgByCode(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORG_CODE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_) && StringUtils.isEmpty(ORGN_SET_CODE_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }
        if (StringUtils.isEmpty(ORG_CODE_)) {
            throw new RuntimeException("errors.codeRequired");
        }

        String sql = "select * from OMV_ORG where ORG_CODE_ = :ORG_CODE_";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ORG_CODE_", ORG_CODE_);

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
    public List<Map<String, Object>> selectOrg(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORG_ID_, String PARENT_ORG_ID_, String ORG_CODE_, String ORG_NAME_, List<String> ORG_TYPE_LIST, List<String> CATEGORY_LIST, String ORG_TAG_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, String EXT_ATTR_7_, String EXT_ATTR_8_, List<String> ORG_STATUS_LIST, Boolean tagUnion, Boolean rootOnly, String withinOrgId, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaOrg(false, ORGN_SET_ID_, ORGN_SET_CODE_, ORG_ID_, PARENT_ORG_ID_, ORG_CODE_, ORG_NAME_, ORG_TYPE_LIST, CATEGORY_LIST, ORG_TAG_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, EXT_ATTR_7_, EXT_ATTR_8_, ORG_STATUS_LIST, tagUnion, rootOnly, withinOrgId, OPERATOR_ID_, OPERATOR_NAME_);// 根据查询条件组装查询SQL语句
        String sql = odSqlCriteria.getSql();
        Map<String, Object> paramMap = odSqlCriteria.getParamMap();

        if (page != null && limit != null && limit > 0) {// 分页
            sql = sql + " limit " + (page - 1) * limit + ", " + limit;
        }

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForList(sql, paramMap);
    }

    @Override
    public int countOrg(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORG_ID_, String PARENT_ORG_ID_, String ORG_CODE_, String ORG_NAME_, List<String> ORG_TYPE_LIST, List<String> CATEGORY_LIST, String ORG_TAG_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, String EXT_ATTR_7_, String EXT_ATTR_8_, List<String> ORG_STATUS_LIST, Boolean tagUnion, Boolean rootOnly, String withinOrgId, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaOrg(true, ORGN_SET_ID_, ORGN_SET_CODE_, ORG_ID_, PARENT_ORG_ID_, ORG_CODE_, ORG_NAME_, ORG_TYPE_LIST, CATEGORY_LIST, ORG_TAG_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, EXT_ATTR_7_, EXT_ATTR_8_, ORG_STATUS_LIST, tagUnion, rootOnly, withinOrgId, OPERATOR_ID_, OPERATOR_NAME_);// 根据查询条件组装总数查询SQL语句
        String sql = odSqlCriteria.getSql();
        Map<String, Object> paramMap = odSqlCriteria.getParamMap();

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    private OdSqlCriteria buildSqlCriteriaOrg(boolean count, String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORG_ID_, String PARENT_ORG_ID_, String ORG_CODE_, String ORG_NAME_, List<String> ORG_TYPE_LIST, List<String> CATEGORY_LIST, String ORG_TAG_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, String EXT_ATTR_7_, String EXT_ATTR_8_, List<String> ORG_STATUS_LIST, Boolean tagUnion, Boolean rootOnly, String withinOrgId, String OPERATOR_ID_, String OPERATOR_NAME_) {// 组装查询SQL语句
        if (StringUtils.isEmpty(ORGN_SET_ID_) && StringUtils.isEmpty(ORGN_SET_CODE_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            Map<String, Object> orgnSet = omOrgnSetService.loadOrgnSetByCode(ORGN_SET_CODE_, OPERATOR_ID_, OPERATOR_NAME_);
            ORGN_SET_ID_ = (String) orgnSet.get("ORGN_SET_ID_");
        }

        String sql;
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);

        if (count) {
            sql = "select count(*) from (select * from OMV_ORG where ORGN_SET_ID_ = :ORGN_SET_ID_) where 1 = 1";
        }
        else {
            sql = "select * from (select * from OMV_ORG where ORGN_SET_ID_ = :ORGN_SET_ID_) where 1 = 1";
        }

        if (StringUtils.isNotEmpty(ORGN_SET_CODE_)) {
            sql += " and ORGN_SET_CODE_ = :ORGN_SET_CODE_";
            paramMap.put("ORGN_SET_CODE_", ORGN_SET_CODE_);
        }
        if (StringUtils.isNotEmpty(ORG_ID_)) {
            sql += " and ORG_ID_ = :ORG_ID_";
            paramMap.put("ORG_ID_", ORG_ID_);
        }
        if (StringUtils.isNotEmpty(PARENT_ORG_ID_)) {
            sql += " and PARENT_ORG_ID_ = :PARENT_ORG_ID_";
            paramMap.put("PARENT_ORG_ID_", PARENT_ORG_ID_);
        }
        if (StringUtils.isNotEmpty(ORG_CODE_)) {
            sql += " and ORG_CODE_ = :ORG_CODE_";
            paramMap.put("ORG_CODE_", ORG_CODE_);
        }
        if (StringUtils.isNotEmpty(ORG_NAME_)) {
            sql += " and ORG_NAME_like concat('%',:ORG_NAME_,'%')";
            paramMap.put("ORG_NAME_", ORG_NAME_);
        }
        if (ORG_TYPE_LIST != null && ORG_TYPE_LIST.size() > 0) {
            sql += " and ORG_TYPE_ in (:ORG_TYPE_LIST)";
            paramMap.put("ORG_TYPE_LIST", ORG_TYPE_LIST);
        }
        if (CATEGORY_LIST != null && CATEGORY_LIST.size() > 0) {
            sql += " and CATEGORY_ in (:CATEGORY_LIST)";
            paramMap.put("CATEGORY_LIST", CATEGORY_LIST);
        }
        if (StringUtils.isNotEmpty(ORG_TAG_)) {
            List<String> tagList = omTagService.splitTag(ORG_TAG_);
            if (tagList.size() > 0) {
                if (tagUnion != null && tagUnion.equals(false)) {
                    sql += " and ORG_ID_ in (select ORG_ID_ from (select OBJ_ID_ as ORG_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'ORG' and TAG_ in (:ORG_TAG_LIST)) T group by ORG_ID_ having count(*) >= 1)";
                    paramMap.put("ORG_TAG_LIST", tagList);
                }
                else {
                    sql += " and ORG_ID_ in (select ORG_ID_ from (select OBJ_ID_ as ORG_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'ORG' and TAG_ in (:ORG_TAG_LIST)) T group by ORG_ID_ having count(*) >= :tagCount)";
                    paramMap.put("ORG_TAG_LIST", tagList);
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
        if (ORG_STATUS_LIST != null && ORG_STATUS_LIST.size() > 0) {
            sql += " and ORG_STATUS_ in (:ORG_STATUS_LIST)";
            paramMap.put("ORG_STATUS_LIST", ORG_STATUS_LIST);
        }

        if (rootOnly != null && rootOnly) {
            sql += " and (PARENT_ORG_ID_ is null or PARENT_ORG_ID_ = '')";
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
    public List<Map<String, Object>> selectParentOrg(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORG_ID_, String ORG_CODE_, String ORG_NAME_, List<String> ORG_TYPE_LIST, List<String> CATEGORY_LIST, String ORG_TAG_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, String EXT_ATTR_7_, String EXT_ATTR_8_, List<String> ORG_STATUS_LIST, Boolean tagUnion, String withinOrgId, Boolean includeSelf, Boolean recursive, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_) && StringUtils.isEmpty(ORGN_SET_CODE_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }
        if (StringUtils.isEmpty(ORG_ID_)) {
            throw new RuntimeException("errors.idRequired");
        }

        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            Map<String, Object> orgnSet = omOrgnSetService.loadOrgnSetByCode(ORGN_SET_CODE_, OPERATOR_ID_, OPERATOR_NAME_);
            ORGN_SET_ID_ = (String) orgnSet.get("ORGN_SET_ID_");
        }

        String sql = "select * from (select * from OMV_ORG where ORGN_SET_ID_ = :ORGN_SET_ID_) where 1 = 1";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        paramMap.put("ORG_ID_", ORG_ID_);

        if (StringUtils.isNotEmpty(ORGN_SET_CODE_)) {
            sql += " and ORGN_SET_CODE_ = :ORGN_SET_CODE_";
            paramMap.put("ORGN_SET_CODE_", ORGN_SET_CODE_);
        }
        if (StringUtils.isNotEmpty(ORG_CODE_)) {
            sql += " and ORG_CODE_ = :ORG_CODE_";
            paramMap.put("ORG_CODE_", ORG_CODE_);
        }
        if (StringUtils.isNotEmpty(ORG_NAME_)) {
            sql += " and ORG_NAME_like concat('%',:ORG_NAME_,'%')";
            paramMap.put("ORG_NAME_", ORG_NAME_);
        }
        if (ORG_TYPE_LIST != null && ORG_TYPE_LIST.size() > 0) {
            sql += " and ORG_TYPE_ in (:ORG_TYPE_LIST)";
            paramMap.put("ORG_TYPE_LIST", ORG_TYPE_LIST);
        }
        if (CATEGORY_LIST != null && CATEGORY_LIST.size() > 0) {
            sql += " and CATEGORY_ in (:CATEGORY_LIST)";
            paramMap.put("CATEGORY_LIST", CATEGORY_LIST);
        }
        if (StringUtils.isNotEmpty(ORG_TAG_)) {
            List<String> tagList = omTagService.splitTag(ORG_TAG_);
            if (tagList.size() > 0) {
                if (tagUnion != null && tagUnion.equals(false)) {
                    sql += " and ORG_ID_ in (select ORG_ID_ from (select OBJ_ID_ as ORG_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'ORG' and TAG_ in (:ORG_TAG_LIST)) T group by ORG_ID_ having count(*) >= 1)";
                    paramMap.put("ORG_TAG_LIST", tagList);
                }
                else {
                    sql += " and ORG_ID_ in (select ORG_ID_ from (select OBJ_ID_ as ORG_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'ORG' and TAG_ in (:ORG_TAG_LIST)) T group by ORG_ID_ having count(*) >= :tagCount)";
                    paramMap.put("ORG_TAG_LIST", tagList);
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
        if (ORG_STATUS_LIST != null && ORG_STATUS_LIST.size() > 0) {
            sql += " and ORG_STATUS_ in (:ORG_STATUS_LIST)";
            paramMap.put("ORG_STATUS_LIST", ORG_STATUS_LIST);
        }

        if (StringUtils.isNotEmpty(withinOrgId)) {
            sql += " and ORG_ID_ in (with recursive CTE as (select ORG_ID_, PARENT_ORG_ID_ from OM_ORG where ORGN_SET_ID_ = :ORGN_SET_ID_ and ORG_ID_ = :withinOrgId union all select OM_ORG.ORG_ID_, OM_ORG.PARENT_ORG_ID_ from OM_ORG inner join CTE on ORGN_SET_ID_ = :ORGN_SET_ID_ and CTE.ORG_ID_ = OM_ORG.PARENT_ORG_ID_) select ORG_ID_ from CTE)";
            paramMap.put("withinOrgId", withinOrgId);
        }
        if (includeSelf == null || includeSelf.equals(false)) {
            sql += " and ORG_ID_ != :ORG_ID_";
        }
        if (recursive == null || recursive.equals(false)) {
            sql += " and (ORG_ID_ = (select PARENT_ORG_ID_ from OM_ORG where ORGN_SET_ID_ = :ORGN_SET_ID_ and ORG_ID_ = :ORG_ID_) or ORG_ID_ = :ORG_ID_)";
        }
        else {
            sql += " and ORG_ID_ in (with recursive CTE as (select ORG_ID_, PARENT_ORG_ID_ from OM_ORG where ORGN_SET_ID_ = :ORGN_SET_ID_ and ORG_ID_ = :ORG_ID_ union all select OM_ORG.ORG_ID_, OM_ORG.PARENT_ORG_ID_ from OM_ORG inner join CTE on ORGN_SET_ID_ = :ORGN_SET_ID_ and CTE.PARENT_ORG_ID_ = OM_ORG.ORG_ID_) select ORG_ID_ from CTE)";
        }

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForList(sql, paramMap);
    }

    @Override
    public List<Map<String, Object>> selectChildOrg(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORG_ID_, String ORG_CODE_, String ORG_NAME_, List<String> ORG_TYPE_LIST, List<String> CATEGORY_LIST, String ORG_TAG_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, String EXT_ATTR_7_, String EXT_ATTR_8_, List<String> ORG_STATUS_LIST, Boolean tagUnion, String withinOrgId, Boolean includeSelf, Boolean recursive, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_) && StringUtils.isEmpty(ORGN_SET_CODE_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }
        if (StringUtils.isEmpty(ORG_ID_)) {
            throw new RuntimeException("errors.idRequired");
        }

        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            Map<String, Object> orgnSet = omOrgnSetService.loadOrgnSetByCode(ORGN_SET_CODE_, OPERATOR_ID_, OPERATOR_NAME_);
            ORGN_SET_ID_ = (String) orgnSet.get("ORGN_SET_ID_");
        }

        String sql = "select * from (select * from OMV_ORG where ORGN_SET_ID_ = :ORGN_SET_ID_) where 1 = 1";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        paramMap.put("ORG_ID_", ORG_ID_);

        if (StringUtils.isNotEmpty(ORGN_SET_CODE_)) {
            sql += " and ORGN_SET_CODE_ = :ORGN_SET_CODE_";
            paramMap.put("ORGN_SET_CODE_", ORGN_SET_CODE_);
        }
        if (StringUtils.isNotEmpty(ORG_CODE_)) {
            sql += " and ORG_CODE_ = :ORG_CODE_";
            paramMap.put("ORG_CODE_", ORG_CODE_);
        }
        if (StringUtils.isNotEmpty(ORG_NAME_)) {
            sql += " and ORG_NAME_like concat('%',:ORG_NAME_,'%')";
            paramMap.put("ORG_NAME_", ORG_NAME_);
        }
        if (ORG_TYPE_LIST != null && ORG_TYPE_LIST.size() > 0) {
            sql += " and ORG_TYPE_ in (:ORG_TYPE_LIST)";
            paramMap.put("ORG_TYPE_LIST", ORG_TYPE_LIST);
        }
        if (CATEGORY_LIST != null && CATEGORY_LIST.size() > 0) {
            sql += " and CATEGORY_ in (:CATEGORY_LIST)";
            paramMap.put("CATEGORY_LIST", CATEGORY_LIST);
        }
        if (StringUtils.isNotEmpty(ORG_TAG_)) {
            List<String> tagList = omTagService.splitTag(ORG_TAG_);
            if (tagList.size() > 0) {
                if (tagUnion != null && tagUnion.equals(false)) {
                    sql += " and ORG_ID_ in (select ORG_ID_ from (select OBJ_ID_ as ORG_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'ORG' and TAG_ in (:ORG_TAG_LIST)) T group by ORG_ID_ having count(*) >= 1)";
                    paramMap.put("ORG_TAG_LIST", tagList);
                }
                else {
                    sql += " and ORG_ID_ in (select ORG_ID_ from (select OBJ_ID_ as ORG_ID_ from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and OBJ_TYPE_ = 'ORG' and TAG_ in (:ORG_TAG_LIST)) T group by ORG_ID_ having count(*) >= :tagCount)";
                    paramMap.put("ORG_TAG_LIST", tagList);
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
        if (ORG_STATUS_LIST != null && ORG_STATUS_LIST.size() > 0) {
            sql += " and ORG_STATUS_ in (:ORG_STATUS_LIST)";
            paramMap.put("ORG_STATUS_LIST", ORG_STATUS_LIST);
        }

        if (StringUtils.isNotEmpty(withinOrgId)) {
            sql += " and ORG_ID_ in (with recursive CTE as (select ORG_ID_, PARENT_ORG_ID_ from OM_ORG where ORGN_SET_ID_ = :ORGN_SET_ID_ and ORG_ID_ = :withinOrgId union all select OM_ORG.ORG_ID_, OM_ORG.PARENT_ORG_ID_ from OM_ORG inner join CTE on ORGN_SET_ID_ = :ORGN_SET_ID_ and CTE.ORG_ID_ = OM_ORG.PARENT_ORG_ID_) select ORG_ID_ from CTE)";
            paramMap.put("withinOrgId", withinOrgId);
        }
        if (includeSelf == null || includeSelf.equals(false)) {
            sql += " and ORG_ID_ != :ORG_ID_";
        }
        if (recursive == null || recursive.equals(false)) {
            sql += " and (PARENT_ORG_ID_ = :ORG_ID_ or ORG_ID_ = :ORG_ID_)";
        }
        else {
            sql += " and ORG_ID_ in (with recursive CTE as (select ORG_ID_, PARENT_ORG_ID_ from OM_ORG where ORGN_SET_ID_ = :ORGN_SET_ID_ and ORG_ID_ = :ORG_ID_ union all select OM_ORG.ORG_ID_, OM_ORG.PARENT_ORG_ID_ from OM_ORG inner join CTE on ORGN_SET_ID_ = :ORGN_SET_ID_ and CTE.ORG_ID_ = OM_ORG.PARENT_ORG_ID_) select ORG_ID_ from CTE)";
        }

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForList(sql, paramMap);
    }

    @Override
    public List<Map<String, Object>> selectOrgByIdList(String ORGN_SET_ID_, List<String> ORG_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (ORG_ID_LIST == null || ORG_ID_LIST.size() == 0) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder(ORG_ID_LIST.size() * 50 + 200);
        Map<String, Object> paramMap = new HashMap<String, Object>();

        sql.append("select * from OMV_ORG where ORGN_SET_ID_ = :ORGN_SET_ID_ and ORG_ID_ in (:ORG_ID_LIST)");
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        paramMap.put("ORG_ID_LIST", ORG_ID_LIST);
        sql.append(" order by FIELD(ORG_ID_,");// 按主键列表顺序排序
        for (int i = 0; i < ORG_ID_LIST.size(); i++) {
            sql.append(" '").append(ORG_ID_LIST.get(i)).append("'");
            if (i < ORG_ID_LIST.size() - 1) {
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
    public List<Map<String, Object>> selectProtoOrgByIdList(String ORGN_SET_ID_, List<String> ORG_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (ORG_ID_LIST == null || ORG_ID_LIST.size() == 0) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder(ORG_ID_LIST.size() * 50 + 200);
        Map<String, Object> paramMap = new HashMap<String, Object>();

        sql.append("select * from OM_ORG where ORGN_SET_ID_ = :ORGN_SET_ID_ and ORG_ID_ in (:ORG_ID_LIST)");
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        paramMap.put("ORG_ID_LIST", ORG_ID_LIST);
        sql.append(" order by FIELD(ORG_ID_,");// 按主键列表顺序排序
        for (int i = 0; i < ORG_ID_LIST.size(); i++) {
            sql.append(" '").append(ORG_ID_LIST.get(i)).append("'");
            if (i < ORG_ID_LIST.size() - 1) {
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
    public int insertOrg(String ORGN_SET_ID_, String ORG_ID_, String PARENT_ORG_ID_, String ORG_CODE_, String ORG_NAME_, String ORG_ABBR_NAME_, String ORG_TYPE_, String CATEGORY_, String MEMO_, String ORG_TAG_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, String EXT_ATTR_7_, String EXT_ATTR_8_, Integer ORDER_, String ORG_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        ORG_TAG_ = StringUtils.join(omTagService.splitTag(ORG_TAG_), ",");
        omTagService.updateTagByObjId(ORGN_SET_ID_, ORG_ID_, "ORG", ORG_TAG_);

        String sql = "insert into OM_ORG (ORGN_SET_ID_, ORG_ID_, PARENT_ORG_ID_, ORG_CODE_, ORG_NAME_, ORG_ABBR_NAME_, ORG_TYPE_, CATEGORY_, MEMO_, ORG_TAG_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, EXT_ATTR_7_, EXT_ATTR_8_, ORDER_, ORG_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''))";
        return omJdbcTemplate.update(sql, ORGN_SET_ID_, ORG_ID_, PARENT_ORG_ID_, ORG_CODE_, ORG_NAME_, ORG_ABBR_NAME_, ORG_TYPE_, CATEGORY_, MEMO_, ORG_TAG_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, EXT_ATTR_7_, EXT_ATTR_8_, ORDER_, ORG_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_);
    }

    @Override
    public int updateOrg(String ORGN_SET_ID_, String ORG_ID_, String ORG_CODE_, String ORG_NAME_, String ORG_ABBR_NAME_, String ORG_TYPE_, String CATEGORY_, String MEMO_, String ORG_TAG_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, String EXT_ATTR_7_, String EXT_ATTR_8_, Integer ORDER_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        ORG_TAG_ = StringUtils.join(omTagService.splitTag(ORG_TAG_), ",");
        omTagService.updateTagByObjId(ORGN_SET_ID_, ORG_ID_, "ORG", ORG_TAG_);

        String sql = "update OM_ORG set ORG_CODE_ = NULLIF(?, ''), ORG_NAME_ = NULLIF(?, ''), ORG_ABBR_NAME_ = NULLIF(?, ''), ORG_TYPE_ = NULLIF(?, ''), CATEGORY_ = NULLIF(?, ''), MEMO_ = NULLIF(?, ''), ORG_TAG_ = NULLIF(?, ''), EXT_ATTR_1_ = NULLIF(?, ''), EXT_ATTR_2_ = NULLIF(?, ''), EXT_ATTR_3_ = NULLIF(?, ''), EXT_ATTR_4_ = NULLIF(?, ''), EXT_ATTR_5_ = NULLIF(?, ''), EXT_ATTR_6_ = NULLIF(?, ''), EXT_ATTR_7_ = NULLIF(?, ''), EXT_ATTR_8_ = NULLIF(?, ''), ORDER_ = NULLIF(?, ''), UPDATE_DATE_ = NULLIF(?, ''), OPERATOR_ID_ = NULLIF(?, ''), OPERATOR_NAME_ = NULLIF(?, '') where ORGN_SET_ID_ = ? and ORG_ID_ = ?";
        return omJdbcTemplate.update(sql, ORG_CODE_, ORG_NAME_, ORG_ABBR_NAME_, ORG_TYPE_, CATEGORY_, MEMO_, ORG_TAG_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, EXT_ATTR_7_, EXT_ATTR_8_, ORDER_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, ORG_ID_);
    }

    @Override
    public int updateOrgOrder(final String ORGN_SET_ID_, final List<String> ORG_ID_LIST, final List<Integer> ORDER_LIST, final Date UPDATE_DATE_, final String OPERATOR_ID_, final String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (ORG_ID_LIST == null || ORG_ID_LIST.size() == 0) {
            return 0;
        }
        if (ORG_ID_LIST.size() != ORDER_LIST.size()) {
            return 0;
        }

        String sql = "update OM_ORG set ORDER_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and ORG_ID_ = ?";
        BatchPreparedStatementSetter batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, ORDER_LIST.get(i));
                ps.setTimestamp(2, UPDATE_DATE_ == null ? null : new java.sql.Timestamp(UPDATE_DATE_.getTime()));
                ps.setString(3, OPERATOR_ID_);
                ps.setString(4, OPERATOR_NAME_);
                ps.setString(5, ORGN_SET_ID_);
                ps.setString(6, ORG_ID_LIST.get(i));
            }

            public int getBatchSize() {
                return ORG_ID_LIST.size();
            }
        };

        return omJdbcTemplate.batchUpdate(sql, batch).length;
    }

    @Override
    public int moveOrg(String ORGN_SET_ID_, String ORG_ID_, String PARENT_ORG_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql = "update OM_ORG set PARENT_ORG_ID_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and ORG_ID_ = ? and not exists (with recursive CTE as (select ORG_ID_ from OM_ORG where ORGN_SET_ID_ = ? and ORG_ID_ = ? union all select OM_ORG.ORG_ID_ from OM_ORG inner join CTE on ORGN_SET_ID_ = ? and CTE.ORG_ID_ = OM_ORG.PARENT_ORG_ID_) select 1 from CTE where ORG_ID_= ?)";
        return omJdbcTemplate.update(sql, PARENT_ORG_ID_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, ORG_ID_, ORGN_SET_ID_, ORG_ID_, ORGN_SET_ID_, PARENT_ORG_ID_);
    }

    @Override
    public int disableOrg(String ORGN_SET_ID_, String ORG_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql = "update OM_ORG set ORG_STATUS_ = '0', UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and ORG_ID_ = ?";
        return omJdbcTemplate.update(sql, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, ORG_ID_);
    }

    @Override
    public int enableOrg(String ORGN_SET_ID_, String ORG_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql = "update OM_ORG set ORG_STATUS_ = '1', UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and ORG_ID_ = ?";
        return omJdbcTemplate.update(sql, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, ORG_ID_);
    }

    @Override
    public int deleteOrg(String ORGN_SET_ID_, String ORG_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        omTagService.deleteTagByObjId(ORGN_SET_ID_, ORG_ID_);

        String sql = "delete from OM_ORG where ORGN_SET_ID_ = ? and ORG_ID_ = ?";
        return omJdbcTemplate.update(sql, ORGN_SET_ID_, ORG_ID_);
    }
}