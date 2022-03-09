package com.jfs.OnlineFlowers.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jfs.OnlineFlowers.entity.Order;
import com.jfs.OnlineFlowers.entity.product.Flowers;
import com.jfs.OnlineFlowers.entity.product.Order_Flowers;
import com.jfs.OnlineFlowers.repository.OrderFlowersRepository;
import com.jfs.OnlineFlowers.service.FlowerService;
import com.jfs.OnlineFlowers.service.OrderService;

@RestController
@RequestMapping("/orderflowers")
@CrossOrigin("*")
public class OrderFlowersController {
	@Autowired
	private OrderFlowersRepository orderflowersrepo;
	
	@Autowired
	private FlowerService flowerservice;
	
	@Autowired
	private OrderService orderservice;
	
	@PutMapping("/{orderid}/{review}")
	public ResponseEntity<JSONParser> updateOrderFlowers(@RequestBody HashMap<Integer, Integer> map, @PathVariable int orderid,@PathVariable String review) {
		Order order = this.orderservice.getOrder(orderid);
		System.out.println("inside updateorderflowers controller");
		
		List<Order_Flowers> ofs = this.orderflowersrepo.findByOrder(order);
		order.setReview(review);
		this.orderservice.updateOrder(order);
		for(Order_Flowers orderflower: ofs) {
			
			for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
				//System.out.println(orderflower.getFlower().getFid() + " " +entry.getKey());
				if(orderflower.getFlower().getFid() == entry.getKey()) {
					orderflower.setRating(entry.getValue());
					this.orderflowersrepo.save(orderflower);
				}
			}
			
			//to calc avg_rating in flowers table
			int count = this.orderflowersrepo.countofsameflowers(orderflower.getFlower());
			int sum = this.orderflowersrepo.sumofratings(orderflower.getFlower());
			int avg = sum/count;
			
			Flowers flower = this.flowerservice.getFlowers(orderflower.getFlower().getTitle());
			flower.setAvg_rating(avg);
			this.flowerservice.updateFlowers(flower);
		}
		
		return ResponseEntity.ok(new JSONParser("Done"));
	}

}
