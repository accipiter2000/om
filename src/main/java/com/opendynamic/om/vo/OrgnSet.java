package com.opendynamic.om.vo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class OrgnSet implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orgnSetId; // 组织架构套ID
    private String parentOrgnSetId; // 上级组织架构套ID
    private String orgnSetCode; // 组织架构套编码
    private String orgnSetName; // 组织架构套名称
    private String allowSync; // 允许同步
    private String memo; // 备注
    private Integer order; // 排序
    private String orgnSetStatus; // 组织架构套状态
    private Date creationDate; // 创建日期
    private Date updateDate; // 修改日期
    private String operatorId; // 操作人员ID
    private String operatorName; // 操作人员名称
    private String parentOrgnSetCode; // 上级组织架构套编码
    private String parentOrgnSetName; // 上级组织架构套名称

    public OrgnSet() {
    }

    public OrgnSet(Map<String, Object> data) {// 通过数据库表加载
        this.orgnSetId = (String) data.get("ORGN_SET_ID_");
        this.parentOrgnSetId = (String) data.get("PARENT_ORGN_SET_ID_");
        this.orgnSetCode = (String) data.get("ORGN_SET_CODE_");
        this.orgnSetName = (String) data.get("ORGN_SET_NAME_");
        this.allowSync = (String) data.get("ALLOW_SYNC_");
        this.memo = (String) data.get("MEMO_");
        this.order = (data.get("ORDER_") != null) ? ((BigDecimal) data.get("ORDER_")).intValue() : null;
        this.orgnSetStatus = (String) data.get("ORGN_SET_STATUS_");
        this.creationDate = (Date) data.get("CREATION_DATE_");
        this.updateDate = (Date) data.get("UPDATE_DATE_");
        this.operatorId = (String) data.get("OPERATOR_ID_");
        this.operatorName = (String) data.get("OPERATOR_NAME_");
        this.parentOrgnSetCode = (String) data.get("PARENT_ORGN_SET_CODE_");
        this.parentOrgnSetName = (String) data.get("PARENT_ORGN_SET_NAME_");
    }

    public String getOrgnSetId() {
        return orgnSetId;
    }

    public void setOrgnSetId(String orgnSetId) {
        this.orgnSetId = orgnSetId;
    }

    public String getParentOrgnSetId() {
        return parentOrgnSetId;
    }

    public void setParentOrgnSetId(String parentOrgnSetId) {
        this.parentOrgnSetId = parentOrgnSetId;
    }

    public String getOrgnSetCode() {
        return orgnSetCode;
    }

    public void setOrgnSetCode(String orgnSetCode) {
        this.orgnSetCode = orgnSetCode;
    }

    public String getOrgnSetName() {
        return orgnSetName;
    }

    public void setOrgnSetName(String orgnSetName) {
        this.orgnSetName = orgnSetName;
    }

    public String getAllowSync() {
        return allowSync;
    }

    public void setAllowSync(String allowSync) {
        this.allowSync = allowSync;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getOrgnSetStatus() {
        return orgnSetStatus;
    }

    public void setOrgnSetStatus(String orgnSetStatus) {
        this.orgnSetStatus = orgnSetStatus;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getParentOrgnSetCode() {
        return parentOrgnSetCode;
    }

    public void setParentOrgnSetCode(String parentOrgnSetCode) {
        this.parentOrgnSetCode = parentOrgnSetCode;
    }

    public String getParentOrgnSetName() {
        return parentOrgnSetName;
    }

    public void setParentOrgnSetName(String parentOrgnSetName) {
        this.parentOrgnSetName = parentOrgnSetName;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(2000);

        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            try {
                if (!fieldName.equals("serialVersionUID")) {
                    Method getter = this.getClass().getMethod("get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1));
                    Object value = getter.invoke(this);
                    stringBuilder.append(fieldName).append("=").append(value).append(",");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return stringBuilder.toString();
    }
}