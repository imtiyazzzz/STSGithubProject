package com.prolog.JPA.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.prolog.JPA.entities.User;

@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);
	@Autowired
	private UserDAOService userDAOService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	long id	= userDAOService.insert(new  User("Imtiyaz","Admin"));
		log.info("New User Created with id {}",id);
		
		long updatedId1 = userDAOService.update(new User(100L,"iftkhar","Admin"));
		log.info("Updated User with id {} ",updatedId1);
		long updatedId2 = userDAOService.update(new User(1L,"Izhar","Admin"));
		log.info("Updated User with id {} ",updatedId2);
		
		User findByIdResult = userDAOService.findById(1L);
		log.info("Found user with id {} : {} ",1L,findByIdResult);
		
		List<User> allResult = userDAOService.findAll();
		log.info("\n All Users : {} ",allResult);
		
		userDAOService.deleteById(1L);
		log.info("User with id {} is deleted successfully",1L);
		//remaining record
		List<User> allResult2 = userDAOService.findAll();
		log.info("\n All Users : {} ",allResult2);
		
		userDAOService.entityManagerPersist();
		
		List<User> allResult3 = userDAOService.findAll();
		log.info("\n All Users : {} ",allResult3);
	}

}
