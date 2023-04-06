package com.opendynamic.om.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface OmMirrorServerService {
    /**
     * 按主键查询,返回单个对象。
     */
    public Map<String, Object> loadMirrorServer(String MIRROR_SERVER_ID_);

    /**
     * 通用查询，返回对象列表。
     */
    public List<Map<String, Object>> selectMirrorServer(String MIRROR_SERVER_ID_, String MIRROR_SERVER_NAME_, List<String> MIRROR_SERVER_STATUS_LIST, Integer page, Integer limit);

    /**
     * 总数查询，在分页时与通用查询配套使用。
     */
    public int countMirrorServer(String MIRROR_SERVER_ID_, String MIRROR_SERVER_NAME_, List<String> MIRROR_SERVER_STATUS_LIST);

    /**
     * 按主键列表查询，返回对象列表，按主键列表顺序排序。
     */
    public List<Map<String, Object>> selectMirrorServerByIdList(List<String> MIRROR_SERVER_ID_LIST);

    /**
     * 新增对象。
     */
    public int insertMirrorServer(String MIRROR_SERVER_ID_, String MIRROR_SERVER_NAME_, String DRIVER_CLASS_NAME_, String URL_, String USERNAME_, String PASSWORD_, String MEMO_, Date LAST_SYNC_DATE_, Integer ORDER_, String MIRROR_SERVER_STATUS_, Date CREATION_DATE_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 修改对象。
     */
    public int updateMirrorServer(String MIRROR_SERVER_ID_, String MIRROR_SERVER_NAME_, String DRIVER_CLASS_NAME_, String URL_, String USERNAME_, String PASSWORD_, String MEMO_, Date LAST_SYNC_DATE_, Integer ORDER_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 拖动排序。
     */
    public int updateMirrorServerOrder(List<String> MIRROR_SERVER_ID_LIST, List<Integer> ORDER_LIST, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 废弃对象。
     */
    public int disableMirrorServer(String MIRROR_SERVER_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 恢复对象。
     */
    public int enableMirrorServer(String MIRROR_SERVER_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 删除对象。
     */
    public int deleteMirrorServer(String MIRROR_SERVER_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);
}