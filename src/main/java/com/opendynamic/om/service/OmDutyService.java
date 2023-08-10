package com.opendynamic.om.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface OmDutyService {
    /**
     * 按主键查询,返回单个对象。
     */
    public Map<String, Object> loadDuty(String ORGN_SET_ID_, String ORGN_SET_CODE_, String DUTY_ID_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 按编码查询,返回单个对象。
     */
    public Map<String, Object> loadDutyByCode(String ORGN_SET_ID_, String ORGN_SET_CODE_, String DUTY_CODE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 通用查询，返回对象列表。
     * 
     * @param ORGN_SET_ID_
     *        组织架构套ID
     * @param ORGN_SET_CODE_
     *        组织架构套编码
     * @param DUTY_ID_
     *        职务ID
     * @param DUTY_CODE_
     *        职务编码
     * @param DUTY_NAME_
     *        职务名称
     * @param DUTY_CATEGORY_LIST
     *        分类
     * @param DUTY_TAG_
     *        职务标签
     * @param DUTY_STATUS_LIST
     *        职务状态
     * @param tagUnion
     *        所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)
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
    public List<Map<String, Object>> selectDuty(String ORGN_SET_ID_, String ORGN_SET_CODE_, String DUTY_ID_, List<String> DUTY_ID_LIST, String DUTY_CODE_, List<String> DUTY_CODE_LIST, String DUTY_NAME_, List<String> DUTY_NAME_LIST, String DUTY_CATEGORY_, List<String> DUTY_CATEGORY_LIST, String DUTY_TAG_, String DUTY_EXT_ATTR_1_, List<String> DUTY_EXT_ATTR_1_LIST, String DUTY_EXT_ATTR_2_, List<String> DUTY_EXT_ATTR_2_LIST, String DUTY_EXT_ATTR_3_, List<String> DUTY_EXT_ATTR_3_LIST, String DUTY_EXT_ATTR_4_, List<String> DUTY_EXT_ATTR_4_LIST, String DUTY_EXT_ATTR_5_, List<String> DUTY_EXT_ATTR_5_LIST, String DUTY_EXT_ATTR_6_, List<String> DUTY_EXT_ATTR_6_LIST, String DUTY_EXT_ATTR_7_, List<String> DUTY_EXT_ATTR_7_LIST, String DUTY_EXT_ATTR_8_, List<String> DUTY_EXT_ATTR_8_LIST,
            String DUTY_STATUS_, List<String> DUTY_STATUS_LIST, Boolean dutyTagUnion, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 总数查询，在分页时与通用查询配套使用。
     */
    public int countDuty(String ORGN_SET_ID_, String ORGN_SET_CODE_, String DUTY_ID_, List<String> DUTY_ID_LIST, String DUTY_CODE_, List<String> DUTY_CODE_LIST, String DUTY_NAME_, List<String> DUTY_NAME_LIST, String DUTY_CATEGORY_, List<String> DUTY_CATEGORY_LIST, String DUTY_TAG_, String DUTY_EXT_ATTR_1_, List<String> DUTY_EXT_ATTR_1_LIST, String DUTY_EXT_ATTR_2_, List<String> DUTY_EXT_ATTR_2_LIST, String DUTY_EXT_ATTR_3_, List<String> DUTY_EXT_ATTR_3_LIST, String DUTY_EXT_ATTR_4_, List<String> DUTY_EXT_ATTR_4_LIST, String DUTY_EXT_ATTR_5_, List<String> DUTY_EXT_ATTR_5_LIST, String DUTY_EXT_ATTR_6_, List<String> DUTY_EXT_ATTR_6_LIST, String DUTY_EXT_ATTR_7_, List<String> DUTY_EXT_ATTR_7_LIST, String DUTY_EXT_ATTR_8_, List<String> DUTY_EXT_ATTR_8_LIST, String DUTY_STATUS_,
            List<String> DUTY_STATUS_LIST, Boolean dutyTagUnion, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 按主键列表查询，返回对象列表，按主键列表顺序排序。
     */
    public List<Map<String, Object>> selectDutyByIdList(String ORGN_SET_ID_, List<String> DUTY_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 按主键列表查询，返回对象列表，按主键列表顺序排序。
     */
    public List<Map<String, Object>> selectProtoDutyByIdList(String ORGN_SET_ID_, List<String> DUTY_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 新增对象。
     */
    public int insertDuty(String ORGN_SET_ID_, String DUTY_ID_, String DUTY_CODE_, String DUTY_NAME_, String DUTY_CATEGORY_, String MEMO_, String DUTY_TAG_, String DUTY_EXT_ATTR_1_, String DUTY_EXT_ATTR_2_, String DUTY_EXT_ATTR_3_, String DUTY_EXT_ATTR_4_, String DUTY_EXT_ATTR_5_, String DUTY_EXT_ATTR_6_, String DUTY_EXT_ATTR_7_, String DUTY_EXT_ATTR_8_, Integer ORDER_, String DUTY_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 修改对象。
     */
    public int updateDuty(String ORGN_SET_ID_, String DUTY_ID_, String DUTY_CODE_, String DUTY_NAME_, String DUTY_CATEGORY_, String MEMO_, String DUTY_TAG_, String DUTY_EXT_ATTR_1_, String DUTY_EXT_ATTR_2_, String DUTY_EXT_ATTR_3_, String DUTY_EXT_ATTR_4_, String DUTY_EXT_ATTR_5_, String DUTY_EXT_ATTR_6_, String DUTY_EXT_ATTR_7_, String DUTY_EXT_ATTR_8_, Integer ORDER_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 拖动排序。
     */
    public int updateDutyOrder(String ORGN_SET_ID_, List<String> DUTY_ID_LIST, List<Integer> ORDER_LIST, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 废弃对象。
     */
    public int disableDuty(String ORGN_SET_ID_, String DUTY_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 恢复对象。
     */
    public int enableDuty(String ORGN_SET_ID_, String DUTY_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 删除对象。
     */
    public int deleteDuty(String ORGN_SET_ID_, String DUTY_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);
}