package com.masai.ServiceLayer;

import java.util.List;

import com.masai.Exceptions.CustomerException;
import com.masai.models.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer) throws CustomerException;
	public Customer updateCustomer(Customer tenant) throws CustomerException;
	public Customer deleteCustomer(Customer tenant) throws CustomerException;
	public Customer viewCustomer(int customerId) throws CustomerException;
	public List<Customer> viewAllCustomer() throws CustomerException;
	public Customer validateCustomer(String userName,String password) throws CustomerException;
	
	
}
