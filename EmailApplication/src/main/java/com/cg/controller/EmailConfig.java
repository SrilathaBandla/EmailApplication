package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.User;
import com.cg.service.EmailService;

@RestController
public class EmailConfig {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private User user;
	
	@RequestMapping("/send-mail")
	public String send() {
		
		
		user.setEmail("srilathabandla409@gmail.com");
		try {
			emailService.sendMail(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
	
	//	emailService.sendMail(user);
		return "Congratulations! Your mail has been send to the user.";
	}
	
	@RequestMapping("/send-mail-attachment")
	public String sendMailAttachment() {
		
		user.setEmail("srilathabandla409@gmail.com");
	   try {
			emailService.sendMail(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
	
		//emailService.sendMail(user);
		return "Congratulations! Your mail has been send to the user.";
	}
	
	}
		
		
		
	


