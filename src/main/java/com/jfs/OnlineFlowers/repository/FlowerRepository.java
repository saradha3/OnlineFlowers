package com.jfs.OnlineFlowers.repository;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfs.OnlineFlowers.entity.product.Category_Flowers;
import com.jfs.OnlineFlowers.entity.product.Flowers;

@Repository
public interface FlowerRepository extends JpaRepository<Flowers, Integer> {

	@Transactional
	public void deleteByTitle(String fname);

	public Flowers findByTitle(String fname);

	public Flowers findByCategoryflower(Category_Flowers categoryflower);

	

}
