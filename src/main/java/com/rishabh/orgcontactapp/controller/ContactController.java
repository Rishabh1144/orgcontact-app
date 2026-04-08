package com.rishabh.orgcontactapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rishabh.orgcontactapp.model.Contact;
import com.rishabh.orgcontactapp.service.ContactService;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;
	
	
	@GetMapping("/GetAllContacts")
	@ResponseBody
	public List<Contact> getAllContactsOfOrg(
			@RequestParam("phone") String phone,
			@RequestParam("orgId") Integer orgId){
		
		boolean status = contactService.checkContactUser(phone, orgId);
		
		System.out.println("checking status...");
		if(status) {
			System.out.println("status true");
			return contactService.getContactsByOrg(orgId);
		}
		System.out.println("status false");
		
		return new ArrayList<Contact>();
	}
			
			
}
