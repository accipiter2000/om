package com.opendynamic.om.service.impl.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.opendynamic.om.query.ChildOrgQuery;
import com.opendynamic.om.query.ChildOrgnSetQuery;
import com.opendynamic.om.query.DutyQuery;
import com.opendynamic.om.query.EmpQuery;
import com.opendynamic.om.query.EmpRelationQuery;
import com.opendynamic.om.query.OrgQuery;
import com.opendynamic.om.query.OrgnSetQuery;
import com.opendynamic.om.query.ParentOrgQuery;
import com.opendynamic.om.query.ParentOrgnSetQuery;
import com.opendynamic.om.query.PosiEmpQuery;
import com.opendynamic.om.query.PosiQuery;
import com.opendynamic.om.service.OmDutyService;
import com.opendynamic.om.service.OmEmpRelationService;
import com.opendynamic.om.service.OmEmpService;
import com.opendynamic.om.service.OmOrgService;
import com.opendynamic.om.service.OmOrgnSetService;
import com.opendynamic.om.service.OmPosiEmpService;
import com.opendynamic.om.service.OmPosiService;
import com.opendynamic.om.service.OmService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class OmServiceImpl implements OmService {
    @Autowired
    private OmOrgnSetService omOrgnSetService;
    @Autowired
    private OmDutyService omDutyService;
    @Autowired
    private OmOrgService omOrgService;
    @Autowired
    private OmPosiService omPosiService;
    @Autowired
    private OmEmpService omEmpService;
    @Autowired
    private OmPosiEmpService omPosiEmpService;
    @Autowired
    private OmEmpRelationService omEmpRelationService;

    @Override
    public OrgnSetQuery createOrgnSetQuery() {
        return new OrgnSetQuery(omOrgnSetService);
    }

    @Override
    public ParentOrgnSetQuery createParentOrgnSetQuery() {
        return new ParentOrgnSetQuery(omOrgnSetService);
    }

    @Override
    public ChildOrgnSetQuery createChildOrgnSetQuery() {
        return new ChildOrgnSetQuery(omOrgnSetService);
    }

    @Override
    public DutyQuery createDutyQuery() {
        return new DutyQuery(omDutyService);
    }

    @Override
    public OrgQuery createOrgQuery() {
        return new OrgQuery(omOrgService);
    }

    @Override
    public ParentOrgQuery createParentOrgQuery() {
        return new ParentOrgQuery(omOrgService);
    }

    @Override
    public ChildOrgQuery createChildOrgQuery() {
        return new ChildOrgQuery(omOrgService);
    }

    @Override
    public PosiQuery createPosiQuery() {
        return new PosiQuery(omPosiService);
    }

    @Override
    public EmpQuery createEmpQuery() {
        return new EmpQuery(omEmpService);
    }

    @Override
    public PosiEmpQuery createPosiEmpQuery() {
        return new PosiEmpQuery(omPosiEmpService);
    }

    @Override
    public EmpRelationQuery createEmpRelationQuery() {
        return new EmpRelationQuery(omEmpRelationService);
    }
}