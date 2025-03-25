package com.ecommerce.ShoppingApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders extends Audit{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	private boolean orderStatus; 
	@ManyToOne
	private Person person;
	@OneToOne
	private Product product;
	private long productCount;
	@JoinColumn(name="productPrice")
	private long productPrice;
	@JoinColumn(name = "productName")
	private String productName;

}

