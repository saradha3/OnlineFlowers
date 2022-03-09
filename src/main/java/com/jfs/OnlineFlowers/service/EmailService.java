package com.jfs.OnlineFlowers.service;

public interface EmailService {
	
	public boolean sendMail(String to, String message, String subject);

}
