package com.product.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class CategoryDto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Long categoryId;
	private String categoryName;
	private Long products_id;
	


}
