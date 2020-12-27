package com.bawnya.ravid.learning.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bawnya.ravid.learning.mappers.CustomerMapper;
import com.bawnya.ravid.learning.persistance.entity.Customer;
import com.bawnya.ravid.learning.persistance.repos.CustomerRepository;
import com.bawnya.ravid.learning.resources.CustomerResource;

@Service
public class CustomerService {

	private Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private CustomerMapper customerMapper;

	public CustomerResource getCustomer(int customerId) {

		Optional<Customer> customerEntity = customerRepo.findById(customerId);

		logger.info("Database call completed, data presemt {} ", customerEntity.isPresent());

		return customerEntity.isPresent() ? customerMapper.mapCustomerEntityToResource(customerEntity.get()) : null;

	}

	public int createCustomer(CustomerResource customerResource) {

		return customerRepo.save(customerMapper.mapCustomerResourceToEntity(customerResource)).getCustomerId();
	}

	public List<CustomerResource> allCustomer() {

		List<Customer> customersEntity = customerRepo.findAll();

		return customerMapper.mapCustomerEntityToResource(customersEntity);
	}
}
