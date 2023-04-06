package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmPosiEmpService;
import com.opendynamic.om.vo.PosiEmp;

@Service
public class PosiEmpQuery {
    private OmPosiEmpService omPosiEmpService;

    private String orgnSetId;
    private String orgnSetCode;
    private String posiEmpId;
    private String orgId;
    private String dutyId;
    private String posiId;
    private String empId;
    private List<String> orgCodeList;
    private List<String> dutyCodeList;
    private List<String> posiCodeList;
    private List<String> empCodeList;
    private List<String> mainList;
    private String posiEmpTag;
    private List<String> posiEmpStatusList;
    private String empName;
    private List<String> categoryList;
    private String empTag;
    private List<String> empStatusList;
    private Boolean tagUnion;
    private String withinOrgId;
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

    public PosiEmpQuery setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public PosiEmpQuery setDutyId(String dutyId) {
        this.dutyId = dutyId;
        return this;
    }

    public PosiEmpQuery setPosiId(String posiId) {
        this.posiId = posiId;
        return this;
    }

    public PosiEmpQuery setEmpId(String empId) {
        this.empId = empId;
        return this;
    }

    public PosiEmpQuery setOrgCode(String orgCode) {
        if (StringUtils.isNotEmpty(orgCode)) {
            this.orgCodeList = new ArrayList<>();
            this.orgCodeList.add(orgCode);
        }
        return this;
    }

    public PosiEmpQuery setOrgCodeList(List<String> orgCodeList) {
        this.orgCodeList = orgCodeList;
        return this;
    }

    public PosiEmpQuery setDutyCode(String dutyCode) {
        if (StringUtils.isNotEmpty(dutyCode)) {
            this.dutyCodeList = new ArrayList<>();
            this.dutyCodeList.add(dutyCode);
        }
        return this;
    }

    public PosiEmpQuery setDutyCodeList(List<String> dutyCodeList) {
        this.dutyCodeList = dutyCodeList;
        return this;
    }

    public PosiEmpQuery setPosiCode(String posiCode) {
        if (StringUtils.isNotEmpty(posiCode)) {
            this.posiCodeList = new ArrayList<>();
            this.posiCodeList.add(posiCode);
        }
        return this;
    }

    public PosiEmpQuery setPosiCodeList(List<String> posiCodeList) {
        this.posiCodeList = posiCodeList;
        return this;
    }

    public PosiEmpQuery setEmpCode(String empCode) {
        if (StringUtils.isNotEmpty(empCode)) {
            this.empCodeList = new ArrayList<>();
            this.empCodeList.add(empCode);
        }
        return this;
    }

    public PosiEmpQuery setEmpCodeList(List<String> empCodeList) {
        this.empCodeList = empCodeList;
        return this;
    }

    public PosiEmpQuery setMain(String main) {
        if (StringUtils.isNotEmpty(main)) {
            this.mainList = new ArrayList<>();
            this.mainList.add(main);
        }
        return this;
    }

    public PosiEmpQuery setMainList(List<String> mainList) {
        this.mainList = mainList;
        return this;
    }

    public PosiEmpQuery setPosiEmpTag(String posiEmpTag) {
        this.posiEmpTag = posiEmpTag;
        return this;
    }

    public PosiEmpQuery setPosiEmpStatus(String posiEmpStatus) {
        if (StringUtils.isNotEmpty(posiEmpStatus)) {
            this.posiEmpStatusList = new ArrayList<>();
            this.posiEmpStatusList.add(posiEmpStatus);
        }
        return this;
    }

    public PosiEmpQuery setPosiEmpStatusList(List<String> posiEmpStatusList) {
        this.posiEmpStatusList = posiEmpStatusList;
        return this;
    }

    public PosiEmpQuery setEmpName(String empName) {
        this.empName = empName;
        return this;
    }

    public PosiEmpQuery setCategory(String category) {
        if (StringUtils.isNotEmpty(category)) {
            this.categoryList = new ArrayList<>();
            this.categoryList.add(category);
        }
        return this;
    }

    public PosiEmpQuery setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
        return this;
    }

    public PosiEmpQuery setEmpTag(String empTag) {
        this.empTag = empTag;
        return this;
    }

    public PosiEmpQuery setEmpStatus(String empStatus) {
        if (StringUtils.isNotEmpty(empStatus)) {
            this.empStatusList = new ArrayList<>();
            this.empStatusList.add(empStatus);
        }
        return this;
    }

    public PosiEmpQuery setEmpStatusList(List<String> empStatusList) {
        this.empStatusList = empStatusList;
        return this;
    }

    public PosiEmpQuery setTagUnion(Boolean tagUnion) {
        this.tagUnion = tagUnion;
        return this;
    }

    public PosiEmpQuery setWithinOrgId(String withinOrgId) {
        this.withinOrgId = withinOrgId;
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
        return omPosiEmpService.selectPosiEmp(orgnSetId, orgnSetCode, posiEmpId, orgId, dutyId, posiId, empId, orgCodeList, dutyCodeList, posiCodeList, empCodeList, mainList, posiEmpTag, posiEmpStatusList, empName, categoryList, empTag, empStatusList, tagUnion, withinOrgId, page, limit, operatorId, operatorName);
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
        return omPosiEmpService.countPosiEmp(orgnSetId, orgnSetCode, posiEmpId, orgId, dutyId, posiId, empId, orgCodeList, dutyCodeList, posiCodeList, empCodeList, mainList, posiEmpTag, posiEmpStatusList, empName, categoryList, empTag, empStatusList, tagUnion, withinOrgId, operatorId, operatorName);
    }
}