package com.product.service;

import com.product.domain.Product;
import com.product.domain.ProductDiscount;
import com.product.domain.ProductViewModel;
import com.product.mapper.ProductMapper;
import com.product.repository.ProductDiscountRepository;
import com.product.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private ProductMapper productMapper;

    public List<ProductViewModel> getAll() {
        List<Product> products = productRepository.findAll();
        List<ProductViewModel> productViewModelList = new ArrayList<>();
        ProductViewModel productViewModel = new ProductViewModel();
        for(Product product : products) {
            productViewModel = new ProductViewModel();
            productViewModel = productMapper.mapDomainToProductViewModel(productViewModel, product, product.getProductDiscount());
            productViewModelList.add(productViewModel);
        }

         //return productRepository.findAll();
        return productViewModelList;

    }

    @Transactional
    public void saveProduct(Product product, ProductDiscount productDiscount) {

        productDiscountRepository.save(productDiscount);
        product.setProductDiscount(productDiscount);
        productRepository.save(product);
    }


    @Transactional
    public ProductViewModel getProduct(Long id) {

        Product product= productRepository.findOne(id);
        ProductViewModel productViewModel = new ProductViewModel();
        productViewModel = productMapper.mapDomainToProductViewModel(productViewModel, product, product.getProductDiscount());
        return productViewModel;

    }

    @Transactional
    public Product getProduct1(Long id) {

        return productRepository.findOne(id);


    }

    @Transactional
    public void updateProduct(Product product, ProductDiscount productDiscount, Long id) {

        Product p = productRepository.findOne(id);
        //Product p = productRepository.findOne(75L);
        p.setCostPrice("611");
        p.setCostPrice(product.getCostPrice());
        p.setRetailPrice(product.getRetailPrice());
        p.setProductCode(product.getProductCode());
        p.setProductCategory(product.getProductCategory());
        p.setProductInvoiceDescription(product.getProductInvoiceDescription());
        p.setProductDescription(product.getProductDescription());
        p.setProductName(product.getProductName());
        p.setProductDiscount(productDiscount);
        productRepository.save(p);
    }
}
