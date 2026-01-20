package com.schneider.batch.provider;

import org.glassfish.jersey.server.ContainerResponse;
import org.glassfish.jersey.server.spi.ContainerResponseWriter;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

/**
 * Created by SESA439295 on 6/20/2017.
 */
public class ResponseWriter implements ContainerResponseWriter {
    private MultivaluedMap<String, String> headers;
    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private boolean committed;
    private Response.StatusType statusInfo;

    private ContainerResponse containerResponse;

    public ResponseWriter() {
    }

    public OutputStream writeResponseStatusAndHeaders(long contentLength, ContainerResponse responseContext) {

        //Just take container response from here
        this.containerResponse=responseContext;
        return this.baos;
    }

    public boolean suspend(long timeOut, TimeUnit timeUnit, TimeoutHandler timeoutHandler) {
        return false;
    }

    public void setSuspendTimeout(long timeOut, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("Async server side invocations are not supported by InMemoryContainer.");
    }

    public void commit() {
        this.committed = true;
    }

    public void failure(Throwable error) {
        throw new ProcessingException("Server-side request processing failed with an error.", error);
    }

    public boolean enableResponseBuffering() {
        return true;
    }

    public byte[] getEntity() {
        if (!this.committed) {
            throw new IllegalStateException("Response is not committed yet.");
        } else {
            return this.baos.toByteArray();
        }
    }

    public MultivaluedMap<String, String> getHeaders() {
        return this.headers;
    }

    public Response.StatusType getStatusInfo() {
        return this.statusInfo;
    }


    public ContainerResponse getContainerResponse() {
        return containerResponse;
    }

    public void setContainerResponse(ContainerResponse containerResponse) {
        this.containerResponse = containerResponse;
    }
}
