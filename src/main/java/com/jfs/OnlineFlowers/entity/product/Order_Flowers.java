package com.jfs.OnlineFlowers.entity.product;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jfs.OnlineFlowers.entity.Order;

@Entity
public class Order_Flowers implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ofid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Order order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Flowers flower;
	
	private int fquantity;
	
	private int rating;
	
	public Order_Flowers() {
		
	}

	public Order_Flowers(int ofid, Order order, Flowers flower, int fquantity, int rating) {
		super();
		this.ofid = ofid;
		this.order = order;
		this.flower = flower;
		this.fquantity = fquantity;
		this.rating = rating;
	}


	public int getOfid() {
		return ofid;
	}

	public void setOfid(int ofid) {
		this.ofid = ofid;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Flowers getFlower() {
		return flower;
	}

	public void setFlower(Flowers flower) {
		this.flower = flower;
	}

	public int getFquantity() {
		return fquantity;
	}

	public void setFquantity(int fquantity) {
		this.fquantity = fquantity;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	

}
