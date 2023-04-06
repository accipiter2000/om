package com.opendynamic.om.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface OmPosiService {
    /**
     * 按主键查询,返回单个对象。
     */
    public Map<String, Object> loadPosi(String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_ID_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 按编码查询,返回单个对象。
     */
    public Map<String, Object> loadPosiByCode(String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_CODE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 通用查询，返回对象列表。
     * 
     * @param ORGN_SET_ID_
     *        组织架构套ID
     * @param ORGN_SET_CODE_
     *        组织架构套编码
     * @param POSI_ID_
     *        岗位ID
     * @param ORG_ID_
     *        机构ID
     * @param DUTY_ID_
     *        职务ID
     * @param POSI_CODE_
     *        岗位编码
     * @param POSI_NAME_
     *        岗位名称
     * @param DUTY_LEVEL_LIST
     *        职级
     * @param CATEGORY_LIST
     *        分类
     * @param POSI_TAG_
     *        岗位标签
     * @param POSI_STATUS_LIST
     *        岗位状态
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
    public List<Map<String, Object>> selectPosi(String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_ID_, String ORG_ID_, String DUTY_ID_, String POSI_CODE_, String POSI_NAME_, List<String> DUTY_LEVEL_LIST, List<String> CATEGORY_LIST, String POSI_TAG_, List<String> POSI_STATUS_LIST, Boolean tagUnion, String withinOrgId, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 总数查询，在分页时与通用查询配套使用。
     */
    public int countPosi(String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_ID_, String ORG_ID_, String DUTY_ID_, String POSI_CODE_, String POSI_NAME_, List<String> DUTY_LEVEL_LIST, List<String> CATEGORY_LIST, String POSI_TAG_, List<String> POSI_STATUS_LIST, Boolean tagUnion, String withinOrgId, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 按主键列表查询，返回对象列表，按主键列表顺序排序。
     */
    public List<Map<String, Object>> selectPosiByIdList(String ORGN_SET_ID_, List<String> POSI_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 按主键列表查询，返回对象列表，按主键列表顺序排序。
     */
    public List<Map<String, Object>> selectProtoPosiByIdList(String ORGN_SET_ID_, List<String> POSI_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 新增对象。
     */
    public int insertPosi(String ORGN_SET_ID_, String POSI_ID_, String ORG_ID_, String DUTY_ID_, String POSI_CODE_, String POSI_NAME_, String DUTY_LEVEL_, String CATEGORY_, String MEMO_, String POSI_TAG_, Integer ORDER_, String POSI_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 修改对象。
     */
    public int updatePosi(String ORGN_SET_ID_, String POSI_ID_, String DUTY_ID_, String POSI_CODE_, String POSI_NAME_, String DUTY_LEVEL_, String CATEGORY_, String MEMO_, String POSI_TAG_, Integer ORDER_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 拖动排序。
     */
    public int updatePosiOrder(String ORGN_SET_ID_, List<String> POSI_ID_LIST, List<Integer> ORDER_LIST, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 移动对象
     */
    public int movePosi(String ORGN_SET_ID_, String POSI_ID_, String ORG_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 废弃对象。
     */
    public int disablePosi(String ORGN_SET_ID_, String POSI_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 恢复对象。
     */
    public int enablePosi(String ORGN_SET_ID_, String POSI_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 删除对象。
     */
    public int deletePosi(String ORGN_SET_ID_, String POSI_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);
}