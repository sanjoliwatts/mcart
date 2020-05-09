package com.project.mcartproducts.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.mcartproducts.entity.Products;
import com.project.mcartproducts.service.ProductService;

@RestController
@RequestMapping("/")
public class Controller {
	@Autowired
	private ProductService mcartService;
	final Logger logger = (Logger)LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/products/{type}")
	public List<Products> getProducts(@PathVariable("type") String type) {
		List<Products> list= mcartService.getProducts(type);
		logger.info("list "+list);
		return list;
	}
	
	@DeleteMapping("/products/{productName}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productName") String productName) {
		return new ResponseEntity<>(mcartService.deleteProduct(productName), HttpStatus.OK);
	}
}
