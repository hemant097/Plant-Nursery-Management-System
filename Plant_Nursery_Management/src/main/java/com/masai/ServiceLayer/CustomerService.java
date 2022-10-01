package com.masai.ServiceLayer;

import java.util.List;

import com.masai.Exceptions.CustomerException;
import com.masai.Exceptions.UserAlreadyExists;
import com.masai.models.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer) throws UserAlreadyExists,CustomerException;

	public Customer updateCustomer(Customer tenant,String Key) throws CustomerException;

	public Customer deleteCustomer(Customer tenant,String Key) throws CustomerException;

	public Customer viewCustomer(int customerId) throws CustomerException;

	public List<Customer> viewAllCustomer() throws CustomerException;

	public Customer validateCustomer(String userName, String password) throws CustomerException;

}
