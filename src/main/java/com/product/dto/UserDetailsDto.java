package com.product.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
@Setter @Getter
public class UserDetailsDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String userName;
	private String password;
	private String address;
	private Long mobileNo;

}
