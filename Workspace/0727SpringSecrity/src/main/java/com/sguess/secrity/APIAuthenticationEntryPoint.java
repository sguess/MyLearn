package com.sguess.secrity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sguess.beans.APIMessage;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@Component
public class APIAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
    private String REALM_NAME = "API_NAME";

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.addHeader("WWW-Authenticate", "Basic Realm=" + response);

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter printWriter = response.getWriter();
        String outputStr = new ObjectMapper().writeValueAsString(new APIMessage(HttpStatus.UNAUTHORIZED.toString(), authException.getMessage(), ""));
        printWriter.println(outputStr);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.setRealmName(REALM_NAME);
        super.afterPropertiesSet();
    }
}
