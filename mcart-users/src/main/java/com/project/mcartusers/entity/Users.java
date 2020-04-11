package com.project.mcartusers.entity;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
	
//	@OneToOne()
//	@JoinColumn(name = "username", referencedColumnName="username")
//	private Cart cart;

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
	
	@Override 
	public String toString(){
		return "username "+this.username+" password "+this.password+" phoneNumber "+ this.phoneNumber+" email "+this.email;
	}
	
	
}
