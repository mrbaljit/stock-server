package com.example;

import com.product.ProductServerApplication;
import com.product.domain.Product;
import com.product.domain.ProductDiscount;
import com.product.repository.ProductDiscountRepository;
import com.product.repository.ProductRepository;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProductServerApplication.class)
public class ProductServerApplicationTests {

	@Autowired
	ProductDiscountRepository productDiscountRepository;

	@Autowired
	ProductRepository productRepository;

	Long productId;

	@Before
	public void setUp() {

		ProductDiscount productDiscount = new ProductDiscount();
		productDiscount.setStartDate(new Date());
		productDiscount.setEndDate(new Date());
		productDiscount.setNeverExpires("true");
		productDiscount.setDiscountTypes("1");

		productDiscountRepository.save(productDiscount);
		productRepository.save(new Product(1, "DELETE", "test product",
				"3", "XL Jersey Red Colour", "2010 XL Red",
				"100", "200", productDiscount));

	}

	@After
	public void tearDown() {

	    productRepository.delete(productId);

	}


	/*@Test
	public void getAll() {
		System.out.println(productRepository.findAll().size());
	}*/

	@Test
	public void findByProductCode() {
		List<Product> prd = productRepository.findByProductCode("DELETE");
		productId = prd.get(0).getProductId();

	}

	@Test
	public void findByProductCodeContainingIgnoreCase() {
		List<Product> prd = productRepository.findByProductCodeContainingIgnoreCase("delete");
		productId = prd.get(0).getProductId();

	}

}
