package com.project.mcartorders.entity;

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
@TableGenerator(name="ordersGen", initialValue=2000, allocationSize=1) //, allocationSize=50
public class Orders{
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="ordersGen")
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="cart_id")
	private int cartId;
	
	@Column(name="date_of_order")
	private Date dateOfOrder;
	
	@Column(name="order_amount")
	private int orderAmount;
	
	public Orders() {}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Date getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	
	
}
