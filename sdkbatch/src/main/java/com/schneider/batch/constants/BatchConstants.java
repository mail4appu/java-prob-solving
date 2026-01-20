package com.schneider.batch.constants;

/**
 * Created by SESA439295 on 6/23/2017.
 */
public class BatchConstants {

    public static final String CONTENT_ID="Content-ID";
    public static final String CONTENT_LENGTH="Content-Length";
    public static final String CONTENT_TYPE="Content-Type";
    public static final String HTTP_STATUS_LINE="HTTP/1.1 200 OK";
    public static final String HTTP_VERSION="HTTP/1.1 ";

    public static final String APPLICATION_HTTP_MEDIA_TYPE="application/http";
    public static final String IN_MEMORY_URL="http://localhost:8080/";
    public static final String BAD_REQ_MSG="Body part must contain content type header with media type as 'application/http'";

    public static final String INVALID_REQUEST_URI="Bad request uri/path: ";

    public static final String INVALID_REQUEST_LINE="Invalid HTTP request Method/Uri/Version";

    public static final String INVALID_CONTENT_ID="Invalid Content-Id: ";

    public static final String VALID_CONTENT_ID_DESCRIPTION=". Must be in alphanumeric  format";

    public static final String INVALID_STATUS_LINE="Invalid status line";

    //^--begining of  string
    //[a-zA-Z0-9]+ -- must be either one or more digit(s) or character(s)
    //[a-zA-Z0-9_-]-- must contain one or more  digits/characters, -, _ after start
    public static final String CONTENT_ID_PATTERN="^[a-zA-Z0-9]+[a-zA-Z0-9_-]+";

    public static final String ZERO_BODY_PARTS_MSG="Nothing to process. Multipart must contain atliest  one body part";

}
