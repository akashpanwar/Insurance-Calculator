package com.pepperminzia.utility.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
public class SendMail {
	Logger logger = LoggerFactory.getLogger(SendMail.class);

	@Autowired
	private JavaMailSender javaMailSender;

	public SendMail(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendMessage(String to, String subject, String body) {
		logger.info("Started sending mail");

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = null;
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setTo(to);
			helper.setText(body);
			helper.setSubject(subject);
			javaMailSender.send(message);
			logger.info("Done sending mail");
		} catch (Exception e) {
			throw new RuntimeException("Error occurred while sending email", e);
		}
	}
	
}