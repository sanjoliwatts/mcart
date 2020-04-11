package com.project.mcartorders.dto;

import java.util.Date;


import java.util.List;



public class CartDTO {
	private int cartId;
	
	private String username;

	private Date dateOfCreation;

	private Date dateOfModification;

	private String status;

	private List<CartDetailsDTO> productsInCart;
	
	public CartDTO() {}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public Date getDateOfModification() {
		return dateOfModification;
	}

	public void setDateOfModification(Date dateOfModification) {
		this.dateOfModification = dateOfModification;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<CartDetailsDTO> getProductsInCart() {
		return productsInCart;
	}

	public void setProductsInCart(List<CartDetailsDTO> productsInCart) {
		this.productsInCart = productsInCart;
	}
	
	
	@Override
	public String toString() {
		return "cartId: "+this.cartId+" --- username: "+this.username+" --- dateOfCreation: "+
	this.dateOfCreation+" --- dateOfModification"+this.dateOfModification+" --- status:"+ this.status  +
	"productsInCart "+this.productsInCart.toString();
	}
	
	
}
