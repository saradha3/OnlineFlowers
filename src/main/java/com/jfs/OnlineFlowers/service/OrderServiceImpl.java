package com.jfs.OnlineFlowers.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfs.OnlineFlowers.entity.Order;
import com.jfs.OnlineFlowers.entity.User;
import com.jfs.OnlineFlowers.entity.product.Category;
import com.jfs.OnlineFlowers.entity.product.Flowers;
import com.jfs.OnlineFlowers.repository.OrderRepository;
import com.jfs.OnlineFlowers.repository.UserRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		return this.orderRepository.save(order);
	}

	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		
		return this.orderRepository.save(order);
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return new ArrayList<>(this.orderRepository.findAll());
	}

	@Override
	public Order getOrder(int orderid) {
		// TODO Auto-generated method stub
		return this.orderRepository.findByOrderid(orderid);
	}

	@Override
	public List<Order> getOrdersByUsername(String username) {
		// TODO Auto-generated method stub
		User user1 = this.userRepository.findByUsername(username);
		return this.orderRepository.findByUser(user1);
	}



}
