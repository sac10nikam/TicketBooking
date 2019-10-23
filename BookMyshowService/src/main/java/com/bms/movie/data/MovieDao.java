package com.bms.movie.data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bms.theater.data.TheaterDao;
import com.bms.theater.data.TheaterDao.TheaterDaoBuilder;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "movie")
@Builder
@Getter
@AllArgsConstructor
@Setter
public class MovieDao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "movieId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Integer movieId;

    @Column(name = "movieName")
    private final String movieName;
    
    @Column(name = "movieType")
    private final String movieType;
     
     @JsonBackReference
	  @ManyToMany	
	  @JoinTable(name="movie_theaterdao",
	  joinColumns=@JoinColumn(name="movieDao_movieId"),
	  inverseJoinColumns=@JoinColumn(name="TheaterDao_theaterId") )	 
	  private List<TheaterDao> theaterDao;
	 
    
 // needed for JPA
 	@SuppressWarnings("unused")
 	private  MovieDao() {
 		this(null, null, null,null);
 	}
    
}
