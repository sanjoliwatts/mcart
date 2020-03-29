package com.project.mcart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name="OrderDetails", initialValue=2001)
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="OrderDetails")
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_name")
	private int productName;
	
	@Column(name="quantity")
	private int quantity;
	
	public OrderDetails() {}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductName() {
		return productName;
	}

	public void setProductName(int productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
