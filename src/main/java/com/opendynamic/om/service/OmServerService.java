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
public interface OmServerService {
    /**
     * 从主服务器复制组织架构套到镜像服务器，镜像服务器的原有相关数据被删除。
     * 
     * @param MIRROR_SERVER_ID_
     * @param ORGN_SET_ID_
     * @param UPDATE_DATE_
     * @param OPERATOR_ID_
     * @param OPERATOR_NAME_
     * @return
     */
    public int pushCopyMirrorServerOrgnSet(String MIRROR_SERVER_ID_, String ORGN_SET_ID_, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 从主服务器比较与镜像服务器组织架构套的差异。
     * 
     * @param MIRROR_SERVER_ID_
     * @param ORGN_SET_ID_
     * @param OPERATOR_ID_
     * @param OPERATOR_NAME_
     * @return
     */
    public OrgnChange pushCompareMirrorServerOrgnSet(String MIRROR_SERVER_ID_, String ORGN_SET_ID_, String OPERATOR_ID_, String OPERATOR_NAME_);

    /**
     * 从主服务器更新指定的组织架构套数据到镜像服务器。
     * 
     * @param MIRROR_SERVER_ID_
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
    public int pushReplaceMirrorServerOrgnSet(String MIRROR_SERVER_ID_, String ORGN_SET_ID_, List<String> INSERT_ORG_ID_LIST, List<String> UPDATE_ORG_ID_LIST, List<String> DELETE_ORG_ID_LIST, List<String> INSERT_DUTY_ID_LIST, List<String> UPDATE_DUTY_ID_LIST, List<String> DELETE_DUTY_ID_LIST, List<String> INSERT_POSI_ID_LIST, List<String> UPDATE_POSI_ID_LIST, List<String> DELETE_POSI_ID_LIST, List<String> INSERT_EMP_ID_LIST, List<String> UPDATE_EMP_ID_LIST, List<String> DELETE_EMP_ID_LIST, List<String> INSERT_POSI_EMP_ID_LIST, List<String> UPDATE_POSI_EMP_ID_LIST, List<String> DELETE_POSI_EMP_ID_LIST, List<String> INSERT_EMP_RELATION_ID_LIST, List<String> UPDATE_EMP_RELATION_ID_LIST, List<String> DELETE_EMP_RELATION_ID_LIST, Date UPDATE_DATE_, String OPERATOR_ID_, String OPERATOR_NAME_);

    public List<Map<String, Object>> selectMirrorServerOrgnSet(String MIRROR_SERVER_ID_, String ORGN_SET_ID_, String PARENT_ORGN_SET_ID_, String ORGN_SET_CODE_, String ORGN_SET_NAME_, List<String> ORGN_SET_STATUS_LIST, Boolean rootOnly, Integer page, Integer limit, String OPERATOR_ID_, String OPERATOR_NAME_);

    public int countMirrorServerOrgnSet(String MIRROR_SERVER_ID_, String ORGN_SET_ID_, String PARENT_ORGN_SET_ID_, String ORGN_SET_CODE_, String ORGN_SET_NAME_, List<String> ORGN_SET_STATUS_LIST, Boolean rootOnly, String OPERATOR_ID_, String OPERATOR_NAME_);
}