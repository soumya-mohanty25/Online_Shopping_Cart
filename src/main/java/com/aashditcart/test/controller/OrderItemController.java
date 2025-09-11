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

import com.aashditcart.test.model.OrderItem;
import com.aashditcart.test.service.OrderItemService;

import lombok.extern.slf4j.Slf4j;

@Controller
@ControllerAdvice
@Slf4j
@RequestMapping("/orderItems")
public class OrderItemController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(OrderItemController.class);

	 @Autowired
	    private OrderItemService orderItemService;

	    @GetMapping("/orderItems")
	    public String showOrderItems(Model model) {
	        List<OrderItem> orderItems = orderItemService.getAllOrderItems();
	        model.addAttribute("orderItems", orderItems);
	        return renderwithbase(model,"/pages/user/orderItems"); // JSP page to display order items
	    }

	    @PostMapping("/orderItems/save")
	    public String saveOrderItem(OrderItem orderItem) {
	        orderItemService.saveOrderItem(orderItem);
	        return "redirect:/orderItems";
	    }

	    @PostMapping("/orderItems/delete")
	    public String deleteOrderItem(@RequestParam Long id) {
	        orderItemService.deleteOrderItem(id);
	        return "redirect:/orderItems";
	    }

}
