package com.jfs.OnlineFlowers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import com.jfs.OnlineFlowers.entity.Roles;
import com.jfs.OnlineFlowers.entity.User;
import com.jfs.OnlineFlowers.entity.User_Roles;
import com.jfs.OnlineFlowers.repository.RoleRepository;
import com.jfs.OnlineFlowers.service.UserService;

@SpringBootApplication
public class OnlineFlowersApplication implements CommandLineRunner{
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(OnlineFlowersApplication.class, args);
	}
	

	public void run(String[] args) throws Exception{
		System.out.println("Starting code");
		User user = new User();
		user.setFirstname("Saradha");
		user.setLastname("Muthukumaran");
		user.setEmail("saradhamuthukumaran3@gmail.com");
		user.setUsername("Sara");
		user.setPassword(this.bCryptPasswordEncoder.encode("sara3"));
		user.setAddress("Chennai");
		//user.setDp("default.png");
		user.setPhone("7010997790");
		
		Roles role1 = new Roles();
		role1.setRoleid(33);
		role1.setRolename("Admin");
		this.roleRepository.save(role1);
		
		User_Roles userrole= new User_Roles();
		userrole.setUser(user);
		userrole.setRole(role1);
		
		user.setUserrole(userrole);
		
		User user1 = this.userService.createUser(user);
		System.out.println(user1.getUsername()); 
		
		
		
		
	}
}
