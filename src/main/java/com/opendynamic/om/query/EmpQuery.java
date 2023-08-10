package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmEmpService;
import com.opendynamic.om.vo.Emp;

@Service
public class EmpQuery {
    private OmEmpService omEmpService;

    private String orgnSetId;
    private String orgnSetCode;
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
    private Boolean empTagUnion;
    private Boolean orgTagUnion;
    private String withinOrgId;
    private Boolean orgRootOnly;
    private Integer page;
    private Integer limit;
    private String operatorId;
    private String operatorName;

    public EmpQuery(OmEmpService omEmpService) {
        super();
        this.omEmpService = omEmpService;
    }

    public EmpQuery setOrgnSetId(String orgnSetId) {
        this.orgnSetId = orgnSetId;
        return this;
    }

    public EmpQuery setOrgnSetCode(String orgnSetCode) {
        this.orgnSetCode = orgnSetCode;
        return this;
    }

    public EmpQuery setEmpId(String empId) {
        this.empId = empId;
        return this;
    }

    public EmpQuery setEmpIdList(List<String> empIdList) {
        this.empIdList = empIdList;
        return this;
    }

    public EmpQuery setEmpCode(String empCode) {
        this.empCode = empCode;
        return this;
    }

    public EmpQuery setEmpCodeList(List<String> empCodeList) {
        this.empCodeList = empCodeList;
        return this;
    }

    public EmpQuery setEmpName(String empName) {
        this.empName = empName;
        return this;
    }

    public EmpQuery setEmpNameList(List<String> empNameList) {
        this.empNameList = empNameList;
        return this;
    }

    public EmpQuery setEmpCategory(String empCategory) {
        this.empCategory = empCategory;
        return this;
    }

    public EmpQuery setEmpCategoryList(List<String> empCategoryList) {
        this.empCategoryList = empCategoryList;
        return this;
    }

    public EmpQuery setEmpTag(String empTag) {
        this.empTag = empTag;
        return this;
    }

    public EmpQuery setEmpExtAttr1(String empExtAttr1) {
        this.empExtAttr1 = empExtAttr1;
        return this;
    }

    public EmpQuery setEmpExtAttr1List(List<String> empExtAttr1List) {
        this.empExtAttr1List = empExtAttr1List;
        return this;
    }

    public EmpQuery setEmpExtAttr2(String empExtAttr2) {
        this.empExtAttr2 = empExtAttr2;
        return this;
    }

    public EmpQuery setEmpExtAttr2List(List<String> empExtAttr2List) {
        this.empExtAttr2List = empExtAttr2List;
        return this;
    }

    public EmpQuery setEmpExtAttr3(String empExtAttr3) {
        this.empExtAttr3 = empExtAttr3;
        return this;
    }

    public EmpQuery setEmpExtAttr3List(List<String> empExtAttr3List) {
        this.empExtAttr3List = empExtAttr3List;
        return this;
    }

    public EmpQuery setEmpExtAttr4(String empExtAttr4) {
        this.empExtAttr4 = empExtAttr4;
        return this;
    }

    public EmpQuery setEmpExtAttr4List(List<String> empExtAttr4List) {
        this.empExtAttr4List = empExtAttr4List;
        return this;
    }

    public EmpQuery setEmpExtAttr5(String empExtAttr5) {
        this.empExtAttr5 = empExtAttr5;
        return this;
    }

    public EmpQuery setEmpExtAttr5List(List<String> empExtAttr5List) {
        this.empExtAttr5List = empExtAttr5List;
        return this;
    }

    public EmpQuery setEmpExtAttr6(String empExtAttr6) {
        this.empExtAttr6 = empExtAttr6;
        return this;
    }

    public EmpQuery setEmpExtAttr6List(List<String> empExtAttr6List) {
        this.empExtAttr6List = empExtAttr6List;
        return this;
    }

    public EmpQuery setEmpExtAttr7(String empExtAttr7) {
        this.empExtAttr7 = empExtAttr7;
        return this;
    }

    public EmpQuery setEmpExtAttr7List(List<String> empExtAttr7List) {
        this.empExtAttr7List = empExtAttr7List;
        return this;
    }

    public EmpQuery setEmpExtAttr8(String empExtAttr8) {
        this.empExtAttr8 = empExtAttr8;
        return this;
    }

    public EmpQuery setEmpExtAttr8List(List<String> empExtAttr8List) {
        this.empExtAttr8List = empExtAttr8List;
        return this;
    }

    public EmpQuery setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
        return this;
    }

    public EmpQuery setEmpStatusList(List<String> empStatusList) {
        this.empStatusList = empStatusList;
        return this;
    }

    public EmpQuery setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public EmpQuery setOrgIdList(List<String> orgIdList) {
        this.orgIdList = orgIdList;
        return this;
    }

    public EmpQuery setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
        return this;
    }

    public EmpQuery setParentOrgIdList(List<String> parentOrgIdList) {
        this.parentOrgIdList = parentOrgIdList;
        return this;
    }

    public EmpQuery setOrgCode(String orgCode) {
        this.orgCode = orgCode;
        return this;
    }

    public EmpQuery setOrgCodeList(List<String> orgCodeList) {
        this.orgCodeList = orgCodeList;
        return this;
    }

    public EmpQuery setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public EmpQuery setOrgNameList(List<String> orgNameList) {
        this.orgNameList = orgNameList;
        return this;
    }

    public EmpQuery setOrgType(String orgType) {
        this.orgType = orgType;
        return this;
    }

    public EmpQuery setOrgTypeList(List<String> orgTypeList) {
        this.orgTypeList = orgTypeList;
        return this;
    }

    public EmpQuery setOrgCategory(String orgCategory) {
        this.orgCategory = orgCategory;
        return this;
    }

    public EmpQuery setOrgCategoryList(List<String> orgCategoryList) {
        this.orgCategoryList = orgCategoryList;
        return this;
    }

    public EmpQuery setOrgTag(String orgTag) {
        this.orgTag = orgTag;
        return this;
    }

    public EmpQuery setOrgExtAttr1(String orgExtAttr1) {
        this.orgExtAttr1 = orgExtAttr1;
        return this;
    }

    public EmpQuery setOrgExtAttr1List(List<String> orgExtAttr1List) {
        this.orgExtAttr1List = orgExtAttr1List;
        return this;
    }

    public EmpQuery setOrgExtAttr2(String orgExtAttr2) {
        this.orgExtAttr2 = orgExtAttr2;
        return this;
    }

    public EmpQuery setOrgExtAttr2List(List<String> orgExtAttr2List) {
        this.orgExtAttr2List = orgExtAttr2List;
        return this;
    }

    public EmpQuery setOrgExtAttr3(String orgExtAttr3) {
        this.orgExtAttr3 = orgExtAttr3;
        return this;
    }

    public EmpQuery setOrgExtAttr3List(List<String> orgExtAttr3List) {
        this.orgExtAttr3List = orgExtAttr3List;
        return this;
    }

    public EmpQuery setOrgExtAttr4(String orgExtAttr4) {
        this.orgExtAttr4 = orgExtAttr4;
        return this;
    }

    public EmpQuery setOrgExtAttr4List(List<String> orgExtAttr4List) {
        this.orgExtAttr4List = orgExtAttr4List;
        return this;
    }

    public EmpQuery setOrgExtAttr5(String orgExtAttr5) {
        this.orgExtAttr5 = orgExtAttr5;
        return this;
    }

    public EmpQuery setOrgExtAttr5List(List<String> orgExtAttr5List) {
        this.orgExtAttr5List = orgExtAttr5List;
        return this;
    }

    public EmpQuery setOrgExtAttr6(String orgExtAttr6) {
        this.orgExtAttr6 = orgExtAttr6;
        return this;
    }

    public EmpQuery setOrgExtAttr6List(List<String> orgExtAttr6List) {
        this.orgExtAttr6List = orgExtAttr6List;
        return this;
    }

    public EmpQuery setOrgExtAttr7(String orgExtAttr7) {
        this.orgExtAttr7 = orgExtAttr7;
        return this;
    }

    public EmpQuery setOrgExtAttr7List(List<String> orgExtAttr7List) {
        this.orgExtAttr7List = orgExtAttr7List;
        return this;
    }

    public EmpQuery setOrgExtAttr8(String orgExtAttr8) {
        this.orgExtAttr8 = orgExtAttr8;
        return this;
    }

    public EmpQuery setOrgExtAttr8List(List<String> orgExtAttr8List) {
        this.orgExtAttr8List = orgExtAttr8List;
        return this;
    }

    public EmpQuery setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus;
        return this;
    }

    public EmpQuery setOrgStatusList(List<String> orgStatusList) {
        this.orgStatusList = orgStatusList;
        return this;
    }

    public EmpQuery setEmpTagUnion(Boolean empTagUnion) {
        this.empTagUnion = empTagUnion;
        return this;
    }

    public EmpQuery setOrgTagUnion(Boolean orgTagUnion) {
        this.orgTagUnion = orgTagUnion;
        return this;
    }

    public EmpQuery setWithinOrgId(String withinOrgId) {
        this.withinOrgId = withinOrgId;
        return this;
    }

    public EmpQuery setOrgRootOnly(Boolean orgRootOnly) {
        this.orgRootOnly = orgRootOnly;
        return this;
    }

    public EmpQuery setPage(Integer page) {
        this.page = page;
        return this;
    }

    public EmpQuery setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public EmpQuery setOperatorId(String operatorId) {
        this.operatorId = operatorId;
        return this;
    }

    public EmpQuery setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    public List<Map<String, Object>> queryForMapList() {
        return omEmpService.selectEmp(orgnSetId, orgnSetCode, empId, empIdList, empCode, empCodeList, empName, empNameList, empCategory, empCategoryList, empTag, empExtAttr1, empExtAttr1List, empExtAttr2, empExtAttr2List, empExtAttr3, empExtAttr3List, empExtAttr4, empExtAttr4List, empExtAttr5, empExtAttr5List, empExtAttr6, empExtAttr6List, empExtAttr7, empExtAttr7List, empExtAttr8, empExtAttr8List, empStatus, empStatusList, orgId, orgIdList, parentOrgId, parentOrgIdList, orgCode, orgCodeList, orgName, orgNameList, orgType, orgTypeList, orgCategory, orgCategoryList, orgTag, orgExtAttr1, orgExtAttr1List, orgExtAttr2, orgExtAttr2List, orgExtAttr3, orgExtAttr3List, orgExtAttr4, orgExtAttr4List, orgExtAttr5, orgExtAttr5List, orgExtAttr6, orgExtAttr6List, orgExtAttr7, orgExtAttr7List,
                orgExtAttr8, orgExtAttr8List, orgStatus, orgStatusList, empTagUnion, orgTagUnion, withinOrgId, orgRootOnly, page, limit, operatorId, operatorName);
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

    public List<Emp> queryForObjectList() {
        List<Map<String, Object>> result = queryForMapList();
        List<Emp> empList = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            empList.add(new Emp(result.get(i)));
        }

        return empList;
    }

    public Emp queryForObject() {
        List<Map<String, Object>> result = queryForMapList();
        if (result.size() == 1) {
            return new Emp(result.get(0));
        }
        else {
            return null;
        }
    }

    public int count() {
        return omEmpService.countEmp(orgnSetId, orgnSetCode, empId, empIdList, empCode, empCodeList, empName, empNameList, empCategory, empCategoryList, empTag, empExtAttr1, empExtAttr1List, empExtAttr2, empExtAttr2List, empExtAttr3, empExtAttr3List, empExtAttr4, empExtAttr4List, empExtAttr5, empExtAttr5List, empExtAttr6, empExtAttr6List, empExtAttr7, empExtAttr7List, empExtAttr8, empExtAttr8List, empStatus, empStatusList, orgId, orgIdList, parentOrgId, parentOrgIdList, orgCode, orgCodeList, orgName, orgNameList, orgType, orgTypeList, orgCategory, orgCategoryList, orgTag, orgExtAttr1, orgExtAttr1List, orgExtAttr2, orgExtAttr2List, orgExtAttr3, orgExtAttr3List, orgExtAttr4, orgExtAttr4List, orgExtAttr5, orgExtAttr5List, orgExtAttr6, orgExtAttr6List, orgExtAttr7, orgExtAttr7List,
                orgExtAttr8, orgExtAttr8List, orgStatus, orgStatusList, empTagUnion, orgTagUnion, withinOrgId, orgRootOnly, operatorId, operatorName);
    }
}