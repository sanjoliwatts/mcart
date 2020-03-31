package com.project.mcart.controller;

import java.util.List;
import java.util.stream.Collectors;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.mcart.bean.CartDTO;
import com.project.mcart.bean.ErrorMessage;
import com.project.mcart.bean.UsersDTO;
import com.project.mcart.entity.Cart;
import com.project.mcart.entity.Products;
import com.project.mcart.entity.Users;
import com.project.mcart.service.McartService;

@RestController
@RequestMapping("/")
public class Controller {
	
	@Autowired
	private McartService mcartService;
	final Logger logger = (Logger)LoggerFactory.getLogger(this.getClass());

	@PostMapping("/login")
	public Boolean validateLogin(@RequestBody Users users) {
		logger.info("Inside Controller validate login");
		return mcartService.validateLogin(users);
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
			response = mcartService.signup(userDTO);
			return ResponseEntity.ok(response);
		}
	}
	
	@GetMapping("/{type}")
	public List<Products> getProducts(@PathVariable("type") String type) {
		return mcartService.getProducts(type);
	}
	

	
	@PostMapping("/carts")
	public ResponseEntity<String> insertToCart(@RequestBody Cart cart) {
		return new ResponseEntity<>(mcartService.insertToCart(cart),HttpStatus.OK);
	}
	
	@PutMapping("/carts")
	public ResponseEntity<String> updateCart(@RequestBody Cart cart) {
		return new ResponseEntity<>(mcartService.updateCart(cart),HttpStatus.OK);
	}
	
	//@RequestMapping(value="/carts", method=RequestMethod.GET)
	@GetMapping(value="/carts")
	public List<Cart> getCart(){
		logger.info("getcart");
		return mcartService.getCart();
	}
	
	/**
	 * Method used to get object from cart for a particular user
	 * @RequestMapping(value="/carts", method=RequestMethod.GET, params="username") can also be used
	 * @param username
	 * @return Cart
	 */
	@GetMapping(value="/carts",  params="username")
	public Cart getCartByUsername(@RequestParam String username) {
		return mcartService.getCartByUsername(username);
	}
	
	@DeleteMapping("/products/{productName}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productName") String productName) {
		return new ResponseEntity<>(mcartService.deleteProduct(productName), HttpStatus.OK);
	}
	
	
	
}
