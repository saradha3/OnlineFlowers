package com.jfs.OnlineFlowers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfs.OnlineFlowers.entity.Order;
import com.jfs.OnlineFlowers.entity.User;
import com.jfs.OnlineFlowers.entity.product.Category;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	Order findByOrderid(int orderid);
	List<Order> findByUser(User user);

}
