package com.product.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter @Getter
public class UserDetailsDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String userName;
	private String password;
	private String address;
	private Long mobileNo;

}
