package com.email.data;

import java.sql.Date;
import java.sql.Time;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@Document(collection = "EmailMsgStore")
public class EmailMsgDao {

	@Id
	public ObjectId _id;
	private String emailDetails;
	
	 // needed for JPA
	  @SuppressWarnings("unused")
	  private EmailMsgDao() { 
		  this(null, null); }
}
