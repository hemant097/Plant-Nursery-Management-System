package com.masai.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exceptions.CustomerException;
import com.masai.ServiceLayer.CustomerService;
import com.masai.models.Customer;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService cService;

	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomerHandler(@Valid @RequestBody Customer customer)
			throws CustomerException {

		Customer savedCustomer = cService.addCustomer(customer);

		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
	}

	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomerHandler(@RequestBody Customer customer,@RequestParam(required = false) String key) throws CustomerException{
		
		Customer updatedCustomer=cService.updateCustomer(customer,key);
		
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
		
		
		
	}

}
