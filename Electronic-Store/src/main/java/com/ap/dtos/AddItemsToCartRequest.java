package com.ap.dtos;

public class AddItemsToCartRequest {
	
	private Integer productId;
	private Integer quantity;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
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
