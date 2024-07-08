package com.ap.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ap.dtos.AddItemsToCartRequest;
import com.ap.dtos.CartDto;
import com.ap.entity.Cart;
import com.ap.entity.CartItems;
import com.ap.entity.Product;
import com.ap.entity.User;
import com.ap.exception.CartNotFoundException;
import com.ap.exception.ProductNotFountException;
import com.ap.exception.UserNotFoudException;
import com.ap.repository.CartItemsRepository;
import com.ap.repository.CartRepository;
import com.ap.repository.ProductRepository;
import com.ap.repository.UserRepositry;
import com.ap.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	
	private UserRepositry userRepositry;
	private CartRepository cartRepository;
	private ProductRepository productRepository;
	private CartItemsRepository cartItemsRepository;
	
	public CartServiceImpl(UserRepositry userRepositry, CartRepository cartRepository,
			ProductRepository productRepository,CartItemsRepository cartItemsRepository) {
		super();
		this.userRepositry = userRepositry;
		this.cartRepository = cartRepository;
		this.productRepository = productRepository;
		this.cartItemsRepository=cartItemsRepository;
	}

	@Override
	public CartDto addItemToCart(String userId, AddItemsToCartRequest request) {
		
		Integer quantity = request.getQuantity();
		Integer productId = request.getProductId();
		
		if(quantity<=0) {
			throw new RuntimeException("Requested Quantity Is Not Valid..!!");
		}
		
		Product product = productRepository.findById(String.valueOf(productId)).orElseThrow(()-> new ProductNotFountException("product not found with given id"));
		User user = userRepositry.findById(userId).orElseThrow(()->new UserNotFoudException("User not found with given id"));
		
		Cart cart=null;
		try {
			cart = cartRepository.findByUser(user).get();
			
		}catch (NoSuchElementException e) {
			
			cart=new Cart();
			cart.setCartId(UUID.randomUUID().toString());
			cart.setCreatedDate(new Date());
			cart.setUser(user);

		}
		
	    AtomicBoolean isUpdated = new AtomicBoolean(false);
		List<CartItems> items = cart.getCartItems();
		
		List<CartItems> updatedItems = items.stream().map(item -> {

			if (item.getProduct().getProductId().equalsIgnoreCase(String.valueOf(productId))) {
				item.setQuantity(quantity);
				item.setTotalPrize(quantity * product.getPrice());
				isUpdated.set(true);
			}
			return item;

		}).toList();
		
		cart.setCartItems(updatedItems);
		
		if(!isUpdated.get()) {
		CartItems cartItems=new CartItems();
		cartItems.setQuantity(quantity);
		cartItems.setTotalPrize(quantity*product.getPrice());
		cartItems.setProduct(product);
		cartItems.setCart(cart);
		items.add(cartItems);
		}
		
		Cart savedCart = cartRepository.save(cart);
		return cartToDto(savedCart);
	}

	@Override
	public void removeItemFromCart(String userId, Integer cartItemId) {
		CartItems cartItems = cartItemsRepository.findById(cartItemId).orElseThrow(()->new RuntimeException("Cart item not found"));
		cartItemsRepository.delete(cartItems);
	}

	@Override
	public void clearCart(String userId) {
		
		User user = userRepositry.findById(userId)
				.orElseThrow(() -> new UserNotFoudException("User not found with given id"));
		Cart cart = cartRepository.findByUser(user)
				.orElseThrow(() -> new CartNotFoundException("Cart not found for this user"));
		cart.getCartItems().clear();

		cartRepository.save(cart);
	}
	
	@Override
	public CartDto getCartByUser(String userId) {
		
		User user = userRepositry.findById(userId).orElseThrow(()->new UserNotFoudException("User not found with given id"));
		Cart cart=cartRepository.findByUser(user).orElseThrow(()->new CartNotFoundException("Cart not found for this user"));
		return cartToDto(cart);
	}

	private CartDto cartToDto(Cart cart) {
		CartDto cartDto=new CartDto();
		BeanUtils.copyProperties(cart, cartDto);
		return cartDto;
	}

	
}
