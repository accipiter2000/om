package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmOrgService;
import com.opendynamic.om.vo.Org;

@Service
public class OrgQuery {
    private OmOrgService omOrgService;

    private String orgnSetId;
    private String orgnSetCode;
    private String orgId;
    private String parentOrgId;
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
    private Boolean rootOnly;
    private String withinOrgId;
    private Integer page;
    private Integer limit;
    private String operatorId;
    private String operatorName;

    public OrgQuery(OmOrgService omOrgService) {
        super();
        this.omOrgService = omOrgService;
    }

    public OrgQuery setOrgnSetId(String orgnSetId) {
        this.orgnSetId = orgnSetId;
        return this;
    }

    public OrgQuery setOrgnSetCode(String orgnSetCode) {
        this.orgnSetCode = orgnSetCode;
        return this;
    }

    public OrgQuery setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public OrgQuery setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
        return this;
    }

    public OrgQuery setOrgCode(String orgCode) {
        this.orgCode = orgCode;
        return this;
    }

    public OrgQuery setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public OrgQuery setOrgType(String orgType) {
        if (StringUtils.isNotEmpty(orgType)) {
            this.orgTypeList = new ArrayList<>();
            this.orgTypeList.add(orgType);
        }
        return this;
    }

    public OrgQuery setOrgTypeList(List<String> orgTypeList) {
        this.orgTypeList = orgTypeList;
        return this;
    }

    public OrgQuery setCategory(String category) {
        if (StringUtils.isNotEmpty(category)) {
            this.categoryList = new ArrayList<>();
            this.categoryList.add(category);
        }
        return this;
    }

    public OrgQuery setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
        return this;
    }

    public OrgQuery setOrgTag(String orgTag) {
        this.orgTag = orgTag;
        return this;
    }

    public OrgQuery setExtAttr1(String extAttr1) {
        this.extAttr1 = extAttr1;
        return this;
    }

    public OrgQuery setExtAttr2(String extAttr2) {
        this.extAttr2 = extAttr2;
        return this;
    }

    public OrgQuery setExtAttr3(String extAttr3) {
        this.extAttr3 = extAttr3;
        return this;
    }

    public OrgQuery setExtAttr4(String extAttr4) {
        this.extAttr4 = extAttr4;
        return this;
    }

    public OrgQuery setExtAttr5(String extAttr5) {
        this.extAttr5 = extAttr5;
        return this;
    }

    public OrgQuery setExtAttr6(String extAttr6) {
        this.extAttr6 = extAttr6;
        return this;
    }

    public OrgQuery setExtAttr7(String extAttr7) {
        this.extAttr7 = extAttr7;
        return this;
    }

    public OrgQuery setExtAttr8(String extAttr8) {
        this.extAttr8 = extAttr8;
        return this;
    }

    public OrgQuery setOrgStatus(String orgStatus) {
        if (StringUtils.isNotEmpty(orgStatus)) {
            this.orgStatusList = new ArrayList<>();
            this.orgStatusList.add(orgStatus);
        }
        return this;
    }

    public OrgQuery setOrgStatusList(List<String> orgStatusList) {
        this.orgStatusList = orgStatusList;
        return this;
    }

    public OrgQuery setTagUnion(Boolean tagUnion) {
        this.tagUnion = tagUnion;
        return this;
    }

    public OrgQuery setRootOnly(Boolean rootOnly) {
        this.rootOnly = rootOnly;
        return this;
    }

    public OrgQuery setWithinOrgId(String withinOrgId) {
        this.withinOrgId = withinOrgId;
        return this;
    }

    public OrgQuery setPage(Integer page) {
        this.page = page;
        return this;
    }

    public OrgQuery setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public OrgQuery setOperatorId(String operatorId) {
        this.operatorId = operatorId;
        return this;
    }

    public OrgQuery setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    public List<Map<String, Object>> queryForMapList() {
        return omOrgService.selectOrg(orgnSetId, orgnSetCode, orgId, parentOrgId, orgCode, orgName, orgTypeList, categoryList, orgTag, extAttr1, extAttr2, extAttr3, extAttr4, extAttr5, extAttr6, extAttr7, extAttr8, orgStatusList, tagUnion, rootOnly, withinOrgId, page, limit, operatorId, operatorName);
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
        return omOrgService.countOrg(orgnSetId, orgnSetCode, orgId, parentOrgId, orgCode, orgName, orgTypeList, categoryList, orgTag, extAttr1, extAttr2, extAttr3, extAttr4, extAttr5, extAttr6, extAttr7, extAttr8, orgStatusList, tagUnion, rootOnly, withinOrgId, operatorId, operatorName);
    }
}