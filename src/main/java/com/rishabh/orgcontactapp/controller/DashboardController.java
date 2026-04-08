package com.rishabh.orgcontactapp.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rishabh.orgcontactapp.model.Contact;
import com.rishabh.orgcontactapp.service.ContactService;
import com.rishabh.orgcontactapp.service.OrgService;


@Controller
public class DashboardController {
	
	@Autowired
	ContactService contactService;
	@Autowired
	OrgService orgService;
	
	@GetMapping("/dashboard")
	public String openDashboard(HttpSession session, Model model) {	
		
		Integer orgId = (Integer) session.getAttribute("orgId");
		
		if(orgId == null) return "redirect:/login";
		
		model.addAttribute("contacts", contactService.getContactsByOrg(orgId));
		model.addAttribute("org", orgService.getOrganizationDetails(orgId));
		
		return "dashboard";
	}
	
	
	@PostMapping("/addContact")
	public String addContact(@Valid @ModelAttribute Contact contact, BindingResult result, HttpSession session, Model model) {
		
		Integer orgId = (Integer) session.getAttribute("orgId");
		model.addAttribute("contacts", contactService.getContactsByOrg(orgId));
		
		if(result.hasErrors()) {
			model.addAttribute("error", "something went wrong");
			return "dashboard";
		}		
		
		boolean status = contactService.addContact(contact,orgId);
		
		if(status) {
			return "redirect:/dashboard";
		}
		
		model.addAttribute("error", "contact already exists");
		return "dashboard";
	}
	
	
	@GetMapping("/updateContact/{id}")
	public String openUpdateContactForm(@PathVariable("id") int contactId, Model model) {
		
		model.addAttribute("contact", contactService.getContactById(contactId));
		
		return "updateContact";
	}
	
	@PostMapping("/updateContact")
	public String updateContact(@Valid @ModelAttribute Contact contact, BindingResult result, HttpSession session, Model model) {
		
		Integer orgId = (Integer) session.getAttribute("orgId");
		
		if(result.hasErrors()) {
			model.addAttribute("error", "something went wrong");
			model.addAttribute("contact", contact);
			for(ObjectError obj: result.getAllErrors()) {
				System.out.println(obj);
			}
			return "updateContact";
		}
		
		contactService.updateContact(contact, orgId);
		
		return "redirect:/dashboard";
	}
	
	
	@GetMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable("id") int contactId) {
		
		contactService.deleteContact(contactId);
		
		return "redirect:/dashboard";
	}
}
