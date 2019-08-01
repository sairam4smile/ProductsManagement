package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.UserDetailsDto;
import com.product.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired UserService  userService;
	
	@PostMapping("/registration")
	public ResponseEntity<String> registration(@RequestBody UserDetailsDto userDetailsDto){
	
		return userService.registration(userDetailsDto);
		
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestParam("username") String username, @RequestParam("password") String password){
	
		return userService.login(username, password);
		
	}

}
