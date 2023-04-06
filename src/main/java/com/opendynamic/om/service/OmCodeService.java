package com.opendynamic.om.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface OmCodeService {
    /**
     * 按主键查询,返回单个对象。
     */
    public Map<String, Object> loadCode(String CODE_ID_);

    /**
     * 通用查询，返回对象列表。
     * 
     * @param CODE_ID_
     *        代码ID
     * @param PARENT_CODE_ID_
     *        上级代码ID
     * @param CATEGORY_LIST
     *        分类
     * @param CODE_
     *        代码
     * @param NAME_
     *        名称
     * @param EXT_ATTR_1_
     *        扩展属性1
     * @param EXT_ATTR_2_
     *        扩展属性2
     * @param EXT_ATTR_3_
     *        扩展属性3
     * @param EXT_ATTR_4_
     *        扩展属性4
     * @param EXT_ATTR_5_
     *        扩展属性5
     * @param EXT_ATTR_6_
     *        扩展属性6
     * @param rootOnly
     *        仅查询根，默认为false
     * @param page
     *        页面 默认为1
     * @param limit
     *        每页数据数量 默认为-1(全部)
     * @return
     */
    public List<Map<String, Object>> selectCode(String CODE_ID_, String PARENT_CODE_ID_, List<String> CATEGORY_LIST, String CODE_, String NAME_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, Boolean rootOnly, Integer page, Integer limit);

    /**
     * 总数查询，在分页时与通用查询配套使用。
     */
    public int countCode(String CODE_ID_, String PARENT_CODE_ID_, List<String> CATEGORY_LIST, String CODE_, String NAME_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, Boolean rootOnly);

    /**
     * 通用父对象查询，返回父对象列表。
     * 
     * @param includeSelf
     *        是否包含自己，默认为false。
     * @param recursive
     *        是否递归，默认为false。
     */
    public List<Map<String, Object>> selectParentCode(String CODE_ID_, List<String> CATEGORY_LIST, String CODE_, String NAME_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, Boolean includeSelf, Boolean recursive);

    /**
     * 通用子对象查询，返回子对象列表。
     * 
     * @param includeSelf
     *        是否包含自己，默认为false。
     * @param recursive
     *        是否递归，默认为false。
     */
    public List<Map<String, Object>> selectChildCode(String CODE_ID_, List<String> CATEGORY_LIST, String CODE_, String NAME_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, Boolean includeSelf, Boolean recursive);

    /**
     * 查询分类。
     * 
     * @return
     */
    public List<Map<String, Object>> selectCodeCategory();

    /**
     * 按主键列表查询，返回对象列表，按主键列表顺序排序。
     */
    public List<Map<String, Object>> selectCodeByIdList(List<String> CODE_ID_LIST);

    /**
     * 新增对象。
     */
    public int insertCode(String CODE_ID_, String PARENT_CODE_ID_, String CATEGORY_, String CODE_, String NAME_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, Integer ORDER_);

    /**
     * 修改对象。
     */
    public int updateCode(String CODE_ID_, String CODE_, String NAME_, String EXT_ATTR_1_, String EXT_ATTR_2_, String EXT_ATTR_3_, String EXT_ATTR_4_, String EXT_ATTR_5_, String EXT_ATTR_6_, Integer ORDER_);

    /**
     * 拖动排序。
     */
    public int updateCodeOrder(List<String> CODE_ID_LIST, List<Integer> ORDER_LIST);

    /**
     * 移动对象。
     */
    public int moveCode(String CODE_ID_, String PARENT_CODE_ID_);

    /**
     * 删除对象。
     */
    public int deleteCode(String CODE_ID_);
}