package com.project.mcart.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mcart.bean.CartDTO;
import com.project.mcart.bean.UsersDTO;
import com.project.mcart.entity.Cart;
import com.project.mcart.entity.Products;
import com.project.mcart.entity.Users;
import com.project.mcart.repository.CartRepository;
import com.project.mcart.repository.ProductRepository;
import com.project.mcart.repository.UserRepository;

@Service("mcartService")
public class McartService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	final Logger logger = (Logger)LoggerFactory.getLogger(this.getClass());
	
	public Boolean validateLogin(Users user) {
		logger.info("Inside Service validateLogin "+user.toString());
		//userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		Users obj = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		return (obj!=null);
	}
	
	public String signup(UsersDTO userDTO) {
		Users user = UsersDTO.prepareEntity(userDTO);
		logger.info("Printing user DTO"+userDTO.toString());
		
		Optional<Users> userRet = userRepository.findByUsername(user.getUsername());

		if (userRet.isPresent()) {
			return "User already Registered";
		}
			userRepository.saveAndFlush(user);
			return "User Registered with Name: "+user.getUsername();
		
	}
	
	public List<Products> getProducts(String type){
		logger.info("getProducts "+type);
		if(type.equals("mobiles"))
			return productRepository.findByProductCodeStartingWith("MOB");
		else if(type.equals("tablets"))
			return productRepository.findByProductCodeStartingWith("TAB");
		
		return new ArrayList<Products>();
	}
	
	public String insertToCart(Cart cart) {
		//String response = "";
		logger.info("insert to cart: "+cart.toString());
		//Cart cartRet = cartRepository.findByUsername(cart.getUsername());
		
		
		Optional<Cart> optCartRet = cartRepository.findByUsername(cart.getUsername());

		if (optCartRet.isPresent()) {
			Cart cartRet = optCartRet.get();
			cartRet.setDateOfModification(new Date());
			//Set all values of cart to cartRet
			cartRepository.saveAndFlush(cartRet);
			return "User's cart is already available, append to the same cart";
		}
		else {
			cart.setDateOfCreation(new Date());
			cart.setStatus("Active");
			Cart cartRet = cartRepository.saveAndFlush(cart);
			return "New items got inserted into the cart with the ID: "+cartRet.getCartId();
		}
	}
	
	public String updateCart(Cart cart) {
		Optional<Cart> optCartRet = cartRepository.findByUsername(cart.getUsername());
		if (optCartRet.isPresent()) {
			Cart cartRet = cartRepository.saveAndFlush(cart);
			return "CartID: "+cartRet.getCartId()+" updated";
		}
		return "User's cart is not available";
	}
	
}
