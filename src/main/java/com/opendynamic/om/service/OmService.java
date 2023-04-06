package com.opendynamic.om.service;

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

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface OmService {
    public OrgnSetQuery createOrgnSetQuery();

    public ParentOrgnSetQuery createParentOrgnSetQuery();

    public ChildOrgnSetQuery createChildOrgnSetQuery();

    public DutyQuery createDutyQuery();

    public OrgQuery createOrgQuery();

    public ParentOrgQuery createParentOrgQuery();

    public ChildOrgQuery createChildOrgQuery();

    public PosiQuery createPosiQuery();

    public EmpQuery createEmpQuery();

    public PosiEmpQuery createPosiEmpQuery();

    public EmpRelationQuery createEmpRelationQuery();
}