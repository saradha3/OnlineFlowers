package com.jfs.OnlineFlowers.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfs.OnlineFlowers.entity.product.Category;
import com.jfs.OnlineFlowers.entity.product.Category_Flowers;

@Repository
public interface CategoryFlowersRepository extends JpaRepository<Category_Flowers, Integer> {

	
	//public boolean deleteByCfid(int id);

	@Transactional
	public void deleteByCategory(Category category);

	@Override
	default void deleteById(Integer id) {
		// TODO Auto-generated method stub
		System.out.println(id);
	}

}
