package com.product.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProductsAnalyticsDto {

	private Long productAnalyticsId;
	private Long viewCount;
	private Long products_id;
	private Long user_id;

}
