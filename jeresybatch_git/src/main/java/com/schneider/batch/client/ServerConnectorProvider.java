package com.schneider.batch.client;

/**
 * Created by SESA439295 on 6/14/2017.
 */
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ApplicationHandler;

/*
 * This is truly ugly, unrefined code.  I'm not going to say anything to defend otherwise.
 */
@Provider
public class ServerConnectorProvider implements Feature {

    private ApplicationHandler applicationHandler;



    public ServerConnectorProvider( @Context  ApplicationHandler applicationHandler) {
        this.applicationHandler = applicationHandler;
    }

    @Override
    public boolean configure(FeatureContext context) {
        ServerConnectorFactory.init(applicationHandler);
        return true;
    }

    public static final class ServerConnectorFactory {

        private static ApplicationHandler applicationHandler;

        private static void init(ApplicationHandler applicationHandler) {
            ServerConnectorFactory.applicationHandler = applicationHandler;
        }

        private ServerConnectorFactory() {}

        public static ServerSideConnector build() {
            return new ServerSideConnector(applicationHandler);
        }

    }

}