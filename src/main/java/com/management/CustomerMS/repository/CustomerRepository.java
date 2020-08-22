package com.management.CustomerMS.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.CustomerMS.dto.CustomerDTO;
import com.management.CustomerMS.entity.Customer;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public void save(CustomerDTO customer);
	public Customer findByPhoneNumber(String phoneNumber);
	public Customer findByEmail(String email);
	
}
