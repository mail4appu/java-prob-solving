package com.schneider.batch.provider;

import com.schneider.batch.model.ApplicationHttpEntity;
import org.glassfish.jersey.media.multipart.internal.LocalizationMessages;
import org.glassfish.jersey.message.MessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by SESA439295 on 6/19/2017
 */
@Provider
@Produces("application/http")
public class ApplicationHttpWriter implements MessageBodyWriter<ApplicationHttpEntity> {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationHttpWriter.class);

    private static final Annotation[] EMPTY_ANNOTATIONS = new Annotation[0];

    private final Providers providers;

    public ApplicationHttpWriter(@Context final Providers providers) {
        System.out.println(providers.getClass().getName());
        this.providers = providers;
    }

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return ApplicationHttpEntity.class.equals(type);
    }

    @Override
    public long getSize(ApplicationHttpEntity applicationHttpEntity, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(ApplicationHttpEntity bodyEntity, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException {
        logger.debug("writing to output stream from ApplicationHttpEntity ");
        final Writer writer = new BufferedWriter(new OutputStreamWriter(entityStream, MessageUtils.getCharset(mediaType)));
        //write status line
        writer.write(bodyEntity.getStatusLine());
        Map<String, List<String>> headersLocal = bodyEntity.getHeaders();
        //write headers
        logger.debug("response headers in ApplicationHttpEntity:  "+headersLocal);
        for (Map.Entry<String, List<String>> entry : headersLocal.entrySet()) {
            List<String> values = entry.getValue();
            if (values.size()> 0) {
                writer.write("\r\n" + entry.getKey() + ": ");
                writer.write(values.get(0));
            }
        }
        writer.write("\r\n");
        writer.write("\r\n");

        //Writing body as json
        if(bodyEntity.getEntity()!=null) {
            Class bodyClass = bodyEntity.getEntity().getClass();
            final MessageBodyWriter bodyWriter = providers.getMessageBodyWriter(
                    bodyClass,
                    bodyClass,
                    EMPTY_ANNOTATIONS,
                    null);

            if (bodyWriter == null) {
                throw new IllegalArgumentException(LocalizationMessages.NO_AVAILABLE_MBW(bodyClass, mediaType));
            }
                writer.flush();
                bodyWriter.writeTo(
                        bodyEntity.getEntity(),
                        bodyClass,
                        bodyClass,
                        EMPTY_ANNOTATIONS,
                        MediaType.WILDCARD_TYPE,
                        bodyEntity.getHeaders(),
                        entityStream
                );
            }
        writer.write("\r\n");
        writer.close();
    }
}
