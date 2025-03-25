package com.ecommerce.ShoppingApp.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person extends Audit{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long personId;
	private String personName;
	private String personEmail;
	private String personPassword;
	private String personPasswordConfirm;
	private String personMobile;
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST,targetEntity = Roles.class)
	private Roles role;
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST,targetEntity = Orders.class)
	private List<Orders> orders;
	

}
