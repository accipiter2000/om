package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmEmpRelationService;
import com.opendynamic.om.vo.EmpRelation;

@Service
public class EmpRelationQuery {
    private OmEmpRelationService omEmpRelationService;

    private String orgnSetId;// 组织架构套ID。
    private String orgnSetCode;// 组织架构套编码。
    private String empRelationId;// 人员关系ID。
    private List<String> empRelationIdList;// 人员关系ID列表。
    private String empRelation;// 人员关系。
    private List<String> empRelationList;// 人员关系列表。
    private String empRelationCategory;// 人员关系分类。
    private List<String> empRelationCategoryList;// 人员关系分类列表。
    private String empRelationTag;// 人员关系标签。
    private String empRelationExtAttr1;// 人员关系扩展属性1。
    private List<String> empRelationExtAttr1List;// 人员关系扩展属性1列表。
    private String empRelationExtAttr2;// 人员关系扩展属性2。
    private List<String> empRelationExtAttr2List;// 人员关系扩展属性2列表。
    private String empRelationExtAttr3;// 人员关系扩展属性3。
    private List<String> empRelationExtAttr3List;// 人员关系扩展属性3列表。
    private String empRelationExtAttr4;// 人员关系扩展属性4。
    private List<String> empRelationExtAttr4List;// 人员关系扩展属性4列表。
    private String empRelationExtAttr5;// 人员关系扩展属性5。
    private List<String> empRelationExtAttr5List;// 人员关系扩展属性5列表。
    private String empRelationExtAttr6;// 人员关系扩展属性6。
    private List<String> empRelationExtAttr6List;// 人员关系扩展属性6列表。
    private String empRelationExtAttr7;// 人员关系扩展属性7。
    private List<String> empRelationExtAttr7List;// 人员关系扩展属性7列表。
    private String empRelationExtAttr8;// 人员关系扩展属性8。
    private List<String> empRelationExtAttr8List;// 人员关系扩展属性8列表。
    private String empRelationStatus;// 人员关系状态。
    private List<String> empRelationStatusList;// 人员关系状态列表。
    private String upperEmpId;// 上级人员ID。
    private List<String> upperEmpIdList;// 上级人员ID列表。
    private String upperEmpCode;// 上级人员编码。
    private List<String> upperEmpCodeList;// 上级人员编码列表。
    private String upperEmpName;// 上级人员名称。
    private List<String> upperEmpNameList;// 上级人员名称列表。
    private String upperEmpCategory;// 上级人员分类。
    private List<String> upperEmpCategoryList;// 上级人员分类列表。
    private String upperEmpTag;// 上级人员标签。
    private String upperEmpExtAttr1;// 上级人员扩展属性1。
    private List<String> upperEmpExtAttr1List;// 上级人员扩展属性1列表。
    private String upperEmpExtAttr2;// 上级人员扩展属性2。
    private List<String> upperEmpExtAttr2List;// 上级人员扩展属性2列表。
    private String upperEmpExtAttr3;// 上级人员扩展属性3。
    private List<String> upperEmpExtAttr3List;// 上级人员扩展属性3列表。
    private String upperEmpExtAttr4;// 上级人员扩展属性4。
    private List<String> upperEmpExtAttr4List;// 上级人员扩展属性4列表。
    private String upperEmpExtAttr5;// 上级人员扩展属性5。
    private List<String> upperEmpExtAttr5List;// 上级人员扩展属性5列表。
    private String upperEmpExtAttr6;// 上级人员扩展属性6。
    private List<String> upperEmpExtAttr6List;// 上级人员扩展属性6列表。
    private String upperEmpExtAttr7;// 上级人员扩展属性7。
    private List<String> upperEmpExtAttr7List;// 上级人员扩展属性7列表。
    private String upperEmpExtAttr8;// 上级人员扩展属性8。
    private List<String> upperEmpExtAttr8List;// 上级人员扩展属性8列表。
    private String upperEmpStatus;// 上级人员状态。
    private List<String> upperEmpStatusList;// 上级人员状态列表。
    private String upperOrgId;// 上级机构ID。
    private List<String> upperOrgIdList;// 上级机构ID列表。
    private String upperParentOrgId;// 上级上级机构ID。
    private List<String> upperParentOrgIdList;// 上级上级机构ID列表。
    private String upperOrgCode;// 上级机构编码。
    private List<String> upperOrgCodeList;// 上级机构编码列表。
    private String upperOrgName;// 上级机构名称。
    private List<String> upperOrgNameList;// 上级机构名称列表。
    private String upperOrgType;// 上级机构类型。
    private List<String> upperOrgTypeList;// 上级机构类型列表。
    private String upperOrgCategory;// 上级机构分类。
    private List<String> upperOrgCategoryList;// 上级机构分类列表。
    private String upperOrgTag;// 上级机构标签。
    private String upperOrgExtAttr1;// 上级机构扩展属性1。
    private List<String> upperOrgExtAttr1List;// 上级机构扩展属性1列表。
    private String upperOrgExtAttr2;// 上级机构扩展属性2。
    private List<String> upperOrgExtAttr2List;// 上级机构扩展属性2列表。
    private String upperOrgExtAttr3;// 上级机构扩展属性3。
    private List<String> upperOrgExtAttr3List;// 上级机构扩展属性3列表。
    private String upperOrgExtAttr4;// 上级机构扩展属性4。
    private List<String> upperOrgExtAttr4List;// 上级机构扩展属性4列表。
    private String upperOrgExtAttr5;// 上级机构扩展属性5。
    private List<String> upperOrgExtAttr5List;// 上级机构扩展属性5列表。
    private String upperOrgExtAttr6;// 上级机构扩展属性6。
    private List<String> upperOrgExtAttr6List;// 上级机构扩展属性6列表。
    private String upperOrgExtAttr7;// 上级机构扩展属性7。
    private List<String> upperOrgExtAttr7List;// 上级机构扩展属性7列表。
    private String upperOrgExtAttr8;// 上级机构扩展属性8。
    private List<String> upperOrgExtAttr8List;// 上级机构扩展属性8列表。
    private String upperOrgStatus;// 上级机构状态。
    private List<String> upperOrgStatusList;// 上级机构状态列表。
    private String lowerEmpId;// 下级人员ID。
    private List<String> lowerEmpIdList;// 下级人员ID列表。
    private String lowerEmpCode;// 下级人员编码。
    private List<String> lowerEmpCodeList;// 下级人员编码列表。
    private String lowerEmpName;// 下级人员名称。
    private List<String> lowerEmpNameList;// 下级人员名称列表。
    private String lowerEmpCategory;// 下级人员分类。
    private List<String> lowerEmpCategoryList;// 下级人员分类列表。
    private String lowerEmpTag;// 下级人员标签。
    private String lowerEmpExtAttr1;// 下级人员扩展属性1。
    private List<String> lowerEmpExtAttr1List;// 下级人员扩展属性1列表。
    private String lowerEmpExtAttr2;// 下级人员扩展属性2。
    private List<String> lowerEmpExtAttr2List;// 下级人员扩展属性2列表。
    private String lowerEmpExtAttr3;// 下级人员扩展属性3。
    private List<String> lowerEmpExtAttr3List;// 下级人员扩展属性3列表。
    private String lowerEmpExtAttr4;// 下级人员扩展属性4。
    private List<String> lowerEmpExtAttr4List;// 下级人员扩展属性4列表。
    private String lowerEmpExtAttr5;// 下级人员扩展属性5。
    private List<String> lowerEmpExtAttr5List;// 下级人员扩展属性5列表。
    private String lowerEmpExtAttr6;// 下级人员扩展属性6。
    private List<String> lowerEmpExtAttr6List;// 下级人员扩展属性6列表。
    private String lowerEmpExtAttr7;// 下级人员扩展属性7。
    private List<String> lowerEmpExtAttr7List;// 下级人员扩展属性7列表。
    private String lowerEmpExtAttr8;// 下级人员扩展属性8。
    private List<String> lowerEmpExtAttr8List;// 下级人员扩展属性8列表。
    private String lowerEmpStatus;// 下级人员状态。
    private List<String> lowerEmpStatusList;// 下级人员状态列表。
    private String lowerOrgId;// 下级机构ID。
    private List<String> lowerOrgIdList;// 下级机构ID列表。
    private String lowerParentOrgId;// 下级上级机构ID。
    private List<String> lowerParentOrgIdList;// 下级上级机构ID列表。
    private String lowerOrgCode;// 下级机构编码。
    private List<String> lowerOrgCodeList;// 下级机构编码列表。
    private String lowerOrgName;// 下级机构名称。
    private List<String> lowerOrgNameList;// 下级机构名称列表。
    private String lowerOrgType;// 下级机构类型。
    private List<String> lowerOrgTypeList;// 下级机构类型列表。
    private String lowerOrgCategory;// 下级机构分类。
    private List<String> lowerOrgCategoryList;// 下级机构分类列表。
    private String lowerOrgTag;// 下级机构标签。
    private String lowerOrgExtAttr1;// 下级机构扩展属性1。
    private List<String> lowerOrgExtAttr1List;// 下级机构扩展属性1列表。
    private String lowerOrgExtAttr2;// 下级机构扩展属性2。
    private List<String> lowerOrgExtAttr2List;// 下级机构扩展属性2列表。
    private String lowerOrgExtAttr3;// 下级机构扩展属性3。
    private List<String> lowerOrgExtAttr3List;// 下级机构扩展属性3列表。
    private String lowerOrgExtAttr4;// 下级机构扩展属性4。
    private List<String> lowerOrgExtAttr4List;// 下级机构扩展属性4列表。
    private String lowerOrgExtAttr5;// 下级机构扩展属性5。
    private List<String> lowerOrgExtAttr5List;// 下级机构扩展属性5列表。
    private String lowerOrgExtAttr6;// 下级机构扩展属性6。
    private List<String> lowerOrgExtAttr6List;// 下级机构扩展属性6列表。
    private String lowerOrgExtAttr7;// 下级机构扩展属性7。
    private List<String> lowerOrgExtAttr7List;// 下级机构扩展属性7列表。
    private String lowerOrgExtAttr8;// 下级机构扩展属性8。
    private List<String> lowerOrgExtAttr8List;// 下级机构扩展属性8列表。
    private String lowerOrgStatus;// 下级机构状态。
    private List<String> lowerOrgStatusList;// 下级机构状态列表。
    private Boolean empRelationTagUnion;// 所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
    private Boolean upperEmpTagUnion;// 所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
    private Boolean upperOrgTagUnion;// 所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
    private String upperWithinOrgId;// 在该机构范围内查询。
    private Boolean upperOrgRootOnly;// 仅查询根，默认为false。
    private Boolean lowerEmpTagUnion;// 所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
    private Boolean lowerOrgTagUnion;// 所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
    private String lowerWithinOrgId;// 在该机构范围内查询。
    private Boolean lowerOrgRootOnly;// 仅查询根，默认为false。
    private Integer page;// 页。默认为1。
    private Integer limit;// 每页数据数量。默认为-1(全部)。
    private String operatorId;// 操作人员ID。
    private String operatorName;// 操作人员名称。

    public EmpRelationQuery(OmEmpRelationService omEmpRelationService) {
        super();
        this.omEmpRelationService = omEmpRelationService;
    }

    /**
     * 设置组织架构套ID。
     * 
     * @param orgnSetId
     *        组织架构套ID。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setOrgnSetId(String orgnSetId) {
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
    public EmpRelationQuery setOrgnSetCode(String orgnSetCode) {
        this.orgnSetCode = orgnSetCode;
        return this;
    }

    /**
     * 设置人员关系ID。
     * 
     * @param empRelationId
     *        人员关系ID。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationId(String empRelationId) {
        this.empRelationId = empRelationId;
        return this;
    }

    /**
     * 设置人员关系ID列表。
     * 
     * @param empRelationIdList
     *        人员关系ID列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationIdList(List<String> empRelationIdList) {
        this.empRelationIdList = empRelationIdList;
        return this;
    }

    /**
     * 设置人员关系。
     * 
     * @param empRelation
     *        人员关系。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelation(String empRelation) {
        this.empRelation = empRelation;
        return this;
    }

    /**
     * 设置人员关系列表。
     * 
     * @param empRelationList
     *        人员关系列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationList(List<String> empRelationList) {
        this.empRelationList = empRelationList;
        return this;
    }

    /**
     * 设置人员关系分类。
     * 
     * @param empRelationCategory
     *        人员关系分类。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationCategory(String empRelationCategory) {
        this.empRelationCategory = empRelationCategory;
        return this;
    }

    /**
     * 设置人员关系分类列表。
     * 
     * @param empRelationCategoryList
     *        人员关系分类列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationCategoryList(List<String> empRelationCategoryList) {
        this.empRelationCategoryList = empRelationCategoryList;
        return this;
    }

    /**
     * 设置人员关系标签。
     * 
     * @param empRelationTag
     *        人员关系标签。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationTag(String empRelationTag) {
        this.empRelationTag = empRelationTag;
        return this;
    }

    /**
     * 设置人员关系扩展属性1。
     * 
     * @param empRelationExtAttr1
     *        人员关系扩展属性1。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationExtAttr1(String empRelationExtAttr1) {
        this.empRelationExtAttr1 = empRelationExtAttr1;
        return this;
    }

    /**
     * 设置人员关系扩展属性1列表。
     * 
     * @param empRelationExtAttr1List
     *        人员关系扩展属性1列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationExtAttr1List(List<String> empRelationExtAttr1List) {
        this.empRelationExtAttr1List = empRelationExtAttr1List;
        return this;
    }

    /**
     * 设置人员关系扩展属性2。
     * 
     * @param empRelationExtAttr2
     *        人员关系扩展属性2。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationExtAttr2(String empRelationExtAttr2) {
        this.empRelationExtAttr2 = empRelationExtAttr2;
        return this;
    }

    /**
     * 设置人员关系扩展属性2列表。
     * 
     * @param empRelationExtAttr2List
     *        人员关系扩展属性2列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationExtAttr2List(List<String> empRelationExtAttr2List) {
        this.empRelationExtAttr2List = empRelationExtAttr2List;
        return this;
    }

    /**
     * 人员关系扩展属性3。 设置
     * 
     * @param empRelationExtAttr3
     *        人员关系扩展属性3。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationExtAttr3(String empRelationExtAttr3) {
        this.empRelationExtAttr3 = empRelationExtAttr3;
        return this;
    }

    /**
     * 设置人员关系扩展属性3列表。
     * 
     * @param empRelationExtAttr3List
     *        人员关系扩展属性3列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationExtAttr3List(List<String> empRelationExtAttr3List) {
        this.empRelationExtAttr3List = empRelationExtAttr3List;
        return this;
    }

    /**
     * 设置人员关系扩展属性4。
     * 
     * @param empRelationExtAttr4
     *        人员关系扩展属性4。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationExtAttr4(String empRelationExtAttr4) {
        this.empRelationExtAttr4 = empRelationExtAttr4;
        return this;
    }

    /**
     * 设置人员关系扩展属性4列表。
     * 
     * @param empRelationExtAttr4List
     *        人员关系扩展属性4列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationExtAttr4List(List<String> empRelationExtAttr4List) {
        this.empRelationExtAttr4List = empRelationExtAttr4List;
        return this;
    }

    /**
     * 设置人员关系扩展属性5。
     * 
     * @param empRelationExtAttr5
     *        人员关系扩展属性5。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationExtAttr5(String empRelationExtAttr5) {
        this.empRelationExtAttr5 = empRelationExtAttr5;
        return this;
    }

    /**
     * 设置人员关系扩展属性5列表。
     * 
     * @param empRelationExtAttr5List
     *        人员关系扩展属性5列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationExtAttr5List(List<String> empRelationExtAttr5List) {
        this.empRelationExtAttr5List = empRelationExtAttr5List;
        return this;
    }

    /**
     * 设置人员关系扩展属性6。
     * 
     * @param empRelationExtAttr6
     *        人员关系扩展属性6。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationExtAttr6(String empRelationExtAttr6) {
        this.empRelationExtAttr6 = empRelationExtAttr6;
        return this;
    }

    /**
     * 设置人员关系扩展属性6列表。
     * 
     * @param empRelationExtAttr6List
     *        人员关系扩展属性6列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationExtAttr6List(List<String> empRelationExtAttr6List) {
        this.empRelationExtAttr6List = empRelationExtAttr6List;
        return this;
    }

    /**
     * 设置人员关系扩展属性7。
     * 
     * @param empRelationExtAttr7
     *        人员关系扩展属性7。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationExtAttr7(String empRelationExtAttr7) {
        this.empRelationExtAttr7 = empRelationExtAttr7;
        return this;
    }

    /**
     * 设置人员关系扩展属性7列表。
     * 
     * @param empRelationExtAttr7List
     *        人员关系扩展属性7列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationExtAttr7List(List<String> empRelationExtAttr7List) {
        this.empRelationExtAttr7List = empRelationExtAttr7List;
        return this;
    }

    /**
     * 设置人员关系扩展属性8。
     * 
     * @param empRelationExtAttr8
     *        人员关系扩展属性8。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationExtAttr8(String empRelationExtAttr8) {
        this.empRelationExtAttr8 = empRelationExtAttr8;
        return this;
    }

    /**
     * 设置人员关系扩展属性8列表。
     * 
     * @param empRelationExtAttr8List
     *        人员关系扩展属性8列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationExtAttr8List(List<String> empRelationExtAttr8List) {
        this.empRelationExtAttr8List = empRelationExtAttr8List;
        return this;
    }

    /**
     * 设置人员关系状态。
     * 
     * @param empRelationStatus
     *        人员关系状态。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationStatus(String empRelationStatus) {
        this.empRelationStatus = empRelationStatus;
        return this;
    }

    /**
     * 设置人员关系状态列表。
     * 
     * @param empRelationStatusList
     *        人员关系状态列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationStatusList(List<String> empRelationStatusList) {
        this.empRelationStatusList = empRelationStatusList;
        return this;
    }

    /**
     * 设置上级人员ID。
     * 
     * @param upperEmpId
     *        上级人员ID。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpId(String upperEmpId) {
        this.upperEmpId = upperEmpId;
        return this;
    }

    /**
     * 设置上级人员ID列表。
     * 
     * @param upperEmpIdList
     *        上级人员ID列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpIdList(List<String> upperEmpIdList) {
        this.upperEmpIdList = upperEmpIdList;
        return this;
    }

    /**
     * 设置上级人员编码。
     * 
     * @param upperEmpCode
     *        上级人员编码。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpCode(String upperEmpCode) {
        this.upperEmpCode = upperEmpCode;
        return this;
    }

    /**
     * 设置上级人员编码列表。
     * 
     * @param upperEmpCodeList
     *        上级人员编码列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpCodeList(List<String> upperEmpCodeList) {
        this.upperEmpCodeList = upperEmpCodeList;
        return this;
    }

    /**
     * 设置上级人员名称。
     * 
     * @param upperEmpName
     *        上级人员名称。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpName(String upperEmpName) {
        this.upperEmpName = upperEmpName;
        return this;
    }

    /**
     * 设置上级人员名称列表。
     * 
     * @param upperEmpNameList
     *        上级人员名称列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpNameList(List<String> upperEmpNameList) {
        this.upperEmpNameList = upperEmpNameList;
        return this;
    }

    /**
     * 设置上级人员分类。
     * 
     * @param upperEmpCategory
     *        上级人员分类。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpCategory(String upperEmpCategory) {
        this.upperEmpCategory = upperEmpCategory;
        return this;
    }

    /**
     * 设置上级人员分类列表。
     * 
     * @param upperEmpCategoryList
     *        上级人员分类列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpCategoryList(List<String> upperEmpCategoryList) {
        this.upperEmpCategoryList = upperEmpCategoryList;
        return this;
    }

    /**
     * 设置上级人员标签。
     * 
     * @param upperEmpTag
     *        上级人员标签。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpTag(String upperEmpTag) {
        this.upperEmpTag = upperEmpTag;
        return this;
    }

    /**
     * 设置上级人员扩展属性1。
     * 
     * @param upperEmpExtAttr1
     *        上级人员扩展属性1。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpExtAttr1(String upperEmpExtAttr1) {
        this.upperEmpExtAttr1 = upperEmpExtAttr1;
        return this;
    }

    /**
     * 设置上级人员扩展属性1列表。
     * 
     * @param upperEmpExtAttr1List
     *        上级人员扩展属性1列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpExtAttr1List(List<String> upperEmpExtAttr1List) {
        this.upperEmpExtAttr1List = upperEmpExtAttr1List;
        return this;
    }

    /**
     * 设置上级人员扩展属性2。
     * 
     * @param upperEmpExtAttr2
     *        上级人员扩展属性2。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpExtAttr2(String upperEmpExtAttr2) {
        this.upperEmpExtAttr2 = upperEmpExtAttr2;
        return this;
    }

    /**
     * 设置上级人员扩展属性2列表。
     * 
     * @param upperEmpExtAttr2List
     *        上级人员扩展属性2列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpExtAttr2List(List<String> upperEmpExtAttr2List) {
        this.upperEmpExtAttr2List = upperEmpExtAttr2List;
        return this;
    }

    /**
     * 设置上级人员扩展属性3。
     * 
     * @param upperEmpExtAttr3
     *        上级人员扩展属性3。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpExtAttr3(String upperEmpExtAttr3) {
        this.upperEmpExtAttr3 = upperEmpExtAttr3;
        return this;
    }

    /**
     * 设置上级人员扩展属性3列表。
     * 
     * @param upperEmpExtAttr3List
     *        上级人员扩展属性3列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpExtAttr3List(List<String> upperEmpExtAttr3List) {
        this.upperEmpExtAttr3List = upperEmpExtAttr3List;
        return this;
    }

    /**
     * 设置上级人员扩展属性4。
     * 
     * @param upperEmpExtAttr4
     *        上级人员扩展属性4。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpExtAttr4(String upperEmpExtAttr4) {
        this.upperEmpExtAttr4 = upperEmpExtAttr4;
        return this;
    }

    /**
     * 设置上级人员扩展属性4列表。
     * 
     * @param upperEmpExtAttr4List
     *        上级人员扩展属性4列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpExtAttr4List(List<String> upperEmpExtAttr4List) {
        this.upperEmpExtAttr4List = upperEmpExtAttr4List;
        return this;
    }

    /**
     * 设置上级人员扩展属性5。
     * 
     * @param upperEmpExtAttr5
     *        上级人员扩展属性5。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpExtAttr5(String upperEmpExtAttr5) {
        this.upperEmpExtAttr5 = upperEmpExtAttr5;
        return this;
    }

    /**
     * 设置上级人员扩展属性5列表。
     * 
     * @param upperEmpExtAttr5List
     *        上级人员扩展属性5列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpExtAttr5List(List<String> upperEmpExtAttr5List) {
        this.upperEmpExtAttr5List = upperEmpExtAttr5List;
        return this;
    }

    /**
     * 设置上级人员扩展属性6。
     * 
     * @param upperEmpExtAttr6
     *        上级人员扩展属性6。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpExtAttr6(String upperEmpExtAttr6) {
        this.upperEmpExtAttr6 = upperEmpExtAttr6;
        return this;
    }

    /**
     * 设置上级人员扩展属性6列表。
     * 
     * @param upperEmpExtAttr6List
     *        上级人员扩展属性6列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpExtAttr6List(List<String> upperEmpExtAttr6List) {
        this.upperEmpExtAttr6List = upperEmpExtAttr6List;
        return this;
    }

    /**
     * 设置上级人员扩展属性7。
     * 
     * @param upperEmpExtAttr7
     *        上级人员扩展属性7。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpExtAttr7(String upperEmpExtAttr7) {
        this.upperEmpExtAttr7 = upperEmpExtAttr7;
        return this;
    }

    /**
     * 设置上级人员扩展属性7列表。
     * 
     * @param upperEmpExtAttr7List
     *        上级人员扩展属性7列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpExtAttr7List(List<String> upperEmpExtAttr7List) {
        this.upperEmpExtAttr7List = upperEmpExtAttr7List;
        return this;
    }

    /**
     * 设置上级人员扩展属性8。
     * 
     * @param upperEmpExtAttr8
     *        上级人员扩展属性8。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpExtAttr8(String upperEmpExtAttr8) {
        this.upperEmpExtAttr8 = upperEmpExtAttr8;
        return this;
    }

    /**
     * 设置上级人员扩展属性8列表。
     * 
     * @param upperEmpExtAttr8List
     *        上级人员扩展属性8列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpExtAttr8List(List<String> upperEmpExtAttr8List) {
        this.upperEmpExtAttr8List = upperEmpExtAttr8List;
        return this;
    }

    /**
     * 设置上级人员状态。
     * 
     * @param upperEmpStatus
     *        上级人员状态。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpStatus(String upperEmpStatus) {
        this.upperEmpStatus = upperEmpStatus;
        return this;
    }

    /**
     * 设置上级人员状态列表。
     * 
     * @param upperEmpStatusList
     *        上级人员状态列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpStatusList(List<String> upperEmpStatusList) {
        this.upperEmpStatusList = upperEmpStatusList;
        return this;
    }

    /**
     * 设置上级机构ID。
     * 
     * @param upperOrgId
     *        上级机构ID。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgId(String upperOrgId) {
        this.upperOrgId = upperOrgId;
        return this;
    }

    /**
     * 设置上级机构ID列表。
     * 
     * @param upperOrgIdList
     *        上级机构ID列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgIdList(List<String> upperOrgIdList) {
        this.upperOrgIdList = upperOrgIdList;
        return this;
    }

    /**
     * 设置上级上级机构ID。
     * 
     * @param upperParentOrgId
     *        上级上级机构ID。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperParentOrgId(String upperParentOrgId) {
        this.upperParentOrgId = upperParentOrgId;
        return this;
    }

    /**
     * 设置上级上级机构ID列表。
     * 
     * @param upperParentOrgIdList
     *        上级上级机构ID列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperParentOrgIdList(List<String> upperParentOrgIdList) {
        this.upperParentOrgIdList = upperParentOrgIdList;
        return this;
    }

    /**
     * 设置上级机构编码。
     * 
     * @param upperOrgCode
     *        上级机构编码。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgCode(String upperOrgCode) {
        this.upperOrgCode = upperOrgCode;
        return this;
    }

    /**
     * 设置上级机构编码列表。
     * 
     * @param upperOrgCodeList
     *        上级机构编码列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgCodeList(List<String> upperOrgCodeList) {
        this.upperOrgCodeList = upperOrgCodeList;
        return this;
    }

    /**
     * 设置上级机构名称。
     * 
     * @param upperOrgName
     *        上级机构名称。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgName(String upperOrgName) {
        this.upperOrgName = upperOrgName;
        return this;
    }

    /**
     * 设置上级机构名称列表。
     * 
     * @param upperOrgNameList
     *        上级机构名称列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgNameList(List<String> upperOrgNameList) {
        this.upperOrgNameList = upperOrgNameList;
        return this;
    }

    /**
     * 设置上级机构类型。
     * 
     * @param upperOrgType
     *        上级机构类型。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgType(String upperOrgType) {
        this.upperOrgType = upperOrgType;
        return this;
    }

    /**
     * 设置上级机构类型列表。
     * 
     * @param upperOrgTypeList
     *        上级机构类型列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgTypeList(List<String> upperOrgTypeList) {
        this.upperOrgTypeList = upperOrgTypeList;
        return this;
    }

    /**
     * 设置上级机构分类。
     * 
     * @param upperOrgCategory
     *        上级机构分类。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgCategory(String upperOrgCategory) {
        this.upperOrgCategory = upperOrgCategory;
        return this;
    }

    /**
     * 设置上级机构分类列表。
     * 
     * @param upperOrgCategoryList
     *        上级机构分类列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgCategoryList(List<String> upperOrgCategoryList) {
        this.upperOrgCategoryList = upperOrgCategoryList;
        return this;
    }

    /**
     * 设置上级机构标签。
     * 
     * @param upperOrgTag
     *        上级机构标签。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgTag(String upperOrgTag) {
        this.upperOrgTag = upperOrgTag;
        return this;
    }

    /**
     * 设置上级机构扩展属性1。
     * 
     * @param upperOrgExtAttr1
     *        上级机构扩展属性1。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgExtAttr1(String upperOrgExtAttr1) {
        this.upperOrgExtAttr1 = upperOrgExtAttr1;
        return this;
    }

    /**
     * 设置上级机构扩展属性1列表。
     * 
     * @param upperOrgExtAttr1List
     *        上级机构扩展属性1列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgExtAttr1List(List<String> upperOrgExtAttr1List) {
        this.upperOrgExtAttr1List = upperOrgExtAttr1List;
        return this;
    }

    /**
     * 设置上级机构扩展属性2。
     * 
     * @param upperOrgExtAttr2
     *        上级机构扩展属性2。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgExtAttr2(String upperOrgExtAttr2) {
        this.upperOrgExtAttr2 = upperOrgExtAttr2;
        return this;
    }

    /**
     * 设置上级机构扩展属性2列表。
     * 
     * @param upperOrgExtAttr2List
     *        上级机构扩展属性2列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgExtAttr2List(List<String> upperOrgExtAttr2List) {
        this.upperOrgExtAttr2List = upperOrgExtAttr2List;
        return this;
    }

    /**
     * 设置上级机构扩展属性3。
     * 
     * @param upperOrgExtAttr3
     *        上级机构扩展属性3。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgExtAttr3(String upperOrgExtAttr3) {
        this.upperOrgExtAttr3 = upperOrgExtAttr3;
        return this;
    }

    /**
     * 设置上级机构扩展属性3列表。
     * 
     * @param upperOrgExtAttr3List
     *        上级机构扩展属性3列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgExtAttr3List(List<String> upperOrgExtAttr3List) {
        this.upperOrgExtAttr3List = upperOrgExtAttr3List;
        return this;
    }

    /**
     * 设置上级机构扩展属性4。
     * 
     * @param upperOrgExtAttr4
     *        上级机构扩展属性4。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgExtAttr4(String upperOrgExtAttr4) {
        this.upperOrgExtAttr4 = upperOrgExtAttr4;
        return this;
    }

    /**
     * 设置上级机构扩展属性4列表。
     * 
     * @param upperOrgExtAttr4List
     *        上级机构扩展属性4列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgExtAttr4List(List<String> upperOrgExtAttr4List) {
        this.upperOrgExtAttr4List = upperOrgExtAttr4List;
        return this;
    }

    /**
     * 设置上级机构扩展属性5。
     * 
     * @param upperOrgExtAttr5
     *        上级机构扩展属性5。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgExtAttr5(String upperOrgExtAttr5) {
        this.upperOrgExtAttr5 = upperOrgExtAttr5;
        return this;
    }

    /**
     * 设置上级机构扩展属性5列表。
     * 
     * @param upperOrgExtAttr5List
     *        上级机构扩展属性5列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgExtAttr5List(List<String> upperOrgExtAttr5List) {
        this.upperOrgExtAttr5List = upperOrgExtAttr5List;
        return this;
    }

    /**
     * 设置上级机构扩展属性6。
     * 
     * @param upperOrgExtAttr6
     *        上级机构扩展属性6。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgExtAttr6(String upperOrgExtAttr6) {
        this.upperOrgExtAttr6 = upperOrgExtAttr6;
        return this;
    }

    /**
     * 设置上级机构扩展属性6列表。
     * 
     * @param upperOrgExtAttr6List
     *        上级机构扩展属性6列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgExtAttr6List(List<String> upperOrgExtAttr6List) {
        this.upperOrgExtAttr6List = upperOrgExtAttr6List;
        return this;
    }

    /**
     * 设置上级机构扩展属性7。
     * 
     * @param upperOrgExtAttr7
     *        上级机构扩展属性7。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgExtAttr7(String upperOrgExtAttr7) {
        this.upperOrgExtAttr7 = upperOrgExtAttr7;
        return this;
    }

    /**
     * 设置上级机构扩展属性7列表。
     * 
     * @param upperOrgExtAttr7List
     *        上级机构扩展属性7列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgExtAttr7List(List<String> upperOrgExtAttr7List) {
        this.upperOrgExtAttr7List = upperOrgExtAttr7List;
        return this;
    }

    /**
     * 设置上级机构扩展属性8。
     * 
     * @param upperOrgExtAttr8
     *        上级机构扩展属性8。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgExtAttr8(String upperOrgExtAttr8) {
        this.upperOrgExtAttr8 = upperOrgExtAttr8;
        return this;
    }

    /**
     * 设置上级机构扩展属性8列表。
     * 
     * @param upperOrgExtAttr8List
     *        上级机构扩展属性8列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgExtAttr8List(List<String> upperOrgExtAttr8List) {
        this.upperOrgExtAttr8List = upperOrgExtAttr8List;
        return this;
    }

    /**
     * 设置上级机构状态。
     * 
     * @param upperOrgStatus
     *        上级机构状态。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgStatus(String upperOrgStatus) {
        this.upperOrgStatus = upperOrgStatus;
        return this;
    }

    /**
     * 设置上级机构状态列表。
     * 
     * @param upperOrgStatusList
     *        上级机构状态列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgStatusList(List<String> upperOrgStatusList) {
        this.upperOrgStatusList = upperOrgStatusList;
        return this;
    }

    /**
     * 设置下级人员ID。
     * 
     * @param lowerEmpId
     *        下级人员ID。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpId(String lowerEmpId) {
        this.lowerEmpId = lowerEmpId;
        return this;
    }

    /**
     * 设置下级人员ID列表。
     * 
     * @param lowerEmpIdList
     *        下级人员ID列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpIdList(List<String> lowerEmpIdList) {
        this.lowerEmpIdList = lowerEmpIdList;
        return this;
    }

    /**
     * 设置下级人员编码。
     * 
     * @param lowerEmpCode
     *        下级人员编码。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpCode(String lowerEmpCode) {
        this.lowerEmpCode = lowerEmpCode;
        return this;
    }

    /**
     * 设置下级人员编码列表。
     * 
     * @param lowerEmpCodeList
     *        下级人员编码列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpCodeList(List<String> lowerEmpCodeList) {
        this.lowerEmpCodeList = lowerEmpCodeList;
        return this;
    }

    /**
     * 设置下级人员名称。
     * 
     * @param lowerEmpName
     *        下级人员名称。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpName(String lowerEmpName) {
        this.lowerEmpName = lowerEmpName;
        return this;
    }

    /**
     * 设置下级人员名称列表。
     * 
     * @param lowerEmpNameList
     *        下级人员名称列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpNameList(List<String> lowerEmpNameList) {
        this.lowerEmpNameList = lowerEmpNameList;
        return this;
    }

    /**
     * 设置下级人员分类。
     * 
     * @param lowerEmpCategory
     *        下级人员分类。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpCategory(String lowerEmpCategory) {
        this.lowerEmpCategory = lowerEmpCategory;
        return this;
    }

    /**
     * 设置下级人员分类列表。
     * 
     * @param lowerEmpCategoryList
     *        下级人员分类列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpCategoryList(List<String> lowerEmpCategoryList) {
        this.lowerEmpCategoryList = lowerEmpCategoryList;
        return this;
    }

    /**
     * 设置下级人员标签。
     * 
     * @param lowerEmpTag
     *        下级人员标签。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpTag(String lowerEmpTag) {
        this.lowerEmpTag = lowerEmpTag;
        return this;
    }

    /**
     * 设置下级人员扩展属性1。
     * 
     * @param lowerEmpExtAttr1
     *        下级人员扩展属性1。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpExtAttr1(String lowerEmpExtAttr1) {
        this.lowerEmpExtAttr1 = lowerEmpExtAttr1;
        return this;
    }

    /**
     * 设置下级人员扩展属性1列表。
     * 
     * @param lowerEmpExtAttr1List
     *        下级人员扩展属性1列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpExtAttr1List(List<String> lowerEmpExtAttr1List) {
        this.lowerEmpExtAttr1List = lowerEmpExtAttr1List;
        return this;
    }

    /**
     * 设置下级人员扩展属性2。
     * 
     * @param lowerEmpExtAttr2
     *        下级人员扩展属性2。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpExtAttr2(String lowerEmpExtAttr2) {
        this.lowerEmpExtAttr2 = lowerEmpExtAttr2;
        return this;
    }

    /**
     * 设置下级人员扩展属性2列表。
     * 
     * @param lowerEmpExtAttr2List
     *        下级人员扩展属性2列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpExtAttr2List(List<String> lowerEmpExtAttr2List) {
        this.lowerEmpExtAttr2List = lowerEmpExtAttr2List;
        return this;
    }

    /**
     * 设置下级人员扩展属性3。
     * 
     * @param lowerEmpExtAttr3
     *        下级人员扩展属性3。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpExtAttr3(String lowerEmpExtAttr3) {
        this.lowerEmpExtAttr3 = lowerEmpExtAttr3;
        return this;
    }

    /**
     * 设置下级人员扩展属性3列表。
     * 
     * @param lowerEmpExtAttr3List
     *        下级人员扩展属性3列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpExtAttr3List(List<String> lowerEmpExtAttr3List) {
        this.lowerEmpExtAttr3List = lowerEmpExtAttr3List;
        return this;
    }

    /**
     * 设置下级人员扩展属性4。
     * 
     * @param lowerEmpExtAttr4
     *        下级人员扩展属性4。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpExtAttr4(String lowerEmpExtAttr4) {
        this.lowerEmpExtAttr4 = lowerEmpExtAttr4;
        return this;
    }

    /**
     * 设置下级人员扩展属性4列表。
     * 
     * @param lowerEmpExtAttr4List
     *        下级人员扩展属性4列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpExtAttr4List(List<String> lowerEmpExtAttr4List) {
        this.lowerEmpExtAttr4List = lowerEmpExtAttr4List;
        return this;
    }

    /**
     * 设置下级人员扩展属性5。
     * 
     * @param lowerEmpExtAttr5
     *        下级人员扩展属性5。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpExtAttr5(String lowerEmpExtAttr5) {
        this.lowerEmpExtAttr5 = lowerEmpExtAttr5;
        return this;
    }

    /**
     * 设置下级人员扩展属性5列表。
     * 
     * @param lowerEmpExtAttr5List
     *        下级人员扩展属性5列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpExtAttr5List(List<String> lowerEmpExtAttr5List) {
        this.lowerEmpExtAttr5List = lowerEmpExtAttr5List;
        return this;
    }

    /**
     * 设置下级人员扩展属性6。
     * 
     * @param lowerEmpExtAttr6
     *        下级人员扩展属性6。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpExtAttr6(String lowerEmpExtAttr6) {
        this.lowerEmpExtAttr6 = lowerEmpExtAttr6;
        return this;
    }

    /**
     * 设置下级人员扩展属性6列表。
     * 
     * @param lowerEmpExtAttr6List
     *        下级人员扩展属性6列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpExtAttr6List(List<String> lowerEmpExtAttr6List) {
        this.lowerEmpExtAttr6List = lowerEmpExtAttr6List;
        return this;
    }

    /**
     * 设置下级人员扩展属性7。
     * 
     * @param lowerEmpExtAttr7
     *        下级人员扩展属性7。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpExtAttr7(String lowerEmpExtAttr7) {
        this.lowerEmpExtAttr7 = lowerEmpExtAttr7;
        return this;
    }

    /**
     * 设置下级人员扩展属性7列表。
     * 
     * @param lowerEmpExtAttr7List
     *        下级人员扩展属性7列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpExtAttr7List(List<String> lowerEmpExtAttr7List) {
        this.lowerEmpExtAttr7List = lowerEmpExtAttr7List;
        return this;
    }

    /**
     * 设置下级人员扩展属性8。
     * 
     * @param lowerEmpExtAttr8
     *        下级人员扩展属性8。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpExtAttr8(String lowerEmpExtAttr8) {
        this.lowerEmpExtAttr8 = lowerEmpExtAttr8;
        return this;
    }

    /**
     * 设置下级人员扩展属性8列表。
     * 
     * @param lowerEmpExtAttr8List
     *        下级人员扩展属性8列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpExtAttr8List(List<String> lowerEmpExtAttr8List) {
        this.lowerEmpExtAttr8List = lowerEmpExtAttr8List;
        return this;
    }

    /**
     * 设置下级人员状态。
     * 
     * @param lowerEmpStatus
     *        下级人员状态。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpStatus(String lowerEmpStatus) {
        this.lowerEmpStatus = lowerEmpStatus;
        return this;
    }

    /**
     * 设置下级人员状态列表。
     * 
     * @param lowerEmpStatusList
     *        下级人员状态列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpStatusList(List<String> lowerEmpStatusList) {
        this.lowerEmpStatusList = lowerEmpStatusList;
        return this;
    }

    /**
     * 设置下级机构ID。
     * 
     * @param lowerOrgId
     *        下级机构ID。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgId(String lowerOrgId) {
        this.lowerOrgId = lowerOrgId;
        return this;
    }

    /**
     * 设置下级机构ID列表。
     * 
     * @param lowerOrgIdList
     *        下级机构ID列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgIdList(List<String> lowerOrgIdList) {
        this.lowerOrgIdList = lowerOrgIdList;
        return this;
    }

    /**
     * 设置下级上级机构ID。
     * 
     * @param lowerParentOrgId
     *        下级上级机构ID。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerParentOrgId(String lowerParentOrgId) {
        this.lowerParentOrgId = lowerParentOrgId;
        return this;
    }

    /**
     * 设置下级上级机构ID列表。
     * 
     * @param lowerParentOrgIdList
     *        下级上级机构ID列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerParentOrgIdList(List<String> lowerParentOrgIdList) {
        this.lowerParentOrgIdList = lowerParentOrgIdList;
        return this;
    }

    /**
     * 设置下级机构编码。
     * 
     * @param lowerOrgCode
     *        下级机构编码。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgCode(String lowerOrgCode) {
        this.lowerOrgCode = lowerOrgCode;
        return this;
    }

    /**
     * 设置下级机构编码列表。
     * 
     * @param lowerOrgCodeList
     *        下级机构编码列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgCodeList(List<String> lowerOrgCodeList) {
        this.lowerOrgCodeList = lowerOrgCodeList;
        return this;
    }

    /**
     * 设置下级机构名称。
     * 
     * @param lowerOrgName
     *        下级机构名称。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgName(String lowerOrgName) {
        this.lowerOrgName = lowerOrgName;
        return this;
    }

    /**
     * 设置下级机构名称列表。
     * 
     * @param lowerOrgNameList
     *        下级机构名称列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgNameList(List<String> lowerOrgNameList) {
        this.lowerOrgNameList = lowerOrgNameList;
        return this;
    }

    /**
     * 设置下级机构类型。
     * 
     * @param lowerOrgType
     *        下级机构类型。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgType(String lowerOrgType) {
        this.lowerOrgType = lowerOrgType;
        return this;
    }

    /**
     * 设置下级机构类型列表。
     * 
     * @param lowerOrgTypeList
     *        下级机构类型列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgTypeList(List<String> lowerOrgTypeList) {
        this.lowerOrgTypeList = lowerOrgTypeList;
        return this;
    }

    /**
     * 设置下级机构分类。
     * 
     * @param lowerOrgCategory
     *        下级机构分类。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgCategory(String lowerOrgCategory) {
        this.lowerOrgCategory = lowerOrgCategory;
        return this;
    }

    /**
     * 设置下级机构分类列表。
     * 
     * @param lowerOrgCategoryList
     *        下级机构分类列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgCategoryList(List<String> lowerOrgCategoryList) {
        this.lowerOrgCategoryList = lowerOrgCategoryList;
        return this;
    }

    /**
     * 设置下级机构标签。
     * 
     * @param lowerOrgTag
     *        下级机构标签。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgTag(String lowerOrgTag) {
        this.lowerOrgTag = lowerOrgTag;
        return this;
    }

    /**
     * 设置下级机构扩展属性1。
     * 
     * @param lowerOrgExtAttr1
     *        下级机构扩展属性1。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgExtAttr1(String lowerOrgExtAttr1) {
        this.lowerOrgExtAttr1 = lowerOrgExtAttr1;
        return this;
    }

    /**
     * 设置下级机构扩展属性1列表。
     * 
     * @param lowerOrgExtAttr1List
     *        下级机构扩展属性1列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgExtAttr1List(List<String> lowerOrgExtAttr1List) {
        this.lowerOrgExtAttr1List = lowerOrgExtAttr1List;
        return this;
    }

    /**
     * 设置下级机构扩展属性2。
     * 
     * @param lowerOrgExtAttr2
     *        下级机构扩展属性2。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgExtAttr2(String lowerOrgExtAttr2) {
        this.lowerOrgExtAttr2 = lowerOrgExtAttr2;
        return this;
    }

    /**
     * 设置下级机构扩展属性2列表。
     * 
     * @param lowerOrgExtAttr2List
     *        下级机构扩展属性2列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgExtAttr2List(List<String> lowerOrgExtAttr2List) {
        this.lowerOrgExtAttr2List = lowerOrgExtAttr2List;
        return this;
    }

    /**
     * 设置下级机构扩展属性3。
     * 
     * @param lowerOrgExtAttr3
     *        下级机构扩展属性3。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgExtAttr3(String lowerOrgExtAttr3) {
        this.lowerOrgExtAttr3 = lowerOrgExtAttr3;
        return this;
    }

    /**
     * 设置下级机构扩展属性3列表。
     * 
     * @param lowerOrgExtAttr3List
     *        下级机构扩展属性3列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgExtAttr3List(List<String> lowerOrgExtAttr3List) {
        this.lowerOrgExtAttr3List = lowerOrgExtAttr3List;
        return this;
    }

    /**
     * 设置下级机构扩展属性4。
     * 
     * @param lowerOrgExtAttr4
     *        下级机构扩展属性4。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgExtAttr4(String lowerOrgExtAttr4) {
        this.lowerOrgExtAttr4 = lowerOrgExtAttr4;
        return this;
    }

    /**
     * 设置下级机构扩展属性4列表。
     * 
     * @param lowerOrgExtAttr4List
     *        下级机构扩展属性4列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgExtAttr4List(List<String> lowerOrgExtAttr4List) {
        this.lowerOrgExtAttr4List = lowerOrgExtAttr4List;
        return this;
    }

    /**
     * 设置下级机构扩展属性5。
     * 
     * @param lowerOrgExtAttr5
     *        下级机构扩展属性5。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgExtAttr5(String lowerOrgExtAttr5) {
        this.lowerOrgExtAttr5 = lowerOrgExtAttr5;
        return this;
    }

    /**
     * 设置下级机构扩展属性5列表。
     * 
     * @param lowerOrgExtAttr5List
     *        下级机构扩展属性5列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgExtAttr5List(List<String> lowerOrgExtAttr5List) {
        this.lowerOrgExtAttr5List = lowerOrgExtAttr5List;
        return this;
    }

    /**
     * 设置下级机构扩展属性6。
     * 
     * @param lowerOrgExtAttr6
     *        下级机构扩展属性6。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgExtAttr6(String lowerOrgExtAttr6) {
        this.lowerOrgExtAttr6 = lowerOrgExtAttr6;
        return this;
    }

    /**
     * 设置下级机构扩展属性6列表。
     * 
     * @param lowerOrgExtAttr6List
     *        下级机构扩展属性6列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgExtAttr6List(List<String> lowerOrgExtAttr6List) {
        this.lowerOrgExtAttr6List = lowerOrgExtAttr6List;
        return this;
    }

    /**
     * 设置下级机构扩展属性7。
     * 
     * @param lowerOrgExtAttr7
     *        下级机构扩展属性7。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgExtAttr7(String lowerOrgExtAttr7) {
        this.lowerOrgExtAttr7 = lowerOrgExtAttr7;
        return this;
    }

    /**
     * 设置下级机构扩展属性7列表。
     * 
     * @param lowerOrgExtAttr7List
     *        下级机构扩展属性7列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgExtAttr7List(List<String> lowerOrgExtAttr7List) {
        this.lowerOrgExtAttr7List = lowerOrgExtAttr7List;
        return this;
    }

    /**
     * 设置下级机构扩展属性8。
     * 
     * @param lowerOrgExtAttr8
     *        下级机构扩展属性8。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgExtAttr8(String lowerOrgExtAttr8) {
        this.lowerOrgExtAttr8 = lowerOrgExtAttr8;
        return this;
    }

    /**
     * 设置下级机构扩展属性8列表。
     * 
     * @param lowerOrgExtAttr8List
     *        下级机构扩展属性8列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgExtAttr8List(List<String> lowerOrgExtAttr8List) {
        this.lowerOrgExtAttr8List = lowerOrgExtAttr8List;
        return this;
    }

    /**
     * 设置下级机构状态。
     * 
     * @param lowerOrgStatus
     *        下级机构状态。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgStatus(String lowerOrgStatus) {
        this.lowerOrgStatus = lowerOrgStatus;
        return this;
    }

    /**
     * 设置下级机构状态列表。
     * 
     * @param lowerOrgStatusList
     *        下级机构状态列表。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgStatusList(List<String> lowerOrgStatusList) {
        this.lowerOrgStatusList = lowerOrgStatusList;
        return this;
    }

    /**
     * 设置所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * 
     * @param empRelationTagUnion
     *        所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setEmpRelationTagUnion(Boolean empRelationTagUnion) {
        this.empRelationTagUnion = empRelationTagUnion;
        return this;
    }

    /**
     * 设置所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * 
     * @param upperEmpTagUnion
     *        所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperEmpTagUnion(Boolean upperEmpTagUnion) {
        this.upperEmpTagUnion = upperEmpTagUnion;
        return this;
    }

    /**
     * 设置所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * 
     * @param upperOrgTagUnion
     *        所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgTagUnion(Boolean upperOrgTagUnion) {
        this.upperOrgTagUnion = upperOrgTagUnion;
        return this;
    }

    /**
     * 设置在该机构范围内查询。
     * 
     * @param upperWithinOrgId
     *        在该机构范围内查询。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperWithinOrgId(String upperWithinOrgId) {
        this.upperWithinOrgId = upperWithinOrgId;
        return this;
    }

    /**
     * 设置仅查询根，默认为false。
     * 
     * @param upperOrgRootOnly
     *        仅查询根，默认为false。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setUpperOrgRootOnly(Boolean upperOrgRootOnly) {
        this.upperOrgRootOnly = upperOrgRootOnly;
        return this;
    }

    /**
     * 设置所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * 
     * @param lowerEmpTagUnion
     *        所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerEmpTagUnion(Boolean lowerEmpTagUnion) {
        this.lowerEmpTagUnion = lowerEmpTagUnion;
        return this;
    }

    /**
     * 设置所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * 
     * @param lowerOrgTagUnion
     *        所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgTagUnion(Boolean lowerOrgTagUnion) {
        this.lowerOrgTagUnion = lowerOrgTagUnion;
        return this;
    }

    /**
     * 设置在该机构范围内查询。
     * 
     * @param lowerWithinOrgId
     *        在该机构范围内查询。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerWithinOrgId(String lowerWithinOrgId) {
        this.lowerWithinOrgId = lowerWithinOrgId;
        return this;
    }

    /**
     * 设置仅查询根，默认为false。
     * 
     * @param lowerOrgRootOnly
     *        仅查询根，默认为false。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setLowerOrgRootOnly(Boolean lowerOrgRootOnly) {
        this.lowerOrgRootOnly = lowerOrgRootOnly;
        return this;
    }

    /**
     * 设置页。默认为1。
     * 
     * @param page
     *        页。默认为1。
     * @return 当前查询实例，支持链式调用。
     */
    public EmpRelationQuery setPage(Integer page) {
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
    public EmpRelationQuery setLimit(Integer limit) {
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
    public EmpRelationQuery setOperatorId(String operatorId) {
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
    public EmpRelationQuery setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    /**
     * 查询对象列表。数据格式为Map。
     * 
     * @return Map类型数据列表。
     */
    public List<Map<String, Object>> queryForMapList() {
        return omEmpRelationService.selectEmpRelation(orgnSetId, orgnSetCode, empRelationId, empRelationIdList, empRelation, empRelationList, empRelationCategory, empRelationCategoryList, empRelationTag, empRelationExtAttr1, empRelationExtAttr1List, empRelationExtAttr2, empRelationExtAttr2List, empRelationExtAttr3, empRelationExtAttr3List, empRelationExtAttr4, empRelationExtAttr4List, empRelationExtAttr5, empRelationExtAttr5List, empRelationExtAttr6, empRelationExtAttr6List, empRelationExtAttr7, empRelationExtAttr7List, empRelationExtAttr8, empRelationExtAttr8List, empRelationStatus, empRelationStatusList, upperEmpId, upperEmpIdList, upperEmpCode, upperEmpCodeList, upperEmpName, upperEmpNameList, upperEmpCategory, upperEmpCategoryList, upperEmpTag, upperEmpExtAttr1, upperEmpExtAttr1List,
                upperEmpExtAttr2, upperEmpExtAttr2List, upperEmpExtAttr3, upperEmpExtAttr3List, upperEmpExtAttr4, upperEmpExtAttr4List, upperEmpExtAttr5, upperEmpExtAttr5List, upperEmpExtAttr6, upperEmpExtAttr6List, upperEmpExtAttr7, upperEmpExtAttr7List, upperEmpExtAttr8, upperEmpExtAttr8List, upperEmpStatus, upperEmpStatusList, upperOrgId, upperOrgIdList, upperParentOrgId, upperParentOrgIdList, upperOrgCode, upperOrgCodeList, upperOrgName, upperOrgNameList, upperOrgType, upperOrgTypeList, upperOrgCategory, upperOrgCategoryList, upperOrgTag, upperOrgExtAttr1, upperOrgExtAttr1List, upperOrgExtAttr2, upperOrgExtAttr2List, upperOrgExtAttr3, upperOrgExtAttr3List, upperOrgExtAttr4, upperOrgExtAttr4List, upperOrgExtAttr5, upperOrgExtAttr5List, upperOrgExtAttr6, upperOrgExtAttr6List,
                upperOrgExtAttr7, upperOrgExtAttr7List, upperOrgExtAttr8, upperOrgExtAttr8List, upperOrgStatus, upperOrgStatusList, lowerEmpId, lowerEmpIdList, lowerEmpCode, lowerEmpCodeList, lowerEmpName, lowerEmpNameList, lowerEmpCategory, lowerEmpCategoryList, lowerEmpTag, lowerEmpExtAttr1, lowerEmpExtAttr1List, lowerEmpExtAttr2, lowerEmpExtAttr2List, lowerEmpExtAttr3, lowerEmpExtAttr3List, lowerEmpExtAttr4, lowerEmpExtAttr4List, lowerEmpExtAttr5, lowerEmpExtAttr5List, lowerEmpExtAttr6, lowerEmpExtAttr6List, lowerEmpExtAttr7, lowerEmpExtAttr7List, lowerEmpExtAttr8, lowerEmpExtAttr8List, lowerEmpStatus, lowerEmpStatusList, lowerOrgId, lowerOrgIdList, lowerParentOrgId, lowerParentOrgIdList, lowerOrgCode, lowerOrgCodeList, lowerOrgName, lowerOrgNameList, lowerOrgType, lowerOrgTypeList,
                lowerOrgCategory, lowerOrgCategoryList, lowerOrgTag, lowerOrgExtAttr1, lowerOrgExtAttr1List, lowerOrgExtAttr2, lowerOrgExtAttr2List, lowerOrgExtAttr3, lowerOrgExtAttr3List, lowerOrgExtAttr4, lowerOrgExtAttr4List, lowerOrgExtAttr5, lowerOrgExtAttr5List, lowerOrgExtAttr6, lowerOrgExtAttr6List, lowerOrgExtAttr7, lowerOrgExtAttr7List, lowerOrgExtAttr8, lowerOrgExtAttr8List, lowerOrgStatus, lowerOrgStatusList, empRelationTagUnion, upperEmpTagUnion, upperOrgTagUnion, upperWithinOrgId, upperOrgRootOnly, lowerEmpTagUnion, lowerOrgTagUnion, lowerWithinOrgId, lowerOrgRootOnly, page, limit, operatorId, operatorName);
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
    public List<EmpRelation> queryForObjectList() {
        List<Map<String, Object>> resultList = queryForMapList();
        List<EmpRelation> empRelationList = new ArrayList<>();
        for (Map<String, Object> result : resultList) {
            empRelationList.add(new EmpRelation(result));
        }

        return empRelationList;
    }

    /**
     * 查询单个对象。数据格式为实体Bean。
     * 
     * @return 单个Bean类型数据。
     */
    public EmpRelation queryForObject() {
        List<Map<String, Object>> result = queryForMapList();
        if (result.size() == 1) {
            return new EmpRelation(result.get(0));
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
        return omEmpRelationService.countEmpRelation(orgnSetId, orgnSetCode, empRelationId, empRelationIdList, empRelation, empRelationList, empRelationCategory, empRelationCategoryList, empRelationTag, empRelationExtAttr1, empRelationExtAttr1List, empRelationExtAttr2, empRelationExtAttr2List, empRelationExtAttr3, empRelationExtAttr3List, empRelationExtAttr4, empRelationExtAttr4List, empRelationExtAttr5, empRelationExtAttr5List, empRelationExtAttr6, empRelationExtAttr6List, empRelationExtAttr7, empRelationExtAttr7List, empRelationExtAttr8, empRelationExtAttr8List, empRelationStatus, empRelationStatusList, upperEmpId, upperEmpIdList, upperEmpCode, upperEmpCodeList, upperEmpName, upperEmpNameList, upperEmpCategory, upperEmpCategoryList, upperEmpTag, upperEmpExtAttr1, upperEmpExtAttr1List,
                upperEmpExtAttr2, upperEmpExtAttr2List, upperEmpExtAttr3, upperEmpExtAttr3List, upperEmpExtAttr4, upperEmpExtAttr4List, upperEmpExtAttr5, upperEmpExtAttr5List, upperEmpExtAttr6, upperEmpExtAttr6List, upperEmpExtAttr7, upperEmpExtAttr7List, upperEmpExtAttr8, upperEmpExtAttr8List, upperEmpStatus, upperEmpStatusList, upperOrgId, upperOrgIdList, upperParentOrgId, upperParentOrgIdList, upperOrgCode, upperOrgCodeList, upperOrgName, upperOrgNameList, upperOrgType, upperOrgTypeList, upperOrgCategory, upperOrgCategoryList, upperOrgTag, upperOrgExtAttr1, upperOrgExtAttr1List, upperOrgExtAttr2, upperOrgExtAttr2List, upperOrgExtAttr3, upperOrgExtAttr3List, upperOrgExtAttr4, upperOrgExtAttr4List, upperOrgExtAttr5, upperOrgExtAttr5List, upperOrgExtAttr6, upperOrgExtAttr6List,
                upperOrgExtAttr7, upperOrgExtAttr7List, upperOrgExtAttr8, upperOrgExtAttr8List, upperOrgStatus, upperOrgStatusList, lowerEmpId, lowerEmpIdList, lowerEmpCode, lowerEmpCodeList, lowerEmpName, lowerEmpNameList, lowerEmpCategory, lowerEmpCategoryList, lowerEmpTag, lowerEmpExtAttr1, lowerEmpExtAttr1List, lowerEmpExtAttr2, lowerEmpExtAttr2List, lowerEmpExtAttr3, lowerEmpExtAttr3List, lowerEmpExtAttr4, lowerEmpExtAttr4List, lowerEmpExtAttr5, lowerEmpExtAttr5List, lowerEmpExtAttr6, lowerEmpExtAttr6List, lowerEmpExtAttr7, lowerEmpExtAttr7List, lowerEmpExtAttr8, lowerEmpExtAttr8List, lowerEmpStatus, lowerEmpStatusList, lowerOrgId, lowerOrgIdList, lowerParentOrgId, lowerParentOrgIdList, lowerOrgCode, lowerOrgCodeList, lowerOrgName, lowerOrgNameList, lowerOrgType, lowerOrgTypeList,
                lowerOrgCategory, lowerOrgCategoryList, lowerOrgTag, lowerOrgExtAttr1, lowerOrgExtAttr1List, lowerOrgExtAttr2, lowerOrgExtAttr2List, lowerOrgExtAttr3, lowerOrgExtAttr3List, lowerOrgExtAttr4, lowerOrgExtAttr4List, lowerOrgExtAttr5, lowerOrgExtAttr5List, lowerOrgExtAttr6, lowerOrgExtAttr6List, lowerOrgExtAttr7, lowerOrgExtAttr7List, lowerOrgExtAttr8, lowerOrgExtAttr8List, lowerOrgStatus, lowerOrgStatusList, empRelationTagUnion, upperEmpTagUnion, upperOrgTagUnion, upperWithinOrgId, upperOrgRootOnly, lowerEmpTagUnion, lowerOrgTagUnion, lowerWithinOrgId, lowerOrgRootOnly, operatorId, operatorName);
    }
}