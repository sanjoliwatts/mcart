package com.project.mcartorderdetails.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.mcartorderdetails.dto.OrderDetailsDTO;
import com.project.mcartorderdetails.service.OrderDetailsService;



@RestController
@RequestMapping("/")
public class Controller {

	@Autowired
	private OrderDetailsService orderDetailsService;
	final Logger logger = (Logger)LoggerFactory.getLogger(this.getClass());

	
	@PostMapping("/orderDetails/saveOrderDetails")
	public String insertToCart(@RequestBody OrderDetailsDTO orderDetailsDTO) {
		return orderDetailsService.insertToOrderDetails(orderDetailsDTO);
	}
	
}
