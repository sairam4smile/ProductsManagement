package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.product.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
	
//	@Query("SELECT u FROM Products u WHERE u.category_id = :categoryId")
//	public List<Products> getPoductsByCategory(@Param("categoryId") Long categoryId);
	

}
