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
     * 
     * @param ORGN_SET_ID_
     *        组织架构套ID
     * @param PARENT_ORGN_SET_ID_
     *        上级组织架构套ID
     * @param ORGN_SET_CODE_
     *        组织架构套编码
     * @param ORGN_SET_NAME_
     *        组织架构套名称
     * @param ORGN_SET_STATUS_LIST
     *        组织架构套状态
     * @param rootOnly
     *        仅查询根，默认为false
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
    public List<Map<String, Object>> selectOrgnSet(String ORGN_SET_ID_, String PARENT_ORGN_SET_ID_, String ORGN_SET_CODE_, String ORGN_SET_NAME_, List<String> ORGN_SET_STATUS_LIST, Boolean rootOnly, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 总数查询，在分页时与通用查询配套使用。
     */
    public int countOrgnSet(String ORGN_SET_ID_, String PARENT_ORGN_SET_ID_, String ORGN_SET_CODE_, String ORGN_SET_NAME_, List<String> ORGN_SET_STATUS_LIST, Boolean rootOnly, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 通用父对象查询，返回父对象列表。
     * 
     * @param includeSelf
     *        是否包含自己，默认为false。
     * @param recursive
     *        是否递归，默认为false。
     */
    public List<Map<String, Object>> selectParentOrgnSet(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORGN_SET_NAME_, List<String> ORGN_SET_STATUS_LIST, Boolean includeSelf, Boolean recursive, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 通用子对象查询，返回子对象列表。
     * 
     * @param includeSelf
     *        是否包含自己，默认为false。
     * @param recursive
     *        是否递归，默认为false。
     */
    public List<Map<String, Object>> selectChildOrgnSet(String ORGN_SET_ID_, String ORGN_SET_CODE_, String ORGN_SET_NAME_, List<String> ORGN_SET_STATUS_LIST, Boolean includeSelf, Boolean recursive, String OPERATOR_ID_, String OPERATOR_NAME_);

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
     * 
     * @param BASE_ORGN_SET_ID_
     * @param ORGN_SET_ID_
     * @param UPDATE_DATE_
     * @param OPERATOR_ID_
     * @param OPERATOR_NAME_
     * @return
     */
    public int copyOrgnSet(String BASE_ORGN_SET_ID_, String ORGN_SET_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 从镜像服务器比较与主服务器组织架构套的差异。
     * 
     * @param BASE_ORGN_SET_ID_
     * @param ORGN_SET_ID_
     * @param OPERATOR_ID_
     * @param OPERATOR_NAME_
     * @return
     */
    public OrgnChange compareOrgnSet(String BASE_ORGN_SET_ID_, String ORGN_SET_ID_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 从镜像服务器更新指定的主服务器的组织架构套数据。
     * 
     * @param BASE_ORGN_SET_ID_
     * @param ORGN_SET_ID_
     * @param INSERT_ORG_ID_LIST
     * @param UPDATE_ORG_ID_LIST
     * @param DELETE_ORG_ID_LIST
     * @param INSERT_DUTY_ID_LIST
     * @param UPDATE_DUTY_ID_LIST
     * @param DELETE_DUTY_ID_LIST
     * @param INSERT_POSI_ID_LIST
     * @param UPDATE_POSI_ID_LIST
     * @param DELETE_POSI_ID_LIST
     * @param INSERT_EMP_ID_LIST
     * @param UPDATE_EMP_ID_LIST
     * @param DELETE_EMP_ID_LIST
     * @param INSERT_POSI_EMP_ID_LIST
     * @param UPDATE_POSI_EMP_ID_LIST
     * @param DELETE_POSI_EMP_ID_LIST
     * @param INSERT_EMP_RELATION_ID_LIST
     * @param UPDATE_EMP_RELATION_ID_LIST
     * @param DELETE_EMP_RELATION_ID_LIST
     * @param UPDATE_DATE_
     * @param OPERATOR_ID_
     * @param OPERATOR_NAME_
     * @return
     */
    public int replaceOrgnSet(String BASE_ORGN_SET_ID_, String ORGN_SET_ID_, List<String> INSERT_ORG_ID_LIST, List<String> UPDATE_ORG_ID_LIST, List<String> DELETE_ORG_ID_LIST, List<String> INSERT_DUTY_ID_LIST, List<String> UPDATE_DUTY_ID_LIST, List<String> DELETE_DUTY_ID_LIST, List<String> INSERT_POSI_ID_LIST, List<String> UPDATE_POSI_ID_LIST, List<String> DELETE_POSI_ID_LIST, List<String> INSERT_EMP_ID_LIST, List<String> UPDATE_EMP_ID_LIST, List<String> DELETE_EMP_ID_LIST, List<String> INSERT_POSI_EMP_ID_LIST, List<String> UPDATE_POSI_EMP_ID_LIST, List<String> DELETE_POSI_EMP_ID_LIST, List<String> INSERT_EMP_RELATION_ID_LIST, List<String> UPDATE_EMP_RELATION_ID_LIST, List<String> DELETE_EMP_RELATION_ID_LIST, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);
}