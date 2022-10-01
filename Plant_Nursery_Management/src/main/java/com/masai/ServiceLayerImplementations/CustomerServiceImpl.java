package com.masai.ServiceLayerImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.CustomerException;
import com.masai.Exceptions.UserAlreadyExists;
import com.masai.Repository.CustomerDAO;
import com.masai.Repository.UserDAO;
import com.masai.Repository.UserSessionDAO;
import com.masai.ServiceLayer.CustomerService;
import com.masai.models.Customer;
import com.masai.models.User;
import com.masai.models.UserSession;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private  CustomerDAO customerDao;
	@Autowired
	private UserSessionDAO userSessionDao;
	@Autowired
	private UserDAO userDao;

	@Override
	public Customer addCustomer(Customer customer) throws UserAlreadyExists,CustomerException {
		
	Customer existingCustomer=customerDao.findByMobile(customer.getMobile());
	
	if(existingCustomer!=null) {
		throw new UserAlreadyExists("customer already registered with this mobile number");
	}
	
	String mobileNum = customer.getMobile();
	User user=  userDao.findByMobile(mobileNum);
	
	if(user!=null) return customerDao.save(customer);
	
	else throw new CustomerException("You have to login first");
	}
	
	
	
	
	
	@Override
	public Customer updateCustomer(Customer tenant,String Key) throws CustomerException {
		
		UserSession loggedInUser=userSessionDao.findByUniqueId(Key);
		if(loggedInUser==null) {
			throw new CustomerException("please provide a valid Key to update a customer");
			
		}
		else if(tenant.getCustomerId()==loggedInUser.getUserId()){
			return customerDao.save(tenant);
			
		}
		else {
			throw new CustomerException("Invalid details..please login first");
		}
		
		
	}

	@Override
	public Customer deleteCustomer(Integer customerId,String Key) throws CustomerException {
		
		UserSession loggedInUser=userSessionDao.findByUniqueId(Key);
		if(loggedInUser==null) {
			throw new CustomerException("please provide a valid Key to delete a customer");
			
		}
		else if(customerId==loggedInUser.getUserId()){
			Optional<Customer> tenant = customerDao.findById(customerId);
			
			customerDao.delete(tenant.get());
			return tenant.get();
			}
		
		else {
			throw new CustomerException("Invalid details..please login first");
		}
		
		
	}

	@Override
	public Customer viewCustomer(int customerId) throws CustomerException {
		
		Optional<UserSession> loggedInUser=userSessionDao.findById(customerId);
		if(loggedInUser.isPresent()) {
			User user = userDao.findByUserId(loggedInUser.get().getUserId());
			Customer customer = customerDao.findByMobile(user.getMobile());
			
			return customer;
		}
		
		else {
			throw new CustomerException("Invalid details..please login first");
		}
	}

	@Override
	public List<Customer> viewAllCustomer() throws CustomerException {
		
		
		if( customerDao.findAll().size()==0)
			throw new CustomerException("No Customer is saved in the database");
		else {
			return customerDao.findAll();
		}
	}

	@Override
	public Customer validateCustomer(String userName, String password) throws CustomerException {
//		
		
		return null;
	}

}
