package com.schneider.batch.service;

import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.internal.MapPropertiesDelegate;
import org.glassfish.jersey.media.multipart.BodyPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.server.ApplicationHandler;
import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.ContainerResponse;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import com.schneider.batch.model.ApplicationHttpEntity;
import com.schneider.batch.provider.ResponseWriter;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by SESA439295 on 6/21/2017.
 */
@Component
@Transactional(rollbackFor = RuntimeException.class)
public class BatchServiceImpl implements BatchService {

    ApplicationHandler applicationHandler;

    SecurityContext securityContext;

    ResponseWriter responseWriter;


    public List<BodyPart> handleBatch(MultiPart batchMultipart, ApplicationHandler applicationHandler, SecurityContext securityContext) throws RuntimeException {
        System.out.println("Transaction status: **********************:  "+ TransactionSynchronizationManager.isActualTransactionActive());

        this.applicationHandler=applicationHandler;
        this.securityContext=securityContext;
        List<BodyPart> responseBodyParts = new ArrayList<BodyPart>();
        System.out.println("body parts ######################: "+batchMultipart.getBodyParts().size());
        try {

            for (BodyPart reqBodyPart : batchMultipart.getBodyParts()) {
                ApplicationHttpEntity applicationHttpEntity = reqBodyPart.getEntityAs(ApplicationHttpEntity.class);
                //System.out.println("Each application entity is *******:  " + applicationHttpEntity);

                BodyPart responseBodyPart = sendRequest(applicationHttpEntity);
                responseBodyParts.add(responseBodyPart);
            }
        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }

        return responseBodyParts;
    }

    private BodyPart sendRequest(ApplicationHttpEntity applicationHttpEntity) {
        BodyPart responseBodyPart = new BodyPart();
        // Future<ContainerResponse> future = applicationHandler.apply(buildContainerRequestFromClientRequest(applicationHttpEntity));
        applicationHandler.handle(buildContainerRequestFromClientRequest(applicationHttpEntity));
        ContainerResponse containerResponse = responseWriter.getContainerResponse();
        Response response = buildResponseFromContainerResponse(containerResponse);
        System.out.println("Media type from Container response is : @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:  " + response.getMediaType());
        addHeadersToResponseBodyPart(responseBodyPart, applicationHttpEntity);
        addBodyEntityToResponseBodyPart(responseBodyPart, response);

        return responseBodyPart;
    }

    private void addBodyEntityToResponseBodyPart(BodyPart responseBodyPart, Response response) {

        //Add headers to Application/http body entity
        ApplicationHttpEntity bodyEntity = new ApplicationHttpEntity();
        MultivaluedMap<String, String> headers = response.getStringHeaders();
        bodyEntity.setStatusLine("HTTP/1.1 200 OK");

        bodyEntity.setHeaders(headers);
        // System.out.println("HHHHHHHHHHHHHHHHHHHHHH: "+bodyEntity.getHeaders());

        //Add body to Application/http body entity
        bodyEntity.setEntity(response.getEntity());
        responseBodyPart.setMediaType(MediaType.valueOf("application/http"));
        responseBodyPart.entity(bodyEntity);
    }

    private void addHeadersToResponseBodyPart(BodyPart responseBodyPart, ApplicationHttpEntity applicationHttpEntity) {

        MultivaluedMap<String, String> reqHeaders = applicationHttpEntity.getHeaders();
        MultivaluedMap<String, String> respHeaders = responseBodyPart.getHeaders();
        List<String> headerValues = new ArrayList<String>();
        //Media type of the responseBodyPart
        headerValues.add("application/http");
        respHeaders.put("Content-Type", headerValues);
        if (reqHeaders.containsKey("Content-ID")) {
            responseBodyPart.getHeaders().put("Content-ID", reqHeaders.get("Content-ID"));
        }
        //TODO below line has no effect. Need to check
        //responseBodyPart.setMediaType(MediaType.valueOf("application/http"));
    }


    private ContainerRequest buildContainerRequestFromClientRequest(ApplicationHttpEntity request) {
        String method = request.getHttpMethod();
        ContainerRequest containerRequest = new ContainerRequest(URI.create("http://localhost:8080/"), URI.create("/products"), method,
                securityContext, new MapPropertiesDelegate());
        responseWriter= new ResponseWriter();
        containerRequest.setWriter(responseWriter);

        // copy the headers
        Map<String, List<String>> headers = request.getHeaders();
        for (String key : headers.keySet()) {
            List<String> values = headers.get(key);
            for (Object value : values) {
                containerRequest.header(key, value);
            }
        }

        // copy the request entity

        try {
            containerRequest.setEntityStream(IOUtils.toInputStream(request.getRequestBody().size() > 0 ? request.getRequestBody().get(0) : "", "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return containerRequest;
    }


    private Response buildResponseFromContainerResponse(ContainerResponse containerResponse) {
        Response.ResponseBuilder responseBuilder = Response.status(containerResponse.getStatusInfo())
                .entity(containerResponse.getEntity()).lastModified(containerResponse.getLastModified())
                .type(containerResponse.getMediaType());
        //System.out.println("Container response"+containerResponse.getStatusInfo().getStatusCode()+":  "+containerResponse.getStatus()+": "+containerResponse.getHeaders()+": "+containerResponse.getMediaType()+": "+containerResponse.getEntityType());

        for (String key : containerResponse.getHeaders().keySet()) {
            // For some bizarre reason, the Content-Type header can get written out
            // twice and cause an exception to be thrown
            if (!"Content-Type".equals(key)) {
                List<Object> values = containerResponse.getHeaders().get(key);
                for (Object value : values) {
                    responseBuilder.header(key, value);
                }
            }
        }

        Response response = responseBuilder.build();
        System.out.println("response media type:   " + response.getMediaType());
        return response;
    }

}
