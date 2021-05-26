package com.mytests.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;


@Configuration
@EnableWebSecurity

public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    public void configureSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("irina").password("jolt").roles("PARENT","ADMIN").and()
                .withUser("andrey").password("jolt").roles("PARENT").and()
                .withUser("admin").password("jolt").roles("ADMIN");
    }
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .mvcMatchers("/home").hasAnyAuthority("ROLE_PARENT")
                .regexMatchers("/secret").hasAnyRole("ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/for_all")).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()

        ;
    }
    }



