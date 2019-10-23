package com.bms.theater.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;
import java.lang.Integer;
import com.bms.theater.data.TheaterDao;


import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface TheaterRepositry extends JpaRepository<TheaterDao, Integer>{

	/*
	 * @Lock(LockModeType.PESSIMISTIC_WRITE)
	 * 
	 * @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value
	 * ="5000")}) TheaterDao findBySeatsAndMovieIdAndTheaterId(Integer
	 * seInteger,Integer mInteger,Integer tInteger);
	 */
	 
	 TheaterDao findByTheaterId(Integer theInteger);
}