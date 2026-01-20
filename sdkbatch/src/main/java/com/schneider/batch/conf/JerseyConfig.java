package com.schneider.batch.conf;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.schneider.batch.client.ServerConnectorProvider;
import com.schneider.batch.exception.ApplicationException;
import com.schneider.batch.exception.BadRequestException;
import com.schneider.batch.exception.BatchProcessException;
import com.schneider.batch.provider.ApplicationHttpReader;
import com.schneider.batch.provider.ApplicationHttpWriter;
import com.schneider.batch.provider.GenericExceptionHandler;
import com.schneider.batch.provider.ProviderLoggingListener;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by SESA439295 on 6/12/2017.
 */
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        super(MultiPartFeature.class,
                ServerConnectorProvider.class,
                JacksonJaxbJsonProvider.class,
                ApplicationHttpWriter.class,
                ApplicationHttpReader.class,
                ProviderLoggingListener.class,
                GenericExceptionHandler.class,
                BadRequestException.class,
                ApplicationException.class,
                BatchProcessException.class);

    }
}
