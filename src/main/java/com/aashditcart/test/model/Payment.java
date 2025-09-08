package com.aashditcart.test.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "payments")
public class Payment {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name = "paymentMode")
	    private String paymentMode;
	    
	    @Column(name = "amount")
	    private double amount;
	    
	    @Column(name = "transactionId")
	    private String transactionId;
	    
	    @Column(name = "status")
	    private String status;
	    
	    @OneToOne
	    @JoinColumn(name = "order_id", nullable = true)
	    private Order order;
}
