package com.project.mcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.mcart.entity.Cart;
import com.project.mcart.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer>{
	
}
