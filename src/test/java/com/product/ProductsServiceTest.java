package com.product;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.product.entity.Category;
import com.product.entity.CategoryAnalytics;
import com.product.entity.Products;
import com.product.entity.ProductsAnalytics;
import com.product.entity.UserDetails;
import com.product.repository.CategoryAnalyticsRepository;
import com.product.repository.CategoryRepository;
import com.product.repository.ProductsAnalyticsRepository;
import com.product.repository.ProductsRepository;
import com.product.repository.UserDetailsRepository;
import com.product.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductsServiceTest {

	@Mock
	ProductsRepository productsRepository;
	@Mock
	CategoryRepository categoryRepository;
	@Mock
	CategoryAnalyticsRepository categoryAnalyticsRepository;
	@Mock
	ProductsAnalyticsRepository productsAnalyticsRepository;
	@Mock
	UserDetailsRepository userDetailsRepository;

	@InjectMocks
	ProductService productService;

	Category category;
	UserDetails userDetails;
	Products products;

	CategoryAnalytics categoryAnalytics;
	ProductsAnalytics productsAnalytics;

	@Before
	public void setUp() {

		category = new Category();
		userDetails = new UserDetails();
		products = new Products();
		categoryAnalytics = new CategoryAnalytics();
		productsAnalytics = new ProductsAnalytics();

	}

	@Test
	public void AllCategorys() {

	}

	@Test
	public void getAllProducts(Long categoryId, Long userId) {

	}

	@Test
	public void getProduct(Long categoryId, Long userId, Long productId) {

	}

	@Test
	public void getCategorysAnalytics() {

	}

	@Test
	public void getCategorysProductsAnalytics(Long categoryId) {

	}

	@Test
	public void getProductsAnalytics(Long productId) {

	}

}
