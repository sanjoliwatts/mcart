package com.project.mcartproducts.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.mcartproducts.entity.Products;



@Repository
public interface ProductRepository extends JpaRepository<Products,Integer>{
	List<Products> findByProductCodeStartingWith(String type);
	Optional<Products> findByProductName(String productName);
}
