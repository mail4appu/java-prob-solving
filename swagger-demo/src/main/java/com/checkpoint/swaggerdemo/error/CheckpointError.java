package com.checkpoint.swaggerdemo.error;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

public class CheckpointError {
    private String errorCode;
    private String statusCode;
    private String statusMessage;
    private String errorDescription;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> errors=new ArrayList<>();

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "CheckpointError{" +
                "errorCode='" + errorCode + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                ", statusDescription='" + errorDescription + '\'' +
                '}';
    }
}
