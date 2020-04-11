package com.project.mcartusers.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.mcartusers.dto.ErrorMessage;
import com.project.mcartusers.dto.UsersDTO;
import com.project.mcartusers.entity.Users;
import com.project.mcartusers.service.userService;

@RestController
@RequestMapping("/")
public class Controller {
	
	@Autowired
	userService service;
	final Logger logger = (Logger)LoggerFactory.getLogger(this.getClass());

	@PostMapping("/login")
	public Boolean validateLogin(@RequestBody Users users) {
		logger.info("Inside Controller validate login");
		return service.validateLogin(users);
	}
	
	@PostMapping("/signup")
	public ResponseEntity signup(@Valid @RequestBody UsersDTO userDTO, Errors errors) {
		String response = "";
		logger.info("Inside Controller signup");
		if (errors.hasErrors()) {
			// collecting the validation errors of all fields together in a String delimited
			// by commas
			response = errors.getAllErrors().stream().map(ObjectError::getDefaultMessage)
					.collect(Collectors.joining(","));
			ErrorMessage error = new ErrorMessage();
			error.setErrorCode(HttpStatus.NOT_ACCEPTABLE.value());
			error.setMessage(response);
			return ResponseEntity.ok(error);
		} else {
			response = service.signup(userDTO);
			return ResponseEntity.ok(response);
		}
	}
}
