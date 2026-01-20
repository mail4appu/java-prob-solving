package com.idrive.server.resources;

import com.idrive.filter.RateLimiterFilter;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.test.DeploymentContext;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.ServletDeploymentContext;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.Test;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;

public class MyServiceJerseyIT extends JerseyTest {

    @Override
    protected TestContainerFactory getTestContainerFactory() {
        return new GrizzlyWebTestContainerFactory();

    }

    @Override
    public void configureClient(ClientConfig config) {
        config.register(MultiPartFeature.class);
    }


    @Override
    protected DeploymentContext configureDeployment() {
        ResourceConfig resourceConfig = new ResourceConfig(Myservice.class,
                 MultiPartFeature.class);
        resourceConfig.property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        resourceConfig.property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
        return ServletDeploymentContext.forServlet(new ServletContainer(resourceConfig)).addListener(ContextLoaderListener.class)
                .addListener(RequestContextListener.class)
                .addFilter(RateLimiterFilter.class, "rateLimiterFilter")
                .contextParam("contextConfigLocation", "classpath:testconfig.xml").build();
    }


    @Test
    public void testGet(){
        target("/api/stock/price").request().header("Content-Type", "application/x-www-form-urlencoded").get();
    }
}
