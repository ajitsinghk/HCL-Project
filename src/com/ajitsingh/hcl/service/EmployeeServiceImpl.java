package com.ajitsingh.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajitsingh.hcl.dao.EmployeeDAO;
import com.ajitsingh.hcl.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	//EmployeeDAO inject
	
	@Autowired
	private EmployeeDAO employeeDAO;

	//Service layer manage transaction. Refactoring needed
	
	@Override
	@Transactional
	public List<Employee> getEmployee() {

		return employeeDAO.getEmployee();
	}

}
