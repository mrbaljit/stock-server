package com.stock;

import com.stock.domain.Stock;
import com.stock.domain.StockData;
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
			StockData stockData = new StockData();
			stockData.setDate(new Date());
			stockData.setName("hello");
			stockData.setPrice("200");

			stockDataRepository.save(stockData);
			repository.save(new Stock(1, "Jack", "Bauer", stockData));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Stock customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");


		};
	}
}
