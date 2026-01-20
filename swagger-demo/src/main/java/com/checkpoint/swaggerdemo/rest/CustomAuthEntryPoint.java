package com.checkpoint.swaggerdemo.rest;

import com.checkpoint.swaggerdemo.rest.impl.LogResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomAuthEntryPoint extends BasicAuthenticationEntryPoint {
    Logger logger= LoggerFactory.getLogger(CustomAuthEntryPoint.class);

    @Override
    public void commence(
            HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
            throws IOException {
        logger.debug("======================Invoking custom authentication entry point==============");
        response.addHeader("WWW-Authenticate", "Basic realm="+getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 - " + authEx.getMessage());
    }

    @Override
    public void afterPropertiesSet() {
        setRealmName("Baeldung");
        super.afterPropertiesSet();
    }
}
