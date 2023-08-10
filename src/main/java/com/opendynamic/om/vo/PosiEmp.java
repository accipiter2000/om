package com.opendynamic.om.vo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class PosiEmp implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orgnSetId;// 组织架构套ID
    private String orgnSetCode; // 组织架构套编码
    private String orgnSetName; // 组织架构套名称
    private String posiEmpId;// 岗位人员ID
    private String main;// 主岗位
    private String posiEmpCategory;// 分类
    private String memo;// 备注
    private String posiEmpTag;// 岗位人员标签
    private String posiEmpExtAttr1;// 岗位人员扩展属性1
    private String posiEmpExtAttr2;// 岗位人员扩展属性2
    private String posiEmpExtAttr3;// 岗位人员扩展属性3
    private String posiEmpExtAttr4;// 岗位人员扩展属性4
    private String posiEmpExtAttr5;// 岗位人员扩展属性5
    private String posiEmpExtAttr6;// 岗位人员扩展属性6
    private String posiEmpExtAttr7;// 岗位人员扩展属性7
    private String posiEmpExtAttr8;// 岗位人员扩展属性8
    private Integer order;// 排序
    private String posiEmpStatus;// 岗位人员状态
    private Date creationDate;// 创建日期
    private Date updateDate;// 更新日期
    private String operatorId;// 操作人员ID
    private String operatorName;// 操作人员名称
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
    private String empTag; // 人员标签
    private String empExtAttr1; // 人员扩展属性1
    private String empExtAttr2; // 人员扩展属性2
    private String empExtAttr3; // 人员扩展属性3
    private String empExtAttr4; // 人员扩展属性4
    private String empExtAttr5; // 人员扩展属性5
    private String empExtAttr6; // 人员扩展属性6
    private String empExtAttr7; // 人员扩展属性7
    private String empExtAttr8; // 人员扩展属性8
    private String empStatus; // 人员状态
    private String posiId; // 岗位ID
    private String posiCode; // 岗位编码
    private String posiName; // 岗位名称
    private String orgLeaderType; // 机构领导类型
    private String posiCategory; // 分类
    private String posiTag; // 岗位标签
    private String posiExtAttr1; // 岗位扩展属性1
    private String posiExtAttr2; // 岗位扩展属性2
    private String posiExtAttr3; // 岗位扩展属性3
    private String posiExtAttr4; // 岗位扩展属性4
    private String posiExtAttr5; // 岗位扩展属性5
    private String posiExtAttr6; // 岗位扩展属性6
    private String posiExtAttr7; // 岗位扩展属性7
    private String posiExtAttr8; // 岗位扩展属性8
    private String posiStatus; // 岗位状态
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

    public PosiEmp() {
    }

    public PosiEmp(Map<String, Object> data) {// 通过数据库表加载
        this.orgnSetId = (String) data.get("ORGN_SET_ID_");
        this.orgnSetCode = (String) data.get("ORGN_SET_CODE_");
        this.orgnSetName = (String) data.get("ORGN_SET_NAME_");
        this.posiEmpId = (String) data.get("POSI_EMP_ID_");
        this.main = (String) data.get("MAIN_");
        this.posiEmpCategory = (String) data.get("POSI_EMP_CATEGORY_");
        this.memo = (String) data.get("MEMO_");
        this.posiEmpTag = (String) data.get("POSI_EMP_TAG_");
        this.posiEmpExtAttr1 = (String) data.get("POSI_EMP_EXT_ATTR_1_");
        this.posiEmpExtAttr2 = (String) data.get("POSI_EMP_EXT_ATTR_2_");
        this.posiEmpExtAttr3 = (String) data.get("POSI_EMP_EXT_ATTR_3_");
        this.posiEmpExtAttr4 = (String) data.get("POSI_EMP_EXT_ATTR_4_");
        this.posiEmpExtAttr5 = (String) data.get("POSI_EMP_EXT_ATTR_5_");
        this.posiEmpExtAttr6 = (String) data.get("POSI_EMP_EXT_ATTR_6_");
        this.posiEmpExtAttr7 = (String) data.get("POSI_EMP_EXT_ATTR_7_");
        this.posiEmpExtAttr8 = (String) data.get("POSI_EMP_EXT_ATTR_8_");
        this.order = (data.get("ORDER_") != null) ? ((BigDecimal) data.get("ORDER_")).intValue() : null;
        this.posiEmpStatus = (String) data.get("POSI_EMP_STATUS_");
        this.creationDate = (Date) data.get("CREATION_DATE_");
        this.updateDate = (Date) data.get("UPDATE_DATE_");
        this.operatorId = (String) data.get("OPERATOR_ID_");
        this.operatorName = (String) data.get("OPERATOR_NAME_");
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
        this.empTag = (String) data.get("EMP_TAG_");
        this.empExtAttr1 = (String) data.get("EMP_EXT_ATTR_1_");
        this.empExtAttr2 = (String) data.get("EMP_EXT_ATTR_2_");
        this.empExtAttr3 = (String) data.get("EMP_EXT_ATTR_3_");
        this.empExtAttr4 = (String) data.get("EMP_EXT_ATTR_4_");
        this.empExtAttr5 = (String) data.get("EMP_EXT_ATTR_5_");
        this.empExtAttr6 = (String) data.get("EMP_EXT_ATTR_6_");
        this.empExtAttr7 = (String) data.get("EMP_EXT_ATTR_7_");
        this.empExtAttr8 = (String) data.get("EMP_EXT_ATTR_8_");
        this.empStatus = (String) data.get("EMP_STATUS_");
        this.posiId = (String) data.get("POSI_ID_");
        this.posiCode = (String) data.get("POSI_CODE_");
        this.posiName = (String) data.get("POSI_NAME_");
        this.orgLeaderType = (String) data.get("ORG_LEADER_TYPE_");
        this.posiCategory = (String) data.get("POSI_CATEGORY_");
        this.posiTag = (String) data.get("POSI_TAG_");
        this.posiExtAttr1 = (String) data.get("POSI_EXT_ATTR_1_");
        this.posiExtAttr2 = (String) data.get("POSI_EXT_ATTR_2_");
        this.posiExtAttr3 = (String) data.get("POSI_EXT_ATTR_3_");
        this.posiExtAttr4 = (String) data.get("POSI_EXT_ATTR_4_");
        this.posiExtAttr5 = (String) data.get("POSI_EXT_ATTR_5_");
        this.posiExtAttr6 = (String) data.get("POSI_EXT_ATTR_6_");
        this.posiExtAttr7 = (String) data.get("POSI_EXT_ATTR_7_");
        this.posiExtAttr8 = (String) data.get("POSI_EXT_ATTR_8_");
        this.posiStatus = (String) data.get("POSI_STATUS_");
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

    public String getPosiEmpId() {
        return posiEmpId;
    }

    public void setPosiEmpId(String posiEmpId) {
        this.posiEmpId = posiEmpId;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getPosiEmpCategory() {
        return posiEmpCategory;
    }

    public void setPosiEmpCategory(String posiEmpCategory) {
        this.posiEmpCategory = posiEmpCategory;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getPosiEmpTag() {
        return posiEmpTag;
    }

    public void setPosiEmpTag(String posiEmpTag) {
        this.posiEmpTag = posiEmpTag;
    }

    public String getPosiEmpExtAttr1() {
        return posiEmpExtAttr1;
    }

    public void setPosiEmpExtAttr1(String posiEmpExtAttr1) {
        this.posiEmpExtAttr1 = posiEmpExtAttr1;
    }

    public String getPosiEmpExtAttr2() {
        return posiEmpExtAttr2;
    }

    public void setPosiEmpExtAttr2(String posiEmpExtAttr2) {
        this.posiEmpExtAttr2 = posiEmpExtAttr2;
    }

    public String getPosiEmpExtAttr3() {
        return posiEmpExtAttr3;
    }

    public void setPosiEmpExtAttr3(String posiEmpExtAttr3) {
        this.posiEmpExtAttr3 = posiEmpExtAttr3;
    }

    public String getPosiEmpExtAttr4() {
        return posiEmpExtAttr4;
    }

    public void setPosiEmpExtAttr4(String posiEmpExtAttr4) {
        this.posiEmpExtAttr4 = posiEmpExtAttr4;
    }

    public String getPosiEmpExtAttr5() {
        return posiEmpExtAttr5;
    }

    public void setPosiEmpExtAttr5(String posiEmpExtAttr5) {
        this.posiEmpExtAttr5 = posiEmpExtAttr5;
    }

    public String getPosiEmpExtAttr6() {
        return posiEmpExtAttr6;
    }

    public void setPosiEmpExtAttr6(String posiEmpExtAttr6) {
        this.posiEmpExtAttr6 = posiEmpExtAttr6;
    }

    public String getPosiEmpExtAttr7() {
        return posiEmpExtAttr7;
    }

    public void setPosiEmpExtAttr7(String posiEmpExtAttr7) {
        this.posiEmpExtAttr7 = posiEmpExtAttr7;
    }

    public String getPosiEmpExtAttr8() {
        return posiEmpExtAttr8;
    }

    public void setPosiEmpExtAttr8(String posiEmpExtAttr8) {
        this.posiEmpExtAttr8 = posiEmpExtAttr8;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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

    public String getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
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

    public String getPosiStatus() {
        return posiStatus;
    }

    public void setPosiStatus(String posiStatus) {
        this.posiStatus = posiStatus;
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
        StringBuilder stringBuilder = new StringBuilder(4000);

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