package com.bms.user.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "user")
@Builder
@Getter
@AllArgsConstructor
public class UserDao {
		
	    @Id
	    @Column(name = "userId")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private final Integer userId;
	    	    
	    @Column(name = "name")
	    private final String name;
	    
	    @Column(name = "mobNo")
	    private final Integer mobNo;
	    
	    @Column(name = "emailId")
	    private final String emailId;
	    
	    @Column(name = "sex")
	    private final String sex;
	    
	    
	    // needed for JPA
		  @SuppressWarnings("unused")
		  private UserDao() { 
			  this(null, null,null,null,null); 
			  }  
}
