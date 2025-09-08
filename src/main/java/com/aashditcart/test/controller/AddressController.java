package com.aashditcart.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aashditcart.test.model.Address;
import com.aashditcart.test.model.User;
import com.aashditcart.test.service.AddressService;
import com.aashditcart.test.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@ControllerAdvice
@Slf4j
@RequestMapping("/users")
public class AddressController {
	
	private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

	 @Autowired
	    private AddressService addressService;

	    @Autowired
	    private UserService userService;

	    // Show Address Page
	    @GetMapping("/addresses")
	    public String showAddresses(HttpSession session, Model model) {
	    	try {
	            User user = (User) session.getAttribute("loggedInUser");
	            if (user == null) {
	                return "redirect:/users/login";
	            }
	            List<Address> addresses = addressService.getAddressesByUser(user.getId());
	            model.addAttribute("addresses", addresses);
	            return "user-address";
	        } catch (Exception e) {
	            logger.error("Error while loading addresses: ", e);
	            return "error"; // your error.jsp page
	        }
	    }

	    // Show Add Address Form
	    @GetMapping("/add-address")
	    public String showAddAddressForm(HttpSession session, Model model) {
	    	 try {
	    	        User user = (User) session.getAttribute("loggedInUser");
	    	        if (user == null) {
	    	            return "redirect:/users/login";
	    	        }
	    	        model.addAttribute("address", new Address());
	    	        return "user-addAddress";
	    	    } catch (Exception e) {
	    	        logger.error("Error while showing add address form: ", e);
	    	        return "error";
	    	    }
	    }

	    // Save New Address
	    @PostMapping("/save-address")
	    public String saveAddress(@ModelAttribute Address address, HttpSession session) {
	    	try {
	            User user = (User) session.getAttribute("loggedInUser");
	            if (user == null) {
	                return "redirect:/users/login";
	            }
	            address.setUser(user);
	            addressService.saveAddress(address);
	            return "redirect:/users/addresses";
	        } catch (Exception e) {
	            logger.error("Error while saving address: ", e);
	            return "error";
	        }
	    }

	    // Show Edit Address Form
	    @GetMapping("/edit-address/{id}")
	    public String showEditAddressForm(@PathVariable Long id, Model model, HttpSession session) {
	    	 try {
	    	        User user = (User) session.getAttribute("loggedInUser");
	    	        if (user == null) {
	    	            return "redirect:/users/login";
	    	        }
	    	        Address address = addressService.getAddressById(id);
	    	        if (address == null || !address.getUser().getId().equals(user.getId())) {
	    	            return "redirect:/users/addresses";
	    	        }
	    	        model.addAttribute("address", address);
	    	        return "user-editAddress";
	    	    } catch (Exception e) {
	    	        logger.error("Error while loading edit address form for ID: " + id, e);
	    	        return "error";
	    	    }
	    }

	    // Update Address
	    @PostMapping("/update-address")
	    public String updateAddress(@ModelAttribute Address address, HttpSession session) {
	    	 try {
	    	        User user = (User) session.getAttribute("loggedInUser");
	    	        if (user == null) {
	    	            return "redirect:/users/login";
	    	        }
	    	        address.setUser(user);
	    	        addressService.updateAddress(address);
	    	        return "redirect:/users/addresses";
	    	    } catch (Exception e) {
	    	        logger.error("Error while updating address: ", e);
	    	        return "error";
	    	    }
	    }

	    // Delete Address
	    @GetMapping("/delete-address/{id}")
	    public String deleteAddress(@PathVariable Long id, HttpSession session) {
	    	try {
	            User user = (User) session.getAttribute("loggedInUser");
	            if (user == null) {
	                return "redirect:/users/login";
	            }
	            Address address = addressService.getAddressById(id);
	            if (address != null && address.getUser().getId().equals(user.getId())) {
	                addressService.deleteAddress(id);
	            }
	            return "redirect:/users/addresses";
	        } catch (Exception e) {
	            logger.error("Error while deleting address with ID: " + id, e);
	            return "error";
	        }
	    }
	    
}

