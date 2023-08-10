package com.opendynamic.om.vo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class Emp implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orgnSetId; // 组织架构套ID
    private String orgnSetCode; // 组织架构套编码
    private String orgnSetName; // 组织架构套名称
    private String empId; // 人员ID
    private String empCode; // 人员编码
    private String empName; // 人员名称
    private String passwordResetReq; // 密码重置
    private String party; // 政治面貌
    private String empLevel; // 职级
    private String gender; // 性别
    private Date birthDate; // 出生日期
    private String tel; // 电话
    private String email; // 电子邮箱
    private Date inDate; // 入职日期
    private Date outDate; // 离职日期
    private String empCategory; // 分类
    private String memo; // 备注
    private String empTag; // 人员标签
    private String empExtAttr1; // 人员扩展属性1
    private String empExtAttr2; // 人员扩展属性2
    private String empExtAttr3; // 人员扩展属性3
    private String empExtAttr4; // 人员扩展属性4
    private String empExtAttr5; // 人员扩展属性5
    private String empExtAttr6; // 人员扩展属性6
    private String empExtAttr7; // 人员扩展属性7
    private String empExtAttr8; // 人员扩展属性8
    private Integer order; // 排序
    private String empStatus; // 人员状态
    private Date creationDate; // 创建日期
    private Date updateDate; // 更新日期
    private String operatorId; // 操作人员ID
    private String operatorName; // 操作人员名称
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

    public Emp() {
    }

    public Emp(Map<String, Object> data) {// 通过数据库表加载
        this.orgnSetId = (String) data.get("ORGN_SET_ID_");
        this.orgnSetCode = (String) data.get("ORGN_SET_CODE_");
        this.orgnSetName = (String) data.get("ORGN_SET_NAME_");
        this.empId = (String) data.get("EMP_ID_");
        this.empCode = (String) data.get("EMP_CODE_");
        this.empName = (String) data.get("EMP_NAME_");
        this.passwordResetReq = (String) data.get("PASSWORD_RESET_REQ_");
        this.party = (String) data.get("PARTY_");
        this.empLevel = (String) data.get("EMP_LEVEL_");
        this.gender = (String) data.get("GENDER_");
        this.birthDate = (Date) data.get("BIRTH_DATE_");
        this.tel = (String) data.get("TEL_");
        this.email = (String) data.get("EMAIL_");
        this.inDate = (Date) data.get("IN_DATE_");
        this.outDate = (Date) data.get("OUT_DATE_");
        this.empCategory = (String) data.get("EMP_CATEGORY_");
        this.memo = (String) data.get("MEMO_");
        this.empTag = (String) data.get("EMP_TAG_");
        this.empExtAttr1 = (String) data.get("EMP_EXT_ATTR_1_");
        this.empExtAttr2 = (String) data.get("EMP_EXT_ATTR_2_");
        this.empExtAttr3 = (String) data.get("EMP_EXT_ATTR_3_");
        this.empExtAttr4 = (String) data.get("EMP_EXT_ATTR_4_");
        this.empExtAttr5 = (String) data.get("EMP_EXT_ATTR_5_");
        this.empExtAttr6 = (String) data.get("EMP_EXT_ATTR_6_");
        this.empExtAttr7 = (String) data.get("EMP_EXT_ATTR_7_");
        this.empExtAttr8 = (String) data.get("EMP_EXT_ATTR_8_");
        this.order = (data.get("ORDER_") != null) ? ((BigDecimal) data.get("ORDER_")).intValue() : null;
        this.empStatus = (String) data.get("EMP_STATUS_");
        this.creationDate = (Date) data.get("CREATION_DATE_");
        this.updateDate = (Date) data.get("UPDATE_DATE_");
        this.operatorId = (String) data.get("OPERATOR_ID_");
        this.operatorName = (String) data.get("OPERATOR_NAME_");
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

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPasswordResetReq() {
        return passwordResetReq;
    }

    public void setPasswordResetReq(String passwordResetReq) {
        this.passwordResetReq = passwordResetReq;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getEmpLevel() {
        return empLevel;
    }

    public void setEmpLevel(String empLevel) {
        this.empLevel = empLevel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getEmpCategory() {
        return empCategory;
    }

    public void setEmpCategory(String empCategory) {
        this.empCategory = empCategory;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getEmpTag() {
        return empTag;
    }

    public void setEmpTag(String empTag) {
        this.empTag = empTag;
    }

    public String getEmpExtAttr1() {
        return empExtAttr1;
    }

    public void setEmpExtAttr1(String empExtAttr1) {
        this.empExtAttr1 = empExtAttr1;
    }

    public String getEmpExtAttr2() {
        return empExtAttr2;
    }

    public void setEmpExtAttr2(String empExtAttr2) {
        this.empExtAttr2 = empExtAttr2;
    }

    public String getEmpExtAttr3() {
        return empExtAttr3;
    }

    public void setEmpExtAttr3(String empExtAttr3) {
        this.empExtAttr3 = empExtAttr3;
    }

    public String getEmpExtAttr4() {
        return empExtAttr4;
    }

    public void setEmpExtAttr4(String empExtAttr4) {
        this.empExtAttr4 = empExtAttr4;
    }

    public String getEmpExtAttr5() {
        return empExtAttr5;
    }

    public void setEmpExtAttr5(String empExtAttr5) {
        this.empExtAttr5 = empExtAttr5;
    }

    public String getEmpExtAttr6() {
        return empExtAttr6;
    }

    public void setEmpExtAttr6(String empExtAttr6) {
        this.empExtAttr6 = empExtAttr6;
    }

    public String getEmpExtAttr7() {
        return empExtAttr7;
    }

    public void setEmpExtAttr7(String empExtAttr7) {
        this.empExtAttr7 = empExtAttr7;
    }

    public String getEmpExtAttr8() {
        return empExtAttr8;
    }

    public void setEmpExtAttr8(String empExtAttr8) {
        this.empExtAttr8 = empExtAttr8;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
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