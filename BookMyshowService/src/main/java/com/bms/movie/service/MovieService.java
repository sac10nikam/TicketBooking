package com.bms.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.movie.data.MovieDao;
import com.bms.movie.data.MovieRepositry;
import com.bms.theater.data.TheaterDao;

@Service
public class MovieService {

     @Autowired
     MovieRepositry movieRepositry;
	
 	public MovieDao findMovie(Integer movieId)
 	{
 		return movieRepositry.findByMovieId(movieId);
 	}
}
