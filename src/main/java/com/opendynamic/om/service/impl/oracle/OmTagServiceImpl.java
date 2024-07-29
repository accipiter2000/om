package com.opendynamic.om.service.impl.oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.opendynamic.OdSqlCriteria;
import com.opendynamic.OdUtils;
import com.opendynamic.om.service.OmTagService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OmTagServiceImpl implements OmTagService {
    @Autowired
    private JdbcTemplate omJdbcTemplate;

    @Override
    public Map<String, Object> loadTag(String ORGN_SET_ID_, String ORGN_SET_CODE_, String TAG_ID_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_) && StringUtils.isEmpty(ORGN_SET_CODE_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }
        if (StringUtils.isEmpty(TAG_ID_)) {
            throw new RuntimeException("errors.idRequired");
        }

        String sql = "select * from OMV_TAG where TAG_ID_ = :TAG_ID_";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("TAG_ID_", TAG_ID_);

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
    public List<Map<String, Object>> selectTag(String ORGN_SET_ID_, String ORGN_SET_CODE_, String TAG_ID_, String OBJ_ID_, String OBJ_TYPE_, String TAG_, Integer page, Integer limit) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaTag(false, ORGN_SET_ID_, ORGN_SET_CODE_, TAG_ID_, OBJ_ID_, OBJ_TYPE_, TAG_);// 根据查询条件组装查询SQL语句
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
    public int countTag(String ORGN_SET_ID_, String ORGN_SET_CODE_, String TAG_ID_, String OBJ_ID_, String OBJ_TYPE_, String TAG_) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaTag(true, ORGN_SET_ID_, ORGN_SET_CODE_, TAG_ID_, OBJ_ID_, OBJ_TYPE_, TAG_);// 根据查询条件组装总数查询SQL语句
        String sql = odSqlCriteria.getSql();
        Map<String, Object> paramMap = odSqlCriteria.getParamMap();

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    private OdSqlCriteria buildSqlCriteriaTag(boolean count, String ORGN_SET_ID_, String ORGN_SET_CODE_, String TAG_ID_, String OBJ_ID_, String OBJ_TYPE_, String TAG_) {// 组装查询SQL语句
        if (StringUtils.isEmpty(ORGN_SET_ID_) && StringUtils.isEmpty(ORGN_SET_CODE_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql;
        Map<String, Object> paramMap = new HashMap<>();

        if (count) {
            sql = "select count(*) from OMV_TAG where 1 = 1";
        }
        else {
            sql = "select * from OMV_TAG where 1 = 1";
        }

        if (StringUtils.isNotEmpty(ORGN_SET_ID_)) {
            sql += " and ORGN_SET_ID_ = :ORGN_SET_ID_";
            paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        }
        if (StringUtils.isNotEmpty(ORGN_SET_CODE_)) {
            sql += " and ORGN_SET_CODE_ = :ORGN_SET_CODE_";
            paramMap.put("ORGN_SET_CODE_", ORGN_SET_CODE_);
        }
        if (StringUtils.isNotEmpty(TAG_ID_)) {
            sql += " and TAG_ID_ = :TAG_ID_";
            paramMap.put("TAG_ID_", TAG_ID_);
        }
        if (StringUtils.isNotEmpty(OBJ_ID_)) {
            sql += " and OBJ_ID_ = :OBJ_ID_";
            paramMap.put("OBJ_ID_", OBJ_ID_);
        }
        if (StringUtils.isNotEmpty(OBJ_TYPE_)) {
            sql += " and OBJ_TYPE_ = :OBJ_TYPE_";
            paramMap.put("OBJ_TYPE_", OBJ_TYPE_);
        }
        if (StringUtils.isNotEmpty(TAG_)) {
            sql += " and TAG_ = :TAG_";
            paramMap.put("TAG_", TAG_);
        }

        return new OdSqlCriteria(sql, paramMap);
    }

    @Override
    public List<Map<String, Object>> selectTagByIdList(String ORGN_SET_ID_, List<String> TAG_ID_LIST) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        if (TAG_ID_LIST == null || TAG_ID_LIST.isEmpty()) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder(TAG_ID_LIST.size() * 50 + 200);
        Map<String, Object> paramMap = new HashMap<>();

        sql.append("select * from OMV_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and TAG_ID_ in (:TAG_ID_LIST)");
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);
        paramMap.put("TAG_ID_LIST", TAG_ID_LIST);
        sql.append(" order by DECODE(TAG_ID_,");// 按主键列表顺序排序
        for (int i = 0; i < TAG_ID_LIST.size(); i++) {
            sql.append(" '").append(TAG_ID_LIST.get(i)).append("', ").append(i);
            if (i < TAG_ID_LIST.size() - 1) {
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
    public int insertTag(String ORGN_SET_ID_, String TAG_ID_, String OBJ_ID_, String OBJ_TYPE_, String TAG_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql = "insert into OM_TAG (ORGN_SET_ID_, TAG_ID_, OBJ_ID_, OBJ_TYPE_, TAG_) values (?, ?, ?, ?, ?)";
        return omJdbcTemplate.update(sql, ORGN_SET_ID_, TAG_ID_, OBJ_ID_, OBJ_TYPE_, TAG_);
    }

    @Override
    public int updateTag(String ORGN_SET_ID_, String TAG_ID_, String OBJ_ID_, String OBJ_TYPE_, String TAG_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql = "update OM_TAG set OBJ_ID_ = ?, OBJ_TYPE_ = ?, TAG_ = ? where ORGN_SET_ID_ = :ORGN_SET_ID_ and TAG_ID_ = ?";
        return omJdbcTemplate.update(sql, OBJ_ID_, OBJ_TYPE_, TAG_, ORGN_SET_ID_, TAG_ID_);
    }

    @Override
    public void updateTagByObjId(String ORGN_SET_ID_, String OBJ_ID_, String OBJ_TYPE_, String TAG_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        deleteTagByObjId(ORGN_SET_ID_, OBJ_ID_);

        List<String> tagList = splitTag(TAG_);
        for (String tag : tagList) {
            insertTag(ORGN_SET_ID_, OdUtils.getUuid(), OBJ_ID_, OBJ_TYPE_, tag);
        }
    }

    @Override
    public int deleteTag(String ORGN_SET_ID_, String TAG_ID_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql = "delete from OM_TAG where ORGN_SET_ID_ = :ORGN_SET_ID_ and TAG_ID_ = ?";
        return omJdbcTemplate.update(sql, ORGN_SET_ID_, TAG_ID_);
    }

    @Override
    public int deleteTagByObjId(String ORGN_SET_ID_, String OBJ_ID_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.orgnSetRequired");
        }

        String sql = "delete from OM_TAG where ORGN_SET_ID_ = ? and OBJ_ID_ = ?";
        return omJdbcTemplate.update(sql, ORGN_SET_ID_, OBJ_ID_);
    }

    @Override
    public List<String> splitTag(String TAG_) {
        List<String> tagList = new ArrayList<>();

        if (StringUtils.isNotEmpty(TAG_)) {
            String[] tags = TAG_.split("[,， 　]");
            for (String tag : tags) {
                if (StringUtils.isNotEmpty(tag)) {
                    tagList.add(tag);
                }
            }
        }

        return tagList;
    }
}