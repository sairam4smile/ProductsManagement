package com.product.entity;

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

@Entity @Table(name = "products_analytics") @Setter @Getter @ToString
public class ProductsAnalytics {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productAnalyticsId;
	private Long viewCount;

	@ManyToOne
	@JoinColumn(name = "products_id")
	private Products products;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserDetails userDetails;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

}
