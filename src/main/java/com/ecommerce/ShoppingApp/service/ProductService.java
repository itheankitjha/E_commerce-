package com.ecommerce.ShoppingApp.service;

import java.util.List;

import com.ecommerce.ShoppingApp.entity.Product;

public interface ProductService {
	public void save(Product product);

	public List<Product> getAllProducts();

	public void deleteById(long productId);

	public Object getProductById(long productId);

	public Product findById(long productId);

	
}
