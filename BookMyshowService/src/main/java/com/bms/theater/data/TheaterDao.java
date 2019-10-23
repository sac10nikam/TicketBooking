package com.bms.theater.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bms.movie.data.MovieDao;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "theater")
@Builder
@Getter
@AllArgsConstructor
@Setter
public class TheaterDao implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "theaterId")
	private final Integer theaterId;
	
	@Column(name = "screen")
	private final Integer screen;
	
	@Column(name = "movieId") 
	private final Integer movieId;  
	

	@Column(name = "adressId")
	private final Integer adressid;

	@Column(name = "theaterName")
	private final String theaterName;


	@Column(name = "seats")
	private final Integer seats;
	
	@JsonManagedReference
    @ManyToMany(mappedBy="theaterDao")
	private List<MovieDao> movieDao;


	
	// needed for JPA
	@SuppressWarnings("unused")
	private TheaterDao() {
		this(null, null, null, null, null, null, null);
	}
}
