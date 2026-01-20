package com.schneider.batch.resource;

import com.schneider.batch.service.BatchService;
import org.glassfish.jersey.media.multipart.BodyPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartMediaTypes;
import org.glassfish.jersey.server.ApplicationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import com.schneider.batch.provider.ResponseWriter;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;


/**
 * Created by SESA439295 on 6/12/2017.
 */
@Component
@Path("/")
public class BatchResource {

    @Context
    ApplicationHandler applicationHandler;

    @Context
    SecurityContext securityContext;

    ResponseWriter responseWriter;

    @Autowired
    BatchService batchService;



    @POST
    @Path("/batch")
    @Produces(MultiPartMediaTypes.MULTIPART_MIXED)
    @Consumes(MultiPartMediaTypes.MULTIPART_MIXED)
    public Response processBatchRequest(MultiPart multiPart) {
        MultiPart multiPartResponse = new MultiPart();
        try {
            System.out.println("===========================Thread executing GET Products =================================\n"+Thread.currentThread().getId()+"   :   "+Thread.currentThread().getName());
            List<BodyPart> reponseParts =batchService.handleBatch(multiPart, applicationHandler, securityContext);
            //List<BodyPart> reponseParts =handleBatch(multiPart);
            System.out.println("in processing batch request:   " + reponseParts.size()+" transaction status: "+ TransactionSynchronizationManager.isActualTransactionActive());


            for (BodyPart responsePart : reponseParts) {
                multiPartResponse.getBodyParts().add(responsePart);
            }
        } catch (Exception ex) {
            //TODO Needs proper exception handling
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        }
        return Response.ok(multiPartResponse).build();

    }


  }
