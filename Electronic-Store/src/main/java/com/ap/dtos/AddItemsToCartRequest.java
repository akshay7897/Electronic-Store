package com.ap.dtos;

public class AddItemsToCartRequest {
	
	private String productId;
	private Integer quantity;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "AddItemsToCartRequest [productId=" + productId + ", quantity=" + quantity + "]";
	}
	
	

}
