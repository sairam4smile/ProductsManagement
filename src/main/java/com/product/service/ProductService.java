package com.product.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.product.entity.Category;
import com.product.entity.CategoryAnalytics;
import com.product.entity.Products;
import com.product.entity.ProductsAnalytics;

public interface ProductService {
	
	
	public ResponseEntity<List<Category>> AllCategorys();
	public ResponseEntity<List<Products>> getAllProducts(Long categoryId);
	public ResponseEntity<Products> getProduct(Long productId);
	public ResponseEntity<List<CategoryAnalytics>> getCategorysAnalytics();
	public ResponseEntity<List<ProductsAnalytics>> getCategorysProductsAnalytics(Long categoryId);
	public ResponseEntity<ProductsAnalytics> getProductsAnalytics(Long productId);



}
