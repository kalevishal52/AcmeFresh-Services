package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.User;

public interface UserReop extends JpaRepository<User, Integer> {

	public User findByMobileNumber(String mobileNumber) ;
	
}
