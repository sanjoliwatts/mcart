package com.project.mcartusers.dto;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.project.mcartusers.entity.Users;



public class UsersDTO {
	private static final long MIN_RANGE = 1000000000;
	private static final long MAX_RANGE = 9999999999L;
	private String username;
	
	@NotNull
	@Size(min = 5, message = "Minimum 5 characters should be there in password")
	private String password;
	
	@Range(min=MIN_RANGE, max=MAX_RANGE, message="Phone number should be 10 digits")
	private long phoneNumber;
	
	private String email;
	
	public UsersDTO() {}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static Users prepareEntity(UsersDTO dto) {
		Users user = new Users();
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setPhoneNumber(dto.getPhoneNumber());
		user.setEmail(dto.getEmail());
		
		return user;
	}
	
	@Override 
	public String toString(){
		return "username "+this.username+" password "+this.password+" phoneNumber "+ this.phoneNumber+" email "+this.email;
	}
}
