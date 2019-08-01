package com.product.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.dto.UserDetailsDto;
import com.product.entity.UserDetails;
import com.product.repository.UserDetailsRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Override
	public ResponseEntity<String> registration(UserDetailsDto userDetailsDto) {

		UserDetails userDetails = new UserDetails();
		BeanUtils.copyProperties(userDetailsDto, userDetails);
		userDetailsRepository.save(userDetails);
		return ResponseEntity.ok().body("succsessfully registerd");

	}

	@Override
	public ResponseEntity<String> login(String userName, String password) {
		userDetailsRepository.findByUserNameAndPassword(userName, password);

		return ResponseEntity.ok().body("succsessfully logined");
	}

}