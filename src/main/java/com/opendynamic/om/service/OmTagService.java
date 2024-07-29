package com.opendynamic.om.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface OmTagService {
    /**
     * 按主键查询,返回单个对象。
     */
    public Map<String, Object> loadTag(String ORGN_SET_ID_, String ORGN_SET_CODE_, String TAG_ID_);

    /**
     * 通用查询，返回对象列表。
     */
    public List<Map<String, Object>> selectTag(String ORGN_SET_ID_, String ORGN_SET_CODE_, String TAG_ID_, String OBJ_ID_, String OBJ_TYPE_, String TAG_, Integer page, Integer limit);

    /**
     * 总数查询，在分页时与通用查询配套使用。
     */
    public int countTag(String ORGN_SET_ID_, String ORGN_SET_CODE_, String TAG_ID_, String OBJ_ID_, String OBJ_TYPE_, String TAG_);

    /**
     * 按主键列表查询，返回对象列表，按主键列表顺序排序。
     */
    public List<Map<String, Object>> selectTagByIdList(String ORGN_SET_ID_, List<String> TAG_ID_LIST);

    /**
     * 新增对象。
     */
    public int insertTag(String ORGN_SET_ID_, String TAG_ID_, String OBJ_ID_, String OBJ_TYPE_, String TAG_);

    /**
     * 修改对象。
     */
    public int updateTag(String ORGN_SET_ID_, String TAG_ID_, String OBJ_ID_, String OBJ_TYPE_, String TAG_);

    /**
     * 修改对象的所有标签。
     */
    public void updateTagByObjId(String ORGN_SET_ID_, String OBJ_ID_, String OBJ_TYPE_, String TAG_);

    /**
     * 删除对象。
     */
    public int deleteTag(String ORGN_SET_ID_, String TAG_ID_);

    /**
     * 删除对象。
     */
    public int deleteTagByObjId(String ORGN_SET_ID_, String OBJ_ID_);

    /**
     * 分割标签字符串。
     */
    public List<String> splitTag(String TAG_);
}