package com.aashditcart.test.service;

import com.aashditcart.test.model.Cart;
import com.aashditcart.test.model.Product;
import com.aashditcart.test.model.User;

public interface CartService {

	Cart getCartByUserId(Long userId);
	Cart saveCart(Cart cart);
	void addProductToCart(User user, Product product, int quantity);
	void removeProductFromCart(Long userId, Long productId);
	void updateCartItemQuantity(Long cartItemId, int quantity);
	void updateCartItem(Long userId, Long productId, int quantity);
//	void saveCart(Cart cart);

	
}
