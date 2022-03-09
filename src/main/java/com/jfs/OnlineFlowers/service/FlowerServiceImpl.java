package com.jfs.OnlineFlowers.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfs.OnlineFlowers.entity.Order;
import com.jfs.OnlineFlowers.entity.User;
import com.jfs.OnlineFlowers.entity.product.Category_Flowers;
import com.jfs.OnlineFlowers.entity.product.Flowers;
import com.jfs.OnlineFlowers.entity.product.Order_Flowers;
import com.jfs.OnlineFlowers.repository.FlowerRepository;
import com.jfs.OnlineFlowers.repository.OrderFlowersRepository;
import com.jfs.OnlineFlowers.repository.OrderRepository;

@Service
public class FlowerServiceImpl implements FlowerService {
	
	@Autowired
	private FlowerRepository flowerRepository;
	
	@Autowired
	private OrderFlowersRepository orderFlowerRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Flowers addFlowers(Flowers flower) throws Exception {
		// TODO Auto-generated method stub
		Flowers local = this.flowerRepository.findByTitle(flower.getTitle());
		if(local!=null) {
			System.out.println("Flower already exists");
			throw new Exception("Flower already exists");
		}
		else {
			local = this.flowerRepository.save(flower);
		}
		return local;
	}

	@Override
	public Flowers updateFlowers(Flowers flower) {
		// TODO Auto-generated method stub
		return this.flowerRepository.save(flower);
	}

	@Override
	public List<Flowers> getFlowers() {
		// TODO Auto-generated method stub
		return new ArrayList<>(this.flowerRepository.findAll());
	}

	@Override
	public Flowers getFlowers(String fname) {
		// TODO Auto-generated method stub
		return this.flowerRepository.findByTitle(fname);
	}

	@Override
	public void deleteFlowers(String fname) {
		// TODO Auto-generated method stub
		this.flowerRepository.deleteByTitle(fname);
	}

	@Override
	public Flowers getFlowersByCategory(Category_Flowers categoryflower) {
		// TODO Auto-generated method stub
		System.out.println(categoryflower);
		System.out.println(this.flowerRepository.findByCategoryflower(categoryflower));
		return this.flowerRepository.findByCategoryflower(categoryflower);
	}

	@Override
	public List<Flowers> getFlowerByOrder(int orderid) {
		// TODO Auto-generated method stub
		Order order = this.orderRepository.findByOrderid(orderid);
		List<Order_Flowers> ofs = this.orderFlowerRepository.findByOrder(order);
		List fls = new ArrayList();
		for(Order_Flowers orderflowers: ofs) {
			Flowers flower = orderflowers.getFlower();
			fls.add(flower);
		}
		return fls;
	}

}
