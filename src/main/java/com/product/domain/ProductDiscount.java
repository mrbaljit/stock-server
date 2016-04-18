package com.product.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by u342597 on 14/04/2016.
 */
@Entity
@Table(name = "PRODUCT_DISCOUNT")
public class ProductDiscount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_DISCOUNT_ID", nullable = false)
    private Long productDiscountId;

    @Column(name = "STARTDATE")
    private Date startDate;

    @Column(name = "ENDDATE")
    private Date endDate;

    @Column(name = "NEVEREXPIRES")
    private String neverExpires;

    @Column(name = "DISCOUNTTYPES")
    private String discountTypes;

    public ProductDiscount() {
    }

    public ProductDiscount(long productDiscountId, String discountTypes, String neverExpires, Date startDate, Date endDate) {
        this.productDiscountId = productDiscountId;
        this.discountTypes = discountTypes;
        this.neverExpires = neverExpires;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getProductDiscountId() {
        return productDiscountId;
    }

    public void setProductDiscountId(Long productDiscountId) {
        this.productDiscountId = productDiscountId;
    }

    public String getDiscountTypes() {
        return discountTypes;
    }

    public void setDiscountTypes(String discountTypes) {
        this.discountTypes = discountTypes;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getNeverExpires() {
        return neverExpires;
    }

    public void setNeverExpires(String neverExpires) {
        this.neverExpires = neverExpires;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Stock_Data{" +


                '}';
    }
}
