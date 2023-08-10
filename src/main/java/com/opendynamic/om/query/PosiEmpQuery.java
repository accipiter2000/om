package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmPosiEmpService;
import com.opendynamic.om.vo.PosiEmp;

@Service
public class PosiEmpQuery {
    private OmPosiEmpService omPosiEmpService;

    private String orgnSetId;
    private String orgnSetCode;
    private String posiEmpId;
    private List<String> posiEmpIdList;
    private String main;
    private List<String> mainList;
    private String posiEmpCategory;
    private List<String> posiEmpCategoryList;
    private String posiEmpTag;
    private String posiEmpExtAttr1;
    private List<String> posiEmpExtAttr1List;
    private String posiEmpExtAttr2;
    private List<String> posiEmpExtAttr2List;
    private String posiEmpExtAttr3;
    private List<String> posiEmpExtAttr3List;
    private String posiEmpExtAttr4;
    private List<String> posiEmpExtAttr4List;
    private String posiEmpExtAttr5;
    private List<String> posiEmpExtAttr5List;
    private String posiEmpExtAttr6;
    private List<String> posiEmpExtAttr6List;
    private String posiEmpExtAttr7;
    private List<String> posiEmpExtAttr7List;
    private String posiEmpExtAttr8;
    private List<String> posiEmpExtAttr8List;
    private String posiEmpStatus;
    private List<String> posiEmpStatusList;
    private String empId;
    private List<String> empIdList;
    private String empCode;
    private List<String> empCodeList;
    private String empName;
    private List<String> empNameList;
    private String empCategory;
    private List<String> empCategoryList;
    private String empTag;
    private String empExtAttr1;
    private List<String> empExtAttr1List;
    private String empExtAttr2;
    private List<String> empExtAttr2List;
    private String empExtAttr3;
    private List<String> empExtAttr3List;
    private String empExtAttr4;
    private List<String> empExtAttr4List;
    private String empExtAttr5;
    private List<String> empExtAttr5List;
    private String empExtAttr6;
    private List<String> empExtAttr6List;
    private String empExtAttr7;
    private List<String> empExtAttr7List;
    private String empExtAttr8;
    private List<String> empExtAttr8List;
    private String empStatus;
    private List<String> empStatusList;
    private String posiId;
    private List<String> posiIdList;
    private String posiCode;
    private List<String> posiCodeList;
    private String posiName;
    private List<String> posiNameList;
    private String orgLeaderType;
    private List<String> orgLeaderTypeList;
    private String posiCategory;
    private List<String> posiCategoryList;
    private String posiTag;
    private String posiExtAttr1;
    private List<String> posiExtAttr1List;
    private String posiExtAttr2;
    private List<String> posiExtAttr2List;
    private String posiExtAttr3;
    private List<String> posiExtAttr3List;
    private String posiExtAttr4;
    private List<String> posiExtAttr4List;
    private String posiExtAttr5;
    private List<String> posiExtAttr5List;
    private String posiExtAttr6;
    private List<String> posiExtAttr6List;
    private String posiExtAttr7;
    private List<String> posiExtAttr7List;
    private String posiExtAttr8;
    private List<String> posiExtAttr8List;
    private String posiStatus;
    private List<String> posiStatusList;
    private String dutyId;
    private List<String> dutyIdList;
    private String dutyCode;
    private List<String> dutyCodeList;
    private String dutyName;
    private List<String> dutyNameList;
    private String dutyCategory;
    private List<String> dutyCategoryList;
    private String dutyTag;
    private String dutyExtAttr1;
    private List<String> dutyExtAttr1List;
    private String dutyExtAttr2;
    private List<String> dutyExtAttr2List;
    private String dutyExtAttr3;
    private List<String> dutyExtAttr3List;
    private String dutyExtAttr4;
    private List<String> dutyExtAttr4List;
    private String dutyExtAttr5;
    private List<String> dutyExtAttr5List;
    private String dutyExtAttr6;
    private List<String> dutyExtAttr6List;
    private String dutyExtAttr7;
    private List<String> dutyExtAttr7List;
    private String dutyExtAttr8;
    private List<String> dutyExtAttr8List;
    private String dutyStatus;
    private List<String> dutyStatusList;
    private String orgId;
    private List<String> orgIdList;
    private String parentOrgId;
    private List<String> parentOrgIdList;
    private String orgCode;
    private List<String> orgCodeList;
    private String orgName;
    private List<String> orgNameList;
    private String orgType;
    private List<String> orgTypeList;
    private String orgCategory;
    private List<String> orgCategoryList;
    private String orgTag;
    private String orgExtAttr1;
    private List<String> orgExtAttr1List;
    private String orgExtAttr2;
    private List<String> orgExtAttr2List;
    private String orgExtAttr3;
    private List<String> orgExtAttr3List;
    private String orgExtAttr4;
    private List<String> orgExtAttr4List;
    private String orgExtAttr5;
    private List<String> orgExtAttr5List;
    private String orgExtAttr6;
    private List<String> orgExtAttr6List;
    private String orgExtAttr7;
    private List<String> orgExtAttr7List;
    private String orgExtAttr8;
    private List<String> orgExtAttr8List;
    private String orgStatus;
    private List<String> orgStatusList;
    private Boolean posiEmpTagUnion;
    private Boolean empTagUnion;
    private Boolean posiTagUnion;
    private Boolean dutyTagUnion;
    private Boolean orgTagUnion;
    private String withinOrgId;
    private Boolean orgRootOnly;
    private Integer page;
    private Integer limit;
    private String operatorId;
    private String operatorName;

    public PosiEmpQuery(OmPosiEmpService omPosiEmpService) {
        super();
        this.omPosiEmpService = omPosiEmpService;
    }

    public PosiEmpQuery setOrgnSetId(String orgnSetId) {
        this.orgnSetId = orgnSetId;
        return this;
    }

    public PosiEmpQuery setOrgnSetCode(String orgnSetCode) {
        this.orgnSetCode = orgnSetCode;
        return this;
    }

    public PosiEmpQuery setPosiEmpId(String posiEmpId) {
        this.posiEmpId = posiEmpId;
        return this;
    }

    public PosiEmpQuery setPosiEmpIdList(List<String> posiEmpIdList) {
        this.posiEmpIdList = posiEmpIdList;
        return this;
    }

    public PosiEmpQuery setMain(String main) {
        this.main = main;
        return this;
    }

    public PosiEmpQuery setMainList(List<String> mainList) {
        this.mainList = mainList;
        return this;
    }

    public PosiEmpQuery setPosiEmpCategory(String posiEmpCategory) {
        this.posiEmpCategory = posiEmpCategory;
        return this;
    }

    public PosiEmpQuery setPosiEmpCategoryList(List<String> posiEmpCategoryList) {
        this.posiEmpCategoryList = posiEmpCategoryList;
        return this;
    }

    public PosiEmpQuery setPosiEmpTag(String posiEmpTag) {
        this.posiEmpTag = posiEmpTag;
        return this;
    }

    public PosiEmpQuery setPosiEmpExtAttr1(String posiEmpExtAttr1) {
        this.posiEmpExtAttr1 = posiEmpExtAttr1;
        return this;
    }

    public PosiEmpQuery setPosiEmpExtAttr1List(List<String> posiEmpExtAttr1List) {
        this.posiEmpExtAttr1List = posiEmpExtAttr1List;
        return this;
    }

    public PosiEmpQuery setPosiEmpExtAttr2(String posiEmpExtAttr2) {
        this.posiEmpExtAttr2 = posiEmpExtAttr2;
        return this;
    }

    public PosiEmpQuery setPosiEmpExtAttr2List(List<String> posiEmpExtAttr2List) {
        this.posiEmpExtAttr2List = posiEmpExtAttr2List;
        return this;
    }

    public PosiEmpQuery setPosiEmpExtAttr3(String posiEmpExtAttr3) {
        this.posiEmpExtAttr3 = posiEmpExtAttr3;
        return this;
    }

    public PosiEmpQuery setPosiEmpExtAttr3List(List<String> posiEmpExtAttr3List) {
        this.posiEmpExtAttr3List = posiEmpExtAttr3List;
        return this;
    }

    public PosiEmpQuery setPosiEmpExtAttr4(String posiEmpExtAttr4) {
        this.posiEmpExtAttr4 = posiEmpExtAttr4;
        return this;
    }

    public PosiEmpQuery setPosiEmpExtAttr4List(List<String> posiEmpExtAttr4List) {
        this.posiEmpExtAttr4List = posiEmpExtAttr4List;
        return this;
    }

    public PosiEmpQuery setPosiEmpExtAttr5(String posiEmpExtAttr5) {
        this.posiEmpExtAttr5 = posiEmpExtAttr5;
        return this;
    }

    public PosiEmpQuery setPosiEmpExtAttr5List(List<String> posiEmpExtAttr5List) {
        this.posiEmpExtAttr5List = posiEmpExtAttr5List;
        return this;
    }

    public PosiEmpQuery setPosiEmpExtAttr6(String posiEmpExtAttr6) {
        this.posiEmpExtAttr6 = posiEmpExtAttr6;
        return this;
    }

    public PosiEmpQuery setPosiEmpExtAttr6List(List<String> posiEmpExtAttr6List) {
        this.posiEmpExtAttr6List = posiEmpExtAttr6List;
        return this;
    }

    public PosiEmpQuery setPosiEmpExtAttr7(String posiEmpExtAttr7) {
        this.posiEmpExtAttr7 = posiEmpExtAttr7;
        return this;
    }

    public PosiEmpQuery setPosiEmpExtAttr7List(List<String> posiEmpExtAttr7List) {
        this.posiEmpExtAttr7List = posiEmpExtAttr7List;
        return this;
    }

    public PosiEmpQuery setPosiEmpExtAttr8(String posiEmpExtAttr8) {
        this.posiEmpExtAttr8 = posiEmpExtAttr8;
        return this;
    }

    public PosiEmpQuery setPosiEmpExtAttr8List(List<String> posiEmpExtAttr8List) {
        this.posiEmpExtAttr8List = posiEmpExtAttr8List;
        return this;
    }

    public PosiEmpQuery setPosiEmpStatus(String posiEmpStatus) {
        this.posiEmpStatus = posiEmpStatus;
        return this;
    }

    public PosiEmpQuery setPosiEmpStatusList(List<String> posiEmpStatusList) {
        this.posiEmpStatusList = posiEmpStatusList;
        return this;
    }

    public PosiEmpQuery setEmpId(String empId) {
        this.empId = empId;
        return this;
    }

    public PosiEmpQuery setEmpIdList(List<String> empIdList) {
        this.empIdList = empIdList;
        return this;
    }

    public PosiEmpQuery setEmpCode(String empCode) {
        this.empCode = empCode;
        return this;
    }

    public PosiEmpQuery setEmpCodeList(List<String> empCodeList) {
        this.empCodeList = empCodeList;
        return this;
    }

    public PosiEmpQuery setEmpName(String empName) {
        this.empName = empName;
        return this;
    }

    public PosiEmpQuery setEmpNameList(List<String> empNameList) {
        this.empNameList = empNameList;
        return this;
    }

    public PosiEmpQuery setEmpCategory(String empCategory) {
        this.empCategory = empCategory;
        return this;
    }

    public PosiEmpQuery setEmpCategoryList(List<String> empCategoryList) {
        this.empCategoryList = empCategoryList;
        return this;
    }

    public PosiEmpQuery setEmpTag(String empTag) {
        this.empTag = empTag;
        return this;
    }

    public PosiEmpQuery setEmpExtAttr1(String empExtAttr1) {
        this.empExtAttr1 = empExtAttr1;
        return this;
    }

    public PosiEmpQuery setEmpExtAttr1List(List<String> empExtAttr1List) {
        this.empExtAttr1List = empExtAttr1List;
        return this;
    }

    public PosiEmpQuery setEmpExtAttr2(String empExtAttr2) {
        this.empExtAttr2 = empExtAttr2;
        return this;
    }

    public PosiEmpQuery setEmpExtAttr2List(List<String> empExtAttr2List) {
        this.empExtAttr2List = empExtAttr2List;
        return this;
    }

    public PosiEmpQuery setEmpExtAttr3(String empExtAttr3) {
        this.empExtAttr3 = empExtAttr3;
        return this;
    }

    public PosiEmpQuery setEmpExtAttr3List(List<String> empExtAttr3List) {
        this.empExtAttr3List = empExtAttr3List;
        return this;
    }

    public PosiEmpQuery setEmpExtAttr4(String empExtAttr4) {
        this.empExtAttr4 = empExtAttr4;
        return this;
    }

    public PosiEmpQuery setEmpExtAttr4List(List<String> empExtAttr4List) {
        this.empExtAttr4List = empExtAttr4List;
        return this;
    }

    public PosiEmpQuery setEmpExtAttr5(String empExtAttr5) {
        this.empExtAttr5 = empExtAttr5;
        return this;
    }

    public PosiEmpQuery setEmpExtAttr5List(List<String> empExtAttr5List) {
        this.empExtAttr5List = empExtAttr5List;
        return this;
    }

    public PosiEmpQuery setEmpExtAttr6(String empExtAttr6) {
        this.empExtAttr6 = empExtAttr6;
        return this;
    }

    public PosiEmpQuery setEmpExtAttr6List(List<String> empExtAttr6List) {
        this.empExtAttr6List = empExtAttr6List;
        return this;
    }

    public PosiEmpQuery setEmpExtAttr7(String empExtAttr7) {
        this.empExtAttr7 = empExtAttr7;
        return this;
    }

    public PosiEmpQuery setEmpExtAttr7List(List<String> empExtAttr7List) {
        this.empExtAttr7List = empExtAttr7List;
        return this;
    }

    public PosiEmpQuery setEmpExtAttr8(String empExtAttr8) {
        this.empExtAttr8 = empExtAttr8;
        return this;
    }

    public PosiEmpQuery setEmpExtAttr8List(List<String> empExtAttr8List) {
        this.empExtAttr8List = empExtAttr8List;
        return this;
    }

    public PosiEmpQuery setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
        return this;
    }

    public PosiEmpQuery setEmpStatusList(List<String> empStatusList) {
        this.empStatusList = empStatusList;
        return this;
    }

    public PosiEmpQuery setPosiId(String posiId) {
        this.posiId = posiId;
        return this;
    }

    public PosiEmpQuery setPosiIdList(List<String> posiIdList) {
        this.posiIdList = posiIdList;
        return this;
    }

    public PosiEmpQuery setPosiCode(String posiCode) {
        this.posiCode = posiCode;
        return this;
    }

    public PosiEmpQuery setPosiCodeList(List<String> posiCodeList) {
        this.posiCodeList = posiCodeList;
        return this;
    }

    public PosiEmpQuery setPosiName(String posiName) {
        this.posiName = posiName;
        return this;
    }

    public PosiEmpQuery setPosiNameList(List<String> posiNameList) {
        this.posiNameList = posiNameList;
        return this;
    }

    public PosiEmpQuery setOrgLeaderType(String orgLeaderType) {
        this.orgLeaderType = orgLeaderType;
        return this;
    }

    public PosiEmpQuery setOrgLeaderTypeList(List<String> orgLeaderTypeList) {
        this.orgLeaderTypeList = orgLeaderTypeList;
        return this;
    }

    public PosiEmpQuery setPosiCategory(String posiCategory) {
        this.posiCategory = posiCategory;
        return this;
    }

    public PosiEmpQuery setPosiCategoryList(List<String> posiCategoryList) {
        this.posiCategoryList = posiCategoryList;
        return this;
    }

    public PosiEmpQuery setPosiTag(String posiTag) {
        this.posiTag = posiTag;
        return this;
    }

    public PosiEmpQuery setPosiExtAttr1(String posiExtAttr1) {
        this.posiExtAttr1 = posiExtAttr1;
        return this;
    }

    public PosiEmpQuery setPosiExtAttr1List(List<String> posiExtAttr1List) {
        this.posiExtAttr1List = posiExtAttr1List;
        return this;
    }

    public PosiEmpQuery setPosiExtAttr2(String posiExtAttr2) {
        this.posiExtAttr2 = posiExtAttr2;
        return this;
    }

    public PosiEmpQuery setPosiExtAttr2List(List<String> posiExtAttr2List) {
        this.posiExtAttr2List = posiExtAttr2List;
        return this;
    }

    public PosiEmpQuery setPosiExtAttr3(String posiExtAttr3) {
        this.posiExtAttr3 = posiExtAttr3;
        return this;
    }

    public PosiEmpQuery setPosiExtAttr3List(List<String> posiExtAttr3List) {
        this.posiExtAttr3List = posiExtAttr3List;
        return this;
    }

    public PosiEmpQuery setPosiExtAttr4(String posiExtAttr4) {
        this.posiExtAttr4 = posiExtAttr4;
        return this;
    }

    public PosiEmpQuery setPosiExtAttr4List(List<String> posiExtAttr4List) {
        this.posiExtAttr4List = posiExtAttr4List;
        return this;
    }

    public PosiEmpQuery setPosiExtAttr5(String posiExtAttr5) {
        this.posiExtAttr5 = posiExtAttr5;
        return this;
    }

    public PosiEmpQuery setPosiExtAttr5List(List<String> posiExtAttr5List) {
        this.posiExtAttr5List = posiExtAttr5List;
        return this;
    }

    public PosiEmpQuery setPosiExtAttr6(String posiExtAttr6) {
        this.posiExtAttr6 = posiExtAttr6;
        return this;
    }

    public PosiEmpQuery setPosiExtAttr6List(List<String> posiExtAttr6List) {
        this.posiExtAttr6List = posiExtAttr6List;
        return this;
    }

    public PosiEmpQuery setPosiExtAttr7(String posiExtAttr7) {
        this.posiExtAttr7 = posiExtAttr7;
        return this;
    }

    public PosiEmpQuery setPosiExtAttr7List(List<String> posiExtAttr7List) {
        this.posiExtAttr7List = posiExtAttr7List;
        return this;
    }

    public PosiEmpQuery setPosiExtAttr8(String posiExtAttr8) {
        this.posiExtAttr8 = posiExtAttr8;
        return this;
    }

    public PosiEmpQuery setPosiExtAttr8List(List<String> posiExtAttr8List) {
        this.posiExtAttr8List = posiExtAttr8List;
        return this;
    }

    public PosiEmpQuery setPosiStatus(String posiStatus) {
        this.posiStatus = posiStatus;
        return this;
    }

    public PosiEmpQuery setPosiStatusList(List<String> posiStatusList) {
        this.posiStatusList = posiStatusList;
        return this;
    }

    public PosiEmpQuery setDutyId(String dutyId) {
        this.dutyId = dutyId;
        return this;
    }

    public PosiEmpQuery setDutyIdList(List<String> dutyIdList) {
        this.dutyIdList = dutyIdList;
        return this;
    }

    public PosiEmpQuery setDutyCode(String dutyCode) {
        this.dutyCode = dutyCode;
        return this;
    }

    public PosiEmpQuery setDutyCodeList(List<String> dutyCodeList) {
        this.dutyCodeList = dutyCodeList;
        return this;
    }

    public PosiEmpQuery setDutyName(String dutyName) {
        this.dutyName = dutyName;
        return this;
    }

    public PosiEmpQuery setDutyNameList(List<String> dutyNameList) {
        this.dutyNameList = dutyNameList;
        return this;
    }

    public PosiEmpQuery setDutyCategory(String dutyCategory) {
        this.dutyCategory = dutyCategory;
        return this;
    }

    public PosiEmpQuery setDutyCategoryList(List<String> dutyCategoryList) {
        this.dutyCategoryList = dutyCategoryList;
        return this;
    }

    public PosiEmpQuery setDutyTag(String dutyTag) {
        this.dutyTag = dutyTag;
        return this;
    }

    public PosiEmpQuery setDutyExtAttr1(String dutyExtAttr1) {
        this.dutyExtAttr1 = dutyExtAttr1;
        return this;
    }

    public PosiEmpQuery setDutyExtAttr1List(List<String> dutyExtAttr1List) {
        this.dutyExtAttr1List = dutyExtAttr1List;
        return this;
    }

    public PosiEmpQuery setDutyExtAttr2(String dutyExtAttr2) {
        this.dutyExtAttr2 = dutyExtAttr2;
        return this;
    }

    public PosiEmpQuery setDutyExtAttr2List(List<String> dutyExtAttr2List) {
        this.dutyExtAttr2List = dutyExtAttr2List;
        return this;
    }

    public PosiEmpQuery setDutyExtAttr3(String dutyExtAttr3) {
        this.dutyExtAttr3 = dutyExtAttr3;
        return this;
    }

    public PosiEmpQuery setDutyExtAttr3List(List<String> dutyExtAttr3List) {
        this.dutyExtAttr3List = dutyExtAttr3List;
        return this;
    }

    public PosiEmpQuery setDutyExtAttr4(String dutyExtAttr4) {
        this.dutyExtAttr4 = dutyExtAttr4;
        return this;
    }

    public PosiEmpQuery setDutyExtAttr4List(List<String> dutyExtAttr4List) {
        this.dutyExtAttr4List = dutyExtAttr4List;
        return this;
    }

    public PosiEmpQuery setDutyExtAttr5(String dutyExtAttr5) {
        this.dutyExtAttr5 = dutyExtAttr5;
        return this;
    }

    public PosiEmpQuery setDutyExtAttr5List(List<String> dutyExtAttr5List) {
        this.dutyExtAttr5List = dutyExtAttr5List;
        return this;
    }

    public PosiEmpQuery setDutyExtAttr6(String dutyExtAttr6) {
        this.dutyExtAttr6 = dutyExtAttr6;
        return this;
    }

    public PosiEmpQuery setDutyExtAttr6List(List<String> dutyExtAttr6List) {
        this.dutyExtAttr6List = dutyExtAttr6List;
        return this;
    }

    public PosiEmpQuery setDutyExtAttr7(String dutyExtAttr7) {
        this.dutyExtAttr7 = dutyExtAttr7;
        return this;
    }

    public PosiEmpQuery setDutyExtAttr7List(List<String> dutyExtAttr7List) {
        this.dutyExtAttr7List = dutyExtAttr7List;
        return this;
    }

    public PosiEmpQuery setDutyExtAttr8(String dutyExtAttr8) {
        this.dutyExtAttr8 = dutyExtAttr8;
        return this;
    }

    public PosiEmpQuery setDutyExtAttr8List(List<String> dutyExtAttr8List) {
        this.dutyExtAttr8List = dutyExtAttr8List;
        return this;
    }

    public PosiEmpQuery setDutyStatus(String dutyStatus) {
        this.dutyStatus = dutyStatus;
        return this;
    }

    public PosiEmpQuery setDutyStatusList(List<String> dutyStatusList) {
        this.dutyStatusList = dutyStatusList;
        return this;
    }

    public PosiEmpQuery setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public PosiEmpQuery setOrgIdList(List<String> orgIdList) {
        this.orgIdList = orgIdList;
        return this;
    }

    public PosiEmpQuery setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
        return this;
    }

    public PosiEmpQuery setParentOrgIdList(List<String> parentOrgIdList) {
        this.parentOrgIdList = parentOrgIdList;
        return this;
    }

    public PosiEmpQuery setOrgCode(String orgCode) {
        this.orgCode = orgCode;
        return this;
    }

    public PosiEmpQuery setOrgCodeList(List<String> orgCodeList) {
        this.orgCodeList = orgCodeList;
        return this;
    }

    public PosiEmpQuery setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public PosiEmpQuery setOrgNameList(List<String> orgNameList) {
        this.orgNameList = orgNameList;
        return this;
    }

    public PosiEmpQuery setOrgType(String orgType) {
        this.orgType = orgType;
        return this;
    }

    public PosiEmpQuery setOrgTypeList(List<String> orgTypeList) {
        this.orgTypeList = orgTypeList;
        return this;
    }

    public PosiEmpQuery setOrgCategory(String orgCategory) {
        this.orgCategory = orgCategory;
        return this;
    }

    public PosiEmpQuery setOrgCategoryList(List<String> orgCategoryList) {
        this.orgCategoryList = orgCategoryList;
        return this;
    }

    public PosiEmpQuery setOrgTag(String orgTag) {
        this.orgTag = orgTag;
        return this;
    }

    public PosiEmpQuery setOrgExtAttr1(String orgExtAttr1) {
        this.orgExtAttr1 = orgExtAttr1;
        return this;
    }

    public PosiEmpQuery setOrgExtAttr1List(List<String> orgExtAttr1List) {
        this.orgExtAttr1List = orgExtAttr1List;
        return this;
    }

    public PosiEmpQuery setOrgExtAttr2(String orgExtAttr2) {
        this.orgExtAttr2 = orgExtAttr2;
        return this;
    }

    public PosiEmpQuery setOrgExtAttr2List(List<String> orgExtAttr2List) {
        this.orgExtAttr2List = orgExtAttr2List;
        return this;
    }

    public PosiEmpQuery setOrgExtAttr3(String orgExtAttr3) {
        this.orgExtAttr3 = orgExtAttr3;
        return this;
    }

    public PosiEmpQuery setOrgExtAttr3List(List<String> orgExtAttr3List) {
        this.orgExtAttr3List = orgExtAttr3List;
        return this;
    }

    public PosiEmpQuery setOrgExtAttr4(String orgExtAttr4) {
        this.orgExtAttr4 = orgExtAttr4;
        return this;
    }

    public PosiEmpQuery setOrgExtAttr4List(List<String> orgExtAttr4List) {
        this.orgExtAttr4List = orgExtAttr4List;
        return this;
    }

    public PosiEmpQuery setOrgExtAttr5(String orgExtAttr5) {
        this.orgExtAttr5 = orgExtAttr5;
        return this;
    }

    public PosiEmpQuery setOrgExtAttr5List(List<String> orgExtAttr5List) {
        this.orgExtAttr5List = orgExtAttr5List;
        return this;
    }

    public PosiEmpQuery setOrgExtAttr6(String orgExtAttr6) {
        this.orgExtAttr6 = orgExtAttr6;
        return this;
    }

    public PosiEmpQuery setOrgExtAttr6List(List<String> orgExtAttr6List) {
        this.orgExtAttr6List = orgExtAttr6List;
        return this;
    }

    public PosiEmpQuery setOrgExtAttr7(String orgExtAttr7) {
        this.orgExtAttr7 = orgExtAttr7;
        return this;
    }

    public PosiEmpQuery setOrgExtAttr7List(List<String> orgExtAttr7List) {
        this.orgExtAttr7List = orgExtAttr7List;
        return this;
    }

    public PosiEmpQuery setOrgExtAttr8(String orgExtAttr8) {
        this.orgExtAttr8 = orgExtAttr8;
        return this;
    }

    public PosiEmpQuery setOrgExtAttr8List(List<String> orgExtAttr8List) {
        this.orgExtAttr8List = orgExtAttr8List;
        return this;
    }

    public PosiEmpQuery setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus;
        return this;
    }

    public PosiEmpQuery setOrgStatusList(List<String> orgStatusList) {
        this.orgStatusList = orgStatusList;
        return this;
    }

    public PosiEmpQuery setPosiEmpTagUnion(Boolean posiEmpTagUnion) {
        this.posiEmpTagUnion = posiEmpTagUnion;
        return this;
    }

    public PosiEmpQuery setEmpTagUnion(Boolean empTagUnion) {
        this.empTagUnion = empTagUnion;
        return this;
    }

    public PosiEmpQuery setPosiTagUnion(Boolean posiTagUnion) {
        this.posiTagUnion = posiTagUnion;
        return this;
    }

    public PosiEmpQuery setDutyTagUnion(Boolean dutyTagUnion) {
        this.dutyTagUnion = dutyTagUnion;
        return this;
    }

    public PosiEmpQuery setOrgTagUnion(Boolean orgTagUnion) {
        this.orgTagUnion = orgTagUnion;
        return this;
    }

    public PosiEmpQuery setWithinOrgId(String withinOrgId) {
        this.withinOrgId = withinOrgId;
        return this;
    }

    public PosiEmpQuery setOrgRootOnly(Boolean orgRootOnly) {
        this.orgRootOnly = orgRootOnly;
        return this;
    }

    public PosiEmpQuery setPage(Integer page) {
        this.page = page;
        return this;
    }

    public PosiEmpQuery setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public PosiEmpQuery setOperatorId(String operatorId) {
        this.operatorId = operatorId;
        return this;
    }

    public PosiEmpQuery setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    public List<Map<String, Object>> queryForMapList() {
        return omPosiEmpService.selectPosiEmp(orgnSetId, orgnSetCode, posiEmpId, posiEmpIdList, main, mainList, posiEmpCategory, posiEmpCategoryList, posiEmpTag, posiEmpExtAttr1, posiEmpExtAttr1List, posiEmpExtAttr2, posiEmpExtAttr2List, posiEmpExtAttr3, posiEmpExtAttr3List, posiEmpExtAttr4, posiEmpExtAttr4List, posiEmpExtAttr5, posiEmpExtAttr5List, posiEmpExtAttr6, posiEmpExtAttr6List, posiEmpExtAttr7, posiEmpExtAttr7List, posiEmpExtAttr8, posiEmpExtAttr8List, posiEmpStatus, posiEmpStatusList, empId, empIdList, empCode, empCodeList, empName, empNameList, empCategory, empCategoryList, empTag, empExtAttr1, empExtAttr1List, empExtAttr2, empExtAttr2List, empExtAttr3, empExtAttr3List, empExtAttr4, empExtAttr4List, empExtAttr5, empExtAttr5List, empExtAttr6, empExtAttr6List, empExtAttr7,
                empExtAttr7List, empExtAttr8, empExtAttr8List, empStatus, empStatusList, posiId, posiIdList, posiCode, posiCodeList, posiName, posiNameList, orgLeaderType, orgLeaderTypeList, posiCategory, posiCategoryList, posiTag, posiExtAttr1, posiExtAttr1List, posiExtAttr2, posiExtAttr2List, posiExtAttr3, posiExtAttr3List, posiExtAttr4, posiExtAttr4List, posiExtAttr5, posiExtAttr5List, posiExtAttr6, posiExtAttr6List, posiExtAttr7, posiExtAttr7List, posiExtAttr8, posiExtAttr8List, posiStatus, posiStatusList, dutyId, dutyIdList, dutyCode, dutyCodeList, dutyName, dutyNameList, dutyCategory, dutyCategoryList, dutyTag, dutyExtAttr1, dutyExtAttr1List, dutyExtAttr2, dutyExtAttr2List, dutyExtAttr3, dutyExtAttr3List, dutyExtAttr4, dutyExtAttr4List, dutyExtAttr5, dutyExtAttr5List, dutyExtAttr6,
                dutyExtAttr6List, dutyExtAttr7, dutyExtAttr7List, dutyExtAttr8, dutyExtAttr8List, dutyStatus, dutyStatusList, orgId, orgIdList, parentOrgId, parentOrgIdList, orgCode, orgCodeList, orgName, orgNameList, orgType, orgTypeList, orgCategory, orgCategoryList, orgTag, orgExtAttr1, orgExtAttr1List, orgExtAttr2, orgExtAttr2List, orgExtAttr3, orgExtAttr3List, orgExtAttr4, orgExtAttr4List, orgExtAttr5, orgExtAttr5List, orgExtAttr6, orgExtAttr6List, orgExtAttr7, orgExtAttr7List, orgExtAttr8, orgExtAttr8List, orgStatus, orgStatusList, posiEmpTagUnion, empTagUnion, posiTagUnion, dutyTagUnion, orgTagUnion, withinOrgId, orgRootOnly, page, limit, operatorId, operatorName);
    }

    public Map<String, Object> queryForMap() {
        List<Map<String, Object>> result = queryForMapList();
        if (result.size() == 1) {
            return result.get(0);
        }
        else {
            return null;
        }
    }

    public List<PosiEmp> queryForObjectList() {
        List<Map<String, Object>> result = queryForMapList();
        List<PosiEmp> posiEmpList = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            posiEmpList.add(new PosiEmp(result.get(i)));
        }

        return posiEmpList;
    }

    public PosiEmp queryForObject() {
        List<Map<String, Object>> result = queryForMapList();
        if (result.size() == 1) {
            return new PosiEmp(result.get(0));
        }
        else {
            return null;
        }
    }

    public int count() {
        return omPosiEmpService.countPosiEmp(orgnSetId, orgnSetCode, posiEmpId, posiEmpIdList, main, mainList, posiEmpCategory, posiEmpCategoryList, posiEmpTag, posiEmpExtAttr1, posiEmpExtAttr1List, posiEmpExtAttr2, posiEmpExtAttr2List, posiEmpExtAttr3, posiEmpExtAttr3List, posiEmpExtAttr4, posiEmpExtAttr4List, posiEmpExtAttr5, posiEmpExtAttr5List, posiEmpExtAttr6, posiEmpExtAttr6List, posiEmpExtAttr7, posiEmpExtAttr7List, posiEmpExtAttr8, posiEmpExtAttr8List, posiEmpStatus, posiEmpStatusList, empId, empIdList, empCode, empCodeList, empName, empNameList, empCategory, empCategoryList, empTag, empExtAttr1, empExtAttr1List, empExtAttr2, empExtAttr2List, empExtAttr3, empExtAttr3List, empExtAttr4, empExtAttr4List, empExtAttr5, empExtAttr5List, empExtAttr6, empExtAttr6List, empExtAttr7,
                empExtAttr7List, empExtAttr8, empExtAttr8List, empStatus, empStatusList, posiId, posiIdList, posiCode, posiCodeList, posiName, posiNameList, orgLeaderType, orgLeaderTypeList, posiCategory, posiCategoryList, posiTag, posiExtAttr1, posiExtAttr1List, posiExtAttr2, posiExtAttr2List, posiExtAttr3, posiExtAttr3List, posiExtAttr4, posiExtAttr4List, posiExtAttr5, posiExtAttr5List, posiExtAttr6, posiExtAttr6List, posiExtAttr7, posiExtAttr7List, posiExtAttr8, posiExtAttr8List, posiStatus, posiStatusList, dutyId, dutyIdList, dutyCode, dutyCodeList, dutyName, dutyNameList, dutyCategory, dutyCategoryList, dutyTag, dutyExtAttr1, dutyExtAttr1List, dutyExtAttr2, dutyExtAttr2List, dutyExtAttr3, dutyExtAttr3List, dutyExtAttr4, dutyExtAttr4List, dutyExtAttr5, dutyExtAttr5List, dutyExtAttr6,
                dutyExtAttr6List, dutyExtAttr7, dutyExtAttr7List, dutyExtAttr8, dutyExtAttr8List, dutyStatus, dutyStatusList, orgId, orgIdList, parentOrgId, parentOrgIdList, orgCode, orgCodeList, orgName, orgNameList, orgType, orgTypeList, orgCategory, orgCategoryList, orgTag, orgExtAttr1, orgExtAttr1List, orgExtAttr2, orgExtAttr2List, orgExtAttr3, orgExtAttr3List, orgExtAttr4, orgExtAttr4List, orgExtAttr5, orgExtAttr5List, orgExtAttr6, orgExtAttr6List, orgExtAttr7, orgExtAttr7List, orgExtAttr8, orgExtAttr8List, orgStatus, orgStatusList, posiEmpTagUnion, empTagUnion, posiTagUnion, dutyTagUnion, orgTagUnion, withinOrgId, orgRootOnly, operatorId, operatorName);
    }
}