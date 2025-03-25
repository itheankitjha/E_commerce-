package com.ecommerce.ShoppingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ShoppingApp.entity.Person;


public interface UserRepository extends JpaRepository<Person, Long>{

	Person findByPersonEmail(String name);

}
