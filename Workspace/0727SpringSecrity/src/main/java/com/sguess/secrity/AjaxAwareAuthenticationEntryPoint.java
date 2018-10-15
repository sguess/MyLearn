package com.sguess.secrity;

import com.sun.net.httpserver.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.header.Header;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxAwareAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
    private static Logger log = LoggerFactory.getLogger(AjaxAwareAuthenticationEntryPoint.class);
    private String loginFormUrl;

    public AjaxAwareAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
        this.loginFormUrl = loginFormUrl;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        String ajaxHeader = request.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equals(ajaxHeader)) {
            log.info("Ajax Request denied session expired back to login page");
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Ajax Request Denied(Session Expired)");
        } else {
            super.commence(request, response, authException);
        }
    }

    @Override
    public String getLoginFormUrl() {
        return loginFormUrl;
    }

    public void setLoginFormUrl(String loginFormUrl) {
        this.loginFormUrl = loginFormUrl;
    }
}
