package com.jfs.OnlineFlowers.service;

import java.util.Set;

import com.jfs.OnlineFlowers.entity.product.Category;


public interface CategoryService {
	
	public Category addCategory(Category category) throws Exception;
	public Category updateCategory(Category category);
	public Set<Category> getCategories();
	public Category getCategory(String cname);
	public void deleteCategory(String cname);
}
