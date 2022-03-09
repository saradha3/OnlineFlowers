package com.jfs.OnlineFlowers.service;

import java.util.Set;

import com.jfs.OnlineFlowers.entity.User;
import com.jfs.OnlineFlowers.entity.User_Roles;

public interface UserService {
	
	//creating User
	public User createUser(User user) throws Exception;
	
	//getting user by username
	public User getUser(String username);
	
	//getting user by email
	public User getUserByEmail(String email);
	
	//deleting user by username
	public void deleteUser(String username);

	public User updateUser(User user);

}
