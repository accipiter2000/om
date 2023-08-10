package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmEmpRelationService;
import com.opendynamic.om.vo.EmpRelation;

@Service
public class EmpRelationQuery {
    private OmEmpRelationService omEmpRelationService;

    private String orgnSetId;
    private String orgnSetCode;
    private String empRelationId;
    private List<String> empRelationIdList;
    private String empRelation;
    private List<String> empRelationList;
    private String empRelationCategory;
    private List<String> empRelationCategoryList;
    private String empRelationTag;
    private String empRelationExtAttr1;
    private List<String> empRelationExtAttr1List;
    private String empRelationExtAttr2;
    private List<String> empRelationExtAttr2List;
    private String empRelationExtAttr3;
    private List<String> empRelationExtAttr3List;
    private String empRelationExtAttr4;
    private List<String> empRelationExtAttr4List;
    private String empRelationExtAttr5;
    private List<String> empRelationExtAttr5List;
    private String empRelationExtAttr6;
    private List<String> empRelationExtAttr6List;
    private String empRelationExtAttr7;
    private List<String> empRelationExtAttr7List;
    private String empRelationExtAttr8;
    private List<String> empRelationExtAttr8List;
    private String empRelationStatus;
    private List<String> empRelationStatusList;
    private String upperEmpId;
    private List<String> upperEmpIdList;
    private String upperEmpCode;
    private List<String> upperEmpCodeList;
    private String upperEmpName;
    private List<String> upperEmpNameList;
    private String upperEmpCategory;
    private List<String> upperEmpCategoryList;
    private String upperEmpTag;
    private String upperEmpExtAttr1;
    private List<String> upperEmpExtAttr1List;
    private String upperEmpExtAttr2;
    private List<String> upperEmpExtAttr2List;
    private String upperEmpExtAttr3;
    private List<String> upperEmpExtAttr3List;
    private String upperEmpExtAttr4;
    private List<String> upperEmpExtAttr4List;
    private String upperEmpExtAttr5;
    private List<String> upperEmpExtAttr5List;
    private String upperEmpExtAttr6;
    private List<String> upperEmpExtAttr6List;
    private String upperEmpExtAttr7;
    private List<String> upperEmpExtAttr7List;
    private String upperEmpExtAttr8;
    private List<String> upperEmpExtAttr8List;
    private String upperEmpStatus;
    private List<String> upperEmpStatusList;
    private String upperOrgId;
    private List<String> upperOrgIdList;
    private String upperParentOrgId;
    private List<String> upperParentOrgIdList;
    private String upperOrgCode;
    private List<String> upperOrgCodeList;
    private String upperOrgName;
    private List<String> upperOrgNameList;
    private String upperOrgType;
    private List<String> upperOrgTypeList;
    private String upperOrgCategory;
    private List<String> upperOrgCategoryList;
    private String upperOrgTag;
    private String upperOrgExtAttr1;
    private List<String> upperOrgExtAttr1List;
    private String upperOrgExtAttr2;
    private List<String> upperOrgExtAttr2List;
    private String upperOrgExtAttr3;
    private List<String> upperOrgExtAttr3List;
    private String upperOrgExtAttr4;
    private List<String> upperOrgExtAttr4List;
    private String upperOrgExtAttr5;
    private List<String> upperOrgExtAttr5List;
    private String upperOrgExtAttr6;
    private List<String> upperOrgExtAttr6List;
    private String upperOrgExtAttr7;
    private List<String> upperOrgExtAttr7List;
    private String upperOrgExtAttr8;
    private List<String> upperOrgExtAttr8List;
    private String upperOrgStatus;
    private List<String> upperOrgStatusList;
    private String lowerEmpId;
    private List<String> lowerEmpIdList;
    private String lowerEmpCode;
    private List<String> lowerEmpCodeList;
    private String lowerEmpName;
    private List<String> lowerEmpNameList;
    private String lowerEmpCategory;
    private List<String> lowerEmpCategoryList;
    private String lowerEmpTag;
    private String lowerEmpExtAttr1;
    private List<String> lowerEmpExtAttr1List;
    private String lowerEmpExtAttr2;
    private List<String> lowerEmpExtAttr2List;
    private String lowerEmpExtAttr3;
    private List<String> lowerEmpExtAttr3List;
    private String lowerEmpExtAttr4;
    private List<String> lowerEmpExtAttr4List;
    private String lowerEmpExtAttr5;
    private List<String> lowerEmpExtAttr5List;
    private String lowerEmpExtAttr6;
    private List<String> lowerEmpExtAttr6List;
    private String lowerEmpExtAttr7;
    private List<String> lowerEmpExtAttr7List;
    private String lowerEmpExtAttr8;
    private List<String> lowerEmpExtAttr8List;
    private String lowerEmpStatus;
    private List<String> lowerEmpStatusList;
    private String lowerOrgId;
    private List<String> lowerOrgIdList;
    private String lowerParentOrgId;
    private List<String> lowerParentOrgIdList;
    private String lowerOrgCode;
    private List<String> lowerOrgCodeList;
    private String lowerOrgName;
    private List<String> lowerOrgNameList;
    private String lowerOrgType;
    private List<String> lowerOrgTypeList;
    private String lowerOrgCategory;
    private List<String> lowerOrgCategoryList;
    private String lowerOrgTag;
    private String lowerOrgExtAttr1;
    private List<String> lowerOrgExtAttr1List;
    private String lowerOrgExtAttr2;
    private List<String> lowerOrgExtAttr2List;
    private String lowerOrgExtAttr3;
    private List<String> lowerOrgExtAttr3List;
    private String lowerOrgExtAttr4;
    private List<String> lowerOrgExtAttr4List;
    private String lowerOrgExtAttr5;
    private List<String> lowerOrgExtAttr5List;
    private String lowerOrgExtAttr6;
    private List<String> lowerOrgExtAttr6List;
    private String lowerOrgExtAttr7;
    private List<String> lowerOrgExtAttr7List;
    private String lowerOrgExtAttr8;
    private List<String> lowerOrgExtAttr8List;
    private String lowerOrgStatus;
    private List<String> lowerOrgStatusList;
    private Boolean empRelationTagUnion;
    private Boolean upperEmpTagUnion;
    private Boolean upperOrgTagUnion;
    private String upperWithinOrgId;
    private Boolean upperOrgRootOnly;
    private Boolean lowerEmpTagUnion;
    private Boolean lowerOrgTagUnion;
    private String lowerWithinOrgId;
    private Boolean lowerOrgRootOnly;
    private Integer page;
    private Integer limit;
    private String operatorId;
    private String operatorName;

    public EmpRelationQuery(OmEmpRelationService omEmpRelationService) {
        super();
        this.omEmpRelationService = omEmpRelationService;
    }

    public EmpRelationQuery setOrgnSetId(String orgnSetId) {
        this.orgnSetId = orgnSetId;
        return this;
    }

    public EmpRelationQuery setOrgnSetCode(String orgnSetCode) {
        this.orgnSetCode = orgnSetCode;
        return this;
    }

    public EmpRelationQuery setEmpRelationId(String empRelationId) {
        this.empRelationId = empRelationId;
        return this;
    }

    public EmpRelationQuery setEmpRelationIdList(List<String> empRelationIdList) {
        this.empRelationIdList = empRelationIdList;
        return this;
    }

    public EmpRelationQuery setEmpRelation(String empRelation) {
        this.empRelation = empRelation;
        return this;
    }

    public EmpRelationQuery setEmpRelationList(List<String> empRelationList) {
        this.empRelationList = empRelationList;
        return this;
    }

    public EmpRelationQuery setEmpRelationCategory(String empRelationCategory) {
        this.empRelationCategory = empRelationCategory;
        return this;
    }

    public EmpRelationQuery setEmpRelationCategoryList(List<String> empRelationCategoryList) {
        this.empRelationCategoryList = empRelationCategoryList;
        return this;
    }

    public EmpRelationQuery setEmpRelationTag(String empRelationTag) {
        this.empRelationTag = empRelationTag;
        return this;
    }

    public EmpRelationQuery setEmpRelationExtAttr1(String empRelationExtAttr1) {
        this.empRelationExtAttr1 = empRelationExtAttr1;
        return this;
    }

    public EmpRelationQuery setEmpRelationExtAttr1List(List<String> empRelationExtAttr1List) {
        this.empRelationExtAttr1List = empRelationExtAttr1List;
        return this;
    }

    public EmpRelationQuery setEmpRelationExtAttr2(String empRelationExtAttr2) {
        this.empRelationExtAttr2 = empRelationExtAttr2;
        return this;
    }

    public EmpRelationQuery setEmpRelationExtAttr2List(List<String> empRelationExtAttr2List) {
        this.empRelationExtAttr2List = empRelationExtAttr2List;
        return this;
    }

    public EmpRelationQuery setEmpRelationExtAttr3(String empRelationExtAttr3) {
        this.empRelationExtAttr3 = empRelationExtAttr3;
        return this;
    }

    public EmpRelationQuery setEmpRelationExtAttr3List(List<String> empRelationExtAttr3List) {
        this.empRelationExtAttr3List = empRelationExtAttr3List;
        return this;
    }

    public EmpRelationQuery setEmpRelationExtAttr4(String empRelationExtAttr4) {
        this.empRelationExtAttr4 = empRelationExtAttr4;
        return this;
    }

    public EmpRelationQuery setEmpRelationExtAttr4List(List<String> empRelationExtAttr4List) {
        this.empRelationExtAttr4List = empRelationExtAttr4List;
        return this;
    }

    public EmpRelationQuery setEmpRelationExtAttr5(String empRelationExtAttr5) {
        this.empRelationExtAttr5 = empRelationExtAttr5;
        return this;
    }

    public EmpRelationQuery setEmpRelationExtAttr5List(List<String> empRelationExtAttr5List) {
        this.empRelationExtAttr5List = empRelationExtAttr5List;
        return this;
    }

    public EmpRelationQuery setEmpRelationExtAttr6(String empRelationExtAttr6) {
        this.empRelationExtAttr6 = empRelationExtAttr6;
        return this;
    }

    public EmpRelationQuery setEmpRelationExtAttr6List(List<String> empRelationExtAttr6List) {
        this.empRelationExtAttr6List = empRelationExtAttr6List;
        return this;
    }

    public EmpRelationQuery setEmpRelationExtAttr7(String empRelationExtAttr7) {
        this.empRelationExtAttr7 = empRelationExtAttr7;
        return this;
    }

    public EmpRelationQuery setEmpRelationExtAttr7List(List<String> empRelationExtAttr7List) {
        this.empRelationExtAttr7List = empRelationExtAttr7List;
        return this;
    }

    public EmpRelationQuery setEmpRelationExtAttr8(String empRelationExtAttr8) {
        this.empRelationExtAttr8 = empRelationExtAttr8;
        return this;
    }

    public EmpRelationQuery setEmpRelationExtAttr8List(List<String> empRelationExtAttr8List) {
        this.empRelationExtAttr8List = empRelationExtAttr8List;
        return this;
    }

    public EmpRelationQuery setEmpRelationStatus(String empRelationStatus) {
        this.empRelationStatus = empRelationStatus;
        return this;
    }

    public EmpRelationQuery setEmpRelationStatusList(List<String> empRelationStatusList) {
        this.empRelationStatusList = empRelationStatusList;
        return this;
    }

    public EmpRelationQuery setUpperEmpId(String upperEmpId) {
        this.upperEmpId = upperEmpId;
        return this;
    }

    public EmpRelationQuery setUpperEmpIdList(List<String> upperEmpIdList) {
        this.upperEmpIdList = upperEmpIdList;
        return this;
    }

    public EmpRelationQuery setUpperEmpCode(String upperEmpCode) {
        this.upperEmpCode = upperEmpCode;
        return this;
    }

    public EmpRelationQuery setUpperEmpCodeList(List<String> upperEmpCodeList) {
        this.upperEmpCodeList = upperEmpCodeList;
        return this;
    }

    public EmpRelationQuery setUpperEmpName(String upperEmpName) {
        this.upperEmpName = upperEmpName;
        return this;
    }

    public EmpRelationQuery setUpperEmpNameList(List<String> upperEmpNameList) {
        this.upperEmpNameList = upperEmpNameList;
        return this;
    }

    public EmpRelationQuery setUpperEmpCategory(String upperEmpCategory) {
        this.upperEmpCategory = upperEmpCategory;
        return this;
    }

    public EmpRelationQuery setUpperEmpCategoryList(List<String> upperEmpCategoryList) {
        this.upperEmpCategoryList = upperEmpCategoryList;
        return this;
    }

    public EmpRelationQuery setUpperEmpTag(String upperEmpTag) {
        this.upperEmpTag = upperEmpTag;
        return this;
    }

    public EmpRelationQuery setUpperEmpExtAttr1(String upperEmpExtAttr1) {
        this.upperEmpExtAttr1 = upperEmpExtAttr1;
        return this;
    }

    public EmpRelationQuery setUpperEmpExtAttr1List(List<String> upperEmpExtAttr1List) {
        this.upperEmpExtAttr1List = upperEmpExtAttr1List;
        return this;
    }

    public EmpRelationQuery setUpperEmpExtAttr2(String upperEmpExtAttr2) {
        this.upperEmpExtAttr2 = upperEmpExtAttr2;
        return this;
    }

    public EmpRelationQuery setUpperEmpExtAttr2List(List<String> upperEmpExtAttr2List) {
        this.upperEmpExtAttr2List = upperEmpExtAttr2List;
        return this;
    }

    public EmpRelationQuery setUpperEmpExtAttr3(String upperEmpExtAttr3) {
        this.upperEmpExtAttr3 = upperEmpExtAttr3;
        return this;
    }

    public EmpRelationQuery setUpperEmpExtAttr3List(List<String> upperEmpExtAttr3List) {
        this.upperEmpExtAttr3List = upperEmpExtAttr3List;
        return this;
    }

    public EmpRelationQuery setUpperEmpExtAttr4(String upperEmpExtAttr4) {
        this.upperEmpExtAttr4 = upperEmpExtAttr4;
        return this;
    }

    public EmpRelationQuery setUpperEmpExtAttr4List(List<String> upperEmpExtAttr4List) {
        this.upperEmpExtAttr4List = upperEmpExtAttr4List;
        return this;
    }

    public EmpRelationQuery setUpperEmpExtAttr5(String upperEmpExtAttr5) {
        this.upperEmpExtAttr5 = upperEmpExtAttr5;
        return this;
    }

    public EmpRelationQuery setUpperEmpExtAttr5List(List<String> upperEmpExtAttr5List) {
        this.upperEmpExtAttr5List = upperEmpExtAttr5List;
        return this;
    }

    public EmpRelationQuery setUpperEmpExtAttr6(String upperEmpExtAttr6) {
        this.upperEmpExtAttr6 = upperEmpExtAttr6;
        return this;
    }

    public EmpRelationQuery setUpperEmpExtAttr6List(List<String> upperEmpExtAttr6List) {
        this.upperEmpExtAttr6List = upperEmpExtAttr6List;
        return this;
    }

    public EmpRelationQuery setUpperEmpExtAttr7(String upperEmpExtAttr7) {
        this.upperEmpExtAttr7 = upperEmpExtAttr7;
        return this;
    }

    public EmpRelationQuery setUpperEmpExtAttr7List(List<String> upperEmpExtAttr7List) {
        this.upperEmpExtAttr7List = upperEmpExtAttr7List;
        return this;
    }

    public EmpRelationQuery setUpperEmpExtAttr8(String upperEmpExtAttr8) {
        this.upperEmpExtAttr8 = upperEmpExtAttr8;
        return this;
    }

    public EmpRelationQuery setUpperEmpExtAttr8List(List<String> upperEmpExtAttr8List) {
        this.upperEmpExtAttr8List = upperEmpExtAttr8List;
        return this;
    }

    public EmpRelationQuery setUpperEmpStatus(String upperEmpStatus) {
        this.upperEmpStatus = upperEmpStatus;
        return this;
    }

    public EmpRelationQuery setUpperEmpStatusList(List<String> upperEmpStatusList) {
        this.upperEmpStatusList = upperEmpStatusList;
        return this;
    }

    public EmpRelationQuery setUpperOrgId(String upperOrgId) {
        this.upperOrgId = upperOrgId;
        return this;
    }

    public EmpRelationQuery setUpperOrgIdList(List<String> upperOrgIdList) {
        this.upperOrgIdList = upperOrgIdList;
        return this;
    }

    public EmpRelationQuery setUpperParentOrgId(String upperParentOrgId) {
        this.upperParentOrgId = upperParentOrgId;
        return this;
    }

    public EmpRelationQuery setUpperParentOrgIdList(List<String> upperParentOrgIdList) {
        this.upperParentOrgIdList = upperParentOrgIdList;
        return this;
    }

    public EmpRelationQuery setUpperOrgCode(String upperOrgCode) {
        this.upperOrgCode = upperOrgCode;
        return this;
    }

    public EmpRelationQuery setUpperOrgCodeList(List<String> upperOrgCodeList) {
        this.upperOrgCodeList = upperOrgCodeList;
        return this;
    }

    public EmpRelationQuery setUpperOrgName(String upperOrgName) {
        this.upperOrgName = upperOrgName;
        return this;
    }

    public EmpRelationQuery setUpperOrgNameList(List<String> upperOrgNameList) {
        this.upperOrgNameList = upperOrgNameList;
        return this;
    }

    public EmpRelationQuery setUpperOrgType(String upperOrgType) {
        this.upperOrgType = upperOrgType;
        return this;
    }

    public EmpRelationQuery setUpperOrgTypeList(List<String> upperOrgTypeList) {
        this.upperOrgTypeList = upperOrgTypeList;
        return this;
    }

    public EmpRelationQuery setUpperOrgCategory(String upperOrgCategory) {
        this.upperOrgCategory = upperOrgCategory;
        return this;
    }

    public EmpRelationQuery setUpperOrgCategoryList(List<String> upperOrgCategoryList) {
        this.upperOrgCategoryList = upperOrgCategoryList;
        return this;
    }

    public EmpRelationQuery setUpperOrgTag(String upperOrgTag) {
        this.upperOrgTag = upperOrgTag;
        return this;
    }

    public EmpRelationQuery setUpperOrgExtAttr1(String upperOrgExtAttr1) {
        this.upperOrgExtAttr1 = upperOrgExtAttr1;
        return this;
    }

    public EmpRelationQuery setUpperOrgExtAttr1List(List<String> upperOrgExtAttr1List) {
        this.upperOrgExtAttr1List = upperOrgExtAttr1List;
        return this;
    }

    public EmpRelationQuery setUpperOrgExtAttr2(String upperOrgExtAttr2) {
        this.upperOrgExtAttr2 = upperOrgExtAttr2;
        return this;
    }

    public EmpRelationQuery setUpperOrgExtAttr2List(List<String> upperOrgExtAttr2List) {
        this.upperOrgExtAttr2List = upperOrgExtAttr2List;
        return this;
    }

    public EmpRelationQuery setUpperOrgExtAttr3(String upperOrgExtAttr3) {
        this.upperOrgExtAttr3 = upperOrgExtAttr3;
        return this;
    }

    public EmpRelationQuery setUpperOrgExtAttr3List(List<String> upperOrgExtAttr3List) {
        this.upperOrgExtAttr3List = upperOrgExtAttr3List;
        return this;
    }

    public EmpRelationQuery setUpperOrgExtAttr4(String upperOrgExtAttr4) {
        this.upperOrgExtAttr4 = upperOrgExtAttr4;
        return this;
    }

    public EmpRelationQuery setUpperOrgExtAttr4List(List<String> upperOrgExtAttr4List) {
        this.upperOrgExtAttr4List = upperOrgExtAttr4List;
        return this;
    }

    public EmpRelationQuery setUpperOrgExtAttr5(String upperOrgExtAttr5) {
        this.upperOrgExtAttr5 = upperOrgExtAttr5;
        return this;
    }

    public EmpRelationQuery setUpperOrgExtAttr5List(List<String> upperOrgExtAttr5List) {
        this.upperOrgExtAttr5List = upperOrgExtAttr5List;
        return this;
    }

    public EmpRelationQuery setUpperOrgExtAttr6(String upperOrgExtAttr6) {
        this.upperOrgExtAttr6 = upperOrgExtAttr6;
        return this;
    }

    public EmpRelationQuery setUpperOrgExtAttr6List(List<String> upperOrgExtAttr6List) {
        this.upperOrgExtAttr6List = upperOrgExtAttr6List;
        return this;
    }

    public EmpRelationQuery setUpperOrgExtAttr7(String upperOrgExtAttr7) {
        this.upperOrgExtAttr7 = upperOrgExtAttr7;
        return this;
    }

    public EmpRelationQuery setUpperOrgExtAttr7List(List<String> upperOrgExtAttr7List) {
        this.upperOrgExtAttr7List = upperOrgExtAttr7List;
        return this;
    }

    public EmpRelationQuery setUpperOrgExtAttr8(String upperOrgExtAttr8) {
        this.upperOrgExtAttr8 = upperOrgExtAttr8;
        return this;
    }

    public EmpRelationQuery setUpperOrgExtAttr8List(List<String> upperOrgExtAttr8List) {
        this.upperOrgExtAttr8List = upperOrgExtAttr8List;
        return this;
    }

    public EmpRelationQuery setUpperOrgStatus(String upperOrgStatus) {
        this.upperOrgStatus = upperOrgStatus;
        return this;
    }

    public EmpRelationQuery setUpperOrgStatusList(List<String> upperOrgStatusList) {
        this.upperOrgStatusList = upperOrgStatusList;
        return this;
    }

    public EmpRelationQuery setLowerEmpId(String lowerEmpId) {
        this.lowerEmpId = lowerEmpId;
        return this;
    }

    public EmpRelationQuery setLowerEmpIdList(List<String> lowerEmpIdList) {
        this.lowerEmpIdList = lowerEmpIdList;
        return this;
    }

    public EmpRelationQuery setLowerEmpCode(String lowerEmpCode) {
        this.lowerEmpCode = lowerEmpCode;
        return this;
    }

    public EmpRelationQuery setLowerEmpCodeList(List<String> lowerEmpCodeList) {
        this.lowerEmpCodeList = lowerEmpCodeList;
        return this;
    }

    public EmpRelationQuery setLowerEmpName(String lowerEmpName) {
        this.lowerEmpName = lowerEmpName;
        return this;
    }

    public EmpRelationQuery setLowerEmpNameList(List<String> lowerEmpNameList) {
        this.lowerEmpNameList = lowerEmpNameList;
        return this;
    }

    public EmpRelationQuery setLowerEmpCategory(String lowerEmpCategory) {
        this.lowerEmpCategory = lowerEmpCategory;
        return this;
    }

    public EmpRelationQuery setLowerEmpCategoryList(List<String> lowerEmpCategoryList) {
        this.lowerEmpCategoryList = lowerEmpCategoryList;
        return this;
    }

    public EmpRelationQuery setLowerEmpTag(String lowerEmpTag) {
        this.lowerEmpTag = lowerEmpTag;
        return this;
    }

    public EmpRelationQuery setLowerEmpExtAttr1(String lowerEmpExtAttr1) {
        this.lowerEmpExtAttr1 = lowerEmpExtAttr1;
        return this;
    }

    public EmpRelationQuery setLowerEmpExtAttr1List(List<String> lowerEmpExtAttr1List) {
        this.lowerEmpExtAttr1List = lowerEmpExtAttr1List;
        return this;
    }

    public EmpRelationQuery setLowerEmpExtAttr2(String lowerEmpExtAttr2) {
        this.lowerEmpExtAttr2 = lowerEmpExtAttr2;
        return this;
    }

    public EmpRelationQuery setLowerEmpExtAttr2List(List<String> lowerEmpExtAttr2List) {
        this.lowerEmpExtAttr2List = lowerEmpExtAttr2List;
        return this;
    }

    public EmpRelationQuery setLowerEmpExtAttr3(String lowerEmpExtAttr3) {
        this.lowerEmpExtAttr3 = lowerEmpExtAttr3;
        return this;
    }

    public EmpRelationQuery setLowerEmpExtAttr3List(List<String> lowerEmpExtAttr3List) {
        this.lowerEmpExtAttr3List = lowerEmpExtAttr3List;
        return this;
    }

    public EmpRelationQuery setLowerEmpExtAttr4(String lowerEmpExtAttr4) {
        this.lowerEmpExtAttr4 = lowerEmpExtAttr4;
        return this;
    }

    public EmpRelationQuery setLowerEmpExtAttr4List(List<String> lowerEmpExtAttr4List) {
        this.lowerEmpExtAttr4List = lowerEmpExtAttr4List;
        return this;
    }

    public EmpRelationQuery setLowerEmpExtAttr5(String lowerEmpExtAttr5) {
        this.lowerEmpExtAttr5 = lowerEmpExtAttr5;
        return this;
    }

    public EmpRelationQuery setLowerEmpExtAttr5List(List<String> lowerEmpExtAttr5List) {
        this.lowerEmpExtAttr5List = lowerEmpExtAttr5List;
        return this;
    }

    public EmpRelationQuery setLowerEmpExtAttr6(String lowerEmpExtAttr6) {
        this.lowerEmpExtAttr6 = lowerEmpExtAttr6;
        return this;
    }

    public EmpRelationQuery setLowerEmpExtAttr6List(List<String> lowerEmpExtAttr6List) {
        this.lowerEmpExtAttr6List = lowerEmpExtAttr6List;
        return this;
    }

    public EmpRelationQuery setLowerEmpExtAttr7(String lowerEmpExtAttr7) {
        this.lowerEmpExtAttr7 = lowerEmpExtAttr7;
        return this;
    }

    public EmpRelationQuery setLowerEmpExtAttr7List(List<String> lowerEmpExtAttr7List) {
        this.lowerEmpExtAttr7List = lowerEmpExtAttr7List;
        return this;
    }

    public EmpRelationQuery setLowerEmpExtAttr8(String lowerEmpExtAttr8) {
        this.lowerEmpExtAttr8 = lowerEmpExtAttr8;
        return this;
    }

    public EmpRelationQuery setLowerEmpExtAttr8List(List<String> lowerEmpExtAttr8List) {
        this.lowerEmpExtAttr8List = lowerEmpExtAttr8List;
        return this;
    }

    public EmpRelationQuery setLowerEmpStatus(String lowerEmpStatus) {
        this.lowerEmpStatus = lowerEmpStatus;
        return this;
    }

    public EmpRelationQuery setLowerEmpStatusList(List<String> lowerEmpStatusList) {
        this.lowerEmpStatusList = lowerEmpStatusList;
        return this;
    }

    public EmpRelationQuery setLowerOrgId(String lowerOrgId) {
        this.lowerOrgId = lowerOrgId;
        return this;
    }

    public EmpRelationQuery setLowerOrgIdList(List<String> lowerOrgIdList) {
        this.lowerOrgIdList = lowerOrgIdList;
        return this;
    }

    public EmpRelationQuery setLowerParentOrgId(String lowerParentOrgId) {
        this.lowerParentOrgId = lowerParentOrgId;
        return this;
    }

    public EmpRelationQuery setLowerParentOrgIdList(List<String> lowerParentOrgIdList) {
        this.lowerParentOrgIdList = lowerParentOrgIdList;
        return this;
    }

    public EmpRelationQuery setLowerOrgCode(String lowerOrgCode) {
        this.lowerOrgCode = lowerOrgCode;
        return this;
    }

    public EmpRelationQuery setLowerOrgCodeList(List<String> lowerOrgCodeList) {
        this.lowerOrgCodeList = lowerOrgCodeList;
        return this;
    }

    public EmpRelationQuery setLowerOrgName(String lowerOrgName) {
        this.lowerOrgName = lowerOrgName;
        return this;
    }

    public EmpRelationQuery setLowerOrgNameList(List<String> lowerOrgNameList) {
        this.lowerOrgNameList = lowerOrgNameList;
        return this;
    }

    public EmpRelationQuery setLowerOrgType(String lowerOrgType) {
        this.lowerOrgType = lowerOrgType;
        return this;
    }

    public EmpRelationQuery setLowerOrgTypeList(List<String> lowerOrgTypeList) {
        this.lowerOrgTypeList = lowerOrgTypeList;
        return this;
    }

    public EmpRelationQuery setLowerOrgCategory(String lowerOrgCategory) {
        this.lowerOrgCategory = lowerOrgCategory;
        return this;
    }

    public EmpRelationQuery setLowerOrgCategoryList(List<String> lowerOrgCategoryList) {
        this.lowerOrgCategoryList = lowerOrgCategoryList;
        return this;
    }

    public EmpRelationQuery setLowerOrgTag(String lowerOrgTag) {
        this.lowerOrgTag = lowerOrgTag;
        return this;
    }

    public EmpRelationQuery setLowerOrgExtAttr1(String lowerOrgExtAttr1) {
        this.lowerOrgExtAttr1 = lowerOrgExtAttr1;
        return this;
    }

    public EmpRelationQuery setLowerOrgExtAttr1List(List<String> lowerOrgExtAttr1List) {
        this.lowerOrgExtAttr1List = lowerOrgExtAttr1List;
        return this;
    }

    public EmpRelationQuery setLowerOrgExtAttr2(String lowerOrgExtAttr2) {
        this.lowerOrgExtAttr2 = lowerOrgExtAttr2;
        return this;
    }

    public EmpRelationQuery setLowerOrgExtAttr2List(List<String> lowerOrgExtAttr2List) {
        this.lowerOrgExtAttr2List = lowerOrgExtAttr2List;
        return this;
    }

    public EmpRelationQuery setLowerOrgExtAttr3(String lowerOrgExtAttr3) {
        this.lowerOrgExtAttr3 = lowerOrgExtAttr3;
        return this;
    }

    public EmpRelationQuery setLowerOrgExtAttr3List(List<String> lowerOrgExtAttr3List) {
        this.lowerOrgExtAttr3List = lowerOrgExtAttr3List;
        return this;
    }

    public EmpRelationQuery setLowerOrgExtAttr4(String lowerOrgExtAttr4) {
        this.lowerOrgExtAttr4 = lowerOrgExtAttr4;
        return this;
    }

    public EmpRelationQuery setLowerOrgExtAttr4List(List<String> lowerOrgExtAttr4List) {
        this.lowerOrgExtAttr4List = lowerOrgExtAttr4List;
        return this;
    }

    public EmpRelationQuery setLowerOrgExtAttr5(String lowerOrgExtAttr5) {
        this.lowerOrgExtAttr5 = lowerOrgExtAttr5;
        return this;
    }

    public EmpRelationQuery setLowerOrgExtAttr5List(List<String> lowerOrgExtAttr5List) {
        this.lowerOrgExtAttr5List = lowerOrgExtAttr5List;
        return this;
    }

    public EmpRelationQuery setLowerOrgExtAttr6(String lowerOrgExtAttr6) {
        this.lowerOrgExtAttr6 = lowerOrgExtAttr6;
        return this;
    }

    public EmpRelationQuery setLowerOrgExtAttr6List(List<String> lowerOrgExtAttr6List) {
        this.lowerOrgExtAttr6List = lowerOrgExtAttr6List;
        return this;
    }

    public EmpRelationQuery setLowerOrgExtAttr7(String lowerOrgExtAttr7) {
        this.lowerOrgExtAttr7 = lowerOrgExtAttr7;
        return this;
    }

    public EmpRelationQuery setLowerOrgExtAttr7List(List<String> lowerOrgExtAttr7List) {
        this.lowerOrgExtAttr7List = lowerOrgExtAttr7List;
        return this;
    }

    public EmpRelationQuery setLowerOrgExtAttr8(String lowerOrgExtAttr8) {
        this.lowerOrgExtAttr8 = lowerOrgExtAttr8;
        return this;
    }

    public EmpRelationQuery setLowerOrgExtAttr8List(List<String> lowerOrgExtAttr8List) {
        this.lowerOrgExtAttr8List = lowerOrgExtAttr8List;
        return this;
    }

    public EmpRelationQuery setLowerOrgStatus(String lowerOrgStatus) {
        this.lowerOrgStatus = lowerOrgStatus;
        return this;
    }

    public EmpRelationQuery setLowerOrgStatusList(List<String> lowerOrgStatusList) {
        this.lowerOrgStatusList = lowerOrgStatusList;
        return this;
    }

    public EmpRelationQuery setEmpRelationTagUnion(Boolean empRelationTagUnion) {
        this.empRelationTagUnion = empRelationTagUnion;
        return this;
    }

    public EmpRelationQuery setUpperEmpTagUnion(Boolean upperEmpTagUnion) {
        this.upperEmpTagUnion = upperEmpTagUnion;
        return this;
    }

    public EmpRelationQuery setUpperOrgTagUnion(Boolean upperOrgTagUnion) {
        this.upperOrgTagUnion = upperOrgTagUnion;
        return this;
    }

    public EmpRelationQuery setUpperWithinOrgId(String upperWithinOrgId) {
        this.upperWithinOrgId = upperWithinOrgId;
        return this;
    }

    public EmpRelationQuery setUpperOrgRootOnly(Boolean upperOrgRootOnly) {
        this.upperOrgRootOnly = upperOrgRootOnly;
        return this;
    }

    public EmpRelationQuery setLowerEmpTagUnion(Boolean lowerEmpTagUnion) {
        this.lowerEmpTagUnion = lowerEmpTagUnion;
        return this;
    }

    public EmpRelationQuery setLowerOrgTagUnion(Boolean lowerOrgTagUnion) {
        this.lowerOrgTagUnion = lowerOrgTagUnion;
        return this;
    }

    public EmpRelationQuery setLowerWithinOrgId(String lowerWithinOrgId) {
        this.lowerWithinOrgId = lowerWithinOrgId;
        return this;
    }

    public EmpRelationQuery setLowerOrgRootOnly(Boolean lowerOrgRootOnly) {
        this.lowerOrgRootOnly = lowerOrgRootOnly;
        return this;
    }

    public EmpRelationQuery setPage(Integer page) {
        this.page = page;
        return this;
    }

    public EmpRelationQuery setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public EmpRelationQuery setOperatorId(String operatorId) {
        this.operatorId = operatorId;
        return this;
    }

    public EmpRelationQuery setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    public List<Map<String, Object>> queryForMapList() {
        return omEmpRelationService.selectEmpRelation(orgnSetId, orgnSetCode, empRelationId, empRelationIdList, empRelation, empRelationList, empRelationCategory, empRelationCategoryList, empRelationTag, empRelationExtAttr1, empRelationExtAttr1List, empRelationExtAttr2, empRelationExtAttr2List, empRelationExtAttr3, empRelationExtAttr3List, empRelationExtAttr4, empRelationExtAttr4List, empRelationExtAttr5, empRelationExtAttr5List, empRelationExtAttr6, empRelationExtAttr6List, empRelationExtAttr7, empRelationExtAttr7List, empRelationExtAttr8, empRelationExtAttr8List, empRelationStatus, empRelationStatusList, upperEmpId, upperEmpIdList, upperEmpCode, upperEmpCodeList, upperEmpName, upperEmpNameList, upperEmpCategory, upperEmpCategoryList, upperEmpTag, upperEmpExtAttr1, upperEmpExtAttr1List,
                upperEmpExtAttr2, upperEmpExtAttr2List, upperEmpExtAttr3, upperEmpExtAttr3List, upperEmpExtAttr4, upperEmpExtAttr4List, upperEmpExtAttr5, upperEmpExtAttr5List, upperEmpExtAttr6, upperEmpExtAttr6List, upperEmpExtAttr7, upperEmpExtAttr7List, upperEmpExtAttr8, upperEmpExtAttr8List, upperEmpStatus, upperEmpStatusList, upperOrgId, upperOrgIdList, upperParentOrgId, upperParentOrgIdList, upperOrgCode, upperOrgCodeList, upperOrgName, upperOrgNameList, upperOrgType, upperOrgTypeList, upperOrgCategory, upperOrgCategoryList, upperOrgTag, upperOrgExtAttr1, upperOrgExtAttr1List, upperOrgExtAttr2, upperOrgExtAttr2List, upperOrgExtAttr3, upperOrgExtAttr3List, upperOrgExtAttr4, upperOrgExtAttr4List, upperOrgExtAttr5, upperOrgExtAttr5List, upperOrgExtAttr6, upperOrgExtAttr6List,
                upperOrgExtAttr7, upperOrgExtAttr7List, upperOrgExtAttr8, upperOrgExtAttr8List, upperOrgStatus, upperOrgStatusList, lowerEmpId, lowerEmpIdList, lowerEmpCode, lowerEmpCodeList, lowerEmpName, lowerEmpNameList, lowerEmpCategory, lowerEmpCategoryList, lowerEmpTag, lowerEmpExtAttr1, lowerEmpExtAttr1List, lowerEmpExtAttr2, lowerEmpExtAttr2List, lowerEmpExtAttr3, lowerEmpExtAttr3List, lowerEmpExtAttr4, lowerEmpExtAttr4List, lowerEmpExtAttr5, lowerEmpExtAttr5List, lowerEmpExtAttr6, lowerEmpExtAttr6List, lowerEmpExtAttr7, lowerEmpExtAttr7List, lowerEmpExtAttr8, lowerEmpExtAttr8List, lowerEmpStatus, lowerEmpStatusList, lowerOrgId, lowerOrgIdList, lowerParentOrgId, lowerParentOrgIdList, lowerOrgCode, lowerOrgCodeList, lowerOrgName, lowerOrgNameList, lowerOrgType, lowerOrgTypeList,
                lowerOrgCategory, lowerOrgCategoryList, lowerOrgTag, lowerOrgExtAttr1, lowerOrgExtAttr1List, lowerOrgExtAttr2, lowerOrgExtAttr2List, lowerOrgExtAttr3, lowerOrgExtAttr3List, lowerOrgExtAttr4, lowerOrgExtAttr4List, lowerOrgExtAttr5, lowerOrgExtAttr5List, lowerOrgExtAttr6, lowerOrgExtAttr6List, lowerOrgExtAttr7, lowerOrgExtAttr7List, lowerOrgExtAttr8, lowerOrgExtAttr8List, lowerOrgStatus, lowerOrgStatusList, empRelationTagUnion, upperEmpTagUnion, upperOrgTagUnion, upperWithinOrgId, upperOrgRootOnly, lowerEmpTagUnion, lowerOrgTagUnion, lowerWithinOrgId, lowerOrgRootOnly, page, limit, operatorId, operatorName);
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

    public List<EmpRelation> queryForObjectList() {
        List<Map<String, Object>> result = queryForMapList();
        List<EmpRelation> empRelationList = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            empRelationList.add(new EmpRelation(result.get(i)));
        }

        return empRelationList;
    }

    public EmpRelation queryForObject() {
        List<Map<String, Object>> result = queryForMapList();
        if (result.size() == 1) {
            return new EmpRelation(result.get(0));
        }
        else {
            return null;
        }
    }

    public int count() {
        return omEmpRelationService.countEmpRelation(orgnSetId, orgnSetCode, empRelationId, empRelationIdList, empRelation, empRelationList, empRelationCategory, empRelationCategoryList, empRelationTag, empRelationExtAttr1, empRelationExtAttr1List, empRelationExtAttr2, empRelationExtAttr2List, empRelationExtAttr3, empRelationExtAttr3List, empRelationExtAttr4, empRelationExtAttr4List, empRelationExtAttr5, empRelationExtAttr5List, empRelationExtAttr6, empRelationExtAttr6List, empRelationExtAttr7, empRelationExtAttr7List, empRelationExtAttr8, empRelationExtAttr8List, empRelationStatus, empRelationStatusList, upperEmpId, upperEmpIdList, upperEmpCode, upperEmpCodeList, upperEmpName, upperEmpNameList, upperEmpCategory, upperEmpCategoryList, upperEmpTag, upperEmpExtAttr1, upperEmpExtAttr1List,
                upperEmpExtAttr2, upperEmpExtAttr2List, upperEmpExtAttr3, upperEmpExtAttr3List, upperEmpExtAttr4, upperEmpExtAttr4List, upperEmpExtAttr5, upperEmpExtAttr5List, upperEmpExtAttr6, upperEmpExtAttr6List, upperEmpExtAttr7, upperEmpExtAttr7List, upperEmpExtAttr8, upperEmpExtAttr8List, upperEmpStatus, upperEmpStatusList, upperOrgId, upperOrgIdList, upperParentOrgId, upperParentOrgIdList, upperOrgCode, upperOrgCodeList, upperOrgName, upperOrgNameList, upperOrgType, upperOrgTypeList, upperOrgCategory, upperOrgCategoryList, upperOrgTag, upperOrgExtAttr1, upperOrgExtAttr1List, upperOrgExtAttr2, upperOrgExtAttr2List, upperOrgExtAttr3, upperOrgExtAttr3List, upperOrgExtAttr4, upperOrgExtAttr4List, upperOrgExtAttr5, upperOrgExtAttr5List, upperOrgExtAttr6, upperOrgExtAttr6List,
                upperOrgExtAttr7, upperOrgExtAttr7List, upperOrgExtAttr8, upperOrgExtAttr8List, upperOrgStatus, upperOrgStatusList, lowerEmpId, lowerEmpIdList, lowerEmpCode, lowerEmpCodeList, lowerEmpName, lowerEmpNameList, lowerEmpCategory, lowerEmpCategoryList, lowerEmpTag, lowerEmpExtAttr1, lowerEmpExtAttr1List, lowerEmpExtAttr2, lowerEmpExtAttr2List, lowerEmpExtAttr3, lowerEmpExtAttr3List, lowerEmpExtAttr4, lowerEmpExtAttr4List, lowerEmpExtAttr5, lowerEmpExtAttr5List, lowerEmpExtAttr6, lowerEmpExtAttr6List, lowerEmpExtAttr7, lowerEmpExtAttr7List, lowerEmpExtAttr8, lowerEmpExtAttr8List, lowerEmpStatus, lowerEmpStatusList, lowerOrgId, lowerOrgIdList, lowerParentOrgId, lowerParentOrgIdList, lowerOrgCode, lowerOrgCodeList, lowerOrgName, lowerOrgNameList, lowerOrgType, lowerOrgTypeList,
                lowerOrgCategory, lowerOrgCategoryList, lowerOrgTag, lowerOrgExtAttr1, lowerOrgExtAttr1List, lowerOrgExtAttr2, lowerOrgExtAttr2List, lowerOrgExtAttr3, lowerOrgExtAttr3List, lowerOrgExtAttr4, lowerOrgExtAttr4List, lowerOrgExtAttr5, lowerOrgExtAttr5List, lowerOrgExtAttr6, lowerOrgExtAttr6List, lowerOrgExtAttr7, lowerOrgExtAttr7List, lowerOrgExtAttr8, lowerOrgExtAttr8List, lowerOrgStatus, lowerOrgStatusList, empRelationTagUnion, upperEmpTagUnion, upperOrgTagUnion, upperWithinOrgId, upperOrgRootOnly, lowerEmpTagUnion, lowerOrgTagUnion, lowerWithinOrgId, lowerOrgRootOnly, operatorId, operatorName);
    }
}