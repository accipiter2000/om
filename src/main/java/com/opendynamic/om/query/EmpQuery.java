package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmEmpService;
import com.opendynamic.om.vo.Emp;

@Service
public class EmpQuery {
    private OmEmpService omEmpService;

    private String orgnSetId;// 组织架构套ID。
    private String orgnSetCode;// 组织架构套编码。
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
    private Boolean empTagUnion;// 所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
    private Boolean orgTagUnion;// 所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
    private String withinOrgId;// 在该机构范围内查询。
    private Boolean orgRootOnly;// 仅查询根，默认为false。
    private Integer page;// 页。默认为1。
    private Integer limit;// 每页数据数量。默认为-1(全部)。
    private String operatorId;// 操作人员ID。
    private String operatorName;// 操作人员名称。

    public EmpQuery(OmEmpService omEmpService) {
        super();
        this.omEmpService = omEmpService;
    }

    /**
     * 设置组织架构套ID。
     * 
     * @param orgnSetId
     *        组织架构套ID。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpQuery setOrgnSetId(String orgnSetId) {
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
    public EmpQuery setOrgnSetCode(String orgnSetCode) {
        this.orgnSetCode = orgnSetCode;
        return this;
    }

    /**
     * 设置人员ID。
     * 
     * @param empId
     *        人员ID。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpQuery setEmpId(String empId) {
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
    public EmpQuery setEmpIdList(List<String> empIdList) {
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
    public EmpQuery setEmpCode(String empCode) {
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
    public EmpQuery setEmpCodeList(List<String> empCodeList) {
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
    public EmpQuery setEmpName(String empName) {
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
    public EmpQuery setEmpNameList(List<String> empNameList) {
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
    public EmpQuery setEmpCategory(String empCategory) {
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
    public EmpQuery setEmpCategoryList(List<String> empCategoryList) {
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
    public EmpQuery setEmpTag(String empTag) {
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
    public EmpQuery setEmpExtAttr1(String empExtAttr1) {
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
    public EmpQuery setEmpExtAttr1List(List<String> empExtAttr1List) {
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
    public EmpQuery setEmpExtAttr2(String empExtAttr2) {
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
    public EmpQuery setEmpExtAttr2List(List<String> empExtAttr2List) {
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
    public EmpQuery setEmpExtAttr3(String empExtAttr3) {
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
    public EmpQuery setEmpExtAttr3List(List<String> empExtAttr3List) {
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
    public EmpQuery setEmpExtAttr4(String empExtAttr4) {
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
    public EmpQuery setEmpExtAttr4List(List<String> empExtAttr4List) {
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
    public EmpQuery setEmpExtAttr5(String empExtAttr5) {
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
    public EmpQuery setEmpExtAttr5List(List<String> empExtAttr5List) {
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
    public EmpQuery setEmpExtAttr6(String empExtAttr6) {
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
    public EmpQuery setEmpExtAttr6List(List<String> empExtAttr6List) {
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
    public EmpQuery setEmpExtAttr7(String empExtAttr7) {
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
    public EmpQuery setEmpExtAttr7List(List<String> empExtAttr7List) {
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
    public EmpQuery setEmpExtAttr8(String empExtAttr8) {
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
    public EmpQuery setEmpExtAttr8List(List<String> empExtAttr8List) {
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
    public EmpQuery setEmpStatus(String empStatus) {
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
    public EmpQuery setEmpStatusList(List<String> empStatusList) {
        this.empStatusList = empStatusList;
        return this;
    }

    /**
     * 设置机构ID。
     * 
     * @param orgId
     *        机构ID。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpQuery setOrgId(String orgId) {
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
    public EmpQuery setOrgIdList(List<String> orgIdList) {
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
    public EmpQuery setParentOrgId(String parentOrgId) {
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
    public EmpQuery setParentOrgIdList(List<String> parentOrgIdList) {
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
    public EmpQuery setOrgCode(String orgCode) {
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
    public EmpQuery setOrgCodeList(List<String> orgCodeList) {
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
    public EmpQuery setOrgName(String orgName) {
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
    public EmpQuery setOrgNameList(List<String> orgNameList) {
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
    public EmpQuery setOrgType(String orgType) {
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
    public EmpQuery setOrgTypeList(List<String> orgTypeList) {
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
    public EmpQuery setOrgCategory(String orgCategory) {
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
    public EmpQuery setOrgCategoryList(List<String> orgCategoryList) {
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
    public EmpQuery setOrgTag(String orgTag) {
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
    public EmpQuery setOrgExtAttr1(String orgExtAttr1) {
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
    public EmpQuery setOrgExtAttr1List(List<String> orgExtAttr1List) {
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
    public EmpQuery setOrgExtAttr2(String orgExtAttr2) {
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
    public EmpQuery setOrgExtAttr2List(List<String> orgExtAttr2List) {
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
    public EmpQuery setOrgExtAttr3(String orgExtAttr3) {
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
    public EmpQuery setOrgExtAttr3List(List<String> orgExtAttr3List) {
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
    public EmpQuery setOrgExtAttr4(String orgExtAttr4) {
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
    public EmpQuery setOrgExtAttr4List(List<String> orgExtAttr4List) {
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
    public EmpQuery setOrgExtAttr5(String orgExtAttr5) {
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
    public EmpQuery setOrgExtAttr5List(List<String> orgExtAttr5List) {
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
    public EmpQuery setOrgExtAttr6(String orgExtAttr6) {
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
    public EmpQuery setOrgExtAttr6List(List<String> orgExtAttr6List) {
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
    public EmpQuery setOrgExtAttr7(String orgExtAttr7) {
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
    public EmpQuery setOrgExtAttr7List(List<String> orgExtAttr7List) {
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
    public EmpQuery setOrgExtAttr8(String orgExtAttr8) {
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
    public EmpQuery setOrgExtAttr8List(List<String> orgExtAttr8List) {
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
    public EmpQuery setOrgStatus(String orgStatus) {
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
    public EmpQuery setOrgStatusList(List<String> orgStatusList) {
        this.orgStatusList = orgStatusList;
        return this;
    }

    /**
     * 设置所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * 
     * @param empTagUnion
     *        所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpQuery setEmpTagUnion(Boolean empTagUnion) {
        this.empTagUnion = empTagUnion;
        return this;
    }

    /**
     * 设置所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * 
     * @param orgTagUnion
     *        所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpQuery setOrgTagUnion(Boolean orgTagUnion) {
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
    public EmpQuery setWithinOrgId(String withinOrgId) {
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
    public EmpQuery setOrgRootOnly(Boolean orgRootOnly) {
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
    public EmpQuery setPage(Integer page) {
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
    public EmpQuery setLimit(Integer limit) {
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
    public EmpQuery setOperatorId(String operatorId) {
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
    public EmpQuery setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    /**
     * 查询对象列表。数据格式为Map。
     * 
     * @return Map类型数据列表。
     */
    public List<Map<String, Object>> queryForMapList() {
        return omEmpService.selectEmp(orgnSetId, orgnSetCode, empId, empIdList, empCode, empCodeList, empName, empNameList, empCategory, empCategoryList, empTag, empExtAttr1, empExtAttr1List, empExtAttr2, empExtAttr2List, empExtAttr3, empExtAttr3List, empExtAttr4, empExtAttr4List, empExtAttr5, empExtAttr5List, empExtAttr6, empExtAttr6List, empExtAttr7, empExtAttr7List, empExtAttr8, empExtAttr8List, empStatus, empStatusList, orgId, orgIdList, parentOrgId, parentOrgIdList, orgCode, orgCodeList, orgName, orgNameList, orgType, orgTypeList, orgCategory, orgCategoryList, orgTag, orgExtAttr1, orgExtAttr1List, orgExtAttr2, orgExtAttr2List, orgExtAttr3, orgExtAttr3List, orgExtAttr4, orgExtAttr4List, orgExtAttr5, orgExtAttr5List, orgExtAttr6, orgExtAttr6List, orgExtAttr7, orgExtAttr7List,
                orgExtAttr8, orgExtAttr8List, orgStatus, orgStatusList, empTagUnion, orgTagUnion, withinOrgId, orgRootOnly, page, limit, operatorId, operatorName);
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
    public List<Emp> queryForObjectList() {
        List<Map<String, Object>> resultList = queryForMapList();
        List<Emp> empList = new ArrayList<>();
        for (Map<String, Object> result : resultList) {
            empList.add(new Emp(result));
        }

        return empList;
    }

    /**
     * 查询单个对象。数据格式为实体Bean。
     * 
     * @return 单个Bean类型数据。
     */
    public Emp queryForObject() {
        List<Map<String, Object>> result = queryForMapList();
        if (result.size() == 1) {
            return new Emp(result.get(0));
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
        return omEmpService.countEmp(orgnSetId, orgnSetCode, empId, empIdList, empCode, empCodeList, empName, empNameList, empCategory, empCategoryList, empTag, empExtAttr1, empExtAttr1List, empExtAttr2, empExtAttr2List, empExtAttr3, empExtAttr3List, empExtAttr4, empExtAttr4List, empExtAttr5, empExtAttr5List, empExtAttr6, empExtAttr6List, empExtAttr7, empExtAttr7List, empExtAttr8, empExtAttr8List, empStatus, empStatusList, orgId, orgIdList, parentOrgId, parentOrgIdList, orgCode, orgCodeList, orgName, orgNameList, orgType, orgTypeList, orgCategory, orgCategoryList, orgTag, orgExtAttr1, orgExtAttr1List, orgExtAttr2, orgExtAttr2List, orgExtAttr3, orgExtAttr3List, orgExtAttr4, orgExtAttr4List, orgExtAttr5, orgExtAttr5List, orgExtAttr6, orgExtAttr6List, orgExtAttr7, orgExtAttr7List,
                orgExtAttr8, orgExtAttr8List, orgStatus, orgStatusList, empTagUnion, orgTagUnion, withinOrgId, orgRootOnly, operatorId, operatorName);
    }
}