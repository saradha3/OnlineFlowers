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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Flowers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fid;
	
	private String title;
	private String description;
	private String image;
	private int s_quantity;
	private double s_price;
	private int m_quantity;
	private double m_price;
	private int l_quantity;
	private double l_price;
	private int avg_rating;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "flower")
	@JsonIgnore
	private List<Category_Flowers> categoryflower = new ArrayList<Category_Flowers>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "flower")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private List<Order_Flowers> orderflower = new ArrayList<Order_Flowers>();
	
	public Flowers() {
		
	}

	public Flowers(int fid, String title, String description, String image, int s_quantity, double s_price,
			int m_quantity, double m_price, int l_quantity, double l_price, int avg_rating,
			List<Category_Flowers> categoryflower, List<Order_Flowers> orderflower) {
		super();
		this.fid = fid;
		this.title = title;
		this.description = description;
		this.image = image;
		this.s_quantity = s_quantity;
		this.s_price = s_price;
		this.m_quantity = m_quantity;
		this.m_price = m_price;
		this.l_quantity = l_quantity;
		this.l_price = l_price;
		this.avg_rating = avg_rating;
		this.categoryflower = categoryflower;
		this.orderflower = orderflower;
	}


	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public int getS_quantity() {
		return s_quantity;
	}

	public void setS_quantity(int s_quantity) {
		this.s_quantity = s_quantity;
	}

	public double getS_price() {
		return s_price;
	}

	public void setS_price(double s_price) {
		this.s_price = s_price;
	}

	public int getM_quantity() {
		return m_quantity;
	}

	public void setM_quantity(int m_quantity) {
		this.m_quantity = m_quantity;
	}

	public double getM_price() {
		return m_price;
	}

	public void setM_price(double m_price) {
		this.m_price = m_price;
	}

	public int getL_quantity() {
		return l_quantity;
	}

	public void setL_quantity(int l_quantity) {
		this.l_quantity = l_quantity;
	}

	public double getL_price() {
		return l_price;
	}

	public void setL_price(double l_price) {
		this.l_price = l_price;
	}

	public List<Category_Flowers> getCategoryflower() {
		return categoryflower;
	}

	public void setCategoryflower(List<Category_Flowers> categoryflower) {
		this.categoryflower = categoryflower;
	}


	public List<Order_Flowers> getOrderflower() {
		return orderflower;
	}

	public void setOrderflower(List<Order_Flowers> orderflower) {
		this.orderflower = orderflower;
	}

	public int getAvg_rating() {
		return avg_rating;
	}

	public void setAvg_rating(int avg_rating) {
		this.avg_rating = avg_rating;
	}

	@Override
	public String toString() {
		return "Flowers [fid=" + fid + ", title=" + title + ", description=" + description + ", image=" + image
				+ ", s_quantity=" + s_quantity + ", s_price=" + s_price + ", m_quantity=" + m_quantity + ", m_price="
				+ m_price + ", l_quantity=" + l_quantity + ", l_price=" + l_price + ", avg_rating=" + avg_rating
				+ ", categoryflower=" + categoryflower + ", orderflower=" + orderflower + "]";
	}

	
	
	

}
