package com.management.CustomerMS.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer{
	
	@Id
	@Column(name="CUSTOMERID", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer customerId;
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	@Column(name="PHONENUMBER", nullable = false)
	String phoneNumber;
	
	@Column(name="NAME", nullable = false)
	String name;
	@Column(name="EMAIL", nullable = false)
	String email;
	
	@Column(name="PASSWORD", nullable = false)
	String password;
	@Column(name="POLICYNUMBER", nullable = false)
	String policyNumber;

		public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	

	}
	
