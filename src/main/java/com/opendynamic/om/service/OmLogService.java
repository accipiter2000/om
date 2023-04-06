package com.opendynamic.om.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface OmLogService {
    /**
     * 按主键查询,返回单个对象。
     */
    public Map<String, Object> loadLog(String LOG_ID_);

    /**
     * 通用查询，返回对象列表。
     * 
     * @param LOG_ID_
     *        日志ID
     * @param CATEGORY_
     *        分类
     * @param IP_
     *        IP
     * @param ACTION_
     *        调用控制层接口
     * @param BUSINESS_KEY_
     *        业务主键
     * @param ERROR_LIST
     *        错误
     * @param ORG_ID_
     *        机构ID
     * @param ORG_NAME_
     *        机构名称
     * @param POSI_ID_
     *        岗位ID
     * @param POSI_NAME_
     *        岗位名称
     * @param EMP_ID_
     *        人员ID
     * @param EMP_NAME_
     *        人员名称
     * @param FROM_CREATION_DATE_
     *        起始创建日期
     * @param TO_CREATION_DATE_
     *        截止创建日期
     * @param page
     *        页面 默认为1
     * @param limit
     *        每页数据数量 默认为-1(全部)
     * @return
     */
    public List<Map<String, Object>> selectLog(String LOG_ID_, String CATEGORY_, String IP_, String ACTION_, String BUSINESS_KEY_, List<String> ERROR_LIST, String ORG_ID_, String ORG_NAME_, String POSI_ID_, String POSI_NAME_, String EMP_ID_, String EMP_NAME_, Date FROM_CREATION_DATE_, Date TO_CREATION_DATE_, Integer page, Integer limit);

    /**
     * 总数查询，在分页时与通用查询配套使用。
     */
    public int countLog(String LOG_ID_, String CATEGORY_, String IP_, String ACTION_, String BUSINESS_KEY_, List<String> ERROR_LIST, String ORG_ID_, String ORG_NAME_, String POSI_ID_, String POSI_NAME_, String EMP_ID_, String EMP_NAME_, Date FROM_CREATION_DATE_, Date TO_CREATION_DATE_);

    /**
     * 按主键列表查询，返回对象列表，按主键列表顺序排序。
     */
    public List<Map<String, Object>> selectLogByIdList(List<String> LOG_ID_LIST);

    /**
     * 新增对象。
     */
    public int insertLog(String LOG_ID_, String CATEGORY_, String IP_, String USER_AGENT_, String URL_, String ACTION_, String PARAMETER_MAP_, String BUSINESS_KEY_, String ERROR_, String MESSAGE_, String ORG_ID_, String ORG_NAME_, String POSI_ID_, String POSI_NAME_, String EMP_ID_, String EMP_NAME_, Date CREATION_DATE_);

    /**
     * 修改对象。
     */
    public int updateLog(String LOG_ID_, String CATEGORY_, String IP_, String USER_AGENT_, String URL_, String ACTION_, String PARAMETER_MAP_, String BUSINESS_KEY_, String ERROR_, String MESSAGE_, String ORG_ID_, String ORG_NAME_, String POSI_ID_, String POSI_NAME_, String EMP_ID_, String EMP_NAME_);

    /**
     * 删除对象。
     */
    public int deleteLog(String LOG_ID_);
}