package com.aashditcart.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashditcart.test.model.Product;
import com.aashditcart.test.repository.ProductRepository;
import com.aashditcart.test.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public Product getProductById(Long productId) {
		return productRepository.findById(productId).orElse(null);
	}

	@Override
	public List<Product> searchByName(String keyword) {
		return productRepository.findByNameContainingIgnoreCase(keyword);
	}	

	
}
