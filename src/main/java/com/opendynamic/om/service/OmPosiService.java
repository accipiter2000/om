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
     */
    public List<Map<String, Object>> selectPosi(String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_ID_, List<String> POSI_ID_LIST, String POSI_CODE_, List<String> POSI_CODE_LIST, String POSI_NAME_, List<String> POSI_NAME_LIST, String ORG_LEADER_TYPE_, List<String> ORG_LEADER_TYPE_LIST, String POSI_CATEGORY_, List<String> POSI_CATEGORY_LIST, String POSI_TAG_, String POSI_EXT_ATTR_1_, List<String> POSI_EXT_ATTR_1_LIST, String POSI_EXT_ATTR_2_, List<String> POSI_EXT_ATTR_2_LIST, String POSI_EXT_ATTR_3_, List<String> POSI_EXT_ATTR_3_LIST, String POSI_EXT_ATTR_4_, List<String> POSI_EXT_ATTR_4_LIST, String POSI_EXT_ATTR_5_, List<String> POSI_EXT_ATTR_5_LIST, String POSI_EXT_ATTR_6_, List<String> POSI_EXT_ATTR_6_LIST, String POSI_EXT_ATTR_7_, List<String> POSI_EXT_ATTR_7_LIST,
            String POSI_EXT_ATTR_8_, List<String> POSI_EXT_ATTR_8_LIST, String POSI_STATUS_, List<String> POSI_STATUS_LIST, String DUTY_ID_, List<String> DUTY_ID_LIST, String DUTY_CODE_, List<String> DUTY_CODE_LIST, String DUTY_NAME_, List<String> DUTY_NAME_LIST, String DUTY_CATEGORY_, List<String> DUTY_CATEGORY_LIST, String DUTY_TAG_, String DUTY_EXT_ATTR_1_, List<String> DUTY_EXT_ATTR_1_LIST, String DUTY_EXT_ATTR_2_, List<String> DUTY_EXT_ATTR_2_LIST, String DUTY_EXT_ATTR_3_, List<String> DUTY_EXT_ATTR_3_LIST, String DUTY_EXT_ATTR_4_, List<String> DUTY_EXT_ATTR_4_LIST, String DUTY_EXT_ATTR_5_, List<String> DUTY_EXT_ATTR_5_LIST, String DUTY_EXT_ATTR_6_, List<String> DUTY_EXT_ATTR_6_LIST, String DUTY_EXT_ATTR_7_, List<String> DUTY_EXT_ATTR_7_LIST, String DUTY_EXT_ATTR_8_,
            List<String> DUTY_EXT_ATTR_8_LIST, String DUTY_STATUS_, List<String> DUTY_STATUS_LIST, String ORG_ID_, List<String> ORG_ID_LIST, String PARENT_ORG_ID_, List<String> PARENT_ORG_ID_LIST, String ORG_CODE_, List<String> ORG_CODE_LIST, String ORG_NAME_, List<String> ORG_NAME_LIST, String ORG_TYPE_, List<String> ORG_TYPE_LIST, String ORG_CATEGORY_, List<String> ORG_CATEGORY_LIST, String ORG_TAG_, String ORG_EXT_ATTR_1_, List<String> ORG_EXT_ATTR_1_LIST, String ORG_EXT_ATTR_2_, List<String> ORG_EXT_ATTR_2_LIST, String ORG_EXT_ATTR_3_, List<String> ORG_EXT_ATTR_3_LIST, String ORG_EXT_ATTR_4_, List<String> ORG_EXT_ATTR_4_LIST, String ORG_EXT_ATTR_5_, List<String> ORG_EXT_ATTR_5_LIST, String ORG_EXT_ATTR_6_, List<String> ORG_EXT_ATTR_6_LIST, String ORG_EXT_ATTR_7_,
            List<String> ORG_EXT_ATTR_7_LIST, String ORG_EXT_ATTR_8_, List<String> ORG_EXT_ATTR_8_LIST, String ORG_STATUS_, List<String> ORG_STATUS_LIST, Boolean posiTagUnion, Boolean dutyTagUnion, Boolean orgTagUnion, String withinOrgId, Boolean orgRootOnly, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 总数查询，在分页时与通用查询配套使用。
     */
    public int countPosi(String ORGN_SET_ID_, String ORGN_SET_CODE_, String POSI_ID_, List<String> POSI_ID_LIST, String POSI_CODE_, List<String> POSI_CODE_LIST, String POSI_NAME_, List<String> POSI_NAME_LIST, String ORG_LEADER_TYPE_, List<String> ORG_LEADER_TYPE_LIST, String POSI_CATEGORY_, List<String> POSI_CATEGORY_LIST, String POSI_TAG_, String POSI_EXT_ATTR_1_, List<String> POSI_EXT_ATTR_1_LIST, String POSI_EXT_ATTR_2_, List<String> POSI_EXT_ATTR_2_LIST, String POSI_EXT_ATTR_3_, List<String> POSI_EXT_ATTR_3_LIST, String POSI_EXT_ATTR_4_, List<String> POSI_EXT_ATTR_4_LIST, String POSI_EXT_ATTR_5_, List<String> POSI_EXT_ATTR_5_LIST, String POSI_EXT_ATTR_6_, List<String> POSI_EXT_ATTR_6_LIST, String POSI_EXT_ATTR_7_, List<String> POSI_EXT_ATTR_7_LIST, String POSI_EXT_ATTR_8_,
            List<String> POSI_EXT_ATTR_8_LIST, String POSI_STATUS_, List<String> POSI_STATUS_LIST, String DUTY_ID_, List<String> DUTY_ID_LIST, String DUTY_CODE_, List<String> DUTY_CODE_LIST, String DUTY_NAME_, List<String> DUTY_NAME_LIST, String DUTY_CATEGORY_, List<String> DUTY_CATEGORY_LIST, String DUTY_TAG_, String DUTY_EXT_ATTR_1_, List<String> DUTY_EXT_ATTR_1_LIST, String DUTY_EXT_ATTR_2_, List<String> DUTY_EXT_ATTR_2_LIST, String DUTY_EXT_ATTR_3_, List<String> DUTY_EXT_ATTR_3_LIST, String DUTY_EXT_ATTR_4_, List<String> DUTY_EXT_ATTR_4_LIST, String DUTY_EXT_ATTR_5_, List<String> DUTY_EXT_ATTR_5_LIST, String DUTY_EXT_ATTR_6_, List<String> DUTY_EXT_ATTR_6_LIST, String DUTY_EXT_ATTR_7_, List<String> DUTY_EXT_ATTR_7_LIST, String DUTY_EXT_ATTR_8_, List<String> DUTY_EXT_ATTR_8_LIST,
            String DUTY_STATUS_, List<String> DUTY_STATUS_LIST, String ORG_ID_, List<String> ORG_ID_LIST, String PARENT_ORG_ID_, List<String> PARENT_ORG_ID_LIST, String ORG_CODE_, List<String> ORG_CODE_LIST, String ORG_NAME_, List<String> ORG_NAME_LIST, String ORG_TYPE_, List<String> ORG_TYPE_LIST, String ORG_CATEGORY_, List<String> ORG_CATEGORY_LIST, String ORG_TAG_, String ORG_EXT_ATTR_1_, List<String> ORG_EXT_ATTR_1_LIST, String ORG_EXT_ATTR_2_, List<String> ORG_EXT_ATTR_2_LIST, String ORG_EXT_ATTR_3_, List<String> ORG_EXT_ATTR_3_LIST, String ORG_EXT_ATTR_4_, List<String> ORG_EXT_ATTR_4_LIST, String ORG_EXT_ATTR_5_, List<String> ORG_EXT_ATTR_5_LIST, String ORG_EXT_ATTR_6_, List<String> ORG_EXT_ATTR_6_LIST, String ORG_EXT_ATTR_7_, List<String> ORG_EXT_ATTR_7_LIST, String ORG_EXT_ATTR_8_,
            List<String> ORG_EXT_ATTR_8_LIST, String ORG_STATUS_, List<String> ORG_STATUS_LIST, Boolean posiTagUnion, Boolean dutyTagUnion, Boolean orgTagUnion, String withinOrgId, Boolean orgRootOnly, String OPERATOR_ID_, String OPERATOR_NAME_);

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
    public int insertPosi(String ORGN_SET_ID_, String POSI_ID_, String ORG_ID_, String DUTY_ID_, String POSI_CODE_, String POSI_NAME_, String ORG_LEADER_TYPE_, String POSI_CATEGORY_, String MEMO_, String POSI_TAG_, String POSI_EXT_ATTR_1_, String POSI_EXT_ATTR_2_, String POSI_EXT_ATTR_3_, String POSI_EXT_ATTR_4_, String POSI_EXT_ATTR_5_, String POSI_EXT_ATTR_6_, String POSI_EXT_ATTR_7_, String POSI_EXT_ATTR_8_, Integer ORDER_, String POSI_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 修改对象。
     */
    public int updatePosi(String ORGN_SET_ID_, String POSI_ID_, String DUTY_ID_, String POSI_CODE_, String POSI_NAME_, String ORG_LEADER_TYPE_, String POSI_CATEGORY_, String MEMO_, String POSI_TAG_, String POSI_EXT_ATTR_1_, String POSI_EXT_ATTR_2_, String POSI_EXT_ATTR_3_, String POSI_EXT_ATTR_4_, String POSI_EXT_ATTR_5_, String POSI_EXT_ATTR_6_, String POSI_EXT_ATTR_7_, String POSI_EXT_ATTR_8_, Integer ORDER_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

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