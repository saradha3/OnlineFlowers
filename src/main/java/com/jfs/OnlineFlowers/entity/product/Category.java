package com.jfs.OnlineFlowers.entity.product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	
	private String title;
	private String description;
	private String image;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "category")
	@JsonIgnore
	private List<Category_Flowers> categoryflower = new ArrayList<Category_Flowers>();
			
	
	public Category() {
		
	}

	

	public Category(String title, String description, List<Category_Flowers> categoryflower, String image) {
		super();
		this.title = title;
		this.description = description;
		this.categoryflower = categoryflower;
		this.image = image;
	}



	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public List<Category_Flowers> getCategoryflower() {
		return categoryflower;
	}



	public void setCategoryflower(List<Category_Flowers> categoryflower) {
		this.categoryflower = categoryflower;
	}
	
	



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	@Override
	public String toString() {
		return "Category [cid=" + cid + ", title=" + title + ", description=" + description + ", image=" + image
				+ ", categoryflower=" + categoryflower + "]";
	}
	
	

}
