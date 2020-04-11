package com.project.mcartcartdetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.mcartcartdetails.entity.CartDetails;



@Repository
public interface CartDetailsRepository extends JpaRepository<CartDetails,Integer>{
	List<CartDetails> findByCartId(int id);
	long deleteByCartId(int id);
}
