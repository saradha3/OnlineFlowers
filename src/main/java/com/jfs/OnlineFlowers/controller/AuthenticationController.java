package com.jfs.OnlineFlowers.controller;

import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jfs.OnlineFlowers.config.JwtUtils;
import com.jfs.OnlineFlowers.entity.JwtRequest;
import com.jfs.OnlineFlowers.entity.JwtResponse;
import com.jfs.OnlineFlowers.entity.User;
import com.jfs.OnlineFlowers.service.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@PostMapping("/generate-token")
	@CrossOrigin("*")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		try {
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		}
		catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User not found");
		}
		
		//If user exist, then generate token
		try {
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
		}
		catch(UsernameNotFoundException e) {
			throw new Exception("User not found" +e.getMessage());
		}
		
		
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			System.out.println("Inside authenticate method");
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
			
		}
		catch(DisabledException e){
			throw new Exception("User Disabled");
		}
		catch(UsernameNotFoundException e) {
			throw new Exception("User not found" +e.getMessage());
		}
		catch(BadCredentialsException e) {
			throw new Exception("Invalid Cedentials" +e.getMessage());
		}
		
	}
	
	//returns the details of current user
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return ((User)this.userDetailsService.loadUserByUsername(principal.getName()));
	}

}
