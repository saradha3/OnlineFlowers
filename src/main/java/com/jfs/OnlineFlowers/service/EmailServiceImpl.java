package com.jfs.OnlineFlowers.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	@Override
	public boolean sendMail(String to, String message, String subject) {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		String host = "smtp.gmail.com";
		
		Properties props = System.getProperties();
		
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("saradhamuthukumaran3@gmail.com", "saradhagmail3");
			}
			
		});
		
		session.setDebug(true);
		
		try {
			MimeMessage m = new MimeMessage(session);
			
			m.setFrom("saradhamuthukumaran3@gmail.com");
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);
			m.setText(message);
			
			Transport.send(m);
			System.out.println("Mail sent successfully");
			flag = true;
			
		}
		catch(MessagingException e) {
			e.printStackTrace();
		}
		
		
		return flag;
	}

}
