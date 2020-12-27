package com.bawnya.ravid.learning;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bawnya.ravid.learning.resources.CustomerResource;
import com.bawnya.ravid.learning.resources.CustomerResult;
import com.bawnya.ravid.learning.service.CustomerService;

@RestController
public class AzureExampleController {
	
	private Logger logger = LoggerFactory.getLogger(AzureExampleController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerResource> getCustomer(@PathVariable("customerId") int customerId) {
		
		logger.info("Request received for customer id {}", customerId);
		CustomerResource custResournce  = customerService.getCustomer(customerId);
		
		if (custResournce == null) {
			logger.error("{} Customer resource not found", CustomerAPIConstants.CUSTOMER_NOT_FOUND);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			logger.info("Request completed in controller");
			return ResponseEntity.ok(custResournce);
		}
	}
	
	@GetMapping("/all") 
	public CustomerResult getAllCustomers() {
		
		List<CustomerResource> customers = customerService.allCustomer();
		CustomerResult result = new CustomerResult();
		result.setCustomers(customers);;
		return result;
	}
	
	@PostMapping( path =  "/create",  consumes = "application/json", produces = "application/json")
	public int createCustomer(@RequestBody CustomerResource customer) {
		
		return customerService.createCustomer(customer);
		
	}
	
	@GetMapping("/") 
	public String getSimpleMessage() {
		
		return "This is Simple message : " + new Date();
		
	}
	
}
