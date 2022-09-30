package com.masai.ServiceLayer;

import java.util.List;

import com.masai.models.Cart;
import com.masai.models.Customer;
import com.masai.models.ItemDTO;
import com.masai.models.Order;



public interface CartService {
	
	public Cart  saveCart(Customer customer,Order item);
	
	public List<Order> getAllItem(Cart cart);
	
	

	public Cart alterCart(Customer customer, ItemDTO newItem);
}