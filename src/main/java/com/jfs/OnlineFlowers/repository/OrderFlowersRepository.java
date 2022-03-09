package com.jfs.OnlineFlowers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jfs.OnlineFlowers.entity.Order;
import com.jfs.OnlineFlowers.entity.product.Flowers;
import com.jfs.OnlineFlowers.entity.product.Order_Flowers;

public interface OrderFlowersRepository extends JpaRepository<Order_Flowers, Integer> {

	List<Order_Flowers> findByOrder(Order order);
	
	@Query("SELECT COUNT(o) FROM Order_Flowers o WHERE o.flower=?1")
	int countofsameflowers(Flowers flower);
	
	@Query("SELECT SUM(o.rating) FROM Order_Flowers o WHERE o.flower=?1")
	int sumofratings(Flowers flower);

}
