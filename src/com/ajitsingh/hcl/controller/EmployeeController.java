package com.ajitsingh.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ajitsingh.hcl.dao.EmployeeDAO;
import com.ajitsingh.hcl.entity.Employee;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	
	//INjecting DAO in controller
	@Autowired
	private EmployeeDAO employeeDAO;
	
	
	
	@RequestMapping("list")
	public String listEmployees(Model theModel) {
		
		// getting employee from dao
		List<Employee> theEmployee   = employeeDAO.getEmployee();

		// adding employee to model and passing this variable rendering
		theModel.addAttribute("employees", theEmployee);
		
		// return view page
		return "list-employees";
	}

}
