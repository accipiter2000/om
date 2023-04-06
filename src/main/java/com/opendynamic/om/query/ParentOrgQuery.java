package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmOrgService;
import com.opendynamic.om.vo.Org;

@Service
public class ParentOrgQuery {
    private OmOrgService omOrgService;

    private String orgnSetId;
    private String orgnSetCode;
    private String orgId;
    private String orgCode;
    private String orgName;
    private List<String> orgTypeList;
    private List<String> categoryList;
    private String orgTag;
    private String extAttr1;
    private String extAttr2;
    private String extAttr3;
    private String extAttr4;
    private String extAttr5;
    private String extAttr6;
    private String extAttr7;
    private String extAttr8;
    private List<String> orgStatusList;
    private Boolean tagUnion;
    private String withinOrgId;
    private Boolean includeSelf;
    private Boolean recursive;
    private String operatorId;
    private String operatorName;

    public ParentOrgQuery(OmOrgService omOrgService) {
        super();
        this.omOrgService = omOrgService;
    }

    public ParentOrgQuery setOrgnSetId(String orgnSetId) {
        this.orgnSetId = orgnSetId;
        return this;
    }

    public ParentOrgQuery setOrgnSetCode(String orgnSetCode) {
        this.orgnSetCode = orgnSetCode;
        return this;
    }

    public ParentOrgQuery setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public ParentOrgQuery setOrgCode(String orgCode) {
        this.orgCode = orgCode;
        return this;
    }

    public ParentOrgQuery setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public ParentOrgQuery setOrgType(String orgType) {
        if (StringUtils.isNotEmpty(orgType)) {
            this.orgTypeList = new ArrayList<>();
            this.orgTypeList.add(orgType);
        }
        return this;
    }

    public ParentOrgQuery setOrgTypeList(List<String> orgTypeList) {
        this.orgTypeList = orgTypeList;
        return this;
    }

    public ParentOrgQuery setCategory(String category) {
        if (StringUtils.isNotEmpty(category)) {
            this.categoryList = new ArrayList<>();
            this.categoryList.add(category);
        }
        return this;
    }

    public ParentOrgQuery setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
        return this;
    }

    public ParentOrgQuery setOrgTag(String orgTag) {
        this.orgTag = orgTag;
        return this;
    }

    public ParentOrgQuery setExtAttr1(String extAttr1) {
        this.extAttr1 = extAttr1;
        return this;
    }

    public ParentOrgQuery setExtAttr2(String extAttr2) {
        this.extAttr2 = extAttr2;
        return this;
    }

    public ParentOrgQuery setExtAttr3(String extAttr3) {
        this.extAttr3 = extAttr3;
        return this;
    }

    public ParentOrgQuery setExtAttr4(String extAttr4) {
        this.extAttr4 = extAttr4;
        return this;
    }

    public ParentOrgQuery setExtAttr5(String extAttr5) {
        this.extAttr5 = extAttr5;
        return this;
    }

    public ParentOrgQuery setExtAttr6(String extAttr6) {
        this.extAttr6 = extAttr6;
        return this;
    }

    public ParentOrgQuery setExtAttr7(String extAttr7) {
        this.extAttr7 = extAttr7;
        return this;
    }

    public ParentOrgQuery setExtAttr8(String extAttr8) {
        this.extAttr8 = extAttr8;
        return this;
    }

    public ParentOrgQuery setOrgStatus(String orgStatus) {
        if (StringUtils.isNotEmpty(orgStatus)) {
            this.orgStatusList = new ArrayList<>();
            this.orgStatusList.add(orgStatus);
        }
        return this;
    }

    public ParentOrgQuery setOrgStatusList(List<String> orgStatusList) {
        this.orgStatusList = orgStatusList;
        return this;
    }

    public ParentOrgQuery setTagUnion(Boolean tagUnion) {
        this.tagUnion = tagUnion;
        return this;
    }

    public ParentOrgQuery setWithinOrgId(String withinOrgId) {
        this.withinOrgId = withinOrgId;
        return this;
    }

    public ParentOrgQuery setIncludeSelf(Boolean includeSelf) {
        this.includeSelf = includeSelf;
        return this;
    }

    public ParentOrgQuery setRecursive(Boolean recursive) {
        this.recursive = recursive;
        return this;
    }

    public ParentOrgQuery setOperatorId(String operatorId) {
        this.operatorId = operatorId;
        return this;
    }

    public ParentOrgQuery setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    public List<Map<String, Object>> queryForMapList() {
        return omOrgService.selectParentOrg(orgnSetId, orgnSetCode, orgId, orgCode, orgName, orgTypeList, categoryList, orgTag, extAttr1, extAttr2, extAttr3, extAttr4, extAttr5, extAttr6, extAttr7, extAttr8, orgStatusList, tagUnion, withinOrgId, includeSelf, recursive, operatorId, operatorName);
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

    public List<Org> queryForObjectList() {
        List<Map<String, Object>> result = queryForMapList();
        List<Org> orgList = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            orgList.add(new Org(result.get(i)));
        }

        return orgList;
    }

    public Org queryForObject() {
        List<Map<String, Object>> result = queryForMapList();
        if (result.size() == 1) {
            return new Org(result.get(0));
        }
        else {
            return null;
        }
    }

    public int count() {
        return queryForMapList().size();
    }
}