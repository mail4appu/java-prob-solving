package com.schneider.batch.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import com.schneider.batch.exception.ApplicationException;
import com.schneider.batch.exception.BadRequestException;
import com.schneider.batch.exception.BatchProcessException;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDetailWrapper {

    private String error;

    private String error_description;

    private int status;

    public ErrorDetailWrapper() {
    }

    public ErrorDetailWrapper(String error) {
        this.error = error;
    }

    public ErrorDetailWrapper(String error, String errorDescription) {
        this.error = error;
        this.error_description = errorDescription;
    }

    public ErrorDetailWrapper(String error, String errorDescription, int status) {
        this.error = error;
        this.error_description = errorDescription;
        this.status = status;
    }

    public ErrorDetailWrapper(ApplicationException ex) {
        this.error_description = ex.getMessage();
        this.status = ex.getStatus();
    }

    public ErrorDetailWrapper(BatchProcessException ex) {
        this.error_description = ex.getMessage();
        this.status = ex.getStatus();
    }

    public ErrorDetailWrapper(BadRequestException ex) {
        this.error_description = ex.getMessage();
        this.status = ex.getStatus();
    }

    public String getError() {
        return error;
    }

    public void setError(String message) {
        this.error = message;
    }

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }

    public int getStatus() {
		return status;
	}

    public void setStatus(int status) {
		this.status = status;
	}

	@Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }


}
