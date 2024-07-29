package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmOrgnSetService;
import com.opendynamic.om.vo.OrgnSet;

@Service
public class OrgnSetQuery {
    private OmOrgnSetService omOrgnSetService;

    private String orgnSetId;// 组织架构套ID。
    private List<String> orgnSetIdList;// 组织架构套ID列表。
    private String parentOrgnSetId;// 上级组织架构套ID。
    private List<String> parentOrgnSetIdList;// 上级组织架构套ID列表。
    private String orgnSetCode;// 组织架构套编码。
    private List<String> orgnSetCodeList;// 组织架构套编码列表。
    private String orgnSetName;// 组织架构套名称。
    private List<String> orgnSetNameList;// 组织架构套名称列表。
    private String orgnSetStatus;// 组织架构套状态。
    private List<String> orgnSetStatusList;// 组织架构套状态列表。
    private Boolean orgnSetRootOnly;// 仅查询根，默认为false。
    private Integer page;// 页。默认为1。
    private Integer limit;// 每页数据数量。默认为-1(全部)。
    private String operatorId;// 操作人员ID。
    private String operatorName;// 操作人员名称。

    public OrgnSetQuery(OmOrgnSetService omOrgnSetService) {
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
    public OrgnSetQuery setOrgnSetId(String orgnSetId) {
        this.orgnSetId = orgnSetId;
        return this;
    }

    /**
     * 设置组织架构套ID列表。
     * 
     * @param orgnSetIdList
     *        组织架构套ID列表。
     * @return 当前查询实例，支持链式调用。
     */
    public OrgnSetQuery setOrgnSetIdList(List<String> orgnSetIdList) {
        this.orgnSetIdList = orgnSetIdList;
        return this;
    }

    /**
     * 设置上级组织架构套ID。
     * 
     * @param parentOrgnSetId
     *        上级组织架构套ID。
     * @return 当前查询实例，支持链式调用。
     */
    public OrgnSetQuery setParentOrgnSetId(String parentOrgnSetId) {
        this.parentOrgnSetId = parentOrgnSetId;
        return this;
    }

    /**
     * 设置上级组织架构套ID列表。
     * 
     * @param parentOrgnSetIdList
     *        上级组织架构套ID列表。
     * @return 当前查询实例，支持链式调用。
     */
    public OrgnSetQuery setParentOrgnSetIdList(List<String> parentOrgnSetIdList) {
        this.parentOrgnSetIdList = parentOrgnSetIdList;
        return this;
    }

    /**
     * 设置组织架构套编码。
     * 
     * @param orgnSetCode
     *        组织架构套编码。
     * @return 当前查询实例，支持链式调用。
     */
    public OrgnSetQuery setOrgnSetCode(String orgnSetCode) {
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
    public OrgnSetQuery setOrgnSetCodeList(List<String> orgnSetCodeList) {
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
    public OrgnSetQuery setOrgnSetName(String orgnSetName) {
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
    public OrgnSetQuery setOrgnSetNameList(List<String> orgnSetNameList) {
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
    public OrgnSetQuery setOrgnSetStatus(String orgnSetStatus) {
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
    public OrgnSetQuery setOrgnSetStatusList(List<String> orgnSetStatusList) {
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
    public OrgnSetQuery setOrgnSetRootOnly(Boolean orgnSetRootOnly) {
        this.orgnSetRootOnly = orgnSetRootOnly;
        return this;
    }

    /**
     * 设置页。默认为1。
     * 
     * @param page
     *        页。默认为1。
     * @return 当前查询实例，支持链式调用。
     */
    public OrgnSetQuery setPage(Integer page) {
        this.page = page;
        return this;
    }

    /**
     * 设置每页数据数量。默认为-1(全部)。
     * 
     * @param limit
     *        每页数据数量。默认为-1(全部)。
     * @return 当前查询实例，支持链式调用。
     */
    public OrgnSetQuery setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    /**
     * 设置操作人员ID。
     * 
     * @param operatorId
     *        操作人员ID。
     * @return 当前查询实例，支持链式调用。
     */
    public OrgnSetQuery setOperatorId(String operatorId) {
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
    public OrgnSetQuery setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    /**
     * 查询对象列表。数据格式为Map。
     * 
     * @return Map类型数据列表。
     */
    public List<Map<String, Object>> queryForMapList() {
        return omOrgnSetService.selectOrgnSet(orgnSetId, orgnSetIdList, parentOrgnSetId, parentOrgnSetIdList, orgnSetCode, orgnSetCodeList, orgnSetName, orgnSetNameList, orgnSetStatus, orgnSetStatusList, orgnSetRootOnly, page, limit, operatorId, operatorName);
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
        return omOrgnSetService.countOrgnSet(orgnSetId, orgnSetIdList, parentOrgnSetId, parentOrgnSetIdList, orgnSetCode, orgnSetCodeList, orgnSetName, orgnSetNameList, orgnSetStatus, orgnSetStatusList, orgnSetRootOnly, operatorId, operatorName);
    }
}