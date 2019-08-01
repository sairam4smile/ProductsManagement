package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.entity.Category;
import com.product.entity.CategoryAnalytics;
import com.product.entity.Products;
import com.product.entity.ProductsAnalytics;
import com.product.repository.CategoryAnalyticsRepository;
import com.product.repository.CategoryRepository;
import com.product.repository.ProductsAnalyticsRepository;
import com.product.repository.ProductsRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired ProductsRepository productsRepository;
	@Autowired CategoryRepository categoryRepository;
	@Autowired CategoryAnalyticsRepository categoryAnalyticsRepository;
	@Autowired ProductsAnalyticsRepository productsAnalyticsRepository;


	@Override
	public ResponseEntity<List<Category>> AllCategorys() {
		return new ResponseEntity<>( categoryRepository.findAll(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Products>> getAllProducts(Long categoryId) {
		return new ResponseEntity<>( categoryRepository.findById(categoryId).get().getProducts(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Products> getProduct(Long productId) {
		return new ResponseEntity<>( productsRepository.findById(productId).get(),HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<List<CategoryAnalytics>> getCategorysAnalytics() {
		return new ResponseEntity<>( categoryAnalyticsRepository.findAll(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<ProductsAnalytics>> getCategorysProductsAnalytics(Long categoryId) {
		Category category=new Category();
		category.setCategoryId(categoryId);
		return new ResponseEntity<>( productsAnalyticsRepository.findByCategory(category),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ProductsAnalytics> getProductsAnalytics(Long productId) {
		return null;
	}

}
