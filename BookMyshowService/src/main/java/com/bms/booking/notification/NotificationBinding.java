package com.bms.booking.notification;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface NotificationBinding {

	@Output("emailChannel")
	MessageChannel emailQuee();
	
	/*
	 * @Output("smsChannel") MessageChannel smsQuee();
	 */
}
