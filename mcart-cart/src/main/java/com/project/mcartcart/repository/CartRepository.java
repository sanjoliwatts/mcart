package com.project.mcartcart.repository;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;

import com.project.mcartcart.entity.Cart;




public interface CartRepository extends JpaRepository<Cart,Integer>{
	Optional<Cart> findByUsername(String username);

}
