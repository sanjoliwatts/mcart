package com.project.mcartorderdetails.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mcartorderdetails.dto.OrderDetailsDTO;
import com.project.mcartorderdetails.repository.OrderDetailsRepository;

@Service("orderDetailsService")
public class OrderDetailsService {
	final Logger logger = (Logger)LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	public String insertToOrderDetails(OrderDetailsDTO orderDetailsDTO) {
		try {
			orderDetailsRepository.saveAndFlush(OrderDetailsDTO.toentity(orderDetailsDTO));
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
		return "success";
	}
}
