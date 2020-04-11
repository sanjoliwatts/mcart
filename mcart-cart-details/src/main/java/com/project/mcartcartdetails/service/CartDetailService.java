package com.project.mcartcartdetails.service;

import java.util.ArrayList;

import java.util.List;


import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mcartcartdetails.dto.CartDTO;
import com.project.mcartcartdetails.dto.CartDetailsDTO;
import com.project.mcartcartdetails.entity.CartDetails;
import com.project.mcartcartdetails.repository.CartDetailsRepository;



@Service("cartDetailService")
@Transactional
public class CartDetailService {
	@Autowired
	private CartDetailsRepository cartDetailsRepository;
	
	final Logger logger = (Logger)LoggerFactory.getLogger(this.getClass());

	public String insertList(CartDTO cartDTO) {
		logger.info("insertList: "+cartDTO.toString());
		
		for(CartDetailsDTO cartDetails: cartDTO.getProductsInCart()) {
			cartDetails.setCartId(cartDTO.getCartId());
			cartDetailsRepository.saveAndFlush(CartDetailsDTO.toEntity(cartDetails));
		}
		return "Cart Details table successfully updated";
		
	}
	
	public List<CartDetailsDTO> getCartDetails(int id){
		List<CartDetailsDTO> retList = new ArrayList<CartDetailsDTO>();
		for(CartDetails list: cartDetailsRepository.findByCartId(id)) {
			retList.add(CartDetailsDTO.toDTO(list));
		}
		
		return retList;
	}
	
	public String updateCartDetails(int id, List<CartDetailsDTO> cartDetailsList) {
		try {
			List<CartDetails> list = cartDetailsRepository.findByCartId(id);
			cartDetailsRepository.deleteAll(list);
			
			for(CartDetailsDTO c: cartDetailsList) {
				c.setCartId(id);
				cartDetailsRepository.saveAndFlush(CartDetailsDTO.toEntity(c));
			}
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
		return "success";
	}
}
