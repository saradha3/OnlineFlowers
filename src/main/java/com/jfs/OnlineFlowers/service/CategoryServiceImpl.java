package com.jfs.OnlineFlowers.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfs.OnlineFlowers.entity.User;
import com.jfs.OnlineFlowers.entity.product.Category;
import com.jfs.OnlineFlowers.entity.product.Category_Flowers;
import com.jfs.OnlineFlowers.repository.CategoryFlowersRepository;
import com.jfs.OnlineFlowers.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryFlowersRepository cfRepository;

	@Override
	public Category addCategory(Category category) throws Exception {
		// TODO Auto-generated method stub
		Category local = this.categoryRepository.findByTitle(category.getTitle());
		if(local!=null) {
			System.out.println("Category already exists");
			throw new Exception("Category already exists");
		}
		else {
			local = this.categoryRepository.save(category);
		}
		return local;
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepository.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.categoryRepository.findAll());
	}

	@Override
	public Category getCategory(String cname) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findByTitle(cname);
	}

	@Override
	public void deleteCategory(String cname) {
		// TODO Auto-generated method stub
		/*Category local = this.categoryRepository.findByTitle(cname);
		List<Category_Flowers> categoryflowers = local.getCategoryflower();
		for(Category_Flowers cf: categoryflowers) {
			int id = cf.getCfid();
			System.out.println("id is:" +id);
			this.cfRepository.deleteById(id);
			//System.out.println(cf.getCategory());
			
		}
		System.out.println(cname);*/
		this.categoryRepository.deleteByTitle(cname);
	}

}
