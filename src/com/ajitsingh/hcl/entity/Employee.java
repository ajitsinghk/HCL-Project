package com.ajitsingh.hcl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


// Mpping class to database
@Entity
@Table(name="employee")
public class Employee {
	
	public Employee() {
		
	}
	
	// Mapping fields to the database columns
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // For auto-increment
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	@NotNull(message="is required")
	@Size(min=1,max=10, message="min 1 char & max 10 char")
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1,max=10, message="min 1 char & max 10 char")
	@Column(name="last_name")
	private String lastName;
	
	
	@NotNull(message="is required")
	@Pattern(regexp="^.+@[^\\.].*\\.[a-z]{2,}$", message="enter valid email")
	@Column(name="email")
	private String email;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	

}
