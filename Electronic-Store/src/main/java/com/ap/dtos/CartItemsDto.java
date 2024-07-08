package com.ap.dtos;

public class CartItemsDto {

	private Integer cartItemId;
	private ProductRequest productRequest;
	private Integer quantity;
	private Integer totalPrize;

	public Integer getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(Integer cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getTotalPrize() {
		return totalPrize;
	}

	public void setTotalPrize(Integer totalPrize) {
		this.totalPrize = totalPrize;
	}

	public ProductRequest getProductRequest() {
		return productRequest;
	}

	public void setProductRequest(ProductRequest productRequest) {
		this.productRequest = productRequest;
	}


	@Override
	public String toString() {
		return "CartItemsDto [cartItemId=" + cartItemId + ", productRequest=" + productRequest + ", quantity="
				+ quantity + ", totalPrize=" + totalPrize +  "]";
	}

}
