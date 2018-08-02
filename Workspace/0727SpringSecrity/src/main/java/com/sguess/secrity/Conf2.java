package com.sguess.secrity;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//@EnableWebSecurity
public class Conf2 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .requestMatchers()
//                .antMatchers("/api/**","/oauth/**")
//                .and()
//                .authorizeRequests()
//                .antMatchers("/**").hasRole("USER")
//                .and()
//                .httpBasic();
        http.authorizeRequests().antMatchers("/common").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        http.formLogin().permitAll();
//        http.authorizeRequests().has
//      http.requestMatchers().antMatchers("/common")
  }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
        UserDetailsService userDetailsService=new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                if (username.equals("a")){
                    return new UserDetails() {
                        @Override
                        public Collection<? extends GrantedAuthority> getAuthorities() {
                            List<GrantedAuthority> list=new ArrayList();
                            SimpleGrantedAuthority authority=new SimpleGrantedAuthority("Admin");
                            return list;
                        }

                        @Override
                        public String getPassword() {
                            return "abc";
                        }

                        @Override
                        public String getUsername() {
                            return "a";
                        }

                        @Override
                        public boolean isAccountNonExpired() {
                            return true;
                        }

                        @Override
                        public boolean isAccountNonLocked() {
                            return true;
                        }

                        @Override
                        public boolean isCredentialsNonExpired() {
                            return true;
                        }

                        @Override
                        public boolean isEnabled() {
                            return true;
                        }
                    };
                }else{
                    return null;
                }

            }
        };
        auth.userDetailsService(userDetailsService);
    }
}