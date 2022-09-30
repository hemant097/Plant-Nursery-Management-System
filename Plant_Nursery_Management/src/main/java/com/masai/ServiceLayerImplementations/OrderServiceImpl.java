package com.masai.ServiceLayerImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.masai.Exceptions.OrderException;
import com.masai.Repository.OrderDao;
import com.masai.ServiceLayer.OrderService;
import com.masai.models.Order;
@Controller
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;

	@Override
	public Order addOrder(Order order) throws OrderException {
		
	Order savedOrder=orderDao.save(order);
	if(savedOrder!=null) {
		return savedOrder;
	}
	else {
		throw new OrderException("no such order");
	}
		
	
	}

	@Override
	public Order updateOrder(Order order) throws OrderException {
		
		Optional<Order> updateorder=orderDao.findById(order.getBookingOrderId());
		
		if(updateorder.isPresent()) {
			return orderDao.save(order);
		}
		else{
			throw new OrderException("Invalid order details");
		}
		
	}

	@Override
	public Order deleteOrderById(Integer orderId) throws OrderException {
		
		Order exsistingOrder=orderDao.findById(orderId).orElseThrow(() -> new OrderException("Order is not listed"+orderId));
		
		orderDao.delete(exsistingOrder);
		return exsistingOrder;
	}

	@Override
	public Order viewOrder(Integer orderId) throws OrderException {
		Optional<Order> vieworder =orderDao.findById(orderId);
		if(vieworder.isPresent()) {
			return vieworder.get();
		}
		else {
			throw new OrderException("No order is found");
		}
		
	}

	@Override
	public List<Order> viewAllOrders() throws OrderException {
		List<Order> orders=orderDao.findAll();
		if(orders.size()>0) {
			return orders;
		}
		else {
			throw new OrderException("No student found");
		}
		
	}

}
