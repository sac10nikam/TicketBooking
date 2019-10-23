package com.email.bookingmsg.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@AllArgsConstructor
@ToString
public class EmailMsg {

	private final Integer bookingId;
    private final Integer userId;
	private final String userName;
    private final Integer mobNo;
	private final String emailId;
    
 // needed for JSON deserialiser
    @SuppressWarnings("unused")
	  private EmailMsg() { 
		  this(null,null, null,null,null); }
}