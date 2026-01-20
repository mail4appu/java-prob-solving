package com.checkpoint.springredis.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ProductCustomizations implements Serializable {

    private static final long serialVersionUID = -6694260749014570072L;
    String priceRange;
    String type;
    int rating;
    String freeShipping;
    int pageSize;

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(String freeShipping) {
        this.freeShipping = freeShipping;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "ProductCustomizations{" +
                "priceRange='" + priceRange + '\'' +
                ", type='" + type + '\'' +
                ", rating=" + rating +
                ", freeShipping='" + freeShipping + '\'' +
                '}';
    }
}
