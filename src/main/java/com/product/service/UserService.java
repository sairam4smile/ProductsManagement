package com.product.service;

import org.springframework.http.ResponseEntity;

import com.product.dto.UserDetailsDto;

public interface UserService {

	public ResponseEntity<String> registration(UserDetailsDto userDetailsDto);
	public ResponseEntity<String> login(String userName, String password);

	
	
}
