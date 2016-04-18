package com.product.mapper;

import com.product.domain.Product;
import com.product.domain.ProductDiscount;
import com.product.domain.ProductViewModel;
import org.springframework.stereotype.Component;

/**
 * Created by u342597 on 19/04/2016.
 */
@Component
public class ProductMapper {

    public Product mapProductViewModelToProduct(ProductViewModel productViewModel, Product product) {

        product.setCostPrice(productViewModel.getCostPrice());
        product.setRetailPrice(productViewModel.getRetailPrice());
        product.setProductCategory(productViewModel.getProductCategory());
        product.setProductCode(productViewModel.getProductCode());
        product.setProductName(productViewModel.getProductName());
        product.setProductDescription(productViewModel.getProductDescription());
        product.setProductInvoiceDescription(productViewModel.getProductInvoiceDescription());

        return product;
    }

    public ProductDiscount mapProductViewModelToProductDiscount(ProductViewModel productViewModel, ProductDiscount productDiscount) {

        productDiscount.setStartDate(productViewModel.getDiscountStartDate());
        productDiscount.setEndDate(productViewModel.getDiscountEndDate());
        productDiscount.setNeverExpires(productViewModel.getDiscountExpires());

        return productDiscount;
    }

}
