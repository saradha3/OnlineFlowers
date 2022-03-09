package com.jfs.OnlineFlowers.entity.product;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
public class Category_Flowers implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cfid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Flowers flower;
	
	public Category_Flowers() {
		
	}

	public Category_Flowers(Category category, Flowers flower) {
		super();
		this.category = category;
		this.flower = flower;
	}

	public int getCfid() {
		return cfid;
	}

	public void setCfid(int cfid) {
		this.cfid = cfid;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Flowers getFlower() {
		return flower;
	}

	public void setFlower(Flowers flower) {
		this.flower = flower;
	}

	
	
	

}
