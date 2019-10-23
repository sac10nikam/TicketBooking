package com.bms.movie.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.lang.Integer;
import java.util.List;

@Repository
public interface MovieRepositry extends JpaRepository<MovieDao, Integer>{

	MovieDao findByMovieId(Integer movieId);
}