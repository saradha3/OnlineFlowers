package com.jfs.OnlineFlowers.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.apache.tomcat.util.json.JSONParser;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jfs.OnlineFlowers.entity.Roles;
import com.jfs.OnlineFlowers.entity.User;
import com.jfs.OnlineFlowers.entity.User_Roles;
import com.jfs.OnlineFlowers.repository.RoleRepository;
import com.jfs.OnlineFlowers.repository.UserRepository;
import com.jfs.OnlineFlowers.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//creating User
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		//encoding password with bcryptpasswordencoder 
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		try {
		Roles role2 = new Roles();
		role2.setRoleid(34);
		role2.setRolename("Normal");
		this.roleRepository.save(role2);
		
		User_Roles userrole= new User_Roles();
		userrole.setUser(user);
		userrole.setRole(role2);
		
		user.setUserrole(userrole);
		
		return this.userService.createUser(user);
		}
		catch(DataIntegrityViolationException e) {
			throw new Exception("Email ID already exists");
		}
	}
	
	//get user by username
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		
		return this.userService.getUser(username);
		
	}
	
	//get user by email
		@GetMapping("/email/{email}")
		public User getUserByEmail(@PathVariable("email") String email) {
			
			return this.userService.getUserByEmail(email);
			
		}
		
	//get user dp
		@GetMapping("/dp/{username}")
		public User getImage(@PathVariable("username") String username) throws IOException {

			User user = this.userRepository.findByUsername(username);
			byte[] img = decompressBytes(user.getDp());
			user.setDp(img);
			return user;
		}
		
	//update user dp	
		@PutMapping("/update/dp/{username}")
		public User updatedp(@RequestParam("imageFile") MultipartFile file, @PathVariable String username) throws IOException {

			System.out.println("Original Image Byte Size - " + file.getBytes().length);
			byte[] img = compressBytes(file.getBytes());
			
			User user = this.userRepository.findByUsername(username);
			user.setDp(img);
			//return ResponseEntity.status(HttpStatus.OK);
			
			return this.userService.updateUser(user);
		}
	
	//update user firstname
		@PutMapping("/update/fn/{firstname}")
		public User updatefirstname(@RequestBody String username, @PathVariable String firstname) {
			User existingUser = this.userRepository.findByUsername(username);
			existingUser.setFirstname(firstname);			
			return this.userService.updateUser(existingUser);			
		}
		
	//update user lastname
				@PutMapping("/update/ln/{lastname}")
				public User updatelastname(@RequestBody String username, @PathVariable String lastname) {
					User existingUser = this.userRepository.findByUsername(username);
					existingUser.setLastname(lastname);			
					return this.userService.updateUser(existingUser);			
				}
				
	//update user address
				@PutMapping("/update/addr/{address}")
				public User updateaddress(@RequestBody String username, @PathVariable String address) {
					User existingUser = this.userRepository.findByUsername(username);
					existingUser.setAddress(address);			
					return this.userService.updateUser(existingUser);			
				}
				
	//update user email
				@PutMapping("/update/mail/{email}")
				public User updatemail(@RequestBody String username, @PathVariable String email) {
					User existingUser = this.userRepository.findByUsername(username);
					existingUser.setEmail(email);		
					return this.userService.updateUser(existingUser);			
				}
				
	//update user phone
				@PutMapping("/update/ph/{phone}")
				public User updatephone(@RequestBody String username, @PathVariable String phone) {
					User existingUser = this.userRepository.findByUsername(username);
					existingUser.setPhone(phone);		
					return this.userService.updateUser(existingUser);			
				}
		
	
	//update user password
	@PutMapping("/update/{newpassword}")
	public User updateUser(@RequestBody String username, @PathVariable String newpassword) {
		//encoding password with bcryptpasswordencoder 
				
				
				User existingUser = this.userRepository.findByUsername(username);
				existingUser.setPassword(this.bCryptPasswordEncoder.encode(newpassword));
				//user.setUserrole(existingUser.getUserrole());
				System.out.println("Inside controller");
				//System.out.println(existingUser.getUserrole());
				
				return this.userService.updateUser(existingUser);
	}
	
	//delete user bu username
	@DeleteMapping("/{username}")
	public void deleteUser(@PathVariable("username") String username) {
		this.userService.deleteUser(username);
	}
	
	@GetMapping("/role/{roleid}")
	public Roles getRole(@PathVariable("roleid") int roleid) {
		
		return this.roleRepository.getById(roleid);
		
	}
	
	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}
	
	
	// uncompress the image bytes before returning it to the angular application
		public static byte[] decompressBytes(byte[] data) {
			Inflater inflater = new Inflater();
			inflater.setInput(data);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			try {
				while (!inflater.finished()) {
					int count = inflater.inflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				outputStream.close();
			} catch (IOException ioe) {
			} catch (DataFormatException e) {
			}
			return outputStream.toByteArray();
		}

}
