package com.masai.ServiceLayerImplementations;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.masai.Exceptions.OrderException;
import com.masai.Repository.OrderDao;
import com.masai.ServiceLayer.OrderService;
import com.masai.models.CustomerOrder;

@Controller
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;

	@Override
	public CustomerOrder addOrder(CustomerOrder order) throws OrderException {
		
		CustomerOrder savedOrder=orderDao.save(order);
	if(savedOrder!=null) {
		return savedOrder;
	}
	else {
		throw new OrderException("no such order");
	}
		
	
	}

	@Override
	public CustomerOrder updateOrder(CustomerOrder order) throws OrderException {
		
		Optional<CustomerOrder> updateorder=orderDao.findById(order.getBookingOrderId());
		
		if(updateorder.isPresent()) {
			return orderDao.save(order);
		}
		else{
			throw new OrderException("Invalid order details");
		}
		
	}

	@Override
	public CustomerOrder deleteOrderById(Integer orderId) throws OrderException {
		
		CustomerOrder exsistingOrder=orderDao.findById(orderId).orElseThrow(() -> new OrderException("Order is not listed"+orderId));
		
		orderDao.delete(exsistingOrder);
		return exsistingOrder;
	}

	@Override
	public CustomerOrder viewOrder(Integer orderId) throws OrderException {
		Optional<CustomerOrder> vieworder =orderDao.findById(orderId);
		if(vieworder.isPresent()) {
			return vieworder.get();
		}
		else {
			throw new OrderException("No order is found");
		}
		
	}

	@Override
	public List<CustomerOrder> viewAllOrders() throws OrderException {
		List<CustomerOrder> orders=orderDao.findAll();
		if(orders.size()>0) {
			return orders;
		}
		else {
			throw new OrderException("No student found");
		}
		
	}

}
