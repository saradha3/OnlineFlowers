package com.jfs.OnlineFlowers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jfs.OnlineFlowers.entity.product.Category;
import com.jfs.OnlineFlowers.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//add category
	 @PostMapping("/")
	public Category addCategory(@RequestBody Category category) throws Exception{
		Category category1 = this.categoryService.addCategory(category);
		return category1;
	}
	
	
	//get category
	@GetMapping("/{title}")
	public Category getCategory(@PathVariable("title") String title) {
		return this.categoryService.getCategory(title);
	}
	
	//get all categories
	@GetMapping("/")
	public ResponseEntity<?> getCategories(){
		return ResponseEntity.ok(this.categoryService.getCategories());
	}
	
	//update category
	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category) {
		return this.categoryService.updateCategory(category);
	}
	
	//delete category
	@DeleteMapping("/{title}")
	public void deleteCategory(@PathVariable("title") String title) {
		this.categoryService.deleteCategory(title);
	}

}
