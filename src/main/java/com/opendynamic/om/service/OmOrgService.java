package com.opendynamic.om.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface OmOrgService {
    /**
     * 按主键查询,返回单个对象。
     */
    public Map<String, Object> loadOrg(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORG_ID_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 按编码查询,返回单个对象。
     */
    public Map<String, Object> loadOrgByCode(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORG_CODE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 通用查询，返回对象列表。
     */
    public List<Map<String, Object>> selectOrg(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORG_ID_, List<String> ORG_ID_LIST, String PARENT_ORG_ID_, List<String> PARENT_ORG_ID_LIST, String ORG_CODE_, List<String> ORG_CODE_LIST, String ORG_NAME_, List<String> ORG_NAME_LIST, String ORG_TYPE_, List<String> ORG_TYPE_LIST, String ORG_CATEGORY_, List<String> ORG_CATEGORY_LIST, String ORG_TAG_, String ORG_EXT_ATTR_1_, List<String> ORG_EXT_ATTR_1_LIST, String ORG_EXT_ATTR_2_, List<String> ORG_EXT_ATTR_2_LIST, String ORG_EXT_ATTR_3_, List<String> ORG_EXT_ATTR_3_LIST, String ORG_EXT_ATTR_4_, List<String> ORG_EXT_ATTR_4_LIST, String ORG_EXT_ATTR_5_, List<String> ORG_EXT_ATTR_5_LIST, String ORG_EXT_ATTR_6_, List<String> ORG_EXT_ATTR_6_LIST, String ORG_EXT_ATTR_7_,
            List<String> ORG_EXT_ATTR_7_LIST, String ORG_EXT_ATTR_8_, List<String> ORG_EXT_ATTR_8_LIST, String ORG_STATUS_, List<String> ORG_STATUS_LIST, Boolean orgTagUnion, String withinOrgId, Boolean orgRootOnly, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 总数查询，在分页时与通用查询配套使用。
     */
    public int countOrg(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORG_ID_, List<String> ORG_ID_LIST, String PARENT_ORG_ID_, List<String> PARENT_ORG_ID_LIST, String ORG_CODE_, List<String> ORG_CODE_LIST, String ORG_NAME_, List<String> ORG_NAME_LIST, String ORG_TYPE_, List<String> ORG_TYPE_LIST, String ORG_CATEGORY_, List<String> ORG_CATEGORY_LIST, String ORG_TAG_, String ORG_EXT_ATTR_1_, List<String> ORG_EXT_ATTR_1_LIST, String ORG_EXT_ATTR_2_, List<String> ORG_EXT_ATTR_2_LIST, String ORG_EXT_ATTR_3_, List<String> ORG_EXT_ATTR_3_LIST, String ORG_EXT_ATTR_4_, List<String> ORG_EXT_ATTR_4_LIST, String ORG_EXT_ATTR_5_, List<String> ORG_EXT_ATTR_5_LIST, String ORG_EXT_ATTR_6_, List<String> ORG_EXT_ATTR_6_LIST, String ORG_EXT_ATTR_7_, List<String> ORG_EXT_ATTR_7_LIST,
            String ORG_EXT_ATTR_8_, List<String> ORG_EXT_ATTR_8_LIST, String ORG_STATUS_, List<String> ORG_STATUS_LIST, Boolean orgTagUnion, String withinOrgId, Boolean orgRootOnly, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 通用上级对象查询，返回上级对象列表。
     */
    public List<Map<String, Object>> selectParentOrg(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORG_ID_, String ORG_CODE_, List<String> ORG_CODE_LIST, String ORG_NAME_, List<String> ORG_NAME_LIST, String ORG_TYPE_, List<String> ORG_TYPE_LIST, String ORG_CATEGORY_, List<String> ORG_CATEGORY_LIST, String ORG_TAG_, String ORG_EXT_ATTR_1_, List<String> ORG_EXT_ATTR_1_LIST, String ORG_EXT_ATTR_2_, List<String> ORG_EXT_ATTR_2_LIST, String ORG_EXT_ATTR_3_, List<String> ORG_EXT_ATTR_3_LIST, String ORG_EXT_ATTR_4_, List<String> ORG_EXT_ATTR_4_LIST, String ORG_EXT_ATTR_5_, List<String> ORG_EXT_ATTR_5_LIST, String ORG_EXT_ATTR_6_, List<String> ORG_EXT_ATTR_6_LIST, String ORG_EXT_ATTR_7_, List<String> ORG_EXT_ATTR_7_LIST, String ORG_EXT_ATTR_8_, List<String> ORG_EXT_ATTR_8_LIST,
            String ORG_STATUS_, List<String> ORG_STATUS_LIST, Boolean orgTagUnion, String withinOrgId, Boolean orgRootOnly, Boolean recursive, Boolean includeSelf, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 通用下级对象查询，返回下级对象列表。
     */
    public List<Map<String, Object>> selectChildOrg(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORG_ID_, String ORG_CODE_, List<String> ORG_CODE_LIST, String ORG_NAME_, List<String> ORG_NAME_LIST, String ORG_TYPE_, List<String> ORG_TYPE_LIST, String ORG_CATEGORY_, List<String> ORG_CATEGORY_LIST, String ORG_TAG_, String ORG_EXT_ATTR_1_, List<String> ORG_EXT_ATTR_1_LIST, String ORG_EXT_ATTR_2_, List<String> ORG_EXT_ATTR_2_LIST, String ORG_EXT_ATTR_3_, List<String> ORG_EXT_ATTR_3_LIST, String ORG_EXT_ATTR_4_, List<String> ORG_EXT_ATTR_4_LIST, String ORG_EXT_ATTR_5_, List<String> ORG_EXT_ATTR_5_LIST, String ORG_EXT_ATTR_6_, List<String> ORG_EXT_ATTR_6_LIST, String ORG_EXT_ATTR_7_, List<String> ORG_EXT_ATTR_7_LIST, String ORG_EXT_ATTR_8_, List<String> ORG_EXT_ATTR_8_LIST,
            String ORG_STATUS_, List<String> ORG_STATUS_LIST, Boolean orgTagUnion, String withinOrgId, Boolean orgRootOnly, Boolean recursive, Boolean includeSelf, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 按主键列表查询，返回对象列表，按主键列表顺序排序。
     */
    public List<Map<String, Object>> selectOrgByIdList(String ORGN_SET_ID_, List<String> ORG_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 按主键列表查询，返回对象列表，按主键列表顺序排序。
     */
    public List<Map<String, Object>> selectProtoOrgByIdList(String ORGN_SET_ID_, List<String> ORG_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 新增对象。
     */
    public int insertOrg(String ORGN_SET_ID_, String ORG_ID_, String PARENT_ORG_ID_, String ORG_CODE_, String ORG_NAME_, String ORG_ABBR_NAME_, String ORG_TYPE_, String ORG_CATEGORY_, String MEMO_, String ORG_TAG_, String ORG_EXT_ATTR_1_, String ORG_EXT_ATTR_2_, String ORG_EXT_ATTR_3_, String ORG_EXT_ATTR_4_, String ORG_EXT_ATTR_5_, String ORG_EXT_ATTR_6_, String ORG_EXT_ATTR_7_, String ORG_EXT_ATTR_8_, Integer ORDER_, String ORG_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 修改对象。
     */
    public int updateOrg(String ORGN_SET_ID_, String ORG_ID_, String ORG_CODE_, String ORG_NAME_, String ORG_ABBR_NAME_, String ORG_TYPE_, String ORG_CATEGORY_, String MEMO_, String ORG_TAG_, String ORG_EXT_ATTR_1_, String ORG_EXT_ATTR_2_, String ORG_EXT_ATTR_3_, String ORG_EXT_ATTR_4_, String ORG_EXT_ATTR_5_, String ORG_EXT_ATTR_6_, String ORG_EXT_ATTR_7_, String ORG_EXT_ATTR_8_, Integer ORDER_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 拖动排序。
     */
    public int updateOrgOrder(String ORGN_SET_ID_, List<String> ORG_ID_LIST, List<Integer> ORDER_LIST, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 移动对象。
     */
    public int moveOrg(String ORGN_SET_ID_, String ORG_ID_, String PARENT_ORG_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 废弃对象。
     */
    public int disableOrg(String ORGN_SET_ID_, String ORG_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 恢复对象。
     */
    public int enableOrg(String ORGN_SET_ID_, String ORG_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 删除对象。
     */
    public int deleteOrg(String ORGN_SET_ID_, String ORG_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);
}