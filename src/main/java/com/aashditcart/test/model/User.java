package com.aashditcart.test.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
	
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
	
	@Column(name = "phnoneNumber")
    private String phoneNumber;
	
	@Column(name = "password")
    private String password;
	
	@Column(name = "role")
    private String role = "CUSTOMER"; 
	
	@Column(name = "gender")
    private String gender;
	
	@DateTimeFormat(pattern = "DD-MM-YYYY")
    private LocalDate dateOfBirth;  
	
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addresses;
    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

}
