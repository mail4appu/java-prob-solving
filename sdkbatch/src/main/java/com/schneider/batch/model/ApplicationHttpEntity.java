package com.schneider.batch.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.glassfish.jersey.media.multipart.BodyPart;
import org.glassfish.jersey.media.multipart.BodyPartEntity;
import org.jvnet.mimepull.MIMEPart;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by SESA439295 on 6/17/2017.
 */
public class ApplicationHttpEntity {
    //It has all the header and body from BodyPart & extra request/response fields

    //Request attributes
    String requestLine;
    List<String> requestBody;
    List<String> remainingMessage = new LinkedList<String>();
    String serviceConsumerUrl;
    String httpMethod;
    String httpVersion;

    //Response attributes
    private String  statusLine;
    MediaType mediaType;
    Object entity;

    MultivaluedMap<String, String> headers = new MultivaluedHashMap<String, String>();

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public String getStatusLine() {
        return statusLine;
    }

    public void setStatusLine(String statusLine) {
        this.statusLine = statusLine;
    }


    public MultivaluedMap<String, String> getHeaders() {
        return headers;
    }



    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }


    public String getRequestLine() {
        return requestLine;
    }

    public void setRequestLine(String requestLine) {
        this.requestLine = requestLine;
    }


    public List<String> getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(List<String> requestBody) {
        this.requestBody = requestBody;
    }

    public List<String> getRemainingMessage() {
        return remainingMessage;
    }

    public void setRemainingMessage(List<String> remainingMessage) {
        this.remainingMessage = remainingMessage;
    }

    public String getServiceConsumerUrl() {
        return serviceConsumerUrl;
    }

    public void setServiceConsumerUrl(String serviceConsumerUrl) {
        this.serviceConsumerUrl = serviceConsumerUrl;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public void setHeaders(MultivaluedMap<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
