package com.opendynamic.om.vo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class Org implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orgnSetId; // 组织架构套ID
    private String orgnSetCode; // 组织架构套编码
    private String orgnSetName; // 组织架构套名称
    private String orgId; // 机构ID
    private String parentOrgId; // 上级机构ID
    private String orgCode; // 机构编码
    private String orgName; // 机构名称
    private String orgAbbrName; // 机构简称
    private String orgType; // 机构类型
    private String orgCategory; // 分类
    private String memo; // 备注
    private String orgTag; // 机构标签
    private String orgExtAttr1; // 机构扩展属性1
    private String orgExtAttr2; // 机构扩展属性2
    private String orgExtAttr3; // 机构扩展属性3
    private String orgExtAttr4; // 机构扩展属性4
    private String orgExtAttr5; // 机构扩展属性5
    private String orgExtAttr6; // 机构扩展属性6
    private String orgExtAttr7; // 机构扩展属性7
    private String orgExtAttr8; // 机构扩展属性8
    private Integer order; // 排序
    private String orgStatus; // 机构状态
    private Date creationDate; // 创建日期
    private Date updateDate; // 修改日期
    private String operatorId; // 操作人员ID
    private String operatorName; // 操作人员名称
    private String parentOrgCode; // 上级机构编码
    private String parentOrgName; // 上级机构名称

    public Org() {
    }

    public Org(Map<String, Object> data) {// 通过数据库表加载
        this.orgnSetId = (String) data.get("ORGN_SET_ID_");
        this.orgnSetCode = (String) data.get("ORGN_SET_CODE_");
        this.orgnSetName = (String) data.get("ORGN_SET_NAME_");
        this.orgId = (String) data.get("ORG_ID_");
        this.parentOrgId = (String) data.get("PARENT_ORG_ID_");
        this.orgCode = (String) data.get("ORG_CODE_");
        this.orgName = (String) data.get("ORG_NAME_");
        this.orgAbbrName = (String) data.get("ORG_ABBR_NAME_");
        this.orgType = (String) data.get("ORG_TYPE_");
        this.orgCategory = (String) data.get("ORG_CATEGORY_");
        this.memo = (String) data.get("MEMO_");
        this.orgTag = (String) data.get("ORG_TAG_");
        this.orgExtAttr1 = (String) data.get("ORG_EXT_ATTR_1_");
        this.orgExtAttr2 = (String) data.get("ORG_EXT_ATTR_2_");
        this.orgExtAttr3 = (String) data.get("ORG_EXT_ATTR_3_");
        this.orgExtAttr4 = (String) data.get("ORG_EXT_ATTR_4_");
        this.orgExtAttr5 = (String) data.get("ORG_EXT_ATTR_5_");
        this.orgExtAttr6 = (String) data.get("ORG_EXT_ATTR_6_");
        this.orgExtAttr7 = (String) data.get("ORG_EXT_ATTR_7_");
        this.orgExtAttr8 = (String) data.get("ORG_EXT_ATTR_8_");
        this.order = (data.get("ORDER_") != null) ? ((BigDecimal) data.get("ORDER_")).intValue() : null;
        this.orgStatus = (String) data.get("ORG_STATUS_");
        this.creationDate = (Date) data.get("CREATION_DATE_");
        this.updateDate = (Date) data.get("UPDATE_DATE_");
        this.operatorId = (String) data.get("OPERATOR_ID_");
        this.operatorName = (String) data.get("OPERATOR_NAME_");
        this.parentOrgCode = (String) data.get("PARENT_ORG_CODE_");
        this.parentOrgName = (String) data.get("PARENT_ORG_NAME_");
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

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgAbbrName() {
        return orgAbbrName;
    }

    public void setOrgAbbrName(String orgAbbrName) {
        this.orgAbbrName = orgAbbrName;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getOrgCategory() {
        return orgCategory;
    }

    public void setOrgCategory(String orgCategory) {
        this.orgCategory = orgCategory;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOrgTag() {
        return orgTag;
    }

    public void setOrgTag(String orgTag) {
        this.orgTag = orgTag;
    }

    public String getOrgExtAttr1() {
        return orgExtAttr1;
    }

    public void setOrgExtAttr1(String orgExtAttr1) {
        this.orgExtAttr1 = orgExtAttr1;
    }

    public String getOrgExtAttr2() {
        return orgExtAttr2;
    }

    public void setOrgExtAttr2(String orgExtAttr2) {
        this.orgExtAttr2 = orgExtAttr2;
    }

    public String getOrgExtAttr3() {
        return orgExtAttr3;
    }

    public void setOrgExtAttr3(String orgExtAttr3) {
        this.orgExtAttr3 = orgExtAttr3;
    }

    public String getOrgExtAttr4() {
        return orgExtAttr4;
    }

    public void setOrgExtAttr4(String orgExtAttr4) {
        this.orgExtAttr4 = orgExtAttr4;
    }

    public String getOrgExtAttr5() {
        return orgExtAttr5;
    }

    public void setOrgExtAttr5(String orgExtAttr5) {
        this.orgExtAttr5 = orgExtAttr5;
    }

    public String getOrgExtAttr6() {
        return orgExtAttr6;
    }

    public void setOrgExtAttr6(String orgExtAttr6) {
        this.orgExtAttr6 = orgExtAttr6;
    }

    public String getOrgExtAttr7() {
        return orgExtAttr7;
    }

    public void setOrgExtAttr7(String orgExtAttr7) {
        this.orgExtAttr7 = orgExtAttr7;
    }

    public String getOrgExtAttr8() {
        return orgExtAttr8;
    }

    public void setOrgExtAttr8(String orgExtAttr8) {
        this.orgExtAttr8 = orgExtAttr8;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus;
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

    public String getParentOrgCode() {
        return parentOrgCode;
    }

    public void setParentOrgCode(String parentOrgCode) {
        this.parentOrgCode = parentOrgCode;
    }

    public String getParentOrgName() {
        return parentOrgName;
    }

    public void setParentOrgName(String parentOrgName) {
        this.parentOrgName = parentOrgName;
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