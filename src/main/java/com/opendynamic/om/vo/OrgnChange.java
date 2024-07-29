package com.opendynamic.om.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class OrgnChange implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Map<String, Object>> insertOrgList;// 新增机构列表。
    private List<Map<String, Object>> updateOrgList;// 修改机构列表。
    private List<Map<String, Object>> deleteOrgList;// 删除机构列表。
    private List<Map<String, Object>> insertDutyList;// 新增职务列表。
    private List<Map<String, Object>> updateDutyList;// 修改职务列表。
    private List<Map<String, Object>> deleteDutyList;// 删除职务列表。
    private List<Map<String, Object>> insertPosiList;// 新增岗位列表。
    private List<Map<String, Object>> updatePosiList;// 修改岗位列表。
    private List<Map<String, Object>> deletePosiList;// 删除岗位列表。
    private List<Map<String, Object>> insertEmpList;// 新增人员列表。
    private List<Map<String, Object>> updateEmpList;// 修改人员列表。
    private List<Map<String, Object>> deleteEmpList;// 删除人员列表。
    private List<Map<String, Object>> insertPosiEmpList;// 新增岗位人员列表。
    private List<Map<String, Object>> updatePosiEmpList;// 修改岗位人员列表。
    private List<Map<String, Object>> deletePosiEmpList;// 删除岗位人员列表。
    private List<Map<String, Object>> insertEmpRelationList;// 新增人员关系列表。
    private List<Map<String, Object>> updateEmpRelationList;// 修改人员关系列表。
    private List<Map<String, Object>> deleteEmpRelationList;// 删除人员关系列表。

    /**
     * 获取新增机构列表。
     * 
     * @return 新增机构列表。
     */
    public List<Map<String, Object>> getInsertOrgList() {
        return insertOrgList;
    }

    /**
     * 设置新增机构列表。
     * 
     * @param insertOrgList
     *        新增机构列表。
     */
    public void setInsertOrgList(List<Map<String, Object>> insertOrgList) {
        this.insertOrgList = insertOrgList;
    }

    /**
     * 获取修改机构列表。
     * 
     * @return 修改机构列表。
     */
    public List<Map<String, Object>> getUpdateOrgList() {
        return updateOrgList;
    }

    /**
     * 设置修改机构列表。
     * 
     * @param updateOrgList
     *        修改机构列表。
     */
    public void setUpdateOrgList(List<Map<String, Object>> updateOrgList) {
        this.updateOrgList = updateOrgList;
    }

    /**
     * 获取删除机构列表。
     * 
     * @return 删除机构列表。
     */
    public List<Map<String, Object>> getDeleteOrgList() {
        return deleteOrgList;
    }

    /**
     * 设置删除机构列表。
     * 
     * @param deleteOrgList
     *        删除机构列表。
     */
    public void setDeleteOrgList(List<Map<String, Object>> deleteOrgList) {
        this.deleteOrgList = deleteOrgList;
    }

    /**
     * 获取新增职务列表。
     * 
     * @return 新增职务列表。
     */
    public List<Map<String, Object>> getInsertDutyList() {
        return insertDutyList;
    }

    /**
     * 设置新增职务列表。
     * 
     * @param insertDutyList
     *        新增职务列表。
     */
    public void setInsertDutyList(List<Map<String, Object>> insertDutyList) {
        this.insertDutyList = insertDutyList;
    }

    /**
     * 获取修改职务列表。
     * 
     * @return 修改职务列表。
     */
    public List<Map<String, Object>> getUpdateDutyList() {
        return updateDutyList;
    }

    /**
     * 设置修改职务列表。
     * 
     * @param updateDutyList
     *        修改职务列表。
     */
    public void setUpdateDutyList(List<Map<String, Object>> updateDutyList) {
        this.updateDutyList = updateDutyList;
    }

    /**
     * 获取删除职务列表。
     * 
     * @return 删除职务列表。
     */
    public List<Map<String, Object>> getDeleteDutyList() {
        return deleteDutyList;
    }

    /**
     * 设置删除职务列表。
     * 
     * @param deleteDutyList
     *        删除职务列表。
     */
    public void setDeleteDutyList(List<Map<String, Object>> deleteDutyList) {
        this.deleteDutyList = deleteDutyList;
    }

    /**
     * 获取新增岗位列表。
     * 
     * @return 新增岗位列表。
     */
    public List<Map<String, Object>> getInsertPosiList() {
        return insertPosiList;
    }

    /**
     * 设置新增岗位列表。
     * 
     * @param insertPosiList
     *        新增岗位列表。
     */
    public void setInsertPosiList(List<Map<String, Object>> insertPosiList) {
        this.insertPosiList = insertPosiList;
    }

    /**
     * 获取修改岗位列表。
     * 
     * @return 修改岗位列表。
     */
    public List<Map<String, Object>> getUpdatePosiList() {
        return updatePosiList;
    }

    /**
     * 设置修改岗位列表。
     * 
     * @param updatePosiList
     *        修改岗位列表。
     */
    public void setUpdatePosiList(List<Map<String, Object>> updatePosiList) {
        this.updatePosiList = updatePosiList;
    }

    /**
     * 获取删除岗位列表。
     * 
     * @return 删除岗位列表。
     */
    public List<Map<String, Object>> getDeletePosiList() {
        return deletePosiList;
    }

    /**
     * 设置删除岗位列表。
     * 
     * @param deletePosiList
     *        删除岗位列表。
     */
    public void setDeletePosiList(List<Map<String, Object>> deletePosiList) {
        this.deletePosiList = deletePosiList;
    }

    /**
     * 获取新增人员列表。
     * 
     * @return 新增人员列表。
     */
    public List<Map<String, Object>> getInsertEmpList() {
        return insertEmpList;
    }

    /**
     * 设置新增人员列表。
     * 
     * @param insertEmpList
     *        新增人员列表。
     */
    public void setInsertEmpList(List<Map<String, Object>> insertEmpList) {
        this.insertEmpList = insertEmpList;
    }

    /**
     * 获取修改人员列表。
     * 
     * @return 修改人员列表。
     */
    public List<Map<String, Object>> getUpdateEmpList() {
        return updateEmpList;
    }

    /**
     * 设置修改人员列表。
     * 
     * @param updateEmpList
     *        修改人员列表。
     */
    public void setUpdateEmpList(List<Map<String, Object>> updateEmpList) {
        this.updateEmpList = updateEmpList;
    }

    /**
     * 获取删除人员列表。
     * 
     * @return 删除人员列表。
     */
    public List<Map<String, Object>> getDeleteEmpList() {
        return deleteEmpList;
    }

    /**
     * 设置删除人员列表。
     * 
     * @param deleteEmpList
     *        删除人员列表。
     */
    public void setDeleteEmpList(List<Map<String, Object>> deleteEmpList) {
        this.deleteEmpList = deleteEmpList;
    }

    /**
     * 获取新增岗位人员列表。
     * 
     * @return 新增岗位人员列表。
     */
    public List<Map<String, Object>> getInsertPosiEmpList() {
        return insertPosiEmpList;
    }

    /**
     * 设置新增岗位人员列表。
     * 
     * @param insertPosiEmpList
     *        新增岗位人员列表。
     */
    public void setInsertPosiEmpList(List<Map<String, Object>> insertPosiEmpList) {
        this.insertPosiEmpList = insertPosiEmpList;
    }

    /**
     * 获取修改岗位人员列表。
     * 
     * @return 修改岗位人员列表。
     */
    public List<Map<String, Object>> getUpdatePosiEmpList() {
        return updatePosiEmpList;
    }

    /**
     * 设置修改岗位人员列表。
     * 
     * @param updatePosiEmpList
     *        修改岗位人员列表。
     */
    public void setUpdatePosiEmpList(List<Map<String, Object>> updatePosiEmpList) {
        this.updatePosiEmpList = updatePosiEmpList;
    }

    /**
     * 获取删除岗位人员列表。
     * 
     * @return 删除岗位人员列表。
     */
    public List<Map<String, Object>> getDeletePosiEmpList() {
        return deletePosiEmpList;
    }

    /**
     * 设置删除岗位人员列表。
     * 
     * @param deletePosiEmpList
     *        删除岗位人员列表。
     */
    public void setDeletePosiEmpList(List<Map<String, Object>> deletePosiEmpList) {
        this.deletePosiEmpList = deletePosiEmpList;
    }

    /**
     * 获取新增人员关系列表。
     * 
     * @return 新增人员关系列表。
     */
    public List<Map<String, Object>> getInsertEmpRelationList() {
        return insertEmpRelationList;
    }

    /**
     * 设置新增人员关系列表。
     * 
     * @param insertEmpRelationList
     *        新增人员关系列表。
     */
    public void setInsertEmpRelationList(List<Map<String, Object>> insertEmpRelationList) {
        this.insertEmpRelationList = insertEmpRelationList;
    }

    /**
     * 获取修改人员关系列表。
     * 
     * @return 修改人员关系列表。
     */
    public List<Map<String, Object>> getUpdateEmpRelationList() {
        return updateEmpRelationList;
    }

    /**
     * 设置修改人员关系列表。
     * 
     * @param updateEmpRelationList
     *        修改人员关系列表。
     */
    public void setUpdateEmpRelationList(List<Map<String, Object>> updateEmpRelationList) {
        this.updateEmpRelationList = updateEmpRelationList;
    }

    /**
     * 获取删除人员关系列表。
     * 
     * @return 删除人员关系列表。
     */
    public List<Map<String, Object>> getDeleteEmpRelationList() {
        return deleteEmpRelationList;
    }

    /**
     * 设置删除人员关系列表。
     * 
     * @param deleteEmpRelationList
     *        删除人员关系列表。
     */
    public void setDeleteEmpRelationList(List<Map<String, Object>> deleteEmpRelationList) {
        this.deleteEmpRelationList = deleteEmpRelationList;
    }

    @Override
    public String toString() {
        return "OrgnChange [insertOrgList=" + insertOrgList + ", updateOrgList=" + updateOrgList + ", deleteOrgList=" + deleteOrgList + ", insertDutyList=" + insertDutyList + ", updateDutyList=" + updateDutyList + ", deleteDutyList=" + deleteDutyList + ", insertPosiList=" + insertPosiList + ", updatePosiList=" + updatePosiList + ", deletePosiList=" + deletePosiList + ", insertEmpList=" + insertEmpList + ", updateEmpList=" + updateEmpList + ", deleteEmpList=" + deleteEmpList + ", insertPosiEmpList=" + insertPosiEmpList + ", updatePosiEmpList=" + updatePosiEmpList + ", deletePosiEmpList=" + deletePosiEmpList + ", insertEmpRelationList=" + insertEmpRelationList + ", updateEmpRelationList=" + updateEmpRelationList + ", deleteEmpRelationList=" + deleteEmpRelationList + "]";
    }
}