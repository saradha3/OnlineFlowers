package com.jfs.OnlineFlowers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jfs.OnlineFlowers.entity.Roles;
import com.jfs.OnlineFlowers.entity.User;

public interface RoleRepository extends JpaRepository<Roles,Integer>{

	//public Roles findByRole(String rolename);

}
