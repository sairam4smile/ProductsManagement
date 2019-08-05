
package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.product.entity.ProductsAnalytics;

@Repository
public interface ProductsAnalyticsRepository extends JpaRepository<ProductsAnalytics, Long> {
	
	
	@Query("SELECT u FROM ProductsAnalytics u WHERE u.products.productId = :productId and  u.userDetails.userId = :userId")
	public Optional<ProductsAnalytics> countOfProductsHits(@Param("productId")Long productId, @Param("userId")Long userId);
	
	
	@Query("SELECT u.products.productId, sum(u.viewCount)  from ProductsAnalytics u where u.category.categoryId=:categoryId group by u.products.productId ")
	public List<?> anlyticsOfProductsHits(@Param("categoryId") Long categoryId);
	
	@Query("SELECT u.products.productId, sum(u.viewCount)  from ProductsAnalytics u where u.products.productId=:productId")
	public List<?> anlyticsOneProductHits(@Param("productId") Long productId);
	
	
	
}
