package com.checkpoint.zookeeper.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@ConfigurationProperties
public class CustomerDefinedConfiguration implements Serializable {

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


}
