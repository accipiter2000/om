package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmOrgnSetService;
import com.opendynamic.om.vo.OrgnSet;

@Service
public class OrgnSetQuery {
    private OmOrgnSetService omOrgnSetService;

    private String orgnSetId;
    private List<String> orgnSetIdList;
    private String parentOrgnSetId;
    private List<String> parentOrgnSetIdList;
    private String orgnSetCode;
    private List<String> orgnSetCodeList;
    private String orgnSetName;
    private List<String> orgnSetNameList;
    private String orgnSetStatus;
    private List<String> orgnSetStatusList;
    private Boolean orgnSetRootOnly;
    private Integer page;
    private Integer limit;
    private String operatorId;
    private String operatorName;

    public OrgnSetQuery(OmOrgnSetService omOrgnSetService) {
        super();
        this.omOrgnSetService = omOrgnSetService;
    }

    public OrgnSetQuery setOrgnSetId(String orgnSetId) {
        this.orgnSetId = orgnSetId;
        return this;
    }

    public OrgnSetQuery setOrgnSetIdList(List<String> orgnSetIdList) {
        this.orgnSetIdList = orgnSetIdList;
        return this;
    }

    public OrgnSetQuery setParentOrgnSetId(String parentOrgnSetId) {
        this.parentOrgnSetId = parentOrgnSetId;
        return this;
    }

    public OrgnSetQuery setParentOrgnSetIdList(List<String> parentOrgnSetIdList) {
        this.parentOrgnSetIdList = parentOrgnSetIdList;
        return this;
    }

    public OrgnSetQuery setOrgnSetCode(String orgnSetCode) {
        this.orgnSetCode = orgnSetCode;
        return this;
    }

    public OrgnSetQuery setOrgnSetCodeList(List<String> orgnSetCodeList) {
        this.orgnSetCodeList = orgnSetCodeList;
        return this;
    }

    public OrgnSetQuery setOrgnSetName(String orgnSetName) {
        this.orgnSetName = orgnSetName;
        return this;
    }

    public OrgnSetQuery setOrgnSetNameList(List<String> orgnSetNameList) {
        this.orgnSetNameList = orgnSetNameList;
        return this;
    }

    public OrgnSetQuery setOrgnSetStatus(String orgnSetStatus) {
        this.orgnSetStatus = orgnSetStatus;
        return this;
    }

    public OrgnSetQuery setOrgnSetStatusList(List<String> orgnSetStatusList) {
        this.orgnSetStatusList = orgnSetStatusList;
        return this;
    }

    public OrgnSetQuery setOrgnSetRootOnly(Boolean orgnSetRootOnly) {
        this.orgnSetRootOnly = orgnSetRootOnly;
        return this;
    }

    public OrgnSetQuery setPage(Integer page) {
        this.page = page;
        return this;
    }

    public OrgnSetQuery setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public OrgnSetQuery setOperatorId(String operatorId) {
        this.operatorId = operatorId;
        return this;
    }

    public OrgnSetQuery setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    public List<Map<String, Object>> queryForMapList() {
        return omOrgnSetService.selectOrgnSet(orgnSetId, orgnSetIdList, parentOrgnSetId, parentOrgnSetIdList, orgnSetCode, orgnSetCodeList, orgnSetName, orgnSetNameList, orgnSetStatus, orgnSetStatusList, orgnSetRootOnly, page, limit, operatorId, operatorName);
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

    public List<OrgnSet> queryForObjectList() {
        List<Map<String, Object>> result = queryForMapList();
        List<OrgnSet> orgnSetList = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            orgnSetList.add(new OrgnSet(result.get(i)));
        }

        return orgnSetList;
    }

    public OrgnSet queryForObject() {
        List<Map<String, Object>> result = queryForMapList();
        if (result.size() == 1) {
            return new OrgnSet(result.get(0));
        }
        else {
            return null;
        }
    }

    public int count() {
        return omOrgnSetService.countOrgnSet(orgnSetId, orgnSetIdList, parentOrgnSetId, parentOrgnSetIdList, orgnSetCode, orgnSetCodeList, orgnSetName, orgnSetNameList, orgnSetStatus, orgnSetStatusList, orgnSetRootOnly, operatorId, operatorName);
    }
}