package com.jfs.OnlineFlowers.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jfs.OnlineFlowers.entity.product.Category_Flowers;
import com.jfs.OnlineFlowers.entity.product.Order_Flowers;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderid;
	//private String ordertitle;
	private String review;
	//private double rating;
	private int price;
	private String status;
	private String ordered_date;
	//private Date dispatched_date;
	//private Date delivered_date;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
	@JsonIgnore
	private List<Order_Flowers> orderflower = new ArrayList<Order_Flowers>();
	
	public Order() {
		
	}

	public Order(int orderid,  String review,  int price, String status,
			String ordered_date, User user, List<Order_Flowers> orderflower) {
		super();
		this.orderid = orderid;
		
		this.review = review;
		
		this.price = price;
		this.status = status;
		this.ordered_date = ordered_date;
		
		this.user = user;
		this.orderflower = orderflower;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrdered_date() {
		return ordered_date;
	}

	public void setOrdered_date(String ordered_date) {
		this.ordered_date = ordered_date;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Order_Flowers> getOrderflower() {
		return orderflower;
	}

	public void setOrderflower(List<Order_Flowers> orderflower) {
		this.orderflower = orderflower;
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", review=" + review + ", price=" + price + ", status=" + status
				+ ", ordered_date=" + ordered_date + ", user=" + user + ", orderflower=" + orderflower + "]";
	}

	
	
	
	

}
