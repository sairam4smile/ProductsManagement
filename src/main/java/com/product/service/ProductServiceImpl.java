package com.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.product.dto.CategoryAnalyticsAnalysisDto;
import com.product.dto.ProductAnalyticsAnalysisDto;
import com.product.entity.Category;
import com.product.entity.CategoryAnalytics;
import com.product.entity.Products;
import com.product.entity.ProductsAnalytics;
import com.product.entity.UserDetails;
import com.product.exceptions.UserDeatilsException;
import com.product.repository.CategoryAnalyticsRepository;
import com.product.repository.CategoryRepository;
import com.product.repository.ProductsAnalyticsRepository;
import com.product.repository.ProductsRepository;
import com.product.repository.UserDetailsRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductsRepository productsRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	CategoryAnalyticsRepository categoryAnalyticsRepository;
	@Autowired
	ProductsAnalyticsRepository productsAnalyticsRepository;
	@Autowired
	UserDetailsRepository userDetailsRepository;

	Category category;
	UserDetails userDetails;
	Products products;

	@Override
	public ResponseEntity<List<Category>> allCategorys() {

		return new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Products>> getAllProducts(Long categoryId, Long userId) {


		if (!userDetailsRepository.findById(userId).isPresent())
			throw new UserDeatilsException("user not existed");

		if (!categoryRepository.findById(categoryId).isPresent())
			throw new UserDeatilsException("category not existed");

		category = new Category();
		category.setCategoryId(categoryId);

		userDetails = new UserDetails();
		userDetails.setUserId(userId);

		Optional<CategoryAnalytics> categoryAnalyticsDb = categoryAnalyticsRepository.countOfCategoryHits(categoryId,
				userId);
		if (categoryAnalyticsDb.isPresent()) {
			Long count = categoryAnalyticsDb.get().getViewCount();
			categoryAnalyticsDb.get().setCategory(category);
			categoryAnalyticsDb.get().setUserDetails(userDetails);
			categoryAnalyticsDb.get().setViewCount(count + 1);
			categoryAnalyticsRepository.save(categoryAnalyticsDb.get());

		} else {
			CategoryAnalytics categoryAnalytics = new CategoryAnalytics();
			categoryAnalytics.setViewCount(1L);
			categoryAnalytics.setCategory(category);
			categoryAnalytics.setUserDetails(userDetails);
			categoryAnalyticsRepository.save(categoryAnalytics);
		}
	
		
		return new ResponseEntity<>(productsRepository.getPoductsByCategory(categoryId), HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Products> getProduct(Long categoryId,Long userId, Long productId) {

		if (!userDetailsRepository.findById(userId).isPresent())
			throw new UserDeatilsException("user not existed");

		
		
		if (!categoryRepository.findById(categoryId).isPresent())
			throw new UserDeatilsException("category not existed");
		
		

		java.util.Optional<Products> product = productsRepository.findById(productId);
		if(!product.isPresent())
			throw new UserDeatilsException("prooduct not existed");

		userDetails = new UserDetails();
		userDetails.setUserId(userId);

		products = new Products();
		products.setProductId(productId);
		
		category =new Category(); 
		category.setCategoryId(categoryId);

		Optional<ProductsAnalytics> productsAnalytics = productsAnalyticsRepository.countOfProductsHits(productId,
				userId);

		if (productsAnalytics.isPresent()) {

			productsAnalytics.get().setViewCount(productsAnalytics.get().getViewCount() + 1);
			productsAnalyticsRepository.save(productsAnalytics.get());

		} else {
			ProductsAnalytics productsAnalyticsSave = new ProductsAnalytics();
			productsAnalyticsSave.setProducts(products);
			productsAnalyticsSave.setViewCount(1L);
			productsAnalyticsSave.setUserDetails(userDetails);
			productsAnalyticsSave.setCategory(category);
			productsAnalyticsRepository.save(productsAnalyticsSave);

		}
		
		
		
		return new ResponseEntity<>(product.get(), HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<List<CategoryAnalyticsAnalysisDto>> getCategorysAnalytics() {

		List<?> CategoryAnalytics = categoryAnalyticsRepository.anlyticsOfCategoryHits();

		List<CategoryAnalyticsAnalysisDto> CategoryAnalyticsAnalysisDtolist = new ArrayList<>();
		for (Object obj : CategoryAnalytics) {
			CategoryAnalyticsAnalysisDto categoryAnalyticsAnalysisDto = new CategoryAnalyticsAnalysisDto();
			Object[] o = (Object[]) obj;
			categoryAnalyticsAnalysisDto.setCategory_id((Long) o[0]);
			categoryAnalyticsAnalysisDto.setViewCount((Long) o[1]);
			CategoryAnalyticsAnalysisDtolist.add(categoryAnalyticsAnalysisDto);

		}

		return new ResponseEntity<>(CategoryAnalyticsAnalysisDtolist, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<ProductAnalyticsAnalysisDto>> getCategorysProductsAnalytics(Long categoryId) {

		if (!categoryRepository.findById(categoryId).isPresent())
			throw new UserDeatilsException("category not existed");
		
		List<?> productsAnalytics = productsAnalyticsRepository.anlyticsOfProductsHits(categoryId);

		List<ProductAnalyticsAnalysisDto> productAnalyticsAnalysisDtolist = new ArrayList<>();
		for (Object obj : productsAnalytics) {
			ProductAnalyticsAnalysisDto productAnalyticsAnalysisDto = new ProductAnalyticsAnalysisDto();
			Object[] o = (Object[]) obj;
			productAnalyticsAnalysisDto.setProduct_id((Long) o[0]);
			productAnalyticsAnalysisDto.setViewCount((Long) o[1]);
			productAnalyticsAnalysisDtolist.add(productAnalyticsAnalysisDto);

		}

		return ResponseEntity.ok().body(productAnalyticsAnalysisDtolist);
	}

	@Override
	public ResponseEntity<List<ProductAnalyticsAnalysisDto>> getProductsAnalytics(Long productId) {
		

		if (!productsRepository.findById(productId).isPresent())
			throw new UserDeatilsException("product not existed");
		
		List<?> productsAnalytics = productsAnalyticsRepository.anlyticsOneProductHits(productId);

		List<ProductAnalyticsAnalysisDto> productAnalyticsAnalysisDtolist = new ArrayList<>();
		for (Object obj : productsAnalytics) {
			ProductAnalyticsAnalysisDto productAnalyticsAnalysisDto = new ProductAnalyticsAnalysisDto();
			Object[] o = (Object[]) obj;
			productAnalyticsAnalysisDto.setProduct_id((Long) o[0]);
			productAnalyticsAnalysisDto.setViewCount((Long) o[1]);
			productAnalyticsAnalysisDtolist.add(productAnalyticsAnalysisDto);

		}

		return ResponseEntity.ok().body(productAnalyticsAnalysisDtolist);

	
	
	
	
	
	}

}
