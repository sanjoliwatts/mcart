package com.project.mcartproducts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.mcartproducts.entity.Products;
import com.project.mcartproducts.repository.ProductRepository;


@Service("productService")
@Transactional
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	final Logger logger = (Logger)LoggerFactory.getLogger(this.getClass());
	
	public List<Products> getProducts(String type){
		logger.info("getProducts "+type);
		if(type.equals("mobiles"))
			return productRepository.findByProductCodeStartingWith("MOB");
		else if(type.equals("tablets"))
			return productRepository.findByProductCodeStartingWith("TAB");
		
		return new ArrayList<Products>();
	}

	public String deleteProduct(String productName) {
		Optional<Products> prodRet = productRepository.findByProductName(productName);
		if(prodRet.isPresent()) {
			productRepository.delete(prodRet.get());
			return "Product removed successfully";
		}
		return "Product Not Available";
	}
}
