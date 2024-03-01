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
import com.opendynamic.om.service.OmMainServerService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OmMainServerServiceImpl implements OmMainServerService {
    @Autowired
    private JdbcTemplate omJdbcTemplate;

    @Override
    public Map<String, Object> loadMainServer(String MAIN_SERVER_ID_) {
        String sql = "select * from OMV_MAIN_SERVER where MAIN_SERVER_ID_ = ?";
        List<Map<String, Object>> result = omJdbcTemplate.queryForList(sql, MAIN_SERVER_ID_);
        if (result.size() == 1) {
            return result.get(0);
        }
        else {
            return null;
        }
    }

    @Override
    public List<Map<String, Object>> selectMainServer(String MAIN_SERVER_ID_, String MAIN_SERVER_NAME_, List<String> MAIN_SERVER_STATUS_LIST, Integer page, Integer limit) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaMainServer(false, MAIN_SERVER_ID_, MAIN_SERVER_NAME_, MAIN_SERVER_STATUS_LIST);// 根据查询条件组装查询SQL语句
        String sql = odSqlCriteria.getSql();
        Map<String, Object> paramMap = odSqlCriteria.getParamMap();

        if (page != null && limit != null && limit > 0) {// 分页
            sql = sql + " limit " + (page - 1) * limit + ", " + limit;
        }

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForList(sql, paramMap);
    }

    @Override
    public int countMainServer(String MAIN_SERVER_ID_, String MAIN_SERVER_NAME_, List<String> MAIN_SERVER_STATUS_LIST) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaMainServer(true, MAIN_SERVER_ID_, MAIN_SERVER_NAME_, MAIN_SERVER_STATUS_LIST);// 根据查询条件组装总数查询SQL语句
        String sql = odSqlCriteria.getSql();
        Map<String, Object> paramMap = odSqlCriteria.getParamMap();

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    private OdSqlCriteria buildSqlCriteriaMainServer(boolean count, String MAIN_SERVER_ID_, String MAIN_SERVER_NAME_, List<String> MAIN_SERVER_STATUS_LIST) {// 组装查询SQL语句
        String sql;
        Map<String, Object> paramMap = new HashMap<String, Object>();

        if (count) {
            sql = "select count(*) from OMV_MAIN_SERVER where 1 = 1";
        }
        else {
            sql = "select * from OMV_MAIN_SERVER where 1 = 1";
        }

        if (StringUtils.isNotEmpty(MAIN_SERVER_ID_)) {
            sql += " and MAIN_SERVER_ID_ = :MAIN_SERVER_ID_";
            paramMap.put("MAIN_SERVER_ID_", MAIN_SERVER_ID_);
        }
        if (StringUtils.isNotEmpty(MAIN_SERVER_NAME_)) {
            sql += " and MAIN_SERVER_NAME_ like concat('%',:MAIN_SERVER_NAME_,'%')";
            paramMap.put("MAIN_SERVER_NAME_", MAIN_SERVER_NAME_);
        }
        if (MAIN_SERVER_STATUS_LIST != null && MAIN_SERVER_STATUS_LIST.size() > 0) {
            sql += " and MAIN_SERVER_STATUS_ in (:MAIN_SERVER_STATUS_LIST)";
            paramMap.put("MAIN_SERVER_STATUS_LIST", MAIN_SERVER_STATUS_LIST);
        }

        if (!count) {
            sql += " order by ORDER_, MAIN_SERVER_ID_";
        }

        return new OdSqlCriteria(sql, paramMap);
    }

    @Override
    public List<Map<String, Object>> selectMainServerByIdList(List<String> MAIN_SERVER_ID_LIST) {
        if (MAIN_SERVER_ID_LIST == null || MAIN_SERVER_ID_LIST.size() == 0) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder(MAIN_SERVER_ID_LIST.size() * 50 + 200);
        Map<String, Object> paramMap = new HashMap<String, Object>();

        sql.append("select * from OMV_MAIN_SERVER where MAIN_SERVER_ID_ in (:MAIN_SERVER_ID_LIST)");
        paramMap.put("MAIN_SERVER_ID_LIST", MAIN_SERVER_ID_LIST);
        sql.append(" order by FIELD(MAIN_SERVER_ID_,");// 按主键列表顺序排序
        for (int i = 0; i < MAIN_SERVER_ID_LIST.size(); i++) {
            sql.append(" '").append(MAIN_SERVER_ID_LIST.get(i)).append("'");
            if (i < MAIN_SERVER_ID_LIST.size() - 1) {
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
    public int insertMainServer(String MAIN_SERVER_ID_, String MAIN_SERVER_NAME_, String DRIVER_CLASS_NAME_, String URL_, String USERNAME_, String PASSWORD_, String MEMO_, Date LAST_SYNC_DATE_, Integer ORDER_, String MAIN_SERVER_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql = "insert into OM_MAIN_SERVER (MAIN_SERVER_ID_, MAIN_SERVER_NAME_, DRIVER_CLASS_NAME_, URL_, USERNAME_, PASSWORD_, MEMO_, LAST_SYNC_DATE_, ORDER_, MAIN_SERVER_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return omJdbcTemplate.update(sql, MAIN_SERVER_ID_, MAIN_SERVER_NAME_, DRIVER_CLASS_NAME_, URL_, USERNAME_, PASSWORD_, MEMO_, LAST_SYNC_DATE_, ORDER_, MAIN_SERVER_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_);
    }

    @Override
    public int updateMainServer(String MAIN_SERVER_ID_, String MAIN_SERVER_NAME_, String DRIVER_CLASS_NAME_, String URL_, String USERNAME_, String PASSWORD_, String MEMO_, Date LAST_SYNC_DATE_, Integer ORDER_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql = "update OM_MAIN_SERVER set MAIN_SERVER_NAME_ = ?, DRIVER_CLASS_NAME_ = ?, URL_ = ?, USERNAME_ = ?, PASSWORD_ = ?, MEMO_ = ?, LAST_SYNC_DATE_ = ?, ORDER_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where MAIN_SERVER_ID_ = ?";
        return omJdbcTemplate.update(sql, MAIN_SERVER_NAME_, DRIVER_CLASS_NAME_, URL_, USERNAME_, PASSWORD_, MEMO_, LAST_SYNC_DATE_, ORDER_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, MAIN_SERVER_ID_);
    }

    @Override
    public int updateMainServerOrder(final List<String> MAIN_SERVER_ID_LIST, final List<Integer> ORDER_LIST, final Date UPDATE_DATE_, final String OPERATOR_ID_, final String OPERATOR_NAME_) {
        if (MAIN_SERVER_ID_LIST == null || MAIN_SERVER_ID_LIST.size() == 0) {
            return 0;
        }
        if (MAIN_SERVER_ID_LIST.size() != ORDER_LIST.size()) {
            return 0;
        }

        String sql = "update OM_MAIN_SERVER set ORDER_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where MAIN_SERVER_ID_ = ?";
        BatchPreparedStatementSetter batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, ORDER_LIST.get(i));
                ps.setTimestamp(2, UPDATE_DATE_ == null ? null : new java.sql.Timestamp(UPDATE_DATE_.getTime()));
                ps.setString(3, OPERATOR_ID_);
                ps.setString(4, OPERATOR_NAME_);
                ps.setString(5, MAIN_SERVER_ID_LIST.get(i));
            }

            public int getBatchSize() {
                return MAIN_SERVER_ID_LIST.size();
            }
        };

        return omJdbcTemplate.batchUpdate(sql, batch).length;
    }

    @Override
    public int disableMainServer(String MAIN_SERVER_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql = "update OM_MAIN_SERVER set MAIN_SERVER_STATUS_ = '0', UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where MAIN_SERVER_ID_ = ?";
        return omJdbcTemplate.update(sql, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, MAIN_SERVER_ID_);
    }

    @Override
    public int enableMainServer(String MAIN_SERVER_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql = "update OM_MAIN_SERVER set MAIN_SERVER_STATUS_ = '1', UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where MAIN_SERVER_ID_ = ?";
        return omJdbcTemplate.update(sql, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, MAIN_SERVER_ID_);
    }

    @Override
    public int deleteMainServer(String MAIN_SERVER_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql = "delete from OM_MAIN_SERVER where MAIN_SERVER_ID_ = ?";
        return omJdbcTemplate.update(sql, MAIN_SERVER_ID_);
    }
}