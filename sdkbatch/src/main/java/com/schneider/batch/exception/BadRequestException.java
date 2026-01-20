package com.schneider.batch.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.schneider.batch.util.ErrorDetailWrapper;
import org.glassfish.jersey.media.multipart.MultiPartMediaTypes;

/**
 * Created by SESA439295 on 6/28/2017.
 */
@Provider
public class BadRequestException extends Exception implements ExceptionMapper<BadRequestException> {

    private static final long serialVersionUID = 1L;

    int status=500;

    /** Description about the error */
    String message;

    public BadRequestException() {
        super("Not a valid request !!");
        System.out.println();
    }

    public BadRequestException(String string) {
        super(string);
        this.message=string;
        this.status=400;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Response toResponse(BadRequestException exception) {
        return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON)
                .entity(new ErrorDetailWrapper(exception))
                .build();
    }
}
