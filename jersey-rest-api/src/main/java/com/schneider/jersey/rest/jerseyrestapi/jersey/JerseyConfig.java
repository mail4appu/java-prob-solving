package com.schneider.jersey.rest.jerseyrestapi.jersey;

import com.schneider.jersey.rest.jerseyrestapi.resource.StockResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;


@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(StockResource.class);
    }
}
