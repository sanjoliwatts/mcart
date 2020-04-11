package com.project.mcartorderdetails.dto;

import com.project.mcartorderdetails.entity.OrderDetails;

public class OrderDetailsDTO {
	
	private int orderId;
	private int productId;
	private String productName;
	private int quantity;
	
	public OrderDetailsDTO() {}

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
	
	public static OrderDetails toentity(OrderDetailsDTO orderDetailsDTO) {
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setOrderId(orderDetailsDTO.getOrderId());
		orderDetails.setProductName(orderDetailsDTO.getProductName());
		orderDetails.setQuantity(orderDetailsDTO.getQuantity());
		return orderDetails;
	}
}
