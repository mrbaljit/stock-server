package com.stock;

import com.stock.domain.Product;
import com.stock.domain.ProductDiscount;
import com.stock.repository.StockDataRepository;
import com.stock.repository.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.CommandLineRunner;

import java.util.Date;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class StockServerApplication {

	private static final Logger log = LoggerFactory.getLogger(StockServerApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(StockServerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(StockRepository repository, StockDataRepository stockDataRepository) {
		return (args) -> {
			// save a couple of customers
			ProductDiscount productDiscount = new ProductDiscount();
			productDiscount.setStartDate(new Date());
			productDiscount.setEndDate(new Date());
			productDiscount.setNeverExpires("true");
			productDiscount.setDiscountTypes("1");

			stockDataRepository.save(productDiscount);
			repository.save(new Product(1, "ADID", "Adidas Jersey",
					"3", "XL Jersey Red Colour", "2010 XL Red",
					"500", "600", productDiscount));

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
