package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.CategoryAnalyticsAnalysisDto;
import com.product.dto.ProductAnalyticsAnalysisDto;
import com.product.entity.Category;
import com.product.entity.Products;
import com.product.entity.ProductsAnalytics;
import com.product.service.ProductService;

@RestController
@RequestMapping("/categorys")
public class ProductController {
	
	@Autowired ProductService productService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Category>> AllCategorys(){
		return productService.AllCategorys();
		
	}
	
	@GetMapping("/{categoryId}/user/{userId}/products")
	public ResponseEntity<List<Products>> getAllProducts(@PathVariable("categoryId") Long categoryId,@PathVariable("userId") Long userId){
		return productService.getAllProducts(categoryId,userId);
		}
	
	@GetMapping("/{categoryId}/user/{userId}/products/{productId}")
	public ResponseEntity<Products> getProduct(@PathVariable("categoryId") Long categoryId,@PathVariable("productId")Long productId, @PathVariable("userId") Long userId){
		return productService.getProduct(categoryId,userId,productId);
		}
	
	
	@GetMapping("/analytics")
	public ResponseEntity<List<CategoryAnalyticsAnalysisDto>> getCategorysAnalytics(){
		return productService.getCategorysAnalytics();
		}
	
	@GetMapping("/analytics/{categoryId}/products")
	public ResponseEntity<List<ProductAnalyticsAnalysisDto>> getCategorysProductsAnalytics(Long categoryId){
		return productService.getCategorysProductsAnalytics(categoryId);
		}
	
	
	@GetMapping("/analytics/products/{productId}")
	public ResponseEntity<List<ProductAnalyticsAnalysisDto>> getProductsAnalytics(Long productId){
		return productService.getProductsAnalytics(productId);
		
	}


}
