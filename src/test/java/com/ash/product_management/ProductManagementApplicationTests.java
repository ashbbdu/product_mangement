package com.ash.product_management;

import com.ash.product_management.entities.ProductEntity;
import com.ash.product_management.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ProductManagementApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository () {
		ProductEntity product = ProductEntity
				.builder().sku("SKU123").title("Tea Tree Shampoo")
				.quantity(10).price(new BigDecimal("10.0999")).build();


		ProductEntity savedEntity = productRepository.save(product);
		System.out.println(savedEntity);
	}

	@Test
	void getRepository () {
		List<ProductEntity> products = productRepository.findAll();
		for(ProductEntity l : products) {
			System.out.println(l);
		}
	}

//	Custom queries
	@Test
	void getRepositoryByTitle () {
		List<ProductEntity> products = productRepository.findByTitle("MacBook Air M3");
		for(ProductEntity l : products) {
			System.out.println(l);
		}
	}

	@Test
	void getRepositoryReadByTitle () {

//		readBy , queryBy ,
		List<ProductEntity> products = productRepository.readByTitle("MacBook Air M3");
		for(ProductEntity l : products) {
			System.out.println(l);
		}
	}

	@Test
	void getFirst2Results () {
		List<ProductEntity> products = productRepository.findFirst2ByTitle("MacBook Air M3");
		for(ProductEntity l : products) {
			System.out.println(l);
		}
	}

	@Test
	void getStartingWIth () {
		List<ProductEntity> products = productRepository.findByTitleStartingWith("MacBook");
		for(ProductEntity l : products) {
			System.out.println(l);
		}
	}

	@Test
	void orderBY () {
		List<ProductEntity>  products = productRepository.findByTitleOrderByIdDesc("MacBook Air M3");
		for(ProductEntity l : products) {
			System.out.println(l);
		}
	}

	@Test
	void distinct () {
		List<ProductEntity>  products = productRepository.findDistinctByTitle("MacBook Air M3");
		for(ProductEntity l : products) {
			System.out.println(l);
		}
	}

	@Test
	void findByTitleAndPrice () {
		ProductEntity product = productRepository.findByTitleAndPrice("iPhone 15" ,new BigDecimal("59999.99") );
		System.out.println(product);
	}

	@Test
	void findByTitleAndPrice1 () {
		ProductEntity product = productRepository.findByTitleAndPrice1("iPhone 15" ,new BigDecimal("59999.99") );
		System.out.println(product);
	}

	@Test
	void countAll () {
		Long count  = productRepository.countByTitle("MacBook Air M3");
		System.out.println(count);
	}


}
