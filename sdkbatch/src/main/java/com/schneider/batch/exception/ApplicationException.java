package com.schneider.batch.exception;

import com.schneider.batch.util.ErrorDetailWrapper;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartMediaTypes;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by SESA439295 on 6/29/2017.
 */
@Provider
public class ApplicationException extends Exception implements ExceptionMapper<ApplicationException> {

    /**
     *
     */
    private static final long serialVersionUID = -2903022710041322542L;

    int status = 500;

    /**
     * Description about the error
     */
    String message;

    /**
     * @param status
     * @param message
     */
    public ApplicationException(int status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public ApplicationException(Throwable cause, int status, String message) {
        super(message, cause);
        this.status = status;
        this.message = message;
    }

    public ApplicationException() {
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


    @Override
    public Response toResponse(ApplicationException exception) {
        return Response.status(exception.getStatus()).type(MediaType.APPLICATION_JSON)
                .entity(new ErrorDetailWrapper(exception)).build();
    }
}
