package com.aashditcart.test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.aashditcart.test.model.Cart;
import com.aashditcart.test.model.CartItem;
import com.aashditcart.test.model.OrderItem;
import com.aashditcart.test.model.Product;
import com.aashditcart.test.model.User;
import com.aashditcart.test.repository.CartItemRepository;
import com.aashditcart.test.repository.CartRepository;
import com.aashditcart.test.repository.ProductRepository;
import com.aashditcart.test.service.CartService;
import com.aashditcart.test.service.UserService;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CartItemRepository cartItemRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserService userService;
	
	@Override
	public Cart getCartByUserId(Long userId) {
		
		 try {
	            Cart cart = cartRepository.findByUserId(userId);
	            if (cart == null) {
	                cart = new Cart(userService.getUserById(userId));
	                cart.setCartItems(new ArrayList<>());
	                cartRepository.save(cart);
	            } else if (cart.getCartItems() == null) {
	                cart.setCartItems(new ArrayList<>());
	            }
	            return cart;
	        } catch (Exception e) {
	            log.error("Failed to get cart for user ID {}: {}", userId, e.getMessage(), e);
	            return null;
	        }
	}
	
	@Override
	@Transactional
	public void addProductToCart(User user, Product product, int quantity) {

		try {
            log.info("Attempting to add product to cart...");
            log.info("Customer ID: {}", user.getId());
            log.info("Product ID: {}", product.getId());
            log.info("Requested Quantity: {}", quantity);

            Cart cart = getCartByUserId(user.getId());

            if (cart == null) {
                log.error("Cart is NULL for user ID: {}", user.getId());
                return;
            }

            Optional<CartItem> existingItem = cart.getCartItems().stream()
                    .filter(item -> item.getProduct().getId().equals(product.getId()))
                    .findFirst();

            if (existingItem.isPresent()) {
                log.info("Product already exists in cart. Updating quantity...");
                CartItem cartItem = existingItem.get();
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                cartItemRepository.save(cartItem);
                log.info("Updated CartItem Quantity: {}", cartItem.getQuantity());
            } else {
                log.info("Product not found in cart. Creating new CartItem...");

                CartItem cartItem = new CartItem();
                cartItem.setCart(cart);
                cartItem.setProduct(product);
                cartItem.setQuantity(quantity);

                log.info("Saving CartItem -> Product ID: {}, Quantity: {}", product.getId(), quantity);

                cartItemRepository.save(cartItem);
                cart.getCartItems().add(cartItem);

                cartRepository.save(cart);
                log.info("New CartItem added successfully!");
            }

        } catch (Exception e) {
            log.error("Error adding product ID {} to cart for user ID {}: {}", 
                      product.getId(), user.getId(), e.getMessage(), e);
        }

	}
	
	@Override
	public void removeProductFromCart(Long userId, Long productId) {
		   
		 try {
	            Cart cart = getCartByUserId(userId);
	            if (cart != null && cart.getCartItems() != null) {
	                List<CartItem> items = cart.getCartItems();
	                items.removeIf(item -> item.getProduct().getId().equals(productId));
	                cartRepository.save(cart);
	                log.info("Product ID {} removed from user ID {}'s cart", productId, userId);
	            } else {
	                log.warn("Cart or CartItems not found for user ID {}", userId);
	            }
	        } catch (Exception e) {
	            log.error("Failed to remove product ID {} from cart for user ID {}: {}", 
	                      productId, userId, e.getMessage(), e);
	        }
	}
	
	@Override
	public void updateCartItem(Long userId, Long productId, int quantity) {

		 try {
	            Cart cart = cartRepository.findByUserId(userId);
	            if (cart != null) {
	                for (CartItem item : cart.getCartItems()) {
	                    if (item.getProduct().getId().equals(productId)) {
	                        item.setQuantity(quantity);
	                        cartItemRepository.save(item);
	                        log.info("Updated quantity of product ID {} to {} for user ID {}", productId, quantity, userId);
	                        break;
	                    }
	                }
	            } else {
	                log.warn("Cart not found for user ID {}", userId);
	            }
	        } catch (Exception e) {
	            log.error("Failed to update cart item for product ID {} and user ID {}: {}", 
	                      productId, userId, e.getMessage(), e);
	        }
		
	}
	
	@Override
	public Cart saveCart(Cart cart) {
		try {
            return cartRepository.save(cart);
        } catch (Exception e) {
            log.error("Failed to save cart ID {}: {}", cart.getId(), e.getMessage(), e);
            return null;
        }
	}
	
	@Override
	public void updateCartItemQuantity(Long cartItemId, int quantity) {
		 try {
	            CartItem cartItem = cartItemRepository.findById(cartItemId).orElse(null);
	            if (cartItem != null) {
	                Product product = cartItem.getProduct();

	                if (quantity > product.getStock()) {
	                    throw new IllegalStateException("Insufficient stock for product: " + product.getName());
	                }

	                cartItem.setQuantity(quantity);
	                cartItem.setPrice(product.getPrice() * quantity);
	                cartItemRepository.save(cartItem);

	                log.info("Updated quantity of order item ID {}: {}", cartItemId, quantity);
	            } else {
	                log.warn("OrderItem not found for ID {}", cartItemId);
	            }
	        } catch (Exception e) {
	            log.error("Error updating order item quantity for ID {}: {}", cartItemId, e.getMessage(), e);
	            throw e;
	        }
		
	}
	
	
}
