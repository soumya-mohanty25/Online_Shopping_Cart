package com.aashditcart.test.service;

import java.util.List;

import com.aashditcart.test.model.OrderItem;



public interface OrderItemService {

	List<OrderItem> getAllOrderItems();
	void saveOrderItem(OrderItem orderItem);
	void deleteOrderItem(Long id);
	
}
