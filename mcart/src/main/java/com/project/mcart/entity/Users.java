package com.project.mcart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {

	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="phone_number")
	private long phoneNumber;
	
	@Column(name="email")
	private String email;
}
