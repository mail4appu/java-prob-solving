package com.schneider.batch.util;

import com.schneider.batch.constants.BatchConstants;
import com.schneider.batch.exception.BadRequestException;
import com.schneider.batch.exception.BatchProcessException;
import com.schneider.batch.model.ApplicationHttpEntity;
import com.schneider.batch.service.BatchServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.media.multipart.BodyPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MultivaluedMap;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by SESA439295 on 7/4/2017.
 * TODO: This can be inner Class to BatchServiceImpl
 */

@Component
public class BatchServiceUtil {

    private static final Logger logger = LoggerFactory.getLogger(BatchServiceImpl.class);

    /**
     * This method
     * a) validates the  incoming request
     * b) prepares ApplicationHttpEntity from input stream ( req) and sets the same as entity in multipart so that,
     * it is easy to get as Object for further  processing
     *
     * @param multiPart
     * @return
     * @throws BadRequestException
     */
    public   MultiPart validateMultipartReq(MultiPart multiPart) throws BadRequestException, BatchProcessException {
        logger.debug("validating incoming multipart request ");
        MultivaluedMap<String, String> bodyPartHeaders;
        if (multiPart != null) {
            List<BodyPart> bodyPartList = multiPart.getBodyParts();

            int size = bodyPartList.size();
            logger.info("Body parts inside multipart request " + size);

            if (bodyPartList != null && size > 0) {
                for (BodyPart reqBodyPart : bodyPartList) {
                    bodyPartHeaders = reqBodyPart.getHeaders();
                    //Fetch Content-Id, to point the right place of error
                    String contentId = getContentId(bodyPartHeaders);
                    String errorContentId = getErrorContentId(contentId);
                    //Validate Content-Type's value
                    logger.debug("validating Content-Type header value ");
                    if ((bodyPartHeaders.containsKey(BatchConstants.CONTENT_TYPE)) && bodyPartHeaders.get(BatchConstants.CONTENT_TYPE) != null && (bodyPartHeaders.get(BatchConstants.CONTENT_TYPE).get(0).equals(BatchConstants.APPLICATION_HTTP_MEDIA_TYPE))) {
                        //do nothing
                    } else {
                        throw new com.schneider.batch.exception.BadRequestException(BatchConstants.BAD_REQ_MSG + errorContentId);
                    }
                    //Validate  Content-ID's value
                    logger.debug("validating Content-ID header value ");
                    /*if (StringUtils.isNotBlank(contentId)) {
                        if (!contentId.matches(BatchConstants.CONTENT_ID_PATTERN)) {
                            throw new com.schneider.batch.exception.BadRequestException(BatchConstants.INVALID_CONTENT_ID + contentId + BatchConstants.VALID_CONTENT_ID_DESCRIPTION);
                        }
                    }*/
                    //Validate internal http request uri
                    logger.debug("validating internal http request uri value ");
                    ApplicationHttpEntity applicationHttpEntity = null;
                    try {
                        //TODO: The below 2 lines will be removed. Added for debugging
                        String bodyPartString= reqBodyPart.getEntityAs(String.class);
                        System.out.println("each body is =================================\n"+bodyPartString);

                        applicationHttpEntity = reqBodyPart.getEntityAs(ApplicationHttpEntity.class);
                    } catch (Exception e) {
                        logger.error("Exception occurred while preparing BodyPartEntity from inputStream", e);
                        throw new BatchProcessException(e.getCause(), e.getMessage());

                    }
                    validateInternalHttpRequest(applicationHttpEntity, errorContentId);
                    //set above prepared object as entity in multipart so that, no need to prepare this entity for further processing
                    multiPart.getBodyParts().get(bodyPartList.indexOf(reqBodyPart)).setEntity(applicationHttpEntity);

                }

            } else {
                throw new com.schneider.batch.exception.BadRequestException(BatchConstants.ZERO_BODY_PARTS_MSG);
            }
        }
        return multiPart;

    }

    /**
     * Checks if the given request  line is non empty
     * and
     * Checks if the given internal http req uri is valid java.net.URI or not
     * and
     * ensures uri is not a opaque uri ( opaque uris make no sense in case of rest services )
     *
     * @param bodyPartEntity
     * @throws BadRequestException
     */
    private void validateInternalHttpRequest(ApplicationHttpEntity bodyPartEntity, String errorContentId) throws BadRequestException {
        logger.debug("Internal http request line " + bodyPartEntity.getRequestLine());
        if (StringUtils.isBlank(bodyPartEntity.getHttpMethod()) || StringUtils.isBlank(bodyPartEntity.getServiceConsumerUrl()) || StringUtils.isBlank(bodyPartEntity.getHttpVersion())) {
            throw new BadRequestException(BatchConstants.INVALID_REQUEST_LINE + errorContentId);
        }
        URI uri = null;
        try {
            uri = new URI(bodyPartEntity.getServiceConsumerUrl());
        } catch (URISyntaxException e) {
            logger.error("invalid request uri", e);
            throw new com.schneider.batch.exception.BadRequestException(e.getMessage() + errorContentId);
        }
        if (uri.isOpaque()) { //Examples: mailto:emailid@email.com, news:comp.lang.java
            logger.debug("opaque url in  http request" + uri.toString());
            throw new com.schneider.batch.exception.BadRequestException(BatchConstants.INVALID_REQUEST_URI + errorContentId);
        }

    }

    private String getContentId(MultivaluedMap<String, String> bodyPartHeaders) {
        if (bodyPartHeaders.containsKey(BatchConstants.CONTENT_ID) && bodyPartHeaders.get(BatchConstants.CONTENT_ID) != null) {
            return bodyPartHeaders.get(BatchConstants.CONTENT_ID).get(0);
        }
        return "";
    }


    private String getErrorContentId(String contentId) {
        if(StringUtils.isNotBlank(contentId)) {
            return " @ " + BatchConstants.CONTENT_ID + ": " + contentId;
        }
        return "";

    }

}

