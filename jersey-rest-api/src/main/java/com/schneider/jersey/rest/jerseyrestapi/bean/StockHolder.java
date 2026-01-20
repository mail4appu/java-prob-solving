package com.schneider.jersey.rest.jerseyrestapi.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by SESA439295 on 1/11/2018.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "Update StockHolder Request", description = "Update Stockholder api request")
public class StockHolder {

    @NotNull(message = "Stock Holder name should be there")
    private String  stockHolderName;
    @NotNull(message = "Stock holder currency must be present")
    private String  stockHolderCurrency;

    @Valid
    @NotNull(message = "there should be at-liest one stock")
    @ApiModelProperty(required = false)
    List<Stock> stocks;

    @Valid
    @ApiModelProperty(required = false)
    StockExchange stockExchange;

    public String getStockHolderName() {
        return stockHolderName;
    }

    public void setStockHolderName(String stockHolderName) {
        this.stockHolderName = stockHolderName;
    }


    public String getStockHolderCurrency() {
        return stockHolderCurrency;
    }

    public void setStockHolderCurrency(String stockHolderCurrency) {
        this.stockHolderCurrency = stockHolderCurrency;
    }

    @NotNull
    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public StockExchange getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
    }
}
