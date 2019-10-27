package com.carljmosca.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"com.carljmosca.demo"})
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private DemoBasicAuthenticationEntryPoint authenticationEntryPoint;
    
    public final static String ROLE_ADMIN = "ADMIN";
    public final static String ROLE_USER = "USER";

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/rest/insecure/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .authenticationEntryPoint(authenticationEntryPoint);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication().withUser("user").password(encoder.encode("passw0rd")).roles(ROLE_USER);
        auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("Passw0rD")).roles(ROLE_USER, ROLE_ADMIN);
    }

}
