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

	@Override
	public void saveEmployee(Employee theEmployee) {

		Session currentSession = sessionFactory.getCurrentSession();
		/*
		 * Refactoring UP009 : instead of save lets go for saveOrUpdate
		 */
		// // this is inserting records
		// currentSession.save(theEmployee);
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public Employee getEmployee(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();

		// We have annotated ID as primary key in Employee class, by using that, we are
		// retrieving Employee.
		Employee theEmployee = currentSession.get(Employee.class, theId);

		return theEmployee;
	}

	@Override
	public void deleteEmployee(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query myQuery = currentSession.createQuery("delete from Employee where id=:thisEmployeeId");
		myQuery.setParameter("thisEmployeeId", theId);

		myQuery.executeUpdate();
	}

	@Override
	public List<Employee> searchEmployees(String theSearchName) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = null;
		//
		// only search by name if theSearchName is not empty
		//
		if (theSearchName != null && theSearchName.trim().length() > 0) {
			// search for firstName or lastName ... case insensitive
			theQuery = currentSession.createQuery(
					"from Employee where lower(firstName) like :theName or lower(lastName) like :theName",
					Employee.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		} else {
			// theSearchName is empty ... so just get all employee
			theQuery = currentSession.createQuery("from Employee", Employee.class);
		}
		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		// return the results
		return employees;

	}

}
