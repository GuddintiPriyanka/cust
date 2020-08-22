package com.management.CustomerMS.dto;

import java.util.List;

import com.management.CustomerMS.entity.Customer;

public class CustomerDTO {
	
	Integer customerId;
	String name;
	String email;
	List<Double> payment;
	String phoneNumber;
	String password;
	MotorDTO motorpolicy;
	LifeDTO lifepolicy;
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public MotorDTO getMotorpolicy() {
		return motorpolicy;
	}
	public void setMotorpolicy(MotorDTO motorpolicy) {
		this.motorpolicy = motorpolicy;
	}
	public List<Double> getPayment() {
		return payment;
	}
	public void setPayment(List<Double> payment) {
		this.payment = payment;
	}
	
	public LifeDTO getLifepolicy() {
		return lifepolicy;
	}
	public void setLifepolicy(LifeDTO lifepolicy) {
		this.lifepolicy = lifepolicy;
	}
	public CustomerDTO() {
		super();
	}
	
	// Converts Entity into DTO
	public static CustomerDTO valueOf(Customer customer) {
		CustomerDTO customerDTO= new CustomerDTO();
	    customerDTO.setCustomerId(customer.getCustomerId());
		customerDTO.setName(customer.getName());
		customerDTO.setEmail(customer.getEmail());
		customerDTO.setPhoneNumber(customer.getPhoneNumber());
		customerDTO.setPassword(customer.getPassword());
		
		MotorDTO motorDTO =new MotorDTO();
		motorDTO.setPolicynumber(customer.getPolicyNumber());
		customerDTO.setMotorpolicy(motorDTO);
		
		LifeDTO lifeDTO =new LifeDTO();
		lifeDTO.setPolicynumber(customer.getPolicyNumber());
		customerDTO.setLifepolicy(lifeDTO);
		
		
		return customerDTO;
	}
	//Creates an entity for a given DTO
	public Customer createEntity() {
		Customer be=new Customer();
		be.setCustomerId(this.getCustomerId());
		be.setEmail(this.getEmail());
		be.setName(this.getName());
		be.setPassword(this.getPassword());
		be.setPhoneNumber(this.getPhoneNumber());
		be.setPolicyNumber(this.getMotorpolicy().getPolicynumber());
		
		return be;
	}
	
	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", name=" + name + ", email=" + email + ", payment=" + payment
				+ ", phoneNumber=" + phoneNumber + ", password=" + password + ", motorpolicy=" + motorpolicy
				+ ", lifepolicy=" + lifepolicy + "]";
	}
	
	
	
	
	
	
}
