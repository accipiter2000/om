package com.opendynamic.om.vo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class Emp implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orgnSetId; // 组织架构套ID。
    private String orgnSetCode; // 组织架构套编码。
    private String orgnSetName; // 组织架构套名称。
    private String empId; // 人员ID。
    private String empCode; // 人员编码。
    private String empName; // 人员名称。
    private String passwordResetReq; // 密码重置。
    private String party; // 政治面貌。
    private String empLevel; // 职级。
    private String gender; // 性别。
    private Date birthDate; // 出生日期。
    private String tel; // 电话。
    private String email; // 电子邮箱。
    private Date inDate; // 入职日期。
    private Date outDate; // 离职日期。
    private String empCategory; // 人员分类。
    private String memo; // 备注。
    private String empTag; // 人员标签。
    private String empExtAttr1; // 人员扩展属性1。
    private String empExtAttr2; // 人员扩展属性2。
    private String empExtAttr3; // 人员扩展属性3。
    private String empExtAttr4; // 人员扩展属性4。
    private String empExtAttr5; // 人员扩展属性5。
    private String empExtAttr6; // 人员扩展属性6。
    private String empExtAttr7; // 人员扩展属性7。
    private String empExtAttr8; // 人员扩展属性8。
    private Integer order; // 排序。
    private String empStatus; // 人员状态。
    private Date creationDate; // 创建日期。
    private Date updateDate; // 更新日期。
    private String operatorId; // 操作人员ID。
    private String operatorName; // 操作人员名称。
    private String orgId; // 机构ID。
    private String parentOrgId; // 上级机构ID。
    private String orgCode; // 机构编码。
    private String orgName; // 机构名称。
    private String orgAbbrName; // 机构简称。
    private String orgType; // 机构类型。
    private String orgCategory; // 机构分类。
    private String orgTag; // 机构标签。
    private String orgExtAttr1; // 机构扩展属性1。
    private String orgExtAttr2; // 机构扩展属性2。
    private String orgExtAttr3; // 机构扩展属性3。
    private String orgExtAttr4; // 机构扩展属性4。
    private String orgExtAttr5; // 机构扩展属性5。
    private String orgExtAttr6; // 机构扩展属性6。
    private String orgExtAttr7; // 机构扩展属性7。
    private String orgExtAttr8; // 机构扩展属性8。
    private String orgStatus; // 机构状态。
    private String parentOrgCode; // 上级机构编码。
    private String parentOrgName; // 上级机构名称。

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
     * 设置组织架构套名称。
     * 
     * @param orgnSetName
     *        组织架构套名称。
     */
    public void setOrgnSetName(String orgnSetName) {
        this.orgnSetName = orgnSetName;
    }

    /**
     * 获取人员ID。
     * 
     * @return 人员ID。
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * 设置人员ID。
     * 
     * @param empId
     *        人员ID。
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    /**
     * 获取人员编码。
     * 
     * @return 人员编码。
     */
    public String getEmpCode() {
        return empCode;
    }

    /**
     * 设置人员编码。
     * 
     * @param empCode
     *        人员编码。
     */
    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    /**
     * 获取人员名称。
     * 
     * @return 人员名称。
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * 设置人员名称。
     * 
     * @param empName
     *        人员名称。
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * 获取密码重置。
     * 
     * @return 密码重置。
     */
    public String getPasswordResetReq() {
        return passwordResetReq;
    }

    /**
     * 设置密码重置。
     * 
     * @param passwordResetReq
     *        密码重置。
     */
    public void setPasswordResetReq(String passwordResetReq) {
        this.passwordResetReq = passwordResetReq;
    }

    /**
     * 获取政治面貌。
     * 
     * @return 政治面貌。
     */
    public String getParty() {
        return party;
    }

    /**
     * 设置政治面貌。
     * 
     * @param party
     *        政治面貌。
     */
    public void setParty(String party) {
        this.party = party;
    }

    /**
     * 获取职级。
     * 
     * @return 职级。
     */
    public String getEmpLevel() {
        return empLevel;
    }

    /**
     * 设置职级。
     * 
     * @param empLevel
     *        职级。
     */
    public void setEmpLevel(String empLevel) {
        this.empLevel = empLevel;
    }

    /**
     * 获取性别。
     * 
     * @return 性别。
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别。
     * 
     * @param gender
     *        性别。
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取出生日期。
     * 
     * @return 出生日期。
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * 设置出生日期。
     * 
     * @param birthDate
     *        出生日期。
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * 获取电话。
     * 
     * @return 电话。
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置电话。
     * 
     * @param tel
     *        电话。
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取电子邮箱。
     * 
     * @return 电子邮箱。
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱。
     * 
     * @param email
     *        电子邮箱。
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取入职日期。
     * 
     * @return 入职日期。
     */
    public Date getInDate() {
        return inDate;
    }

    /**
     * 设置入职日期。
     * 
     * @param inDate
     *        入职日期。
     */
    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    /**
     * 获取离职日期。
     * 
     * @return 离职日期。
     */
    public Date getOutDate() {
        return outDate;
    }

    /**
     * 设置离职日期。
     * 
     * @param outDate
     *        离职日期。
     */
    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    /**
     * 获取人员分类。
     * 
     * @return 人员分类。
     */
    public String getEmpCategory() {
        return empCategory;
    }

    /**
     * 设置人员分类。
     * 
     * @param empCategory
     *        人员分类。
     */
    public void setEmpCategory(String empCategory) {
        this.empCategory = empCategory;
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
     * 获取人员标签。
     * 
     * @return 人员标签。
     */
    public String getEmpTag() {
        return empTag;
    }

    /**
     * 设置人员标签。
     * 
     * @param empTag
     *        人员标签。
     */
    public void setEmpTag(String empTag) {
        this.empTag = empTag;
    }

    /**
     * 获取人员扩展属性1。
     * 
     * @return 人员扩展属性1。
     */
    public String getEmpExtAttr1() {
        return empExtAttr1;
    }

    /**
     * 设置人员扩展属性1。
     * 
     * @param empExtAttr1
     *        人员扩展属性1。
     */
    public void setEmpExtAttr1(String empExtAttr1) {
        this.empExtAttr1 = empExtAttr1;
    }

    /**
     * 获取人员扩展属性2。
     * 
     * @return 人员扩展属性2。
     */
    public String getEmpExtAttr2() {
        return empExtAttr2;
    }

    /**
     * 设置人员扩展属性2。
     * 
     * @param empExtAttr2
     *        人员扩展属性2。
     */
    public void setEmpExtAttr2(String empExtAttr2) {
        this.empExtAttr2 = empExtAttr2;
    }

    /**
     * 获取人员扩展属性3。
     * 
     * @return 人员扩展属性3。
     */
    public String getEmpExtAttr3() {
        return empExtAttr3;
    }

    /**
     * 设置人员扩展属性3。
     * 
     * @param empExtAttr3
     *        人员扩展属性3。
     */
    public void setEmpExtAttr3(String empExtAttr3) {
        this.empExtAttr3 = empExtAttr3;
    }

    /**
     * 获取人员扩展属性4。
     * 
     * @return 人员扩展属性4。
     */
    public String getEmpExtAttr4() {
        return empExtAttr4;
    }

    /**
     * 设置人员扩展属性4。
     * 
     * @param empExtAttr4
     *        人员扩展属性4。
     */
    public void setEmpExtAttr4(String empExtAttr4) {
        this.empExtAttr4 = empExtAttr4;
    }

    /**
     * 获取人员扩展属性5。
     * 
     * @return 人员扩展属性5。
     */
    public String getEmpExtAttr5() {
        return empExtAttr5;
    }

    /**
     * 设置人员扩展属性5。
     * 
     * @param empExtAttr5
     *        人员扩展属性5。
     */
    public void setEmpExtAttr5(String empExtAttr5) {
        this.empExtAttr5 = empExtAttr5;
    }

    /**
     * 获取人员扩展属性6。
     * 
     * @return 人员扩展属性6。
     */
    public String getEmpExtAttr6() {
        return empExtAttr6;
    }

    /**
     * 设置人员扩展属性6。
     * 
     * @param empExtAttr6
     *        人员扩展属性6。
     */
    public void setEmpExtAttr6(String empExtAttr6) {
        this.empExtAttr6 = empExtAttr6;
    }

    /**
     * 获取人员扩展属性7。
     * 
     * @return 人员扩展属性7。
     */
    public String getEmpExtAttr7() {
        return empExtAttr7;
    }

    /**
     * 设置人员扩展属性7。
     * 
     * @param empExtAttr7
     *        人员扩展属性7。
     */
    public void setEmpExtAttr7(String empExtAttr7) {
        this.empExtAttr7 = empExtAttr7;
    }

    /**
     * 获取人员扩展属性8。
     * 
     * @return 人员扩展属性8。
     */
    public String getEmpExtAttr8() {
        return empExtAttr8;
    }

    /**
     * 设置人员扩展属性8。
     * 
     * @param empExtAttr8
     *        人员扩展属性8。
     */
    public void setEmpExtAttr8(String empExtAttr8) {
        this.empExtAttr8 = empExtAttr8;
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
     * 获取人员状态。
     * 
     * @return 人员状态。
     */
    public String getEmpStatus() {
        return empStatus;
    }

    /**
     * 设置人员状态。
     * 
     * @param empStatus
     *        人员状态。
     */
    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
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
     * 获取更新日期。
     * 
     * @return 更新日期。
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新日期。
     * 
     * @param updateDate
     *        更新日期。
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
     * 获取机构ID。
     * 
     * @return 机构ID。
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 设置机构ID。
     * 
     * @param orgId
     *        机构ID。
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * 获取上级机构ID。
     * 
     * @return 上级机构ID。
     */
    public String getParentOrgId() {
        return parentOrgId;
    }

    /**
     * 设置上级机构ID。
     * 
     * @param parentOrgId
     *        上级机构ID。
     */
    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    /**
     * 获取机构编码。
     * 
     * @return 机构编码。
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * 设置机构编码。
     * 
     * @param orgCode
     *        机构编码。
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    /**
     * 获取机构名称。
     * 
     * @return 机构名称。
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置机构名称。
     * 
     * @param orgName
     *        机构名称。
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * 获取机构简称。
     * 
     * @return 机构简称。
     */
    public String getOrgAbbrName() {
        return orgAbbrName;
    }

    /**
     * 设置机构简称。
     * 
     * @param orgAbbrName
     *        机构简称。
     */
    public void setOrgAbbrName(String orgAbbrName) {
        this.orgAbbrName = orgAbbrName;
    }

    /**
     * 获取机构类型。
     * 
     * @return 机构类型。
     */
    public String getOrgType() {
        return orgType;
    }

    /**
     * 设置机构类型。
     * 
     * @param orgType
     *        机构类型。
     */
    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    /**
     * 获取机构分类。
     * 
     * @return 机构分类。
     */
    public String getOrgCategory() {
        return orgCategory;
    }

    /**
     * 设置机构分类。
     * 
     * @param orgCategory
     *        机构分类。
     */
    public void setOrgCategory(String orgCategory) {
        this.orgCategory = orgCategory;
    }

    /**
     * 获取机构标签。
     * 
     * @return 机构标签。
     */
    public String getOrgTag() {
        return orgTag;
    }

    /**
     * 设置机构标签。
     * 
     * @param orgTag
     *        机构标签。
     */
    public void setOrgTag(String orgTag) {
        this.orgTag = orgTag;
    }

    /**
     * 获取机构扩展属性1。
     * 
     * @return 机构扩展属性1。
     */
    public String getOrgExtAttr1() {
        return orgExtAttr1;
    }

    /**
     * 设置机构扩展属性1。
     * 
     * @param orgExtAttr1
     *        机构扩展属性1。
     */
    public void setOrgExtAttr1(String orgExtAttr1) {
        this.orgExtAttr1 = orgExtAttr1;
    }

    /**
     * 获取机构扩展属性2。
     * 
     * @return 机构扩展属性2。
     */
    public String getOrgExtAttr2() {
        return orgExtAttr2;
    }

    /**
     * 设置机构扩展属性2。
     * 
     * @param orgExtAttr2
     *        机构扩展属性2。
     */
    public void setOrgExtAttr2(String orgExtAttr2) {
        this.orgExtAttr2 = orgExtAttr2;
    }

    /**
     * 获取机构扩展属性3。
     * 
     * @return 机构扩展属性3。
     */
    public String getOrgExtAttr3() {
        return orgExtAttr3;
    }

    /**
     * 设置机构扩展属性3。
     * 
     * @param orgExtAttr3
     *        机构扩展属性3。
     */
    public void setOrgExtAttr3(String orgExtAttr3) {
        this.orgExtAttr3 = orgExtAttr3;
    }

    /**
     * 获取机构扩展属性4。
     * 
     * @return 机构扩展属性4。
     */
    public String getOrgExtAttr4() {
        return orgExtAttr4;
    }

    /**
     * 设置机构扩展属性4。
     * 
     * @param orgExtAttr4
     *        机构扩展属性4。
     */
    public void setOrgExtAttr4(String orgExtAttr4) {
        this.orgExtAttr4 = orgExtAttr4;
    }

    /**
     * 获取机构扩展属性5。
     * 
     * @return 机构扩展属性5。
     */
    public String getOrgExtAttr5() {
        return orgExtAttr5;
    }

    /**
     * 设置机构扩展属性5。
     * 
     * @param orgExtAttr5
     *        机构扩展属性5。
     */
    public void setOrgExtAttr5(String orgExtAttr5) {
        this.orgExtAttr5 = orgExtAttr5;
    }

    /**
     * 获取机构扩展属性6。
     * 
     * @return 机构扩展属性6。
     */
    public String getOrgExtAttr6() {
        return orgExtAttr6;
    }

    /**
     * 设置机构扩展属性6。
     * 
     * @param orgExtAttr6
     *        机构扩展属性6。
     */
    public void setOrgExtAttr6(String orgExtAttr6) {
        this.orgExtAttr6 = orgExtAttr6;
    }

    /**
     * 获取机构扩展属性7。
     * 
     * @return 机构扩展属性7。
     */
    public String getOrgExtAttr7() {
        return orgExtAttr7;
    }

    /**
     * 设置机构扩展属性7。
     * 
     * @param orgExtAttr7
     *        机构扩展属性7。
     */
    public void setOrgExtAttr7(String orgExtAttr7) {
        this.orgExtAttr7 = orgExtAttr7;
    }

    /**
     * 获取机构扩展属性8。
     * 
     * @return 机构扩展属性8。
     */
    public String getOrgExtAttr8() {
        return orgExtAttr8;
    }

    /**
     * 设置机构扩展属性8。
     * 
     * @param orgExtAttr8
     *        机构扩展属性8。
     */
    public void setOrgExtAttr8(String orgExtAttr8) {
        this.orgExtAttr8 = orgExtAttr8;
    }

    /**
     * 获取机构状态。
     * 
     * @return 机构状态。
     */
    public String getOrgStatus() {
        return orgStatus;
    }

    /**
     * 设置机构状态。
     * 
     * @param orgStatus
     *        机构状态。
     */
    public void setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus;
    }

    /**
     * 获取上级机构编码。
     * 
     * @return 上级机构编码。
     */
    public String getParentOrgCode() {
        return parentOrgCode;
    }

    /**
     * 设置上级机构编码。
     * 
     * @param parentOrgCode
     *        上级机构编码。
     */
    public void setParentOrgCode(String parentOrgCode) {
        this.parentOrgCode = parentOrgCode;
    }

    /**
     * 获取上级机构名称。
     * 
     * @return 上级机构名称。
     */
    public String getParentOrgName() {
        return parentOrgName;
    }

    /**
     * 设置上级机构名称。
     * 
     * @param parentOrgName
     *        上级机构名称。
     */
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