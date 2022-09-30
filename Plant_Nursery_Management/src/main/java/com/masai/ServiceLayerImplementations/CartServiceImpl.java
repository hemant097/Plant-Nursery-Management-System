package com.masai.ServiceLayerImplementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.Repository.CartDAO;
import com.masai.ServiceLayer.CartService;
import com.masai.models.Cart;
import com.masai.models.Customer;
import com.masai.models.Order;
import com.masai.models.ItemDTO;






@Service
public class CartServiceImpl implements CartService {

	private CartDAO cartDAO;
	
	@Override
	public Cart saveCart(Customer customer, Order item) {
		
		return null;
	}

	@Override
	public List<Order> getAllItem(Cart cart) {
		return null;
	}

	

	@Override
	public Cart alterCart(Customer customer, ItemDTO newItem) {
		// TODO Auto-generated method stub
		return null;
	}



	
}
