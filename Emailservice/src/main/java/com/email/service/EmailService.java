package com.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.data.EmailMsgDao;
import com.email.data.EmailMsgRepositry;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailService {

	@Autowired
	 private  EmailMsgRepositry emailMsgRepositry;

	public void saveMail(String sentMailMsg) {
		EmailMsgDao saved = emailMsgRepositry.save( EmailMsgDao.builder().emailDetails(sentMailMsg).build());
		log.info("savemail"+saved.get_id());
	}
}
