package com.opendynamic.om.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class OrgnChange implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Map<String, Object>> insertOrgList;
    private List<Map<String, Object>> updateOrgList;
    private List<Map<String, Object>> deleteOrgList;
    private List<Map<String, Object>> insertDutyList;
    private List<Map<String, Object>> updateDutyList;
    private List<Map<String, Object>> deleteDutyList;
    private List<Map<String, Object>> insertPosiList;
    private List<Map<String, Object>> updatePosiList;
    private List<Map<String, Object>> deletePosiList;
    private List<Map<String, Object>> insertEmpList;
    private List<Map<String, Object>> updateEmpList;
    private List<Map<String, Object>> deleteEmpList;
    private List<Map<String, Object>> insertPosiEmpList;
    private List<Map<String, Object>> updatePosiEmpList;
    private List<Map<String, Object>> deletePosiEmpList;
    private List<Map<String, Object>> insertEmpRelationList;
    private List<Map<String, Object>> updateEmpRelationList;
    private List<Map<String, Object>> deleteEmpRelationList;

    public List<Map<String, Object>> getInsertOrgList() {
        return insertOrgList;
    }

    public void setInsertOrgList(List<Map<String, Object>> insertOrgList) {
        this.insertOrgList = insertOrgList;
    }

    public List<Map<String, Object>> getUpdateOrgList() {
        return updateOrgList;
    }

    public void setUpdateOrgList(List<Map<String, Object>> updateOrgList) {
        this.updateOrgList = updateOrgList;
    }

    public List<Map<String, Object>> getDeleteOrgList() {
        return deleteOrgList;
    }

    public void setDeleteOrgList(List<Map<String, Object>> deleteOrgList) {
        this.deleteOrgList = deleteOrgList;
    }

    public List<Map<String, Object>> getInsertDutyList() {
        return insertDutyList;
    }

    public void setInsertDutyList(List<Map<String, Object>> insertDutyList) {
        this.insertDutyList = insertDutyList;
    }

    public List<Map<String, Object>> getUpdateDutyList() {
        return updateDutyList;
    }

    public void setUpdateDutyList(List<Map<String, Object>> updateDutyList) {
        this.updateDutyList = updateDutyList;
    }

    public List<Map<String, Object>> getDeleteDutyList() {
        return deleteDutyList;
    }

    public void setDeleteDutyList(List<Map<String, Object>> deleteDutyList) {
        this.deleteDutyList = deleteDutyList;
    }

    public List<Map<String, Object>> getInsertPosiList() {
        return insertPosiList;
    }

    public void setInsertPosiList(List<Map<String, Object>> insertPosiList) {
        this.insertPosiList = insertPosiList;
    }

    public List<Map<String, Object>> getUpdatePosiList() {
        return updatePosiList;
    }

    public void setUpdatePosiList(List<Map<String, Object>> updatePosiList) {
        this.updatePosiList = updatePosiList;
    }

    public List<Map<String, Object>> getDeletePosiList() {
        return deletePosiList;
    }

    public void setDeletePosiList(List<Map<String, Object>> deletePosiList) {
        this.deletePosiList = deletePosiList;
    }

    public List<Map<String, Object>> getInsertEmpList() {
        return insertEmpList;
    }

    public void setInsertEmpList(List<Map<String, Object>> insertEmpList) {
        this.insertEmpList = insertEmpList;
    }

    public List<Map<String, Object>> getUpdateEmpList() {
        return updateEmpList;
    }

    public void setUpdateEmpList(List<Map<String, Object>> updateEmpList) {
        this.updateEmpList = updateEmpList;
    }

    public List<Map<String, Object>> getDeleteEmpList() {
        return deleteEmpList;
    }

    public void setDeleteEmpList(List<Map<String, Object>> deleteEmpList) {
        this.deleteEmpList = deleteEmpList;
    }

    public List<Map<String, Object>> getInsertPosiEmpList() {
        return insertPosiEmpList;
    }

    public void setInsertPosiEmpList(List<Map<String, Object>> insertPosiEmpList) {
        this.insertPosiEmpList = insertPosiEmpList;
    }

    public List<Map<String, Object>> getUpdatePosiEmpList() {
        return updatePosiEmpList;
    }

    public void setUpdatePosiEmpList(List<Map<String, Object>> updatePosiEmpList) {
        this.updatePosiEmpList = updatePosiEmpList;
    }

    public List<Map<String, Object>> getDeletePosiEmpList() {
        return deletePosiEmpList;
    }

    public void setDeletePosiEmpList(List<Map<String, Object>> deletePosiEmpList) {
        this.deletePosiEmpList = deletePosiEmpList;
    }

    public List<Map<String, Object>> getInsertEmpRelationList() {
        return insertEmpRelationList;
    }

    public void setInsertEmpRelationList(List<Map<String, Object>> insertEmpRelationList) {
        this.insertEmpRelationList = insertEmpRelationList;
    }

    public List<Map<String, Object>> getUpdateEmpRelationList() {
        return updateEmpRelationList;
    }

    public void setUpdateEmpRelationList(List<Map<String, Object>> updateEmpRelationList) {
        this.updateEmpRelationList = updateEmpRelationList;
    }

    public List<Map<String, Object>> getDeleteEmpRelationList() {
        return deleteEmpRelationList;
    }

    public void setDeleteEmpRelationList(List<Map<String, Object>> deleteEmpRelationList) {
        this.deleteEmpRelationList = deleteEmpRelationList;
    }

    @Override
    public String toString() {
        return "OrgnChange [insertOrgList=" + insertOrgList + ", updateOrgList=" + updateOrgList + ", deleteOrgList=" + deleteOrgList + ", insertDutyList=" + insertDutyList + ", updateDutyList=" + updateDutyList + ", deleteDutyList=" + deleteDutyList + ", insertPosiList=" + insertPosiList + ", updatePosiList=" + updatePosiList + ", deletePosiList=" + deletePosiList + ", insertEmpList=" + insertEmpList + ", updateEmpList=" + updateEmpList + ", deleteEmpList=" + deleteEmpList + ", insertPosiEmpList=" + insertPosiEmpList + ", updatePosiEmpList=" + updatePosiEmpList + ", deletePosiEmpList=" + deletePosiEmpList + ", insertEmpRelationList=" + insertEmpRelationList + ", updateEmpRelationList=" + updateEmpRelationList + ", deleteEmpRelationList=" + deleteEmpRelationList + "]";
    }
}