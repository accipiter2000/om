package com.opendynamic.om.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface OmEmpRelationService {
    /**
     * 按主键查询,返回单个对象。
     */
    public Map<String, Object> loadEmpRelation(String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_RELATION_ID_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 通用查询，返回对象列表。
     * 
     * @param ORGN_SET_ID_
     *        组织架构套ID
     * @param ORGN_SET_CODE_
     *        组织架构套编码
     * @param EMP_RELATION_ID_
     *        人员关系ID
     * @param UPPER_EMP_ID_
     *        上级人员ID
     * @param LOWER_EMP_ID_
     *        下级人员ID
     * @param EMP_RELATION_LIST
     *        人员关系
     * @param EMP_RELATION_TAG_
     *        人员关系标签
     * @param EMP_RELATION_STATUS_LIST
     *        人员关系状态
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
    public List<Map<String, Object>> selectEmpRelation(String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_RELATION_ID_, String UPPER_EMP_ID_, String LOWER_EMP_ID_, List<String> EMP_RELATION_LIST, String EMP_RELATION_TAG_, List<String> EMP_RELATION_STATUS_LIST, Boolean tagUnion, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 总数查询，在分页时与通用查询配套使用。
     */
    public int countEmpRelation(String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_RELATION_ID_, String UPPER_EMP_ID_, String LOWER_EMP_ID_, List<String> EMP_RELATION_LIST, String EMP_RELATION_TAG_, List<String> EMP_RELATION_STATUS_LIST, Boolean tagUnion, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 按主键列表查询，返回对象列表，按主键列表顺序排序。
     */
    public List<Map<String, Object>> selectEmpRelationByIdList(String ORGN_SET_ID_, List<String> EMP_RELATION_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 按主键列表查询，返回对象列表，按主键列表顺序排序。
     */
    public List<Map<String, Object>> selectProtoEmpRelationByIdList(String ORGN_SET_ID_, List<String> EMP_RELATION_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 新增对象。
     */
    public int insertEmpRelation(String ORGN_SET_ID_, String EMP_RELATION_ID_, String UPPER_EMP_ID_, String LOWER_EMP_ID_, String EMP_RELATION_, String EMP_RELATION_TAG_, String EMP_RELATION_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 修改对象。
     */
    public int updateEmpRelation(String ORGN_SET_ID_, String EMP_RELATION_ID_, String EMP_RELATION_, String EMP_RELATION_TAG_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 拖动排序。
     */
    public int updateEmpRelationOrder(String ORGN_SET_ID_, List<String> EMP_RELATION_ID_LIST, List<Integer> ORDER_LIST, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 废弃对象。
     */
    public int disableEmpRelation(String ORGN_SET_ID_, String EMP_RELATION_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 恢复对象。
     */
    public int enableEmpRelation(String ORGN_SET_ID_, String EMP_RELATION_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 删除对象。
     */
    public int deleteEmpRelation(String ORGN_SET_ID_, String EMP_RELATION_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 删除对象。
     */
    public int deleteEmpRelationByEmpId(String ORGN_SET_ID_, String EMP_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);
}