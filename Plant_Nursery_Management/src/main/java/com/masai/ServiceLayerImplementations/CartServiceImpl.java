package com.masai.ServiceLayerImplementations;

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
			
			ourCart.getPlanters().add(planter);
			ourCart.setCustomer(customer);
			
			return cartDao.save(ourCart);
			
		}
		
		else
		throw new CartException("No such planter present");	
	
	}

	@Override
	public List<Planter> getAllItem(Integer cartID)
			throws CartException{
		
		Optional<Cart> cartData = cartDao.findById(cartID);
		
		if(cartData.isEmpty())
			throw new CartException("Cart is empty");
		
		else {
			List<Planter> planters = cartData.get().getPlanters();
			return planters;
		}
		
	}

	@Override
	public String deleteFromCart(Integer cartId, Integer planterId) throws PlanterException, CartException {
		
		Optional<Cart> opt = cartDao.findById(cartId);
		
		if (opt.isPresent()) {
			Cart cart = opt.get();
			List<Planter> planters = cart.getPlanters();
			
			for(Planter p:planters) {
				if(p.getPlanterId()==planterId) {
					planterDAO.delete(p);
				}
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
