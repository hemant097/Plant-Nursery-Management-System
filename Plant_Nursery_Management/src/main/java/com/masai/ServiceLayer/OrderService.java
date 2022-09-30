package com.masai.ServiceLayer;

import java.util.List;

import com.masai.Exceptions.OrderException;
import com.masai.models.Order;

public interface OrderService {

	public Order addOrder(Order order) throws OrderException;

	public Order updateOrder(Order order) throws OrderException;

	public Order deleteOrderById(Integer orderId) throws OrderException;

	public Order viewOrder(Integer orderId) throws OrderException;

	public List<Order> viewAllOrders() throws OrderException;

}
