package com.opendynamic.om.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class Posi implements Serializable {
    private static final long serialVersionUID = 1L;

    private String posiId; // 岗位ID
    private String orgnSetId; // 组织架构套ID
    private String orgId; // 机构ID
    private String dutyId; // 职务ID
    private String posiCode; // 岗位编码
    private String posiName; // 岗位名称
    private String dutyLevel; // 机构职级
    private String category; // 分类
    private String memo; // 备注
    private String posiTag; // 岗位标签
    private Integer order; // 排序
    private String posiStatus; // 岗位状态
    private Date creationDate; // 创建日期
    private Date updateDate; // 修改日期
    private String operatorId; // 操作人员ID
    private String operatorName; // 操作人员名称
    private String orgnSetCode; // 组织架构套编码
    private String orgnSetName;// 组织架构套名称
    private String orgCode;// 机构编码
    private String orgName;// 机构名称
    private String dutyCode;// 职务编码
    private String dutyName;// 职务名称

    public Posi() {
    }

    public Posi(Map<String, Object> data) {// 通过数据库表加载
        this.posiId = (String) data.get("POSI_ID_");
        this.orgnSetId = (String) data.get("ORGN_SET_ID_");
        this.orgId = (String) data.get("ORG_ID_");
        this.dutyId = (String) data.get("DUTY_ID_");
        this.posiCode = (String) data.get("POSI_CODE_");
        this.posiName = (String) data.get("POSI_NAME_");
        this.dutyLevel = (String) data.get("DUTY_LEVEL_");
        this.category = (String) data.get("CATEGORY_");
        this.memo = (String) data.get("MEMO_");
        this.posiTag = (String) data.get("POSI_TAG_");
        this.order = (data.get("ORDER_") != null) ? ((BigDecimal) data.get("ORDER_")).intValue() : null;
        this.posiStatus = (String) data.get("POSI_STATUS_");
        this.creationDate = (Date) data.get("CREATION_DATE_");
        this.updateDate = (Date) data.get("UPDATE_DATE_");
        this.operatorId = (String) data.get("OPERATOR_ID_");
        this.operatorName = (String) data.get("OPERATOR_NAME_");
        this.orgnSetCode = (String) data.get("ORGN_SET_CODE_");
        this.orgnSetName = (String) data.get("ORGN_SET_NAME_");
        this.orgCode = (String) data.get("ORG_CODE_");
        this.orgName = (String) data.get("ORG_NAME_");
        this.dutyCode = (String) data.get("DUTY_CODE_");
        this.dutyName = (String) data.get("DUTY_NAME_");
    }

    public String getPosiId() {
        return posiId;
    }

    public void setPosiId(String posiId) {
        this.posiId = posiId;
    }

    public String getOrgnSetId() {
        return orgnSetId;
    }

    public void setOrgnSetId(String orgnSetId) {
        this.orgnSetId = orgnSetId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getDutyId() {
        return dutyId;
    }

    public void setDutyId(String dutyId) {
        this.dutyId = dutyId;
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

    public String getDutyLevel() {
        return dutyLevel;
    }

    public void setDutyLevel(String dutyLevel) {
        this.dutyLevel = dutyLevel;
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

    public String getPosiTag() {
        return posiTag;
    }

    public void setPosiTag(String posiTag) {
        this.posiTag = posiTag;
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
}