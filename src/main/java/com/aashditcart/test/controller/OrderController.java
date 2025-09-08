package com.aashditcart.test.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aashditcart.test.model.Address;
import com.aashditcart.test.model.Order;
import com.aashditcart.test.model.User;
import com.aashditcart.test.service.AddressService;
import com.aashditcart.test.service.CartService;
import com.aashditcart.test.service.OrderService;


import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@ControllerAdvice
@Slf4j
@RequestMapping("/orders")
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
    private OrderService orderService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
    private AddressService addressService;

	    @GetMapping("/view")
	    public String viewOrders(@SessionAttribute(name = "loggedInUser", required = false) User user, 
	                             Model model, HttpSession session) {
	    	try {
	            if (user == null) {
	                session.invalidate();
	                return "redirect:/users/login";
	            }

	            List<Order> orders = orderService.getOrdersByUser(user);
	            model.addAttribute("orders", orders);
	            return "user-order";

	        } catch (Exception e) {
	            log.error("Error viewing orders for user", e);
	            return "error";
	        }
	    }

	    @PostMapping("/place")
	    public String placeOrder(@SessionAttribute(name = "loggedInUser", required = false) User user, HttpSession session) {
	    	 try {
	    	        if (user == null) {
	    	            session.invalidate();
	    	            return "redirect:/users/login";
	    	        }

	    	        orderService.placeOrder(user);
	    	        return "redirect:/orders/view";

	    	    } catch (Exception e) {
	    	        log.error("Error placing order", e);
	    	        return "error";
	    	    }
	    }
	    
	    @PostMapping("/remove-item")
	    public String removeOrder(@RequestParam("orderId") Long orderId, HttpSession session) {
	    	try {
	            User user = (User) session.getAttribute("loggedInUser");
	            if (user == null) {
	                return "redirect:/users/login";
	            }

	            orderService.removeOrder(orderId);
	            return "redirect:/orders/view";

	        } catch (Exception e) {
	            log.error("Error removing order item with ID: {}", orderId, e);
	            return "error";
	        }
	    }

	    @GetMapping("/manage")
	    public String manageOrders(Model model, HttpSession session) {
	    	try {
	            User user = (User) session.getAttribute("loggedInUser");
	            if (user == null) {
	                session.invalidate();
	                return "redirect:/users/login";
	            }

	            List<Order> orders = orderService.getAllOrders();
	            model.addAttribute("orders", orders);
	            return "admin-manageOrder";
	        } catch (Exception e) {
	            log.error("Error managing orders", e);
	            return "error";
	        }
	    }
	    
	    @PostMapping("/update-status")
	    public String updateOrderStatus(@RequestParam("orderId") Long orderId, @RequestParam("status") String status, HttpSession session) {
	    	try {
	            User user = (User) session.getAttribute("loggedInUser");
	            if (user == null) {
	                return "redirect:/users/login";
	            }

	            orderService.updateOrderStatus(orderId, status);
	            return "redirect:/orders/view";

	        } catch (Exception e) {
	            log.error("Error updating order status for order ID: {}, status: {}", orderId, status, e);
	            return "error";
	        }
	    }
	    
	    @PostMapping("/proceed")
	    public String proceedToPayment(@RequestParam("orderId") Long orderId, HttpSession session) {
	    	 try {
	    	        User user = (User) session.getAttribute("loggedInUser");
	    	        if (user == null) {
	    	            return "redirect:/users/login";
	    	        }

	    	        return "redirect:/payment/checkout?orderId=" + orderId;

	    	    } catch (Exception e) {
	    	        log.error("Error proceeding to payment for order ID: {}", orderId, e);
	    	        return "error";
	    	    }
	    }
	    
	    @PostMapping("/orders/remove")
	    public String removeOrder(@RequestParam("orderId") Long orderId, RedirectAttributes redirectAttributes) {
	    	try {
	            orderService.removeOrderById(orderId);
	            redirectAttributes.addFlashAttribute("success", "Order removed successfully!");
	        } catch (Exception e) {
	            log.error("Failed to remove order ID: {}", orderId, e);
	            redirectAttributes.addFlashAttribute("error", "Failed to remove order.");
	        }
	        return "redirect:/orders/view";
	    }

	    
	    
	    @GetMapping("/choose-address")
	    public String chooseAddress(@RequestParam("orderId") Long orderId, Model model, HttpSession session) {
	    	 try {
	    	        User user = (User) session.getAttribute("loggedInUser");
	    	        if (user == null) {
	    	            return "redirect:/users/login";
	    	        }

	    	        List<Address> addresses = addressService.getAddressesByUser(user.getId());

	    	        model.addAttribute("orderId", orderId);
	    	        model.addAttribute("addresses", addresses);
	    	        return "user-chooseAddress";

	    	    } catch (Exception e) {
	    	        log.error("Error choosing address for order ID: {}", orderId, e);
	    	        return "error";
	    	    }
	    }

	    @PostMapping("/select-address")
	    public String selectAddress(@RequestParam("orderId") Long orderId, @RequestParam("addressId") Long addressId, HttpSession session) {
	    	 try {
	    	        User user = (User) session.getAttribute("loggedInUser");
	    	        if (user == null) {
	    	            return "redirect:/users/login";
	    	        }

	    	        orderService.setOrderDeliveryAddress(orderId, addressId);
	    	        return "redirect:/orders/view";

	    	    } catch (Exception e) {
	    	        log.error("Error setting address for order ID: {}, address ID: {}", orderId, addressId, e);
	    	        return "error";
	    	    }
	    }

}
