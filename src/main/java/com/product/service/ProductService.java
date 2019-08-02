package com.product.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.product.dto.CategoryAnalyticsAnalysisDto;
import com.product.dto.ProductAnalyticsAnalysisDto;
import com.product.entity.Category;
import com.product.entity.Products;
import com.product.entity.ProductsAnalytics;

public interface ProductService {
	
	
	public ResponseEntity<List<Category>> AllCategorys();
	public ResponseEntity<List<Products>> getAllProducts(Long categoryId,Long userId);
	public ResponseEntity<Products> getProduct(Long categoryId,Long userId,Long productId);
	public ResponseEntity<List<CategoryAnalyticsAnalysisDto>> getCategorysAnalytics();
	public ResponseEntity<List<ProductAnalyticsAnalysisDto>> getCategorysProductsAnalytics(Long categoryId);
	public ResponseEntity<List<ProductAnalyticsAnalysisDto>> getProductsAnalytics(Long productId);



}
