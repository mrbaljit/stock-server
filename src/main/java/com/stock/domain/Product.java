package com.stock.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by u342597 on 14/04/2016.
 */
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    @Column(name = "PRODUCTCODE", nullable = false)
    private String productCode;

    @Column(name = "PRODUCTNAME", nullable = false)
    private String productName;

    @Column(name = "PRODUCTCATEGORY", nullable = false)
    private String productCategory;

    @Column(name = "COSTPRICE", nullable = false)
    private String costPrice;

    @Column(name = "RETAILPRICE", nullable = false)
    private String retailPrice;

    @Column(name = "PRODUCTDESC", nullable = false)
    private String productDescription;

    @Column(name = "PRODUCTINVDESC", nullable = false)
    private String productInvoiceDescription;


    @OneToOne
    @JoinColumn(name="productDiscountId")
    private ProductDiscount productDiscount;

    public Product() {
    }

    public Product(long productId, String productCode, String productName,
                   String productCategory, String productDescription, String productInvoiceDescription,
                   String retailPrice, String costPrice,
                   ProductDiscount productDiscount) {
        this.productId = productId;
        this.productCode = productCode;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.productInvoiceDescription = productInvoiceDescription;
        this.costPrice = costPrice;
        this.retailPrice = retailPrice;
        this.productDiscount = productDiscount;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductInvoiceDescription() {
        return productInvoiceDescription;
    }

    public void setProductInvoiceDescription(String productInvoiceDescription) {
        this.productInvoiceDescription = productInvoiceDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }

    public ProductDiscount getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(ProductDiscount productDiscount) {
        this.productDiscount = productDiscount;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", code='" + productCode + '\'' +
                ", name='" + productName + '\'' +
                ", productDiscount='" + productDiscount + '\'' +
                '}';
    }
}
