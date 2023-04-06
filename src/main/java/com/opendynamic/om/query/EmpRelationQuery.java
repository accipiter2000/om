package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmEmpRelationService;
import com.opendynamic.om.vo.EmpRelation;

@Service
public class EmpRelationQuery {
    private OmEmpRelationService omEmpRelationService;

    private String empRelationId;
    private String orgnSetId;
    private String orgnSetCode;
    private String upperEmpId;
    private String lowerEmpId;
    private List<String> empRelationList;
    private String empRelationTag;
    private List<String> empRelationStatusList;
    private Boolean tagUnion;
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

    public EmpRelationQuery setUpperEmpId(String upperEmpId) {
        this.upperEmpId = upperEmpId;
        return this;
    }

    public EmpRelationQuery setLowerEmpId(String lowerEmpId) {
        this.lowerEmpId = lowerEmpId;
        return this;
    }

    public EmpRelationQuery setEmpRelation(String empRelation) {
        if (StringUtils.isNotEmpty(empRelation)) {
            this.empRelationList = new ArrayList<>();
            this.empRelationList.add(empRelation);
        }
        return this;
    }

    public EmpRelationQuery setEmpRelationList(List<String> empRelationList) {
        this.empRelationList = empRelationList;
        return this;
    }

    public EmpRelationQuery setEmpRelationTag(String empRelationTag) {
        this.empRelationTag = empRelationTag;
        return this;
    }

    public EmpRelationQuery setEmpRelationStatus(String empRelationStatus) {
        if (StringUtils.isNotEmpty(empRelationStatus)) {
            this.empRelationStatusList = new ArrayList<>();
            this.empRelationStatusList.add(empRelationStatus);
        }
        return this;
    }

    public EmpRelationQuery setEmpRelationStatusList(List<String> empRelationStatusList) {
        this.empRelationStatusList = empRelationStatusList;
        return this;
    }

    public EmpRelationQuery setTagUnion(Boolean tagUnion) {
        this.tagUnion = tagUnion;
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
        return omEmpRelationService.selectEmpRelation(orgnSetId, orgnSetCode, empRelationId, upperEmpId, lowerEmpId, empRelationList, empRelationTag, empRelationStatusList, tagUnion, page, limit, operatorId, operatorName);
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
        return omEmpRelationService.countEmpRelation(orgnSetId, orgnSetCode, empRelationId, upperEmpId, lowerEmpId, empRelationList, empRelationTag, empRelationStatusList, tagUnion, operatorId, operatorName);
    }
}