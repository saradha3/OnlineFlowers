package com.jfs.OnlineFlowers.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfs.OnlineFlowers.entity.product.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	public Category findByTitle(String cname);

	@Transactional
	public void deleteByTitle(String cname);

}
