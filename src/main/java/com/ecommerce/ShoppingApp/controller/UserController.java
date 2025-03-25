package com.ecommerce.ShoppingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.ShoppingApp.entity.Person;
import com.ecommerce.ShoppingApp.entity.Roles;
import com.ecommerce.ShoppingApp.service.UserService;


@Controller
@RequestMapping("/public")
public class UserController {
	@Autowired
	private UserService userServices;
	
	@GetMapping("/register")
	public String registrationPage(Model model)
	{
		model.addAttribute("user", new Person());
		return "registration";
	}
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute("User") Person user) 
	{
		//System.out.println("User details "+user.get()+" "+user.getUserPassword()+" "+user.getUserPasswordcnfrm());
		Person person = userServices.findByPersonEmail(user.getPersonEmail());
		
		if(person!=null)return "redirect:/public/register";
		Roles role = new Roles();
		role.setRoleName("USER");
		user.setRole(role);
		userServices.save(user);
		return "redirect:/products";
	}
	@GetMapping("/dashboard")
	public String dashboard(Model model,Authentication authentication)
	{
		if(authentication!=null)
		{
			Person person = userServices.findByPersonEmail(authentication.getName());
			model.addAttribute("person", person);
			model.addAttribute("username", authentication.getName());
	        model.addAttribute("roles", authentication.getAuthorities().toString());
	        System.out.println(person); 
		}
		return "home.html";
	}

}
