package com.product.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

 @Setter @Getter @ToString
public class Products implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long productId;
	private String productName;
	private Long category_id;
	
	

}
