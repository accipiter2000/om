package com.opendynamic.om.vo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class EmpRelation implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orgnSetId; // 组织架构套ID。
    private String orgnSetCode; // 组织架构套编码。
    private String orgnSetName; // 组织架构套名称。
    private String empRelationId; // 人员关系ID。
    private String empRelation; // 人员关系。
    private String empRelationCategory; // 人员关系分类。
    private String memo; // 备注。
    private String empRelationTag; // 人员关系标签。
    private String empRelationExtAttr1; // 人员关系扩展属性1。
    private String empRelationExtAttr2; // 人员关系扩展属性2。
    private String empRelationExtAttr3; // 人员关系扩展属性3。
    private String empRelationExtAttr4; // 人员关系扩展属性4。
    private String empRelationExtAttr5; // 人员关系扩展属性5。
    private String empRelationExtAttr6; // 人员关系扩展属性6。
    private String empRelationExtAttr7; // 人员关系扩展属性7。
    private String empRelationExtAttr8; // 人员关系扩展属性8。
    private Integer order; // 排序。
    private String empRelationStatus; // 人员关系状态。
    private Date creationDate; // 创建日期。
    private Date updateDate; // 修改日期。
    private String operatorId; // 操作人员ID。
    private String operatorName; // 操作人员名称。
    private String upperEmpId; // 上级人员ID。
    private String upperEmpCode; // 上级人员编码。
    private String upperEmpName; // 上级人员名称。
    private String upperPasswordResetReq; // 上级密码重置。
    private String upperParty; // 上级政治面貌。
    private String upperEmpLevel; // 上级职级。
    private String upperGender; // 上级性别。
    private Date upperBirthDate; // 上级出生日期。
    private String upperTel; // 上级电话。
    private String upperEmail; // 上级电子邮箱。
    private Date upperInDate; // 上级入职日期。
    private Date upperOutDate; // 上级离职日期。
    private String upperEmpCategory; // 上级人员分类。
    private String upperEmpTag; // 上级人员标签。
    private String upperEmpExtAttr1; // 上级人员扩展属性1。
    private String upperEmpExtAttr2; // 上级人员扩展属性2。
    private String upperEmpExtAttr3; // 上级人员扩展属性3。
    private String upperEmpExtAttr4; // 上级人员扩展属性4。
    private String upperEmpExtAttr5; // 上级人员扩展属性5。
    private String upperEmpExtAttr6; // 上级人员扩展属性6。
    private String upperEmpExtAttr7; // 上级人员扩展属性7。
    private String upperEmpExtAttr8; // 上级人员扩展属性8。
    private String upperEmpStatus; // 上级人员状态。
    private String upperOrgId; // 上级机构ID。
    private String upperParentOrgId; // 上级上级机构ID。
    private String upperOrgCode; // 上级机构编码。
    private String upperOrgName; // 上级机构名称。
    private String upperOrgAbbrName; // 上级机构简称。
    private String upperOrgType; // 上级机构类型。
    private String upperOrgCategory; // 上级机构分类。
    private String upperOrgTag; // 上级机构标签。
    private String upperOrgExtAttr1; // 上级机构扩展属性1。
    private String upperOrgExtAttr2; // 上级机构扩展属性2。
    private String upperOrgExtAttr3; // 上级机构扩展属性3。
    private String upperOrgExtAttr4; // 上级机构扩展属性4。
    private String upperOrgExtAttr5; // 上级机构扩展属性5。
    private String upperOrgExtAttr6; // 上级机构扩展属性6。
    private String upperOrgExtAttr7; // 上级机构扩展属性7。
    private String upperOrgExtAttr8; // 上级机构扩展属性8。
    private String upperOrgStatus; // 上级机构状态。
    private String upperParentOrgCode; // 上级上级机构编码。
    private String upperParentOrgName; // 上级上级机构名称。
    private String lowerEmpId; // 下级人员ID。
    private String lowerEmpCode; // 下级人员编码。
    private String lowerEmpName; // 下级人员名称。
    private String lowerPasswordResetReq; // 下级密码重置。
    private String lowerParty; // 下级政治面貌。
    private String lowerEmpLevel; // 下级职级。
    private String lowerGender; // 下级性别。
    private Date lowerBirthDate; // 下级出生日期。
    private String lowerTel; // 下级电话。
    private String lowerEmail; // 下级电子邮箱。
    private Date lowerInDate; // 下级入职日期。
    private Date lowerOutDate; // 下级离职日期。
    private String lowerEmpCategory; // 下级人员分类。
    private String lowerEmpTag; // 下级人员标签。
    private String lowerEmpExtAttr1; // 下级人员扩展属性1。
    private String lowerEmpExtAttr2; // 下级人员扩展属性2。
    private String lowerEmpExtAttr3; // 下级人员扩展属性3。
    private String lowerEmpExtAttr4; // 下级人员扩展属性4。
    private String lowerEmpExtAttr5; // 下级人员扩展属性5。
    private String lowerEmpExtAttr6; // 下级人员扩展属性6。
    private String lowerEmpExtAttr7; // 下级人员扩展属性7。
    private String lowerEmpExtAttr8; // 下级人员扩展属性8。
    private String lowerEmpStatus; // 下级人员状态。
    private String lowerOrgId; // 下级机构ID。
    private String lowerParentOrgId; // 下级上级机构ID。
    private String lowerOrgCode; // 下级机构编码。
    private String lowerOrgName; // 下级机构名称。
    private String lowerOrgAbbrName; // 下级机构简称。
    private String lowerOrgType; // 下级机构类型。
    private String lowerOrgCategory; // 下级机构分类。
    private String lowerOrgTag; // 下级机构标签。
    private String lowerOrgExtAttr1; // 下级机构扩展属性1。
    private String lowerOrgExtAttr2; // 下级机构扩展属性2。
    private String lowerOrgExtAttr3; // 下级机构扩展属性3。
    private String lowerOrgExtAttr4; // 下级机构扩展属性4。
    private String lowerOrgExtAttr5; // 下级机构扩展属性5。
    private String lowerOrgExtAttr6; // 下级机构扩展属性6。
    private String lowerOrgExtAttr7; // 下级机构扩展属性7。
    private String lowerOrgExtAttr8; // 下级机构扩展属性8。
    private String lowerOrgStatus; // 下级机构状态。
    private String lowerParentOrgCode; // 下级上级机构编码。
    private String lowerParentOrgName; // 下级上级机构名称。

    public EmpRelation() {
    }

    public EmpRelation(Map<String, Object> data) {// 通过数据库表加载
        this.orgnSetId = (String) data.get("ORGN_SET_ID_");
        this.orgnSetCode = (String) data.get("ORGN_SET_CODE_");
        this.orgnSetName = (String) data.get("ORGN_SET_NAME_");
        this.empRelationId = (String) data.get("EMP_RELATION_ID_");
        this.empRelation = (String) data.get("EMP_RELATION_");
        this.empRelationCategory = (String) data.get("EMP_RELATION_CATEGORY_");
        this.memo = (String) data.get("MEMO_");
        this.empRelationTag = (String) data.get("EMP_RELATION_TAG_");
        this.empRelationExtAttr1 = (String) data.get("EMP_RELATION_EXT_ATTR_1_");
        this.empRelationExtAttr2 = (String) data.get("EMP_RELATION_EXT_ATTR_2_");
        this.empRelationExtAttr3 = (String) data.get("EMP_RELATION_EXT_ATTR_3_");
        this.empRelationExtAttr4 = (String) data.get("EMP_RELATION_EXT_ATTR_4_");
        this.empRelationExtAttr5 = (String) data.get("EMP_RELATION_EXT_ATTR_5_");
        this.empRelationExtAttr6 = (String) data.get("EMP_RELATION_EXT_ATTR_6_");
        this.empRelationExtAttr7 = (String) data.get("EMP_RELATION_EXT_ATTR_7_");
        this.empRelationExtAttr8 = (String) data.get("EMP_RELATION_EXT_ATTR_8_");
        this.order = (data.get("ORDER_") != null) ? ((BigDecimal) data.get("ORDER_")).intValue() : null;
        this.empRelationStatus = (String) data.get("EMP_RELATION_STATUS_");
        this.creationDate = (Date) data.get("CREATION_DATE_");
        this.updateDate = (Date) data.get("UPDATE_DATE_");
        this.operatorId = (String) data.get("OPERATOR_ID_");
        this.operatorName = (String) data.get("OPERATOR_NAME_");
        this.upperEmpId = (String) data.get("UPPER_EMP_ID_");
        this.upperEmpCode = (String) data.get("UPPER_EMP_CODE_");
        this.upperEmpName = (String) data.get("UPPER_EMP_NAME_");
        this.upperPasswordResetReq = (String) data.get("UPPER_PASSWORD_RESET_REQ_");
        this.upperParty = (String) data.get("UPPER_PARTY_");
        this.upperEmpLevel = (String) data.get("UPPER_EMP_LEVEL_");
        this.upperGender = (String) data.get("UPPER_GENDER_");
        this.upperBirthDate = (Date) data.get("UPPER_BIRTH_DATE_");
        this.upperTel = (String) data.get("UPPER_TEL_");
        this.upperEmail = (String) data.get("UPPER_EMAIL_");
        this.upperInDate = (Date) data.get("UPPER_IN_DATE_");
        this.upperOutDate = (Date) data.get("UPPER_OUT_DATE_");
        this.upperEmpCategory = (String) data.get("UPPER_EMP_CATEGORY_");
        this.upperEmpTag = (String) data.get("UPPER_EMP_TAG_");
        this.upperEmpExtAttr1 = (String) data.get("UPPER_EMP_EXT_ATTR_1_");
        this.upperEmpExtAttr2 = (String) data.get("UPPER_EMP_EXT_ATTR_2_");
        this.upperEmpExtAttr3 = (String) data.get("UPPER_EMP_EXT_ATTR_3_");
        this.upperEmpExtAttr4 = (String) data.get("UPPER_EMP_EXT_ATTR_4_");
        this.upperEmpExtAttr5 = (String) data.get("UPPER_EMP_EXT_ATTR_5_");
        this.upperEmpExtAttr6 = (String) data.get("UPPER_EMP_EXT_ATTR_6_");
        this.upperEmpExtAttr7 = (String) data.get("UPPER_EMP_EXT_ATTR_7_");
        this.upperEmpExtAttr8 = (String) data.get("UPPER_EMP_EXT_ATTR_8_");
        this.upperEmpStatus = (String) data.get("UPPER_EMP_STATUS_");
        this.upperOrgId = (String) data.get("UPPER_ORG_ID_");
        this.upperParentOrgId = (String) data.get("UPPER_PARENT_ORG_ID_");
        this.upperOrgCode = (String) data.get("UPPER_ORG_CODE_");
        this.upperOrgName = (String) data.get("UPPER_ORG_NAME_");
        this.upperOrgAbbrName = (String) data.get("UPPER_ORG_ABBR_NAME_");
        this.upperOrgType = (String) data.get("UPPER_ORG_TYPE_");
        this.upperOrgCategory = (String) data.get("UPPER_ORG_CATEGORY_");
        this.upperOrgTag = (String) data.get("UPPER_ORG_TAG_");
        this.upperOrgExtAttr1 = (String) data.get("UPPER_ORG_EXT_ATTR_1_");
        this.upperOrgExtAttr2 = (String) data.get("UPPER_ORG_EXT_ATTR_2_");
        this.upperOrgExtAttr3 = (String) data.get("UPPER_ORG_EXT_ATTR_3_");
        this.upperOrgExtAttr4 = (String) data.get("UPPER_ORG_EXT_ATTR_4_");
        this.upperOrgExtAttr5 = (String) data.get("UPPER_ORG_EXT_ATTR_5_");
        this.upperOrgExtAttr6 = (String) data.get("UPPER_ORG_EXT_ATTR_6_");
        this.upperOrgExtAttr7 = (String) data.get("UPPER_ORG_EXT_ATTR_7_");
        this.upperOrgExtAttr8 = (String) data.get("UPPER_ORG_EXT_ATTR_8_");
        this.upperOrgStatus = (String) data.get("UPPER_ORG_STATUS_");
        this.upperParentOrgCode = (String) data.get("UPPER_PARENT_ORG_CODE_");
        this.upperParentOrgName = (String) data.get("UPPER_PARENT_ORG_NAME_");
        this.lowerEmpId = (String) data.get("LOWER_EMP_ID_");
        this.lowerEmpCode = (String) data.get("LOWER_EMP_CODE_");
        this.lowerEmpName = (String) data.get("LOWER_EMP_NAME_");
        this.lowerPasswordResetReq = (String) data.get("LOWER_PASSWORD_RESET_REQ_");
        this.lowerParty = (String) data.get("LOWER_PARTY_");
        this.lowerEmpLevel = (String) data.get("LOWER_EMP_LEVEL_");
        this.lowerGender = (String) data.get("LOWER_GENDER_");
        this.lowerBirthDate = (Date) data.get("LOWER_BIRTH_DATE_");
        this.lowerTel = (String) data.get("LOWER_TEL_");
        this.lowerEmail = (String) data.get("LOWER_EMAIL_");
        this.lowerInDate = (Date) data.get("LOWER_IN_DATE_");
        this.lowerOutDate = (Date) data.get("LOWER_OUT_DATE_");
        this.lowerEmpCategory = (String) data.get("LOWER_EMP_CATEGORY_");
        this.lowerEmpTag = (String) data.get("LOWER_EMP_TAG_");
        this.lowerEmpExtAttr1 = (String) data.get("LOWER_EMP_EXT_ATTR_1_");
        this.lowerEmpExtAttr2 = (String) data.get("LOWER_EMP_EXT_ATTR_2_");
        this.lowerEmpExtAttr3 = (String) data.get("LOWER_EMP_EXT_ATTR_3_");
        this.lowerEmpExtAttr4 = (String) data.get("LOWER_EMP_EXT_ATTR_4_");
        this.lowerEmpExtAttr5 = (String) data.get("LOWER_EMP_EXT_ATTR_5_");
        this.lowerEmpExtAttr6 = (String) data.get("LOWER_EMP_EXT_ATTR_6_");
        this.lowerEmpExtAttr7 = (String) data.get("LOWER_EMP_EXT_ATTR_7_");
        this.lowerEmpExtAttr8 = (String) data.get("LOWER_EMP_EXT_ATTR_8_");
        this.lowerEmpStatus = (String) data.get("LOWER_EMP_STATUS_");
        this.lowerOrgId = (String) data.get("LOWER_ORG_ID_");
        this.lowerParentOrgId = (String) data.get("LOWER_PARENT_ORG_ID_");
        this.lowerOrgCode = (String) data.get("LOWER_ORG_CODE_");
        this.lowerOrgName = (String) data.get("LOWER_ORG_NAME_");
        this.lowerOrgAbbrName = (String) data.get("LOWER_ORG_ABBR_NAME_");
        this.lowerOrgType = (String) data.get("LOWER_ORG_TYPE_");
        this.lowerOrgCategory = (String) data.get("LOWER_ORG_CATEGORY_");
        this.lowerOrgTag = (String) data.get("LOWER_ORG_TAG_");
        this.lowerOrgExtAttr1 = (String) data.get("LOWER_ORG_EXT_ATTR_1_");
        this.lowerOrgExtAttr2 = (String) data.get("LOWER_ORG_EXT_ATTR_2_");
        this.lowerOrgExtAttr3 = (String) data.get("LOWER_ORG_EXT_ATTR_3_");
        this.lowerOrgExtAttr4 = (String) data.get("LOWER_ORG_EXT_ATTR_4_");
        this.lowerOrgExtAttr5 = (String) data.get("LOWER_ORG_EXT_ATTR_5_");
        this.lowerOrgExtAttr6 = (String) data.get("LOWER_ORG_EXT_ATTR_6_");
        this.lowerOrgExtAttr7 = (String) data.get("LOWER_ORG_EXT_ATTR_7_");
        this.lowerOrgExtAttr8 = (String) data.get("LOWER_ORG_EXT_ATTR_8_");
        this.lowerOrgStatus = (String) data.get("LOWER_ORG_STATUS_");
        this.lowerParentOrgCode = (String) data.get("LOWER_PARENT_ORG_CODE_");
        this.lowerParentOrgName = (String) data.get("LOWER_PARENT_ORG_NAME_");
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
     * 获取人员关系ID。
     * 
     * @return 人员关系ID。
     */
    public String getEmpRelationId() {
        return empRelationId;
    }

    /**
     * 设置人员关系ID。
     * 
     * @param empRelationId
     *        人员关系ID。
     */
    public void setEmpRelationId(String empRelationId) {
        this.empRelationId = empRelationId;
    }

    /**
     * 获取人员关系。
     * 
     * @return 人员关系。
     */
    public String getEmpRelation() {
        return empRelation;
    }

    /**
     * 设置人员关系。
     * 
     * @param empRelation
     *        人员关系。
     */
    public void setEmpRelation(String empRelation) {
        this.empRelation = empRelation;
    }

    /**
     * 获取人员关系分类。
     * 
     * @return 人员关系分类。
     */
    public String getEmpRelationCategory() {
        return empRelationCategory;
    }

    /**
     * 设置人员关系分类。
     * 
     * @param empRelationCategory
     *        人员关系分类。
     */
    public void setEmpRelationCategory(String empRelationCategory) {
        this.empRelationCategory = empRelationCategory;
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
     * 获取人员关系标签。
     * 
     * @return 人员关系标签。
     */
    public String getEmpRelationTag() {
        return empRelationTag;
    }

    /**
     * 设置人员关系标签。
     * 
     * @param empRelationTag
     *        人员关系标签。
     */
    public void setEmpRelationTag(String empRelationTag) {
        this.empRelationTag = empRelationTag;
    }

    /**
     * 获取人员关系扩展属性1。
     * 
     * @return 人员关系扩展属性1。
     */
    public String getEmpRelationExtAttr1() {
        return empRelationExtAttr1;
    }

    /**
     * 设置人员关系扩展属性1。
     * 
     * @param empRelationExtAttr1
     *        人员关系扩展属性1。
     */
    public void setEmpRelationExtAttr1(String empRelationExtAttr1) {
        this.empRelationExtAttr1 = empRelationExtAttr1;
    }

    /**
     * 获取人员关系扩展属性2。
     * 
     * @return 人员关系扩展属性2。
     */
    public String getEmpRelationExtAttr2() {
        return empRelationExtAttr2;
    }

    /**
     * 设置人员关系扩展属性2。
     * 
     * @param empRelationExtAttr2
     *        人员关系扩展属性2。
     */
    public void setEmpRelationExtAttr2(String empRelationExtAttr2) {
        this.empRelationExtAttr2 = empRelationExtAttr2;
    }

    /**
     * 获取人员关系扩展属性3。
     * 
     * @return 人员关系扩展属性3。
     */
    public String getEmpRelationExtAttr3() {
        return empRelationExtAttr3;
    }

    /**
     * 设置人员关系扩展属性3。
     * 
     * @param empRelationExtAttr3
     *        人员关系扩展属性3。
     */
    public void setEmpRelationExtAttr3(String empRelationExtAttr3) {
        this.empRelationExtAttr3 = empRelationExtAttr3;
    }

    /**
     * 获取人员关系扩展属性4。
     * 
     * @return 人员关系扩展属性4。
     */
    public String getEmpRelationExtAttr4() {
        return empRelationExtAttr4;
    }

    /**
     * 设置人员关系扩展属性4。
     * 
     * @param empRelationExtAttr4
     *        人员关系扩展属性4。
     */
    public void setEmpRelationExtAttr4(String empRelationExtAttr4) {
        this.empRelationExtAttr4 = empRelationExtAttr4;
    }

    /**
     * 获取人员关系扩展属性5。
     * 
     * @return 人员关系扩展属性5。
     */
    public String getEmpRelationExtAttr5() {
        return empRelationExtAttr5;
    }

    /**
     * 设置人员关系扩展属性5。
     * 
     * @param empRelationExtAttr5
     *        人员关系扩展属性5。
     */
    public void setEmpRelationExtAttr5(String empRelationExtAttr5) {
        this.empRelationExtAttr5 = empRelationExtAttr5;
    }

    /**
     * 获取人员关系扩展属性6。
     * 
     * @return 人员关系扩展属性6。
     */
    public String getEmpRelationExtAttr6() {
        return empRelationExtAttr6;
    }

    /**
     * 设置人员关系扩展属性6。
     * 
     * @param empRelationExtAttr6
     *        人员关系扩展属性6。
     */
    public void setEmpRelationExtAttr6(String empRelationExtAttr6) {
        this.empRelationExtAttr6 = empRelationExtAttr6;
    }

    /**
     * 获取人员关系扩展属性7。
     * 
     * @return 人员关系扩展属性7。
     */
    public String getEmpRelationExtAttr7() {
        return empRelationExtAttr7;
    }

    /**
     * 设置人员关系扩展属性7。
     * 
     * @param empRelationExtAttr7
     *        人员关系扩展属性7。
     */
    public void setEmpRelationExtAttr7(String empRelationExtAttr7) {
        this.empRelationExtAttr7 = empRelationExtAttr7;
    }

    /**
     * 获取人员关系扩展属性8。
     * 
     * @return 人员关系扩展属性8。
     */
    public String getEmpRelationExtAttr8() {
        return empRelationExtAttr8;
    }

    /**
     * 设置人员关系扩展属性8。
     * 
     * @param empRelationExtAttr8
     *        人员关系扩展属性8。
     */
    public void setEmpRelationExtAttr8(String empRelationExtAttr8) {
        this.empRelationExtAttr8 = empRelationExtAttr8;
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
     * 获取人员关系状态。
     * 
     * @return 人员关系状态。
     */
    public String getEmpRelationStatus() {
        return empRelationStatus;
    }

    /**
     * 设置人员关系状态。
     * 
     * @param empRelationStatus
     *        人员关系状态。
     */
    public void setEmpRelationStatus(String empRelationStatus) {
        this.empRelationStatus = empRelationStatus;
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
     * 获取上级人员ID。
     * 
     * @return 上级人员ID。
     */
    public String getUpperEmpId() {
        return upperEmpId;
    }

    /**
     * 设置上级人员ID。
     * 
     * @param upperEmpId
     *        上级人员ID。
     */
    public void setUpperEmpId(String upperEmpId) {
        this.upperEmpId = upperEmpId;
    }

    /**
     * 获取上级人员编码。
     * 
     * @return 上级人员编码。
     */
    public String getUpperEmpCode() {
        return upperEmpCode;
    }

    /**
     * 设置上级人员编码。
     * 
     * @param upperEmpCode
     *        上级人员编码。
     */
    public void setUpperEmpCode(String upperEmpCode) {
        this.upperEmpCode = upperEmpCode;
    }

    /**
     * 获取上级人员名称。
     * 
     * @return 上级人员名称。
     */
    public String getUpperEmpName() {
        return upperEmpName;
    }

    /**
     * 设置上级人员名称。
     * 
     * @param upperEmpName
     *        上级人员名称。
     */
    public void setUpperEmpName(String upperEmpName) {
        this.upperEmpName = upperEmpName;
    }

    /**
     * 获取上级密码重置。
     * 
     * @return 上级密码重置。
     */
    public String getUpperPasswordResetReq() {
        return upperPasswordResetReq;
    }

    /**
     * 设置上级密码重置。
     * 
     * @param upperPasswordResetReq
     *        上级密码重置。
     */
    public void setUpperPasswordResetReq(String upperPasswordResetReq) {
        this.upperPasswordResetReq = upperPasswordResetReq;
    }

    /**
     * 获取上级政治面貌。
     * 
     * @return 上级政治面貌。
     */
    public String getUpperParty() {
        return upperParty;
    }

    /**
     * 设置上级政治面貌。
     * 
     * @param upperParty
     *        上级政治面貌。
     */
    public void setUpperParty(String upperParty) {
        this.upperParty = upperParty;
    }

    /**
     * 获取上级职级。
     * 
     * @return 上级职级。
     */
    public String getUpperEmpLevel() {
        return upperEmpLevel;
    }

    /**
     * 设置上级职级。
     * 
     * @param upperEmpLevel
     *        上级职级。
     */
    public void setUpperEmpLevel(String upperEmpLevel) {
        this.upperEmpLevel = upperEmpLevel;
    }

    /**
     * 获取上级性别。
     * 
     * @return 上级性别。
     */
    public String getUpperGender() {
        return upperGender;
    }

    /**
     * 设置上级性别。
     * 
     * @param upperGender
     *        上级性别。
     */
    public void setUpperGender(String upperGender) {
        this.upperGender = upperGender;
    }

    /**
     * 获取上级出生日期。
     * 
     * @return 上级出生日期。
     */
    public Date getUpperBirthDate() {
        return upperBirthDate;
    }

    /**
     * 设置上级出生日期。
     * 
     * @param upperBirthDate
     *        上级出生日期。
     */
    public void setUpperBirthDate(Date upperBirthDate) {
        this.upperBirthDate = upperBirthDate;
    }

    /**
     * 获取上级电话。
     * 
     * @return 上级电话。
     */
    public String getUpperTel() {
        return upperTel;
    }

    /**
     * 设置上级电话。
     * 
     * @param upperTel
     *        上级电话。
     */
    public void setUpperTel(String upperTel) {
        this.upperTel = upperTel;
    }

    /**
     * 获取上级电子邮箱。
     * 
     * @return 上级电子邮箱。
     */
    public String getUpperEmail() {
        return upperEmail;
    }

    /**
     * 设置上级电子邮箱。
     * 
     * @param upperEmail
     *        上级电子邮箱。
     */
    public void setUpperEmail(String upperEmail) {
        this.upperEmail = upperEmail;
    }

    /**
     * 获取上级入职日期。
     * 
     * @return 上级入职日期。
     */
    public Date getUpperInDate() {
        return upperInDate;
    }

    /**
     * 设置上级入职日期。
     * 
     * @param upperInDate
     *        上级入职日期。
     */
    public void setUpperInDate(Date upperInDate) {
        this.upperInDate = upperInDate;
    }

    /**
     * 获取上级离职日期。
     * 
     * @return 上级离职日期。
     */
    public Date getUpperOutDate() {
        return upperOutDate;
    }

    /**
     * 设置上级离职日期。
     * 
     * @param upperOutDate
     *        上级离职日期。
     */
    public void setUpperOutDate(Date upperOutDate) {
        this.upperOutDate = upperOutDate;
    }

    /**
     * 获取上级人员分类。
     * 
     * @return 上级人员分类。
     */
    public String getUpperEmpCategory() {
        return upperEmpCategory;
    }

    /**
     * 设置上级人员分类。
     * 
     * @param upperEmpCategory
     *        上级人员分类。
     */
    public void setUpperEmpCategory(String upperEmpCategory) {
        this.upperEmpCategory = upperEmpCategory;
    }

    /**
     * 获取上级人员标签。
     * 
     * @return 上级人员标签。
     */
    public String getUpperEmpTag() {
        return upperEmpTag;
    }

    /**
     * 设置上级人员标签。
     * 
     * @param upperEmpTag
     *        上级人员标签。
     */
    public void setUpperEmpTag(String upperEmpTag) {
        this.upperEmpTag = upperEmpTag;
    }

    /**
     * 获取上级人员扩展属性1。
     * 
     * @return 上级人员扩展属性1。
     */
    public String getUpperEmpExtAttr1() {
        return upperEmpExtAttr1;
    }

    /**
     * 设置上级人员扩展属性1。
     * 
     * @param upperEmpExtAttr1
     *        上级人员扩展属性1。
     */
    public void setUpperEmpExtAttr1(String upperEmpExtAttr1) {
        this.upperEmpExtAttr1 = upperEmpExtAttr1;
    }

    /**
     * 获取上级人员扩展属性2。
     * 
     * @return 上级人员扩展属性2。
     */
    public String getUpperEmpExtAttr2() {
        return upperEmpExtAttr2;
    }

    /**
     * 设置上级人员扩展属性2。
     * 
     * @param upperEmpExtAttr2
     *        上级人员扩展属性2。
     */
    public void setUpperEmpExtAttr2(String upperEmpExtAttr2) {
        this.upperEmpExtAttr2 = upperEmpExtAttr2;
    }

    /**
     * 获取上级人员扩展属性3。
     * 
     * @return 上级人员扩展属性3。
     */
    public String getUpperEmpExtAttr3() {
        return upperEmpExtAttr3;
    }

    /**
     * 设置上级人员扩展属性3。
     * 
     * @param upperEmpExtAttr3
     *        上级人员扩展属性3。
     */
    public void setUpperEmpExtAttr3(String upperEmpExtAttr3) {
        this.upperEmpExtAttr3 = upperEmpExtAttr3;
    }

    /**
     * 获取上级人员扩展属性4。
     * 
     * @return 上级人员扩展属性4。
     */
    public String getUpperEmpExtAttr4() {
        return upperEmpExtAttr4;
    }

    /**
     * 设置上级人员扩展属性4。
     * 
     * @param upperEmpExtAttr4
     *        上级人员扩展属性4。
     */
    public void setUpperEmpExtAttr4(String upperEmpExtAttr4) {
        this.upperEmpExtAttr4 = upperEmpExtAttr4;
    }

    /**
     * 获取上级人员扩展属性5。
     * 
     * @return 上级人员扩展属性5。
     */
    public String getUpperEmpExtAttr5() {
        return upperEmpExtAttr5;
    }

    /**
     * 设置上级人员扩展属性5。
     * 
     * @param upperEmpExtAttr5
     *        上级人员扩展属性5。
     */
    public void setUpperEmpExtAttr5(String upperEmpExtAttr5) {
        this.upperEmpExtAttr5 = upperEmpExtAttr5;
    }

    /**
     * 获取上级人员扩展属性6。
     * 
     * @return 上级人员扩展属性6。
     */
    public String getUpperEmpExtAttr6() {
        return upperEmpExtAttr6;
    }

    /**
     * 设置上级人员扩展属性6。
     * 
     * @param upperEmpExtAttr6
     *        上级人员扩展属性6。
     */
    public void setUpperEmpExtAttr6(String upperEmpExtAttr6) {
        this.upperEmpExtAttr6 = upperEmpExtAttr6;
    }

    /**
     * 获取上级人员扩展属性7。
     * 
     * @return 上级人员扩展属性7。
     */
    public String getUpperEmpExtAttr7() {
        return upperEmpExtAttr7;
    }

    /**
     * 设置上级人员扩展属性7。
     * 
     * @param upperEmpExtAttr7
     *        上级人员扩展属性7。
     */
    public void setUpperEmpExtAttr7(String upperEmpExtAttr7) {
        this.upperEmpExtAttr7 = upperEmpExtAttr7;
    }

    /**
     * 获取上级人员扩展属性8。
     * 
     * @return 上级人员扩展属性8。
     */
    public String getUpperEmpExtAttr8() {
        return upperEmpExtAttr8;
    }

    /**
     * 设置上级人员扩展属性8。
     * 
     * @param upperEmpExtAttr8
     *        上级人员扩展属性8。
     */
    public void setUpperEmpExtAttr8(String upperEmpExtAttr8) {
        this.upperEmpExtAttr8 = upperEmpExtAttr8;
    }

    /**
     * 获取上级人员状态。
     * 
     * @return 上级人员状态。
     */
    public String getUpperEmpStatus() {
        return upperEmpStatus;
    }

    /**
     * 设置上级人员状态。
     * 
     * @param upperEmpStatus
     *        上级人员状态。
     */
    public void setUpperEmpStatus(String upperEmpStatus) {
        this.upperEmpStatus = upperEmpStatus;
    }

    /**
     * 获取上级机构ID。
     * 
     * @return 上级机构ID。
     */
    public String getUpperOrgId() {
        return upperOrgId;
    }

    /**
     * 设置上级机构ID。
     * 
     * @param upperOrgId
     *        上级机构ID。
     */
    public void setUpperOrgId(String upperOrgId) {
        this.upperOrgId = upperOrgId;
    }

    /**
     * 获取上级上级机构ID。
     * 
     * @return 上级上级机构ID。
     */
    public String getUpperParentOrgId() {
        return upperParentOrgId;
    }

    /**
     * 设置上级上级机构ID。
     * 
     * @param upperParentOrgId
     *        上级上级机构ID。
     */
    public void setUpperParentOrgId(String upperParentOrgId) {
        this.upperParentOrgId = upperParentOrgId;
    }

    /**
     * 获取上级机构编码。
     * 
     * @return 上级机构编码。
     */
    public String getUpperOrgCode() {
        return upperOrgCode;
    }

    /**
     * 设置上级机构编码。
     * 
     * @param upperOrgCode
     *        上级机构编码。
     */
    public void setUpperOrgCode(String upperOrgCode) {
        this.upperOrgCode = upperOrgCode;
    }

    /**
     * 获取上级机构名称。
     * 
     * @return 上级机构名称。
     */
    public String getUpperOrgName() {
        return upperOrgName;
    }

    /**
     * 设置上级机构名称。
     * 
     * @param upperOrgName
     *        上级机构名称。
     */
    public void setUpperOrgName(String upperOrgName) {
        this.upperOrgName = upperOrgName;
    }

    /**
     * 获取上级机构简称。
     * 
     * @return 上级机构简称。
     */
    public String getUpperOrgAbbrName() {
        return upperOrgAbbrName;
    }

    /**
     * 设置上级机构简称。
     * 
     * @param upperOrgAbbrName
     *        上级机构简称。
     */
    public void setUpperOrgAbbrName(String upperOrgAbbrName) {
        this.upperOrgAbbrName = upperOrgAbbrName;
    }

    /**
     * 获取上级机构类型。
     * 
     * @return 上级机构类型。
     */
    public String getUpperOrgType() {
        return upperOrgType;
    }

    /**
     * 设置上级机构类型。
     * 
     * @param upperOrgType
     *        上级机构类型。
     */
    public void setUpperOrgType(String upperOrgType) {
        this.upperOrgType = upperOrgType;
    }

    /**
     * 获取上级机构分类。
     * 
     * @return 上级机构分类。
     */
    public String getUpperOrgCategory() {
        return upperOrgCategory;
    }

    /**
     * 设置上级机构分类。
     * 
     * @param upperOrgCategory
     *        上级机构分类。
     */
    public void setUpperOrgCategory(String upperOrgCategory) {
        this.upperOrgCategory = upperOrgCategory;
    }

    /**
     * 获取上级机构标签。
     * 
     * @return 上级机构标签。
     */
    public String getUpperOrgTag() {
        return upperOrgTag;
    }

    /**
     * 设置上级机构标签。
     * 
     * @param upperOrgTag
     *        上级机构标签。
     */
    public void setUpperOrgTag(String upperOrgTag) {
        this.upperOrgTag = upperOrgTag;
    }

    /**
     * 获取上级机构扩展属性1。
     * 
     * @return 上级机构扩展属性1。
     */
    public String getUpperOrgExtAttr1() {
        return upperOrgExtAttr1;
    }

    /**
     * 设置上级机构扩展属性1。
     * 
     * @param upperOrgExtAttr1
     *        上级机构扩展属性1。
     */
    public void setUpperOrgExtAttr1(String upperOrgExtAttr1) {
        this.upperOrgExtAttr1 = upperOrgExtAttr1;
    }

    /**
     * 获取上级机构扩展属性2。
     * 
     * @return 上级机构扩展属性2。
     */
    public String getUpperOrgExtAttr2() {
        return upperOrgExtAttr2;
    }

    /**
     * 设置上级机构扩展属性2。
     * 
     * @param upperOrgExtAttr2
     *        上级机构扩展属性2。
     */
    public void setUpperOrgExtAttr2(String upperOrgExtAttr2) {
        this.upperOrgExtAttr2 = upperOrgExtAttr2;
    }

    /**
     * 获取上级机构扩展属性3。
     * 
     * @return 上级机构扩展属性3。
     */
    public String getUpperOrgExtAttr3() {
        return upperOrgExtAttr3;
    }

    /**
     * 设置上级机构扩展属性3。
     * 
     * @param upperOrgExtAttr3
     *        上级机构扩展属性3。
     */
    public void setUpperOrgExtAttr3(String upperOrgExtAttr3) {
        this.upperOrgExtAttr3 = upperOrgExtAttr3;
    }

    /**
     * 获取上级机构扩展属性4。
     * 
     * @return 上级机构扩展属性4。
     */
    public String getUpperOrgExtAttr4() {
        return upperOrgExtAttr4;
    }

    /**
     * 设置上级机构扩展属性4。
     * 
     * @param upperOrgExtAttr4
     *        上级机构扩展属性4。
     */
    public void setUpperOrgExtAttr4(String upperOrgExtAttr4) {
        this.upperOrgExtAttr4 = upperOrgExtAttr4;
    }

    /**
     * 获取上级机构扩展属性5。
     * 
     * @return 上级机构扩展属性5。
     */
    public String getUpperOrgExtAttr5() {
        return upperOrgExtAttr5;
    }

    /**
     * 设置上级机构扩展属性5。
     * 
     * @param upperOrgExtAttr5
     *        上级机构扩展属性5。
     */
    public void setUpperOrgExtAttr5(String upperOrgExtAttr5) {
        this.upperOrgExtAttr5 = upperOrgExtAttr5;
    }

    /**
     * 获取上级机构扩展属性6。
     * 
     * @return 上级机构扩展属性6。
     */
    public String getUpperOrgExtAttr6() {
        return upperOrgExtAttr6;
    }

    /**
     * 设置上级机构扩展属性6。
     * 
     * @param upperOrgExtAttr6
     *        上级机构扩展属性6。
     */
    public void setUpperOrgExtAttr6(String upperOrgExtAttr6) {
        this.upperOrgExtAttr6 = upperOrgExtAttr6;
    }

    /**
     * 获取上级机构扩展属性7。
     * 
     * @return 上级机构扩展属性7。
     */
    public String getUpperOrgExtAttr7() {
        return upperOrgExtAttr7;
    }

    /**
     * 设置上级机构扩展属性7。
     * 
     * @param upperOrgExtAttr7
     *        上级机构扩展属性7。
     */
    public void setUpperOrgExtAttr7(String upperOrgExtAttr7) {
        this.upperOrgExtAttr7 = upperOrgExtAttr7;
    }

    /**
     * 获取上级机构扩展属性8。
     * 
     * @return 上级机构扩展属性8。
     */
    public String getUpperOrgExtAttr8() {
        return upperOrgExtAttr8;
    }

    /**
     * 设置上级机构扩展属性8。
     * 
     * @param upperOrgExtAttr8
     *        上级机构扩展属性8。
     */
    public void setUpperOrgExtAttr8(String upperOrgExtAttr8) {
        this.upperOrgExtAttr8 = upperOrgExtAttr8;
    }

    /**
     * 获取上级机构状态。
     * 
     * @return 上级机构状态。
     */
    public String getUpperOrgStatus() {
        return upperOrgStatus;
    }

    /**
     * 设置上级机构状态。
     * 
     * @param upperOrgStatus
     *        上级机构状态。
     */
    public void setUpperOrgStatus(String upperOrgStatus) {
        this.upperOrgStatus = upperOrgStatus;
    }

    /**
     * 获取上级上级机构编码。
     * 
     * @return 上级上级机构编码。
     */
    public String getUpperParentOrgCode() {
        return upperParentOrgCode;
    }

    /**
     * 设置上级上级机构编码。
     * 
     * @param upperParentOrgCode
     *        上级上级机构编码。
     */
    public void setUpperParentOrgCode(String upperParentOrgCode) {
        this.upperParentOrgCode = upperParentOrgCode;
    }

    /**
     * 获取上级上级机构名称。
     * 
     * @return 上级上级机构名称。
     */
    public String getUpperParentOrgName() {
        return upperParentOrgName;
    }

    /**
     * 设置上级上级机构名称。
     * 
     * @param upperParentOrgName
     *        上级上级机构名称。
     */
    public void setUpperParentOrgName(String upperParentOrgName) {
        this.upperParentOrgName = upperParentOrgName;
    }

    /**
     * 获取下级人员ID。
     * 
     * @return 下级人员ID。
     */
    public String getLowerEmpId() {
        return lowerEmpId;
    }

    /**
     * 设置下级人员ID。
     * 
     * @param lowerEmpId
     *        下级人员ID。
     */
    public void setLowerEmpId(String lowerEmpId) {
        this.lowerEmpId = lowerEmpId;
    }

    /**
     * 获取下级人员编码。
     * 
     * @return 下级人员编码。
     */
    public String getLowerEmpCode() {
        return lowerEmpCode;
    }

    /**
     * 设置下级人员编码。
     * 
     * @param lowerEmpCode
     *        下级人员编码。
     */
    public void setLowerEmpCode(String lowerEmpCode) {
        this.lowerEmpCode = lowerEmpCode;
    }

    /**
     * 获取下级人员名称。
     * 
     * @return 下级人员名称。
     */
    public String getLowerEmpName() {
        return lowerEmpName;
    }

    /**
     * 设置下级人员名称。
     * 
     * @param lowerEmpName
     *        下级人员名称。
     */
    public void setLowerEmpName(String lowerEmpName) {
        this.lowerEmpName = lowerEmpName;
    }

    /**
     * 获取下级密码重置。
     * 
     * @return 下级密码重置。
     */
    public String getLowerPasswordResetReq() {
        return lowerPasswordResetReq;
    }

    /**
     * 设置下级密码重置。
     * 
     * @param lowerPasswordResetReq
     *        下级密码重置。
     */
    public void setLowerPasswordResetReq(String lowerPasswordResetReq) {
        this.lowerPasswordResetReq = lowerPasswordResetReq;
    }

    /**
     * 获取下级政治面貌。
     * 
     * @return 下级政治面貌。
     */
    public String getLowerParty() {
        return lowerParty;
    }

    /**
     * 设置下级政治面貌。
     * 
     * @param lowerParty
     *        下级政治面貌。
     */
    public void setLowerParty(String lowerParty) {
        this.lowerParty = lowerParty;
    }

    /**
     * 获取下级职级。
     * 
     * @return 下级职级。
     */
    public String getLowerEmpLevel() {
        return lowerEmpLevel;
    }

    /**
     * 设置下级职级。
     * 
     * @param lowerEmpLevel
     *        下级职级。
     */
    public void setLowerEmpLevel(String lowerEmpLevel) {
        this.lowerEmpLevel = lowerEmpLevel;
    }

    /**
     * 获取下级性别。
     * 
     * @return 下级性别。
     */
    public String getLowerGender() {
        return lowerGender;
    }

    /**
     * 设置下级性别。
     * 
     * @param lowerGender
     *        下级性别。
     */
    public void setLowerGender(String lowerGender) {
        this.lowerGender = lowerGender;
    }

    /**
     * 获取下级出生日期。
     * 
     * @return 下级出生日期。
     */
    public Date getLowerBirthDate() {
        return lowerBirthDate;
    }

    /**
     * 设置下级出生日期。
     * 
     * @param lowerBirthDate
     *        下级出生日期。
     */
    public void setLowerBirthDate(Date lowerBirthDate) {
        this.lowerBirthDate = lowerBirthDate;
    }

    /**
     * 获取下级电话。
     * 
     * @return 下级电话。
     */
    public String getLowerTel() {
        return lowerTel;
    }

    /**
     * 设置下级电话。
     * 
     * @param lowerTel
     *        下级电话。
     */
    public void setLowerTel(String lowerTel) {
        this.lowerTel = lowerTel;
    }

    /**
     * 获取下级电子邮箱。
     * 
     * @return 下级电子邮箱。
     */
    public String getLowerEmail() {
        return lowerEmail;
    }

    /**
     * 设置下级电子邮箱。
     * 
     * @param lowerEmail
     *        下级电子邮箱。
     */
    public void setLowerEmail(String lowerEmail) {
        this.lowerEmail = lowerEmail;
    }

    /**
     * 获取下级入职日期。
     * 
     * @return 下级入职日期。
     */
    public Date getLowerInDate() {
        return lowerInDate;
    }

    /**
     * 设置下级入职日期。
     * 
     * @param lowerInDate
     *        下级入职日期。
     */
    public void setLowerInDate(Date lowerInDate) {
        this.lowerInDate = lowerInDate;
    }

    /**
     * 获取下级离职日期。
     * 
     * @return 下级离职日期。
     */
    public Date getLowerOutDate() {
        return lowerOutDate;
    }

    /**
     * 设置下级离职日期。
     * 
     * @param lowerOutDate
     *        下级离职日期。
     */
    public void setLowerOutDate(Date lowerOutDate) {
        this.lowerOutDate = lowerOutDate;
    }

    /**
     * 获取下级人员分类。
     * 
     * @return 下级人员分类。
     */
    public String getLowerEmpCategory() {
        return lowerEmpCategory;
    }

    /**
     * 设置下级人员分类。
     * 
     * @param lowerEmpCategory
     *        下级人员分类。
     */
    public void setLowerEmpCategory(String lowerEmpCategory) {
        this.lowerEmpCategory = lowerEmpCategory;
    }

    /**
     * 获取下级人员标签。
     * 
     * @return 下级人员标签。
     */
    public String getLowerEmpTag() {
        return lowerEmpTag;
    }

    /**
     * 设置下级人员标签。
     * 
     * @param lowerEmpTag
     *        下级人员标签。
     */
    public void setLowerEmpTag(String lowerEmpTag) {
        this.lowerEmpTag = lowerEmpTag;
    }

    /**
     * 获取下级人员扩展属性1。
     * 
     * @return 下级人员扩展属性1。
     */
    public String getLowerEmpExtAttr1() {
        return lowerEmpExtAttr1;
    }

    /**
     * 设置下级人员扩展属性1。
     * 
     * @param lowerEmpExtAttr1
     *        下级人员扩展属性1。
     */
    public void setLowerEmpExtAttr1(String lowerEmpExtAttr1) {
        this.lowerEmpExtAttr1 = lowerEmpExtAttr1;
    }

    /**
     * 获取 下级人员扩展属性2。
     * 
     * @return 下级人员扩展属性2。
     */
    public String getLowerEmpExtAttr2() {
        return lowerEmpExtAttr2;
    }

    /**
     * 设置下级人员扩展属性2。
     * 
     * @param lowerEmpExtAttr2
     *        下级人员扩展属性2。
     */
    public void setLowerEmpExtAttr2(String lowerEmpExtAttr2) {
        this.lowerEmpExtAttr2 = lowerEmpExtAttr2;
    }

    /**
     * 获取下级人员扩展属性3。
     * 
     * @return 下级人员扩展属性3。
     */
    public String getLowerEmpExtAttr3() {
        return lowerEmpExtAttr3;
    }

    /**
     * 设置下级人员扩展属性3。
     * 
     * @param lowerEmpExtAttr3
     *        下级人员扩展属性3。
     */
    public void setLowerEmpExtAttr3(String lowerEmpExtAttr3) {
        this.lowerEmpExtAttr3 = lowerEmpExtAttr3;
    }

    /**
     * 获取下级人员扩展属性4。
     * 
     * @return 下级人员扩展属性4。
     */
    public String getLowerEmpExtAttr4() {
        return lowerEmpExtAttr4;
    }

    /**
     * 设置下级人员扩展属性4。
     * 
     * @param lowerEmpExtAttr4
     *        下级人员扩展属性4。
     */
    public void setLowerEmpExtAttr4(String lowerEmpExtAttr4) {
        this.lowerEmpExtAttr4 = lowerEmpExtAttr4;
    }

    /**
     * 获取下级人员扩展属性5。
     * 
     * @return 下级人员扩展属性5。
     */
    public String getLowerEmpExtAttr5() {
        return lowerEmpExtAttr5;
    }

    /**
     * 设置下级人员扩展属性5。
     * 
     * @param lowerEmpExtAttr5
     *        下级人员扩展属性5。
     */
    public void setLowerEmpExtAttr5(String lowerEmpExtAttr5) {
        this.lowerEmpExtAttr5 = lowerEmpExtAttr5;
    }

    /**
     * 获取下级人员扩展属性6。
     * 
     * @return 下级人员扩展属性6。
     */
    public String getLowerEmpExtAttr6() {
        return lowerEmpExtAttr6;
    }

    /**
     * 设置下级人员扩展属性6。
     * 
     * @param lowerEmpExtAttr6
     *        下级人员扩展属性6。
     */
    public void setLowerEmpExtAttr6(String lowerEmpExtAttr6) {
        this.lowerEmpExtAttr6 = lowerEmpExtAttr6;
    }

    /**
     * 获取下级人员扩展属性7。
     * 
     * @return 下级人员扩展属性7。
     */
    public String getLowerEmpExtAttr7() {
        return lowerEmpExtAttr7;
    }

    /**
     * 设置下级人员扩展属性7。
     * 
     * @param lowerEmpExtAttr7
     *        下级人员扩展属性7。
     */
    public void setLowerEmpExtAttr7(String lowerEmpExtAttr7) {
        this.lowerEmpExtAttr7 = lowerEmpExtAttr7;
    }

    /**
     * 获取下级人员扩展属性8。
     * 
     * @return 下级人员扩展属性8。
     */
    public String getLowerEmpExtAttr8() {
        return lowerEmpExtAttr8;
    }

    /**
     * 设置下级人员扩展属性8。
     * 
     * @param lowerEmpExtAttr8
     *        下级人员扩展属性8。
     */
    public void setLowerEmpExtAttr8(String lowerEmpExtAttr8) {
        this.lowerEmpExtAttr8 = lowerEmpExtAttr8;
    }

    /**
     * 获取下级人员状态。
     * 
     * @return 下级人员状态。
     */
    public String getLowerEmpStatus() {
        return lowerEmpStatus;
    }

    /**
     * 设置下级人员状态。
     * 
     * @param lowerEmpStatus
     *        下级人员状态。
     */
    public void setLowerEmpStatus(String lowerEmpStatus) {
        this.lowerEmpStatus = lowerEmpStatus;
    }

    /**
     * 获取下级机构ID。
     * 
     * @return 下级机构ID。
     */
    public String getLowerOrgId() {
        return lowerOrgId;
    }

    /**
     * 设置下级机构ID。
     * 
     * @param lowerOrgId
     *        下级机构ID。
     */
    public void setLowerOrgId(String lowerOrgId) {
        this.lowerOrgId = lowerOrgId;
    }

    /**
     * 获取下级上级机构ID。
     * 
     * @return 下级上级机构ID。
     */
    public String getLowerParentOrgId() {
        return lowerParentOrgId;
    }

    /**
     * 设置下级上级机构ID。
     * 
     * @param lowerParentOrgId
     *        下级上级机构ID。
     */
    public void setLowerParentOrgId(String lowerParentOrgId) {
        this.lowerParentOrgId = lowerParentOrgId;
    }

    /**
     * 获取下级机构编码。
     * 
     * @return 下级机构编码。
     */
    public String getLowerOrgCode() {
        return lowerOrgCode;
    }

    /**
     * 设置下级机构编码。
     * 
     * @param lowerOrgCode
     *        下级机构编码。
     */
    public void setLowerOrgCode(String lowerOrgCode) {
        this.lowerOrgCode = lowerOrgCode;
    }

    /**
     * 获取下级机构名称。
     * 
     * @return 下级机构名称。
     */
    public String getLowerOrgName() {
        return lowerOrgName;
    }

    /**
     * 设置下级机构名称。
     * 
     * @param lowerOrgName
     *        下级机构名称。
     */
    public void setLowerOrgName(String lowerOrgName) {
        this.lowerOrgName = lowerOrgName;
    }

    /**
     * 获取下级机构简称。
     * 
     * @return 下级机构简称。
     */
    public String getLowerOrgAbbrName() {
        return lowerOrgAbbrName;
    }

    /**
     * 设置下级机构简称。
     * 
     * @param lowerOrgAbbrName
     *        下级机构简称。
     */
    public void setLowerOrgAbbrName(String lowerOrgAbbrName) {
        this.lowerOrgAbbrName = lowerOrgAbbrName;
    }

    /**
     * 获取下级机构类型。
     * 
     * @return 下级机构类型。
     */
    public String getLowerOrgType() {
        return lowerOrgType;
    }

    /**
     * 设置下级机构类型。
     * 
     * @param lowerOrgType
     *        下级机构类型。
     */
    public void setLowerOrgType(String lowerOrgType) {
        this.lowerOrgType = lowerOrgType;
    }

    /**
     * 获取下级机构分类。
     * 
     * @return 下级机构分类。
     */
    public String getLowerOrgCategory() {
        return lowerOrgCategory;
    }

    /**
     * 设置下级机构分类。
     * 
     * @param lowerOrgCategory
     *        下级机构分类。
     */
    public void setLowerOrgCategory(String lowerOrgCategory) {
        this.lowerOrgCategory = lowerOrgCategory;
    }

    /**
     * 获取下级机构标签。
     * 
     * @return 下级机构标签。
     */
    public String getLowerOrgTag() {
        return lowerOrgTag;
    }

    /**
     * 设置下级机构标签。
     * 
     * @param lowerOrgTag
     *        下级机构标签。
     */
    public void setLowerOrgTag(String lowerOrgTag) {
        this.lowerOrgTag = lowerOrgTag;
    }

    /**
     * 获取下级机构扩展属性1。
     * 
     * @return 下级机构扩展属性1。
     */
    public String getLowerOrgExtAttr1() {
        return lowerOrgExtAttr1;
    }

    /**
     * 设置下级机构扩展属性1。
     * 
     * @param lowerOrgExtAttr1
     *        下级机构扩展属性1。
     */
    public void setLowerOrgExtAttr1(String lowerOrgExtAttr1) {
        this.lowerOrgExtAttr1 = lowerOrgExtAttr1;
    }

    /**
     * 获取下级机构扩展属性2。
     * 
     * @return 下级机构扩展属性2。
     */
    public String getLowerOrgExtAttr2() {
        return lowerOrgExtAttr2;
    }

    /**
     * 设置下级机构扩展属性2。
     * 
     * @param lowerOrgExtAttr2
     *        下级机构扩展属性2。
     */
    public void setLowerOrgExtAttr2(String lowerOrgExtAttr2) {
        this.lowerOrgExtAttr2 = lowerOrgExtAttr2;
    }

    /**
     * 获取下级机构扩展属性3。
     * 
     * @return 下级机构扩展属性3。
     */
    public String getLowerOrgExtAttr3() {
        return lowerOrgExtAttr3;
    }

    /**
     * 设置下级机构扩展属性3。
     * 
     * @param lowerOrgExtAttr3
     *        下级机构扩展属性3。
     */
    public void setLowerOrgExtAttr3(String lowerOrgExtAttr3) {
        this.lowerOrgExtAttr3 = lowerOrgExtAttr3;
    }

    /**
     * 获取下级机构扩展属性4。
     * 
     * @return 下级机构扩展属性4。
     */
    public String getLowerOrgExtAttr4() {
        return lowerOrgExtAttr4;
    }

    /**
     * 设置下级机构扩展属性4。
     * 
     * @param lowerOrgExtAttr4
     *        下级机构扩展属性4。
     */
    public void setLowerOrgExtAttr4(String lowerOrgExtAttr4) {
        this.lowerOrgExtAttr4 = lowerOrgExtAttr4;
    }

    /**
     * 获取下级机构扩展属性5。
     * 
     * @return 下级机构扩展属性5。
     */
    public String getLowerOrgExtAttr5() {
        return lowerOrgExtAttr5;
    }

    /**
     * 设置下级机构扩展属性5。
     * 
     * @param lowerOrgExtAttr5
     *        下级机构扩展属性5。
     */
    public void setLowerOrgExtAttr5(String lowerOrgExtAttr5) {
        this.lowerOrgExtAttr5 = lowerOrgExtAttr5;
    }

    /**
     * 获取下级机构扩展属性6。
     * 
     * @return 下级机构扩展属性6。
     */
    public String getLowerOrgExtAttr6() {
        return lowerOrgExtAttr6;
    }

    /**
     * 设置下级机构扩展属性6。
     * 
     * @param lowerOrgExtAttr6
     *        下级机构扩展属性6。
     */
    public void setLowerOrgExtAttr6(String lowerOrgExtAttr6) {
        this.lowerOrgExtAttr6 = lowerOrgExtAttr6;
    }

    /**
     * 获取下级机构扩展属性7。
     * 
     * @return 下级机构扩展属性7。
     */
    public String getLowerOrgExtAttr7() {
        return lowerOrgExtAttr7;
    }

    /**
     * 设置下级机构扩展属性7。
     * 
     * @param lowerOrgExtAttr7
     *        下级机构扩展属性7。
     */
    public void setLowerOrgExtAttr7(String lowerOrgExtAttr7) {
        this.lowerOrgExtAttr7 = lowerOrgExtAttr7;
    }

    /**
     * 获取下级机构扩展属性8。
     * 
     * @return 下级机构扩展属性8。
     */
    public String getLowerOrgExtAttr8() {
        return lowerOrgExtAttr8;
    }

    /**
     * 设置下级机构扩展属性8。
     * 
     * @param lowerOrgExtAttr8
     *        下级机构扩展属性8。
     */
    public void setLowerOrgExtAttr8(String lowerOrgExtAttr8) {
        this.lowerOrgExtAttr8 = lowerOrgExtAttr8;
    }

    /**
     * 获取下级机构状态。
     * 
     * @return 下级机构状态。
     */
    public String getLowerOrgStatus() {
        return lowerOrgStatus;
    }

    /**
     * 设置下级机构状态。
     * 
     * @param lowerOrgStatus
     *        下级机构状态。
     */
    public void setLowerOrgStatus(String lowerOrgStatus) {
        this.lowerOrgStatus = lowerOrgStatus;
    }

    /**
     * 获取下级上级机构编码。
     * 
     * @return 下级上级机构编码。
     */
    public String getLowerParentOrgCode() {
        return lowerParentOrgCode;
    }

    /**
     * 设置下级上级机构编码。
     * 
     * @param lowerParentOrgCode
     *        下级上级机构编码。
     */
    public void setLowerParentOrgCode(String lowerParentOrgCode) {
        this.lowerParentOrgCode = lowerParentOrgCode;
    }

    /**
     * 获取下级上级机构名称。
     * 
     * @return 下级上级机构名称。
     */
    public String getLowerParentOrgName() {
        return lowerParentOrgName;
    }

    /**
     * 设置下级上级机构名称。
     * 
     * @param lowerParentOrgName
     *        下级上级机构名称。
     */
    public void setLowerParentOrgName(String lowerParentOrgName) {
        this.lowerParentOrgName = lowerParentOrgName;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(5000);

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