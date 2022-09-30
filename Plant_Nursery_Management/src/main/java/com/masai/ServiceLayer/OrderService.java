package com.masai.ServiceLayer;

import java.util.List;
import com.masai.Exceptions.OrderException;
import com.masai.models.CustomerOrder;

public interface OrderService {

	public CustomerOrder addOrder(CustomerOrder order) throws OrderException;

	public CustomerOrder updateOrder(CustomerOrder order) throws OrderException;

	public CustomerOrder deleteOrderById(Integer orderId) throws OrderException;

	public CustomerOrder viewOrder(Integer orderId) throws OrderException;

	public List<CustomerOrder> viewAllOrders() throws OrderException;

}
