package com.ap.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	private String productId;
	
	private String title;
	
	private String descreption;
	
	private Integer price;
	
	private Integer discountedPrice;
	
	private Integer quantity;
	
	private boolean live;
	
	private boolean stock;
	
	public Product() {
		// 
	}

	public Product(String productId, String title, String descreption, Integer price, Integer discountedPrice,
			Integer quantity, boolean live, boolean stock) {
		super();
		this.productId = productId;
		this.title = title;
		this.descreption = descreption;
		this.price = price;
		this.discountedPrice = discountedPrice;
		this.quantity = quantity;
		this.live = live;
		this.stock = stock;
	}

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
		return "Product [productId=" + productId + ", title=" + title + ", descreption=" + descreption + ", price="
				+ price + ", discountedPrice=" + discountedPrice + ", quantity=" + quantity + ", live=" + live
				+ ", stock=" + stock + "]";
	}
	
	
	
	

}
