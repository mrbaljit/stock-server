package com.example;

import com.product.ProductServerApplication;
import com.product.domain.Product;
import com.product.domain.ProductDiscount;
import com.product.repository.ProductDiscountRepository;
import com.product.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProductServerApplication.class)
public class ProductServerApplicationTests {

	@Autowired
	ProductDiscountRepository productDiscountRepository;

	@Autowired
	ProductRepository productRepository;

	@Before
	public void setUp() {

		ProductDiscount productDiscount = new ProductDiscount();
		productDiscount.setStartDate(new Date());
		productDiscount.setEndDate(new Date());
		productDiscount.setNeverExpires("true");
		productDiscount.setDiscountTypes("1");

		productDiscountRepository.save(productDiscount);
		productRepository.save(new Product(1, "ADID", "Adidas Jersey",
				"3", "XL Jersey Red Colour", "2010 XL Red",
				"500", "600", productDiscount));

	}

	@Test
	public void getItemsShouldReturnBothItems() {
		System.out.println(productRepository.findAll().size());
	}

}
