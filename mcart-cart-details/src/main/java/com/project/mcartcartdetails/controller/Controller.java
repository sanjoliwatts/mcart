package com.project.mcartcartdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.mcartcartdetails.dto.CartDTO;
import com.project.mcartcartdetails.dto.CartDetailsDTO;
import com.project.mcartcartdetails.service.CartDetailService;


@RestController
@RequestMapping("/")
public class Controller {
	
	@Autowired
	CartDetailService CartDetailService;
	
	@PostMapping("/cartDetails")
	public ResponseEntity<String> insertToCart(@RequestBody CartDTO cartDTO) {
		
		return new ResponseEntity<>(CartDetailService.insertList(cartDTO),HttpStatus.OK);
	}
	
	@GetMapping("/cartDetails/{id}")
	public ResponseEntity<List<CartDetailsDTO>> getCartDetails(@PathVariable("id") int id) {
		return new ResponseEntity<>(CartDetailService.getCartDetails(id), HttpStatus.OK);
	}
	
	@PutMapping("/cartDetails/{id}")
	public ResponseEntity<String> updateCart(@PathVariable("id") int id, @RequestBody CartDTO cartDTO) {
		return new ResponseEntity<>(CartDetailService.updateCartDetails(id, cartDTO.getProductsInCart()),HttpStatus.OK);
	}
}
