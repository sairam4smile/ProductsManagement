package com.product.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class CategoryAnalyticsDto {

	private Long CategoryAnalyticsId;
	private Long viewCount;
	private Long category_id;
	private Long user_id;

	

}
