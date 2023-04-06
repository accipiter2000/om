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
     * 
     * @param ORGN_SET_ID_
     *        组织架构套ID
     * @param ORGN_SET_CODE_
     *        组织架构套编码
     * @param ORG_ID_
     *        机构ID
     * @param PARENT_ORG_ID_
     *        上级机构ID
     * @param ORG_CODE_
     *        机构编码
     * @param ORG_NAME_
     *        机构名称
     * @param ORG_TYPE_LIST
     *        机构类型
     * @param CATEGORY_LIST
     *        分类
     * @param ORG_TAG_
     *        机构标签
     * @param ORG_STATUS_LIST
     *        机构状态
     * @param tagUnion
     *        所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)
     * @param rootOnly
     *        仅查询根，默认为false
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
    public List<Map<String, Object>> selectOrg(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORG_ID_, String PARENT_ORG_ID_, String ORG_CODE_, String ORG_NAME_, List<String> ORG_TYPE_LIST, List<String> CATEGORY_LIST, String ORG_TAG_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, String EXT_ATTR_7_, String EXT_ATTR_8_, List<String> ORG_STATUS_LIST, Boolean tagUnion, Boolean rootOnly, String withinOrgId, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 总数查询，在分页时与通用查询配套使用。
     */
    public int countOrg(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORG_ID_, String PARENT_ORG_ID_, String ORG_CODE_, String ORG_NAME_, List<String> ORG_TYPE_LIST, List<String> CATEGORY_LIST, String ORG_TAG_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, String EXT_ATTR_7_, String EXT_ATTR_8_, List<String> ORG_STATUS_LIST, Boolean tagUnion, Boolean rootOnly, String withinOrgId, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 通用父对象查询，返回父对象列表。
     * 
     * @param tagUnion
     *        所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)
     * @param includeSelf
     *        是否包含自己，默认为false。
     * @param recursive
     *        是否递归，默认为false。
     * @param withinOrgId
     *        递归在该机构的下级机构中查询
     */
    public List<Map<String, Object>> selectParentOrg(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORG_ID_, String ORG_CODE_, String ORG_NAME_, List<String> ORG_TYPE_LIST, List<String> CATEGORY_LIST, String ORG_TAG_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, String EXT_ATTR_7_, String EXT_ATTR_8_, List<String> ORG_STATUS_LIST, Boolean tagUnion, String withinOrgId, Boolean includeSelf, Boolean recursive, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 通用子对象查询，返回子对象列表。
     * 
     * @param tagUnion
     *        所有标签匹配还是任意标签匹配，默认为true(所有标签匹配)
     * @param includeSelf
     *        是否包含自己，默认为false。
     * @param recursive
     *        是否递归，默认为false。
     * @param withinOrgId
     *        递归在该机构的下级机构中查询
     */
    public List<Map<String, Object>> selectChildOrg(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORG_ID_, String ORG_CODE_, String ORG_NAME_, List<String> ORG_TYPE_LIST, List<String> CATEGORY_LIST, String ORG_TAG_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, String EXT_ATTR_7_, String EXT_ATTR_8_, List<String> ORG_STATUS_LIST, Boolean tagUnion, String withinOrgId, Boolean includeSelf, Boolean recursive, String OPERATOR_ID_, String OPERATOR_NAME_);

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
    public int insertOrg(String ORGN_SET_ID_, String ORG_ID_, String PARENT_ORG_ID_, String ORG_CODE_, String ORG_NAME_, String ORG_ABBR_NAME_, String ORG_TYPE_, String CATEGORY_, String MEMO_, String ORG_TAG_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, String EXT_ATTR_7_, String EXT_ATTR_8_, Integer ORDER_, String ORG_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 修改对象。
     */
    public int updateOrg(String ORGN_SET_ID_, String ORG_ID_, String ORG_CODE_, String ORG_NAME_, String ORG_ABBR_NAME_, String ORG_TYPE_, String CATEGORY_, String MEMO_, String ORG_TAG_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, String EXT_ATTR_7_, String EXT_ATTR_8_, Integer ORDER_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

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