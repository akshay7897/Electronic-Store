package com.ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ap.entity.CartItems;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Integer> {

}
