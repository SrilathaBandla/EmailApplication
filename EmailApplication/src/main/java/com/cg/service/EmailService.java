package com.cg.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.cg.model.User;

@Service
public class EmailService {
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;
	}
	
	public void sendMail(User user) throws MailException{
		
		SimpleMailMessage mail = new SimpleMailMessage();
			mail.setTo(user.getEmail());
			mail.setSubject("Cab Booking Details");
			mail.setText("Thanks for Booking our Cab");
			
			javaMailSender.send(mail);
		
	}
	
	public void sendMailAttachment(User user) throws MailException,MessagingException{
		MimeMessage message =javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		helper.setTo(user.getEmail());
		helper.setSubject("Payment Details");
		helper.setText("Please find the attached file for payment details");
		ClassPathResource classPathResource = new ClassPathResource("Attachment.pdf");
		helper.addAttachment(classPathResource.getFilename(),classPathResource);
		javaMailSender.send(message);
	}
}


