package com.sguess.secrity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class AdAuthenticationProvider implements AuthenticationProvider {
    private static final Logger LOG = LoggerFactory.getLogger(AdAuthenticationProvider.class);

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        LOG.info("Auth info" + authentication.getName() + "," + authentication.getCredentials().toString());
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        if (username.equals("Tom") && password.equals("123")) {
            LOG.info("Admin is login");
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_Admin"));
            return new UsernamePasswordAuthenticationToken(username, password, authorities);
        } else if (username.equals("Jerry") && password.equals("123")) {
            LOG.info("Jerry is login");
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("EndUser"));
            return new UsernamePasswordAuthenticationToken(username, password, authorities);
        } else if (username.equals("Api") && password.equals("123")) {
            LOG.info("API is login");
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("API"));
            return new UsernamePasswordAuthenticationToken(username, password, authorities);
        }
        LOG.info("Normal User is login");
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("Viewer"));
        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
