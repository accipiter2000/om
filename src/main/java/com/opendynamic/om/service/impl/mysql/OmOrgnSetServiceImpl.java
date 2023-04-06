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
import com.opendynamic.om.service.OmOrgnSetService;
import com.opendynamic.om.vo.OrgnChange;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OmOrgnSetServiceImpl implements OmOrgnSetService {
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
    public List<Map<String, Object>> selectOrgnSet(String ORGN_SET_ID_, String PARENT_ORGN_SET_ID_, String ORGN_SET_CODE_, String ORGN_SET_NAME_, List<String> ORGN_SET_STATUS_LIST, Boolean rootOnly, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaOrgnSet(false, ORGN_SET_ID_, PARENT_ORGN_SET_ID_, ORGN_SET_CODE_, ORGN_SET_NAME_, ORGN_SET_STATUS_LIST, rootOnly, OPERATOR_ID_, OPERATOR_NAME_);// 根据查询条件组装查询SQL语句
        String sql = odSqlCriteria.getSql();
        Map<String, Object> paramMap = odSqlCriteria.getParamMap();

        if (page != null && limit != null && limit > 0) {// 分页
            sql = sql + " limit " + (page - 1) * limit + ", " + limit;
        }

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForList(sql, paramMap);
    }

    @Override
    public int countOrgnSet(String ORGN_SET_ID_, String PARENT_ORGN_SET_ID_, String ORGN_SET_CODE_, String ORGN_SET_NAME_, List<String> ORGN_SET_STATUS_LIST, Boolean rootOnly, String OPERATOR_ID_, String OPERATOR_NAME_) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaOrgnSet(true, ORGN_SET_ID_, PARENT_ORGN_SET_ID_, ORGN_SET_CODE_, ORGN_SET_NAME_, ORGN_SET_STATUS_LIST, rootOnly, OPERATOR_ID_, OPERATOR_NAME_);// 根据查询条件组装总数查询SQL语句
        String sql = odSqlCriteria.getSql();
        Map<String, Object> paramMap = odSqlCriteria.getParamMap();

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    private OdSqlCriteria buildSqlCriteriaOrgnSet(boolean count, String ORGN_SET_ID_, String PARENT_ORGN_SET_ID_, String ORGN_SET_CODE_, String ORGN_SET_NAME_, List<String> ORGN_SET_STATUS_LIST, Boolean rootOnly, String OPERATOR_ID_, String OPERATOR_NAME_) {// 组装查询SQL语句
        String sql;
        Map<String, Object> paramMap = new HashMap<String, Object>();

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
        if (StringUtils.isNotEmpty(PARENT_ORGN_SET_ID_)) {
            sql += " and PARENT_ORGN_SET_ID_ = :PARENT_ORGN_SET_ID_";
            paramMap.put("PARENT_ORGN_SET_ID_", PARENT_ORGN_SET_ID_);
        }
        if (StringUtils.isNotEmpty(ORGN_SET_CODE_)) {
            sql += " and ORGN_SET_CODE_ = :ORGN_SET_CODE_";
            paramMap.put("ORGN_SET_CODE_", ORGN_SET_CODE_);
        }
        if (StringUtils.isNotEmpty(ORGN_SET_NAME_)) {
            sql += " and ORGN_SET_NAME_like concat('%',:ORGN_SET_NAME_,'%')";
            paramMap.put("ORGN_SET_NAME_", ORGN_SET_NAME_);
        }
        if (ORGN_SET_STATUS_LIST != null && ORGN_SET_STATUS_LIST.size() > 0) {
            sql += " and ORGN_SET_STATUS_ in (:ORGN_SET_STATUS_LIST)";
            paramMap.put("ORGN_SET_STATUS_LIST", ORGN_SET_STATUS_LIST);
        }

        if (rootOnly != null && rootOnly) {
            sql += " and (PARENT_ORGN_SET_ID_ is null or PARENT_ORGN_SET_ID_ = '')";
        }

        if (!count) {
            sql += " order by ORDER_";
        }

        return new OdSqlCriteria(sql, paramMap);
    }

    @Override
    public List<Map<String, Object>> selectParentOrgnSet(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORGN_SET_NAME_, List<String> ORGN_SET_STATUS_LIST, Boolean includeSelf, Boolean recursive, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.idRequired");
        }

        String sql = "select * from OMV_ORGN_SET where 1 = 1";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);

        if (StringUtils.isNotEmpty(ORGN_SET_CODE_)) {
            sql += " and ORGN_SET_CODE_ = :ORGN_SET_CODE_";
            paramMap.put("ORGN_SET_CODE_", ORGN_SET_CODE_);
        }
        if (StringUtils.isNotEmpty(ORGN_SET_NAME_)) {
            sql += " and ORGN_SET_NAME_like concat('%',:ORGN_SET_NAME_,'%')";
            paramMap.put("ORGN_SET_NAME_", ORGN_SET_NAME_);
        }
        if (ORGN_SET_STATUS_LIST != null && ORGN_SET_STATUS_LIST.size() > 0) {
            sql += " and ORGN_SET_STATUS_ in (:ORGN_SET_STATUS_LIST)";
            paramMap.put("ORGN_SET_STATUS_LIST", ORGN_SET_STATUS_LIST);
        }

        if (includeSelf == null || includeSelf.equals(false)) {
            sql += " and ORGN_SET_ID_ != :ORGN_SET_ID_";
        }
        if (recursive == null || recursive.equals(false)) {
            sql += " and (ORGN_SET_ID_ = (select PARENT_ORGN_SET_ID_ from OM_ORGN_SET where ORGN_SET_ID_ = :ORGN_SET_ID_) or ORGN_SET_ID_ = :ORGN_SET_ID_)";
        }
        else {
            sql += " and ORGN_SET_ID_ in (with recursive CTE as (select ORGN_SET_ID_, PARENT_ORGN_SET_ID_ from OM_ORGN_SET where ORGN_SET_ID_ = :ORGN_SET_ID_ union all select OM_ORGN_SET.ORGN_SET_ID_, OM_ORGN_SET.PARENT_ORGN_SET_ID_ from OM_ORGN_SET inner join CTE on CTE.PARENT_ORGN_SET_ID_ = OM_ORGN_SET.ORGN_SET_ID_) select ORGN_SET_ID_ from CTE)";
        }

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForList(sql, paramMap);
    }

    @Override
    public List<Map<String, Object>> selectChildOrgnSet(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORGN_SET_NAME_, List<String> ORGN_SET_STATUS_LIST, Boolean includeSelf, Boolean recursive, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (StringUtils.isEmpty(ORGN_SET_ID_)) {
            throw new RuntimeException("errors.idRequired");
        }

        String sql = "select * from OMV_ORGN_SET where 1 = 1";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ORGN_SET_ID_", ORGN_SET_ID_);

        if (StringUtils.isNotEmpty(ORGN_SET_CODE_)) {
            sql += " and ORGN_SET_CODE_ = :ORGN_SET_CODE_";
            paramMap.put("ORGN_SET_CODE_", ORGN_SET_CODE_);
        }
        if (StringUtils.isNotEmpty(ORGN_SET_NAME_)) {
            sql += " and ORGN_SET_NAME_like concat('%',:ORGN_SET_NAME_,'%')";
            paramMap.put("ORGN_SET_NAME_", ORGN_SET_NAME_);
        }
        if (ORGN_SET_STATUS_LIST != null && ORGN_SET_STATUS_LIST.size() > 0) {
            sql += " and ORGN_SET_STATUS_ in (:ORGN_SET_STATUS_LIST)";
            paramMap.put("ORGN_SET_STATUS_LIST", ORGN_SET_STATUS_LIST);
        }

        if (includeSelf == null || includeSelf.equals(false)) {
            sql += " and ORGN_SET_ID_ != :ORGN_SET_ID_";
        }
        if (recursive == null || recursive.equals(false)) {
            sql += " and (PARENT_ORGN_SET_ID_ = :ORGN_SET_ID_ or ORGN_SET_ID_ = :ORGN_SET_ID_)";
        }
        else {
            sql += " and ORGN_SET_ID_ in (with recursive CTE as (select ORGN_SET_ID_, PARENT_ORGN_SET_ID_ from OM_ORGN_SET where ORGN_SET_ID_ = :ORGN_SET_ID_ union all select OM_ORGN_SET.ORGN_SET_ID_, OM_ORGN_SET.PARENT_ORGN_SET_ID_ from OM_ORGN_SET inner join CTE on CTE.ORGN_SET_ID_ = OM_ORGN_SET.PARENT_ORGN_SET_ID_) select ORGN_SET_ID_ from CTE)";
        }

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForList(sql, paramMap);
    }

    @Override
    public List<Map<String, Object>> selectOrgnSetByIdList(List<String> ORGN_SET_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_) {
        if (ORGN_SET_ID_LIST == null || ORGN_SET_ID_LIST.size() == 0) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder(ORGN_SET_ID_LIST.size() * 50 + 200);
        Map<String, Object> paramMap = new HashMap<String, Object>();

        sql.append("select * from OMV_ORGN_SET where ORGN_SET_ID_ in (:ORGN_SET_ID_LIST)");
        paramMap.put("ORGN_SET_ID_LIST", ORGN_SET_ID_LIST);
        sql.append(" order by FIELD(ORGN_SET_ID_,");// 按主键列表顺序排序
        for (int i = 0; i < ORGN_SET_ID_LIST.size(); i++) {
            sql.append(" '").append(ORGN_SET_ID_LIST.get(i)).append("'");
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
        String sql = "insert into OM_ORGN_SET (ORGN_SET_ID_, PARENT_ORGN_SET_ID_, ORGN_SET_CODE_, ORGN_SET_NAME_, ALLOW_SYNC_, MEMO_, ORDER_, ORGN_SET_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''), NULLIF(?, ''))";
        return omJdbcTemplate.update(sql, ORGN_SET_ID_, PARENT_ORGN_SET_ID_, ORGN_SET_CODE_, ORGN_SET_NAME_, ALLOW_SYNC_, MEMO_, ORDER_, ORGN_SET_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_);
    }

    @Override
    public int updateOrgnSet(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORGN_SET_NAME_, String ALLOW_SYNC_, String MEMO_, Integer ORDER_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql = "update OM_ORGN_SET set ORGN_SET_CODE_ = NULLIF(?, ''), ORGN_SET_NAME_ = NULLIF(?, ''), ALLOW_SYNC_ = NULLIF(?, ''), MEMO_ = NULLIF(?, ''), ORDER_ = NULLIF(?, ''), UPDATE_DATE_ = NULLIF(?, ''), OPERATOR_ID_ = NULLIF(?, ''), OPERATOR_NAME_ = NULLIF(?, '') where ORGN_SET_ID_ = ?";
        return omJdbcTemplate.update(sql, ORGN_SET_CODE_, ORGN_SET_NAME_, ALLOW_SYNC_, MEMO_, ORDER_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_);
    }

    @Override
    public int updateOrgnSetOrder(final List<String> ORGN_SET_ID_LIST, final List<Integer> ORDER_LIST, final Date UPDATE_DATE_, final String OPERATOR_ID_, final String OPERATOR_NAME_) {
        if (ORGN_SET_ID_LIST == null || ORGN_SET_ID_LIST.size() == 0) {
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
        String sql = "update OM_ORGN_SET set PARENT_ORGN_SET_ID_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where ORGN_SET_ID_ = ? and not exists (with recursive CTE as (select ORGN_SET_ID_ from OM_ORGN_SET where ORGN_SET_ID_ = ? union all select OM_ORGN_SET.ORGN_SET_ID_ from OM_ORGN_SET inner join CTE on CTE.ORGN_SET_ID_ = OM_ORGN_SET.PARENT_ORGN_SET_ID_) select 1 from CTE where ORGN_SET_ID_= ?)";
        return omJdbcTemplate.update(sql, PARENT_ORGN_SET_ID_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, ORGN_SET_ID_, ORGN_SET_ID_, PARENT_ORGN_SET_ID_);
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
    public OrgnChange compareOrgnSet(String BASE_ORGN_SET_ID_, String ORGN_SET_ID_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int copyOrgnSet(String BASE_ORGN_SET_ID_, String ORGN_SET_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int replaceOrgnSet(String BASE_ORGN_SET_ID_, String ORGN_SET_ID_, List<String> INSERT_ORG_ID_LIST, List<String> UPDATE_ORG_ID_LIST, List<String> DELETE_ORG_ID_LIST, List<String> INSERT_DUTY_ID_LIST, List<String> UPDATE_DUTY_ID_LIST, List<String> DELETE_DUTY_ID_LIST, List<String> INSERT_POSI_ID_LIST, List<String> UPDATE_POSI_ID_LIST, List<String> DELETE_POSI_ID_LIST, List<String> INSERT_EMP_ID_LIST, List<String> UPDATE_EMP_ID_LIST, List<String> DELETE_EMP_ID_LIST, List<String> INSERT_POSI_EMP_ID_LIST, List<String> UPDATE_POSI_EMP_ID_LIST, List<String> DELETE_POSI_EMP_ID_LIST, List<String> INSERT_EMP_RELATION_ID_LIST, List<String> UPDATE_EMP_RELATION_ID_LIST, List<String> DELETE_EMP_RELATION_ID_LIST, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        // TODO Auto-generated method stub
        return 0;
    }
}