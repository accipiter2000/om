package com.opendynamic.om.vo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class Duty implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orgnSetId; // 组织架构套ID
    private String orgnSetCode; // 组织架构套编码
    private String orgnSetName; // 组织架构套名称
    private String dutyId; // 职务ID
    private String dutyCode; // 职务编码
    private String dutyName; // 职务名称
    private String dutyCategory; // 分类
    private String memo; // 备注
    private String dutyTag; // 职务标签
    private String dutyExtAttr1; // 职务扩展属性1
    private String dutyExtAttr2; // 职务扩展属性2
    private String dutyExtAttr3; // 职务扩展属性3
    private String dutyExtAttr4; // 职务扩展属性4
    private String dutyExtAttr5; // 职务扩展属性5
    private String dutyExtAttr6; // 职务扩展属性6
    private String dutyExtAttr7; // 职务扩展属性7
    private String dutyExtAttr8; // 职务扩展属性8
    private Integer order; // 排序
    private String dutyStatus; // 职务状态
    private Date creationDate; // 创建日期
    private Date updateDate; // 修改日期
    private String operatorId; // 操作人员ID
    private String operatorName; // 操作人员名称

    public Duty() {
    }

    public Duty(Map<String, Object> data) {// 通过数据库表加载
        this.orgnSetId = (String) data.get("ORGN_SET_ID_");
        this.orgnSetCode = (String) data.get("ORGN_SET_CODE_");
        this.orgnSetName = (String) data.get("ORGN_SET_NAME_");
        this.dutyId = (String) data.get("DUTY_ID_");
        this.dutyCode = (String) data.get("DUTY_CODE_");
        this.dutyName = (String) data.get("DUTY_NAME_");
        this.dutyCategory = (String) data.get("DUTY_CATEGORY_");
        this.memo = (String) data.get("MEMO_");
        this.dutyTag = (String) data.get("DUTY_TAG_");
        this.dutyExtAttr1 = (String) data.get("DUTY_EXT_ATTR_1_");
        this.dutyExtAttr2 = (String) data.get("DUTY_EXT_ATTR_2_");
        this.dutyExtAttr3 = (String) data.get("DUTY_EXT_ATTR_3_");
        this.dutyExtAttr4 = (String) data.get("DUTY_EXT_ATTR_4_");
        this.dutyExtAttr5 = (String) data.get("DUTY_EXT_ATTR_5_");
        this.dutyExtAttr6 = (String) data.get("DUTY_EXT_ATTR_6_");
        this.dutyExtAttr7 = (String) data.get("DUTY_EXT_ATTR_7_");
        this.dutyExtAttr8 = (String) data.get("DUTY_EXT_ATTR_8_");
        this.order = (data.get("ORDER_") != null) ? ((BigDecimal) data.get("ORDER_")).intValue() : null;
        this.dutyStatus = (String) data.get("DUTY_STATUS_");
        this.creationDate = (Date) data.get("CREATION_DATE_");
        this.updateDate = (Date) data.get("UPDATE_DATE_");
        this.operatorId = (String) data.get("OPERATOR_ID_");
        this.operatorName = (String) data.get("OPERATOR_NAME_");
    }

    public String getOrgnSetId() {
        return orgnSetId;
    }

    public void setOrgnSetId(String orgnSetId) {
        this.orgnSetId = orgnSetId;
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

    public String getDutyId() {
        return dutyId;
    }

    public void setDutyId(String dutyId) {
        this.dutyId = dutyId;
    }

    public String getDutyCode() {
        return dutyCode;
    }

    public void setDutyCode(String dutyCode) {
        this.dutyCode = dutyCode;
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    public String getDutyCategory() {
        return dutyCategory;
    }

    public void setDutyCategory(String dutyCategory) {
        this.dutyCategory = dutyCategory;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getDutyTag() {
        return dutyTag;
    }

    public void setDutyTag(String dutyTag) {
        this.dutyTag = dutyTag;
    }

    public String getDutyExtAttr1() {
        return dutyExtAttr1;
    }

    public void setDutyExtAttr1(String dutyExtAttr1) {
        this.dutyExtAttr1 = dutyExtAttr1;
    }

    public String getDutyExtAttr2() {
        return dutyExtAttr2;
    }

    public void setDutyExtAttr2(String dutyExtAttr2) {
        this.dutyExtAttr2 = dutyExtAttr2;
    }

    public String getDutyExtAttr3() {
        return dutyExtAttr3;
    }

    public void setDutyExtAttr3(String dutyExtAttr3) {
        this.dutyExtAttr3 = dutyExtAttr3;
    }

    public String getDutyExtAttr4() {
        return dutyExtAttr4;
    }

    public void setDutyExtAttr4(String dutyExtAttr4) {
        this.dutyExtAttr4 = dutyExtAttr4;
    }

    public String getDutyExtAttr5() {
        return dutyExtAttr5;
    }

    public void setDutyExtAttr5(String dutyExtAttr5) {
        this.dutyExtAttr5 = dutyExtAttr5;
    }

    public String getDutyExtAttr6() {
        return dutyExtAttr6;
    }

    public void setDutyExtAttr6(String dutyExtAttr6) {
        this.dutyExtAttr6 = dutyExtAttr6;
    }

    public String getDutyExtAttr7() {
        return dutyExtAttr7;
    }

    public void setDutyExtAttr7(String dutyExtAttr7) {
        this.dutyExtAttr7 = dutyExtAttr7;
    }

    public String getDutyExtAttr8() {
        return dutyExtAttr8;
    }

    public void setDutyExtAttr8(String dutyExtAttr8) {
        this.dutyExtAttr8 = dutyExtAttr8;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getDutyStatus() {
        return dutyStatus;
    }

    public void setDutyStatus(String dutyStatus) {
        this.dutyStatus = dutyStatus;
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