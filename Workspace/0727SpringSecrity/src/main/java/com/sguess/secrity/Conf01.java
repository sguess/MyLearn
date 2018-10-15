package com.sguess.secrity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity
public class Conf01 extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Admin").password("123").authorities("ROLE_Admin");
        auth.inMemoryAuthentication().withUser("Tom").password("123").roles("User");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin", "/admin01").hasAnyRole("Admin")
                .antMatchers("/enduser", "/enduser01").hasAnyAuthority("ROLE_User")
                .antMatchers("/normal", "/normal01").hasAnyRole("Normal")
                .antMatchers("/api/**").hasAnyAuthority("API")
                .antMatchers("/img/**", "/js/**", "css/**", "/webjars/**").permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
//                .formLogin().loginProcessingUrl("/login")
//                .formLogin().successHandler(authSucessHander)
                .formLogin()
                .loginPage("/login").failureUrl("/login?error")
                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .and()
//                .httpBasic().realmName("API").authenticationEntryPoint(authEntityPoint)
//                .and()
//                .exceptionHandling().accessDeniedHandler(authAccessDeniedHandel);
        ;
        http.csrf().disable();
//        http.exceptionHandling().authenticationEntryPoint(new AjaxAwareAuthenticationEntryPoint("/login"));
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}

