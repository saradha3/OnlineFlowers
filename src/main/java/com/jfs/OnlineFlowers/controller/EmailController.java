package com.jfs.OnlineFlowers.controller;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jfs.OnlineFlowers.service.EmailService;

@RestController
@RequestMapping("/email")
@CrossOrigin("*")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/registration/{to}")
	public ResponseEntity<?> sendEmail(@PathVariable String to) {
		String subject = "Registration on Sara Flowers";
		String message = "You have successfully created an account on Sara Flowers Shop!! We wish you a very happy and pleasant shopping!!";
		this.emailService.sendMail(to, message, subject);
		return ResponseEntity.ok("Done");
		
	}
	
	@PostMapping("/orderconfirmed/{to}")
	public ResponseEntity<?> confirmordermail(@RequestBody String message,@PathVariable String to){
		String subject = "Order Confirmation";
		String msg = message;
		this.emailService.sendMail(to, msg, subject);
		return ResponseEntity.ok("Done");
		
	}
	
	@PostMapping("/updatestock")
	public ResponseEntity<?> updatestockmail(@RequestBody String message){
		String subject = "Update Stock";
		String msg = message;
		this.emailService.sendMail("saradhamuthukumaran3@gmail.com", msg, subject);
		return ResponseEntity.ok("Done");
		
	}
	
	@PostMapping("/orderreceived")
	public ResponseEntity<?> orderreceivedmail(@RequestBody String message){
		String subject = "New Order Received";
		String msg = message;
		this.emailService.sendMail("saradhamuthukumaran3@gmail.com", msg, subject);
		return ResponseEntity.ok("Done");
		
	}
	
	@PostMapping("/forgotpassword/{to}")
	public ResponseEntity<JSONParser> forgotpasswordmail(@RequestBody String message,@PathVariable String to){
		String subject = "Forgot Password?";
		String msg = message;
		this.emailService.sendMail(to, msg, subject);
		return ResponseEntity.ok(new JSONParser("Done"));
		
	}
	
	@PostMapping("/contactform")
	public ResponseEntity<JSONParser> contactform(@RequestBody String message){
		String subject = "Message from customer";
		String msg = message;
		this.emailService.sendMail("saradhamuthukumaran3@gmail.com", msg, subject);
		return ResponseEntity.ok(new JSONParser("Done"));
		
	}
	
	@PostMapping("/feedback")
	public ResponseEntity<JSONParser> feedback(@RequestBody String message){
		String subject = "Feedback from customer";
		String msg = message;
		this.emailService.sendMail("saradhamuthukumaran3@gmail.com", msg, subject);
		return ResponseEntity.ok(new JSONParser("Done"));
		
	}

}
