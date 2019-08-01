package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.entity.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

	public UserDetails findByUserNameAndPassword(String userName,String password) ;
}
