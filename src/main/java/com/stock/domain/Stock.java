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
@Table(name = "STOCK")
public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STOCK_ID", nullable = false)
    private Long stockId;

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name="stockDataId")
    private StockData stockData;

    public Stock() {
    }

    public Stock(long stockId, String code, String name, StockData stockData) {
        this.stockId = stockId;
        this.code = code;
        this.name = name;
        this.stockData = stockData;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StockData getStockData() {
        return stockData;
    }

    public void setStockData(StockData stockData) {
        this.stockData = stockData;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }


    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", stockData='" + stockData + '\'' +
                '}';
    }
}
