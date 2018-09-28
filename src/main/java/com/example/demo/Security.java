package com.example.demo;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class Security extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login.html")
        .loginProcessingUrl("/loginx");
        http.authorizeRequests()
                .antMatchers("/login.html").permitAll();
        http.authorizeRequests()
                .antMatchers("/x").hasAuthority("admin");
        http.authorizeRequests()
                .antMatchers("/xx*").authenticated();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
        http.sessionManagement().maximumSessions(1);
        http.sessionManagement().sessionAuthenticationErrorUrl("/login.html");
        http.requiresChannel().antMatchers("/xxx").requiresSecure();
        http.csrf().disable();


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
