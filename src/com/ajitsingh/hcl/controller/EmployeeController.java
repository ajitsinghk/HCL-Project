package com.ajitsingh.hcl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	
	
	@RequestMapping("list")
	public String listEmployees(Model theModel) {
		
		return "list-employees";
	}

}
