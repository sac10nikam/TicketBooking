package com.bms.movie.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bms.movie.data.MovieDao;
import com.bms.movie.service.MovieService;
import com.bms.theater.data.TheaterDao;
import com.bms.theater.service.TheaterService;

@RestController
public class MovieController {

	
	@Autowired
	MovieService movieService;
	
	 @GetMapping(value = "/movie/{movieId}")
	  public MovieDao findBooking(@PathVariable Integer movieId) {		
		 return movieService.findMovie(movieId);
	}
}
