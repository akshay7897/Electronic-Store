package com.ap.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ap.entity.Cart;
import com.ap.entity.User;

public interface CartRepository extends JpaRepository<Cart, String> {
	
	Optional<Cart> findByUser(User user);

}
