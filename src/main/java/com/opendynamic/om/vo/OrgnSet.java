package com.opendynamic.om.vo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class OrgnSet implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orgnSetId; // 组织架构套ID。
    private String parentOrgnSetId; // 上级组织架构套ID。
    private String orgnSetCode; // 组织架构套编码。
    private String orgnSetName; // 组织架构套名称。
    private String allowSync; // 允许同步。
    private String memo; // 备注。
    private Integer order; // 排序。
    private String orgnSetStatus; // 组织架构套状态。
    private Date creationDate; // 创建日期。
    private Date updateDate; // 修改日期。
    private String operatorId; // 操作人员ID。
    private String operatorName; // 操作人员名称。
    private String parentOrgnSetCode; // 上级组织架构套编码。
    private String parentOrgnSetName; // 上级组织架构套名称。

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

    /**
     * 获取组织架构套ID。
     * 
     * @return 组织架构套ID。
     */
    public String getOrgnSetId() {
        return orgnSetId;
    }

    /**
     * 设置组织架构套ID。
     * 
     * @param orgnSetId
     *        组织架构套ID。
     */
    public void setOrgnSetId(String orgnSetId) {
        this.orgnSetId = orgnSetId;
    }

    /**
     * 获取上级组织架构套ID。
     * 
     * @return 上级组织架构套ID。
     */
    public String getParentOrgnSetId() {
        return parentOrgnSetId;
    }

    /**
     * 设置上级组织架构套ID。
     * 
     * @param parentOrgnSetId
     *        上级组织架构套ID。
     */
    public void setParentOrgnSetId(String parentOrgnSetId) {
        this.parentOrgnSetId = parentOrgnSetId;
    }

    /**
     * 获取组织架构套编码。
     * 
     * @return 组织架构套编码。
     */
    public String getOrgnSetCode() {
        return orgnSetCode;
    }

    /**
     * 设置组织架构套编码。
     * 
     * @param orgnSetCode
     *        组织架构套编码。
     */
    public void setOrgnSetCode(String orgnSetCode) {
        this.orgnSetCode = orgnSetCode;
    }

    /**
     * 获取组织架构套名称。
     * 
     * @return 组织架构套名称。
     */
    public String getOrgnSetName() {
        return orgnSetName;
    }

    /**
     * 组织架构套名称。 设置
     * 
     * @param orgnSetName
     *        组织架构套名称。
     */
    public void setOrgnSetName(String orgnSetName) {
        this.orgnSetName = orgnSetName;
    }

    /**
     * 获取允许同步。
     * 
     * @return 允许同步。
     */
    public String getAllowSync() {
        return allowSync;
    }

    /**
     * 设置允许同步。
     * 
     * @param allowSync
     *        允许同步。
     */
    public void setAllowSync(String allowSync) {
        this.allowSync = allowSync;
    }

    /**
     * 获取备注。
     * 
     * @return 备注。
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注。
     * 
     * @param memo
     *        备注。
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * 获取排序。
     * 
     * @return 排序。
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * 设置排序。
     * 
     * @param order
     *        排序。
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * 获取组织架构套状态。
     * 
     * @return 组织架构套状态。
     */
    public String getOrgnSetStatus() {
        return orgnSetStatus;
    }

    /**
     * 设置组织架构套状态。
     * 
     * @param orgnSetStatus
     *        组织架构套状态。
     */
    public void setOrgnSetStatus(String orgnSetStatus) {
        this.orgnSetStatus = orgnSetStatus;
    }

    /**
     * 获取创建日期。
     * 
     * @return 创建日期。
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * 设置创建日期。
     * 
     * @param creationDate
     *        创建日期。
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * 获取修改日期。
     * 
     * @return 修改日期。
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置修改日期。
     * 
     * @param updateDate
     *        修改日期。
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取操作人员ID。
     * 
     * @return 操作人员ID。
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * 设置操作人员ID。
     * 
     * @param operatorId
     *        操作人员ID。
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * 获取操作人员名称。
     * 
     * @return 操作人员名称。
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * 设置操作人员名称。
     * 
     * @param operatorName
     *        操作人员名称。
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    /**
     * 获取上级组织架构套编码。
     * 
     * @return 上级组织架构套编码。
     */
    public String getParentOrgnSetCode() {
        return parentOrgnSetCode;
    }

    /**
     * 设置上级组织架构套编码。
     * 
     * @param parentOrgnSetCode
     *        上级组织架构套编码。
     */
    public void setParentOrgnSetCode(String parentOrgnSetCode) {
        this.parentOrgnSetCode = parentOrgnSetCode;
    }

    /**
     * 获取上级组织架构套名称。
     * 
     * @return 上级组织架构套名称。
     */
    public String getParentOrgnSetName() {
        return parentOrgnSetName;
    }

    /**
     * 设置上级组织架构套名称。
     * 
     * @param parentOrgnSetName
     *        上级组织架构套名称。
     */
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