package com.jfs.OnlineFlowers.repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jfs.OnlineFlowers.entity.User;
import com.jfs.OnlineFlowers.repository.UserRepository;

@SpringBootTest
class UserRepoTest {
	
	@Autowired
	private UserRepository userRepository;

	@Test
	void testFindByUsername() {
		//fail("Not yet implemented");
		User user = new User();
		user.setUsername("Bindhu");
		user.setPassword("pwd");
		user.setEmail("bindhu@gmail.com");
		userRepository.save(user);
		String actualResult = userRepository.findByUsername("Bindhu").getEmail();
		
		assertThat(actualResult).isEqualTo("bindhu@gmail.com");
		
	}

	@Test
	void testFindByEmail() {
		//fail("Not yet implemented");
		User user = new User();
		user.setUsername("Bindhu");
		user.setPassword("pwd");
		user.setEmail("bindhu@gmail.com");
		userRepository.save(user);
		String actualResult = userRepository.findByEmail("bindhu@gmail.com").getUsername();
		
		assertThat(actualResult).isEqualTo("Bindhu");
	}
	
	@AfterEach
	void tearDown() {
		userRepository.deleteByUsername("Bindhu");
	}

}
