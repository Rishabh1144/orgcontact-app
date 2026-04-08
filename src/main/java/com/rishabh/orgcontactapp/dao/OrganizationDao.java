package com.rishabh.orgcontactapp.dao;

import com.rishabh.orgcontactapp.model.Organization;

public interface OrganizationDao {
	public Organization getOrgByEmail(String email);
	public Organization getOrgById(int orgId);
	public int saveOrg(Organization org);
}
