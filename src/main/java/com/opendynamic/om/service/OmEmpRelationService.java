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
     */
    public List<Map<String, Object>> selectEmpRelation(String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_RELATION_ID_, List<String> EMP_RELATION_ID_LIST, String EMP_RELATION_, List<String> EMP_RELATION_LIST, String EMP_RELATION_CATEGORY_, List<String> EMP_RELATION_CATEGORY_LIST, String EMP_RELATION_TAG_, String EMP_RELATION_EXT_ATTR_1_, List<String> EMP_RELATION_EXT_ATTR_1_LIST, String EMP_RELATION_EXT_ATTR_2_, List<String> EMP_RELATION_EXT_ATTR_2_LIST, String EMP_RELATION_EXT_ATTR_3_, List<String> EMP_RELATION_EXT_ATTR_3_LIST, String EMP_RELATION_EXT_ATTR_4_, List<String> EMP_RELATION_EXT_ATTR_4_LIST, String EMP_RELATION_EXT_ATTR_5_, List<String> EMP_RELATION_EXT_ATTR_5_LIST, String EMP_RELATION_EXT_ATTR_6_, List<String> EMP_RELATION_EXT_ATTR_6_LIST, String EMP_RELATION_EXT_ATTR_7_,
            List<String> EMP_RELATION_EXT_ATTR_7_LIST, String EMP_RELATION_EXT_ATTR_8_, List<String> EMP_RELATION_EXT_ATTR_8_LIST, String EMP_RELATION_STATUS_, List<String> EMP_RELATION_STATUS_LIST, String UPPER_EMP_ID_, List<String> UPPER_EMP_ID_LIST, String UPPER_EMP_CODE_, List<String> UPPER_EMP_CODE_LIST, String UPPER_EMP_NAME_, List<String> UPPER_EMP_NAME_LIST, String UPPER_EMP_CATEGORY_, List<String> UPPER_EMP_CATEGORY_LIST, String UPPER_EMP_TAG_, String UPPER_EMP_EXT_ATTR_1_, List<String> UPPER_EMP_EXT_ATTR_1_LIST, String UPPER_EMP_EXT_ATTR_2_, List<String> UPPER_EMP_EXT_ATTR_2_LIST, String UPPER_EMP_EXT_ATTR_3_, List<String> UPPER_EMP_EXT_ATTR_3_LIST, String UPPER_EMP_EXT_ATTR_4_, List<String> UPPER_EMP_EXT_ATTR_4_LIST, String UPPER_EMP_EXT_ATTR_5_,
            List<String> UPPER_EMP_EXT_ATTR_5_LIST, String UPPER_EMP_EXT_ATTR_6_, List<String> UPPER_EMP_EXT_ATTR_6_LIST, String UPPER_EMP_EXT_ATTR_7_, List<String> UPPER_EMP_EXT_ATTR_7_LIST, String UPPER_EMP_EXT_ATTR_8_, List<String> UPPER_EMP_EXT_ATTR_8_LIST, String UPPER_EMP_STATUS_, List<String> UPPER_EMP_STATUS_LIST, String UPPER_ORG_ID_, List<String> UPPER_ORG_ID_LIST, String UPPER_PARENT_ORG_ID_, List<String> UPPER_PARENT_ORG_ID_LIST, String UPPER_ORG_CODE_, List<String> UPPER_ORG_CODE_LIST, String UPPER_ORG_NAME_, List<String> UPPER_ORG_NAME_LIST, String UPPER_ORG_TYPE_, List<String> UPPER_ORG_TYPE_LIST, String UPPER_ORG_CATEGORY_, List<String> UPPER_ORG_CATEGORY_LIST, String UPPER_ORG_TAG_, String UPPER_ORG_EXT_ATTR_1_, List<String> UPPER_ORG_EXT_ATTR_1_LIST,
            String UPPER_ORG_EXT_ATTR_2_, List<String> UPPER_ORG_EXT_ATTR_2_LIST, String UPPER_ORG_EXT_ATTR_3_, List<String> UPPER_ORG_EXT_ATTR_3_LIST, String UPPER_ORG_EXT_ATTR_4_, List<String> UPPER_ORG_EXT_ATTR_4_LIST, String UPPER_ORG_EXT_ATTR_5_, List<String> UPPER_ORG_EXT_ATTR_5_LIST, String UPPER_ORG_EXT_ATTR_6_, List<String> UPPER_ORG_EXT_ATTR_6_LIST, String UPPER_ORG_EXT_ATTR_7_, List<String> UPPER_ORG_EXT_ATTR_7_LIST, String UPPER_ORG_EXT_ATTR_8_, List<String> UPPER_ORG_EXT_ATTR_8_LIST, String UPPER_ORG_STATUS_, List<String> UPPER_ORG_STATUS_LIST, String LOWER_EMP_ID_, List<String> LOWER_EMP_ID_LIST, String LOWER_EMP_CODE_, List<String> LOWER_EMP_CODE_LIST, String LOWER_EMP_NAME_, List<String> LOWER_EMP_NAME_LIST, String LOWER_EMP_CATEGORY_, List<String> LOWER_EMP_CATEGORY_LIST,
            String LOWER_EMP_TAG_, String LOWER_EMP_EXT_ATTR_1_, List<String> LOWER_EMP_EXT_ATTR_1_LIST, String LOWER_EMP_EXT_ATTR_2_, List<String> LOWER_EMP_EXT_ATTR_2_LIST, String LOWER_EMP_EXT_ATTR_3_, List<String> LOWER_EMP_EXT_ATTR_3_LIST, String LOWER_EMP_EXT_ATTR_4_, List<String> LOWER_EMP_EXT_ATTR_4_LIST, String LOWER_EMP_EXT_ATTR_5_, List<String> LOWER_EMP_EXT_ATTR_5_LIST, String LOWER_EMP_EXT_ATTR_6_, List<String> LOWER_EMP_EXT_ATTR_6_LIST, String LOWER_EMP_EXT_ATTR_7_, List<String> LOWER_EMP_EXT_ATTR_7_LIST, String LOWER_EMP_EXT_ATTR_8_, List<String> LOWER_EMP_EXT_ATTR_8_LIST, String LOWER_EMP_STATUS_, List<String> LOWER_EMP_STATUS_LIST, String LOWER_ORG_ID_, List<String> LOWER_ORG_ID_LIST, String LOWER_PARENT_ORG_ID_, List<String> LOWER_PARENT_ORG_ID_LIST,
            String LOWER_ORG_CODE_, List<String> LOWER_ORG_CODE_LIST, String LOWER_ORG_NAME_, List<String> LOWER_ORG_NAME_LIST, String LOWER_ORG_TYPE_, List<String> LOWER_ORG_TYPE_LIST, String LOWER_ORG_CATEGORY_, List<String> LOWER_ORG_CATEGORY_LIST, String LOWER_ORG_TAG_, String LOWER_ORG_EXT_ATTR_1_, List<String> LOWER_ORG_EXT_ATTR_1_LIST, String LOWER_ORG_EXT_ATTR_2_, List<String> LOWER_ORG_EXT_ATTR_2_LIST, String LOWER_ORG_EXT_ATTR_3_, List<String> LOWER_ORG_EXT_ATTR_3_LIST, String LOWER_ORG_EXT_ATTR_4_, List<String> LOWER_ORG_EXT_ATTR_4_LIST, String LOWER_ORG_EXT_ATTR_5_, List<String> LOWER_ORG_EXT_ATTR_5_LIST, String LOWER_ORG_EXT_ATTR_6_, List<String> LOWER_ORG_EXT_ATTR_6_LIST, String LOWER_ORG_EXT_ATTR_7_, List<String> LOWER_ORG_EXT_ATTR_7_LIST, String LOWER_ORG_EXT_ATTR_8_,
            List<String> LOWER_ORG_EXT_ATTR_8_LIST, String LOWER_ORG_STATUS_, List<String> LOWER_ORG_STATUS_LIST, Boolean empRelationTagUnion, Boolean upperEmpTagUnion, Boolean upperOrgTagUnion, String upperWithinOrgId, Boolean upperOrgRootOnly, Boolean lowerEmpTagUnion, Boolean lowerOrgTagUnion, String lowerWithinOrgId, Boolean lowerOrgRootOnly, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 总数查询，在分页时与通用查询配套使用。
     */
    public int countEmpRelation(String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_RELATION_ID_, List<String> EMP_RELATION_ID_LIST, String EMP_RELATION_, List<String> EMP_RELATION_LIST, String EMP_RELATION_CATEGORY_, List<String> EMP_RELATION_CATEGORY_LIST, String EMP_RELATION_TAG_, String EMP_RELATION_EXT_ATTR_1_, List<String> EMP_RELATION_EXT_ATTR_1_LIST, String EMP_RELATION_EXT_ATTR_2_, List<String> EMP_RELATION_EXT_ATTR_2_LIST, String EMP_RELATION_EXT_ATTR_3_, List<String> EMP_RELATION_EXT_ATTR_3_LIST, String EMP_RELATION_EXT_ATTR_4_, List<String> EMP_RELATION_EXT_ATTR_4_LIST, String EMP_RELATION_EXT_ATTR_5_, List<String> EMP_RELATION_EXT_ATTR_5_LIST, String EMP_RELATION_EXT_ATTR_6_, List<String> EMP_RELATION_EXT_ATTR_6_LIST, String EMP_RELATION_EXT_ATTR_7_,
            List<String> EMP_RELATION_EXT_ATTR_7_LIST, String EMP_RELATION_EXT_ATTR_8_, List<String> EMP_RELATION_EXT_ATTR_8_LIST, String EMP_RELATION_STATUS_, List<String> EMP_RELATION_STATUS_LIST, String UPPER_EMP_ID_, List<String> UPPER_EMP_ID_LIST, String UPPER_EMP_CODE_, List<String> UPPER_EMP_CODE_LIST, String UPPER_EMP_NAME_, List<String> UPPER_EMP_NAME_LIST, String UPPER_EMP_CATEGORY_, List<String> UPPER_EMP_CATEGORY_LIST, String UPPER_EMP_TAG_, String UPPER_EMP_EXT_ATTR_1_, List<String> UPPER_EMP_EXT_ATTR_1_LIST, String UPPER_EMP_EXT_ATTR_2_, List<String> UPPER_EMP_EXT_ATTR_2_LIST, String UPPER_EMP_EXT_ATTR_3_, List<String> UPPER_EMP_EXT_ATTR_3_LIST, String UPPER_EMP_EXT_ATTR_4_, List<String> UPPER_EMP_EXT_ATTR_4_LIST, String UPPER_EMP_EXT_ATTR_5_,
            List<String> UPPER_EMP_EXT_ATTR_5_LIST, String UPPER_EMP_EXT_ATTR_6_, List<String> UPPER_EMP_EXT_ATTR_6_LIST, String UPPER_EMP_EXT_ATTR_7_, List<String> UPPER_EMP_EXT_ATTR_7_LIST, String UPPER_EMP_EXT_ATTR_8_, List<String> UPPER_EMP_EXT_ATTR_8_LIST, String UPPER_EMP_STATUS_, List<String> UPPER_EMP_STATUS_LIST, String UPPER_ORG_ID_, List<String> UPPER_ORG_ID_LIST, String UPPER_PARENT_ORG_ID_, List<String> UPPER_PARENT_ORG_ID_LIST, String UPPER_ORG_CODE_, List<String> UPPER_ORG_CODE_LIST, String UPPER_ORG_NAME_, List<String> UPPER_ORG_NAME_LIST, String UPPER_ORG_TYPE_, List<String> UPPER_ORG_TYPE_LIST, String UPPER_ORG_CATEGORY_, List<String> UPPER_ORG_CATEGORY_LIST, String UPPER_ORG_TAG_, String UPPER_ORG_EXT_ATTR_1_, List<String> UPPER_ORG_EXT_ATTR_1_LIST,
            String UPPER_ORG_EXT_ATTR_2_, List<String> UPPER_ORG_EXT_ATTR_2_LIST, String UPPER_ORG_EXT_ATTR_3_, List<String> UPPER_ORG_EXT_ATTR_3_LIST, String UPPER_ORG_EXT_ATTR_4_, List<String> UPPER_ORG_EXT_ATTR_4_LIST, String UPPER_ORG_EXT_ATTR_5_, List<String> UPPER_ORG_EXT_ATTR_5_LIST, String UPPER_ORG_EXT_ATTR_6_, List<String> UPPER_ORG_EXT_ATTR_6_LIST, String UPPER_ORG_EXT_ATTR_7_, List<String> UPPER_ORG_EXT_ATTR_7_LIST, String UPPER_ORG_EXT_ATTR_8_, List<String> UPPER_ORG_EXT_ATTR_8_LIST, String UPPER_ORG_STATUS_, List<String> UPPER_ORG_STATUS_LIST, String LOWER_EMP_ID_, List<String> LOWER_EMP_ID_LIST, String LOWER_EMP_CODE_, List<String> LOWER_EMP_CODE_LIST, String LOWER_EMP_NAME_, List<String> LOWER_EMP_NAME_LIST, String LOWER_EMP_CATEGORY_, List<String> LOWER_EMP_CATEGORY_LIST,
            String LOWER_EMP_TAG_, String LOWER_EMP_EXT_ATTR_1_, List<String> LOWER_EMP_EXT_ATTR_1_LIST, String LOWER_EMP_EXT_ATTR_2_, List<String> LOWER_EMP_EXT_ATTR_2_LIST, String LOWER_EMP_EXT_ATTR_3_, List<String> LOWER_EMP_EXT_ATTR_3_LIST, String LOWER_EMP_EXT_ATTR_4_, List<String> LOWER_EMP_EXT_ATTR_4_LIST, String LOWER_EMP_EXT_ATTR_5_, List<String> LOWER_EMP_EXT_ATTR_5_LIST, String LOWER_EMP_EXT_ATTR_6_, List<String> LOWER_EMP_EXT_ATTR_6_LIST, String LOWER_EMP_EXT_ATTR_7_, List<String> LOWER_EMP_EXT_ATTR_7_LIST, String LOWER_EMP_EXT_ATTR_8_, List<String> LOWER_EMP_EXT_ATTR_8_LIST, String LOWER_EMP_STATUS_, List<String> LOWER_EMP_STATUS_LIST, String LOWER_ORG_ID_, List<String> LOWER_ORG_ID_LIST, String LOWER_PARENT_ORG_ID_, List<String> LOWER_PARENT_ORG_ID_LIST,
            String LOWER_ORG_CODE_, List<String> LOWER_ORG_CODE_LIST, String LOWER_ORG_NAME_, List<String> LOWER_ORG_NAME_LIST, String LOWER_ORG_TYPE_, List<String> LOWER_ORG_TYPE_LIST, String LOWER_ORG_CATEGORY_, List<String> LOWER_ORG_CATEGORY_LIST, String LOWER_ORG_TAG_, String LOWER_ORG_EXT_ATTR_1_, List<String> LOWER_ORG_EXT_ATTR_1_LIST, String LOWER_ORG_EXT_ATTR_2_, List<String> LOWER_ORG_EXT_ATTR_2_LIST, String LOWER_ORG_EXT_ATTR_3_, List<String> LOWER_ORG_EXT_ATTR_3_LIST, String LOWER_ORG_EXT_ATTR_4_, List<String> LOWER_ORG_EXT_ATTR_4_LIST, String LOWER_ORG_EXT_ATTR_5_, List<String> LOWER_ORG_EXT_ATTR_5_LIST, String LOWER_ORG_EXT_ATTR_6_, List<String> LOWER_ORG_EXT_ATTR_6_LIST, String LOWER_ORG_EXT_ATTR_7_, List<String> LOWER_ORG_EXT_ATTR_7_LIST, String LOWER_ORG_EXT_ATTR_8_,
            List<String> LOWER_ORG_EXT_ATTR_8_LIST, String LOWER_ORG_STATUS_, List<String> LOWER_ORG_STATUS_LIST, Boolean empRelationTagUnion, Boolean upperEmpTagUnion, Boolean upperOrgTagUnion, String upperWithinOrgId, Boolean upperOrgRootOnly, Boolean lowerEmpTagUnion, Boolean lowerOrgTagUnion, String lowerWithinOrgId, Boolean lowerOrgRootOnly, String OPERATOR_ID_, String OPERATOR_NAME_);

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
    public int insertEmpRelation(String ORGN_SET_ID_, String EMP_RELATION_ID_, String UPPER_EMP_ID_, String LOWER_EMP_ID_, String EMP_RELATION_, String EMP_RELATION_CATEGORY_, String MEMO_, String EMP_RELATION_TAG_, String EMP_RELATION_EXT_ATTR_1_, String EMP_RELATION_EXT_ATTR_2_, String EMP_RELATION_EXT_ATTR_3_, String EMP_RELATION_EXT_ATTR_4_, String EMP_RELATION_EXT_ATTR_5_, String EMP_RELATION_EXT_ATTR_6_, String EMP_RELATION_EXT_ATTR_7_, String EMP_RELATION_EXT_ATTR_8_, Integer ORDER_, String EMP_RELATION_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 修改对象。
     */
    public int updateEmpRelation(String ORGN_SET_ID_, String EMP_RELATION_ID_, String EMP_RELATION_, String EMP_RELATION_CATEGORY_, String MEMO_, String EMP_RELATION_TAG_, String EMP_RELATION_EXT_ATTR_1_, String EMP_RELATION_EXT_ATTR_2_, String EMP_RELATION_EXT_ATTR_3_, String EMP_RELATION_EXT_ATTR_4_, String EMP_RELATION_EXT_ATTR_5_, String EMP_RELATION_EXT_ATTR_6_, String EMP_RELATION_EXT_ATTR_7_, String EMP_RELATION_EXT_ATTR_8_, Integer ORDER_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

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