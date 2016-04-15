package com.stock.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.crypto.Data;

/**
 * Created by u342597 on 14/04/2016.
 */
@Entity
@Table(name = "STOCK_DATA")
public class StockData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STOCK_DATA_ID", nullable = false)
    private Long stockDataId;

    @Column(name = "DATE", nullable = false)
    private Date date;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRICE", nullable = false)
    private String price;

    public StockData() {
    }

    public StockData(long stockDataId, String price, String name, Date date) {
        this.stockDataId = stockDataId;
        this.price = price;
        this.name = name;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getStockDataId() {
        return stockDataId;
    }

    public void setStockDataId(Long stockDataId) {
        this.stockDataId = stockDataId;
    }

    @Override
    public String toString() {
        return "Stock_Data{" +
                "stockDataId=" + stockDataId +
                ", price='" + price + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
