package com.jfs.OnlineFlowers.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class User_Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userroleid;
	
	@OneToOne(fetch = FetchType.EAGER)
	private User user;
	
	@ManyToOne
	private Roles role;
	
	public User_Roles() {
		
	}

	
	public User_Roles(int userroleid, User user, Roles role) {
		
		this.userroleid = userroleid;
		this.user = user;
		this.role = role;
	}



	public int getUserroleid() {
		return userroleid;
	}

	public void setUserroleid(int userroleid) {
		this.userroleid = userroleid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User_Roles [userroleid=" + userroleid + ", user=" + user + ", role=" + role + "]";
	}


	
	
	

}
