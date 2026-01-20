package com.checkpoint.swaggerdemo.rest;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BasicAuthFilter extends AbstractAuthenticationProcessingFilter {

    public BasicAuthFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        final String authorization = httpServletRequest.getHeader("Authorization");
        if(StringUtils.isEmpty(authorization)){
            throw new BadCredentialsException("No credentials");

        }
        System.out.println(httpServletRequest.getParameter("Username"));
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(httpServletRequest.getParameter("Username"), httpServletRequest.getParameter("Password")));
    }
}
