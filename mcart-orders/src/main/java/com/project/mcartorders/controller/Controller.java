package com.project.mcartorders.controller;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.mcartorders.service.OrderService;


@RestController
@RequestMapping("/")
public class Controller {

	@Autowired
	private OrderService orderService;
	final Logger logger = (Logger)LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/orders")
	public ResponseEntity<String> createNewOrder(@RequestBody Map<String, String> map){
		logger.info("map "+map);

		return new ResponseEntity<>(orderService.createNewOrder(map.get("username"), Integer.parseInt(map.get("orderAmount"))),HttpStatus.OK);
	}
	
}
