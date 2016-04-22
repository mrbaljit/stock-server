package com.product.controller;

import com.product.domain.Product;
import com.product.domain.ProductDiscount;
import com.product.domain.ProductViewModel;
import com.product.mapper.ProductMapper;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by u342597 on 14/04/2016.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;
    private ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @RequestMapping(value = "/allProducts", method = GET)
    public List<ProductViewModel> getAll(){
        return  productService.getAll();
    }

    @RequestMapping(value = "{id}/getProduct", method = GET)
    public ProductViewModel getAll(@PathVariable String id){
        Product product = productService.getProduct(Long.valueOf(id));
        ProductViewModel productViewModel = productMapper.mapDomainToProductViewModel(product, product.getProductDiscount());
        return productViewModel;
    }

    @RequestMapping(value = "{id}/deleteProduct", method = POST)
    public void deleteProduct(@PathVariable String id)
    {
        productService.deleteProduct(Long.valueOf(id));
    }

    @RequestMapping(value = "/createUpdateProduct" , method = RequestMethod.POST)
    public void createUpdateProduct(@RequestBody ProductViewModel productViewModel) {

        try {

            Product product = new Product(1L);

            if(!StringUtils.isEmpty(productViewModel.getProductId()))
            {
                product = productService.getProduct(Long.valueOf(productViewModel.getProductId()));
            }

            product = productMapper.mapProductViewModelToProduct(productViewModel, product);
            ProductDiscount productDiscount = new ProductDiscount();
            productDiscount = productMapper.mapProductViewModelToProductDiscount(productViewModel, productDiscount);
            productService.saveProduct(product, productDiscount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}