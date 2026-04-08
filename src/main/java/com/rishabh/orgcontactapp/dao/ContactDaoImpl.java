package com.rishabh.orgcontactapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.rishabh.orgcontactapp.model.Contact;

@Repository
public class ContactDaoImpl implements ContactDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Contact getContactByPhoneAndOrg(String phone, int orgId) {
		
		String query = "from Contact where phone=:phone and org_id=:orgId";
		List<Contact> contacts = hibernateTemplate.execute(session -> {
			return session.createQuery(
					query,
					Contact.class)
					.setParameter("phone", phone)
					.setParameter("orgId", orgId)
					.list();
		});
		
		if(contacts.isEmpty()) {
			return null;
		}
		
		return contacts.get(0);
	}
	
	
	@Override
	public Contact getContactById(int contactId) {
		
		Contact contact = hibernateTemplate.get(Contact.class, contactId);
		
		return contact;
	}

	
	@Override
	public int saveContact(Contact contact) {
		
		Integer id = (Integer) hibernateTemplate.save(contact);
		
		return id;
	}


	@Override
	public void updateContact(Contact contact) {
		
		hibernateTemplate.merge(contact);
	}


	@Override
	public void deleteContact(Contact contact) {
		
		hibernateTemplate.delete(contact);
		
	}


	@Override
	public Contact getContactByPhone(String phone) {
		
		String query = "from Contact where phone=:phone";
		List<Contact> contacts = hibernateTemplate.execute(session -> {
			return session.createQuery(
					query,
					Contact.class)
					.setParameter("phone", phone)
					.list();
		}); 
		
		if(contacts.isEmpty()) {
			return null;
		}
		
		
		return contacts.get(0);
	}


	@Override
	public List<Contact> getAllContactsOfOrg(int orgId) {
		
		String query = "from Contact where org_id=:orgId";
		List<Contact> contacts = hibernateTemplate.execute(session -> {
			return session.createQuery(
					query,
					Contact.class)
					.setParameter("orgId", orgId)
					.list();
		});
		
		if(contacts.isEmpty()) {
			return new ArrayList<>();
		}
		
		return contacts;
	}
	
	
	
	
	
}
