package com.rishabh.orgcontactapp.dao;

import java.util.List;

import com.rishabh.orgcontactapp.model.Contact;

public interface ContactDao {
	public Contact getContactByPhoneAndOrg(String phone, int orgId);
	public Contact getContactById(int contactId);
	public int saveContact(Contact contact);
	public void updateContact(Contact contact);
	public void deleteContact(Contact contact);
	public Contact getContactByPhone(String phone);
	public List<Contact> getAllContactsOfOrg(int orgId);
}
