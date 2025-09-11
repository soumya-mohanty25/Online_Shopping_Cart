package com.aashditcart.test.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashditcart.test.model.Cart;
import com.aashditcart.test.model.CartItem;
import com.aashditcart.test.model.Order;
import com.aashditcart.test.model.OrderItem;
import com.aashditcart.test.model.Product;
import com.aashditcart.test.model.User;
import com.aashditcart.test.repository.CartItemRepository;
import com.aashditcart.test.repository.CartRepository;
import com.aashditcart.test.repository.OrderItemRepository;
import com.aashditcart.test.repository.OrderRepository;
import com.aashditcart.test.repository.ProductRepository;
import com.aashditcart.test.repository.UserRepository;
import com.aashditcart.test.service.OrderService;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl  implements OrderService{

	@Autowired
	private OrderRepository orderRepository ;
	
	@Autowired
	 private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;

	@Override
	public List<Order> getOrdersByUser(User user) {
		
		try {
            return orderRepository.findByUser(user);
        } catch (Exception e) {
            log.error("Error fetching orders for user ID {}: {}", user.getId(), e.getMessage(), e);
            return new ArrayList<>();
        }
	}

	@Override
	@Transactional
	public void placeOrder(User sessionUser) {

		 try {
	            User user = userRepository.findById(sessionUser.getId())
	                    .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

	            Cart cart = cartRepository.findByUser(user);

	            if (cart == null) {
	                log.warn("Cart is null for customer ID {}", user.getId());
	                throw new IllegalStateException("Cart not found!");
	            }

	            List<CartItem> cartItems = new ArrayList<>(cart.getCartItems());
	            log.info("Fetched {} cart items for customer ID {}", cartItems.size(), user.getId());

	            if (cartItems.isEmpty()) {
	                throw new IllegalStateException("No items in cart to place an order!");
	            }

	            Order order = new Order();
	            order.setUser(user);
	            order.setOrderDate(new Date());
	            order.setStatus("Pending");
	            order = orderRepository.save(order);

	            List<OrderItem> orderItems = new ArrayList<>();

	            for (CartItem cartItem : cartItems) {
	                Product product = cartItem.getProduct();
	                int quantity = cartItem.getQuantity();

	                if (product.getStock() < quantity) {
	                    throw new IllegalStateException("Product out of stock: " + product.getName());
	                }

	                OrderItem orderItem = new OrderItem();
	                orderItem.setOrder(order);
	                orderItem.setProduct(product);
	                orderItem.setQuantity(quantity);
	                orderItem.setPrice(product.getPrice() * quantity);

	                orderItems.add(orderItem);

	                product.setStock(product.getStock() - quantity);
	                productRepository.save(product);
	            }

	            orderItemRepository.saveAll(orderItems);
	            order.setOrderItems(orderItems);
	            orderRepository.save(order);

	            cartItemRepository.deleteAll(cartItems);
	            cart.getCartItems().clear();
	            cartRepository.save(cart);

	            log.info("Order placed successfully and cart cleared for customer ID {}", user.getId());

	        } catch (Exception e) {
	            log.error("Error placing order for customer ID {}: {}", sessionUser.getId(), e.getMessage(), e);
	            throw e;
	        }
	}

	@Override
	public void removeOrder(Long orderId) {
		try {
            orderRepository.deleteById(orderId);
            log.info("Order with ID {} removed successfully", orderId);
        } catch (Exception e) {
            log.error("Error removing order with ID {}: {}", orderId, e.getMessage(), e);
        }
		
	}

	@Override
	public void updateOrderStatus(Long orderId, String status) {
	
		try {
            Order order = orderRepository.findById(orderId).orElse(null);
            if (order != null) {
                order.setStatus(status);
                orderRepository.save(order);
                log.info("Order status updated for ID {}: {}", orderId, status);
            } else {
                log.warn("Order not found for ID {} to update status", orderId);
            }
        } catch (Exception e) {
            log.error("Error updating order status for ID {}: {}", orderId, e.getMessage(), e);
        }
	}

	@Override
	@Transactional
	public void placeSingleOrder(User user, Product product, int quantity) {
		 try {
	            if (product.getStock() < quantity) {
	                throw new IllegalStateException("Product out of stock: " + product.getName());
	            }

	            Order order = new Order();
	            order.setUser(user);
	            order.setStatus("Pending");

	            OrderItem orderItem = new OrderItem();
	            orderItem.setProduct(product);
	            orderItem.setQuantity(quantity);
	            orderItem.setPrice(product.getPrice() * quantity);
	            orderItem.setOrder(order);

	            order.setOrderItems(List.of(orderItem));

	            orderRepository.save(order);
	            orderItemRepository.save(orderItem);

	            product.setStock(product.getStock() - quantity);
	            productRepository.save(product);

	            log.info("Single order placed successfully for product {} (Qty: {}) by user ID {}",
	                    product.getName(), quantity, user.getId());

	        } catch (Exception e) {
	            log.error("Error placing single order for user ID {} and product {}: {}", user.getId(), product.getName(), e.getMessage(), e);
	            throw e;
	        }
	}

	@Override
	public void setOrderDeliveryAddress(Long orderId, Long addressId) {
		log.warn("setOrderDeliveryAddress not implemented yet for order ID {} and address ID {}", orderId, addressId);
	}

	@Override
	public List<Order> getAllOrders() {
		try {
            return orderRepository.findAll();
        } catch (Exception e) {
            log.error("Error fetching all orders: {}", e.getMessage(), e);
            return new ArrayList<>();
        } 
	}

	@Override
	public void removeOrderById(Long orderId) {
		 try {
	            orderRepository.deleteById(orderId);
	            log.info("Order with ID {} deleted successfully", orderId);
	        } catch (Exception e) {
	            log.error("Error deleting order by ID {}: {}", orderId, e.getMessage(), e);
	        }
	}

}
