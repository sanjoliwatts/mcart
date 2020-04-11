package com.project.mcartorders.dto;

import java.util.Date;
import java.util.List;

public class OrdersDTO {
	
	private int orderId;
	private int cartId;
	private Date dateOfOrder;
	private int orderAmount;
	private List<OrderDetailsDTO> productsInOrder;
	
	public OrdersDTO() {}

	
	public List<OrderDetailsDTO> getProductsInOrder() {
		return productsInOrder;
	}


	public void setProductsInOrder(List<OrderDetailsDTO> productsInOrder) {
		this.productsInOrder = productsInOrder;
	}


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
