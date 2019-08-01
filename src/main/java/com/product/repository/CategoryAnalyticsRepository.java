package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.entity.CategoryAnalytics;


@Repository
public interface CategoryAnalyticsRepository extends JpaRepository<CategoryAnalytics, Long> {
	
	
}
