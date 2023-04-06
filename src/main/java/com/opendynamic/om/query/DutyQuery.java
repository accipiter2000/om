package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmDutyService;
import com.opendynamic.om.vo.OrgnSet;

@Service
public class DutyQuery {
    private OmDutyService omDutyService;

    private String orgnSetId;
    private String orgnSetCode;
    private String dutyId;
    private String dutyCode;
    private String dutyName;
    private List<String> categoryList;
    private String dutyTag;
    private List<String> dutyStatusList;
    private Boolean tagUnion;
    private Integer page;
    private Integer limit;
    private String operatorId;
    private String operatorName;

    public DutyQuery(OmDutyService omDutyService) {
        super();
        this.omDutyService = omDutyService;
    }

    public DutyQuery setOrgnSetId(String orgnSetId) {
        this.orgnSetId = orgnSetId;
        return this;
    }

    public DutyQuery setOrgnSetCode(String orgnSetCode) {
        this.orgnSetCode = orgnSetCode;
        return this;
    }

    public DutyQuery setDutyId(String dutyId) {
        this.dutyId = dutyId;
        return this;
    }

    public DutyQuery setDutyCode(String dutyCode) {
        this.dutyCode = dutyCode;
        return this;
    }

    public DutyQuery setDutyName(String dutyName) {
        this.dutyName = dutyName;
        return this;
    }

    public DutyQuery setCategory(String category) {
        if (StringUtils.isNotEmpty(category)) {
            this.categoryList = new ArrayList<>();
            this.categoryList.add(category);
        }
        return this;
    }

    public DutyQuery setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
        return this;
    }

    public DutyQuery setDutyTag(String dutyTag) {
        this.dutyTag = dutyTag;
        return this;
    }

    public DutyQuery setDutyStatus(String dutyStatus) {
        if (StringUtils.isNotEmpty(dutyStatus)) {
            this.dutyStatusList = new ArrayList<>();
            this.dutyStatusList.add(dutyStatus);
        }
        return this;
    }

    public DutyQuery setDutyStatusList(List<String> dutyStatusList) {
        this.dutyStatusList = dutyStatusList;
        return this;
    }

    public DutyQuery setTagUnion(Boolean tagUnion) {
        this.tagUnion = tagUnion;
        return this;
    }

    public DutyQuery setPage(Integer page) {
        this.page = page;
        return this;
    }

    public DutyQuery setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public DutyQuery setOperatorId(String operatorId) {
        this.operatorId = operatorId;
        return this;
    }

    public DutyQuery setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    public List<Map<String, Object>> queryForMapList() {
        return omDutyService.selectDuty(orgnSetId, orgnSetCode, dutyId, dutyCode, dutyName, categoryList, dutyTag, dutyStatusList, tagUnion, page, limit, operatorId, operatorName);
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
        return omDutyService.countDuty(orgnSetId, orgnSetCode, dutyId, dutyCode, dutyName, categoryList, dutyTag, dutyStatusList, tagUnion, operatorId, operatorName);
    }
}