package com.stock.controller;

import com.stock.domain.Stock;
import com.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by u342597 on 14/04/2016.
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    private StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }


    @RequestMapping(value = "/hello", method = GET)
    public String sayHello(){
        return "Hello there !";
    }

    @RequestMapping(value = "/allStock", method = GET)
    public List<Stock> getAll(){
        return stockService.getAll();
    }

    @RequestMapping(value = "/addStock" , method = RequestMethod.POST)
    public void saveStock(@RequestBody Stock stock) {

        System.out.println(stock.getName());
        System.out.println(stock.getCode());
        System.out.println(stock.getStockData().getPrice());
        System.out.println(">>>>>>>>>>>>>>>>>");
    }


}
