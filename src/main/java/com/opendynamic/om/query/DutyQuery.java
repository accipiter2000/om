package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmDutyService;
import com.opendynamic.om.vo.Duty;

@Service
public class DutyQuery {
    private OmDutyService omDutyService;

    private String orgnSetId;// 组织架构套ID。
    private String orgnSetCode;// 组织架构套编码。
    private String dutyId;// 职务ID。
    private List<String> dutyIdList;// 职务ID列表。
    private String dutyCode;// 职务编码。
    private List<String> dutyCodeList;// 职务编码列表。
    private String dutyName;// 职务名称。
    private List<String> dutyNameList;// 职务名称列表。
    private String dutyCategory;// 职务分类。
    private List<String> dutyCategoryList;// 职务分类列表。
    private String dutyTag;// 职务标签。
    private String dutyExtAttr1;// 职务扩展属性1。
    private List<String> dutyExtAttr1List;// 职务扩展属性1列表。
    private String dutyExtAttr2;// 职务扩展属性2。
    private List<String> dutyExtAttr2List;// 职务扩展属性2列表。
    private String dutyExtAttr3;// 职务扩展属性3。
    private List<String> dutyExtAttr3List;// 职务扩展属性3列表。
    private String dutyExtAttr4;// 职务扩展属性4。
    private List<String> dutyExtAttr4List;// 职务扩展属性4列表。
    private String dutyExtAttr5;// 职务扩展属性5。
    private List<String> dutyExtAttr5List;// 职务扩展属性5列表。
    private String dutyExtAttr6;// 职务扩展属性6。
    private List<String> dutyExtAttr6List;// 职务扩展属性6列表。
    private String dutyExtAttr7;// 职务扩展属性7。
    private List<String> dutyExtAttr7List;// 职务扩展属性7列表。
    private String dutyExtAttr8;// 职务扩展属性8。
    private List<String> dutyExtAttr8List;// 职务扩展属性8列表。
    private String dutyStatus;// 职务状态。
    private List<String> dutyStatusList;// 职务状态列表。
    private Boolean dutyTagUnion;//// 所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
    private Integer page;// 页。默认为1。
    private Integer limit;// 每页数据数量。默认为-1(全部)。
    private String operatorId;// 操作人员ID。
    private String operatorName;// 操作人员名称。

    public DutyQuery(OmDutyService omDutyService) {
        super();
        this.omDutyService = omDutyService;
    }

    /**
     * 设置组织架构套ID。
     * 
     * @param orgnSetId
     *        组织架构套ID。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setOrgnSetId(String orgnSetId) {
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
    public DutyQuery setOrgnSetCode(String orgnSetCode) {
        this.orgnSetCode = orgnSetCode;
        return this;
    }

    /**
     * 设置职务ID。
     * 
     * @param dutyId
     *        职务ID。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyId(String dutyId) {
        this.dutyId = dutyId;
        return this;
    }

    /**
     * 设置职务ID列表。
     * 
     * @param dutyIdList
     *        职务ID列表。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyIdList(List<String> dutyIdList) {
        this.dutyIdList = dutyIdList;
        return this;
    }

    /**
     * 设置职务编码。
     * 
     * @param dutyCode
     *        职务编码。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyCode(String dutyCode) {
        this.dutyCode = dutyCode;
        return this;
    }

    /**
     * 设置职务编码列表。
     * 
     * @param dutyCodeList
     *        职务编码列表。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyCodeList(List<String> dutyCodeList) {
        this.dutyCodeList = dutyCodeList;
        return this;
    }

    /**
     * 设置职务名称。
     * 
     * @param dutyName
     *        职务名称。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyName(String dutyName) {
        this.dutyName = dutyName;
        return this;
    }

    /**
     * 设置职务名称列表。
     * 
     * @param dutyNameList
     *        职务名称列表。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyNameList(List<String> dutyNameList) {
        this.dutyNameList = dutyNameList;
        return this;
    }

    /**
     * 设置职务分类。
     * 
     * @param dutyCategory
     *        职务分类。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyCategory(String dutyCategory) {
        this.dutyCategory = dutyCategory;
        return this;
    }

    /**
     * 设置职务分类列表。
     * 
     * @param dutyCategoryList
     *        职务分类列表。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyCategoryList(List<String> dutyCategoryList) {
        this.dutyCategoryList = dutyCategoryList;
        return this;
    }

    /**
     * 设置职务标签。
     * 
     * @param dutyTag
     *        职务标签。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyTag(String dutyTag) {
        this.dutyTag = dutyTag;
        return this;
    }

    /**
     * 设置职务扩展属性1。
     * 
     * @param dutyExtAttr1
     *        职务扩展属性1。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyExtAttr1(String dutyExtAttr1) {
        this.dutyExtAttr1 = dutyExtAttr1;
        return this;
    }

    /**
     * 设置职务扩展属性1列表。
     * 
     * @param dutyExtAttr1List
     *        职务扩展属性1列表。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyExtAttr1List(List<String> dutyExtAttr1List) {
        this.dutyExtAttr1List = dutyExtAttr1List;
        return this;
    }

    /**
     * 设置职务扩展属性2。
     * 
     * @param dutyExtAttr2
     *        职务扩展属性2。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyExtAttr2(String dutyExtAttr2) {
        this.dutyExtAttr2 = dutyExtAttr2;
        return this;
    }

    /**
     * 设置职务扩展属性2列表。
     * 
     * @param dutyExtAttr2List
     *        职务扩展属性2列表。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyExtAttr2List(List<String> dutyExtAttr2List) {
        this.dutyExtAttr2List = dutyExtAttr2List;
        return this;
    }

    /**
     * 设置职务扩展属性3。
     * 
     * @param dutyExtAttr3
     *        职务扩展属性3。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyExtAttr3(String dutyExtAttr3) {
        this.dutyExtAttr3 = dutyExtAttr3;
        return this;
    }

    /**
     * 设置职务扩展属性3列表。
     * 
     * @param dutyExtAttr3List
     *        职务扩展属性3列表。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyExtAttr3List(List<String> dutyExtAttr3List) {
        this.dutyExtAttr3List = dutyExtAttr3List;
        return this;
    }

    /**
     * 设置职务扩展属性4。
     * 
     * @param dutyExtAttr4
     *        职务扩展属性4。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyExtAttr4(String dutyExtAttr4) {
        this.dutyExtAttr4 = dutyExtAttr4;
        return this;
    }

    /**
     * 设置职务扩展属性4列表。
     * 
     * @param dutyExtAttr4List
     *        职务扩展属性4列表。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyExtAttr4List(List<String> dutyExtAttr4List) {
        this.dutyExtAttr4List = dutyExtAttr4List;
        return this;
    }

    /**
     * 设置职务扩展属性5。
     * 
     * @param dutyExtAttr5
     *        职务扩展属性5。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyExtAttr5(String dutyExtAttr5) {
        this.dutyExtAttr5 = dutyExtAttr5;
        return this;
    }

    /**
     * 设置职务扩展属性5列表。
     * 
     * @param dutyExtAttr5List
     *        职务扩展属性5列表。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyExtAttr5List(List<String> dutyExtAttr5List) {
        this.dutyExtAttr5List = dutyExtAttr5List;
        return this;
    }

    /**
     * 设置职务扩展属性6。
     * 
     * @param dutyExtAttr6
     *        职务扩展属性6。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyExtAttr6(String dutyExtAttr6) {
        this.dutyExtAttr6 = dutyExtAttr6;
        return this;
    }

    /**
     * 设置职务扩展属性6列表。
     * 
     * @param dutyExtAttr6List
     *        职务扩展属性6列表。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyExtAttr6List(List<String> dutyExtAttr6List) {
        this.dutyExtAttr6List = dutyExtAttr6List;
        return this;
    }

    /**
     * 设置职务扩展属性7。
     * 
     * @param dutyExtAttr7
     *        职务扩展属性7。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyExtAttr7(String dutyExtAttr7) {
        this.dutyExtAttr7 = dutyExtAttr7;
        return this;
    }

    /**
     * 设置职务扩展属性7列表。
     * 
     * @param dutyExtAttr7List
     *        职务扩展属性7列表。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyExtAttr7List(List<String> dutyExtAttr7List) {
        this.dutyExtAttr7List = dutyExtAttr7List;
        return this;
    }

    /**
     * 设置职务扩展属性8。
     * 
     * @param dutyExtAttr8
     *        职务扩展属性8。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyExtAttr8(String dutyExtAttr8) {
        this.dutyExtAttr8 = dutyExtAttr8;
        return this;
    }

    /**
     * 设置职务扩展属性8列表。
     * 
     * @param dutyExtAttr8List
     *        职务扩展属性8列表。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyExtAttr8List(List<String> dutyExtAttr8List) {
        this.dutyExtAttr8List = dutyExtAttr8List;
        return this;
    }

    /**
     * 设置职务状态。
     * 
     * @param dutyStatus
     *        职务状态。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyStatus(String dutyStatus) {
        this.dutyStatus = dutyStatus;
        return this;
    }

    /**
     * 设置职务状态列表。
     * 
     * @param dutyStatusList
     *        职务状态列表。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyStatusList(List<String> dutyStatusList) {
        this.dutyStatusList = dutyStatusList;
        return this;
    }

    /**
     * 设置所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * 
     * @param dutyTagUnion
     *        所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setDutyTagUnion(Boolean dutyTagUnion) {
        this.dutyTagUnion = dutyTagUnion;
        return this;
    }

    /**
     * 设置页。默认为1。
     * 
     * @param page
     *        页。默认为1。
     * @return 当前查询实例，支持链式调用。
     */
    public DutyQuery setPage(Integer page) {
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
    public DutyQuery setLimit(Integer limit) {
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
    public DutyQuery setOperatorId(String operatorId) {
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
    public DutyQuery setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    /**
     * 查询对象列表。数据格式为Map。
     * 
     * @return Map类型数据列表。
     */
    public List<Map<String, Object>> queryForMapList() {
        return omDutyService.selectDuty(orgnSetId, orgnSetCode, dutyId, dutyIdList, dutyCode, dutyCodeList, dutyName, dutyNameList, dutyCategory, dutyCategoryList, dutyTag, dutyExtAttr1, dutyExtAttr1List, dutyExtAttr2, dutyExtAttr2List, dutyExtAttr3, dutyExtAttr3List, dutyExtAttr4, dutyExtAttr4List, dutyExtAttr5, dutyExtAttr5List, dutyExtAttr6, dutyExtAttr6List, dutyExtAttr7, dutyExtAttr7List, dutyExtAttr8, dutyExtAttr8List, dutyStatus, dutyStatusList, dutyTagUnion, page, limit, operatorId, operatorName);
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
    public List<Duty> queryForObjectList() {
        List<Map<String, Object>> resultList = queryForMapList();
        List<Duty> dutyList = new ArrayList<>();
        for (Map<String, Object> result : resultList) {
            dutyList.add(new Duty(result));
        }

        return dutyList;
    }

    /**
     * 查询单个对象。数据格式为实体Bean。
     * 
     * @return 单个Bean类型数据。
     */
    public Duty queryForObject() {
        List<Map<String, Object>> result = queryForMapList();
        if (result.size() == 1) {
            return new Duty(result.get(0));
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
        return omDutyService.countDuty(orgnSetId, orgnSetCode, dutyId, dutyIdList, dutyCode, dutyCodeList, dutyName, dutyNameList, dutyCategory, dutyCategoryList, dutyTag, dutyExtAttr1, dutyExtAttr1List, dutyExtAttr2, dutyExtAttr2List, dutyExtAttr3, dutyExtAttr3List, dutyExtAttr4, dutyExtAttr4List, dutyExtAttr5, dutyExtAttr5List, dutyExtAttr6, dutyExtAttr6List, dutyExtAttr7, dutyExtAttr7List, dutyExtAttr8, dutyExtAttr8List, dutyStatus, dutyStatusList, dutyTagUnion, operatorId, operatorName);
    }
}