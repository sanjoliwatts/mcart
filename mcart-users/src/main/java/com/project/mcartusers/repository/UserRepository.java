package com.project.mcartusers.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.mcartusers.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,String>{
	Users findByUsernameAndPassword(String username, String password);
	Optional<Users> findByUsername(String username); 
}