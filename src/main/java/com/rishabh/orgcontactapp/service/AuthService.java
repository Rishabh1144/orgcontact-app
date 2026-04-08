package com.rishabh.orgcontactapp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishabh.orgcontactapp.dao.OrganizationDao;
import com.rishabh.orgcontactapp.model.Organization;

@Service
public class AuthService {
	
	@Autowired
	private OrganizationDao orgDao;
	
	public int login(String email, String password) {
		
		Organization org = orgDao.getOrgByEmail(email);
		
		if(org!=null && org.getPassword().equals(password)) {
			return org.getId();
		}
		
		return -1;
	}
	
	
	@Transactional
	public boolean registerUser(Organization org) {
		
		// check if email already exist
		Organization existingOrg = orgDao.getOrgByEmail(org.getEmail());
		
		if(existingOrg!=null) {
			return false;
		}
		
		//save user in database
		int id = orgDao.saveOrg(org);
		
		if(id>0) {
			return true;
		}
		
		return false;
	}
	
}
