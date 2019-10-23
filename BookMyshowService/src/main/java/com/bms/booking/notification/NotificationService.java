package com.bms.booking.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.integration.support.MessageBuilder;



@Service
@EnableBinding(NotificationBinding.class)
@Slf4j
public class NotificationService {
	
	@Autowired
	NotificationBinding notificationBinding;
	
	
	public void notfiyEmailService(EmailMsg emailMsg)
	{
		notificationBinding.emailQuee().send(MessageBuilder.withPayload(emailMsg).build());
		log.info("msg sent"+emailMsg.toString());
	}
	
}
