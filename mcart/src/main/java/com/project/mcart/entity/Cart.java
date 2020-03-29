package com.project.mcart.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name="Cart", initialValue=101) //, allocationSize=50
public class Cart extends AuditModel{

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="Cart")
	@Column(name = "cart_id")
	private int cartId;
	
	@Column(name = "username", nullable = false)
	private String username;

	@Column(name="date_of_creation")
	private Date dateOfCreation;

	@Column(name="date_of_modification")
	private Date dateOfModification;

	@Column(name = "status")
	private String status;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="cart_id", referencedColumnName =  "cart_id")
	private List<CartDetails> productsInCart;
	
	public Cart() {}

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
	
	
}

