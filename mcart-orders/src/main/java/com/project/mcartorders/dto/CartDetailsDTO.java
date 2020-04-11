package com.project.mcartorders.dto;

import javax.persistence.Column;

public class CartDetailsDTO {
	
	private int cartId;
	
	private int productId;
	
	private String productName;
	
	private int quantity;
	
	public CartDetailsDTO() {}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "cartId: "+this.cartId+" --- productId: "+this.productId+" ---productName: "+this.productName+
				" ---quantity "+this.quantity;
	}
}
