package com.ajitsingh.hcl.dao;

import java.util.List;

import com.ajitsingh.hcl.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getEmployee();

	public void saveEmployee(Employee theEmployee);

	public Employee getEmployee(int theId);

	public void deleteEmployee(int theId);

	public List<Employee> searchEmployees(String theSearchName);

}
