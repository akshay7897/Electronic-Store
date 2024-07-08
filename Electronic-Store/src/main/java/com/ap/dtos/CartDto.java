package com.ap.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ap.entity.User;

public class CartDto {
	
	private String cartId;
	private Date createdDate;
	private User user;
	private List<CartItemsDto> cartItems=new ArrayList<>();

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CartItemsDto> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemsDto> cartItems) {
		this.cartItems = cartItems;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "CartDto [cartId=" + cartId + ", createdDate=" + createdDate + ", user=" + user + ", cartItems="
				+ cartItems + "]";
	}
	

}
