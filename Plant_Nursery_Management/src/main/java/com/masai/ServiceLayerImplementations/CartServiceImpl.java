package com.masai.ServiceLayerImplementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.CustomerException;
import com.masai.Repository.CustomerDAO;
import com.masai.Repository.PlanterDAO;
import com.masai.Repository.UserDAO;
import com.masai.Repository.UserSessionDAO;
import com.masai.ServiceLayer.CartService;
import com.masai.models.Cart;
import com.masai.models.Customer;
import com.masai.models.Planter;
import com.masai.models.User;
@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private PlanterDAO planterDAO;
	@Autowired
	private  CustomerDAO customerDao;
	@Autowired
	private UserSessionDAO userSessionDao;
	@Autowired
	private UserDAO userDao;
		
	
	@Override
	public Cart addToCart(Integer CustomerId, Integer productId) throws CustomerException {
		
		Optional<Planter> planter=planterDAO.findById(productId);
		Optional<Customer> customer=customerDao.findById(CustomerId);
		
		if(customer.isEmpty()) {
			throw new CustomerException("customer not found");
			
		}
		String moibileNumber=customer.get().getMobile();
		User user=userDao.findByMobile(moibileNumber);
//		String use=userSessionDao.findById(user.getUserId());
//		 return null;
		 
	
	
	}

	@Override
	public Cart getAllItem(Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteFromCart(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String emptyCart() {
		// TODO Auto-generated method stub
		return null;
	}

}
