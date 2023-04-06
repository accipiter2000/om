package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmEmpService;
import com.opendynamic.om.vo.Emp;

@Service
public class EmpQuery {
    private OmEmpService omEmpService;

    private String orgnSetId;
    private String orgnSetCode;
    private String empId;
    private String orgId;
    private String empCode;
    private String empName;
    private List<String> categoryList;
    private String empTag;
    private String extAttr1;
    private String extAttr2;
    private String extAttr3;
    private String extAttr4;
    private String extAttr5;
    private String extAttr6;
    private String extAttr7;
    private String extAttr8;
    private List<String> empStatusList;
    private Boolean tagUnion;
    private String withinOrgId;
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

    public EmpQuery setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public EmpQuery setEmpCode(String empCode) {
        this.empCode = empCode;
        return this;
    }

    public EmpQuery setEmpName(String empName) {
        this.empName = empName;
        return this;
    }

    public EmpQuery setCategory(String category) {
        if (StringUtils.isNotEmpty(category)) {
            this.categoryList = new ArrayList<>();
            this.categoryList.add(category);
        }
        return this;
    }

    public EmpQuery setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
        return this;
    }

    public EmpQuery setEmpTag(String empTag) {
        this.empTag = empTag;
        return this;
    }

    public EmpQuery setExtAttr1(String extAttr1) {
        this.extAttr1 = extAttr1;
        return this;
    }

    public EmpQuery setExtAttr2(String extAttr2) {
        this.extAttr2 = extAttr2;
        return this;
    }

    public EmpQuery setExtAttr3(String extAttr3) {
        this.extAttr3 = extAttr3;
        return this;
    }

    public EmpQuery setExtAttr4(String extAttr4) {
        this.extAttr4 = extAttr4;
        return this;
    }

    public EmpQuery setExtAttr5(String extAttr5) {
        this.extAttr5 = extAttr5;
        return this;
    }

    public EmpQuery setExtAttr6(String extAttr6) {
        this.extAttr6 = extAttr6;
        return this;
    }

    public EmpQuery setExtAttr7(String extAttr7) {
        this.extAttr7 = extAttr7;
        return this;
    }

    public EmpQuery setExtAttr8(String extAttr8) {
        this.extAttr8 = extAttr8;
        return this;
    }

    public EmpQuery setEmpStatus(String empStatus) {
        if (StringUtils.isNotEmpty(empStatus)) {
            this.empStatusList = new ArrayList<>();
            this.empStatusList.add(empStatus);
        }
        return this;
    }

    public EmpQuery setEmpStatusList(List<String> empStatusList) {
        this.empStatusList = empStatusList;
        return this;
    }

    public EmpQuery setTagUnion(Boolean tagUnion) {
        this.tagUnion = tagUnion;
        return this;
    }

    public EmpQuery setWithinOrgId(String withinOrgId) {
        this.withinOrgId = withinOrgId;
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
        return omEmpService.selectEmp(orgnSetId, orgnSetCode, empId, orgId, empCode, empName, categoryList, empTag, extAttr1, extAttr2, extAttr3, extAttr4, extAttr5, extAttr6, extAttr7, extAttr8, empStatusList, tagUnion, withinOrgId, page, limit, operatorId, operatorName);
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
        return omEmpService.countEmp(orgnSetId, orgnSetCode, empId, orgId, empCode, empName, categoryList, empTag, extAttr1, extAttr2, extAttr3, extAttr4, extAttr5, extAttr6, extAttr7, extAttr8, empStatusList, tagUnion, withinOrgId, operatorId, operatorName);
    }
}