package com.aashditcart.test.model;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "stock") 
	private int stock;
	
	@Column(name = "product_image_path")
	private String imageUrl;
	
//	@Column(name = "product_image_path")
//	private String imagePath;
	
//	@Column(name = "is_active")
//	private Boolean isActive;
	
//	@Transient
//	private MultipartFile  image;
}
