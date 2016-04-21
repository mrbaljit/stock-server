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
    @Column(name = "ID", nullable = false)
    private Long id;

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

    public ProductDiscount(long id, String discountTypes, String neverExpires, Date startDate, Date endDate) {
        this.id = id;
        this.discountTypes = discountTypes;
        this.neverExpires = neverExpires;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "Product_Data{" +


                '}';
    }
}
