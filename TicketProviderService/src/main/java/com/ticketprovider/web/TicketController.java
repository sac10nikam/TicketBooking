package com.ticketprovider.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticketprovider.service.Ticket;
import com.ticketprovider.service.TicketService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class TicketController {

	private final TicketService ticketService;
	private final ToTicketViewTransformer toTicketViewTransformer;
	
	@Autowired
	 public TicketController(TicketService ticketService,ToTicketViewTransformer toTicketViewTransformer)
	 {
		 this.ticketService=ticketService;
		 this.toTicketViewTransformer=toTicketViewTransformer;
	 }
	 
	  @GetMapping(value = "/tickets")
	  public List<TicketView> findAllTickets() {
		  
		  log.info("===>Controleer ");
		 return ticketService.findAllTickets()
				 .stream()
				 .map(toTicketViewTransformer::transform)
				 .collect(Collectors.toList());
	  }
	  
	  @PostMapping(value = "/tickets")
	  public Integer createTicket(@RequestBody TicketView ticketView) {
		  log.info("createTicket   Tickets");
		  Integer ticketId = ticketService.createTicket(toTicketViewTransformer.transformToTicket(ticketView));
		  return ticketId;
	  }
	  
	  @DeleteMapping(value = "/tickets/{ticketId}")
	  public void deleteTicket(@PathVariable Integer ticketId) {
		  ticketService.deletTicket(ticketId);
	  }
	  
	  @PutMapping(value = "/tickets/{ticketId}")
	  public ResponseEntity<Object> updateTicket(@RequestBody TicketView ticketView,@PathVariable Integer ticketId) {
		  ticketService.updateTicket(toTicketViewTransformer.transformToTicket(ticketView),ticketId);
		   return ResponseEntity.status(HttpStatus.OK)
			        .body("ticketId updated" +ticketId);
	  }
}
