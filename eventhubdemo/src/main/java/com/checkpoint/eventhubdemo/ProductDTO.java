package com.checkpoint.eventhubdemo;

import java.io.Serializable;

public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 351781042022950246L;


    private String algorithm;
    private String secretKey;
    private String maxAllowedClients;
    private String retailerUrl;


    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getMaxAllowedClients() {
        return maxAllowedClients;
    }

    public void setMaxAllowedClients(String maxAllowedClients) {
        this.maxAllowedClients = maxAllowedClients;
    }

    public String getRetailerUrl() {
        return retailerUrl;
    }

    public void setRetailerUrl(String retailerUrl) {
        this.retailerUrl = retailerUrl;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "algorithm='" + algorithm + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", maxAllowedClients='" + maxAllowedClients + '\'' +
                ", retailerUrl='" + retailerUrl + '\'' +
                '}';
    }
}
