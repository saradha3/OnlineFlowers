package com.jfs.OnlineFlowers.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.jfs.OnlineFlowers.entity.Order;
import com.jfs.OnlineFlowers.entity.product.Category;


public interface OrderService {

	public Order createOrder(Order order);
	public Order updateOrder(Order order);
	public Order getOrder(int orderid);
	public List<Order> getOrders();
	public List<Order> getOrdersByUsername(String username);
	
}
