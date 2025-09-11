package com.aashditcart.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@ControllerAdvice
@Slf4j
@RequestMapping("/admins")
public class AdminController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        return renderwithbase(model,"/pages/admin/admin-dashboard");
    }
}
