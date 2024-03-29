package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmOrgnSetService;
import com.opendynamic.om.vo.OrgnSet;

@Service
public class ChildOrgnSetQuery {
    private OmOrgnSetService omOrgnSetService;

    private String orgnSetId;
    private String orgnSetCode;
    private List<String> orgnSetCodeList;
    private String orgnSetName;
    private List<String> orgnSetNameList;
    private String orgnSetStatus;
    private List<String> orgnSetStatusList;
    private Boolean orgnSetRootOnly;
    private Boolean recursive;
    private Boolean includeSelf;
    private String operatorId;
    private String operatorName;

    public ChildOrgnSetQuery(OmOrgnSetService omOrgnSetService) {
        super();
        this.omOrgnSetService = omOrgnSetService;
    }

    public ChildOrgnSetQuery setOrgnSetId(String orgnSetId) {
        this.orgnSetId = orgnSetId;
        return this;
    }

    public ChildOrgnSetQuery setOrgnSetCode(String orgnSetCode) {
        this.orgnSetCode = orgnSetCode;
        return this;
    }

    public ChildOrgnSetQuery setOrgnSetCodeList(List<String> orgnSetCodeList) {
        this.orgnSetCodeList = orgnSetCodeList;
        return this;
    }

    public ChildOrgnSetQuery setOrgnSetName(String orgnSetName) {
        this.orgnSetName = orgnSetName;
        return this;
    }

    public ChildOrgnSetQuery setOrgnSetNameList(List<String> orgnSetNameList) {
        this.orgnSetNameList = orgnSetNameList;
        return this;
    }

    public ChildOrgnSetQuery setOrgnSetStatus(String orgnSetStatus) {
        this.orgnSetStatus = orgnSetStatus;
        return this;
    }

    public ChildOrgnSetQuery setOrgnSetStatusList(List<String> orgnSetStatusList) {
        this.orgnSetStatusList = orgnSetStatusList;
        return this;
    }

    public ChildOrgnSetQuery setOrgnSetRootOnly(Boolean orgnSetRootOnly) {
        this.orgnSetRootOnly = orgnSetRootOnly;
        return this;
    }

    public ChildOrgnSetQuery setRecursive(Boolean recursive) {
        this.recursive = recursive;
        return this;
    }

    public ChildOrgnSetQuery setIncludeSelf(Boolean includeSelf) {
        this.includeSelf = includeSelf;
        return this;
    }

    public ChildOrgnSetQuery setOperatorId(String operatorId) {
        this.operatorId = operatorId;
        return this;
    }

    public ChildOrgnSetQuery setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    public List<Map<String, Object>> queryForMapList() {
        return omOrgnSetService.selectChildOrgnSet(orgnSetId, orgnSetCode, orgnSetCodeList, orgnSetName, orgnSetNameList, orgnSetStatus, orgnSetStatusList, orgnSetRootOnly, recursive, includeSelf, operatorId, operatorName);
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
        return queryForMapList().size();
    }
}