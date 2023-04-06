package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmOrgnSetService;
import com.opendynamic.om.vo.OrgnSet;

@Service
public class ParentOrgnSetQuery {
    private OmOrgnSetService omOrgnSetService;

    private String orgnSetId;
    private String orgnSetCode;
    private String orgnSetName;
    private List<String> orgnSetStatusList;
    private Boolean includeSelf;
    private Boolean recursive;
    private String operatorId;
    private String operatorName;

    public ParentOrgnSetQuery(OmOrgnSetService omOrgnSetService) {
        super();
        this.omOrgnSetService = omOrgnSetService;
    }

    public ParentOrgnSetQuery setOrgnSetId(String orgnSetId) {
        this.orgnSetId = orgnSetId;
        return this;
    }

    public ParentOrgnSetQuery setOrgnSetCode(String orgnSetCode) {
        this.orgnSetCode = orgnSetCode;
        return this;
    }

    public ParentOrgnSetQuery setOrgnSetName(String orgnSetName) {
        this.orgnSetName = orgnSetName;
        return this;
    }

    public ParentOrgnSetQuery setOrgnSetStatus(String orgnSetStatus) {
        if (StringUtils.isNotEmpty(orgnSetStatus)) {
            this.orgnSetStatusList = new ArrayList<>();
            this.orgnSetStatusList.add(orgnSetStatus);
        }
        return this;
    }

    public ParentOrgnSetQuery setOrgnSetStatusList(List<String> orgnSetStatusList) {
        this.orgnSetStatusList = orgnSetStatusList;
        return this;
    }

    public ParentOrgnSetQuery setIncludeSelf(Boolean includeSelf) {
        this.includeSelf = includeSelf;
        return this;
    }

    public ParentOrgnSetQuery setRecursive(Boolean recursive) {
        this.recursive = recursive;
        return this;
    }

    public ParentOrgnSetQuery setOperatorId(String operatorId) {
        this.operatorId = operatorId;
        return this;
    }

    public ParentOrgnSetQuery setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    public List<Map<String, Object>> queryForMapList() {
        return omOrgnSetService.selectParentOrgnSet(orgnSetId, orgnSetCode, orgnSetName, orgnSetStatusList, includeSelf, recursive, operatorId, operatorName);
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