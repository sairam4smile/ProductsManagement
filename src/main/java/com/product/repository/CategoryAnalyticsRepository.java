package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.product.entity.CategoryAnalytics;


@Repository
public interface CategoryAnalyticsRepository extends JpaRepository<CategoryAnalytics, Long> {
	
	@Query("SELECT u FROM CategoryAnalytics u WHERE u.category.categoryId = :categoryId and  u.userDetails.userId = :userId")
	public Optional<CategoryAnalytics> countOfCategoryHits(@Param("categoryId")Long categoryId, @Param("userId") Long userId);
	
	
	@Query("SELECT u.category.categoryId, sum(u.viewCount)  FROM CategoryAnalytics u  group by u.category.categoryId")
	public List<?> anlyticsOfCategoryHits();
	
	
}
