package com.aashditcart.test.service;

import java.util.List;

import com.aashditcart.test.model.Product;

public interface ProductService {

	Product saveProduct(Product product);
	List<Product> getAllProducts();
	Product getProductById(Long productId);
	Product updateProduct(Product product);
	void deleteProduct(Long id);
	List<Product> searchByName(String keyword);

}
