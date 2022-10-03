package com.masai.ServiceLayerImplementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.CartException;
import com.masai.Exceptions.CustomerException;
import com.masai.Exceptions.PlanterException;
import com.masai.Repository.CartDAO;
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
	@Autowired
	private CartDAO cartDao;
	
	@Override
	public Cart addToCart(Integer CustomerId, Integer planterId,Cart ourCart)
			throws CustomerException,CartException {
		
		Optional<Planter> optPlanter=planterDAO.findById(planterId);
		Optional<Customer> optCustomer=customerDao.findById(CustomerId);
		
		if(optCustomer.isEmpty()) {
			throw new CustomerException("customer not found");		
		}
		
		Customer customer = optCustomer.get();
		String mobileNumber=customer.getMobile();
		
		User user=userDao.findByMobile(mobileNumber);
		String isPresentOrNot=userSessionDao.findByUserId(user.getUserId());
		if(isPresentOrNot==null)
		throw new CustomerException("customer not logged IN");
		
		if(optPlanter.isPresent()) {
			
			Planter planter = optPlanter.get();
			
			ourCart.setPlanter(planter);
			ourCart.setCustomer(customer);
			ourCart.setPlanterId(planterId);
			
			return cartDao.save(ourCart);
			
		}
		
		else
		throw new CartException("No such planter present");	
	
	}

	@Override
	public List<Planter> getAllItem()
			throws CartException{
		
		List<Cart> cartData = cartDao.findAll();
		
		if(cartData.isEmpty())
			throw new CartException("Cart is empty");
		
		else {
			
			List<Planter> planters = new ArrayList<>();
			
			for(Cart cart:cartData) {
				planters.add(cart.getPlanter());
			}
			return planters;
		}
		
	}

	@Override
	public String deleteFromCart(Integer cartItemId, Integer planterId) throws PlanterException, CartException {
		
		Optional<Cart> opt = cartDao.findById(cartItemId);
		
		if (opt.isPresent()) {
			Cart cart = opt.get();
			Planter p = cart.getPlanter();
			
		
			if(p.getPlanterId()==planterId) {
				cartDao.delete(cart);
					
			}
			
			
			return "CartProduct is deleted from Cart";
			
		} else
			throw new PlanterException("Product not found with given id");
		
	}

	@Override
	public String emptyCart(){
		
		cartDao.deleteAll();
		
		return "Cart Emptied Successfully";
	}

	

}
