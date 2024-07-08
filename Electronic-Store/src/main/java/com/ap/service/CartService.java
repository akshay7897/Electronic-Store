package com.ap.service;

import com.ap.dtos.AddItemsToCartRequest;
import com.ap.dtos.CartDto;

public interface CartService {
	
	CartDto addItemToCart(String userId,AddItemsToCartRequest request);
	
	void removeItemFromCart(String userId,Integer cartItem);
	
	void clearCart(String userId);
	
	CartDto getCartByUser(String userId);

}
