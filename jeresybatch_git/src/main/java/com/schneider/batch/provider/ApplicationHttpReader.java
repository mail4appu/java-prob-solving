package com.schneider.batch.provider;

import com.schneider.batch.util.BatchParser;
import com.schneider.batch.model.ApplicationHttpEntity;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sesa298913 on 19/06/2017.
 */
@Provider
@Consumes("application/http")
public class ApplicationHttpReader implements MessageBodyReader<ApplicationHttpEntity> {
    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return ApplicationHttpEntity.class.isAssignableFrom(type);
    }

    @Override
    public ApplicationHttpEntity readFrom(Class<ApplicationHttpEntity> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        List<String> remainingMessage = new LinkedList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(entityStream));
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                remainingMessage.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        remainingMessage.addAll(remainingMessage);

        ApplicationHttpEntity applicationHttpEntity = new ApplicationHttpEntity();
        applicationHttpEntity.getHeaders().putAll(BatchParser.consumeHeaders(remainingMessage));
        String httpReqLine = null;
        try {
            httpReqLine = BatchParser.consumeHttpStatusLine(remainingMessage);
            applicationHttpEntity.setRequestLine(httpReqLine);
        } catch (Exception e) {
            e.printStackTrace();
        }
        prareRequestMetadata(httpReqLine, applicationHttpEntity);
        applicationHttpEntity.setRequestBody(remainingMessage);
        return applicationHttpEntity;
    }

    private void prareRequestMetadata(String httpReqLine, ApplicationHttpEntity bpe) {
        final String[] parts = httpReqLine.toString().split(" ");
        if (parts.length == 3) {
            bpe.setHttpMethod(parts[0]);
            bpe.setServiceConsumerUrl(parts[1]);
            bpe.setHttpVersion(parts[2]);
        }


    }
}
