package com.opendynamic.om.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class PosiEmp implements Serializable {
    private static final long serialVersionUID = 1L;

    private String posiEmpId;// 岗位人员ID
    private String orgnSetId;// 组织架构套ID
    private String posiId;// 岗位ID
    private String empId;// 人员ID
    private String main;// 主岗位
    private String posiEmpTag;// 岗位人员标签
    private String posiEmpStatus;// 岗位人员状态
    private Date creationDate;// 创建日期
    private Date updateDate;// 更新日期
    private String operatorId;// 操作人员ID
    private String operatorName;// 操作人员名称
    private String orgnSetCode; // 组织架构套编码
    private String orgnSetName; // 组织架构套名称
    private String orgId;// 机构id
    private String orgCode; // 机构编码
    private String orgName; // 机构名称
    private String dutyId;// 职务id
    private String dutyCode;// 职务编码
    private String dutyName;// 职务名称
    private String posiCode;// 岗位编码
    private String posiName;// 岗位名称
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
    private String category; // 分类
    private String memo; // 备注
    private String empTag; // 人员标签
    private String extAttr1; // 扩展属性1
    private String extAttr2; // 扩展属性2
    private String extAttr3; // 扩展属性3
    private String extAttr4; // 扩展属性4
    private String extAttr5; // 扩展属性5
    private String extAttr6; // 扩展属性6
    private String extAttr7; // 扩展属性7
    private String extAttr8; // 扩展属性8
    private Integer order; // 排序
    private String empStatus; // 人员状态

    public PosiEmp() {
    }

    public PosiEmp(Map<String, Object> data) {// 通过数据库表加载
        this.posiEmpId = (String) data.get("POSI_EMP_ID_");
        this.orgnSetId = (String) data.get("ORGN_SET_ID_");
        this.posiId = (String) data.get("POSI_ID_");
        this.empId = (String) data.get("EMP_ID_");
        this.main = (String) data.get("MAIN_");
        this.posiEmpTag = (String) data.get("POSI_EMP_TAG_");
        this.posiEmpStatus = (String) data.get("POSI_EMP_STATUS_");
        this.creationDate = (Date) data.get("CREATION_DATE_");
        this.updateDate = (Date) data.get("UPDATE_DATE_");
        this.operatorId = (String) data.get("OPERATOR_ID_");
        this.operatorName = (String) data.get("OPERATOR_NAME_");
        this.orgnSetCode = (String) data.get("ORGN_SET_CODE_");
        this.orgnSetName = (String) data.get("ORGN_SET_NAME_");
        this.orgId = (String) data.get("ORG_ID_");
        this.orgCode = (String) data.get("ORG_CODE_");
        this.orgName = (String) data.get("ORG_NAME_");
        this.dutyId = (String) data.get("DUTY_ID_");
        this.dutyCode = (String) data.get("DUTY_CODE_");
        this.dutyName = (String) data.get("DUTY_NAME_");
        this.posiCode = (String) data.get("POSI_CODE_");
        this.posiName = (String) data.get("POSI_NAME_");
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
        this.category = (String) data.get("CATEGORY_");
        this.memo = (String) data.get("MEMO_");
        this.empTag = (String) data.get("EMP_TAG_");
        this.extAttr1 = (String) data.get("EXT_ATTR_1_");
        this.extAttr2 = (String) data.get("EXT_ATTR_2_");
        this.extAttr3 = (String) data.get("EXT_ATTR_3_");
        this.extAttr4 = (String) data.get("EXT_ATTR_4_");
        this.extAttr5 = (String) data.get("EXT_ATTR_5_");
        this.extAttr6 = (String) data.get("EXT_ATTR_6_");
        this.extAttr7 = (String) data.get("EXT_ATTR_7_");
        this.extAttr8 = (String) data.get("EXT_ATTR_8_");
        this.order = (data.get("ORDER_") != null) ? ((BigDecimal) data.get("ORDER_")).intValue() : null;
        this.empStatus = (String) data.get("EMP_STATUS_");
    }

    public String getPosiEmpId() {
        return posiEmpId;
    }

    public void setPosiEmpId(String posiEmpId) {
        this.posiEmpId = posiEmpId;
    }

    public String getOrgnSetId() {
        return orgnSetId;
    }

    public void setOrgnSetId(String orgnSetId) {
        this.orgnSetId = orgnSetId;
    }

    public String getPosiId() {
        return posiId;
    }

    public void setPosiId(String posiId) {
        this.posiId = posiId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getPosiEmpTag() {
        return posiEmpTag;
    }

    public void setPosiEmpTag(String posiEmpTag) {
        this.posiEmpTag = posiEmpTag;
    }

    public String getPosiEmpStatus() {
        return posiEmpStatus;
    }

    public void setPosiEmpStatus(String posiEmpStatus) {
        this.posiEmpStatus = posiEmpStatus;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getExtAttr1() {
        return extAttr1;
    }

    public void setExtAttr1(String extAttr1) {
        this.extAttr1 = extAttr1;
    }

    public String getExtAttr2() {
        return extAttr2;
    }

    public void setExtAttr2(String extAttr2) {
        this.extAttr2 = extAttr2;
    }

    public String getExtAttr3() {
        return extAttr3;
    }

    public void setExtAttr3(String extAttr3) {
        this.extAttr3 = extAttr3;
    }

    public String getExtAttr4() {
        return extAttr4;
    }

    public void setExtAttr4(String extAttr4) {
        this.extAttr4 = extAttr4;
    }

    public String getExtAttr5() {
        return extAttr5;
    }

    public void setExtAttr5(String extAttr5) {
        this.extAttr5 = extAttr5;
    }

    public String getExtAttr6() {
        return extAttr6;
    }

    public void setExtAttr6(String extAttr6) {
        this.extAttr6 = extAttr6;
    }

    public String getExtAttr7() {
        return extAttr7;
    }

    public void setExtAttr7(String extAttr7) {
        this.extAttr7 = extAttr7;
    }

    public String getExtAttr8() {
        return extAttr8;
    }

    public void setExtAttr8(String extAttr8) {
        this.extAttr8 = extAttr8;
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
}