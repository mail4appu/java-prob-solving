package com.schneider.batch.resource;

import com.schneider.batch.service.BatchService;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartMediaTypes;
import org.glassfish.jersey.server.ApplicationHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


/**
 * Created by SESA439295 on 6/12/2017.
 */
@Component
@Path("/")
@Transactional(rollbackFor = Exception.class)
public class BatchResource {

    private static final Logger logger = LoggerFactory.getLogger(BatchResource.class);

    @Context
    ApplicationHandler applicationHandler;

    @Context
    SecurityContext securityContext;


    @Autowired
    BatchService batchService;

    @Context
    org.glassfish.jersey.servlet.internal.ResponseWriter responseWriter;


    @POST
    @Path("/batch")
    @Produces({MultiPartMediaTypes.MULTIPART_MIXED})
    @Consumes(MultiPartMediaTypes.MULTIPART_MIXED)
    public Response processBatchRequest(MultiPart multiPartReq) throws Exception {
        MultiPart multiPartResponse = new MultiPart();
        System.out.println("===========================Thread executing GET Products =================================\n" + Thread.currentThread().getId() + "   :   " + Thread.currentThread().getName() + " response writer is " + responseWriter);
            if (multiPartReq != null) {
                logger.info("Processing  batch request -- Beginning");
                multiPartResponse = batchService.processBatch(multiPartReq, applicationHandler, securityContext);
            }
        logger.info("Processing batch request -- End");
        return Response.ok(multiPartResponse).build();

    }

}
