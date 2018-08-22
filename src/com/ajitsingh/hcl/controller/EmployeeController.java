package com.ajitsingh.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	 * @Autowired private EmployeeDAO employeeDAO;
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

	@GetMapping("/addForm")
	public String addForms(Model theModel) {

		// form data to be stored in model attribute
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);

		return "employee-form";
	}
	
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		employeeService.saveEmployee(theEmployee);
		
		return "redirect:/employee/list";
		
	}
	
	@GetMapping("/updateForm")
	public String updateForm(@RequestParam("employeeId") int theId, Model theModel) {
		
		 Employee theEmployee = employeeService.getEmployee(theId);
		 
		 theModel.addAttribute("employee", theEmployee);
		
		return "employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int theId) {
		
		employeeService.deleteEmployee(theId);
		return "redirect:/employee/list";
	}
	
	@PostMapping("/searchEmployee")
	public String search(@RequestParam("theSearchName") String theSearchName,
			Model theModel) {

			// search customers from the service
			List<Employee> theEmployee = employeeService.searchEmployee(theSearchName);

			// add the customers to the model
			theModel.addAttribute("employees", theEmployee);

			return "list-employees"; 
			} 
	
	
	
	
	
	
	
	
}
