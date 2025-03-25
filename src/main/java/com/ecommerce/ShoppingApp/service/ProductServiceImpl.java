package com.ecommerce.ShoppingApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ShoppingApp.entity.Product;
import com.ecommerce.ShoppingApp.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public void deleteById(long productId) {
		// TODO Auto-generated method stub
		productRepository.deleteById(productId);
	}

	@Override
	public Object getProductById(long productId) {
		// TODO Auto-generated method stub
		Optional<Product> opt =  productRepository.findById(productId);
		
		if(opt.isPresent())
			return opt.get();
		throw new RuntimeException("Product not found");
	}

	@Override
	public Product findById(long productId) {
		// TODO Auto-generated method stub
		Optional<Product> opt =  productRepository.findById(productId);
		
		if(opt.isPresent())
			return opt.get();
		throw new RuntimeException("Product not found");
	}


}
