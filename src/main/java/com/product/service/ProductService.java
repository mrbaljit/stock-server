package com.product.service;

import com.product.domain.Product;
import com.product.domain.ProductDiscount;
import com.product.repository.ProductDiscountRepository;
import com.product.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

/**
 * Created by u342597 on 14/04/2016.
 */
@Service
public class ProductService {
    public static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDiscountRepository productDiscountRepository;

    public List<Product> getAll() {
         return productRepository.findAll();

    }

    @Transactional
    public void saveProduct(Product product, ProductDiscount productDiscount) {

        productDiscountRepository.save(productDiscount);
        product.setProductDiscount(productDiscount);
        productRepository.save(product);
    }


}
