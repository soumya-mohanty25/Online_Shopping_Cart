package com.aashditcart.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aashditcart.test.model.Product;
import com.aashditcart.test.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Controller
@ControllerAdvice
@Slf4j
@RequestMapping("/products")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	    @Autowired
	    private ProductService productService;

	    // Show Manage Product Page for Admin
	    @GetMapping("/manage")
	    public String showManageProducts(Model model) {
	    	 try {
	             List<Product> products = productService.getAllProducts();
	             model.addAttribute("products", products);
	             model.addAttribute("product", new Product());
	             return "admin-productManage";
	         } catch (Exception e) {
	             logger.error("Error loading manage products page", e);
	             return "error";
	         }
	    }

	    // Add New Product
	    @PostMapping("/add")
	    public String addProduct(@ModelAttribute Product product) {
	    	try {
	            productService.saveProduct(product);
	            return "redirect:/products/manage";
	        } catch (Exception e) {
	            logger.error("Error adding product: {}", product, e);
	            return "error";
	        }
	    }
	    
	    @GetMapping("/list")
	    public String showProductlist(Model model) {
	    	try {
	            List<Product> products = productService.getAllProducts();
	            model.addAttribute("products", products);
	            return "admin-productlist";
	        } catch (Exception e) {
	            logger.error("Error loading product list", e);
	            return "error";
	        }
	    }  

	    @GetMapping("/edit/{id}")
	    public String showEditProductForm(@PathVariable Long id, Model model) {
	    	try {
	            Product product = productService.getProductById(id);
	            model.addAttribute("product", product);
	            return "admin-editProduct";
	        } catch (Exception e) {
	            logger.error("Error showing edit form for product ID: {}", id, e);
	            return "error";
	        }
	    }

	    @PostMapping("/update/{id}")
	    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
	    	 try {
	             product.setId(id);
	             productService.updateProduct(product);
	             return "redirect:/products/manage";
	         } catch (Exception e) {
	             logger.error("Error updating product ID: {}", id, e);
	             return "error";
	         }
	    }

	    // Delete Product
	    @GetMapping("/delete/{id}")
	    public String deleteProduct(@PathVariable Long id) {
	    	 try {
	             productService.deleteProduct(id);
	             return "redirect:/products/manage";
	         } catch (Exception e) {
	             logger.error("Error deleting product ID: {}", id, e);
	             return "error";
	         }
	    }

	    // Show Product Page for Customers
	    @GetMapping("/shop")
	    public String showProductsForCustomer(Model model) {
	    	 try {
	             List<Product> products = productService.getAllProducts();
	             model.addAttribute("products", products);
	             return "user-shopProduct";
	         } catch (Exception e) {
	             logger.error("Error showing products for customer", e);
	             return "error";
	         }
	    }
	    
       @GetMapping("/search")
	    public String searchProducts(@RequestParam("keyword") String keyword, Model model) {
    	   try {
               List<Product> results = productService.searchByName(keyword);
               model.addAttribute("products", results);
               model.addAttribute("searchKeyword", keyword);
               return "user-searchProduct";
           } catch (Exception e) {
               logger.error("Error searching products with keyword: {}", keyword, e);
               return "error";
           }
	    }

}
