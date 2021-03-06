package com.project.mcart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;


@Entity
//@TableGenerator(name="cartDetailsGen", initialValue=101) //, allocationSize=50
public class CartDetails {

//	@Id
//	@GeneratedValue(strategy=GenerationType.TABLE, generator="cartDetailsGen")
	@Column(name = "cart_id")
	private int cartId;
	
	@Id
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "quantity")
	private int quantity;
	
	public CartDetails() {}

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

