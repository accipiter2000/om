package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmPosiService;
import com.opendynamic.om.vo.Posi;

@Service
public class PosiQuery {
    private OmPosiService omPosiService;

    private String orgnSetId;
    private String orgnSetCode;
    private String posiId;
    private List<String> posiIdList;
    private String posiCode;
    private List<String> posiCodeList;
    private String posiName;
    private List<String> posiNameList;
    private String orgLeaderType;
    private List<String> orgLeaderTypeList;
    private String posiCategory;
    private List<String> posiCategoryList;
    private String posiTag;
    private String posiExtAttr1;
    private List<String> posiExtAttr1List;
    private String posiExtAttr2;
    private List<String> posiExtAttr2List;
    private String posiExtAttr3;
    private List<String> posiExtAttr3List;
    private String posiExtAttr4;
    private List<String> posiExtAttr4List;
    private String posiExtAttr5;
    private List<String> posiExtAttr5List;
    private String posiExtAttr6;
    private List<String> posiExtAttr6List;
    private String posiExtAttr7;
    private List<String> posiExtAttr7List;
    private String posiExtAttr8;
    private List<String> posiExtAttr8List;
    private String posiStatus;
    private List<String> posiStatusList;
    private String dutyId;
    private List<String> dutyIdList;
    private String dutyCode;
    private List<String> dutyCodeList;
    private String dutyName;
    private List<String> dutyNameList;
    private String dutyCategory;
    private List<String> dutyCategoryList;
    private String dutyTag;
    private String dutyExtAttr1;
    private List<String> dutyExtAttr1List;
    private String dutyExtAttr2;
    private List<String> dutyExtAttr2List;
    private String dutyExtAttr3;
    private List<String> dutyExtAttr3List;
    private String dutyExtAttr4;
    private List<String> dutyExtAttr4List;
    private String dutyExtAttr5;
    private List<String> dutyExtAttr5List;
    private String dutyExtAttr6;
    private List<String> dutyExtAttr6List;
    private String dutyExtAttr7;
    private List<String> dutyExtAttr7List;
    private String dutyExtAttr8;
    private List<String> dutyExtAttr8List;
    private String dutyStatus;
    private List<String> dutyStatusList;
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
    private Boolean posiTagUnion;
    private Boolean dutyTagUnion;
    private Boolean orgTagUnion;
    private String withinOrgId;
    private Boolean orgRootOnly;
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

    public PosiQuery setPosiIdList(List<String> posiIdList) {
        this.posiIdList = posiIdList;
        return this;
    }

    public PosiQuery setPosiCode(String posiCode) {
        this.posiCode = posiCode;
        return this;
    }

    public PosiQuery setPosiCodeList(List<String> posiCodeList) {
        this.posiCodeList = posiCodeList;
        return this;
    }

    public PosiQuery setPosiName(String posiName) {
        this.posiName = posiName;
        return this;
    }

    public PosiQuery setPosiNameList(List<String> posiNameList) {
        this.posiNameList = posiNameList;
        return this;
    }

    public PosiQuery setOrgLeaderType(String orgLeaderType) {
        this.orgLeaderType = orgLeaderType;
        return this;
    }

    public PosiQuery setOrgLeaderTypeList(List<String> orgLeaderTypeList) {
        this.orgLeaderTypeList = orgLeaderTypeList;
        return this;
    }

    public PosiQuery setPosiCategory(String posiCategory) {
        this.posiCategory = posiCategory;
        return this;
    }

    public PosiQuery setPosiCategoryList(List<String> posiCategoryList) {
        this.posiCategoryList = posiCategoryList;
        return this;
    }

    public PosiQuery setPosiTag(String posiTag) {
        this.posiTag = posiTag;
        return this;
    }

    public PosiQuery setPosiExtAttr1(String posiExtAttr1) {
        this.posiExtAttr1 = posiExtAttr1;
        return this;
    }

    public PosiQuery setPosiExtAttr1List(List<String> posiExtAttr1List) {
        this.posiExtAttr1List = posiExtAttr1List;
        return this;
    }

    public PosiQuery setPosiExtAttr2(String posiExtAttr2) {
        this.posiExtAttr2 = posiExtAttr2;
        return this;
    }

    public PosiQuery setPosiExtAttr2List(List<String> posiExtAttr2List) {
        this.posiExtAttr2List = posiExtAttr2List;
        return this;
    }

    public PosiQuery setPosiExtAttr3(String posiExtAttr3) {
        this.posiExtAttr3 = posiExtAttr3;
        return this;
    }

    public PosiQuery setPosiExtAttr3List(List<String> posiExtAttr3List) {
        this.posiExtAttr3List = posiExtAttr3List;
        return this;
    }

    public PosiQuery setPosiExtAttr4(String posiExtAttr4) {
        this.posiExtAttr4 = posiExtAttr4;
        return this;
    }

    public PosiQuery setPosiExtAttr4List(List<String> posiExtAttr4List) {
        this.posiExtAttr4List = posiExtAttr4List;
        return this;
    }

    public PosiQuery setPosiExtAttr5(String posiExtAttr5) {
        this.posiExtAttr5 = posiExtAttr5;
        return this;
    }

    public PosiQuery setPosiExtAttr5List(List<String> posiExtAttr5List) {
        this.posiExtAttr5List = posiExtAttr5List;
        return this;
    }

    public PosiQuery setPosiExtAttr6(String posiExtAttr6) {
        this.posiExtAttr6 = posiExtAttr6;
        return this;
    }

    public PosiQuery setPosiExtAttr6List(List<String> posiExtAttr6List) {
        this.posiExtAttr6List = posiExtAttr6List;
        return this;
    }

    public PosiQuery setPosiExtAttr7(String posiExtAttr7) {
        this.posiExtAttr7 = posiExtAttr7;
        return this;
    }

    public PosiQuery setPosiExtAttr7List(List<String> posiExtAttr7List) {
        this.posiExtAttr7List = posiExtAttr7List;
        return this;
    }

    public PosiQuery setPosiExtAttr8(String posiExtAttr8) {
        this.posiExtAttr8 = posiExtAttr8;
        return this;
    }

    public PosiQuery setPosiExtAttr8List(List<String> posiExtAttr8List) {
        this.posiExtAttr8List = posiExtAttr8List;
        return this;
    }

    public PosiQuery setPosiStatus(String posiStatus) {
        this.posiStatus = posiStatus;
        return this;
    }

    public PosiQuery setPosiStatusList(List<String> posiStatusList) {
        this.posiStatusList = posiStatusList;
        return this;
    }

    public PosiQuery setDutyId(String dutyId) {
        this.dutyId = dutyId;
        return this;
    }

    public PosiQuery setDutyIdList(List<String> dutyIdList) {
        this.dutyIdList = dutyIdList;
        return this;
    }

    public PosiQuery setDutyCode(String dutyCode) {
        this.dutyCode = dutyCode;
        return this;
    }

    public PosiQuery setDutyCodeList(List<String> dutyCodeList) {
        this.dutyCodeList = dutyCodeList;
        return this;
    }

    public PosiQuery setDutyName(String dutyName) {
        this.dutyName = dutyName;
        return this;
    }

    public PosiQuery setDutyNameList(List<String> dutyNameList) {
        this.dutyNameList = dutyNameList;
        return this;
    }

    public PosiQuery setDutyCategory(String dutyCategory) {
        this.dutyCategory = dutyCategory;
        return this;
    }

    public PosiQuery setDutyCategoryList(List<String> dutyCategoryList) {
        this.dutyCategoryList = dutyCategoryList;
        return this;
    }

    public PosiQuery setDutyTag(String dutyTag) {
        this.dutyTag = dutyTag;
        return this;
    }

    public PosiQuery setDutyExtAttr1(String dutyExtAttr1) {
        this.dutyExtAttr1 = dutyExtAttr1;
        return this;
    }

    public PosiQuery setDutyExtAttr1List(List<String> dutyExtAttr1List) {
        this.dutyExtAttr1List = dutyExtAttr1List;
        return this;
    }

    public PosiQuery setDutyExtAttr2(String dutyExtAttr2) {
        this.dutyExtAttr2 = dutyExtAttr2;
        return this;
    }

    public PosiQuery setDutyExtAttr2List(List<String> dutyExtAttr2List) {
        this.dutyExtAttr2List = dutyExtAttr2List;
        return this;
    }

    public PosiQuery setDutyExtAttr3(String dutyExtAttr3) {
        this.dutyExtAttr3 = dutyExtAttr3;
        return this;
    }

    public PosiQuery setDutyExtAttr3List(List<String> dutyExtAttr3List) {
        this.dutyExtAttr3List = dutyExtAttr3List;
        return this;
    }

    public PosiQuery setDutyExtAttr4(String dutyExtAttr4) {
        this.dutyExtAttr4 = dutyExtAttr4;
        return this;
    }

    public PosiQuery setDutyExtAttr4List(List<String> dutyExtAttr4List) {
        this.dutyExtAttr4List = dutyExtAttr4List;
        return this;
    }

    public PosiQuery setDutyExtAttr5(String dutyExtAttr5) {
        this.dutyExtAttr5 = dutyExtAttr5;
        return this;
    }

    public PosiQuery setDutyExtAttr5List(List<String> dutyExtAttr5List) {
        this.dutyExtAttr5List = dutyExtAttr5List;
        return this;
    }

    public PosiQuery setDutyExtAttr6(String dutyExtAttr6) {
        this.dutyExtAttr6 = dutyExtAttr6;
        return this;
    }

    public PosiQuery setDutyExtAttr6List(List<String> dutyExtAttr6List) {
        this.dutyExtAttr6List = dutyExtAttr6List;
        return this;
    }

    public PosiQuery setDutyExtAttr7(String dutyExtAttr7) {
        this.dutyExtAttr7 = dutyExtAttr7;
        return this;
    }

    public PosiQuery setDutyExtAttr7List(List<String> dutyExtAttr7List) {
        this.dutyExtAttr7List = dutyExtAttr7List;
        return this;
    }

    public PosiQuery setDutyExtAttr8(String dutyExtAttr8) {
        this.dutyExtAttr8 = dutyExtAttr8;
        return this;
    }

    public PosiQuery setDutyExtAttr8List(List<String> dutyExtAttr8List) {
        this.dutyExtAttr8List = dutyExtAttr8List;
        return this;
    }

    public PosiQuery setDutyStatus(String dutyStatus) {
        this.dutyStatus = dutyStatus;
        return this;
    }

    public PosiQuery setDutyStatusList(List<String> dutyStatusList) {
        this.dutyStatusList = dutyStatusList;
        return this;
    }

    public PosiQuery setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public PosiQuery setOrgIdList(List<String> orgIdList) {
        this.orgIdList = orgIdList;
        return this;
    }

    public PosiQuery setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
        return this;
    }

    public PosiQuery setParentOrgIdList(List<String> parentOrgIdList) {
        this.parentOrgIdList = parentOrgIdList;
        return this;
    }

    public PosiQuery setOrgCode(String orgCode) {
        this.orgCode = orgCode;
        return this;
    }

    public PosiQuery setOrgCodeList(List<String> orgCodeList) {
        this.orgCodeList = orgCodeList;
        return this;
    }

    public PosiQuery setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public PosiQuery setOrgNameList(List<String> orgNameList) {
        this.orgNameList = orgNameList;
        return this;
    }

    public PosiQuery setOrgType(String orgType) {
        this.orgType = orgType;
        return this;
    }

    public PosiQuery setOrgTypeList(List<String> orgTypeList) {
        this.orgTypeList = orgTypeList;
        return this;
    }

    public PosiQuery setOrgCategory(String orgCategory) {
        this.orgCategory = orgCategory;
        return this;
    }

    public PosiQuery setOrgCategoryList(List<String> orgCategoryList) {
        this.orgCategoryList = orgCategoryList;
        return this;
    }

    public PosiQuery setOrgTag(String orgTag) {
        this.orgTag = orgTag;
        return this;
    }

    public PosiQuery setOrgExtAttr1(String orgExtAttr1) {
        this.orgExtAttr1 = orgExtAttr1;
        return this;
    }

    public PosiQuery setOrgExtAttr1List(List<String> orgExtAttr1List) {
        this.orgExtAttr1List = orgExtAttr1List;
        return this;
    }

    public PosiQuery setOrgExtAttr2(String orgExtAttr2) {
        this.orgExtAttr2 = orgExtAttr2;
        return this;
    }

    public PosiQuery setOrgExtAttr2List(List<String> orgExtAttr2List) {
        this.orgExtAttr2List = orgExtAttr2List;
        return this;
    }

    public PosiQuery setOrgExtAttr3(String orgExtAttr3) {
        this.orgExtAttr3 = orgExtAttr3;
        return this;
    }

    public PosiQuery setOrgExtAttr3List(List<String> orgExtAttr3List) {
        this.orgExtAttr3List = orgExtAttr3List;
        return this;
    }

    public PosiQuery setOrgExtAttr4(String orgExtAttr4) {
        this.orgExtAttr4 = orgExtAttr4;
        return this;
    }

    public PosiQuery setOrgExtAttr4List(List<String> orgExtAttr4List) {
        this.orgExtAttr4List = orgExtAttr4List;
        return this;
    }

    public PosiQuery setOrgExtAttr5(String orgExtAttr5) {
        this.orgExtAttr5 = orgExtAttr5;
        return this;
    }

    public PosiQuery setOrgExtAttr5List(List<String> orgExtAttr5List) {
        this.orgExtAttr5List = orgExtAttr5List;
        return this;
    }

    public PosiQuery setOrgExtAttr6(String orgExtAttr6) {
        this.orgExtAttr6 = orgExtAttr6;
        return this;
    }

    public PosiQuery setOrgExtAttr6List(List<String> orgExtAttr6List) {
        this.orgExtAttr6List = orgExtAttr6List;
        return this;
    }

    public PosiQuery setOrgExtAttr7(String orgExtAttr7) {
        this.orgExtAttr7 = orgExtAttr7;
        return this;
    }

    public PosiQuery setOrgExtAttr7List(List<String> orgExtAttr7List) {
        this.orgExtAttr7List = orgExtAttr7List;
        return this;
    }

    public PosiQuery setOrgExtAttr8(String orgExtAttr8) {
        this.orgExtAttr8 = orgExtAttr8;
        return this;
    }

    public PosiQuery setOrgExtAttr8List(List<String> orgExtAttr8List) {
        this.orgExtAttr8List = orgExtAttr8List;
        return this;
    }

    public PosiQuery setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus;
        return this;
    }

    public PosiQuery setOrgStatusList(List<String> orgStatusList) {
        this.orgStatusList = orgStatusList;
        return this;
    }

    public PosiQuery setPosiTagUnion(Boolean posiTagUnion) {
        this.posiTagUnion = posiTagUnion;
        return this;
    }

    public PosiQuery setDutyTagUnion(Boolean dutyTagUnion) {
        this.dutyTagUnion = dutyTagUnion;
        return this;
    }

    public PosiQuery setOrgTagUnion(Boolean orgTagUnion) {
        this.orgTagUnion = orgTagUnion;
        return this;
    }

    public PosiQuery setWithinOrgId(String withinOrgId) {
        this.withinOrgId = withinOrgId;
        return this;
    }

    public PosiQuery setOrgRootOnly(Boolean orgRootOnly) {
        this.orgRootOnly = orgRootOnly;
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
        return omPosiService.selectPosi(orgnSetId, orgnSetCode, posiId, posiIdList, posiCode, posiCodeList, posiName, posiNameList, orgLeaderType, orgLeaderTypeList, posiCategory, posiCategoryList, posiTag, posiExtAttr1, posiExtAttr1List, posiExtAttr2, posiExtAttr2List, posiExtAttr3, posiExtAttr3List, posiExtAttr4, posiExtAttr4List, posiExtAttr5, posiExtAttr5List, posiExtAttr6, posiExtAttr6List, posiExtAttr7, posiExtAttr7List, posiExtAttr8, posiExtAttr8List, posiStatus, posiStatusList, dutyId, dutyIdList, dutyCode, dutyCodeList, dutyName, dutyNameList, dutyCategory, dutyCategoryList, dutyTag, dutyExtAttr1, dutyExtAttr1List, dutyExtAttr2, dutyExtAttr2List, dutyExtAttr3, dutyExtAttr3List, dutyExtAttr4, dutyExtAttr4List, dutyExtAttr5, dutyExtAttr5List, dutyExtAttr6, dutyExtAttr6List,
                dutyExtAttr7, dutyExtAttr7List, dutyExtAttr8, dutyExtAttr8List, dutyStatus, dutyStatusList, orgId, orgIdList, parentOrgId, parentOrgIdList, orgCode, orgCodeList, orgName, orgNameList, orgType, orgTypeList, orgCategory, orgCategoryList, orgTag, orgExtAttr1, orgExtAttr1List, orgExtAttr2, orgExtAttr2List, orgExtAttr3, orgExtAttr3List, orgExtAttr4, orgExtAttr4List, orgExtAttr5, orgExtAttr5List, orgExtAttr6, orgExtAttr6List, orgExtAttr7, orgExtAttr7List, orgExtAttr8, orgExtAttr8List, orgStatus, orgStatusList, posiTagUnion, dutyTagUnion, orgTagUnion, withinOrgId, orgRootOnly, page, limit, operatorId, operatorName);
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
        return omPosiService.countPosi(orgnSetId, orgnSetCode, posiId, posiIdList, posiCode, posiCodeList, posiName, posiNameList, orgLeaderType, orgLeaderTypeList, posiCategory, posiCategoryList, posiTag, posiExtAttr1, posiExtAttr1List, posiExtAttr2, posiExtAttr2List, posiExtAttr3, posiExtAttr3List, posiExtAttr4, posiExtAttr4List, posiExtAttr5, posiExtAttr5List, posiExtAttr6, posiExtAttr6List, posiExtAttr7, posiExtAttr7List, posiExtAttr8, posiExtAttr8List, posiStatus, posiStatusList, dutyId, dutyIdList, dutyCode, dutyCodeList, dutyName, dutyNameList, dutyCategory, dutyCategoryList, dutyTag, dutyExtAttr1, dutyExtAttr1List, dutyExtAttr2, dutyExtAttr2List, dutyExtAttr3, dutyExtAttr3List, dutyExtAttr4, dutyExtAttr4List, dutyExtAttr5, dutyExtAttr5List, dutyExtAttr6, dutyExtAttr6List,
                dutyExtAttr7, dutyExtAttr7List, dutyExtAttr8, dutyExtAttr8List, dutyStatus, dutyStatusList, orgId, orgIdList, parentOrgId, parentOrgIdList, orgCode, orgCodeList, orgName, orgNameList, orgType, orgTypeList, orgCategory, orgCategoryList, orgTag, orgExtAttr1, orgExtAttr1List, orgExtAttr2, orgExtAttr2List, orgExtAttr3, orgExtAttr3List, orgExtAttr4, orgExtAttr4List, orgExtAttr5, orgExtAttr5List, orgExtAttr6, orgExtAttr6List, orgExtAttr7, orgExtAttr7List, orgExtAttr8, orgExtAttr8List, orgStatus, orgStatusList, posiTagUnion, dutyTagUnion, orgTagUnion, withinOrgId, orgRootOnly, operatorId, operatorName);
    }
}