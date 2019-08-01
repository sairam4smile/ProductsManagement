
package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.entity.ProductsAnalytics;
import com.product.entity.Products;
import java.util.List;
import com.product.entity.Category;

@Repository
public interface ProductsAnalyticsRepository extends JpaRepository<ProductsAnalytics, Long> {
	
	List<ProductsAnalytics> findByCategory(Category category);
	
	
}
