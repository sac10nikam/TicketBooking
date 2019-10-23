package com.email.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailMsgRepositry extends MongoRepository<EmailMsgDao, String>{

}
