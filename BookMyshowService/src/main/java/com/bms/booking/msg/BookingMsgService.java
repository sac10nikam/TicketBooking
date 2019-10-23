package com.bms.booking.msg;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Service;

import com.bms.booking.data.BookingDao;
import com.bms.booking.notification.EmailMsg;
import com.bms.booking.notification.NotificationService;
import com.bms.user.data.UserDao;
import com.bms.user.data.UserRepositry;

@Service

public class BookingMsgService {

	UserRepositry userRepositry;
	NotificationService notificationService;
	
	@Autowired
	public BookingMsgService(UserRepositry userRepositry,NotificationService notificationService)
	{
		this.userRepositry=userRepositry;
		this.notificationService=notificationService;
	}
	
	public void  sendNotifcations(BookingDao savedBooking)
	{
		UserDao user = userRepositry.findById(savedBooking.getUserId()).get();//Get user mobile number and email 
		
		EmailMsg emailMsg = EmailMsg.builder()
		         .bookingId(savedBooking.getBookingId())
		         .userId(user.getUserId())
		         .userName(user.getName())
		         .emailId(user.getEmailId())
		         .mobNo(user.getMobNo())
		         .build();
		         
		 notificationService.notfiyEmailService(emailMsg);
		 
		//Sendto smsquee(mobile,bookingid);	
	}
}
