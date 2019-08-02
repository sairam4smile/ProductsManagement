package com.product.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "category_analytics")
@Setter
@Getter
@ToString
public class CategoryAnalytics {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long CategoryAnalyticsId;
	private Long viewCount;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserDetails userDetails;

}
