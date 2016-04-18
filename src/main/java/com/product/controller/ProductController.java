package com.product.controller;

import com.product.domain.Product;
import com.product.domain.ProductDiscount;
import com.product.domain.ProductViewModel;
import com.product.mapper.ProductMapper;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by u342597 on 14/04/2016.
 */
@RestController
@RequestMapping("/stock")
public class ProductController {

    private ProductService productService;
    private ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }


    @RequestMapping(value = "/hello", method = GET)
    public String sayHello(){
        return "Hello there !";
    }

    @RequestMapping(value = "/allStock", method = GET)
    public List<Product> getAll(){
        List<Product> products = productService.getAll();
        System.out.println(products.get(0).getProductDiscount().getStartDate());
        return productService.getAll();
    }

    @RequestMapping(value = "/addStock" , method = RequestMethod.POST)
    public void productStock(@RequestBody ProductViewModel productViewModel) {

        Product product = new Product();
        product = productMapper.mapProductViewModelToProduct(productViewModel, product);
        ProductDiscount productDiscount = new ProductDiscount();
        productDiscount = productMapper.mapProductViewModelToProductDiscount(productViewModel, productDiscount);


        productService.saveProduct(product, productDiscount);

        System.out.println(productViewModel.getProductCategory());
        System.out.println(productViewModel.getProductCode());
        System.out.println(productViewModel.getProductName());
        System.out.println(productViewModel.getCostPrice());
        System.out.println(productViewModel.getRetailPrice());

        System.out.println(productViewModel.getProductDescription());
        System.out.println(productViewModel.getProductInvoiceDescription());

        System.out.println(productViewModel.getDiscountStartDate());
        System.out.println(productViewModel.getDiscountEndDate());
        System.out.println(productViewModel.getDiscountExpires());

        System.out.println(productViewModel.getDiscountType());

        System.out.println(productViewModel.getDiscountAmount());
        System.out.println(productViewModel.getDiscountPercentage());

        System.out.println(productViewModel.getDiscountForProduct());
        System.out.println(productViewModel.getDiscountAmountForOrdersOver());

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("Current Date: " + ft.format(productViewModel.getDiscountStartDate()));
        System.out.println("End Date: " + ft.format(productViewModel.getDiscountEndDate()));

        System.out.println(">>>>>>>>>>>>>>>>>");
    }


}


