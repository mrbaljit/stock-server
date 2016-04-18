package com.product.domain;

import java.util.Date;

/**
 * Created by u342597 on 18/04/2016.
 */
public class ProductViewModel {

    private String productCategory;
    private String productCode;
    private String productName;
    private String retailPrice;
    private String productDescription;
    private String productInvoiceDescription;
    private String costPrice;
    private String discountType;
    private String discountAmount;
    private String discountPercentage;
    private String discountForProduct;
    private String discountAmountForOrdersOver;
    private Date discountStartDate;
    private Date discountEndDate;
    private String discountExpires;

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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Date getDiscountEndDate() {
        return discountEndDate;
    }

    public void setDiscountEndDate(Date discountEndDate) {
        this.discountEndDate = discountEndDate;
    }

    public String getDiscountExpires() {
        return discountExpires;
    }

    public void setDiscountExpires(String discountExpires) {
        this.discountExpires = discountExpires;
    }

    public String getDiscountForProduct() {
        return discountForProduct;
    }

    public void setDiscountForProduct(String discountForProduct) {
        this.discountForProduct = discountForProduct;
    }

    public String getDiscountAmountForOrdersOver() {
        return discountAmountForOrdersOver;
    }

    public void setDiscountAmountForOrdersOver(String discountAmountForOrdersOver) {
        this.discountAmountForOrdersOver = discountAmountForOrdersOver;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Date getDiscountStartDate() {
        return discountStartDate;
    }

    public void setDiscountStartDate(Date discountStartDate) {
        this.discountStartDate = discountStartDate;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
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

    public String getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }
}
