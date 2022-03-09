package com.jfs.OnlineFlowers.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jfs.OnlineFlowers.entity.Order;
import com.jfs.OnlineFlowers.entity.User;
import com.jfs.OnlineFlowers.entity.product.Category;
import com.jfs.OnlineFlowers.entity.product.Flowers;
import com.jfs.OnlineFlowers.entity.product.Order_Flowers;
import com.jfs.OnlineFlowers.service.FlowerService;
import com.jfs.OnlineFlowers.service.OrderService;
import com.jfs.OnlineFlowers.service.UserService;

import io.jsonwebtoken.ExpiredJwtException;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	
	@Autowired
	private FlowerService flowerService;
	
	@PostMapping("/{username}/{flowers}/{fqty}")
	public Order addOrder(@RequestBody Order order,@PathVariable String username, @PathVariable String[] flowers, @PathVariable int[] fqty) throws Exception{
		/*Order order2 = new Order();
		order2.setPrice(100);
		order2.setRating(4);
		order2.setReview("Nice");
		order2.setStatus("Ordered");*/
		//Order order1= new Order();
		User user1 = this.userService.getUser(username);
		System.out.println(user1.getUserid());
		order.setUser(user1);
		
		/*java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
		System.out.println(date);
		order.setOrdered_date(date);*/
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String strDate = formatter.format(date);
		order.setOrdered_date(strDate);
		
		List<Order_Flowers> list = new ArrayList<Order_Flowers>();
		
		for(int i=0;i<flowers.length;i++) {
			Flowers flower = this.flowerService.getFlowers(flowers[i]);
			
			Order_Flowers ofs = new Order_Flowers();
			ofs.setFlower(flower);
			ofs.setOrder(order);
			ofs.setFquantity(fqty[i]);
			list.add(ofs);
		}
		order.setOrderflower(list);
		
		return this.orderService.createOrder(order);
		//return order1;
		}
		
	 
	
	//update order
		@PutMapping("/{username}")
		public Order updateOrder(@RequestBody Order order, @PathVariable String username) {
			
			User user1 = this.userService.getUser(username);
			System.out.println(user1.getUserid());
			order.setUser(user1);
			return this.orderService.updateOrder(order);
		}
		
	/*get order
		@GetMapping("/{orderid}")
		public Order getOrder(@PathVariable("orderid") int orderid) {
			return this.orderService.getOrder(orderid);
		}*/
		
	
		/* @GetMapping("/")
		public ResponseEntity<?> getOrders(){
			return ResponseEntity.ok(this.orderService.getOrders());
		}*/
		
	//get all orders
		@GetMapping("/")
		public List<Order> getOrders() {
			
			return this.orderService.getOrders();
		}
		
	//get all orders of a specific user
		@GetMapping("/{username}")
		public List<Order> getOrdersByUserName(@PathVariable String username){
			return this.orderService.getOrdersByUsername(username);
		}
		

}
