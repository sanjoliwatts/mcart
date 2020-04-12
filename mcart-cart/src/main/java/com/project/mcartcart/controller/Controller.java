package com.project.mcartcart.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.mcartcart.dto.CartDTO;
import com.project.mcartcart.entity.Cart;
import com.project.mcartcart.service.CartService;


@RestController
@RequestMapping("/")
public class Controller {

	@Autowired
	private CartService cartService;
	
	final Logger logger = (Logger)LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/carts")
	public ResponseEntity<String> insertToCart(@RequestBody CartDTO cartDTO) {
		
		return new ResponseEntity<>(cartService.insertToCart(cartDTO),HttpStatus.OK);
	}
	
	@PutMapping("/carts")
	public ResponseEntity<String> updateCart(@RequestBody CartDTO cartDTO) {
		return new ResponseEntity<>(cartService.updateCart(cartDTO),HttpStatus.OK);
	}
	
	//@RequestMapping(value="/carts", method=RequestMethod.GET)
	@GetMapping(value="/carts")
	public List<CartDTO> getCart(){
		logger.info("getcart");
		return cartService.getCart();
	}
	
	/**
	 * Method used to get object from cart for a particular user
	 * @RequestMapping(value="/carts", method=RequestMethod.GET, params="username") can also be used
	 * @param username
	 * @return Cart
	 */
	@GetMapping(value="/carts",  params="username")
	public CartDTO getCartByUsername(@RequestParam String username) {
		return cartService.getCartByUsername(username);
	}
	
	@GetMapping(value="/carts/updateCartStatus")
	public CartDTO updateCart(@RequestParam("username") String username, @RequestParam("status") String status) {
		return cartService.updateCartStatus(username, status);
	}
	
}
