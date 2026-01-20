package com.schneider.batch.provider;

import com.schneider.batch.model.ApplicationHttpEntity;
import org.glassfish.jersey.media.multipart.internal.LocalizationMessages;
import org.glassfish.jersey.message.MessageUtils;

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
 * Created by SESA439295 on 6/19/2017.
 */
@Provider
@Produces("application/http")
public class ApplicationHttpWriter implements MessageBodyWriter<ApplicationHttpEntity> {

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
        // ApplicationHttpEntity bodyEntity=applicationHttpBodyPart.getApplicationHttpEntity();
        final Writer writer = new BufferedWriter(new OutputStreamWriter(entityStream, MessageUtils.getCharset(mediaType)));
        writer.write(bodyEntity.getStatusLine());
        Map<String, List<String>> headersLocal = bodyEntity.getHeaders();
        System.out.println("Headers before writing############################3:   " + headersLocal);
        for (Map.Entry<String, List<String>> entry : headersLocal.entrySet()) {
            System.out.println("Entry key:  " + entry.getKey() + "  : Entery value" + entry.getValue());
            writer.write("\r\n" + entry.getKey() + ": ");
            List<String> values = entry.getValue();
            if (values.size() == 0) {
                throw new RuntimeException();
            } else {
                writer.write(values.get(0));
            }
            writer.write("\r\n");
            writer.write("\r\n");

            //Writing body as json
            Class bodyClass = bodyEntity.getEntity().getClass();
            /*if (bodyEntity instanceof BodyPartEntity) {
                bodyClass = InputStream.class;
                System.out.println();
                bodyEntity = ((BodyPartEntity) bodyEntity).getInputStream();
            }*/

            final MessageBodyWriter bodyWriter = providers.getMessageBodyWriter(
                    bodyClass,
                    bodyClass,
                    EMPTY_ANNOTATIONS,
                    null);

            if (bodyWriter == null) {
                throw new IllegalArgumentException(LocalizationMessages.NO_AVAILABLE_MBW(bodyClass, mediaType));
            }
            System.out.println("Body writer is" + bodyWriter.getClass());
            writer.flush();
            try {
                bodyWriter.writeTo(
                        bodyEntity.getEntity(),
                        bodyClass,
                        bodyClass,
                        EMPTY_ANNOTATIONS,
                        MediaType.WILDCARD_TYPE,
                        bodyEntity.getHeaders(),
                        entityStream
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
            writer.write("\r\n");
            writer.close();
        }
    }
}
