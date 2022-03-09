package com.jfs.OnlineFlowers.servicetest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.jfs.OnlineFlowers.repository.UserRepository;
import com.jfs.OnlineFlowers.service.UserService;
import com.jfs.OnlineFlowers.service.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	@Mock
	private UserRepository userrepo;
	
	@Autowired
	private UserServiceImpl userservice;
	
	@BeforeEach
	void setUp() {
		this.userservice=new UserServiceImpl(this.userrepo);
	}

	@Test
	void testGetUser() {
		//fail("Not yet implemented");
		userservice.getUser("Sara");
		verify(userrepo).findByUsername("Sara");
	}

}
