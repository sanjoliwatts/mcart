package com.project.mcart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.mcart.entity.Users;
import com.project.mcart.service.McartService;

@RestController
@RequestMapping("/")
public class Controller {
	
	@Autowired
	private McartService mcartService;

	@PostMapping("/login")
	public Boolean validateLogin(@Valid @RequestBody Users users) {
		//Users user = mcartService.validateLogin(users);
		return false;
	}
}
