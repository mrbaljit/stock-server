package com.stock.service;

import com.stock.domain.Product;
import com.stock.repository.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by u342597 on 14/04/2016.
 */
@Service
public class StockService {
    public static final Logger LOGGER = LoggerFactory.getLogger(StockService.class);

    @Autowired
    private StockRepository repository;

    public List<Product> getAll() {
         return repository.findAll();

    }

}
