package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmPosiEmpService;
import com.opendynamic.om.vo.PosiEmp;

@Service
public class PosiEmpQuery {
    private OmPosiEmpService omPosiEmpService;

    private String orgnSetId;// 组织架构套ID。
    private String orgnSetCode;// 组织架构套编码。
    private String posiEmpId;// 岗位人员ID。
    private List<String> posiEmpIdList;// 岗位人员ID列表。
    private String main;// 主岗位。
    private List<String> mainList;// 主岗位列表。
    private String posiEmpCategory;// 岗位人员分类。
    private List<String> posiEmpCategoryList;// 岗位人员分类列表。
    private String posiEmpTag;// 岗位人员标签。
    private String posiEmpExtAttr1;// 岗位人员扩展属性1。
    private List<String> posiEmpExtAttr1List;// 岗位人员扩展属性1列表。
    private String posiEmpExtAttr2;// 岗位人员扩展属性2。
    private List<String> posiEmpExtAttr2List;// 岗位人员扩展属性2列表。
    private String posiEmpExtAttr3;// 岗位人员扩展属性3。
    private List<String> posiEmpExtAttr3List;// 岗位人员扩展属性3列表。
    private String posiEmpExtAttr4;// 岗位人员扩展属性4。
    private List<String> posiEmpExtAttr4List;// 岗位人员扩展属性4列表。
    private String posiEmpExtAttr5;// 岗位人员扩展属性5。
    private List<String> posiEmpExtAttr5List;// 岗位人员扩展属性5列表。
    private String posiEmpExtAttr6;// 岗位人员扩展属性6。
    private List<String> posiEmpExtAttr6List;// 岗位人员扩展属性6列表。
    private String posiEmpExtAttr7;// 岗位人员扩展属性7。
    private List<String> posiEmpExtAttr7List;// 岗位人员扩展属性7列表。
    private String posiEmpExtAttr8;// 岗位人员扩展属性8。
    private List<String> posiEmpExtAttr8List;// 岗位人员扩展属性8列表。
    private String posiEmpStatus;// 岗位人员状态。
    private List<String> posiEmpStatusList;// 岗位人员状态列表。
    private String empId;// 人员ID。
    private List<String> empIdList;// 人员ID列表。
    private String empCode;// 人员编码。
    private List<String> empCodeList;// 人员编码列表。
    private String empName;// 人员名称。
    private List<String> empNameList;// 人员名称列表。
    private String empCategory;// 人员分类。
    private List<String> empCategoryList;// 人员分类列表。
    private String empTag;// 人员标签。
    private String empExtAttr1;// 人员扩展属性1。
    private List<String> empExtAttr1List;// 人员扩展属性1列表。
    private String empExtAttr2;// 人员扩展属性2。
    private List<String> empExtAttr2List;// 人员扩展属性2列表。
    private String empExtAttr3;// 人员扩展属性3。
    private List<String> empExtAttr3List;// 人员扩展属性3列表。
    private String empExtAttr4;// 人员扩展属性4。
    private List<String> empExtAttr4List;// 人员扩展属性4列表。
    private String empExtAttr5;// 人员扩展属性5。
    private List<String> empExtAttr5List;// 人员扩展属性5列表。
    private String empExtAttr6;// 人员扩展属性6。
    private List<String> empExtAttr6List;// 人员扩展属性6列表。
    private String empExtAttr7;// 人员扩展属性7。
    private List<String> empExtAttr7List;// 人员扩展属性7列表。
    private String empExtAttr8;// 人员扩展属性8。
    private List<String> empExtAttr8List;// 人员扩展属性8列表。
    private String empStatus;// 人员状态。
    private List<String> empStatusList;// 人员状态列表。
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
    private Boolean posiEmpTagUnion;// 所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
    private Boolean empTagUnion;// 所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
    private Boolean posiTagUnion;// 所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
    private Boolean dutyTagUnion;// 所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
    private Boolean orgTagUnion;// 所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
    private String withinOrgId;// 在该机构范围内查询。
    private Boolean orgRootOnly;// 仅查询根，默认为false。
    private Integer page;// 页。默认为1。
    private Integer limit;// 每页数据数量。默认为-1(全部)。
    private String operatorId;// 操作人员ID。
    private String operatorName;// 操作人员名称。

    public PosiEmpQuery(OmPosiEmpService omPosiEmpService) {
        super();
        this.omPosiEmpService = omPosiEmpService;
    }

    /**
     * 设置组织架构套ID。
     * 
     * @param orgnSetId
     *        组织架构套ID。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setOrgnSetId(String orgnSetId) {
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
    public PosiEmpQuery setOrgnSetCode(String orgnSetCode) {
        this.orgnSetCode = orgnSetCode;
        return this;
    }

    /**
     * 设置岗位人员ID。
     * 
     * @param posiEmpId
     *        岗位人员ID。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpId(String posiEmpId) {
        this.posiEmpId = posiEmpId;
        return this;
    }

    /**
     * 设置岗位人员ID列表。
     * 
     * @param posiEmpIdList
     *        岗位人员ID列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpIdList(List<String> posiEmpIdList) {
        this.posiEmpIdList = posiEmpIdList;
        return this;
    }

    /**
     * 设置主岗位。
     * 
     * @param main
     *        主岗位。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setMain(String main) {
        this.main = main;
        return this;
    }

    /**
     * 设置主岗位列表。
     * 
     * @param mainList
     *        主岗位列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setMainList(List<String> mainList) {
        this.mainList = mainList;
        return this;
    }

    /**
     * 设置岗位人员分类。
     * 
     * @param posiEmpCategory
     *        岗位人员分类。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpCategory(String posiEmpCategory) {
        this.posiEmpCategory = posiEmpCategory;
        return this;
    }

    /**
     * 设置岗位人员分类列表。
     * 
     * @param posiEmpCategoryList
     *        岗位人员分类列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpCategoryList(List<String> posiEmpCategoryList) {
        this.posiEmpCategoryList = posiEmpCategoryList;
        return this;
    }

    /**
     * 设置岗位人员标签。
     * 
     * @param posiEmpTag
     *        岗位人员标签。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpTag(String posiEmpTag) {
        this.posiEmpTag = posiEmpTag;
        return this;
    }

    /**
     * 设置岗位人员扩展属性1。
     * 
     * @param posiEmpExtAttr1
     *        岗位人员扩展属性1。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpExtAttr1(String posiEmpExtAttr1) {
        this.posiEmpExtAttr1 = posiEmpExtAttr1;
        return this;
    }

    /**
     * 设置岗位人员扩展属性1列表。
     * 
     * @param posiEmpExtAttr1List
     *        岗位人员扩展属性1列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpExtAttr1List(List<String> posiEmpExtAttr1List) {
        this.posiEmpExtAttr1List = posiEmpExtAttr1List;
        return this;
    }

    /**
     * 设置岗位人员扩展属性2。
     * 
     * @param posiEmpExtAttr2
     *        岗位人员扩展属性2。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpExtAttr2(String posiEmpExtAttr2) {
        this.posiEmpExtAttr2 = posiEmpExtAttr2;
        return this;
    }

    /**
     * 设置岗位人员扩展属性2列表。
     * 
     * @param posiEmpExtAttr2List
     *        岗位人员扩展属性2列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpExtAttr2List(List<String> posiEmpExtAttr2List) {
        this.posiEmpExtAttr2List = posiEmpExtAttr2List;
        return this;
    }

    /**
     * 设置岗位人员扩展属性3。
     * 
     * @param posiEmpExtAttr3
     *        岗位人员扩展属性3。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpExtAttr3(String posiEmpExtAttr3) {
        this.posiEmpExtAttr3 = posiEmpExtAttr3;
        return this;
    }

    /**
     * 设置岗位人员扩展属性3列表。
     * 
     * @param posiEmpExtAttr3List
     *        岗位人员扩展属性3列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpExtAttr3List(List<String> posiEmpExtAttr3List) {
        this.posiEmpExtAttr3List = posiEmpExtAttr3List;
        return this;
    }

    /**
     * 设置岗位人员扩展属性4。
     * 
     * @param posiEmpExtAttr4
     *        岗位人员扩展属性4。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpExtAttr4(String posiEmpExtAttr4) {
        this.posiEmpExtAttr4 = posiEmpExtAttr4;
        return this;
    }

    /**
     * 设置岗位人员扩展属性4列表。
     * 
     * @param posiEmpExtAttr4List
     *        岗位人员扩展属性4列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpExtAttr4List(List<String> posiEmpExtAttr4List) {
        this.posiEmpExtAttr4List = posiEmpExtAttr4List;
        return this;
    }

    /**
     * 设置岗位人员扩展属性5。
     * 
     * @param posiEmpExtAttr5
     *        岗位人员扩展属性5。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpExtAttr5(String posiEmpExtAttr5) {
        this.posiEmpExtAttr5 = posiEmpExtAttr5;
        return this;
    }

    /**
     * 设置岗位人员扩展属性5列表。
     * 
     * @param posiEmpExtAttr5List
     *        岗位人员扩展属性5列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpExtAttr5List(List<String> posiEmpExtAttr5List) {
        this.posiEmpExtAttr5List = posiEmpExtAttr5List;
        return this;
    }

    /**
     * 设置岗位人员扩展属性6。
     * 
     * @param posiEmpExtAttr6
     *        岗位人员扩展属性6。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpExtAttr6(String posiEmpExtAttr6) {
        this.posiEmpExtAttr6 = posiEmpExtAttr6;
        return this;
    }

    /**
     * 设置岗位人员扩展属性6列表。
     * 
     * @param posiEmpExtAttr6List
     *        岗位人员扩展属性6列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpExtAttr6List(List<String> posiEmpExtAttr6List) {
        this.posiEmpExtAttr6List = posiEmpExtAttr6List;
        return this;
    }

    /**
     * 设置岗位人员扩展属性7。
     * 
     * @param posiEmpExtAttr7
     *        岗位人员扩展属性7。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpExtAttr7(String posiEmpExtAttr7) {
        this.posiEmpExtAttr7 = posiEmpExtAttr7;
        return this;
    }

    /**
     * 设置岗位人员扩展属性7列表。
     * 
     * @param posiEmpExtAttr7List
     *        岗位人员扩展属性7列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpExtAttr7List(List<String> posiEmpExtAttr7List) {
        this.posiEmpExtAttr7List = posiEmpExtAttr7List;
        return this;
    }

    /**
     * 设置岗位人员扩展属性8。
     * 
     * @param posiEmpExtAttr8
     *        岗位人员扩展属性8。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpExtAttr8(String posiEmpExtAttr8) {
        this.posiEmpExtAttr8 = posiEmpExtAttr8;
        return this;
    }

    /**
     * 设置岗位人员扩展属性8列表。
     * 
     * @param posiEmpExtAttr8List
     *        岗位人员扩展属性8列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpExtAttr8List(List<String> posiEmpExtAttr8List) {
        this.posiEmpExtAttr8List = posiEmpExtAttr8List;
        return this;
    }

    /**
     * 设置岗位人员状态。
     * 
     * @param posiEmpStatus
     *        岗位人员状态。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpStatus(String posiEmpStatus) {
        this.posiEmpStatus = posiEmpStatus;
        return this;
    }

    /**
     * 设置岗位人员状态列表。
     * 
     * @param posiEmpStatusList
     *        岗位人员状态列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpStatusList(List<String> posiEmpStatusList) {
        this.posiEmpStatusList = posiEmpStatusList;
        return this;
    }

    /**
     * 设置人员ID。
     * 
     * @param empId
     *        人员ID。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpId(String empId) {
        this.empId = empId;
        return this;
    }

    /**
     * 设置人员ID列表。
     * 
     * @param empIdList
     *        人员ID列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpIdList(List<String> empIdList) {
        this.empIdList = empIdList;
        return this;
    }

    /**
     * 设置人员编码。
     * 
     * @param empCode
     *        人员编码。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpCode(String empCode) {
        this.empCode = empCode;
        return this;
    }

    /**
     * 设置人员编码列表。
     * 
     * @param empCodeList
     *        人员编码列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpCodeList(List<String> empCodeList) {
        this.empCodeList = empCodeList;
        return this;
    }

    /**
     * 设置人员名称。
     * 
     * @param empName
     *        人员名称。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpName(String empName) {
        this.empName = empName;
        return this;
    }

    /**
     * 设置人员名称列表。
     * 
     * @param empNameList
     *        人员名称列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpNameList(List<String> empNameList) {
        this.empNameList = empNameList;
        return this;
    }

    /**
     * 设置人员分类。
     * 
     * @param empCategory
     *        人员分类。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpCategory(String empCategory) {
        this.empCategory = empCategory;
        return this;
    }

    /**
     * 设置人员分类列表。
     * 
     * @param empCategoryList
     *        人员分类列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpCategoryList(List<String> empCategoryList) {
        this.empCategoryList = empCategoryList;
        return this;
    }

    /**
     * 设置人员标签。
     * 
     * @param empTag
     *        人员标签。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpTag(String empTag) {
        this.empTag = empTag;
        return this;
    }

    /**
     * 设置人员扩展属性1。
     * 
     * @param empExtAttr1
     *        人员扩展属性1。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpExtAttr1(String empExtAttr1) {
        this.empExtAttr1 = empExtAttr1;
        return this;
    }

    /**
     * 设置人员扩展属性1列表。
     * 
     * @param empExtAttr1List
     *        人员扩展属性1列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpExtAttr1List(List<String> empExtAttr1List) {
        this.empExtAttr1List = empExtAttr1List;
        return this;
    }

    /**
     * 设置人员扩展属性2。
     * 
     * @param empExtAttr2
     *        人员扩展属性2。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpExtAttr2(String empExtAttr2) {
        this.empExtAttr2 = empExtAttr2;
        return this;
    }

    /**
     * 设置人员扩展属性2列表。
     * 
     * @param empExtAttr2List
     *        人员扩展属性2列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpExtAttr2List(List<String> empExtAttr2List) {
        this.empExtAttr2List = empExtAttr2List;
        return this;
    }

    /**
     * 设置人员扩展属性3。
     * 
     * @param empExtAttr3
     *        人员扩展属性3。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpExtAttr3(String empExtAttr3) {
        this.empExtAttr3 = empExtAttr3;
        return this;
    }

    /**
     * 设置人员扩展属性3列表。
     * 
     * @param empExtAttr3List
     *        人员扩展属性3列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpExtAttr3List(List<String> empExtAttr3List) {
        this.empExtAttr3List = empExtAttr3List;
        return this;
    }

    /**
     * 设置人员扩展属性4。
     * 
     * @param empExtAttr4
     *        人员扩展属性4。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpExtAttr4(String empExtAttr4) {
        this.empExtAttr4 = empExtAttr4;
        return this;
    }

    /**
     * 设置人员扩展属性4列表。
     * 
     * @param empExtAttr4List
     *        人员扩展属性4列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpExtAttr4List(List<String> empExtAttr4List) {
        this.empExtAttr4List = empExtAttr4List;
        return this;
    }

    /**
     * 设置人员扩展属性5。
     * 
     * @param empExtAttr5
     *        人员扩展属性5。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpExtAttr5(String empExtAttr5) {
        this.empExtAttr5 = empExtAttr5;
        return this;
    }

    /**
     * 设置人员扩展属性5列表。
     * 
     * @param empExtAttr5List
     *        人员扩展属性5列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpExtAttr5List(List<String> empExtAttr5List) {
        this.empExtAttr5List = empExtAttr5List;
        return this;
    }

    /**
     * 设置人员扩展属性6。
     * 
     * @param empExtAttr6
     *        人员扩展属性6。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpExtAttr6(String empExtAttr6) {
        this.empExtAttr6 = empExtAttr6;
        return this;
    }

    /**
     * 设置人员扩展属性6列表。
     * 
     * @param empExtAttr6List
     *        人员扩展属性6列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpExtAttr6List(List<String> empExtAttr6List) {
        this.empExtAttr6List = empExtAttr6List;
        return this;
    }

    /**
     * 设置人员扩展属性7。
     * 
     * @param empExtAttr7
     *        人员扩展属性7。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpExtAttr7(String empExtAttr7) {
        this.empExtAttr7 = empExtAttr7;
        return this;
    }

    /**
     * 设置人员扩展属性7列表。
     * 
     * @param empExtAttr7List
     *        人员扩展属性7列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpExtAttr7List(List<String> empExtAttr7List) {
        this.empExtAttr7List = empExtAttr7List;
        return this;
    }

    /**
     * 设置人员扩展属性8。
     * 
     * @param empExtAttr8
     *        人员扩展属性8。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpExtAttr8(String empExtAttr8) {
        this.empExtAttr8 = empExtAttr8;
        return this;
    }

    /**
     * 设置人员扩展属性8列表。
     * 
     * @param empExtAttr8List
     *        人员扩展属性8列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpExtAttr8List(List<String> empExtAttr8List) {
        this.empExtAttr8List = empExtAttr8List;
        return this;
    }

    /**
     * 设置人员状态。
     * 
     * @param empStatus
     *        人员状态。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
        return this;
    }

    /**
     * 设置人员状态列表。
     * 
     * @param empStatusList
     *        人员状态列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpStatusList(List<String> empStatusList) {
        this.empStatusList = empStatusList;
        return this;
    }

    /**
     * 设置岗位ID。
     * 
     * @param posiId
     *        岗位ID。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiId(String posiId) {
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
    public PosiEmpQuery setPosiIdList(List<String> posiIdList) {
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
    public PosiEmpQuery setPosiCode(String posiCode) {
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
    public PosiEmpQuery setPosiCodeList(List<String> posiCodeList) {
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
    public PosiEmpQuery setPosiName(String posiName) {
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
    public PosiEmpQuery setPosiNameList(List<String> posiNameList) {
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
    public PosiEmpQuery setOrgLeaderType(String orgLeaderType) {
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
    public PosiEmpQuery setOrgLeaderTypeList(List<String> orgLeaderTypeList) {
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
    public PosiEmpQuery setPosiCategory(String posiCategory) {
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
    public PosiEmpQuery setPosiCategoryList(List<String> posiCategoryList) {
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
    public PosiEmpQuery setPosiTag(String posiTag) {
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
    public PosiEmpQuery setPosiExtAttr1(String posiExtAttr1) {
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
    public PosiEmpQuery setPosiExtAttr1List(List<String> posiExtAttr1List) {
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
    public PosiEmpQuery setPosiExtAttr2(String posiExtAttr2) {
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
    public PosiEmpQuery setPosiExtAttr2List(List<String> posiExtAttr2List) {
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
    public PosiEmpQuery setPosiExtAttr3(String posiExtAttr3) {
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
    public PosiEmpQuery setPosiExtAttr3List(List<String> posiExtAttr3List) {
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
    public PosiEmpQuery setPosiExtAttr4(String posiExtAttr4) {
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
    public PosiEmpQuery setPosiExtAttr4List(List<String> posiExtAttr4List) {
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
    public PosiEmpQuery setPosiExtAttr5(String posiExtAttr5) {
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
    public PosiEmpQuery setPosiExtAttr5List(List<String> posiExtAttr5List) {
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
    public PosiEmpQuery setPosiExtAttr6(String posiExtAttr6) {
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
    public PosiEmpQuery setPosiExtAttr6List(List<String> posiExtAttr6List) {
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
    public PosiEmpQuery setPosiExtAttr7(String posiExtAttr7) {
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
    public PosiEmpQuery setPosiExtAttr7List(List<String> posiExtAttr7List) {
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
    public PosiEmpQuery setPosiExtAttr8(String posiExtAttr8) {
        this.posiExtAttr8 = posiExtAttr8;
        return this;
    }

    /**
     * 设置岗位扩展属性8列表。
     * 
     * @param posiExtAttr8List
     *        岗位扩展属性8列表。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiExtAttr8List(List<String> posiExtAttr8List) {
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
    public PosiEmpQuery setPosiStatus(String posiStatus) {
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
    public PosiEmpQuery setPosiStatusList(List<String> posiStatusList) {
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
    public PosiEmpQuery setDutyId(String dutyId) {
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
    public PosiEmpQuery setDutyIdList(List<String> dutyIdList) {
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
    public PosiEmpQuery setDutyCode(String dutyCode) {
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
    public PosiEmpQuery setDutyCodeList(List<String> dutyCodeList) {
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
    public PosiEmpQuery setDutyName(String dutyName) {
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
    public PosiEmpQuery setDutyNameList(List<String> dutyNameList) {
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
    public PosiEmpQuery setDutyCategory(String dutyCategory) {
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
    public PosiEmpQuery setDutyCategoryList(List<String> dutyCategoryList) {
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
    public PosiEmpQuery setDutyTag(String dutyTag) {
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
    public PosiEmpQuery setDutyExtAttr1(String dutyExtAttr1) {
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
    public PosiEmpQuery setDutyExtAttr1List(List<String> dutyExtAttr1List) {
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
    public PosiEmpQuery setDutyExtAttr2(String dutyExtAttr2) {
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
    public PosiEmpQuery setDutyExtAttr2List(List<String> dutyExtAttr2List) {
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
    public PosiEmpQuery setDutyExtAttr3(String dutyExtAttr3) {
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
    public PosiEmpQuery setDutyExtAttr3List(List<String> dutyExtAttr3List) {
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
    public PosiEmpQuery setDutyExtAttr4(String dutyExtAttr4) {
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
    public PosiEmpQuery setDutyExtAttr4List(List<String> dutyExtAttr4List) {
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
    public PosiEmpQuery setDutyExtAttr5(String dutyExtAttr5) {
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
    public PosiEmpQuery setDutyExtAttr5List(List<String> dutyExtAttr5List) {
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
    public PosiEmpQuery setDutyExtAttr6(String dutyExtAttr6) {
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
    public PosiEmpQuery setDutyExtAttr6List(List<String> dutyExtAttr6List) {
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
    public PosiEmpQuery setDutyExtAttr7(String dutyExtAttr7) {
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
    public PosiEmpQuery setDutyExtAttr7List(List<String> dutyExtAttr7List) {
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
    public PosiEmpQuery setDutyExtAttr8(String dutyExtAttr8) {
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
    public PosiEmpQuery setDutyExtAttr8List(List<String> dutyExtAttr8List) {
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
    public PosiEmpQuery setDutyStatus(String dutyStatus) {
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
    public PosiEmpQuery setDutyStatusList(List<String> dutyStatusList) {
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
    public PosiEmpQuery setOrgId(String orgId) {
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
    public PosiEmpQuery setOrgIdList(List<String> orgIdList) {
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
    public PosiEmpQuery setParentOrgId(String parentOrgId) {
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
    public PosiEmpQuery setParentOrgIdList(List<String> parentOrgIdList) {
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
    public PosiEmpQuery setOrgCode(String orgCode) {
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
    public PosiEmpQuery setOrgCodeList(List<String> orgCodeList) {
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
    public PosiEmpQuery setOrgName(String orgName) {
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
    public PosiEmpQuery setOrgNameList(List<String> orgNameList) {
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
    public PosiEmpQuery setOrgType(String orgType) {
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
    public PosiEmpQuery setOrgTypeList(List<String> orgTypeList) {
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
    public PosiEmpQuery setOrgCategory(String orgCategory) {
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
    public PosiEmpQuery setOrgCategoryList(List<String> orgCategoryList) {
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
    public PosiEmpQuery setOrgTag(String orgTag) {
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
    public PosiEmpQuery setOrgExtAttr1(String orgExtAttr1) {
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
    public PosiEmpQuery setOrgExtAttr1List(List<String> orgExtAttr1List) {
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
    public PosiEmpQuery setOrgExtAttr2(String orgExtAttr2) {
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
    public PosiEmpQuery setOrgExtAttr2List(List<String> orgExtAttr2List) {
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
    public PosiEmpQuery setOrgExtAttr3(String orgExtAttr3) {
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
    public PosiEmpQuery setOrgExtAttr3List(List<String> orgExtAttr3List) {
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
    public PosiEmpQuery setOrgExtAttr4(String orgExtAttr4) {
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
    public PosiEmpQuery setOrgExtAttr4List(List<String> orgExtAttr4List) {
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
    public PosiEmpQuery setOrgExtAttr5(String orgExtAttr5) {
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
    public PosiEmpQuery setOrgExtAttr5List(List<String> orgExtAttr5List) {
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
    public PosiEmpQuery setOrgExtAttr6(String orgExtAttr6) {
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
    public PosiEmpQuery setOrgExtAttr6List(List<String> orgExtAttr6List) {
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
    public PosiEmpQuery setOrgExtAttr7(String orgExtAttr7) {
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
    public PosiEmpQuery setOrgExtAttr7List(List<String> orgExtAttr7List) {
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
    public PosiEmpQuery setOrgExtAttr8(String orgExtAttr8) {
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
    public PosiEmpQuery setOrgExtAttr8List(List<String> orgExtAttr8List) {
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
    public PosiEmpQuery setOrgStatus(String orgStatus) {
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
    public PosiEmpQuery setOrgStatusList(List<String> orgStatusList) {
        this.orgStatusList = orgStatusList;
        return this;
    }

    /**
     * 设置所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * 
     * @param posiEmpTagUnion
     *        所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiEmpTagUnion(Boolean posiEmpTagUnion) {
        this.posiEmpTagUnion = posiEmpTagUnion;
        return this;
    }

    /**
     * 设置所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * 
     * @param empTagUnion
     *        所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setEmpTagUnion(Boolean empTagUnion) {
        this.empTagUnion = empTagUnion;
        return this;
    }

    /**
     * 设置所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * 
     * @param posiTagUnion
     *        所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * @return 当前查询实例，支持链式调用。
     */
    public PosiEmpQuery setPosiTagUnion(Boolean posiTagUnion) {
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
    public PosiEmpQuery setDutyTagUnion(Boolean dutyTagUnion) {
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
    public PosiEmpQuery setOrgTagUnion(Boolean orgTagUnion) {
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
    public PosiEmpQuery setWithinOrgId(String withinOrgId) {
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
    public PosiEmpQuery setOrgRootOnly(Boolean orgRootOnly) {
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
    public PosiEmpQuery setPage(Integer page) {
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
    public PosiEmpQuery setLimit(Integer limit) {
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
    public PosiEmpQuery setOperatorId(String operatorId) {
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
    public PosiEmpQuery setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    /**
     * 查询对象列表。数据格式为Map。
     * 
     * @return Map类型数据列表。
     */
    public List<Map<String, Object>> queryForMapList() {
        return omPosiEmpService.selectPosiEmp(orgnSetId, orgnSetCode, posiEmpId, posiEmpIdList, main, mainList, posiEmpCategory, posiEmpCategoryList, posiEmpTag, posiEmpExtAttr1, posiEmpExtAttr1List, posiEmpExtAttr2, posiEmpExtAttr2List, posiEmpExtAttr3, posiEmpExtAttr3List, posiEmpExtAttr4, posiEmpExtAttr4List, posiEmpExtAttr5, posiEmpExtAttr5List, posiEmpExtAttr6, posiEmpExtAttr6List, posiEmpExtAttr7, posiEmpExtAttr7List, posiEmpExtAttr8, posiEmpExtAttr8List, posiEmpStatus, posiEmpStatusList, empId, empIdList, empCode, empCodeList, empName, empNameList, empCategory, empCategoryList, empTag, empExtAttr1, empExtAttr1List, empExtAttr2, empExtAttr2List, empExtAttr3, empExtAttr3List, empExtAttr4, empExtAttr4List, empExtAttr5, empExtAttr5List, empExtAttr6, empExtAttr6List, empExtAttr7,
                empExtAttr7List, empExtAttr8, empExtAttr8List, empStatus, empStatusList, posiId, posiIdList, posiCode, posiCodeList, posiName, posiNameList, orgLeaderType, orgLeaderTypeList, posiCategory, posiCategoryList, posiTag, posiExtAttr1, posiExtAttr1List, posiExtAttr2, posiExtAttr2List, posiExtAttr3, posiExtAttr3List, posiExtAttr4, posiExtAttr4List, posiExtAttr5, posiExtAttr5List, posiExtAttr6, posiExtAttr6List, posiExtAttr7, posiExtAttr7List, posiExtAttr8, posiExtAttr8List, posiStatus, posiStatusList, dutyId, dutyIdList, dutyCode, dutyCodeList, dutyName, dutyNameList, dutyCategory, dutyCategoryList, dutyTag, dutyExtAttr1, dutyExtAttr1List, dutyExtAttr2, dutyExtAttr2List, dutyExtAttr3, dutyExtAttr3List, dutyExtAttr4, dutyExtAttr4List, dutyExtAttr5, dutyExtAttr5List, dutyExtAttr6,
                dutyExtAttr6List, dutyExtAttr7, dutyExtAttr7List, dutyExtAttr8, dutyExtAttr8List, dutyStatus, dutyStatusList, orgId, orgIdList, parentOrgId, parentOrgIdList, orgCode, orgCodeList, orgName, orgNameList, orgType, orgTypeList, orgCategory, orgCategoryList, orgTag, orgExtAttr1, orgExtAttr1List, orgExtAttr2, orgExtAttr2List, orgExtAttr3, orgExtAttr3List, orgExtAttr4, orgExtAttr4List, orgExtAttr5, orgExtAttr5List, orgExtAttr6, orgExtAttr6List, orgExtAttr7, orgExtAttr7List, orgExtAttr8, orgExtAttr8List, orgStatus, orgStatusList, posiEmpTagUnion, empTagUnion, posiTagUnion, dutyTagUnion, orgTagUnion, withinOrgId, orgRootOnly, page, limit, operatorId, operatorName);
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
    public List<PosiEmp> queryForObjectList() {
        List<Map<String, Object>> resultList = queryForMapList();
        List<PosiEmp> posiEmpList = new ArrayList<>();
        for (Map<String, Object> result : resultList) {
            posiEmpList.add(new PosiEmp(result));
        }

        return posiEmpList;
    }

    /**
     * 查询单个对象。数据格式为实体Bean。
     * 
     * @return 单个Bean类型数据。
     */
    public PosiEmp queryForObject() {
        List<Map<String, Object>> result = queryForMapList();
        if (result.size() == 1) {
            return new PosiEmp(result.get(0));
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
        return omPosiEmpService.countPosiEmp(orgnSetId, orgnSetCode, posiEmpId, posiEmpIdList, main, mainList, posiEmpCategory, posiEmpCategoryList, posiEmpTag, posiEmpExtAttr1, posiEmpExtAttr1List, posiEmpExtAttr2, posiEmpExtAttr2List, posiEmpExtAttr3, posiEmpExtAttr3List, posiEmpExtAttr4, posiEmpExtAttr4List, posiEmpExtAttr5, posiEmpExtAttr5List, posiEmpExtAttr6, posiEmpExtAttr6List, posiEmpExtAttr7, posiEmpExtAttr7List, posiEmpExtAttr8, posiEmpExtAttr8List, posiEmpStatus, posiEmpStatusList, empId, empIdList, empCode, empCodeList, empName, empNameList, empCategory, empCategoryList, empTag, empExtAttr1, empExtAttr1List, empExtAttr2, empExtAttr2List, empExtAttr3, empExtAttr3List, empExtAttr4, empExtAttr4List, empExtAttr5, empExtAttr5List, empExtAttr6, empExtAttr6List, empExtAttr7,
                empExtAttr7List, empExtAttr8, empExtAttr8List, empStatus, empStatusList, posiId, posiIdList, posiCode, posiCodeList, posiName, posiNameList, orgLeaderType, orgLeaderTypeList, posiCategory, posiCategoryList, posiTag, posiExtAttr1, posiExtAttr1List, posiExtAttr2, posiExtAttr2List, posiExtAttr3, posiExtAttr3List, posiExtAttr4, posiExtAttr4List, posiExtAttr5, posiExtAttr5List, posiExtAttr6, posiExtAttr6List, posiExtAttr7, posiExtAttr7List, posiExtAttr8, posiExtAttr8List, posiStatus, posiStatusList, dutyId, dutyIdList, dutyCode, dutyCodeList, dutyName, dutyNameList, dutyCategory, dutyCategoryList, dutyTag, dutyExtAttr1, dutyExtAttr1List, dutyExtAttr2, dutyExtAttr2List, dutyExtAttr3, dutyExtAttr3List, dutyExtAttr4, dutyExtAttr4List, dutyExtAttr5, dutyExtAttr5List, dutyExtAttr6,
                dutyExtAttr6List, dutyExtAttr7, dutyExtAttr7List, dutyExtAttr8, dutyExtAttr8List, dutyStatus, dutyStatusList, orgId, orgIdList, parentOrgId, parentOrgIdList, orgCode, orgCodeList, orgName, orgNameList, orgType, orgTypeList, orgCategory, orgCategoryList, orgTag, orgExtAttr1, orgExtAttr1List, orgExtAttr2, orgExtAttr2List, orgExtAttr3, orgExtAttr3List, orgExtAttr4, orgExtAttr4List, orgExtAttr5, orgExtAttr5List, orgExtAttr6, orgExtAttr6List, orgExtAttr7, orgExtAttr7List, orgExtAttr8, orgExtAttr8List, orgStatus, orgStatusList, posiEmpTagUnion, empTagUnion, posiTagUnion, dutyTagUnion, orgTagUnion, withinOrgId, orgRootOnly, operatorId, operatorName);
    }
}