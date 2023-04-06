package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmPosiService;
import com.opendynamic.om.vo.Posi;

@Service
public class PosiQuery {
    private OmPosiService omPosiService;

    private String orgnSetId;
    private String orgnSetCode;
    private String posiId;
    private String orgId;
    private String dutyId;
    private String posiCode;
    private String posiName;
    private List<String> dutyLevelList;
    private List<String> categoryList;
    private String posiTag;
    private List<String> posiStatusList;
    private Boolean tagUnion;
    private String withinOrgId;
    private Integer page;
    private Integer limit;
    private String operatorId;
    private String operatorName;

    public PosiQuery(OmPosiService omPosiService) {
        super();
        this.omPosiService = omPosiService;
    }

    public PosiQuery setOrgnSetId(String orgnSetId) {
        this.orgnSetId = orgnSetId;
        return this;
    }

    public PosiQuery setOrgnSetCode(String orgnSetCode) {
        this.orgnSetCode = orgnSetCode;
        return this;
    }

    public PosiQuery setPosiId(String posiId) {
        this.posiId = posiId;
        return this;
    }

    public PosiQuery setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public PosiQuery setDutyId(String dutyId) {
        this.dutyId = dutyId;
        return this;
    }

    public PosiQuery setPosiCode(String posiCode) {
        this.posiCode = posiCode;
        return this;
    }

    public PosiQuery setPosiName(String posiName) {
        this.posiName = posiName;
        return this;
    }

    public PosiQuery setDutyLevel(String dutyLevel) {
        if (StringUtils.isNotEmpty(dutyLevel)) {
            this.dutyLevelList = new ArrayList<>();
            this.dutyLevelList.add(dutyLevel);
        }
        return this;
    }

    public PosiQuery setDutyLevelList(List<String> dutyLevelList) {
        this.dutyLevelList = dutyLevelList;
        return this;
    }

    public PosiQuery setCategory(String category) {
        if (StringUtils.isNotEmpty(category)) {
            this.categoryList = new ArrayList<>();
            this.categoryList.add(category);
        }
        return this;
    }

    public PosiQuery setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
        return this;
    }

    public PosiQuery setPosiTag(String posiTag) {
        this.posiTag = posiTag;
        return this;
    }

    public PosiQuery setPosiStatus(String posiStatus) {
        if (StringUtils.isNotEmpty(posiStatus)) {
            this.posiStatusList = new ArrayList<>();
            this.posiStatusList.add(posiStatus);
        }
        return this;
    }

    public PosiQuery setPosiStatusList(List<String> posiStatusList) {
        this.posiStatusList = posiStatusList;
        return this;
    }

    public PosiQuery setTagUnion(Boolean tagUnion) {
        this.tagUnion = tagUnion;
        return this;
    }

    public PosiQuery setWithinOrgId(String withinOrgId) {
        this.withinOrgId = withinOrgId;
        return this;
    }

    public PosiQuery setPage(Integer page) {
        this.page = page;
        return this;
    }

    public PosiQuery setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public PosiQuery setOperatorId(String operatorId) {
        this.operatorId = operatorId;
        return this;
    }

    public PosiQuery setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    public List<Map<String, Object>> queryForMapList() {
        return omPosiService.selectPosi(orgnSetId, orgnSetCode, posiId, orgId, dutyId, posiCode, posiName, dutyLevelList, categoryList, posiTag, posiStatusList, tagUnion, withinOrgId, page, limit, operatorId, operatorName);
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

    public List<Posi> queryForObjectList() {
        List<Map<String, Object>> result = queryForMapList();
        List<Posi> posiList = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            posiList.add(new Posi(result.get(i)));
        }

        return posiList;
    }

    public Posi queryForObject() {
        List<Map<String, Object>> result = queryForMapList();
        if (result.size() == 1) {
            return new Posi(result.get(0));
        }
        else {
            return null;
        }
    }

    public int count() {
        return omPosiService.countPosi(orgnSetId, orgnSetCode, posiId, orgId, dutyId, posiCode, posiName, dutyLevelList, categoryList, posiTag, posiStatusList, tagUnion, withinOrgId, operatorId, operatorName);
    }
}