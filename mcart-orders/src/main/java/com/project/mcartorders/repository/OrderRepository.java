package com.project.mcartorders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.project.mcartorders.entity.Orders;


@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer>{
	
}
