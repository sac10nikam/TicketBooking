package com.email.bookingmsg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.email.data.EmailMsgRepositry;
import com.email.service.EmailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SendEmailService {

    private JavaMailSender javaMailSender;    
    private  EmailService emailService;
    
    @Autowired
    public SendEmailService(JavaMailSender javaMailSender,EmailService EmailService)
    {
    	this.javaMailSender=javaMailSender;
    	this.emailService=EmailService;
    }
	
    
	public void sendEmail(EmailMsg emailMsg) {
		
		 SimpleMailMessage msg = new SimpleMailMessage();
		 msg.setTo(emailMsg.getEmailId());
	     msg.setSubject("Your BookMyshow ticket Booked");
	     msg.setText("Hello World \n BookMyshow  yourBookingId:"+emailMsg.getBookingId()+"\n"+"mobileNumber:"+emailMsg.getMobNo());
	     String sentMailMsg=msg.toString();
	     emailService.saveMail(sentMailMsg);
	     javaMailSender.send(msg);
	     log.info("Mail sent"+msg.toString());
	}
}
