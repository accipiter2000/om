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
    public List<Map<String, Object>> selectPosiEmp(String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_EMP_ID_, String ORG_ID_, String DUTY_ID_, String POSI_ID_, String EMP_ID_, List<String> ORG_CODE_LIST, List<String> DUTY_CODE_LIST, List<String> POSI_CODE_LIST, List<String> EMP_CODE_LIST, List<String> MAIN_LIST, String POSI_EMP_TAG_, List<String> POSI_EMP_STATUS_LIST, String EMP_NAME_, List<String> CATEGORY_LIST, String EMP_TAG_, List<String> EMP_STATUS_LIST, Boolean tagUnion, String withinOrgId, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 总数查询，在分页时与通用查询配套使用。
     */
    public int countPosiEmp(String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_EMP_ID_, String ORG_ID_, String DUTY_ID_, String POSI_ID_, String EMP_ID_, List<String> ORG_CODE_LIST, List<String> DUTY_CODE_LIST, List<String> POSI_CODE_LIST, List<String> EMP_CODE_LIST, List<String> MAIN_LIST, String POSI_EMP_TAG_, List<String> POSI_EMP_STATUS_LIST, String EMP_NAME_, List<String> CATEGORY_LIST, String EMP_TAG_, List<String> EMP_STATUS_LIST, Boolean tagUnion, String withinOrgId, String OPERATOR_ID_, String OPERATOR_NAME_);

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
    public int insertPosiEmp(String ORGN_SET_ID_, String POSI_EMP_ID_, String POSI_ID_, String EMP_ID_, String MAIN_, String POSI_EMP_TAG_, String POSI_EMP_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

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
    public int updatePosiEmp(String ORGN_SET_ID_, String POSI_EMP_ID_, String MAIN_, String POSI_EMP_TAG_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

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