package com.ajitsingh.hcl.service;

import java.util.List;

import com.ajitsingh.hcl.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployee();

	public void saveEmployee(Employee theEmployee);

	public Employee getEmployee(int theId);

	public void deleteEmployee(int theId);

	public List<Employee> searchEmployee(String theSearchName);

}
