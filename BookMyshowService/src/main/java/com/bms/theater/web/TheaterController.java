package com.bms.theater.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.bms.theater.data.TheaterDao;
import com.bms.theater.service.TheaterService;

@RestController
public class TheaterController {

	@Autowired
	TheaterService theaterService;
	
	 @GetMapping(value = "/theater/{theaterId}")
	  public TheaterDao findBooking(@PathVariable Integer theaterId) {		
		 return theaterService.findTheater(theaterId);
	}
}
