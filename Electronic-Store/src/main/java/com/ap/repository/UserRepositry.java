package com.ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ap.entity.User;

public interface UserRepositry extends JpaRepository<User, String>{
	

}
