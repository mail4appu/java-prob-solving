package com.checkpoint.zookeeper.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Component
//@ConfigurationProperties
public class CustomerRandomConfiguration implements Serializable {
    private static final long serialVersionUID = -5481155806499000172L;

    Map<String, String> appConfiguration = new HashMap<>();

    public Map<String, String> getAppConfiguration() {
        return appConfiguration;
    }


}
