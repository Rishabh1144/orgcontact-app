package com.rishabh.orgcontactapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.rishabh.orgcontactapp.model.Organization;

@Repository
public class OrganizationDaoImpl implements OrganizationDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public Organization getOrgByEmail(String email) {
		
		String query = "from Organization where email=:email";
		
		List<Organization> orgs = hibernateTemplate.execute(session -> {
			return session.createQuery(
					query,
					Organization.class)
					.setParameter("email", email)
					.list();
		});
		
		if(orgs.isEmpty()) {
			return null;
		}
		
		return orgs.get(0);
	}
	
	

	@Override
	public int saveOrg(Organization org) {
		
		int id = (Integer) hibernateTemplate.save(org);
		
		return id;
	}



	@Override
	public Organization getOrgById(int orgId) {
		
		Organization org = hibernateTemplate.get(Organization.class, orgId);
		
		return org;
	}

}
