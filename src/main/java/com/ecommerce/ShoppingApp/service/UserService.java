package com.ecommerce.ShoppingApp.service;

import com.ecommerce.ShoppingApp.entity.Person;


public interface UserService {

	void save(Person user);

	Person findByPersonEmail(String personEmail);

}
