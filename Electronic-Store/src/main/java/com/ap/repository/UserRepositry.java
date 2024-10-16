package com.ap.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ap.entity.User;

public interface UserRepositry extends JpaRepository<User, String>{
	
	
	Optional<User> findByEmail(String Email);
	
	List<User> findByNameContaining(String keyword);
	

}
