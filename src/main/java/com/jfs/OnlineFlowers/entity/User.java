package com.jfs.OnlineFlowers.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = "users")
public class User implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	
	@Column(unique = true)
	private String email;
	private String phone;
	private String address;
	//private String ipAddress;
	
	@Column(name = "dp")
	@Lob
	private byte[] dp;
	
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
	@JsonIgnore
	private User_Roles userrole;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Order> orders;


	public User() {
		
	}

	public User(byte[] dp) {
		super();
		this.dp = dp;
	}

	public User(int userid, String username, String password, String firstname, String lastname, String email,
			String phone, String address, byte[] dp, User_Roles userrole, List<Order> orders) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.address = address;
		
		this.dp = dp;
		this.userrole = userrole;
		this.orders = orders;
	}









	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getDp() {
		return dp;
	}

	public void setDp(byte[] dp) {
		this.dp = dp;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public User_Roles getUserrole() {
		return userrole;
	}


	public void setUserrole(User_Roles userrole) {
		this.userrole = userrole;
	}
	
	
	
	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", dp=" + Arrays.toString(dp) + ", userrole=" + userrole + ", orders=" + orders + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Set<Authority> set = new HashSet<>();
		//Set set = new HashSet();
		//System.out.println(this.getUserrole());
		//System.out.println(this.userrole.getRole());
		
		set.add(new Authority(this.userrole.getRole().getRolename()));
		//set.add(this.userrole.getRole().getRolename());
		System.out.println("Inside getAuthorities" +set);
		for(Authority i: set) {
			System.out.println(i.getAuthority());
		}
		return set;
	}






	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}






	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}






	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}






	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	

}
