package com.schneider.batch.util;

import com.schneider.batch.model.ApplicationHttpEntity;
import com.schneider.batch.service.BatchService;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.glassfish.jersey.media.multipart.BodyPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.internal.MultiPartReaderClientSide;
import org.glassfish.jersey.media.multipart.internal.MultiPartReaderServerSide;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartHttpServletRequest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by SESA439295 on 7/6/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class BatchServiceUtilTest {


    @Mock
    MockMultipartHttpServletRequest mockMultipartHttpServletRequest;
    String multipartRequest = "POST /nfhelper-api/v1/batch HTTP/1.1\n" +
            "Host: nfh-ppr.schneider-electric.com\n" +
            "Authorization: Bearer <access_token>\n" +
            "Content-Type: multipart/mixed; boundary=batch_36522ad7-fc75-4b56-8c71-56071383e77b\n" +
            "Content-Length: ###\n" +
            "\n" +
            "--batch_36522ad7-fc75-4b56-8c71-56071383e77b\n" +
            "Content-Type: application/http\n" +
            "Content-ID: batch_1\n" +
            "\n" +
            "GET /projects HTTP/1.1\n" +
            "Accept: application/json\n" +
            "\n" +
            "--batch_36522ad7-fc75-4b56-8c71-56071383e77b--";


    List<ApplicationHttpEntity> applicationHttpEntityList = new ArrayList<ApplicationHttpEntity>();


    @Before
    public void setUp() throws Exception {
/*
        new MultiPartReaderClientSide(new Providers() {
            @Override
            public <T> MessageBodyReader<T> getMessageBodyReader(Class<T> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
                return null;
            }

            @Override
            public <T> MessageBodyWriter<T> getMessageBodyWriter(Class<T> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
                return null;
            }

            @Override
            public <T extends Throwable> ExceptionMapper<T> getExceptionMapper(Class<T> type) {
                return null;
            }

            @Override
            public <T> ContextResolver<T> getContextResolver(Class<T> contextType, MediaType mediaType) {
                return null;
            }
        }).readFrom(MultiPart.class, MultiPart.class, null,MediaType.valueOf("application/http"), null, new ByteArrayInputStream(multipartRequest.getBytes()) );
        multiPart=initializeMultipartRequest();
        when(bodyPart.getEntityAs(ApplicationHttpEntity.class)).thenReturn(new ApplicationHttpEntity());*/

    }

    private MultiPart initializeMultipartRequest() throws IOException {
       /* multiPart= new MultiPart();
        bodyPart= new BodyPart("Content-Type: application/http\n" +
                "Content-ID: batch_1\n" +
                "\n" +
                "GET /projects HTTP/1.1\n" +
                "Accept: application/json", MediaType.valueOf("application/http"));
        bodyPart.setMediaType(MediaType.valueOf("application/http"));
        bodyPart.getHeaders().add("Content-Type", "application/http");

        MultivaluedMap<String, String> headers= new MultivaluedHashMap<String, String>();
        multiPart.bodyPart(bodyPart);
       // headers.add("Content-Type", "multipart/mixed;boundary=batch_36522ad7-fc75-4b56-8c71-56071383e77b");

        multiPart.getHeaders().add("Content-Type", "multipart/mixed;boundary=batch_36522ad7-fc75-4b56-8c71-56071383e77b");
        return multiPart;
*/
        return null;
    }

    @Test
    public void validateMultipartReq() throws Exception {
        // batchServiceUtil.validateMultipartReq(multiPart);

    }


}