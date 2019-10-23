package com.email.bookingmsg.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface BookingEmailBinding {

	String INPUT_EMAIL = "inputemail";

	@Input(INPUT_EMAIL)
	SubscribableChannel email();
}
