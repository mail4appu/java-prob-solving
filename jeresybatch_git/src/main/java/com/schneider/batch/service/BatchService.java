package com.schneider.batch.service;

import org.glassfish.jersey.media.multipart.BodyPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.server.ApplicationHandler;

import javax.ws.rs.core.SecurityContext;
import java.util.List;

/**
 * Created by SESA439295 on 6/21/2017.
 */
public interface BatchService {

    public List<BodyPart> handleBatch(MultiPart batchMultipart, ApplicationHandler applicationHandler, SecurityContext securityContext);
}
