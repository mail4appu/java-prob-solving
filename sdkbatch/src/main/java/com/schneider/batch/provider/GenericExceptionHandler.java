package com.schneider.batch.provider;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by SESA439295 on 6/22/2017.
 */
public class GenericExceptionHandler {
    public Response toResponse(RuntimeException exception) {
        String errorMessage="{ \"status\":\"500\", \"errorMessage\":\"'"+exception.getMessage()+"'\" }";
        return Response.status(500).entity(errorMessage).type(MediaType.valueOf("application/json")).build();
    }
}
