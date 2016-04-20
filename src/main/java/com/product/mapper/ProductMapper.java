package com.product.mapper;

import com.product.domain.Product;
import com.product.domain.ProductDiscount;
import com.product.domain.ProductViewModel;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by u342597 on 19/04/2016.
 */
@Component
public class ProductMapper {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");

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

    public ProductDiscount mapProductViewModelToProductDiscount(ProductViewModel productViewModel, ProductDiscount productDiscount) throws ParseException {


        productDiscount.setStartDate(formatter1.parse(productViewModel.getDiscountStartDate()));
        productDiscount.setEndDate(formatter1.parse(productViewModel.getDiscountEndDate()));
        productDiscount.setNeverExpires(productViewModel.getDiscountExpires());
        productDiscount.setDiscountTypes(productViewModel.getDiscountType());

        return productDiscount;
    }

    public ProductViewModel mapDomainToProductViewModel(ProductViewModel productViewModel, Product product,
                                                         ProductDiscount productDiscount) {

        productViewModel.setCostPrice(product.getCostPrice());
        productViewModel.setRetailPrice(product.getRetailPrice());
        productViewModel.setProductCategory(product.getProductCategory());
        productViewModel.setProductCode(product.getProductCode());
        productViewModel.setProductName(product.getProductName());
        productViewModel.setProductDescription(product.getProductDescription());
        productViewModel.setProductInvoiceDescription(product.getProductInvoiceDescription());
        productViewModel.setProductId(String.valueOf(product.getProductId()));

        productViewModel.setDiscountStartDate(formatter.format(productDiscount.getStartDate()));
        productViewModel.setDiscountEndDate(formatter.format(productDiscount.getEndDate()));
        productViewModel.setDiscountExpires(productDiscount.getNeverExpires());
        productViewModel.setDiscountType(productDiscount.getDiscountTypes());
        productViewModel.setProductId(String.valueOf(product.getProductId()));
        return productViewModel;
    }
}
