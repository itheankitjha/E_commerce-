package com.ecommerce.ShoppingApp.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.ShoppingApp.entity.Orders;
import com.ecommerce.ShoppingApp.entity.Person;
import com.ecommerce.ShoppingApp.entity.Product;
import com.ecommerce.ShoppingApp.repository.ProductRepository;
import com.ecommerce.ShoppingApp.repository.UserRepository;
import com.ecommerce.ShoppingApp.service.OrdersService;

@Controller
public class OrdersController {
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/orders")
	public String showOrders(Model model, Authentication authentication) 
	{
		//System.out.println(authentication.getName());
		List<Orders> orders = ordersService.findAllByName(authentication.getName());
		Collections.sort(orders,(a,b)->a.getProductName().compareTo(b.getProductName()));
		model.addAttribute("orders",orders); 
		return "orders";
	}
	
	@GetMapping("/addProductDB/{productId}")
	public String addProduct(@PathVariable("productId") long productId,Authentication authentication)
	{
		Person person = userRepository.findByPersonEmail(authentication.getName());
		Optional<Product> product = productRepository.findById(productId);
		if(product==null)return "redirect:/products";
		Orders orders = new Orders();
		orders.setPerson(person);
		orders.setProduct(product.get());
		orders.setProductCount(1); 
		orders.setProductPrice(product.get().getProductPrice());
		orders.setProductName(product.get().getProductName());
		//System.out.println(orders+" -------------->");
		Orders order = ordersService.findByProductDetails(person.getPersonId(),product.get().getProductId());
		//System.out.println(order.getProductCount()+" ------------->");
		if(order==null)ordersService.save(orders);
		else ordersService.updateByPersonProductId(person.getPersonId(),product.get().getProductId(),order.getProductCount()+1);
		
		return "redirect:/products";
	}
	
	@GetMapping("/addProductDBPlus/{productId}")
	public String addProductDBPlus(@PathVariable("productId") long productId,Authentication authentication)
	{
		//System.out.println("------->");
		Person person = userRepository.findByPersonEmail(authentication.getName());
		Optional<Product> product = productRepository.findById(productId);
		if(product==null)return "redirect:/products";
		Orders orders = new Orders();
		orders.setPerson(person);
		orders.setProduct(product.get());
		orders.setProductCount(1); 
		orders.setProductPrice(product.get().getProductPrice());
		orders.setProductName(product.get().getProductName());
		//System.out.println(orders+" -------------->");
		Orders order = ordersService.findByProductDetails(person.getPersonId(),product.get().getProductId());
		//System.out.println(order.getProductCount()+" ------------->");
		if(order==null)ordersService.save(orders);
		else ordersService.updateByPersonProductId(person.getPersonId(),product.get().getProductId(),order.getProductCount()+1);
		
		return "redirect:/orders";
	}
	@GetMapping("/addProductDBMinus/{productId}")
	public String addProductDBMinus(@PathVariable("productId") long productId,Authentication authentication)
	{
		//System.out.println("------->");
		Person person = userRepository.findByPersonEmail(authentication.getName());
		Optional<Product> product = productRepository.findById(productId);
		if(product==null)return "redirect:/products";
		Orders orders = new Orders();
		orders.setPerson(person);
		orders.setProduct(product.get());
		orders.setProductCount(1); 
		orders.setProductPrice(product.get().getProductPrice());
		orders.setProductName(product.get().getProductName());
		//System.out.println(orders+" -------------->");
		Orders order = ordersService.findByProductDetails(person.getPersonId(),product.get().getProductId());
		System.out.println(order.getProductCount()+" ------------->");
		if(order.getProductCount()>0) ordersService.updateByPersonProductId(person.getPersonId(),product.get().getProductId(),order.getProductCount()-1);
		if(order!=null && order.getProductCount()-1==0) ordersService.deleteBy(order);
		
		return "redirect:/orders";
	}

}
