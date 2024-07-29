package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmOrgService;
import com.opendynamic.om.vo.Org;

@Service
public class ParentOrgQuery {
    private OmOrgService omOrgService;

    private String orgnSetId;// 组织架构套ID。
    private String orgnSetCode;// 组织架构套编码。
    private String orgId;// 机构ID。
    private String orgCode;// 机构编码。
    private List<String> orgCodeList;// 机构编码列表。
    private String orgName;// 机构名称。
    private List<String> orgNameList;// 机构名称列表。
    private String orgType;// 机构类型。
    private List<String> orgTypeList;// 机构类型列表。
    private String orgCategory;// 机构分类。
    private List<String> orgCategoryList;// 机构分类列表。
    private String orgTag;// 机构标签。
    private String orgExtAttr1;// 机构扩展属性1。
    private List<String> orgExtAttr1List;// 机构扩展属性1列表。
    private String orgExtAttr2;// 机构扩展属性2。
    private List<String> orgExtAttr2List;// 机构扩展属性2列表。
    private String orgExtAttr3;// 机构扩展属性3。
    private List<String> orgExtAttr3List;// 机构扩展属性3列表。
    private String orgExtAttr4;// 机构扩展属性4。
    private List<String> orgExtAttr4List;// 机构扩展属性4列表。
    private String orgExtAttr5;// 机构扩展属性5。
    private List<String> orgExtAttr5List;// 机构扩展属性5列表。
    private String orgExtAttr6;// 机构扩展属性6。
    private List<String> orgExtAttr6List;// 机构扩展属性6列表。
    private String orgExtAttr7;// 机构扩展属性7。
    private List<String> orgExtAttr7List;// 机构扩展属性7列表。
    private String orgExtAttr8;// 机构扩展属性8。
    private List<String> orgExtAttr8List;// 机构扩展属性8列表。
    private String orgStatus;// 机构状态。
    private List<String> orgStatusList;// 机构状态列表。
    private Boolean orgTagUnion;// 所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
    private String withinOrgId;// 在该机构范围内查询。
    private Boolean orgRootOnly;// 仅查询根，默认为false。
    private Boolean recursive;// 是否递归，默认为false。
    private Boolean includeSelf;// 是否包含自己，默认为false。
    private String operatorId;// 操作人员ID。
    private String operatorName;// 操作人员名称。

    public ParentOrgQuery(OmOrgService omOrgService) {
        super();
        this.omOrgService = omOrgService;
    }

    /**
     * 设置组织架构套ID。
     * 
     * @param orgnSetId
     *        组织架构套ID。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgnSetId(String orgnSetId) {
        this.orgnSetId = orgnSetId;
        return this;
    }

    /**
     * 设置组织架构套编码。
     * 
     * @param orgnSetCode
     *        组织架构套编码。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgnSetCode(String orgnSetCode) {
        this.orgnSetCode = orgnSetCode;
        return this;
    }

    /**
     * 设置机构ID。
     * 
     * @param orgId
     *        机构ID。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    /**
     * 设置机构编码。
     * 
     * @param orgCode
     *        机构编码。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgCode(String orgCode) {
        this.orgCode = orgCode;
        return this;
    }

    /**
     * 设置机构编码列表。
     * 
     * @param orgCodeList
     *        机构编码列表。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgCodeList(List<String> orgCodeList) {
        this.orgCodeList = orgCodeList;
        return this;
    }

    /**
     * 设置机构名称。
     * 
     * @param orgName
     *        机构名称。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    /**
     * 设置机构名称列表。
     * 
     * @param orgNameList
     *        机构名称列表。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgNameList(List<String> orgNameList) {
        this.orgNameList = orgNameList;
        return this;
    }

    /**
     * 设置机构类型。
     * 
     * @param orgType
     *        机构类型。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgType(String orgType) {
        this.orgType = orgType;
        return this;
    }

    /**
     * 设置机构类型列表。
     * 
     * @param orgTypeList
     *        机构类型列表。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgTypeList(List<String> orgTypeList) {
        this.orgTypeList = orgTypeList;
        return this;
    }

    /**
     * 设置机构分类。
     * 
     * @param orgCategory
     *        机构分类。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgCategory(String orgCategory) {
        this.orgCategory = orgCategory;
        return this;
    }

    /**
     * 设置机构分类列表。
     * 
     * @param orgCategoryList
     *        机构分类列表。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgCategoryList(List<String> orgCategoryList) {
        this.orgCategoryList = orgCategoryList;
        return this;
    }

    /**
     * 设置机构标签。
     * 
     * @param orgTag
     *        机构标签。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgTag(String orgTag) {
        this.orgTag = orgTag;
        return this;
    }

    /**
     * 设置机构扩展属性1。
     * 
     * @param orgExtAttr1
     *        机构扩展属性1。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgExtAttr1(String orgExtAttr1) {
        this.orgExtAttr1 = orgExtAttr1;
        return this;
    }

    /**
     * 设置机构扩展属性1列表。
     * 
     * @param orgExtAttr1List
     *        机构扩展属性1列表。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgExtAttr1List(List<String> orgExtAttr1List) {
        this.orgExtAttr1List = orgExtAttr1List;
        return this;
    }

    /**
     * 设置机构扩展属性2。
     * 
     * @param orgExtAttr2
     *        机构扩展属性2。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgExtAttr2(String orgExtAttr2) {
        this.orgExtAttr2 = orgExtAttr2;
        return this;
    }

    /**
     * 设置机构扩展属性2列表。
     * 
     * @param orgExtAttr2List
     *        机构扩展属性2列表。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgExtAttr2List(List<String> orgExtAttr2List) {
        this.orgExtAttr2List = orgExtAttr2List;
        return this;
    }

    /**
     * 设置机构扩展属性3。
     * 
     * @param orgExtAttr3
     *        机构扩展属性3。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgExtAttr3(String orgExtAttr3) {
        this.orgExtAttr3 = orgExtAttr3;
        return this;
    }

    /**
     * 设置机构扩展属性3列表。
     * 
     * @param orgExtAttr3List
     *        机构扩展属性3列表。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgExtAttr3List(List<String> orgExtAttr3List) {
        this.orgExtAttr3List = orgExtAttr3List;
        return this;
    }

    /**
     * 设置机构扩展属性4。
     * 
     * @param orgExtAttr4
     *        机构扩展属性4。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgExtAttr4(String orgExtAttr4) {
        this.orgExtAttr4 = orgExtAttr4;
        return this;
    }

    /**
     * 设置机构扩展属性4列表。
     * 
     * @param orgExtAttr4List
     *        机构扩展属性4列表。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgExtAttr4List(List<String> orgExtAttr4List) {
        this.orgExtAttr4List = orgExtAttr4List;
        return this;
    }

    /**
     * 设置机构扩展属性5。
     * 
     * @param orgExtAttr5
     *        机构扩展属性5。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgExtAttr5(String orgExtAttr5) {
        this.orgExtAttr5 = orgExtAttr5;
        return this;
    }

    /**
     * 设置机构扩展属性5列表。
     * 
     * @param orgExtAttr5List
     *        机构扩展属性5列表。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgExtAttr5List(List<String> orgExtAttr5List) {
        this.orgExtAttr5List = orgExtAttr5List;
        return this;
    }

    /**
     * 设置机构扩展属性6。
     * 
     * @param orgExtAttr6
     *        机构扩展属性6。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgExtAttr6(String orgExtAttr6) {
        this.orgExtAttr6 = orgExtAttr6;
        return this;
    }

    /**
     * 设置机构扩展属性6列表。
     * 
     * @param orgExtAttr6List
     *        机构扩展属性6列表。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgExtAttr6List(List<String> orgExtAttr6List) {
        this.orgExtAttr6List = orgExtAttr6List;
        return this;
    }

    /**
     * 设置机构扩展属性7。
     * 
     * @param orgExtAttr7
     *        机构扩展属性7。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgExtAttr7(String orgExtAttr7) {
        this.orgExtAttr7 = orgExtAttr7;
        return this;
    }

    /**
     * 设置机构扩展属性7列表。
     * 
     * @param orgExtAttr7List
     *        机构扩展属性7列表。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgExtAttr7List(List<String> orgExtAttr7List) {
        this.orgExtAttr7List = orgExtAttr7List;
        return this;
    }

    /**
     * 设置机构扩展属性8。
     * 
     * @param orgExtAttr8
     *        机构扩展属性8。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgExtAttr8(String orgExtAttr8) {
        this.orgExtAttr8 = orgExtAttr8;
        return this;
    }

    /**
     * 设置机构扩展属性8列表。
     * 
     * @param orgExtAttr8List
     *        机构扩展属性8列表。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgExtAttr8List(List<String> orgExtAttr8List) {
        this.orgExtAttr8List = orgExtAttr8List;
        return this;
    }

    /**
     * 设置机构状态。
     * 
     * @param orgStatus
     *        机构状态。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus;
        return this;
    }

    /**
     * 设置机构状态列表。
     * 
     * @param orgStatusList
     *        机构状态列表。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgStatusList(List<String> orgStatusList) {
        this.orgStatusList = orgStatusList;
        return this;
    }

    /**
     * 设置所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * 
     * @param orgTagUnion
     *        所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgTagUnion(Boolean orgTagUnion) {
        this.orgTagUnion = orgTagUnion;
        return this;
    }

    /**
     * 设置在该机构范围内查询。
     * 
     * @param withinOrgId
     *        在该机构范围内查询。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setWithinOrgId(String withinOrgId) {
        this.withinOrgId = withinOrgId;
        return this;
    }

    /**
     * 设置仅查询根，默认为false。
     * 
     * @param orgRootOnly
     *        仅查询根，默认为false。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOrgRootOnly(Boolean orgRootOnly) {
        this.orgRootOnly = orgRootOnly;
        return this;
    }

    /**
     * 设置是否递归，默认为false。
     * 
     * @param recursive
     *        是否递归，默认为false。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setRecursive(Boolean recursive) {
        this.recursive = recursive;
        return this;
    }

    /**
     * 设置是否包含自己，默认为false。
     * 
     * @param includeSelf
     *        是否包含自己，默认为false。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setIncludeSelf(Boolean includeSelf) {
        this.includeSelf = includeSelf;
        return this;
    }

    /**
     * 设置操作人员ID。
     * 
     * @param operatorId
     *        操作人员ID。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOperatorId(String operatorId) {
        this.operatorId = operatorId;
        return this;
    }

    /**
     * 设置操作人员名称。
     * 
     * @param operatorName
     *        操作人员名称。
     * @return 当前查询实例，支持链式调用。
     */
    public ParentOrgQuery setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    /**
     * 查询对象列表。数据格式为Map。
     * 
     * @return Map类型数据列表。
     */
    public List<Map<String, Object>> queryForMapList() {
        return omOrgService.selectParentOrg(orgnSetId, orgnSetCode, orgId, orgCode, orgCodeList, orgName, orgNameList, orgType, orgTypeList, orgCategory, orgCategoryList, orgTag, orgExtAttr1, orgExtAttr1List, orgExtAttr2, orgExtAttr2List, orgExtAttr3, orgExtAttr3List, orgExtAttr4, orgExtAttr4List, orgExtAttr5, orgExtAttr5List, orgExtAttr6, orgExtAttr6List, orgExtAttr7, orgExtAttr7List, orgExtAttr8, orgExtAttr8List, orgStatus, orgStatusList, orgTagUnion, withinOrgId, orgRootOnly, recursive, includeSelf, operatorId, operatorName);
    }

    /**
     * 查询单个对象。数据格式为Map。
     * 
     * @return 单个Map类型数据。
     */
    public Map<String, Object> queryForMap() {
        List<Map<String, Object>> result = queryForMapList();
        if (result.size() == 1) {
            return result.get(0);
        }
        else {
            return null;
        }
    }

    /**
     * 查询对象列表。数据格式为实体Bean。
     * 
     * @return Bean类型数据列表。
     */
    public List<Org> queryForObjectList() {
        List<Map<String, Object>> resultList = queryForMapList();
        List<Org> orgList = new ArrayList<>();
        for (Map<String, Object> result : resultList) {
            orgList.add(new Org(result));
        }

        return orgList;
    }

    /**
     * 查询单个对象。数据格式为实体Bean。
     * 
     * @return 单个Bean类型数据。
     */
    public Org queryForObject() {
        List<Map<String, Object>> result = queryForMapList();
        if (result.size() == 1) {
            return new Org(result.get(0));
        }
        else {
            return null;
        }
    }

    /**
     * 查询总数。
     * 
     * @return 总数。
     */
    public int count() {
        return queryForMapList().size();
    }
}