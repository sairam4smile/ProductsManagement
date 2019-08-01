package com.product.dto;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
