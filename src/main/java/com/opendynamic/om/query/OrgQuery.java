package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmOrgService;
import com.opendynamic.om.vo.Org;

@Service
public class OrgQuery {
    private OmOrgService omOrgService;

    private String orgnSetId;
    private String orgnSetCode;
    private String orgId;
    private List<String> orgIdList;
    private String parentOrgId;
    private List<String> parentOrgIdList;
    private String orgCode;
    private List<String> orgCodeList;
    private String orgName;
    private List<String> orgNameList;
    private String orgType;
    private List<String> orgTypeList;
    private String orgCategory;
    private List<String> orgCategoryList;
    private String orgTag;
    private String orgExtAttr1;
    private List<String> orgExtAttr1List;
    private String orgExtAttr2;
    private List<String> orgExtAttr2List;
    private String orgExtAttr3;
    private List<String> orgExtAttr3List;
    private String orgExtAttr4;
    private List<String> orgExtAttr4List;
    private String orgExtAttr5;
    private List<String> orgExtAttr5List;
    private String orgExtAttr6;
    private List<String> orgExtAttr6List;
    private String orgExtAttr7;
    private List<String> orgExtAttr7List;
    private String orgExtAttr8;
    private List<String> orgExtAttr8List;
    private String orgStatus;
    private List<String> orgStatusList;
    private Boolean orgTagUnion;
    private String withinOrgId;
    private Boolean orgRootOnly;
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

    public OrgQuery setOrgIdList(List<String> orgIdList) {
        this.orgIdList = orgIdList;
        return this;
    }

    public OrgQuery setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
        return this;
    }

    public OrgQuery setParentOrgIdList(List<String> parentOrgIdList) {
        this.parentOrgIdList = parentOrgIdList;
        return this;
    }

    public OrgQuery setOrgCode(String orgCode) {
        this.orgCode = orgCode;
        return this;
    }

    public OrgQuery setOrgCodeList(List<String> orgCodeList) {
        this.orgCodeList = orgCodeList;
        return this;
    }

    public OrgQuery setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public OrgQuery setOrgNameList(List<String> orgNameList) {
        this.orgNameList = orgNameList;
        return this;
    }

    public OrgQuery setOrgType(String orgType) {
        this.orgType = orgType;
        return this;
    }

    public OrgQuery setOrgTypeList(List<String> orgTypeList) {
        this.orgTypeList = orgTypeList;
        return this;
    }

    public OrgQuery setOrgCategory(String orgCategory) {
        this.orgCategory = orgCategory;
        return this;
    }

    public OrgQuery setOrgCategoryList(List<String> orgCategoryList) {
        this.orgCategoryList = orgCategoryList;
        return this;
    }

    public OrgQuery setOrgTag(String orgTag) {
        this.orgTag = orgTag;
        return this;
    }

    public OrgQuery setOrgExtAttr1(String orgExtAttr1) {
        this.orgExtAttr1 = orgExtAttr1;
        return this;
    }

    public OrgQuery setOrgExtAttr1List(List<String> orgExtAttr1List) {
        this.orgExtAttr1List = orgExtAttr1List;
        return this;
    }

    public OrgQuery setOrgExtAttr2(String orgExtAttr2) {
        this.orgExtAttr2 = orgExtAttr2;
        return this;
    }

    public OrgQuery setOrgExtAttr2List(List<String> orgExtAttr2List) {
        this.orgExtAttr2List = orgExtAttr2List;
        return this;
    }

    public OrgQuery setOrgExtAttr3(String orgExtAttr3) {
        this.orgExtAttr3 = orgExtAttr3;
        return this;
    }

    public OrgQuery setOrgExtAttr3List(List<String> orgExtAttr3List) {
        this.orgExtAttr3List = orgExtAttr3List;
        return this;
    }

    public OrgQuery setOrgExtAttr4(String orgExtAttr4) {
        this.orgExtAttr4 = orgExtAttr4;
        return this;
    }

    public OrgQuery setOrgExtAttr4List(List<String> orgExtAttr4List) {
        this.orgExtAttr4List = orgExtAttr4List;
        return this;
    }

    public OrgQuery setOrgExtAttr5(String orgExtAttr5) {
        this.orgExtAttr5 = orgExtAttr5;
        return this;
    }

    public OrgQuery setOrgExtAttr5List(List<String> orgExtAttr5List) {
        this.orgExtAttr5List = orgExtAttr5List;
        return this;
    }

    public OrgQuery setOrgExtAttr6(String orgExtAttr6) {
        this.orgExtAttr6 = orgExtAttr6;
        return this;
    }

    public OrgQuery setOrgExtAttr6List(List<String> orgExtAttr6List) {
        this.orgExtAttr6List = orgExtAttr6List;
        return this;
    }

    public OrgQuery setOrgExtAttr7(String orgExtAttr7) {
        this.orgExtAttr7 = orgExtAttr7;
        return this;
    }

    public OrgQuery setOrgExtAttr7List(List<String> orgExtAttr7List) {
        this.orgExtAttr7List = orgExtAttr7List;
        return this;
    }

    public OrgQuery setOrgExtAttr8(String orgExtAttr8) {
        this.orgExtAttr8 = orgExtAttr8;
        return this;
    }

    public OrgQuery setOrgExtAttr8List(List<String> orgExtAttr8List) {
        this.orgExtAttr8List = orgExtAttr8List;
        return this;
    }

    public OrgQuery setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus;
        return this;
    }

    public OrgQuery setOrgStatusList(List<String> orgStatusList) {
        this.orgStatusList = orgStatusList;
        return this;
    }

    public OrgQuery setOrgTagUnion(Boolean orgTagUnion) {
        this.orgTagUnion = orgTagUnion;
        return this;
    }

    public OrgQuery setWithinOrgId(String withinOrgId) {
        this.withinOrgId = withinOrgId;
        return this;
    }

    public OrgQuery setOrgRootOnly(Boolean orgRootOnly) {
        this.orgRootOnly = orgRootOnly;
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
        return omOrgService.selectOrg(orgnSetId, orgnSetCode, orgId, orgIdList, parentOrgId, parentOrgIdList, orgCode, orgCodeList, orgName, orgNameList, orgType, orgTypeList, orgCategory, orgCategoryList, orgTag, orgExtAttr1, orgExtAttr1List, orgExtAttr2, orgExtAttr2List, orgExtAttr3, orgExtAttr3List, orgExtAttr4, orgExtAttr4List, orgExtAttr5, orgExtAttr5List, orgExtAttr6, orgExtAttr6List, orgExtAttr7, orgExtAttr7List, orgExtAttr8, orgExtAttr8List, orgStatus, orgStatusList, orgTagUnion, withinOrgId, orgRootOnly, page, limit, operatorId, operatorName);
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
        return omOrgService.countOrg(orgnSetId, orgnSetCode, orgId, orgIdList, parentOrgId, parentOrgIdList, orgCode, orgCodeList, orgName, orgNameList, orgType, orgTypeList, orgCategory, orgCategoryList, orgTag, orgExtAttr1, orgExtAttr1List, orgExtAttr2, orgExtAttr2List, orgExtAttr3, orgExtAttr3List, orgExtAttr4, orgExtAttr4List, orgExtAttr5, orgExtAttr5List, orgExtAttr6, orgExtAttr6List, orgExtAttr7, orgExtAttr7List, orgExtAttr8, orgExtAttr8List, orgStatus, orgStatusList, orgTagUnion, withinOrgId, orgRootOnly, operatorId, operatorName);
    }
}