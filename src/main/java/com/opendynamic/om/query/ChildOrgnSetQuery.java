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

    private String orgnSetId;// 组织架构套ID。
    private String orgnSetCode;// 组织架构套编码。
    private List<String> orgnSetCodeList;// 组织架构套编码列表。
    private String orgnSetName;// 组织架构套名称。
    private List<String> orgnSetNameList;// 组织架构套名称列表。
    private String orgnSetStatus;// 组织架构套状态。
    private List<String> orgnSetStatusList;// 组织架构套状态列表。
    private Boolean orgnSetRootOnly;// 仅查询根，默认为false。
    private Boolean recursive;// 是否递归，默认为false。
    private Boolean includeSelf;// 是否包含自己，默认为false。
    private String operatorId;// 操作人员ID。
    private String operatorName;// 操作人员名称。

    public ChildOrgnSetQuery(OmOrgnSetService omOrgnSetService) {
        super();
        this.omOrgnSetService = omOrgnSetService;
    }

    /**
     * 设置组织架构套ID。
     * 
     * @param orgnSetId
     *        组织架构套ID。
     * @return 当前查询实例，支持链式调用。
     */
    public ChildOrgnSetQuery setOrgnSetId(String orgnSetId) {
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
    public ChildOrgnSetQuery setOrgnSetCode(String orgnSetCode) {
        this.orgnSetCode = orgnSetCode;
        return this;
    }

    /**
     * 设置组织架构套编码列表。
     * 
     * @param orgnSetCodeList
     *        组织架构套编码列表。
     * @return 当前查询实例，支持链式调用。
     */
    public ChildOrgnSetQuery setOrgnSetCodeList(List<String> orgnSetCodeList) {
        this.orgnSetCodeList = orgnSetCodeList;
        return this;
    }

    /**
     * 设置组织架构套名称。
     * 
     * @param orgnSetName
     *        组织架构套名称。
     * @return 当前查询实例，支持链式调用。
     */
    public ChildOrgnSetQuery setOrgnSetName(String orgnSetName) {
        this.orgnSetName = orgnSetName;
        return this;
    }

    /**
     * 设置组织架构套名称列表。
     * 
     * @param orgnSetNameList
     *        组织架构套名称列表。
     * @return 当前查询实例，支持链式调用。
     */
    public ChildOrgnSetQuery setOrgnSetNameList(List<String> orgnSetNameList) {
        this.orgnSetNameList = orgnSetNameList;
        return this;
    }

    /**
     * 设置组织架构套状态。
     * 
     * @param orgnSetStatus
     *        组织架构套状态。
     * @return 当前查询实例，支持链式调用。
     */
    public ChildOrgnSetQuery setOrgnSetStatus(String orgnSetStatus) {
        this.orgnSetStatus = orgnSetStatus;
        return this;
    }

    /**
     * 设置组织架构套状态列表。
     * 
     * @param orgnSetStatusList
     *        组织架构套状态列表。
     * @return 当前查询实例，支持链式调用。
     */
    public ChildOrgnSetQuery setOrgnSetStatusList(List<String> orgnSetStatusList) {
        this.orgnSetStatusList = orgnSetStatusList;
        return this;
    }

    /**
     * 设置仅查询根，默认为false。
     * 
     * @param orgnSetRootOnly
     *        仅查询根，默认为false。
     * @return 当前查询实例，支持链式调用。
     */
    public ChildOrgnSetQuery setOrgnSetRootOnly(Boolean orgnSetRootOnly) {
        this.orgnSetRootOnly = orgnSetRootOnly;
        return this;
    }

    /**
     * 设置是否递归，默认为false。
     * 
     * @param recursive
     *        是否递归，默认为false。
     * @return 当前查询实例，支持链式调用。
     */
    public ChildOrgnSetQuery setRecursive(Boolean recursive) {
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
    public ChildOrgnSetQuery setIncludeSelf(Boolean includeSelf) {
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
    public ChildOrgnSetQuery setOperatorId(String operatorId) {
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
    public ChildOrgnSetQuery setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    /**
     * 查询对象列表。数据格式为Map。
     * 
     * @return Map类型数据列表。
     */
    public List<Map<String, Object>> queryForMapList() {
        return omOrgnSetService.selectChildOrgnSet(orgnSetId, orgnSetCode, orgnSetCodeList, orgnSetName, orgnSetNameList, orgnSetStatus, orgnSetStatusList, orgnSetRootOnly, recursive, includeSelf, operatorId, operatorName);
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
    public List<OrgnSet> queryForObjectList() {
        List<Map<String, Object>> resultList = queryForMapList();
        List<OrgnSet> orgnSetList = new ArrayList<>();
        for (Map<String, Object> result : resultList) {
            orgnSetList.add(new OrgnSet(result));
        }

        return orgnSetList;
    }

    /**
     * 查询单个对象。数据格式为实体Bean。
     * 
     * @return 单个Bean类型数据。
     */
    public OrgnSet queryForObject() {
        List<Map<String, Object>> result = queryForMapList();
        if (result.size() == 1) {
            return new OrgnSet(result.get(0));
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