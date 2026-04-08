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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rishabh.orgcontactapp.model.Organization;
import com.rishabh.orgcontactapp.service.AuthService;

@Controller
public class AuthController {

	@Autowired
	AuthService authService;
	
	@GetMapping("/register")
	public String openRegisterForm() {
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute Organization org, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("error", "Something went wrong");
			return "register";
		}
		
		boolean status = authService.registerUser(org);
		
		if(status) {
			return "redirect:/login";
		}
		else {
			model.addAttribute("error", "account already exist!");
			return "register";
		}
	}
	
	@GetMapping("/login")
	public String openLoginForm() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginUser(
			@RequestParam String email,
			@RequestParam String password,
			HttpSession session,
			Model model) {
		
		int orgId = authService.login(email, password);
		
		if(orgId != -1) {
			session.setAttribute("orgId", orgId);
			return "redirect:/dashboard";
		}
		else {
			model.addAttribute("error", "Invalid Email or Password");
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:login";
	}
	
}
