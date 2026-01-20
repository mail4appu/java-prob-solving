package com.schneider.batch.service;

import com.schneider.batch.constants.BatchConstants;
import com.schneider.batch.exception.BadRequestException;
import com.schneider.batch.exception.BatchProcessException;
import com.schneider.batch.model.ApplicationHttpEntity;
import com.schneider.batch.model.User;
import com.schneider.batch.provider.ResponseWriter;
import com.schneider.batch.util.BatchServiceUtil;
import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.internal.MapPropertiesDelegate;
import org.glassfish.jersey.media.multipart.BodyPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.server.ApplicationHandler;
import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.ContainerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
 * Created by SESA439295 on 6/21/2017
 */
@Component
public class BatchServiceImpl implements BatchService {

    @Autowired
    User user;

    @Autowired
    BatchServiceUtil batchServiceUtil;

    private static final Logger logger = LoggerFactory.getLogger(BatchServiceImpl.class);

    ApplicationHandler applicationHandler;

    SecurityContext securityContext;

    ResponseWriter responseWriter;


    public MultiPart processBatch(MultiPart batchMultipart, ApplicationHandler applicationHandler, SecurityContext securityContext) throws BatchProcessException, BadRequestException {
        logger.debug(" In handleBatch() ");

        //Validate request
        batchServiceUtil.validateMultipartReq(batchMultipart);
        //prepare required data
        this.applicationHandler = applicationHandler;
        this.securityContext = securityContext;
        prepareUser(batchMultipart);

        logger.debug("ApplicationHandler and security Context from jax-rs: " + applicationHandler + " , " + securityContext);
        List<BodyPart> responseBodyParts = null;
        MultiPart multiPartResponse = null;
        BodyPart responseBodyPart = null;
        //Iterate over body parts
        List<BodyPart> bodyPartList = batchMultipart.getBodyParts();
        if (bodyPartList != null && bodyPartList.size() > 0) {
            multiPartResponse = new MultiPart();
            responseBodyParts = new ArrayList<BodyPart>();
            for (BodyPart reqBodyPart : bodyPartList) {
                //Get the already prepared entity
                ApplicationHttpEntity applicationHttpEntity = (ApplicationHttpEntity) reqBodyPart.getEntity();
                logger.debug("Each internal body part entity is  " + applicationHttpEntity);

                if (applicationHttpEntity != null) {
                    //send each internal http request
                    Response response = sendInternalRequest(applicationHttpEntity);
                    responseBodyPart = new BodyPart();
                    //Add headers to repsonseBodyPart
                    addHeadersToResponseBodyPart(responseBodyPart, reqBodyPart);
                    //Add Body Part entity to responseBodyPart
                    responseBodyPart = addBodyEntityToResponseBodyPart(responseBodyPart, response);
                    responseBodyParts.add(responseBodyPart);
                    //Throw error when response is other than  200 or 201
                    if (response.getStatus() > 399 && response.getStatus() <= 503) {
                        logger.error("Response is other 200 or 201");
                        throw new BatchProcessException(prepareMultipartResponse(responseBodyParts, multiPartResponse));
                    }
                }

            }
        }

        //Prepare Multipart response
        return prepareMultipartResponse(responseBodyParts, multiPartResponse);
    }

    private void prepareUser(MultiPart batchMultipart) {
        final MultivaluedMap<String, String> headers = batchMultipart.getHeaders();
        if(headers!=null && headers.size()>0 && headers.containsKey("FederatedId")){
            user.setFedIDValue(headers.get("FederatedId").get(0));
            user.setFedIdKey("FederatedId");
        }
    }

    /**
     * This method actually handles the internal http request by delegating
     * the ContainerRequest to "ApplicationHandler" which process the request in synchronous way
     * <p>
     * Also, prepares javax.ws.rs.core.Response from ContainerResponse
     *
     * @param applicationHttpEntity
     * @return
     * @throws IOException
     */
    private Response sendInternalRequest(ApplicationHttpEntity applicationHttpEntity) throws BatchProcessException {
        logger.info("Delegating the container request to ApplicationHandler's handle() ");
        // Future<ContainerResponse> future = applicationHandler.apply(buildInternalRequestFromBodyPartEntity(applicationHttpEntity));
        applicationHandler.handle(buildContainerRequestFromBodyPartEntity(applicationHttpEntity));
        ContainerResponse containerResponse = responseWriter.getContainerResponse();
        Response response = buildResponseFromContainerResponse(containerResponse);
        return response;
    }

    private BodyPart addBodyEntityToResponseBodyPart(BodyPart responseBodyPart, Response response) {
        logger.debug("Adding body part entity response body part");
        //Create Body part entity
        ApplicationHttpEntity bodyEntity = new ApplicationHttpEntity();
        //Add status line
        bodyEntity.setStatusLine(BatchConstants.HTTP_VERSION + response.getStatus() + " " + response.getStatusInfo());
        //Add headers to Application/http body entity
        System.out.println("headers from each response : @@@@@@@@@@@@@@@@@@@@@@@@@@@@2:  " + response.getStringHeaders());
        MultivaluedMap<String, String> headers = response.getStringHeaders();
        bodyEntity.setHeaders(headers);
        //Add body to Application/http body entity
        bodyEntity.setEntity(response.getEntity());
        responseBodyPart.setMediaType(MediaType.valueOf(BatchConstants.APPLICATION_HTTP_MEDIA_TYPE));
        logger.debug("Each internal Response body part entity " + bodyEntity);
        responseBodyPart.entity(bodyEntity);
        return responseBodyPart;
    }

    private void addHeadersToResponseBodyPart(BodyPart responseBodyPart, BodyPart reqBodyPart) {
        logger.debug("Adding headers to response body part");
        MultivaluedMap<String, String> reqHeaders = reqBodyPart.getHeaders();
        MultivaluedMap<String, String> respHeaders = responseBodyPart.getHeaders();
        //Media type of the responseBodyPart
        responseBodyPart.getHeaders().put(BatchConstants.CONTENT_TYPE, reqHeaders.get(BatchConstants.CONTENT_TYPE));
        if (reqHeaders.containsKey(BatchConstants.CONTENT_ID)) {
            responseBodyPart.getHeaders().put(BatchConstants.CONTENT_ID, reqHeaders.get(BatchConstants.CONTENT_ID));
        }
    }

    private ContainerRequest buildContainerRequestFromBodyPartEntity(ApplicationHttpEntity bodyPartEntity) throws BatchProcessException {
        logger.debug("Generating container request from the given http request");
        String method = bodyPartEntity.getHttpMethod();
        //Container request ( Internal rest call )
        ContainerRequest containerRequest = new ContainerRequest(URI.create(BatchConstants.IN_MEMORY_URL), URI.create(bodyPartEntity.getServiceConsumerUrl()), method,
                securityContext, new MapPropertiesDelegate());
        //Set custom response writer
        responseWriter = new ResponseWriter();
        containerRequest.setWriter(responseWriter);
        // copy the headers
        Map<String, List<String>> headers = bodyPartEntity.getHeaders();
        for (String key : headers.keySet()) {
            List<String> values = headers.get(key);
            for (Object value : values) {
                containerRequest.header(key, value);
            }
        }

        //Add user details
        if(user.getFedIdKey()!=null )
        containerRequest.header(user.getFedIdKey(), user.getFedIDValue());
        // copy the request entity
        List<String> requestBody = bodyPartEntity.getRequestBody();
        if (requestBody != null && requestBody.size() > 0) {
            try {
                containerRequest.setEntityStream(IOUtils.toInputStream(requestBody.get(0), "UTF-8"));
            } catch (IOException e) {
                logger.error("Error while preparing container request", e);
                throw new BatchProcessException(e.getCause(), e.getMessage());
            }
        }
        logger.debug("Generated container  request" + containerRequest);
        return containerRequest;
    }


    private Response buildResponseFromContainerResponse(ContainerResponse containerResponse) {
        logger.debug("Building JAX-RS response from container response: " + containerResponse);
        //Create ResponseBuilder
        Response.ResponseBuilder responseBuilder = Response.status(containerResponse.getStatusInfo())
                .entity(containerResponse.getEntity()).lastModified(containerResponse.getLastModified())
                .type(containerResponse.getMediaType());
        for (String key : containerResponse.getHeaders().keySet()) {
            System.out.println("header keys from container response: ########################3:  " + key);
            // For some bizarre reason, the Content-Type header can get written out
            // twice and cause an exception to be thrown
            if (!BatchConstants.CONTENT_TYPE.equals(key)) {
                List<Object> values = containerResponse.getHeaders().get(key);
                for (Object value : values) {
                    responseBuilder.header(key, value);
                }
            }
        }
        responseBuilder.header(BatchConstants.CONTENT_LENGTH, responseWriter.getContentLength());
        Response response = responseBuilder.build();
        logger.debug("JAX-RS response from container response: " + response);
        return response;
    }


    private MultiPart prepareMultipartResponse(List<BodyPart> responseBodyParts, MultiPart multiPartResponse) {
        if (responseBodyParts != null && responseBodyParts.size() > 0) {
            for (BodyPart responsePart : responseBodyParts) {
                multiPartResponse.getBodyParts().add(responsePart);
            }
        }
        return multiPartResponse;
    }

}
