package com.project.mcart.bean;

import java.util.Date;
import java.util.List;

import com.project.mcart.entity.Cart;
import com.project.mcart.entity.CartDetails;

public class CartDTO {
	private int cartId;
	
	private String username;

	private Date dateOfCreation;

	private Date dateOfModification;

	private String status;

	private List<CartDetails> productsInCart;
	
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

	public List<CartDetails> getProductsInCart() {
		return productsInCart;
	}

	public void setProductsInCart(List<CartDetails> productsInCart) {
		this.productsInCart = productsInCart;
	}
	
	public static Cart toEntity(CartDTO cartDTO) {
		Cart cart = new Cart();
		cart.setDateOfCreation(new Date());
		cart.setProductsInCart(cartDTO.getProductsInCart());
		cart.setStatus(cartDTO.getStatus());
		cart.setUsername(cartDTO.getUsername());
		
		return cart;
	}
	
	@Override
	public String toString() {
		return "cartId: "+this.cartId+" --- username: "+this.username+" --- dateOfCreation: "+
	this.dateOfCreation+" --- dateOfModification"+this.dateOfModification+" --- status:"+ this.status  +
	"productsInCart "+this.productsInCart.toString();
	}
	
	
}
