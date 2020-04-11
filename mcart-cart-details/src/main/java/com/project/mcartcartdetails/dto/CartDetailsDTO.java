package com.project.mcartcartdetails.dto;



import com.project.mcartcartdetails.entity.CartDetails;

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
	
	public static CartDetails toEntity(CartDetailsDTO cartDetailsDTO) {
		CartDetails cart = new CartDetails();
		cart.setCartId(cartDetailsDTO.getCartId());
		cart.setProductId(cartDetailsDTO.getProductId());
		cart.setProductName(cartDetailsDTO.getProductName());
		cart.setQuantity(cartDetailsDTO.getQuantity());
		return cart;
	}
	
	public static CartDetailsDTO toDTO(CartDetails cartDetails) {
		CartDetailsDTO cartDetailsDTO = new CartDetailsDTO();
		cartDetailsDTO.setCartId(cartDetails.getCartId());
		cartDetailsDTO.setProductId(cartDetails.getProductId());
		cartDetailsDTO.setProductName(cartDetails.getProductName());
		cartDetailsDTO.setQuantity(cartDetails.getQuantity());
		return cartDetailsDTO;
	}
	
	@Override
	public String toString() {
		return "cartId: "+this.cartId+" --- productId: "+this.productId+" ---productName: "+this.productName+
				" ---quantity "+this.quantity;
	}
}
