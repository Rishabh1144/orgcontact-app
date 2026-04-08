package com.rishabh.orgcontactapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishabh.orgcontactapp.dao.ContactDao;
import com.rishabh.orgcontactapp.dao.OrganizationDao;
import com.rishabh.orgcontactapp.model.Contact;
import com.rishabh.orgcontactapp.model.Organization;

@Service
public class ContactService {
	
	@Autowired
	private ContactDao contactDao;
	@Autowired
	private OrganizationDao orgDao;
	
	
	public List<Contact> getContactsByOrg(int orgId){
		
		List<Contact> contacts = contactDao.getAllContactsOfOrg(orgId);
		
		return contacts;
	}
	
	
	public Contact getContactById(int contactId) {
		
		Contact contact = contactDao.getContactById(contactId);
		
		return contact;
	}
	
	
	@Transactional
	public boolean addContact(Contact contact, int orgId) {
		Contact existingContact = contactDao.getContactByPhoneAndOrg(contact.getPhone(), orgId);
		
		if(existingContact != null) {
			return false;
		}
		
		Organization org = orgDao.getOrgById(orgId);
		contact.setOrg(org);
		contact.setProfileImageUrl("default");
		
		int id = contactDao.saveContact(contact);
		
		if(id>0) {
			return true;
		}
		
		return false;
	}
	
	
	@Transactional
	public void updateContact(Contact contact, int orgId) {
		Organization org = orgDao.getOrgById(orgId);
		contact.setProfileImageUrl("default");
		contact.setOrg(org);
		contactDao.updateContact(contact);
	}
	
	
	@Transactional
	public void deleteContact(int contactId) {
		
		Contact contact = contactDao.getContactById(contactId);
		contactDao.deleteContact(contact);
	}
	
	
	public boolean checkContactUser(String phone, int orgId) {		
		Contact contact = contactDao.getContactByPhoneAndOrg(phone, orgId);
		
		if(contact!=null) {
			return true;
		}
		return false;
	}
	
	
}
