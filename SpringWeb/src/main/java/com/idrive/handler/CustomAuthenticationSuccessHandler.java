package com.idrive.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by SESA439295 on 8/17/2018.
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for(GrantedAuthority authority:authorities){
            if("ROLE_USER".equals(authority.getAuthority())){

                redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/courses");
            }
            else{
                redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "");
            }
        }
    }
}
