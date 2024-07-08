package com.ap.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ap.dtos.AddItemsToCartRequest;
import com.ap.dtos.ApiResponseMessage;
import com.ap.dtos.CartDto;
import com.ap.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	private CartService cartService;

	public CartController(CartService cartService) {
		super();
		this.cartService = cartService;
	}
	
	@PostMapping("create/{userId}")
	public ResponseEntity<CartDto> addItemToCart(@RequestBody AddItemsToCartRequest request,@PathVariable String userId){
		
		CartDto addedCartItems = cartService.addItemToCart(userId, request);
		return new ResponseEntity<>(addedCartItems,HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{userId}/cart/{cartItemId}")
	public ResponseEntity<ApiResponseMessage> removeItemsFromCart(@PathVariable String userId,@PathVariable Integer cartItemId){
		cartService.removeItemFromCart(userId, cartItemId);
		return new ResponseEntity<>(new ApiResponseMessage("Cart Item Removed",true,HttpStatus.OK),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<ApiResponseMessage> clearCart(@PathVariable String userId){
		cartService.clearCart(userId);
		return new ResponseEntity<>(new ApiResponseMessage("Cart Item Removed for User",true,HttpStatus.OK),HttpStatus.OK);
	}
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<CartDto> getCartByUser(@PathVariable String userId){
		CartDto cartDto = cartService.getCartByUser(userId);
		return new ResponseEntity<>(cartDto,HttpStatus.OK);
	}
	

}
