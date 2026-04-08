package com.rishabh.orgcontactapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishabh.orgcontactapp.dao.OrganizationDao;
import com.rishabh.orgcontactapp.model.Organization;

@Service
public class OrgService {
	@Autowired
	private OrganizationDao organizationDao;
	
	public Organization getOrganizationDetails(int orgId) {
		
		return organizationDao.getOrgById(orgId);
	}
}
