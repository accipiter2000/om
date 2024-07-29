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

    private String orgnSetId;// 组织架构套ID。
    private String orgnSetCode;// 组织架构套编码。
    private String posiId;// 岗位ID。
    private List<String> posiIdList;// 岗位ID列表。
    private String posiCode;// 岗位编码。
    private List<String> posiCodeList;// 岗位编码列表。
    private String posiName;// 岗位名称。
    private List<String> posiNameList;// 岗位名称列表。
    private String orgLeaderType;// 机构领导类型。
    private List<String> orgLeaderTypeList;// 机构领导类型列表。
    private String posiCategory;// 岗位分类。
    private List<String> posiCategoryList;// 岗位分类列表。
    private String posiTag;// 岗位标签。
    private String posiExtAttr1;// 岗位扩展属性1。
    private List<String> posiExtAttr1List;// 岗位扩展属性1列表。
    private String posiExtAttr2;// 岗位扩展属性2。
    private List<String> posiExtAttr2List;// 岗位扩展属性2列表。
    private String posiExtAttr3;// 岗位扩展属性3。
    private List<String> posiExtAttr3List;// 岗位扩展属性3列表。
    private String posiExtAttr4;// 岗位扩展属性4。
    private List<String> posiExtAttr4List;// 岗位扩展属性4列表。
    private String posiExtAttr5;// 岗位扩展属性5。
    private List<String> posiExtAttr5List;// 岗位扩展属性5列表。
    private String posiExtAttr6;// 岗位扩展属性6。
    private List<String> posiExtAttr6List;// 岗位扩展属性6列表。
    private String posiExtAttr7;// 岗位扩展属性7。
    private List<String> posiExtAttr7List;// 岗位扩展属性7列表。
    private String posiExtAttr8;// 岗位扩展属性8。
    private List<String> posiExtAttr8List;// 岗位扩展属性8列表。
    private String posiStatus;// 岗位状态。
    private List<String> posiStatusList;// 岗位状态列表。
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
    private String orgId;// 机构ID。
    private List<String> orgIdList;// 机构ID列表。
    private String parentOrgId;// 上级机构ID。
    private List<String> parentOrgIdList;// 上级机构ID列表。
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
    private Boolean posiTagUnion;// 所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
    private Boolean dutyTagUnion;// 所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
    private Boolean orgTagUnion;// 所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
    private String withinOrgId;// 在该机构范围内查询。
    private Boolean orgRootOnly;// 仅查询根，默认为false。
    private Integer page;// 页。默认为1。
    private Integer limit;// 每页数据数量。默认为-1(全部)。
    private String operatorId;// 操作人员ID。
    private String operatorName;// 操作人员名称。

    public PosiQuery(OmPosiService omPosiService) {
        super();
        this.omPosiService = omPosiService;
    }

    /**
     * 设置组织架构套ID。
     * 
     * @param orgnSetId
     *        组织架构套ID。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setOrgnSetId(String orgnSetId) {
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
    public PosiQuery setOrgnSetCode(String orgnSetCode) {
        this.orgnSetCode = orgnSetCode;
        return this;
    }

    /**
     * 设置岗位ID。
     * 
     * @param posiId
     *        岗位ID。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiId(String posiId) {
        this.posiId = posiId;
        return this;
    }

    /**
     * 设置岗位ID列表。
     * 
     * @param posiIdList
     *        岗位ID列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiIdList(List<String> posiIdList) {
        this.posiIdList = posiIdList;
        return this;
    }

    /**
     * 设置岗位编码。
     * 
     * @param posiCode
     *        岗位编码。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiCode(String posiCode) {
        this.posiCode = posiCode;
        return this;
    }

    /**
     * 设置岗位编码列表。
     * 
     * @param posiCodeList
     *        岗位编码列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiCodeList(List<String> posiCodeList) {
        this.posiCodeList = posiCodeList;
        return this;
    }

    /**
     * 设置岗位名称。
     * 
     * @param posiName
     *        岗位名称。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiName(String posiName) {
        this.posiName = posiName;
        return this;
    }

    /**
     * 设置岗位名称列表。
     * 
     * @param posiNameList
     *        岗位名称列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiNameList(List<String> posiNameList) {
        this.posiNameList = posiNameList;
        return this;
    }

    /**
     * 设置机构领导类型。
     * 
     * @param orgLeaderType
     *        机构领导类型。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setOrgLeaderType(String orgLeaderType) {
        this.orgLeaderType = orgLeaderType;
        return this;
    }

    /**
     * 设置机构领导类型列表。
     * 
     * @param orgLeaderTypeList
     *        机构领导类型列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setOrgLeaderTypeList(List<String> orgLeaderTypeList) {
        this.orgLeaderTypeList = orgLeaderTypeList;
        return this;
    }

    /**
     * 设置岗位分类。
     * 
     * @param posiCategory
     *        岗位分类。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiCategory(String posiCategory) {
        this.posiCategory = posiCategory;
        return this;
    }

    /**
     * 设置岗位分类列表。
     * 
     * @param posiCategoryList
     *        岗位分类列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiCategoryList(List<String> posiCategoryList) {
        this.posiCategoryList = posiCategoryList;
        return this;
    }

    /**
     * 设置岗位标签。
     * 
     * @param posiTag
     *        岗位标签。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiTag(String posiTag) {
        this.posiTag = posiTag;
        return this;
    }

    /**
     * 设置岗位扩展属性1。
     * 
     * @param posiExtAttr1
     *        岗位扩展属性1。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiExtAttr1(String posiExtAttr1) {
        this.posiExtAttr1 = posiExtAttr1;
        return this;
    }

    /**
     * 设置岗位扩展属性1列表。
     * 
     * @param posiExtAttr1List
     *        岗位扩展属性1列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiExtAttr1List(List<String> posiExtAttr1List) {
        this.posiExtAttr1List = posiExtAttr1List;
        return this;
    }

    /**
     * 设置岗位扩展属性2。
     * 
     * @param posiExtAttr2
     *        岗位扩展属性2。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiExtAttr2(String posiExtAttr2) {
        this.posiExtAttr2 = posiExtAttr2;
        return this;
    }

    /**
     * 设置岗位扩展属性2列表。
     * 
     * @param posiExtAttr2List
     *        岗位扩展属性2列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiExtAttr2List(List<String> posiExtAttr2List) {
        this.posiExtAttr2List = posiExtAttr2List;
        return this;
    }

    /**
     * 设置岗位扩展属性3。
     * 
     * @param posiExtAttr3
     *        岗位扩展属性3。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiExtAttr3(String posiExtAttr3) {
        this.posiExtAttr3 = posiExtAttr3;
        return this;
    }

    /**
     * 设置岗位扩展属性3列表。
     * 
     * @param posiExtAttr3List
     *        岗位扩展属性3列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiExtAttr3List(List<String> posiExtAttr3List) {
        this.posiExtAttr3List = posiExtAttr3List;
        return this;
    }

    /**
     * 设置岗位扩展属性4。
     * 
     * @param posiExtAttr4
     *        岗位扩展属性4。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiExtAttr4(String posiExtAttr4) {
        this.posiExtAttr4 = posiExtAttr4;
        return this;
    }

    /**
     * 设置岗位扩展属性4列表。
     * 
     * @param posiExtAttr4List
     *        岗位扩展属性4列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiExtAttr4List(List<String> posiExtAttr4List) {
        this.posiExtAttr4List = posiExtAttr4List;
        return this;
    }

    /**
     * 设置岗位扩展属性5。
     * 
     * @param posiExtAttr5
     *        岗位扩展属性5。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiExtAttr5(String posiExtAttr5) {
        this.posiExtAttr5 = posiExtAttr5;
        return this;
    }

    /**
     * 设置岗位扩展属性5列表。
     * 
     * @param posiExtAttr5List
     *        岗位扩展属性5列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiExtAttr5List(List<String> posiExtAttr5List) {
        this.posiExtAttr5List = posiExtAttr5List;
        return this;
    }

    /**
     * 设置岗位扩展属性6。
     * 
     * @param posiExtAttr6
     *        岗位扩展属性6。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiExtAttr6(String posiExtAttr6) {
        this.posiExtAttr6 = posiExtAttr6;
        return this;
    }

    /**
     * 设置岗位扩展属性6列表。
     * 
     * @param posiExtAttr6List
     *        岗位扩展属性6列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiExtAttr6List(List<String> posiExtAttr6List) {
        this.posiExtAttr6List = posiExtAttr6List;
        return this;
    }

    /**
     * 设置岗位扩展属性7。
     * 
     * @param posiExtAttr7
     *        岗位扩展属性7。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiExtAttr7(String posiExtAttr7) {
        this.posiExtAttr7 = posiExtAttr7;
        return this;
    }

    /**
     * 设置岗位扩展属性7列表。
     * 
     * @param posiExtAttr7List
     *        岗位扩展属性7列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiExtAttr7List(List<String> posiExtAttr7List) {
        this.posiExtAttr7List = posiExtAttr7List;
        return this;
    }

    /**
     * 设置岗位扩展属性8。
     * 
     * @param posiExtAttr8
     *        岗位扩展属性8。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiExtAttr8(String posiExtAttr8) {
        this.posiExtAttr8 = posiExtAttr8;
        return this;
    }

    /**
     * 岗位扩展属性8列表。 设置
     * 
     * @param posiExtAttr8List
     *        岗位扩展属性8列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiExtAttr8List(List<String> posiExtAttr8List) {
        this.posiExtAttr8List = posiExtAttr8List;
        return this;
    }

    /**
     * 设置岗位状态。
     * 
     * @param posiStatus
     *        岗位状态。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiStatus(String posiStatus) {
        this.posiStatus = posiStatus;
        return this;
    }

    /**
     * 设置岗位状态列表。
     * 
     * @param posiStatusList
     *        岗位状态列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiStatusList(List<String> posiStatusList) {
        this.posiStatusList = posiStatusList;
        return this;
    }

    /**
     * 设置职务ID。
     * 
     * @param dutyId
     *        职务ID。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setDutyId(String dutyId) {
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
    public PosiQuery setDutyIdList(List<String> dutyIdList) {
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
    public PosiQuery setDutyCode(String dutyCode) {
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
    public PosiQuery setDutyCodeList(List<String> dutyCodeList) {
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
    public PosiQuery setDutyName(String dutyName) {
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
    public PosiQuery setDutyNameList(List<String> dutyNameList) {
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
    public PosiQuery setDutyCategory(String dutyCategory) {
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
    public PosiQuery setDutyCategoryList(List<String> dutyCategoryList) {
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
    public PosiQuery setDutyTag(String dutyTag) {
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
    public PosiQuery setDutyExtAttr1(String dutyExtAttr1) {
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
    public PosiQuery setDutyExtAttr1List(List<String> dutyExtAttr1List) {
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
    public PosiQuery setDutyExtAttr2(String dutyExtAttr2) {
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
    public PosiQuery setDutyExtAttr2List(List<String> dutyExtAttr2List) {
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
    public PosiQuery setDutyExtAttr3(String dutyExtAttr3) {
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
    public PosiQuery setDutyExtAttr3List(List<String> dutyExtAttr3List) {
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
    public PosiQuery setDutyExtAttr4(String dutyExtAttr4) {
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
    public PosiQuery setDutyExtAttr4List(List<String> dutyExtAttr4List) {
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
    public PosiQuery setDutyExtAttr5(String dutyExtAttr5) {
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
    public PosiQuery setDutyExtAttr5List(List<String> dutyExtAttr5List) {
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
    public PosiQuery setDutyExtAttr6(String dutyExtAttr6) {
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
    public PosiQuery setDutyExtAttr6List(List<String> dutyExtAttr6List) {
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
    public PosiQuery setDutyExtAttr7(String dutyExtAttr7) {
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
    public PosiQuery setDutyExtAttr7List(List<String> dutyExtAttr7List) {
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
    public PosiQuery setDutyExtAttr8(String dutyExtAttr8) {
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
    public PosiQuery setDutyExtAttr8List(List<String> dutyExtAttr8List) {
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
    public PosiQuery setDutyStatus(String dutyStatus) {
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
    public PosiQuery setDutyStatusList(List<String> dutyStatusList) {
        this.dutyStatusList = dutyStatusList;
        return this;
    }

    /**
     * 设置机构ID。
     * 
     * @param orgId
     *        机构ID。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    /**
     * 设置机构ID列表。
     * 
     * @param orgIdList
     *        机构ID列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setOrgIdList(List<String> orgIdList) {
        this.orgIdList = orgIdList;
        return this;
    }

    /**
     * 设置上级机构ID。
     * 
     * @param parentOrgId
     *        上级机构ID。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
        return this;
    }

    /**
     * 设置上级机构ID列表。
     * 
     * @param parentOrgIdList
     *        上级机构ID列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setParentOrgIdList(List<String> parentOrgIdList) {
        this.parentOrgIdList = parentOrgIdList;
        return this;
    }

    /**
     * 设置机构编码。
     * 
     * @param orgCode
     *        机构编码。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setOrgCode(String orgCode) {
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
    public PosiQuery setOrgCodeList(List<String> orgCodeList) {
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
    public PosiQuery setOrgName(String orgName) {
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
    public PosiQuery setOrgNameList(List<String> orgNameList) {
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
    public PosiQuery setOrgType(String orgType) {
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
    public PosiQuery setOrgTypeList(List<String> orgTypeList) {
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
    public PosiQuery setOrgCategory(String orgCategory) {
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
    public PosiQuery setOrgCategoryList(List<String> orgCategoryList) {
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
    public PosiQuery setOrgTag(String orgTag) {
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
    public PosiQuery setOrgExtAttr1(String orgExtAttr1) {
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
    public PosiQuery setOrgExtAttr1List(List<String> orgExtAttr1List) {
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
    public PosiQuery setOrgExtAttr2(String orgExtAttr2) {
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
    public PosiQuery setOrgExtAttr2List(List<String> orgExtAttr2List) {
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
    public PosiQuery setOrgExtAttr3(String orgExtAttr3) {
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
    public PosiQuery setOrgExtAttr3List(List<String> orgExtAttr3List) {
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
    public PosiQuery setOrgExtAttr4(String orgExtAttr4) {
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
    public PosiQuery setOrgExtAttr4List(List<String> orgExtAttr4List) {
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
    public PosiQuery setOrgExtAttr5(String orgExtAttr5) {
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
    public PosiQuery setOrgExtAttr5List(List<String> orgExtAttr5List) {
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
    public PosiQuery setOrgExtAttr6(String orgExtAttr6) {
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
    public PosiQuery setOrgExtAttr6List(List<String> orgExtAttr6List) {
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
    public PosiQuery setOrgExtAttr7(String orgExtAttr7) {
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
    public PosiQuery setOrgExtAttr7List(List<String> orgExtAttr7List) {
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
    public PosiQuery setOrgExtAttr8(String orgExtAttr8) {
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
    public PosiQuery setOrgExtAttr8List(List<String> orgExtAttr8List) {
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
    public PosiQuery setOrgStatus(String orgStatus) {
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
    public PosiQuery setOrgStatusList(List<String> orgStatusList) {
        this.orgStatusList = orgStatusList;
        return this;
    }

    /**
     * 设置所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * 
     * @param posiTagUnion
     *        所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPosiTagUnion(Boolean posiTagUnion) {
        this.posiTagUnion = posiTagUnion;
        return this;
    }

    /**
     * 设置所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * 
     * @param dutyTagUnion
     *        所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setDutyTagUnion(Boolean dutyTagUnion) {
        this.dutyTagUnion = dutyTagUnion;
        return this;
    }

    /**
     * 设置所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * 
     * @param orgTagUnion
     *        所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setOrgTagUnion(Boolean orgTagUnion) {
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
    public PosiQuery setWithinOrgId(String withinOrgId) {
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
    public PosiQuery setOrgRootOnly(Boolean orgRootOnly) {
        this.orgRootOnly = orgRootOnly;
        return this;
    }

    /**
     * 设置页。默认为1。
     * 
     * @param page
     *        页。默认为1。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiQuery setPage(Integer page) {
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
    public PosiQuery setLimit(Integer limit) {
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
    public PosiQuery setOperatorId(String operatorId) {
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
    public PosiQuery setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    /**
     * 查询对象列表。数据格式为Map。
     * 
     * @return Map类型数据列表。
     */
    public List<Map<String, Object>> queryForMapList() {
        return omPosiService.selectPosi(orgnSetId, orgnSetCode, posiId, posiIdList, posiCode, posiCodeList, posiName, posiNameList, orgLeaderType, orgLeaderTypeList, posiCategory, posiCategoryList, posiTag, posiExtAttr1, posiExtAttr1List, posiExtAttr2, posiExtAttr2List, posiExtAttr3, posiExtAttr3List, posiExtAttr4, posiExtAttr4List, posiExtAttr5, posiExtAttr5List, posiExtAttr6, posiExtAttr6List, posiExtAttr7, posiExtAttr7List, posiExtAttr8, posiExtAttr8List, posiStatus, posiStatusList, dutyId, dutyIdList, dutyCode, dutyCodeList, dutyName, dutyNameList, dutyCategory, dutyCategoryList, dutyTag, dutyExtAttr1, dutyExtAttr1List, dutyExtAttr2, dutyExtAttr2List, dutyExtAttr3, dutyExtAttr3List, dutyExtAttr4, dutyExtAttr4List, dutyExtAttr5, dutyExtAttr5List, dutyExtAttr6, dutyExtAttr6List,
                dutyExtAttr7, dutyExtAttr7List, dutyExtAttr8, dutyExtAttr8List, dutyStatus, dutyStatusList, orgId, orgIdList, parentOrgId, parentOrgIdList, orgCode, orgCodeList, orgName, orgNameList, orgType, orgTypeList, orgCategory, orgCategoryList, orgTag, orgExtAttr1, orgExtAttr1List, orgExtAttr2, orgExtAttr2List, orgExtAttr3, orgExtAttr3List, orgExtAttr4, orgExtAttr4List, orgExtAttr5, orgExtAttr5List, orgExtAttr6, orgExtAttr6List, orgExtAttr7, orgExtAttr7List, orgExtAttr8, orgExtAttr8List, orgStatus, orgStatusList, posiTagUnion, dutyTagUnion, orgTagUnion, withinOrgId, orgRootOnly, page, limit, operatorId, operatorName);
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
    public List<Posi> queryForObjectList() {
        List<Map<String, Object>> resultList = queryForMapList();
        List<Posi> posiList = new ArrayList<>();
        for (Map<String, Object> result : resultList) {
            posiList.add(new Posi(result));
        }

        return posiList;
    }

    /**
     * 查询单个对象。数据格式为实体Bean。
     * 
     * @return 单个Bean类型数据。
     */
    public Posi queryForObject() {
        List<Map<String, Object>> result = queryForMapList();
        if (result.size() == 1) {
            return new Posi(result.get(0));
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
        return omPosiService.countPosi(orgnSetId, orgnSetCode, posiId, posiIdList, posiCode, posiCodeList, posiName, posiNameList, orgLeaderType, orgLeaderTypeList, posiCategory, posiCategoryList, posiTag, posiExtAttr1, posiExtAttr1List, posiExtAttr2, posiExtAttr2List, posiExtAttr3, posiExtAttr3List, posiExtAttr4, posiExtAttr4List, posiExtAttr5, posiExtAttr5List, posiExtAttr6, posiExtAttr6List, posiExtAttr7, posiExtAttr7List, posiExtAttr8, posiExtAttr8List, posiStatus, posiStatusList, dutyId, dutyIdList, dutyCode, dutyCodeList, dutyName, dutyNameList, dutyCategory, dutyCategoryList, dutyTag, dutyExtAttr1, dutyExtAttr1List, dutyExtAttr2, dutyExtAttr2List, dutyExtAttr3, dutyExtAttr3List, dutyExtAttr4, dutyExtAttr4List, dutyExtAttr5, dutyExtAttr5List, dutyExtAttr6, dutyExtAttr6List,
                dutyExtAttr7, dutyExtAttr7List, dutyExtAttr8, dutyExtAttr8List, dutyStatus, dutyStatusList, orgId, orgIdList, parentOrgId, parentOrgIdList, orgCode, orgCodeList, orgName, orgNameList, orgType, orgTypeList, orgCategory, orgCategoryList, orgTag, orgExtAttr1, orgExtAttr1List, orgExtAttr2, orgExtAttr2List, orgExtAttr3, orgExtAttr3List, orgExtAttr4, orgExtAttr4List, orgExtAttr5, orgExtAttr5List, orgExtAttr6, orgExtAttr6List, orgExtAttr7, orgExtAttr7List, orgExtAttr8, orgExtAttr8List, orgStatus, orgStatusList, posiTagUnion, dutyTagUnion, orgTagUnion, withinOrgId, orgRootOnly, operatorId, operatorName);
    }
}