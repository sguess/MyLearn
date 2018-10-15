package com.sguess.secrity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthSucessHandler authSucessHander;
    @Autowired
    private APIAuthenticationEntryPoint authEntityPoint;
    @Autowired
    private AuthAccessDeniedHandler authAccessDeniedHandel;
    @Autowired
    private AdAuthenticationProvider adProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(adProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin", "/admin01").hasAnyRole("Admin")
                .antMatchers("/enduser", "/enduser01").hasAnyRole("EndUser")
                .antMatchers("/normal", "/normal01").hasAnyRole("Normal")
                .antMatchers("/api/**").hasAnyRole("API")
                .antMatchers("/img/**", "/js/**", "css/**", "/webjars/**").permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin().successHandler(authSucessHander)
                .loginPage("/login").failureUrl("/login? error")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .httpBasic().realmName("API").authenticationEntryPoint(authEntityPoint)
                .and()
                .exceptionHandling().accessDeniedHandler(authAccessDeniedHandel);
        http.csrf().disable();
        http.exceptionHandling().authenticationEntryPoint(new AjaxAwareAuthenticationEntryPoint("/login"));
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}

