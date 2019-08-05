package com.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.entity.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

	public Optional<UserDetails> findByUserNameAndPassword(String userName,String password) ;
	
	public Optional<UserDetails> findByUserName(String userName) ;

}
