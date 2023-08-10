package com.opendynamic.om.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.opendynamic.om.service.OmDutyService;
import com.opendynamic.om.vo.Duty;

@Service
public class DutyQuery {
    private OmDutyService omDutyService;

    private String orgnSetId;
    private String orgnSetCode;
    private String dutyId;
    private List<String> dutyIdList;
    private String dutyCode;
    private List<String> dutyCodeList;
    private String dutyName;
    private List<String> dutyNameList;
    private String dutyCategory;
    private List<String> dutyCategoryList;
    private String dutyTag;
    private String dutyExtAttr1;
    private List<String> dutyExtAttr1List;
    private String dutyExtAttr2;
    private List<String> dutyExtAttr2List;
    private String dutyExtAttr3;
    private List<String> dutyExtAttr3List;
    private String dutyExtAttr4;
    private List<String> dutyExtAttr4List;
    private String dutyExtAttr5;
    private List<String> dutyExtAttr5List;
    private String dutyExtAttr6;
    private List<String> dutyExtAttr6List;
    private String dutyExtAttr7;
    private List<String> dutyExtAttr7List;
    private String dutyExtAttr8;
    private List<String> dutyExtAttr8List;
    private String dutyStatus;
    private List<String> dutyStatusList;
    private Boolean dutyTagUnion;
    private Integer page;
    private Integer limit;
    private String operatorId;
    private String operatorName;

    public DutyQuery(OmDutyService omDutyService) {
        super();
        this.omDutyService = omDutyService;
    }

    public DutyQuery setOrgnSetId(String orgnSetId) {
        this.orgnSetId = orgnSetId;
        return this;
    }

    public DutyQuery setOrgnSetCode(String orgnSetCode) {
        this.orgnSetCode = orgnSetCode;
        return this;
    }

    public DutyQuery setDutyId(String dutyId) {
        this.dutyId = dutyId;
        return this;
    }

    public DutyQuery setDutyIdList(List<String> dutyIdList) {
        this.dutyIdList = dutyIdList;
        return this;
    }

    public DutyQuery setDutyCode(String dutyCode) {
        this.dutyCode = dutyCode;
        return this;
    }

    public DutyQuery setDutyCodeList(List<String> dutyCodeList) {
        this.dutyCodeList = dutyCodeList;
        return this;
    }

    public DutyQuery setDutyName(String dutyName) {
        this.dutyName = dutyName;
        return this;
    }

    public DutyQuery setDutyNameList(List<String> dutyNameList) {
        this.dutyNameList = dutyNameList;
        return this;
    }

    public DutyQuery setDutyCategory(String dutyCategory) {
        this.dutyCategory = dutyCategory;
        return this;
    }

    public DutyQuery setDutyCategoryList(List<String> dutyCategoryList) {
        this.dutyCategoryList = dutyCategoryList;
        return this;
    }

    public DutyQuery setDutyTag(String dutyTag) {
        this.dutyTag = dutyTag;
        return this;
    }

    public DutyQuery setDutyExtAttr1(String dutyExtAttr1) {
        this.dutyExtAttr1 = dutyExtAttr1;
        return this;
    }

    public DutyQuery setDutyExtAttr1List(List<String> dutyExtAttr1List) {
        this.dutyExtAttr1List = dutyExtAttr1List;
        return this;
    }

    public DutyQuery setDutyExtAttr2(String dutyExtAttr2) {
        this.dutyExtAttr2 = dutyExtAttr2;
        return this;
    }

    public DutyQuery setDutyExtAttr2List(List<String> dutyExtAttr2List) {
        this.dutyExtAttr2List = dutyExtAttr2List;
        return this;
    }

    public DutyQuery setDutyExtAttr3(String dutyExtAttr3) {
        this.dutyExtAttr3 = dutyExtAttr3;
        return this;
    }

    public DutyQuery setDutyExtAttr3List(List<String> dutyExtAttr3List) {
        this.dutyExtAttr3List = dutyExtAttr3List;
        return this;
    }

    public DutyQuery setDutyExtAttr4(String dutyExtAttr4) {
        this.dutyExtAttr4 = dutyExtAttr4;
        return this;
    }

    public DutyQuery setDutyExtAttr4List(List<String> dutyExtAttr4List) {
        this.dutyExtAttr4List = dutyExtAttr4List;
        return this;
    }

    public DutyQuery setDutyExtAttr5(String dutyExtAttr5) {
        this.dutyExtAttr5 = dutyExtAttr5;
        return this;
    }

    public DutyQuery setDutyExtAttr5List(List<String> dutyExtAttr5List) {
        this.dutyExtAttr5List = dutyExtAttr5List;
        return this;
    }

    public DutyQuery setDutyExtAttr6(String dutyExtAttr6) {
        this.dutyExtAttr6 = dutyExtAttr6;
        return this;
    }

    public DutyQuery setDutyExtAttr6List(List<String> dutyExtAttr6List) {
        this.dutyExtAttr6List = dutyExtAttr6List;
        return this;
    }

    public DutyQuery setDutyExtAttr7(String dutyExtAttr7) {
        this.dutyExtAttr7 = dutyExtAttr7;
        return this;
    }

    public DutyQuery setDutyExtAttr7List(List<String> dutyExtAttr7List) {
        this.dutyExtAttr7List = dutyExtAttr7List;
        return this;
    }

    public DutyQuery setDutyExtAttr8(String dutyExtAttr8) {
        this.dutyExtAttr8 = dutyExtAttr8;
        return this;
    }

    public DutyQuery setDutyExtAttr8List(List<String> dutyExtAttr8List) {
        this.dutyExtAttr8List = dutyExtAttr8List;
        return this;
    }

    public DutyQuery setDutyStatus(String dutyStatus) {
        this.dutyStatus = dutyStatus;
        return this;
    }

    public DutyQuery setDutyStatusList(List<String> dutyStatusList) {
        this.dutyStatusList = dutyStatusList;
        return this;
    }

    public DutyQuery setDutyTagUnion(Boolean dutyTagUnion) {
        this.dutyTagUnion = dutyTagUnion;
        return this;
    }

    public DutyQuery setPage(Integer page) {
        this.page = page;
        return this;
    }

    public DutyQuery setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public DutyQuery setOperatorId(String operatorId) {
        this.operatorId = operatorId;
        return this;
    }

    public DutyQuery setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }

    public List<Map<String, Object>> queryForMapList() {
        return omDutyService.selectDuty(orgnSetId, orgnSetCode, dutyId, dutyIdList, dutyCode, dutyCodeList, dutyName, dutyNameList, dutyCategory, dutyCategoryList, dutyTag, dutyExtAttr1, dutyExtAttr1List, dutyExtAttr2, dutyExtAttr2List, dutyExtAttr3, dutyExtAttr3List, dutyExtAttr4, dutyExtAttr4List, dutyExtAttr5, dutyExtAttr5List, dutyExtAttr6, dutyExtAttr6List, dutyExtAttr7, dutyExtAttr7List, dutyExtAttr8, dutyExtAttr8List, dutyStatus, dutyStatusList, dutyTagUnion, page, limit, operatorId, operatorName);
    }

    public Map<String, Object> queryForMap() {
        List<Map<String, Object>> result = queryForMapList();
        if (result.size() == 1) {
            return result.get(0);
        }
        else {
            return null;
        }
    }

    public List<Duty> queryForObjectList() {
        List<Map<String, Object>> result = queryForMapList();
        List<Duty> dutyList = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            dutyList.add(new Duty(result.get(i)));
        }

        return dutyList;
    }

    public Duty queryForObject() {
        List<Map<String, Object>> result = queryForMapList();
        if (result.size() == 1) {
            return new Duty(result.get(0));
        }
        else {
            return null;
        }
    }

    public int count() {
        return omDutyService.countDuty(orgnSetId, orgnSetCode, dutyId, dutyIdList, dutyCode, dutyCodeList, dutyName, dutyNameList, dutyCategory, dutyCategoryList, dutyTag, dutyExtAttr1, dutyExtAttr1List, dutyExtAttr2, dutyExtAttr2List, dutyExtAttr3, dutyExtAttr3List, dutyExtAttr4, dutyExtAttr4List, dutyExtAttr5, dutyExtAttr5List, dutyExtAttr6, dutyExtAttr6List, dutyExtAttr7, dutyExtAttr7List, dutyExtAttr8, dutyExtAttr8List, dutyStatus, dutyStatusList, dutyTagUnion, operatorId, operatorName);
    }
}