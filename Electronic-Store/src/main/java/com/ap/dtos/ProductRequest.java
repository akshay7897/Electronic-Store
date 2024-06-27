package com.ap.dtos;

import jakarta.validation.constraints.NotBlank;

public class ProductRequest {
	
private String productId;
	
	@NotBlank(message = "Title cant be null")
	private String title;
	@NotBlank(message = "Descreption cant be null")
	private String descreption;
	@NotBlank(message = "Price cant be null")
	private Integer price;
	private Integer discountedPrice;
	@NotBlank(message = "Title cant be null")
	private Integer quantity;
	private boolean live;
	private boolean stock;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescreption() {
		return descreption;
	}
	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getDiscountedPrice() {
		return discountedPrice;
	}
	public void setDiscountedPrice(Integer discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public boolean isStock() {
		return stock;
	}
	public void setStock(boolean stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "ProductRequest [productId=" + productId + ", title=" + title + ", descreption=" + descreption
				+ ", price=" + price + ", discountedPrice=" + discountedPrice + ", quantity=" + quantity + ", live="
				+ live + ", stock=" + stock + "]";
	}
	
	
	

}
