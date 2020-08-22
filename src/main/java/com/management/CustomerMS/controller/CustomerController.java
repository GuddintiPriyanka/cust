package com.management.CustomerMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.management.CustomerMS.dto.CustomerDTO;
import com.management.CustomerMS.dto.LifeDTO;
import com.management.CustomerMS.dto.MotorDTO;
import com.management.CustomerMS.entity.Customer;
import com.management.CustomerMS.service.CustomerService;



@RestController
@CrossOrigin
@EnableAutoConfiguration
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerService customerService;
	
	@Autowired  
    RestTemplate template;

	@PostMapping(value="customer/register",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public String registerCustomer(@RequestBody CustomerDTO customerDTO) {
		try {
		logger.info("Registration request for customer {}", customerDTO);
		customerService.registerCustomer(customerDTO);
		
		return "Success";
	
		}catch(Exception e) {
		return("Already registered");
	}
	}
	
	@PostMapping(value = "customer/login",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String loginCustomer(@RequestBody CustomerDTO customerDTO) throws Exception {
		try {
			customerService.customerLogin(customerDTO);
			return "Login Successfull";
		} catch (Exception e) {
			return " Login unsuccessfull, check your credentials and try again";
		}
	}

	
	
	@GetMapping(value = "customer/{phoneNumber}/insurancedetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO getInsuranceDetails(@PathVariable String phoneNumber) {

		logger.info("Insurancedetails request for customer {}", phoneNumber);
		CustomerDTO customerDTO=new CustomerDTO();
		Customer customer =customerService.getCustomerProfile(phoneNumber);
	    customerDTO=customerDTO.valueOf(customer);
	    
		
		MotorDTO motorDTO  = template.getForObject("http://MOTORMS"+"/motor/"+customerDTO.getMotorpolicy().getPolicynumber(),MotorDTO.class);  
		customerDTO.setMotorpolicy(motorDTO);
			 
		LifeDTO lifeDTO  = template.getForObject("http://LIFEMS"+"/life/"+customerDTO.getLifepolicy().getPolicynumber(),LifeDTO.class);       
		customerDTO.setLifepolicy(lifeDTO);
		
		List<Double> payment=template.getForObject("http://PAYMENTMS"+"/customers/"+phoneNumber, List.class);  
	    customerDTO.setPayment(payment); 
		
	    return customerDTO;
			
	}
	
	
	

}

