package com.aashditcart.test.controller;

import org.springframework.ui.Model;

public class BaseController {

	 protected String renderwithbase(Model model, String body) {
	        model.addAttribute("body", body);  // example: "pages/user/user-dashboard"
	        return "layout/main";              // Spring will resolve: /WEB-INF/views/layout/main.jsp
	    }
}
