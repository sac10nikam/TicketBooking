package com.bms.theater.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.theater.data.TheaterDao;
import com.bms.theater.data.TheaterRepositry;

@Service
@Transactional
public class TheaterService {

	TheaterRepositry theaterRepositry;
	

	@Autowired
	public TheaterService(TheaterRepositry theaterRepositry)
	{
		this.theaterRepositry=theaterRepositry;
	}
	
	public void locakSeats(Integer theaterId, Integer movieId, Integer bookedSeats) {
		
		//theaterRepositry.findBySeatsAndMovieIdAndTheaterId(bookedSeats, movieId, theaterId);
		
	}

	
	public TheaterDao findTheater(Integer theaterId)
	{
		return theaterRepositry.findByTheaterId(theaterId);
	}
	
}
