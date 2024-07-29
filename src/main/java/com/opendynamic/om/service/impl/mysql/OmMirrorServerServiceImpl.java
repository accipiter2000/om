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
import com.opendynamic.om.service.OmMirrorServerService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OmMirrorServerServiceImpl implements OmMirrorServerService {
    @Autowired
    private JdbcTemplate omJdbcTemplate;

    @Override
    public Map<String, Object> loadMirrorServer(String MIRROR_SERVER_ID_) {
        String sql = "select * from OMV_MIRROR_SERVER where MIRROR_SERVER_ID_ = ?";
        List<Map<String, Object>> result = omJdbcTemplate.queryForList(sql, MIRROR_SERVER_ID_);
        if (result.size() == 1) {
            return result.get(0);
        }
        else {
            return null;
        }
    }

    @Override
    public List<Map<String, Object>> selectMirrorServer(String MIRROR_SERVER_ID_, String MIRROR_SERVER_NAME_, List<String> MIRROR_SERVER_STATUS_LIST, Integer page, Integer limit) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaMirrorServer(false, MIRROR_SERVER_ID_, MIRROR_SERVER_NAME_, MIRROR_SERVER_STATUS_LIST);// 根据查询条件组装查询SQL语句
        String sql = odSqlCriteria.getSql();
        Map<String, Object> paramMap = odSqlCriteria.getParamMap();

        if (page != null && limit != null && limit > 0) {// 分页
            sql = sql + " limit " + (page - 1) * limit + ", " + limit;
        }

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForList(sql, paramMap);
    }

    @Override
    public int countMirrorServer(String MIRROR_SERVER_ID_, String MIRROR_SERVER_NAME_, List<String> MIRROR_SERVER_STATUS_LIST) {
        OdSqlCriteria odSqlCriteria = buildSqlCriteriaMirrorServer(true, MIRROR_SERVER_ID_, MIRROR_SERVER_NAME_, MIRROR_SERVER_STATUS_LIST);// 根据查询条件组装总数查询SQL语句
        String sql = odSqlCriteria.getSql();
        Map<String, Object> paramMap = odSqlCriteria.getParamMap();

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(omJdbcTemplate);
        return namedParameterJdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    private OdSqlCriteria buildSqlCriteriaMirrorServer(boolean count, String MIRROR_SERVER_ID_, String MIRROR_SERVER_NAME_, List<String> MIRROR_SERVER_STATUS_LIST) {// 组装查询SQL语句
        String sql;
        Map<String, Object> paramMap = new HashMap<>();

        if (count) {
            sql = "select count(*) from OMV_MIRROR_SERVER where 1 = 1";
        }
        else {
            sql = "select * from OMV_MIRROR_SERVER where 1 = 1";
        }

        if (StringUtils.isNotEmpty(MIRROR_SERVER_ID_)) {
            sql += " and MIRROR_SERVER_ID_ = :MIRROR_SERVER_ID_";
            paramMap.put("MIRROR_SERVER_ID_", MIRROR_SERVER_ID_);
        }
        if (StringUtils.isNotEmpty(MIRROR_SERVER_NAME_)) {
            sql += " and MIRROR_SERVER_NAME_ like concat('%',:MIRROR_SERVER_NAME_,'%')";
            paramMap.put("MIRROR_SERVER_NAME_", MIRROR_SERVER_NAME_);
        }
        if (MIRROR_SERVER_STATUS_LIST != null && !MIRROR_SERVER_STATUS_LIST.isEmpty()) {
            sql += " and MIRROR_SERVER_STATUS_ in (:MIRROR_SERVER_STATUS_LIST)";
            paramMap.put("MIRROR_SERVER_STATUS_LIST", MIRROR_SERVER_STATUS_LIST);
        }

        if (!count) {
            sql += " order by ORDER_, MIRROR_SERVER_ID_";
        }

        return new OdSqlCriteria(sql, paramMap);
    }

    @Override
    public List<Map<String, Object>> selectMirrorServerByIdList(List<String> MIRROR_SERVER_ID_LIST) {
        if (MIRROR_SERVER_ID_LIST == null || MIRROR_SERVER_ID_LIST.isEmpty()) {
            return new ArrayList<>();
        }

        StringBuilder sql = new StringBuilder(MIRROR_SERVER_ID_LIST.size() * 50 + 200);
        Map<String, Object> paramMap = new HashMap<>();

        sql.append("select * from OMV_MIRROR_SERVER where MIRROR_SERVER_ID_ in (:MIRROR_SERVER_ID_LIST)");
        paramMap.put("MIRROR_SERVER_ID_LIST", MIRROR_SERVER_ID_LIST);
        sql.append(" order by FIELD(MIRROR_SERVER_ID_,");// 按主键列表顺序排序
        for (int i = 0; i < MIRROR_SERVER_ID_LIST.size(); i++) {
            sql.append(" '").append(MIRROR_SERVER_ID_LIST.get(i)).append("'");
            if (i < MIRROR_SERVER_ID_LIST.size() - 1) {
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
    public int insertMirrorServer(String MIRROR_SERVER_ID_, String MIRROR_SERVER_NAME_, String DRIVER_CLASS_NAME_, String URL_, String USERNAME_, String PASSWORD_, String MEMO_, Date LAST_SYNC_DATE_, Integer ORDER_, String MIRROR_SERVER_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql = "insert into OM_MIRROR_SERVER (MIRROR_SERVER_ID_, MIRROR_SERVER_NAME_, DRIVER_CLASS_NAME_, URL_, USERNAME_, PASSWORD_, MEMO_, LAST_SYNC_DATE_, ORDER_, MIRROR_SERVER_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return omJdbcTemplate.update(sql, MIRROR_SERVER_ID_, MIRROR_SERVER_NAME_, DRIVER_CLASS_NAME_, URL_, USERNAME_, PASSWORD_, MEMO_, LAST_SYNC_DATE_, ORDER_, MIRROR_SERVER_STATUS_, CREATION_DATE_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_);
    }

    @Override
    public int updateMirrorServer(String MIRROR_SERVER_ID_, String MIRROR_SERVER_NAME_, String DRIVER_CLASS_NAME_, String URL_, String USERNAME_, String PASSWORD_, String MEMO_, Date LAST_SYNC_DATE_, Integer ORDER_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql = "update OM_MIRROR_SERVER set MIRROR_SERVER_NAME_ = ?, DRIVER_CLASS_NAME_ = ?, URL_ = ?, USERNAME_ = ?, PASSWORD_ = ?, MEMO_ = ?, LAST_SYNC_DATE_ = ?, ORDER_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where MIRROR_SERVER_ID_ = ?";
        return omJdbcTemplate.update(sql, MIRROR_SERVER_NAME_, DRIVER_CLASS_NAME_, URL_, USERNAME_, PASSWORD_, MEMO_, LAST_SYNC_DATE_, ORDER_, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, MIRROR_SERVER_ID_);
    }

    @Override
    public int updateMirrorServerOrder(final List<String> MIRROR_SERVER_ID_LIST, final List<Integer> ORDER_LIST, final Date UPDATE_DATE_, final String OPERATOR_ID_, final String OPERATOR_NAME_) {
        if (MIRROR_SERVER_ID_LIST == null || MIRROR_SERVER_ID_LIST.isEmpty()) {
            return 0;
        }
        if (MIRROR_SERVER_ID_LIST.size() != ORDER_LIST.size()) {
            return 0;
        }

        String sql = "update OM_MIRROR_SERVER set ORDER_ = ?, UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where MIRROR_SERVER_ID_ = ?";
        BatchPreparedStatementSetter batch = new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, ORDER_LIST.get(i));
                ps.setTimestamp(2, UPDATE_DATE_ == null ? null : new java.sql.Timestamp(UPDATE_DATE_.getTime()));
                ps.setString(3, OPERATOR_ID_);
                ps.setString(4, OPERATOR_NAME_);
                ps.setString(5, MIRROR_SERVER_ID_LIST.get(i));
            }

            public int getBatchSize() {
                return MIRROR_SERVER_ID_LIST.size();
            }
        };

        return omJdbcTemplate.batchUpdate(sql, batch).length;
    }

    @Override
    public int disableMirrorServer(String MIRROR_SERVER_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql = "update OM_MIRROR_SERVER set MIRROR_SERVER_STATUS_ = '0', UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where MIRROR_SERVER_ID_ = ?";
        return omJdbcTemplate.update(sql, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, MIRROR_SERVER_ID_);
    }

    @Override
    public int enableMirrorServer(String MIRROR_SERVER_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql = "update OM_MIRROR_SERVER set MIRROR_SERVER_STATUS_ = '1', UPDATE_DATE_ = ?, OPERATOR_ID_ = ?, OPERATOR_NAME_ = ? where MIRROR_SERVER_ID_ = ?";
        return omJdbcTemplate.update(sql, UPDATE_DATE_, OPERATOR_ID_, OPERATOR_NAME_, MIRROR_SERVER_ID_);
    }

    @Override
    public int deleteMirrorServer(String MIRROR_SERVER_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_) {
        String sql = "delete from OM_MIRROR_SERVER where MIRROR_SERVER_ID_ = ?";
        return omJdbcTemplate.update(sql, MIRROR_SERVER_ID_);
    }
}