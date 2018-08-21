package com.ajitsingh.hcl.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ajitsingh.hcl.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	// Injecting session factory
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * Spring Transactional Management Up8: Refactored : Service Layer taking care
	 * of @Transactional
	 * 
	 */

	@Override
	// @Transactional
	public List<Employee> getEmployee() {

		// Open hb session
		Session currentSession = sessionFactory.getCurrentSession();

		// write query
		Query<Employee> myQuery = currentSession.createQuery("from Employee", Employee.class);

		// executing query and storing in variable
		List<Employee> employee = myQuery.getResultList();

		// return result
		return employee;
	}

}
