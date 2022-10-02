package com.masai.ServiceLayer;
import java.util.List;

import com.masai.Exceptions.CartException;
import com.masai.Exceptions.CustomerException;
import com.masai.Exceptions.PlanterException;
import com.masai.models.Cart;
import com.masai.models.Planter;


public interface CartService {
	
	public Cart addToCart( Integer CustomerId,Integer productId,Cart ourCart )
			throws CustomerException,CartException;
	
	public List<Planter> getAllItem (Integer cartId)throws CartException;
	
	public String deleteFromCart(Integer cartId,Integer planterId)
			throws PlanterException,CartException;
	
	public String emptyCart();
	
	
	
}