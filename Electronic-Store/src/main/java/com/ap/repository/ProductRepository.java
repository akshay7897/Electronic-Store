package com.ap.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ap.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

	Page<Product> findByTitleContaining(String subTitle,Pageable pageable);
	
	Page<Product> findByLive(boolean live,Pageable pageable);

}
