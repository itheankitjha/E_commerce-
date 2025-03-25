package com.ecommerce.ShoppingApp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends Audit{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long productId;
	private String productName;
	private long productQuantity;
	private long productPrice;
 
}
