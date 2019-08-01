package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Category;
import com.product.entity.CategoryAnalytics;
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
	
	@GetMapping("/{categoryId}/products")
	public ResponseEntity<List<Products>> getAllProducts(@PathVariable() Long categoryId){
		return productService.getAllProducts(categoryId);
		}
	
	@GetMapping("/{categoryId}/products/{productId}")
	public ResponseEntity<Products> getProduct(Long productId){
		return productService.getProduct(productId);
		}
	
	
	@GetMapping("/analytics")
	public ResponseEntity<List<CategoryAnalytics>> getCategorysAnalytics(){
		return productService.getCategorysAnalytics();
		}
	
	@GetMapping("/analytics/{categoryId}/products")
	public ResponseEntity<List<ProductsAnalytics>> getCategorysProductsAnalytics(Long categoryId){
		return productService.getCategorysProductsAnalytics(categoryId);
		}
	
	
	@GetMapping("/analytics/{categoryId}/products/{productId}")
	public ResponseEntity<ProductsAnalytics> getProductsAnalytics(Long productId){
		return productService.getProductsAnalytics(productId);
		
	}


}
