package com.sguess.secrity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class AuthSucessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private static final Logger logger=LoggerFactory.getLogger(AuthSucessHandler.class);

    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String role=authentication.getAuthorities().toString();
        String targetUrl="adminHomePage";
        if (role.equals("Admin")){
            return "/adminHomePage";
        }else{
            return "/nomalPage";
        }
    }
}
