package com.management.CustomerMS.service;


import java.util.regex.Pattern;
import javax.naming.InvalidNameException;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.CustomerMS.dto.CustomerDTO;
import com.management.CustomerMS.entity.Customer;
import com.management.CustomerMS.repository.CustomerRepository;

@Service

public class CustomerService {
	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
	@Autowired
	CustomerRepository customerRepo;
	
	//customer registers into insurance portal using DTO
	public String registerCustomer(CustomerDTO customerDTO) throws Exception {
		
		try {
			logger.info("Registration request for customer {}", customerDTO);
			validateCustomer(customerDTO);
			Customer be=customerDTO.createEntity();
			customerRepo.save(be);
			return("new user created");
			}catch(Exception e) {
			throw new Exception("Name is not valid");
		}
	}
	
	//customer validation
	public void validateCustomer(CustomerDTO customerDTO) throws Exception {

		logger.info("Customer details are being validated");
		if(!isAlreadyPhoneNumberExist(customerDTO.getPhoneNumber()))
			throw new Exception("CustomerRegistration: Phone number already exists");
		if(!isAlreadyEmailIdExist(customerDTO.getEmail()))
			throw new Exception("customerRegistration: Email already exists");
		if(!isValidName(customerDTO.getName()))
			throw new InvalidNameException("CustomerRegistration: Invalid Name");
		if(!isValidEmail(customerDTO.getEmail()))
			throw new Exception("CustomerRegistration: Invalid Email");
		if(!isValidPhoneNumber(customerDTO.getPhoneNumber()))
			throw new Exception("CustomerRegistration:Invalid Phone number");
		if(!isvalidPassword(customerDTO.getPassword()))
			throw new Exception("CustomerRegistration: Invalid Password");
		
		
		
	}
	
	private boolean isAlreadyEmailIdExist(String email) {
		Customer customer=customerRepo.findByEmail(email);
		if (customer!=null) {
		
			return false;
		}
		else {
		    return true;
		}
	}

	private boolean isAlreadyPhoneNumberExist(String phoneNumber) {

		Customer customer=customerRepo.findByPhoneNumber(phoneNumber);
		if (customer!=null) {

			return false;
		}
		else {
		     return true;
		}
	}

	private boolean isvalidPassword(String password) {
		return Pattern.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{7,20}$",password);
	}

	private boolean isValidPhoneNumber(String phoneNumber) {
		return Pattern.matches("\\d{10}", phoneNumber);
	}

	private boolean isValidEmail(String email) {
		return Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$",email);
	}

	private boolean isValidName(String name) {

		return Pattern.matches("^[a-zA-Z]+[-a-zA-Z\\s]+([-a-zA-Z]+)$", name);
	}

	
	
	//customer login using DTO
	public void customerLogin(CustomerDTO customerDTO) throws Exception {

		Customer customer = customerRepo.findByEmail(customerDTO.getEmail());
		if (customer != null) {
			if (customer.getPassword().equals(customerDTO.getPassword())) {
				logger.info("Login successfull");
			} else {
				throw new Exception("customerLogin:Invalid Password");
			}
		}else {
			throw new Exception("customerLogin:InvalidEmail");
		}
		
	}
	
	// Fetches full profile of a specific customer
	public Customer getCustomerProfile(String phoneNumber) {

		logger.info("Insurancedetails request for customer {}", phoneNumber);

		Customer custDTO=customerRepo.findByPhoneNumber(phoneNumber);
		
		logger.info("Insurancedetails for customer : {}", custDTO);

		return custDTO;
	}


}
