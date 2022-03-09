package com.jfs.OnlineFlowers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jfs.OnlineFlowers.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	public User findByUsername(String username);
	
	@Transactional
	public void deleteByUsername(String username);

	public User findByEmail(String email);

}
