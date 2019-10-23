package com.email.bookingmsg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableBinding(BookingEmailBinding.class)
public class BookingEmailListener {
	
	@Autowired
	SendEmailService sendEmailService;
	
	@StreamListener(target =BookingEmailBinding.INPUT_EMAIL)
	public void processBookedEmailMsg(EmailMsg emailMsg) {
		log.info("Email Registered by Client " + emailMsg.toString());
		sendEmailService.sendEmail(emailMsg);
	}
}
