package com.opendynamic.om.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class EmpRelation implements Serializable {
    private static final long serialVersionUID = 1L;

    private String empRelationId; // 人员关系ID
    private String orgnSetId; // 组织架构套ID
    private String upperEmpId; // 上级人员ID
    private String lowerEmpId; // 下级人员ID
    private String empRelation; // 人员关系
    private String empRelationTag;// 人员关系标签
    private String empRelationStatus; // 人员关系状态
    private Date creationDate; // 创建日期
    private Date updateDate; // 修改日期
    private String operatorId; // 操作人员ID
    private String operatorName; // 操作人员名称
    private String orgnSetCode; // 组织架构套编码
    private String orgnSetName; // 组织架构套名称
    private String upperEmpCode; // 上级人员编码
    private String upperEmpName; // 上级人员名称
    private String lowerEmpCode; // 下级人员编码
    private String lowerEmpName; // 下级人员名称

    public EmpRelation() {
    }

    public EmpRelation(Map<String, Object> data) {// 通过数据库表加载
        this.empRelationId = (String) data.get("EMP_RELATION_ID_");
        this.orgnSetId = (String) data.get("ORGN_SET_ID_");
        this.upperEmpId = (String) data.get("UPPER_EMP_ID_");
        this.lowerEmpId = (String) data.get("LOWER_EMP_ID_");
        this.empRelation = (String) data.get("EMP_RELATION_");
        this.empRelationTag = (String) data.get("EMP_RELATION_TAG_");
        this.empRelationStatus = (String) data.get("EMP_RELATION_STATUS_");
        this.creationDate = (Date) data.get("CREATION_DATE_");
        this.updateDate = (Date) data.get("UPDATE_DATE_");
        this.operatorId = (String) data.get("OPERATOR_ID_");
        this.operatorName = (String) data.get("OPERATOR_NAME_");
        this.orgnSetCode = (String) data.get("ORGN_SET_CODE_");
        this.orgnSetName = (String) data.get("ORGN_SET_NAME_");
        this.upperEmpCode = (String) data.get("UPPER_EMP_CODE_");
        this.upperEmpName = (String) data.get("UPPER_EMP_NAME_");
        this.lowerEmpCode = (String) data.get("LOWER_EMP_CODE_");
        this.lowerEmpName = (String) data.get("LOWER_EMP_NAME_");
    }

    public String getEmpRelationId() {
        return empRelationId;
    }

    public void setEmpRelationId(String empRelationId) {
        this.empRelationId = empRelationId;
    }

    public String getOrgnSetId() {
        return orgnSetId;
    }

    public void setOrgnSetId(String orgnSetId) {
        this.orgnSetId = orgnSetId;
    }

    public String getUpperEmpId() {
        return upperEmpId;
    }

    public void setUpperEmpId(String upperEmpId) {
        this.upperEmpId = upperEmpId;
    }

    public String getLowerEmpId() {
        return lowerEmpId;
    }

    public void setLowerEmpId(String lowerEmpId) {
        this.lowerEmpId = lowerEmpId;
    }

    public String getEmpRelation() {
        return empRelation;
    }

    public void setEmpRelation(String empRelation) {
        this.empRelation = empRelation;
    }

    public String getEmpRelationTag() {
        return empRelationTag;
    }

    public void setEmpRelationTag(String empRelationTag) {
        this.empRelationTag = empRelationTag;
    }

    public String getEmpRelationStatus() {
        return empRelationStatus;
    }

    public void setEmpRelationStatus(String empRelationStatus) {
        this.empRelationStatus = empRelationStatus;
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

    public String getUpperEmpCode() {
        return upperEmpCode;
    }

    public void setUpperEmpCode(String upperEmpCode) {
        this.upperEmpCode = upperEmpCode;
    }

    public String getUpperEmpName() {
        return upperEmpName;
    }

    public void setUpperEmpName(String upperEmpName) {
        this.upperEmpName = upperEmpName;
    }

    public String getLowerEmpCode() {
        return lowerEmpCode;
    }

    public void setLowerEmpCode(String lowerEmpCode) {
        this.lowerEmpCode = lowerEmpCode;
    }

    public String getLowerEmpName() {
        return lowerEmpName;
    }

    public void setLowerEmpName(String lowerEmpName) {
        this.lowerEmpName = lowerEmpName;
    }
}