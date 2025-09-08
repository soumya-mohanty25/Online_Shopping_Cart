package com.aashditcart.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aashditcart.test.model.Cart;
import com.aashditcart.test.model.CartItem;
import com.aashditcart.test.model.Product;
import com.aashditcart.test.model.User;
import com.aashditcart.test.repository.CartRepository;
import com.aashditcart.test.service.CartService;
import com.aashditcart.test.service.ProductService;
import com.aashditcart.test.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@ControllerAdvice
@Slf4j
@RequestMapping("/carts")
public class CartController {

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/view")
	public String viewCart(HttpSession session, Model model) {
	    try {
	        User loggedInUser = (User) session.getAttribute("loggedInUser");

	        if (loggedInUser == null) {
	            log.info("User not logged in, redirecting to login page.");
	            return "redirect:/users/login";
	        }

	        Cart cart = cartService.getCartByUserId(loggedInUser.getId());

	        if (cart != null) {
	            log.info("Cart ID: {}", cart.getId());
	            log.info("Cart Items Count: {}", cart.getCartItems().size());
	            for (CartItem item : cart.getCartItems()) {
	                log.info("CartItem -> Product ID: {}, Quantity: {}", item.getProduct().getId(), item.getQuantity());
	            }
	        }

	        model.addAttribute("cart", cart);
	        return "user-shopCart";
	    } catch (Exception e) {
	        log.error("Error while viewing cart", e);
	        model.addAttribute("error", "Unable to load cart.");
	        return "error";
	    }

	}
	
	@PostMapping("/add")
	public String addToCart(@RequestParam("productId") Long productId,
	                        @RequestParam("quantity") int quantity,
	                        HttpSession session) {

		 try {
		        User loggedInUser = (User) session.getAttribute("loggedInUser");
		        if (loggedInUser == null) {
		            log.warn("Unauthorized add-to-cart attempt.");
		            return "redirect:/users/login";
		        }

		        Product product = productService.getProductById(productId);
		        if (product != null && product.getStock() >= quantity) {
		            cartService.addProductToCart(loggedInUser, product, quantity);
		            log.info("Added product ID {} to cart for user ID {}", productId, loggedInUser.getId());
		        } else {
		            log.warn("Product is null or insufficient stock for product ID: {}", productId);
		        }

		        return "redirect:/products/shop";
		    } catch (Exception e) {
		        log.error("Error while adding to cart", e);
		        return "error";
		    }
	}
    
	// In CartService
	  @PostMapping("/remove")
	    public String removeFromCart(@RequestParam("productId") Long productId, HttpSession session) {
		  try {
		        User user = (User) session.getAttribute("loggedInUser");
		        if (user == null) {
		            log.warn("Unauthorized remove-from-cart attempt.");
		            return "redirect:/users/login";
		        }

		        cartService.removeProductFromCart(user.getId(), productId);
		        log.info("Removed product ID {} from cart for user ID {}", productId, user.getId());

		        return "redirect:/carts/view";
		    } catch (Exception e) {
		        log.error("Error while removing item from cart", e);
		        return "error";
		    }
	    }
	
	   @PostMapping("/updateQuantity")
	    public String updateCartItemQuantity(@RequestParam("cartItemId") Long cartItemId, @RequestParam("quantity") int quantity, HttpSession session) {
		   try {
   	        User user = (User) session.getAttribute("loggedInUser");
   	        if (user == null) {
   	            return "redirect:/users/login";
   	        }

   	        cartService.updateCartItemQuantity(cartItemId, quantity);
   	        return "redirect:/carts/view";

   	    } catch (Exception e) {
   	        log.error("Error updating quantity for cart item ID: {}, quantity: {}", cartItemId, quantity, e);
   	        return "error";
   	    }
	    }

	   @PostMapping("/checkout")
	   public String checkout(HttpSession session, Model model) {
		   try {
		        User loggedInUser = (User) session.getAttribute("loggedInUser");
		        if (loggedInUser == null) {
		            log.warn("Unauthorized checkout attempt.");
		            return "redirect:/users/login";
		        }

		        Cart cart = cartService.getCartByUserId(loggedInUser.getId());

		        if (cart == null || cart.getCartItems().isEmpty()) {
		            model.addAttribute("error", "Your cart is empty.");
		            return "user-shopCart";
		        }

		        model.addAttribute("cart", cart);
		        return "user-checkout";
		    } catch (Exception e) {
		        log.error("Error during checkout", e);
		        model.addAttribute("error", "Unable to proceed to checkout.");
		        return "error";
		    }
	   }

}
