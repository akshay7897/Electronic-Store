package com.ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ap.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {

}
