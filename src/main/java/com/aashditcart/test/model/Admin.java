package com.aashditcart.test.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "admins")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "firstName")
    private String firstName;
  
	@Column(name = "lastName")
    private String lastName;
	
	@Column(name = "username")
    private String username;
	
	@Column(name = "email")
    private String email; 
	
	@Column(name = "password")
    private String password;
	
	@Column(name = "role")
    private String role = "ADMIN";
	
}
