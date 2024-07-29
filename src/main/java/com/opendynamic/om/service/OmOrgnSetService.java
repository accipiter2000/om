package com.opendynamic.om.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.opendynamic.om.vo.OrgnChange;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface OmOrgnSetService {
    /**
     * 按主键查询,返回单个对象。
     */
    public Map<String, Object> loadOrgnSet(String ORGN_SET_ID_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 按编码查询,返回单个对象。
     */
    public Map<String, Object> loadOrgnSetByCode(String ORGN_SET_CODE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 通用查询，返回对象列表。
     */
    public List<Map<String, Object>> selectOrgnSet(String ORGN_SET_ID_, List<String> ORGN_SET_ID_LIST, String PARENT_ORGN_SET_ID_, List<String> PARENT_ORGN_SET_ID_LIST, String ORGN_SET_CODE_, List<String> ORGN_SET_CODE_LIST, String ORGN_SET_NAME_, List<String> ORGN_SET_NAME_LIST, String ORGN_SET_STATUS_, List<String> ORGN_SET_STATUS_LIST, Boolean orgnSetRootOnly, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 总数查询，在分页时与通用查询配套使用。
     */
    public int countOrgnSet(String ORGN_SET_ID_, List<String> ORGN_SET_ID_LIST, String PARENT_ORGN_SET_ID_, List<String> PARENT_ORGN_SET_ID_LIST, String ORGN_SET_CODE_, List<String> ORGN_SET_CODE_LIST, String ORGN_SET_NAME_, List<String> ORGN_SET_NAME_LIST, String ORGN_SET_STATUS_, List<String> ORGN_SET_STATUS_LIST, Boolean orgnSetRootOnly, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 通用上级对象查询，返回上级对象列表。
     * 
     * @param recursive
     *        是否递归，默认为false。
     * @param includeSelf
     *        是否包含自己，默认为false。
     */
    public List<Map<String, Object>> selectParentOrgnSet(String ORGN_SET_ID_, String ORGN_SET_CODE_, List<String> ORGN_SET_CODE_LIST, String ORGN_SET_NAME_, List<String> ORGN_SET_NAME_LIST, String ORGN_SET_STATUS_, List<String> ORGN_SET_STATUS_LIST, Boolean orgnSetRootOnly, Boolean recursive, Boolean includeSelf, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 通用下级对象查询，返回下级对象列表。
     * 
     * @param recursive
     *        是否递归，默认为false。
     * @param includeSelf
     *        是否包含自己，默认为false。
     */
    public List<Map<String, Object>> selectChildOrgnSet(String ORGN_SET_ID_, String ORGN_SET_CODE_, List<String> ORGN_SET_CODE_LIST, String ORGN_SET_NAME_, List<String> ORGN_SET_NAME_LIST, String ORGN_SET_STATUS_, List<String> ORGN_SET_STATUS_LIST, Boolean orgnSetRootOnly, Boolean recursive, Boolean includeSelf, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 按主键列表查询，返回对象列表，按主键列表顺序排序。
     */
    public List<Map<String, Object>> selectOrgnSetByIdList(List<String> ORGN_SET_ID_LIST, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 新增对象。
     */
    public int insertOrgnSet(String ORGN_SET_ID_, String PARENT_ORGN_SET_ID_, String ORGN_SET_CODE_, String ORGN_SET_NAME_, String ALLOW_SYNC_, String MEMO_, Integer ORDER_, String ORGN_SET_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 修改对象。
     */
    public int updateOrgnSet(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORGN_SET_NAME_, String ALLOW_SYNC_, String MEMO_, Integer ORDER_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 拖动排序。
     */
    public int updateOrgnSetOrder(List<String> ORGN_SET_ID_LIST, List<Integer> ORDER_LIST, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 移动对象。
     */
    public int moveOrgnSet(String ORGN_SET_ID_, String PARENT_ORGN_SET_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 废弃对象。
     */
    public int disableOrgnSet(String ORGN_SET_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 恢复对象。
     */
    public int enableOrgnSet(String ORGN_SET_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 删除对象。
     */
    public int deleteOrgnSet(String ORGN_SET_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 全部删除组织架构套中所有对象
     */
    public int trunkOrgnSet(String ORGN_SET_ID_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 从镜像服务器复制主服务器的组织架构套，镜像服务器的原有相关数据被删除。
     */
    public int copyOrgnSet(String BASE_ORGN_SET_ID_, String ORGN_SET_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 从镜像服务器比较与主服务器组织架构套的差异。
     */
    public OrgnChange compareOrgnSet(String BASE_ORGN_SET_ID_, String ORGN_SET_ID_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 从镜像服务器更新指定的主服务器的组织架构套数据。
     */
    public int replaceOrgnSet(String BASE_ORGN_SET_ID_, String ORGN_SET_ID_, List<String> INSERT_ORG_ID_LIST, List<String> UPDATE_ORG_ID_LIST, List<String> DELETE_ORG_ID_LIST, List<String> INSERT_DUTY_ID_LIST, List<String> UPDATE_DUTY_ID_LIST, List<String> DELETE_DUTY_ID_LIST, List<String> INSERT_POSI_ID_LIST, List<String> UPDATE_POSI_ID_LIST, List<String> DELETE_POSI_ID_LIST, List<String> INSERT_EMP_ID_LIST, List<String> UPDATE_EMP_ID_LIST, List<String> DELETE_EMP_ID_LIST, List<String> INSERT_POSI_EMP_ID_LIST, List<String> UPDATE_POSI_EMP_ID_LIST, List<String> DELETE_POSI_EMP_ID_LIST, List<String> INSERT_EMP_RELATION_ID_LIST, List<String> UPDATE_EMP_RELATION_ID_LIST, List<String> DELETE_EMP_RELATION_ID_LIST, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);
}