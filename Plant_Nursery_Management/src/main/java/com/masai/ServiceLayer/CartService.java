package com.masai.ServiceLayer;
import java.util.List;
import com.masai.models.Cart;
import com.masai.models.Customer;
import com.masai.models.CustomerOrder;


public interface CartService {
	
	public Cart addToCart( Integer CustomerId,Integer productId ) ;
	
	public Cart getAllItem(Cart cart);
	
	public String deleteFromCart(Integer Id);
	
	public String emptyCart();
	
	
	
}