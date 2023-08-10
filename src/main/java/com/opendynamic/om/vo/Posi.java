package com.opendynamic.om.vo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class Posi implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orgnSetId; // 组织架构套ID
    private String orgnSetCode; // 组织架构套编码
    private String orgnSetName;// 组织架构套名称
    private String posiId; // 岗位ID
    private String posiCode; // 岗位编码
    private String posiName; // 岗位名称
    private String orgLeaderType; // 机构领导类型
    private String posiCategory; // 分类
    private String memo; // 备注
    private String posiTag; // 岗位标签
    private String posiExtAttr1; // 岗位扩展属性1
    private String posiExtAttr2; // 岗位扩展属性2
    private String posiExtAttr3; // 岗位扩展属性3
    private String posiExtAttr4; // 岗位扩展属性4
    private String posiExtAttr5; // 岗位扩展属性5
    private String posiExtAttr6; // 岗位扩展属性6
    private String posiExtAttr7; // 岗位扩展属性7
    private String posiExtAttr8; // 岗位扩展属性8
    private Integer order; // 排序
    private String posiStatus; // 岗位状态
    private Date creationDate; // 创建日期
    private Date updateDate; // 修改日期
    private String operatorId; // 操作人员ID
    private String operatorName; // 操作人员名称
    private String dutyId; // 职务ID
    private String dutyCode; // 职务编码
    private String dutyName; // 职务名称
    private String dutyCategory; // 分类
    private String dutyTag; // 职务标签
    private String dutyExtAttr1; // 职务扩展属性1
    private String dutyExtAttr2; // 职务扩展属性2
    private String dutyExtAttr3; // 职务扩展属性3
    private String dutyExtAttr4; // 职务扩展属性4
    private String dutyExtAttr5; // 职务扩展属性5
    private String dutyExtAttr6; // 职务扩展属性6
    private String dutyExtAttr7; // 职务扩展属性7
    private String dutyExtAttr8; // 职务扩展属性8
    private String dutyStatus; // 职务状态
    private String orgId; // 机构ID
    private String parentOrgId; // 上级机构ID
    private String orgCode; // 机构编码
    private String orgName; // 机构名称
    private String orgAbbrName; // 机构简称
    private String orgType; // 机构类型
    private String orgCategory; // 分类
    private String orgTag; // 机构标签
    private String orgExtAttr1; // 机构扩展属性1
    private String orgExtAttr2; // 机构扩展属性2
    private String orgExtAttr3; // 机构扩展属性3
    private String orgExtAttr4; // 机构扩展属性4
    private String orgExtAttr5; // 机构扩展属性5
    private String orgExtAttr6; // 机构扩展属性6
    private String orgExtAttr7; // 机构扩展属性7
    private String orgExtAttr8; // 机构扩展属性8
    private String orgStatus; // 机构状态
    private String parentOrgCode; // 上级机构编码
    private String parentOrgName; // 上级机构名称

    public Posi() {
    }

    public Posi(Map<String, Object> data) {// 通过数据库表加载
        this.orgnSetId = (String) data.get("ORGN_SET_ID_");
        this.orgnSetCode = (String) data.get("ORGN_SET_CODE_");
        this.orgnSetName = (String) data.get("ORGN_SET_NAME_");
        this.posiId = (String) data.get("POSI_ID_");
        this.posiCode = (String) data.get("POSI_CODE_");
        this.posiName = (String) data.get("POSI_NAME_");
        this.orgLeaderType = (String) data.get("ORG_LEADER_TYPE_");
        this.posiCategory = (String) data.get("POSI_CATEGORY_");
        this.memo = (String) data.get("MEMO_");
        this.posiTag = (String) data.get("POSI_TAG_");
        this.posiExtAttr1 = (String) data.get("POSI_EXT_ATTR_1_");
        this.posiExtAttr2 = (String) data.get("POSI_EXT_ATTR_2_");
        this.posiExtAttr3 = (String) data.get("POSI_EXT_ATTR_3_");
        this.posiExtAttr4 = (String) data.get("POSI_EXT_ATTR_4_");
        this.posiExtAttr5 = (String) data.get("POSI_EXT_ATTR_5_");
        this.posiExtAttr6 = (String) data.get("POSI_EXT_ATTR_6_");
        this.posiExtAttr7 = (String) data.get("POSI_EXT_ATTR_7_");
        this.posiExtAttr8 = (String) data.get("POSI_EXT_ATTR_8_");
        this.order = (data.get("ORDER_") != null) ? ((BigDecimal) data.get("ORDER_")).intValue() : null;
        this.posiStatus = (String) data.get("POSI_STATUS_");
        this.creationDate = (Date) data.get("CREATION_DATE_");
        this.updateDate = (Date) data.get("UPDATE_DATE_");
        this.operatorId = (String) data.get("OPERATOR_ID_");
        this.operatorName = (String) data.get("OPERATOR_NAME_");
        this.dutyId = (String) data.get("DUTY_ID_");
        this.dutyCode = (String) data.get("DUTY_CODE_");
        this.dutyName = (String) data.get("DUTY_NAME_");
        this.dutyCategory = (String) data.get("DUTY_CATEGORY_");
        this.dutyTag = (String) data.get("DUTY_TAG_");
        this.dutyExtAttr1 = (String) data.get("DUTY_EXT_ATTR_1_");
        this.dutyExtAttr2 = (String) data.get("DUTY_EXT_ATTR_2_");
        this.dutyExtAttr3 = (String) data.get("DUTY_EXT_ATTR_3_");
        this.dutyExtAttr4 = (String) data.get("DUTY_EXT_ATTR_4_");
        this.dutyExtAttr5 = (String) data.get("DUTY_EXT_ATTR_5_");
        this.dutyExtAttr6 = (String) data.get("DUTY_EXT_ATTR_6_");
        this.dutyExtAttr7 = (String) data.get("DUTY_EXT_ATTR_7_");
        this.dutyExtAttr8 = (String) data.get("DUTY_EXT_ATTR_8_");
        this.dutyStatus = (String) data.get("DUTY_STATUS_");
        this.orgId = (String) data.get("ORG_ID_");
        this.parentOrgId = (String) data.get("PARENT_ORG_ID_");
        this.orgCode = (String) data.get("ORG_CODE_");
        this.orgName = (String) data.get("ORG_NAME_");
        this.orgAbbrName = (String) data.get("ORG_ABBR_NAME_");
        this.orgType = (String) data.get("ORG_TYPE_");
        this.orgCategory = (String) data.get("ORG_CATEGORY_");
        this.orgTag = (String) data.get("ORG_TAG_");
        this.orgExtAttr1 = (String) data.get("ORG_EXT_ATTR_1_");
        this.orgExtAttr2 = (String) data.get("ORG_EXT_ATTR_2_");
        this.orgExtAttr3 = (String) data.get("ORG_EXT_ATTR_3_");
        this.orgExtAttr4 = (String) data.get("ORG_EXT_ATTR_4_");
        this.orgExtAttr5 = (String) data.get("ORG_EXT_ATTR_5_");
        this.orgExtAttr6 = (String) data.get("ORG_EXT_ATTR_6_");
        this.orgExtAttr7 = (String) data.get("ORG_EXT_ATTR_7_");
        this.orgExtAttr8 = (String) data.get("ORG_EXT_ATTR_8_");
        this.orgStatus = (String) data.get("ORG_STATUS_");
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

    public String getPosiId() {
        return posiId;
    }

    public void setPosiId(String posiId) {
        this.posiId = posiId;
    }

    public String getPosiCode() {
        return posiCode;
    }

    public void setPosiCode(String posiCode) {
        this.posiCode = posiCode;
    }

    public String getPosiName() {
        return posiName;
    }

    public void setPosiName(String posiName) {
        this.posiName = posiName;
    }

    public String getOrgLeaderType() {
        return orgLeaderType;
    }

    public void setOrgLeaderType(String orgLeaderType) {
        this.orgLeaderType = orgLeaderType;
    }

    public String getPosiCategory() {
        return posiCategory;
    }

    public void setPosiCategory(String posiCategory) {
        this.posiCategory = posiCategory;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getPosiTag() {
        return posiTag;
    }

    public void setPosiTag(String posiTag) {
        this.posiTag = posiTag;
    }

    public String getPosiExtAttr1() {
        return posiExtAttr1;
    }

    public void setPosiExtAttr1(String posiExtAttr1) {
        this.posiExtAttr1 = posiExtAttr1;
    }

    public String getPosiExtAttr2() {
        return posiExtAttr2;
    }

    public void setPosiExtAttr2(String posiExtAttr2) {
        this.posiExtAttr2 = posiExtAttr2;
    }

    public String getPosiExtAttr3() {
        return posiExtAttr3;
    }

    public void setPosiExtAttr3(String posiExtAttr3) {
        this.posiExtAttr3 = posiExtAttr3;
    }

    public String getPosiExtAttr4() {
        return posiExtAttr4;
    }

    public void setPosiExtAttr4(String posiExtAttr4) {
        this.posiExtAttr4 = posiExtAttr4;
    }

    public String getPosiExtAttr5() {
        return posiExtAttr5;
    }

    public void setPosiExtAttr5(String posiExtAttr5) {
        this.posiExtAttr5 = posiExtAttr5;
    }

    public String getPosiExtAttr6() {
        return posiExtAttr6;
    }

    public void setPosiExtAttr6(String posiExtAttr6) {
        this.posiExtAttr6 = posiExtAttr6;
    }

    public String getPosiExtAttr7() {
        return posiExtAttr7;
    }

    public void setPosiExtAttr7(String posiExtAttr7) {
        this.posiExtAttr7 = posiExtAttr7;
    }

    public String getPosiExtAttr8() {
        return posiExtAttr8;
    }

    public void setPosiExtAttr8(String posiExtAttr8) {
        this.posiExtAttr8 = posiExtAttr8;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getPosiStatus() {
        return posiStatus;
    }

    public void setPosiStatus(String posiStatus) {
        this.posiStatus = posiStatus;
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

    public String getDutyStatus() {
        return dutyStatus;
    }

    public void setDutyStatus(String dutyStatus) {
        this.dutyStatus = dutyStatus;
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

    public String getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus;
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
        StringBuilder stringBuilder = new StringBuilder(3000);

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