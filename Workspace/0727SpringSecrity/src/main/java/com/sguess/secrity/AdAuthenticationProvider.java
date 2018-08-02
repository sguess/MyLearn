package com.sguess.secrity;

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
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username=authentication.getName();
        String password=authentication.getCredentials().toString();
        if(username.equals("Tom")&&password.equals("123")){
            List<GrantedAuthority> authorities=new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("Admin"));
            return new UsernamePasswordAuthenticationToken(username,password,authorities);
        }else if(username.equals("Jerry")&&password.equals("123")){
            List<GrantedAuthority> authorities=new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("EndUser"));
            return new UsernamePasswordAuthenticationToken(username,password,authorities);
        }else if(username.equals("Api")&&password.equals("123")){
            List<GrantedAuthority> authorities=new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("API"));
            return new UsernamePasswordAuthenticationToken(username,password,authorities);
        }
        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("Viewer"));
        return new UsernamePasswordAuthenticationToken(username,password,authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
