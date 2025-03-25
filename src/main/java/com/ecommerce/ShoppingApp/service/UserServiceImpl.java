package com.ecommerce.ShoppingApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ShoppingApp.entity.Person;
import com.ecommerce.ShoppingApp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public void save(Person user) {
		// TODO Auto-generated method stub
		System.out.println(user+" 000");
		userRepository.save(user);
	}
	@Override
	public Person findByPersonEmail(String personEmail) {
		// TODO Auto-generated method stub
		return userRepository.findByPersonEmail(personEmail);
	}

}
