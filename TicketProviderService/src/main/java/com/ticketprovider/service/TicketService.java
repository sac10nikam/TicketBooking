package com.ticketprovider.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ticketprovider.data.TicketDao;
import com.ticketprovider.data.TicketRepository;
import com.ticketprovider.message.BookMyShowSender;
import com.ticketprovider.message.ToTicketMsgTransformer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class TicketService {

	 private final TicketRepository ticketRepository;	
	 private final ToTicketTransformer toTicketTransformer;
	 private final  BookMyShowSender bookMyShowSender;
	 private final ToTicketMsgTransformer toTicketMsgTransformer;
	 
	 @Autowired
	 public TicketService(TicketRepository ticketRepository,ToTicketTransformer toTicketTransformer,BookMyShowSender bookMyShowSender,ToTicketMsgTransformer toTicketMsgTransformer)
	 {
		 this.ticketRepository=ticketRepository;
		 this.toTicketTransformer=toTicketTransformer;
		 this.bookMyShowSender=bookMyShowSender;
		 this.toTicketMsgTransformer=toTicketMsgTransformer;
	 }
	 
	 
	 public List<Ticket> findAllTickets()
	 {
		 log.info("Retrieving all  Tickets");
		 List<TicketDao> ticketDao=ticketRepository.findAll();
		 return ticketDao.stream()
				          .map(toTicketTransformer::transform)
				          .collect(Collectors.toList()) ;
	 }
	 
	 public Integer createTicket(Ticket ticket)
	 {
		 log.info("createTicket all  Tickets");
		 TicketDao ticketDao = ticketRepository.save(toTicketTransformer.transformToTicketDao(ticket));
		
		 //If Ticket is going to save and Consumer IS BMS then send it only BMS QUEE.
		 if(ticketDao.getTicketConsumerType().equals("BMS")) {		
		   bookMyShowSender.send(toTicketMsgTransformer.transform(ticketDao));
		}
		 return ticketDao.getTicketId();
	 }
	 public void deletTicket(Integer ticketId) {
		   		  ticketRepository.deleteById(ticketId);;
	 }
	 
	 public TicketDao findTicketByid(Integer ticketId)
	 {
		 Optional<TicketDao> ticketDao = ticketRepository.findById(ticketId);
		 log.info("Retrieving all  Tickets"+ticketDao.get().getTicketId());
		 return ticketDao.get();
	 }


	public void updateTicket(Ticket ticket, Integer ticketId) {
		 log.info("Retrieving all  updateTicket");		 
		TicketDao ticketDao =findTicketByid(ticketId);		 
		 
		if (ticketDao==null) { 
			//return ResponseEntity.notFound().build(); 
			}
		 
		TicketDao ticketDaoUpdate = TicketDao.builder().ticketId(ticketId)
				                                       .movieId(ticket.getMovieId())
				                                       .theaterId(ticket.getTheaterId())
				                                        .price(ticket.getPrice())
				                                        .numberOfTickets(ticket.getNumberOfTickets())
				                                        .ticketConsumerType(ticket.getTicketConsumerType()).build();
		  ticketRepository.save(ticketDaoUpdate);
	}
}
