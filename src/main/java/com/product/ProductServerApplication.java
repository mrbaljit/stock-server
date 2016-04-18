package com.product;

import com.product.domain.Product;
import com.product.repository.ProductDiscountRepository;
import com.product.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.CommandLineRunner;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class ProductServerApplication {

	private static final Logger log = LoggerFactory.getLogger(ProductServerApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(ProductServerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository repository, ProductDiscountRepository stockDataRepository) {
		return (args) -> {
			/*// save a couple of customers
			ProductDiscount productDiscount = new ProductDiscount();
			productDiscount.setStartDate(new Date());
			productDiscount.setEndDate(new Date());
			productDiscount.setNeverExpires("true");
			productDiscount.setDiscountTypes("1");

			stockDataRepository.save(productDiscount);
			repository.save(new Product(1, "ADID", "Adidas Jersey",
					"3", "XL Jersey Red Colour", "2010 XL Red",
					"500", "600", productDiscount));
*/
			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Product customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");


		};
	}
}
