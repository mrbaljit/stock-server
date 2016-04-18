package com.stock.controller;

import com.stock.domain.Product;
import com.stock.domain.StockViewModel;
import com.stock.service.StockService;
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
    public List<Product> getAll(){
        List<Product> products = stockService.getAll();
        System.out.println(products.get(0).getProductDiscount().getStartDate());
        return stockService.getAll();
    }

    @RequestMapping(value = "/addStock" , method = RequestMethod.POST)
    public void saveStock(@RequestBody StockViewModel stockViewModel) {

        System.out.println(stockViewModel.getProductCategory());
        System.out.println(stockViewModel.getProductCode());
        System.out.println(stockViewModel.getProductName());
        System.out.println(stockViewModel.getCostPrice());
        System.out.println(stockViewModel.getRetailPrice());

        System.out.println(stockViewModel.getProductDescription());
        System.out.println(stockViewModel.getProductInvoiceDescription());

        System.out.println(stockViewModel.getDiscountStartDate());
        System.out.println(stockViewModel.getDiscountEndDate());
        System.out.println(stockViewModel.getDiscountExpires());

        System.out.println(stockViewModel.getDiscountType());

        System.out.println(stockViewModel.getDiscountAmount());
        System.out.println(stockViewModel.getDiscountPercentage());

        System.out.println(stockViewModel.getDiscountForProduct());
        System.out.println(stockViewModel.getDiscountAmountForOrdersOver());

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("Current Date: " + ft.format(stockViewModel.getDiscountStartDate()));
        System.out.println("End Date: " + ft.format(stockViewModel.getDiscountEndDate()));

        System.out.println(">>>>>>>>>>>>>>>>>");
    }


}


