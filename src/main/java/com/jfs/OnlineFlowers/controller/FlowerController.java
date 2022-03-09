package com.jfs.OnlineFlowers.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.bind.annotation.RestController;

import com.jfs.OnlineFlowers.entity.product.Category;
import com.jfs.OnlineFlowers.entity.product.Category_Flowers;
import com.jfs.OnlineFlowers.entity.product.Flowers;
import com.jfs.OnlineFlowers.repository.CategoryRepository;
import com.jfs.OnlineFlowers.service.CategoryService;
import com.jfs.OnlineFlowers.service.FlowerService;

@RestController
@RequestMapping("/flowers")
@CrossOrigin("*")
public class FlowerController {
	
	@Autowired
	private FlowerService flowerService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	//add flowers
	@PostMapping("/{cnames}")
	public Flowers addFlower(@RequestBody Flowers flower, @PathVariable List<String> cnames) throws Exception{
		//String cname = "";
		System.out.println(flower);
		/*Set<Category_Flowers> cs = flower.getCategoryflower();
		System.out.println("set is" +cs);
		for (Category_Flowers category_Flowers : cs)  {
			cname = category_Flowers.getCategory().getTitle();
			System.out.println(cname);
		}*/
		List<Category_Flowers> cfs = new ArrayList<>();
		for(String cname: cnames) {
			
		System.out.println("cname is" +cname);
		Category category = this.categoryRepository.findByTitle(cname);
		//System.out.println("category is" +category);
		
		Category_Flowers cf = new Category_Flowers();
		cf.setCategory(category);
		cf.setFlower(flower);
		
		
		cfs.add(cf);
		}
		
		
		flower.setCategoryflower(cfs);
		
		return this.flowerService.addFlowers(flower);
		
	}
	
	//get all flowers
	@GetMapping("/")
	public List<Flowers> getFlowers() {
		
		return this.flowerService.getFlowers();
	}
	
	//get flowers by title
	@GetMapping("/{title}")
	public Flowers getFlower(@PathVariable("title") String title) {
		return this.flowerService.getFlowers(title);
	}
	
	//get flowers by category
	@GetMapping("/category/{cname}")
	public List<Flowers> getFlowerByCategory(@PathVariable("cname") String cname){
		Category category = this.categoryRepository.findByTitle(cname);
		List<Category_Flowers> cf = category.getCategoryflower();
		List<Flowers> flowers = new ArrayList<>();
		Flowers flower = new Flowers();
		for(Category_Flowers cfs: cf) {
			flower = this.flowerService.getFlowersByCategory(cfs) ;
			flowers.add(flower);
		}
		return flowers;
	}
	
	//update flower
	@PutMapping("/")
	public Flowers updateFlower(@RequestBody Flowers flower) {
		return this.flowerService.updateFlowers(flower);
	}
	
	//delete flower by title
	@DeleteMapping("/{title}")
	public void deleteFlower(@PathVariable("title") String title ) {
		this.flowerService.deleteFlowers(title);
	}
	
	//get flowers by orderID
	@GetMapping("/orderid/{orderid}")
	public List<Flowers> getFlowerByOrder(@PathVariable int orderid){
		return this.flowerService.getFlowerByOrder(orderid);
	}
}
