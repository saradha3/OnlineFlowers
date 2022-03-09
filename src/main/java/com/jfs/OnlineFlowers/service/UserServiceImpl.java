package com.jfs.OnlineFlowers.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfs.OnlineFlowers.entity.User;
import com.jfs.OnlineFlowers.entity.User_Roles;
import com.jfs.OnlineFlowers.repository.RoleRepository;
import com.jfs.OnlineFlowers.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user) throws Exception {
		// TODO Auto-generated method stub
		User local = this.userRepository.findByUsername(user.getUsername());
		if(local!=null) {
			System.out.println("User already exists");
			throw new Exception("User already exists");
		}
		else {
			local = this.userRepository.save(user);
		}
		return local;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		User local = this.userRepository.findByUsername(username);
		return local;
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		this.userRepository.deleteByUsername(username);
		
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return this.userRepository.save(user);
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return this.userRepository.findByEmail(email);
	}

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	

}
