package com.bms.ticket.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.bms.ticket.service.TicketServiceMsg;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BMSConsumer {
	
	@Autowired
	TicketServiceMsg ticketMsgService;
	
	@Autowired
	ToTicketMsgTransformer toTicketMsgTransformer;
	
	@RabbitListener(queues = "${bookmyshow.rabbitmq.queue}")
	public void recievedMessage( TicketMsg ticketMsg) {
		log.info("Recieved Message From RabbitMQ: " + ticketMsg);       
		ticketMsgService.saveTicketMsg(toTicketMsgTransformer.transfrom(ticketMsg));
		
	}
}
