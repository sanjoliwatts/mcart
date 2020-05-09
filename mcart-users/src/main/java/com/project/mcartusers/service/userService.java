package com.project.mcartusers.service;

import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mcartusers.dto.UsersDTO;
import com.project.mcartusers.entity.Users;
import com.project.mcartusers.repository.UserRepository;


@Service("userService")
public class userService {
	@Autowired
	private UserRepository userRepository;
	
final Logger logger = (Logger)LoggerFactory.getLogger(this.getClass());
	
	public Boolean validateLogin(Users user) {
		logger.info("Inside Service validateLogin "+user.toString());
		//userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		Users obj = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		logger.info("Result "+(obj!=null));
		return (obj!=null);
	}
	
	public String signup(UsersDTO userDTO) {
		Users user = UsersDTO.prepareEntity(userDTO);
		logger.info("Printing user DTO"+userDTO.toString());
		
		Optional<Users> userRet = userRepository.findByUsername(user.getUsername());

		if (userRet.isPresent()) {
			return "User already Registered";
		}
			userRepository.saveAndFlush(user);
			return "User Registered with Name: "+user.getUsername();
		
	}
}
