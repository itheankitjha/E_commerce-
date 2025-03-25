package com.ecommerce.ShoppingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.ShoppingApp.entity.Person;
import com.ecommerce.ShoppingApp.entity.Product;
import com.ecommerce.ShoppingApp.repository.UserRepository;
import com.ecommerce.ShoppingApp.service.ProductService;

@Controller
public class ProductContoller {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/addProduct")
	public String addProductPage(Model model,Authentication authentication)
	{ 
		Person person = userRepository.findByPersonEmail(authentication.getName());
		if(person.getRole().getRoleName().equals("ADMIN")==false)return "redirect:/products";
		
		Product product = new Product();
		model.addAttribute("product", product);
		return "add_product";
	} 
	 
	@PostMapping("/addProduct") 
	public String addProduct(@ModelAttribute("Product") Product product,Authentication authentication)
	{
		Person person = userRepository.findByPersonEmail(authentication.getName());
		if(person.getRole().getRoleName().equals("ADMIN")==false)return "redirect:/products";
		
		productService.save(product);
		return "redirect:/products"; 
	}
	
	@GetMapping(value = {"/","/products"})
	public String getAllProducts(Model model, Authentication authentication)
	{
		List<Product> products = productService.getAllProducts();
		if(authentication!=null)
		{
			model.addAttribute("username", authentication.getName());
	        model.addAttribute("roles", authentication.getAuthorities().toString());
	        System.out.println(authentication.getAuthorities().toString()); 
		}
		
		model.addAttribute("products",products);
		
		return "userViewProduct";
	}
	@GetMapping("/updateProduct/{productId}")
	public String updateProduct(@PathVariable("productId") long productId,Model model, Authentication authentication)
	{
		Person person = userRepository.findByPersonEmail(authentication.getName());
		if(person.getRole().getRoleName().equals("ADMIN")==false)return "redirect:/products";
		model.addAttribute("product", productService.getProductById(productId));
		Product product = productService.findById(productId);
		if(product!=null)
			productService.save(product);
		return "update_product";
	}
	
	@GetMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") long productId, Authentication authentication)
	{
		Person person = userRepository.findByPersonEmail(authentication.getName());
		if(person.getRole().getRoleName().equals("ADMIN")==false)return "redirect:/products";
		productService.deleteById(productId);
		return "redirect:/products";
	}
}
