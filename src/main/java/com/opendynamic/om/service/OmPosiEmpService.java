package com.opendynamic.om.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface OmPosiEmpService {
    /**
     * 按主键查询,返回单个对象。
     */
    public Map<String, Object> loadPosiEmp(String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_EMP_ID_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 通用查询，返回对象列表。
     * 
     * @param ORGN_SET_ID_
     *        组织架构套ID
     * @param ORGN_SET_CODE_
     *        组织架构套编码
     * @param POSI_EMP_ID_
     *        岗位人员ID
     * @param ORG_ID_
     *        机构ID
     * @param DUTY_ID_
     *        职务ID
     * @param POSI_ID_
     *        岗位ID
     * @param EMP_ID_
     *        人员ID
     * @param ORG_CODE_LIST
     *        机构编码列表
     * @param DUTY_CODE_LIST
     *        职务编码列表
     * @param POSI_CODE_LIST
     *        岗位编码列表
     * @param ORG_LEADER_TYPE_LIST
     *        机构领导类型
     * @param EMP_CODE_LIST
     *        人员编码列表
     * @param MAIN_LIST
     *        主岗位
     * @param POSI_EMP_TAG_
     *        岗位人员标签
     * @param POSI_EMP_STATUS_LIST
     *        岗位人员状态
     * @param EMP_NAME_
     *        人员名称
     * @param CATEGORY_LIST
     *        分类
     * @param EMP_TAG_
     *        人员标签
     * @param EMP_STATUS_LIST
     *        人员状态
     * @param tagUnion
     *        所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)
     * @param withinOrgId
     *        递归在该机构的下级机构中查询
     * @param page
     *        页面 默认为1
     * @param limit
     *        每页数据数量 默认为-1(全部)
     * @param OPERATOR_ID_
     *        操作人员ID
     * @param OPERATOR_NAME_
     *        操作人员名称
     * @return
     */
    public List<Map<String, Object>> selectPosiEmp(String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_EMP_ID_, List<String> POSI_EMP_ID_LIST, String MAIN_, List<String> MAIN_LIST, String POSI_EMP_CATEGORY_, List<String> POSI_EMP_CATEGORY_LIST, String POSI_EMP_TAG_, String POSI_EMP_EXT_ATTR_1_, List<String> POSI_EMP_EXT_ATTR_1_LIST, String POSI_EMP_EXT_ATTR_2_, List<String> POSI_EMP_EXT_ATTR_2_LIST, String POSI_EMP_EXT_ATTR_3_, List<String> POSI_EMP_EXT_ATTR_3_LIST, String POSI_EMP_EXT_ATTR_4_, List<String> POSI_EMP_EXT_ATTR_4_LIST, String POSI_EMP_EXT_ATTR_5_, List<String> POSI_EMP_EXT_ATTR_5_LIST, String POSI_EMP_EXT_ATTR_6_, List<String> POSI_EMP_EXT_ATTR_6_LIST, String POSI_EMP_EXT_ATTR_7_, List<String> POSI_EMP_EXT_ATTR_7_LIST, String POSI_EMP_EXT_ATTR_8_,
            List<String> POSI_EMP_EXT_ATTR_8_LIST, String POSI_EMP_STATUS_, List<String> POSI_EMP_STATUS_LIST, String EMP_ID_, List<String> EMP_ID_LIST, String EMP_CODE_, List<String> EMP_CODE_LIST, String EMP_NAME_, List<String> EMP_NAME_LIST, String EMP_CATEGORY_, List<String> EMP_CATEGORY_LIST, String EMP_TAG_, String EMP_EXT_ATTR_1_, List<String> EMP_EXT_ATTR_1_LIST, String EMP_EXT_ATTR_2_, List<String> EMP_EXT_ATTR_2_LIST, String EMP_EXT_ATTR_3_, List<String> EMP_EXT_ATTR_3_LIST, String EMP_EXT_ATTR_4_, List<String> EMP_EXT_ATTR_4_LIST, String EMP_EXT_ATTR_5_, List<String> EMP_EXT_ATTR_5_LIST, String EMP_EXT_ATTR_6_, List<String> EMP_EXT_ATTR_6_LIST, String EMP_EXT_ATTR_7_, List<String> EMP_EXT_ATTR_7_LIST, String EMP_EXT_ATTR_8_, List<String> EMP_EXT_ATTR_8_LIST, String EMP_STATUS_,
            List<String> EMP_STATUS_LIST, String POSI_ID_, List<String> POSI_ID_LIST, String POSI_CODE_, List<String> POSI_CODE_LIST, String POSI_NAME_, List<String> POSI_NAME_LIST, String ORG_LEADER_TYPE_, List<String> ORG_LEADER_TYPE_LIST, String POSI_CATEGORY_, List<String> POSI_CATEGORY_LIST, String POSI_TAG_, String POSI_EXT_ATTR_1_, List<String> POSI_EXT_ATTR_1_LIST, String POSI_EXT_ATTR_2_, List<String> POSI_EXT_ATTR_2_LIST, String POSI_EXT_ATTR_3_, List<String> POSI_EXT_ATTR_3_LIST, String POSI_EXT_ATTR_4_, List<String> POSI_EXT_ATTR_4_LIST, String POSI_EXT_ATTR_5_, List<String> POSI_EXT_ATTR_5_LIST, String POSI_EXT_ATTR_6_, List<String> POSI_EXT_ATTR_6_LIST, String POSI_EXT_ATTR_7_, List<String> POSI_EXT_ATTR_7_LIST, String POSI_EXT_ATTR_8_, List<String> POSI_EXT_ATTR_8_LIST,
            String POSI_STATUS_, List<String> POSI_STATUS_LIST, String DUTY_ID_, List<String> DUTY_ID_LIST, String DUTY_CODE_, List<String> DUTY_CODE_LIST, String DUTY_NAME_, List<String> DUTY_NAME_LIST, String DUTY_CATEGORY_, List<String> DUTY_CATEGORY_LIST, String DUTY_TAG_, String DUTY_EXT_ATTR_1_, List<String> DUTY_EXT_ATTR_1_LIST, String DUTY_EXT_ATTR_2_, List<String> DUTY_EXT_ATTR_2_LIST, String DUTY_EXT_ATTR_3_, List<String> DUTY_EXT_ATTR_3_LIST, String DUTY_EXT_ATTR_4_, List<String> DUTY_EXT_ATTR_4_LIST, String DUTY_EXT_ATTR_5_, List<String> DUTY_EXT_ATTR_5_LIST, String DUTY_EXT_ATTR_6_, List<String> DUTY_EXT_ATTR_6_LIST, String DUTY_EXT_ATTR_7_, List<String> DUTY_EXT_ATTR_7_LIST, String DUTY_EXT_ATTR_8_, List<String> DUTY_EXT_ATTR_8_LIST, String DUTY_STATUS_,
            List<String> DUTY_STATUS_LIST, String ORG_ID_, List<String> ORG_ID_LIST, String PARENT_ORG_ID_, List<String> PARENT_ORG_ID_LIST, String ORG_CODE_, List<String> ORG_CODE_LIST, String ORG_NAME_, List<String> ORG_NAME_LIST, String ORG_TYPE_, List<String> ORG_TYPE_LIST, String ORG_CATEGORY_, List<String> ORG_CATEGORY_LIST, String ORG_TAG_, String ORG_EXT_ATTR_1_, List<String> ORG_EXT_ATTR_1_LIST, String ORG_EXT_ATTR_2_, List<String> ORG_EXT_ATTR_2_LIST, String ORG_EXT_ATTR_3_, List<String> ORG_EXT_ATTR_3_LIST, String ORG_EXT_ATTR_4_, List<String> ORG_EXT_ATTR_4_LIST, String ORG_EXT_ATTR_5_, List<String> ORG_EXT_ATTR_5_LIST, String ORG_EXT_ATTR_6_, List<String> ORG_EXT_ATTR_6_LIST, String ORG_EXT_ATTR_7_, List<String> ORG_EXT_ATTR_7_LIST, String ORG_EXT_ATTR_8_,
            List<String> ORG_EXT_ATTR_8_LIST, String ORG_STATUS_, List<String> ORG_STATUS_LIST, Boolean posiEmpTagUnion, Boolean empTagUnion, Boolean posiTagUnion, Boolean dutyTagUnion, Boolean orgTagUnion, String withinOrgId, Boolean orgRootOnly, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 总数查询，在分页时与通用查询配套使用。
     */
    public int countPosiEmp(String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_EMP_ID_, List<String> POSI_EMP_ID_LIST, String MAIN_, List<String> MAIN_LIST, String POSI_EMP_CATEGORY_, List<String> POSI_EMP_CATEGORY_LIST, String POSI_EMP_TAG_, String POSI_EMP_EXT_ATTR_1_, List<String> POSI_EMP_EXT_ATTR_1_LIST, String POSI_EMP_EXT_ATTR_2_, List<String> POSI_EMP_EXT_ATTR_2_LIST, String POSI_EMP_EXT_ATTR_3_, List<String> POSI_EMP_EXT_ATTR_3_LIST, String POSI_EMP_EXT_ATTR_4_, List<String> POSI_EMP_EXT_ATTR_4_LIST, String POSI_EMP_EXT_ATTR_5_, List<String> POSI_EMP_EXT_ATTR_5_LIST, String POSI_EMP_EXT_ATTR_6_, List<String> POSI_EMP_EXT_ATTR_6_LIST, String POSI_EMP_EXT_ATTR_7_, List<String> POSI_EMP_EXT_ATTR_7_LIST, String POSI_EMP_EXT_ATTR_8_, List<String> POSI_EMP_EXT_ATTR_8_LIST,
            String POSI_EMP_STATUS_, List<String> POSI_EMP_STATUS_LIST, String EMP_ID_, List<String> EMP_ID_LIST, String EMP_CODE_, List<String> EMP_CODE_LIST, String EMP_NAME_, List<String> EMP_NAME_LIST, String EMP_CATEGORY_, List<String> EMP_CATEGORY_LIST, String EMP_TAG_, String EMP_EXT_ATTR_1_, List<String> EMP_EXT_ATTR_1_LIST, String EMP_EXT_ATTR_2_, List<String> EMP_EXT_ATTR_2_LIST, String EMP_EXT_ATTR_3_, List<String> EMP_EXT_ATTR_3_LIST, String EMP_EXT_ATTR_4_, List<String> EMP_EXT_ATTR_4_LIST, String EMP_EXT_ATTR_5_, List<String> EMP_EXT_ATTR_5_LIST, String EMP_EXT_ATTR_6_, List<String> EMP_EXT_ATTR_6_LIST, String EMP_EXT_ATTR_7_, List<String> EMP_EXT_ATTR_7_LIST, String EMP_EXT_ATTR_8_, List<String> EMP_EXT_ATTR_8_LIST, String EMP_STATUS_, List<String> EMP_STATUS_LIST,
            String POSI_ID_, List<String> POSI_ID_LIST, String POSI_CODE_, List<String> POSI_CODE_LIST, String POSI_NAME_, List<String> POSI_NAME_LIST, String ORG_LEADER_TYPE_, List<String> ORG_LEADER_TYPE_LIST, String POSI_CATEGORY_, List<String> POSI_CATEGORY_LIST, String POSI_TAG_, String POSI_EXT_ATTR_1_, List<String> POSI_EXT_ATTR_1_LIST, String POSI_EXT_ATTR_2_, List<String> POSI_EXT_ATTR_2_LIST, String POSI_EXT_ATTR_3_, List<String> POSI_EXT_ATTR_3_LIST, String POSI_EXT_ATTR_4_, List<String> POSI_EXT_ATTR_4_LIST, String POSI_EXT_ATTR_5_, List<String> POSI_EXT_ATTR_5_LIST, String POSI_EXT_ATTR_6_, List<String> POSI_EXT_ATTR_6_LIST, String POSI_EXT_ATTR_7_, List<String> POSI_EXT_ATTR_7_LIST, String POSI_EXT_ATTR_8_, List<String> POSI_EXT_ATTR_8_LIST, String POSI_STATUS_,
            List<String> POSI_STATUS_LIST, String DUTY_ID_, List<String> DUTY_ID_LIST, String DUTY_CODE_, List<String> DUTY_CODE_LIST, String DUTY_NAME_, List<String> DUTY_NAME_LIST, String DUTY_CATEGORY_, List<String> DUTY_CATEGORY_LIST, String DUTY_TAG_, String DUTY_EXT_ATTR_1_, List<String> DUTY_EXT_ATTR_1_LIST, String DUTY_EXT_ATTR_2_, List<String> DUTY_EXT_ATTR_2_LIST, String DUTY_EXT_ATTR_3_, List<String> DUTY_EXT_ATTR_3_LIST, String DUTY_EXT_ATTR_4_, List<String> DUTY_EXT_ATTR_4_LIST, String DUTY_EXT_ATTR_5_, List<String> DUTY_EXT_ATTR_5_LIST, String DUTY_EXT_ATTR_6_, List<String> DUTY_EXT_ATTR_6_LIST, String DUTY_EXT_ATTR_7_, List<String> DUTY_EXT_ATTR_7_LIST, String DUTY_EXT_ATTR_8_, List<String> DUTY_EXT_ATTR_8_LIST, String DUTY_STATUS_, List<String> DUTY_STATUS_LIST,
            String ORG_ID_, List<String> ORG_ID_LIST, String PARENT_ORG_ID_, List<String> PARENT_ORG_ID_LIST, String ORG_CODE_, List<String> ORG_CODE_LIST, String ORG_NAME_, List<String> ORG_NAME_LIST, String ORG_TYPE_, List<String> ORG_TYPE_LIST, String ORG_CATEGORY_, List<String> ORG_CATEGORY_LIST, String ORG_TAG_, String ORG_EXT_ATTR_1_, List<String> ORG_EXT_ATTR_1_LIST, String ORG_EXT_ATTR_2_, List<String> ORG_EXT_ATTR_2_LIST, String ORG_EXT_ATTR_3_, List<String> ORG_EXT_ATTR_3_LIST, String ORG_EXT_ATTR_4_, List<String> ORG_EXT_ATTR_4_LIST, String ORG_EXT_ATTR_5_, List<String> ORG_EXT_ATTR_5_LIST, String ORG_EXT_ATTR_6_, List<String> ORG_EXT_ATTR_6_LIST, String ORG_EXT_ATTR_7_, List<String> ORG_EXT_ATTR_7_LIST, String ORG_EXT_ATTR_8_, List<String> ORG_EXT_ATTR_8_LIST,
            String ORG_STATUS_, List<String> ORG_STATUS_LIST, Boolean posiEmpTagUnion, Boolean empTagUnion, Boolean posiTagUnion, Boolean dutyTagUnion, Boolean orgTagUnion, String withinOrgId,Boolean orgRootOnly,  String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 按主键列表查询，返回对象列表，按主键列表顺序排序。
     */
    public List<Map<String, Object>> selectPosiEmpByIdList(String ORGN_SET_ID_, List<String> POSI_EMP_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 按主键列表查询，返回对象列表，按主键列表顺序排序。
     */
    public List<Map<String, Object>> selectProtoPosiEmpByIdList(String ORGN_SET_ID_, List<String> POSI_EMP_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 新增对象。
     */
    public int insertPosiEmp(String ORGN_SET_ID_, String POSI_EMP_ID_, String POSI_ID_, String EMP_ID_, String MAIN_, String POSI_EMP_CATEGORY_, String MEMO_, String POSI_EMP_TAG_, String POSI_EMP_EXT_ATTR_1_, String POSI_EMP_EXT_ATTR_2_, String POSI_EMP_EXT_ATTR_3_, String POSI_EMP_EXT_ATTR_4_, String POSI_EMP_EXT_ATTR_5_, String POSI_EMP_EXT_ATTR_6_, String POSI_EMP_EXT_ATTR_7_, String POSI_EMP_EXT_ATTR_8_, Integer ORDER_, String POSI_EMP_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 批量新增对象。
     */
    public int insertPosiEmpByEmpIdList(String ORGN_SET_ID_, String POSI_ID_, List<String> EMP_ID_LIST, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 批量新增对象。
     */
    public int insertPosiEmpByPosiIdList(String ORGN_SET_ID_, String EMP_ID_, List<String> POSI_ID_LIST, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 修改对象。
     */
    public int updatePosiEmp(String ORGN_SET_ID_, String POSI_EMP_ID_, String MAIN_, String POSI_EMP_CATEGORY_, String MEMO_, String POSI_EMP_TAG_, String POSI_EMP_EXT_ATTR_1_, String POSI_EMP_EXT_ATTR_2_, String POSI_EMP_EXT_ATTR_3_, String POSI_EMP_EXT_ATTR_4_, String POSI_EMP_EXT_ATTR_5_, String POSI_EMP_EXT_ATTR_6_, String POSI_EMP_EXT_ATTR_7_, String POSI_EMP_EXT_ATTR_8_, Integer ORDER_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 设置主岗位。
     */
    public int updatePosiEmpMain(String ORGN_SET_ID_, String POSI_EMP_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 废弃对象。
     */
    public int disablePosiEmp(String ORGN_SET_ID_, String POSI_EMP_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 恢复对象。
     */
    public int enablePosiEmp(String ORGN_SET_ID_, String POSI_EMP_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 删除对象。
     */
    public int deletePosiEmp(String ORGN_SET_ID_, String POSI_EMP_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 批量删除对象。
     */
    public int deletePosiEmpByIdList(String ORGN_SET_ID_, List<String> POSI_EMP_ID_LIST, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);
}