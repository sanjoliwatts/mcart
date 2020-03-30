package com.project.mcart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.mcart.entity.Products;
import com.project.mcart.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,String>{
	Users findByUsernameAndPassword(String username, String password);
	Optional<Users> findByUsername(String username); 
}
