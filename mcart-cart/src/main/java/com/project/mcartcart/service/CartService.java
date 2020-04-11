package com.project.mcartcart.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.mcartcart.dto.CartDTO;
import com.project.mcartcart.dto.CartDetailsDTO;
import com.project.mcartcart.entity.Cart;
import com.project.mcartcart.repository.CartRepository;


@Service("cartService")
@Transactional
public class CartService {
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	final Logger logger = (Logger)LoggerFactory.getLogger(this.getClass());

	public String insertToCart(CartDTO cartDTO) {
		
		
		//Cart cartRet = cartRepository.findByUsername(cart.getUsername());
		logger.info("insert to cart: "+cartDTO.toString());
		
		Optional<Cart> optCartRet = cartRepository.findByUsername(cartDTO.getUsername());

		if (optCartRet.isPresent()) {
			Cart cartRet = optCartRet.get();
			cartRet.setDateOfModification(new Date());
			//Set all values of cart to cartRet
			cartRepository.saveAndFlush(cartRet);
			
			return "User's cart is already available, append to the same cart";
		}
		else {
			cartDTO.setDateOfCreation(new Date());
			cartDTO.setStatus("Active");
			Cart cartRet = cartRepository.saveAndFlush(CartDTO.toEntity(cartDTO));
			cartDTO.setCartId(cartRet.getCartId());
			ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8084/cartDetails/", 
					cartDTO, String.class);
			return "New items got inserted into the cart with the ID: "+cartRet.getCartId();
		}
	}
	
	public CartDTO updateCartStatus(String username, String status) {
		Optional<Cart> cartRet = cartRepository.findByUsername(username);
		CartDTO cartDTO = null;
		try {
			if (cartRet.isPresent()) {
				cartRet.get().setStatus(status);
				Cart cart = cartRepository.saveAndFlush(cartRet.get());
				
				List<CartDetailsDTO> CartDetailsList = getCartDetails(cart);
				cartDTO = CartDTO.toDTO(cart);
				cartDTO.setProductsInCart(CartDetailsList);
			}
			else {
				throw new Exception("No Cart Found for the given username");
			}
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
		return cartDTO;
	}
	
	
	public String updateCart(CartDTO cartDTO) {
		//Cart cart = cartDTO.toEntity(cartDTO);
		Optional<Cart> optCartRet = cartRepository.findByUsername(cartDTO.getUsername());
		if (optCartRet.isPresent()) {
			//cartRepository.delete(optCartRet.get());
			cartDTO.setStatus("Active");
			cartDTO.setCartId(optCartRet.get().getCartId());
			
			Cart cartRet = cartRepository.saveAndFlush(CartDTO.toEntity(cartDTO));
			String response = PutCartDetails(cartRet.getCartId(), cartDTO);
			logger.info("res "+response);
			if(!response.equals("success")) {
				return "Some Error Occured";
			}
			return "CartID: "+cartRet.getCartId()+" updated";
		}
		return "User's cart is not available";
	}
	
	public String PutCartDetails(int id, CartDTO cartDTO) {
		HttpEntity<CartDTO> entity = new HttpEntity<CartDTO>(cartDTO);
		return restTemplate.exchange("http://localhost:8084/cartDetails/"
				+id,HttpMethod.PUT, entity, String.class).getBody();
	}
	
	
	public List<CartDTO> getCart(){
		logger.info("getCaart....");
		List<Cart> cartList = cartRepository.findAll();
		List<CartDTO> retList = new ArrayList<CartDTO>();
		
		for(Cart c:cartList) {
			List<CartDetailsDTO> productList = getCartDetails(c);
			
			CartDTO cart = CartDTO.toDTO(c);
			cart.setProductsInCart(productList);
			retList.add(cart);
		}
		return retList;
	}
	
	public List<CartDetailsDTO>  getCartDetails(Cart c){
		ResponseEntity<List<CartDetailsDTO>> listResponse = restTemplate.exchange("http://localhost:8084/cartDetails/"
				+c.getCartId(),HttpMethod.GET, null,  new ParameterizedTypeReference<List<CartDetailsDTO>>() {});
		return listResponse.getBody();
	}
	
	public CartDTO getCartByUsername(String username){
		Optional<Cart> optCartRet = cartRepository.findByUsername(username);
		Cart cart = optCartRet.get();
		List<CartDetailsDTO> productList = getCartDetails(cart);
		
		CartDTO cartDTO = CartDTO.toDTO(cart);
		cartDTO.setProductsInCart(productList);
		return cartDTO;
	}
	
}
