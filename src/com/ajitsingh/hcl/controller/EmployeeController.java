package com.ajitsingh.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ajitsingh.hcl.dao.EmployeeDAO;
import com.ajitsingh.hcl.entity.Employee;
import com.ajitsingh.hcl.service.EmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController {

	/*
	 * Up08 : Refactored : Injecting EmployeeService obj from Service Layer //
	 * INjecting DAO in controller
	 * 
	 * @Autowired 
	 * private EmployeeDAO employeeDAO;
	 */

	@Autowired
	private EmployeeService employeeService;

	// Refactored to GetMapping
	// @RequestMapping("list")
	@GetMapping("list")
	public String listEmployees(Model theModel) {
		/*
		 * Up08: refactored // getting employee from dao // List<Employee> theEmployee =
		 * employeeDAO.getEmployee();
		 * 
		 * // adding employee to model and passing this variable rendering //
		 * theModel.addAttribute("employees", theEmployee);
		 */
		theModel.addAttribute("employees", employeeService.getEmployee());

		// return view page
		return "list-employees";
	}

}
