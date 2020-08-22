package com.management.CustomerMS.dto;

public class CustomerLoginDTO {
	Integer customerId;
	String email;
	String password;

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public CustomerLoginDTO() {
		super();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginDTO [CustomerId=" + customerId + ", password=" + password + "]";
	}
	
	
	

}
