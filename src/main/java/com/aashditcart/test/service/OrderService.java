package com.aashditcart.test.service;

import java.util.List;

import com.aashditcart.test.model.Order;
import com.aashditcart.test.model.Product;
import com.aashditcart.test.model.User;

public interface OrderService {

	List<Order> getOrdersByUser(User user);
	void placeOrder(User user);
	void removeOrder(Long orderId);
	void updateOrderStatus(Long orderId, String status);
	void placeSingleOrder(User user, Product product, int quantity);
	void setOrderDeliveryAddress(Long orderId, Long addressId);
	List<Order> getAllOrders();
	void removeOrderById(Long orderId);
}
