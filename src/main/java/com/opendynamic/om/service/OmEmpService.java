package com.opendynamic.om.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface OmEmpService {
    /**
     * 按主键查询,返回单个对象。
     */
    public Map<String, Object> loadEmp(String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_ID_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 按编码查询,返回单个对象。
     */
    public Map<String, Object> loadEmpByCode(String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_CODE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 按编码查询,返回单个对象。
     */
    public Map<String, Object> loadEmpByPassword(String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_CODE_, String PASSWORD_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 通用查询，返回对象列表。
     *
     * @param ORGN_SET_ID_
     *        组织架构套ID
     * @param ORGN_SET_CODE_
     *        组织架构套编码
     * @param EMP_ID_
     *        人员ID
     * @param ORG_ID_
     *        机构ID
     * @param EMP_CODE_
     *        人员编码
     * @param EMP_NAME_
     *        人员名称
     * @param EMP_CATEGORY_LIST
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
    public List<Map<String, Object>> selectEmp(String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_ID_, List<String> EMP_ID_LIST, String EMP_CODE_, List<String> EMP_CODE_LIST, String EMP_NAME_, List<String> EMP_NAME_LIST, String EMP_CATEGORY_, List<String> EMP_CATEGORY_LIST, String EMP_TAG_, String EMP_EXT_ATTR_1_, List<String> EMP_EXT_ATTR_1_LIST, String EMP_EXT_ATTR_2_, List<String> EMP_EXT_ATTR_2_LIST, String EMP_EXT_ATTR_3_, List<String> EMP_EXT_ATTR_3_LIST, String EMP_EXT_ATTR_4_, List<String> EMP_EXT_ATTR_4_LIST, String EMP_EXT_ATTR_5_, List<String> EMP_EXT_ATTR_5_LIST, String EMP_EXT_ATTR_6_, List<String> EMP_EXT_ATTR_6_LIST, String EMP_EXT_ATTR_7_, List<String> EMP_EXT_ATTR_7_LIST, String EMP_EXT_ATTR_8_, List<String> EMP_EXT_ATTR_8_LIST, String EMP_STATUS_,
            List<String> EMP_STATUS_LIST, String ORG_ID_, List<String> ORG_ID_LIST, String PARENT_ORG_ID_, List<String> PARENT_ORG_ID_LIST, String ORG_CODE_, List<String> ORG_CODE_LIST, String ORG_NAME_, List<String> ORG_NAME_LIST, String ORG_TYPE_, List<String> ORG_TYPE_LIST, String ORG_CATEGORY_, List<String> ORG_CATEGORY_LIST, String ORG_TAG_, String ORG_EXT_ATTR_1_, List<String> ORG_EXT_ATTR_1_LIST, String ORG_EXT_ATTR_2_, List<String> ORG_EXT_ATTR_2_LIST, String ORG_EXT_ATTR_3_, List<String> ORG_EXT_ATTR_3_LIST, String ORG_EXT_ATTR_4_, List<String> ORG_EXT_ATTR_4_LIST, String ORG_EXT_ATTR_5_, List<String> ORG_EXT_ATTR_5_LIST, String ORG_EXT_ATTR_6_, List<String> ORG_EXT_ATTR_6_LIST, String ORG_EXT_ATTR_7_, List<String> ORG_EXT_ATTR_7_LIST, String ORG_EXT_ATTR_8_,
            List<String> ORG_EXT_ATTR_8_LIST, String ORG_STATUS_, List<String> ORG_STATUS_LIST, Boolean empTagUnion, Boolean orgTagUnion, String withinOrgId, Boolean orgRootOnly, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 总数查询，在分页时与通用查询配套使用。
     */
    public int countEmp(String ORGN_SET_ID_, String ORGN_SET_CODE_, String EMP_ID_, List<String> EMP_ID_LIST, String EMP_CODE_, List<String> EMP_CODE_LIST, String EMP_NAME_, List<String> EMP_NAME_LIST, String EMP_CATEGORY_, List<String> EMP_CATEGORY_LIST, String EMP_TAG_, String EMP_EXT_ATTR_1_, List<String> EMP_EXT_ATTR_1_LIST, String EMP_EXT_ATTR_2_, List<String> EMP_EXT_ATTR_2_LIST, String EMP_EXT_ATTR_3_, List<String> EMP_EXT_ATTR_3_LIST, String EMP_EXT_ATTR_4_, List<String> EMP_EXT_ATTR_4_LIST, String EMP_EXT_ATTR_5_, List<String> EMP_EXT_ATTR_5_LIST, String EMP_EXT_ATTR_6_, List<String> EMP_EXT_ATTR_6_LIST, String EMP_EXT_ATTR_7_, List<String> EMP_EXT_ATTR_7_LIST, String EMP_EXT_ATTR_8_, List<String> EMP_EXT_ATTR_8_LIST, String EMP_STATUS_, List<String> EMP_STATUS_LIST,
            String ORG_ID_, List<String> ORG_ID_LIST, String PARENT_ORG_ID_, List<String> PARENT_ORG_ID_LIST, String ORG_CODE_, List<String> ORG_CODE_LIST, String ORG_NAME_, List<String> ORG_NAME_LIST, String ORG_TYPE_, List<String> ORG_TYPE_LIST, String ORG_CATEGORY_, List<String> ORG_CATEGORY_LIST, String ORG_TAG_, String ORG_EXT_ATTR_1_, List<String> ORG_EXT_ATTR_1_LIST, String ORG_EXT_ATTR_2_, List<String> ORG_EXT_ATTR_2_LIST, String ORG_EXT_ATTR_3_, List<String> ORG_EXT_ATTR_3_LIST, String ORG_EXT_ATTR_4_, List<String> ORG_EXT_ATTR_4_LIST, String ORG_EXT_ATTR_5_, List<String> ORG_EXT_ATTR_5_LIST, String ORG_EXT_ATTR_6_, List<String> ORG_EXT_ATTR_6_LIST, String ORG_EXT_ATTR_7_, List<String> ORG_EXT_ATTR_7_LIST, String ORG_EXT_ATTR_8_, List<String> ORG_EXT_ATTR_8_LIST,
            String ORG_STATUS_, List<String> ORG_STATUS_LIST, Boolean empTagUnion, Boolean orgTagUnion, String withinOrgId, Boolean orgRootOnly, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 按主键列表查询，返回对象列表，按主键列表顺序排序。
     */
    public List<Map<String, Object>> selectEmpByIdList(String ORGN_SET_ID_, List<String> EMP_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 按主键列表查询，返回对象列表，按主键列表顺序排序。
     */
    public List<Map<String, Object>> selectProtoEmpByIdList(String ORGN_SET_ID_, List<String> EMP_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 新增对象。
     */
    public int insertEmp(String ORGN_SET_ID_, String EMP_ID_, String ORG_ID_, String EMP_CODE_, String EMP_NAME_, String PASSWORD_, String PASSWORD_RESET_REQ_, String PARTY_, String EMP_LEVEL_, String GENDER_, Date BIRTH_DATE_, String TEL_, String EMAIL_, Date IN_DATE_, Date OUT_DATE_, String EMP_CATEGORY_, String MEMO_, String EMP_TAG_, String EMP_EXT_ATTR_1_, String EMP_EXT_ATTR_2_, String EMP_EXT_ATTR_3_, String EMP_EXT_ATTR_4_, String EMP_EXT_ATTR_5_, String EMP_EXT_ATTR_6_, String EMP_EXT_ATTR_7_, String EMP_EXT_ATTR_8_, Integer ORDER_, String EMP_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 修改对象。
     */
    public int updateEmp(String ORGN_SET_ID_, String EMP_ID_, String EMP_CODE_, String EMP_NAME_, String PARTY_, String EMP_LEVEL_, String GENDER_, Date BIRTH_DATE_, String TEL_, String EMAIL_, Date IN_DATE_, Date OUT_DATE_, String EMP_CATEGORY_, String MEMO_, String EMP_TAG_, String EMP_EXT_ATTR_1_, String EMP_EXT_ATTR_2_, String EMP_EXT_ATTR_3_, String EMP_EXT_ATTR_4_, String EMP_EXT_ATTR_5_, String EMP_EXT_ATTR_6_, String EMP_EXT_ATTR_7_, String EMP_EXT_ATTR_8_, Integer ORDER_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 修改密码
     */
    public int updateEmpPassword(String ORGN_SET_ID_, String EMP_ID_, String OLD_PASSWORD_, String NEW_PASSWORD_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 重置密码
     */
    public int resetEmpPassword(String ORGN_SET_ID_, String EMP_ID_, String PASSWORD_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 拖动排序。
     */
    public int updateEmpOrder(String ORGN_SET_ID_, List<String> EMP_ID_LIST, List<Integer> ORDER_LIST, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 移动对象
     */
    public int moveEmp(String ORGN_SET_ID_, String EMP_ID_, String ORG_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 废弃对象。
     */
    public int disableEmp(String ORGN_SET_ID_, String EMP_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 恢复对象。
     */
    public int enableEmp(String ORGN_SET_ID_, String EMP_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 删除对象。
     */
    public int deleteEmp(String ORGN_SET_ID_, String EMP_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);
}