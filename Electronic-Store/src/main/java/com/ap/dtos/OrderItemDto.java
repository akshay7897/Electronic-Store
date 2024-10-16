package com.ap.dtos;

public class OrderItemDto {
	
	private int orderItemId;
	
	private int quantity;
	
	private int totalPrice;
	
	private ProductResponse productResponse;

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ProductResponse getProductResponse() {
		return productResponse;
	}

	public void setProductResponse(ProductResponse productResponse) {
		this.productResponse = productResponse;
	}

	@Override
	public String toString() {
		return "OrderItemDto [orderItemId=" + orderItemId + ", quantity=" + quantity + ", totalPrice=" + totalPrice
				+ ", productResponse=" + productResponse + "]";
	}
	
	
	

}
