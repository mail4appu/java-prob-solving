package com.schneider.batch.provider;

import com.schneider.batch.constants.BatchConstants;
import com.schneider.batch.model.ApplicationHttpEntity;
import com.schneider.batch.util.BatchParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by sesa298913 on 19/06/2017.
 */
@Provider
@Consumes("application/http")
public class ApplicationHttpReader implements MessageBodyReader<ApplicationHttpEntity> {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationHttpReader.class);

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return ApplicationHttpEntity.class.isAssignableFrom(type);
    }

    @Override
    public ApplicationHttpEntity readFrom(Class<ApplicationHttpEntity> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        logger.debug("Preparing ApplicationHttpEntity using custom entity provider --reader ");
        //Prepare parse-able bodyPart from input stream
        List<String> bodyPart=BatchParser.prepareBodyPart(entityStream);

        ApplicationHttpEntity applicationHttpEntity = new ApplicationHttpEntity();
        MultivaluedMap<String, String> headers = applicationHttpEntity.getHeaders();
        //Parse headers and set in the entity object (applicationHttpEntity)
        headers.putAll(BatchParser.consumeHeaders(bodyPart));
        String httpReqLine;

        //Parse status line and set in the entity Object ( applicationHttpEntity)
        httpReqLine = BatchParser.consumeHttpStatusLine(bodyPart);
        applicationHttpEntity.setRequestLine(httpReqLine);

        prepareRequestMetadata(httpReqLine, applicationHttpEntity);
        //Set the remaining list as request body
        applicationHttpEntity.setRequestBody(bodyPart);
        if (bodyPart.size() > 0) {
            applicationHttpEntity.setEntity(bodyPart.get(0));
        }
        //set media type in the entity
        if (applicationHttpEntity.getEntity() != null) {
             List<String> contentTypeList=headers.get(BatchConstants.CONTENT_TYPE);
             if(contentTypeList!=null && contentTypeList.size()>0) {
                 applicationHttpEntity.setMediaType(MediaType.valueOf(contentTypeList.get(0)));
             }
        }
        return applicationHttpEntity;
    }

    private void prepareRequestMetadata(String httpReqLine, ApplicationHttpEntity applicationHttpEntity) {
        if(org.apache.commons.lang3.StringUtils.isNotBlank(httpReqLine)) {
            final String[] parts = httpReqLine.toString().split(" ");
            if (parts!=null && parts.length == 3) {
                applicationHttpEntity.setHttpMethod(parts[0]);
                applicationHttpEntity.setServiceConsumerUrl(parts[1]);
                applicationHttpEntity.setHttpVersion(parts[2]);
            }

        }


    }
}
