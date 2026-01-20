package com.schneider.batch.exception;

import com.schneider.batch.util.ErrorDetailWrapper;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartMediaTypes;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by SESA439295 on 6/22/2017.
 */
@Provider
public class BatchProcessException  extends Exception implements ExceptionMapper<BatchProcessException> {

    private static final long serialVersionUID = -2903022710041322542L;

    int status = 500;

    /**
     * Description about the error
     */
    String message;

    MultiPart multiPartResponse;

    /**
     * @param status
     * @param message
     */
    public BatchProcessException(int status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public BatchProcessException(Throwable cause, int status, String message) {
        super(message, cause);
        this.status = status;
        this.message = message;
    }


    public BatchProcessException(Throwable cause, String message) {
        super(message, cause);
        this.status = 500;
        this.message = message;
    }




    public BatchProcessException() {
    }

    public BatchProcessException(MultiPart multiPart){
        this.multiPartResponse=multiPart;

    }

    public MultiPart getMultiPartResponse() {
        return multiPartResponse;
    }

    public void setMultiPartResponse(MultiPart multiPartResponse) {
        this.multiPartResponse = multiPartResponse;
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
    public Response toResponse(BatchProcessException exception) {

        if (exception.getMultiPartResponse() != null) {
            return Response.status(200).type(MultiPartMediaTypes.MULTIPART_MIXED)
                    .entity(exception.getMultiPartResponse()).build();
        }
        return Response.status(exception.getStatus()).type(MediaType.APPLICATION_JSON)
                .entity(new ErrorDetailWrapper(exception)).build();
    }
}
