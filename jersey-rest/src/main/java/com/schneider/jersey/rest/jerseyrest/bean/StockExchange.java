package com.schneider.jersey.rest.jerseyrest.bean;

import javax.validation.constraints.NotNull;

/**
 * Created by SESA439295 on 1/11/2018.
 */
public class StockExchange {

    @NotNull
    private String exchangeName;
    @NotNull
    private String exchangeCountry;

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getExchangeCountry() {
        return exchangeCountry;
    }

    public void setExchangeCountry(String exchangeCountry) {
        this.exchangeCountry = exchangeCountry;
    }
}
