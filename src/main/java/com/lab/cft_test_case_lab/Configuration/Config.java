package com.lab.cft_test_case_lab.Configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/desktop/add").permitAll()
                .antMatchers("/desktop/change").permitAll()
                .antMatchers("/desktop/delete").permitAll()
                .antMatchers("/desktop/see").permitAll()
                .antMatchers("/drives/add").permitAll()
                .antMatchers("/drives/change").permitAll()
                .antMatchers("/drives/delete").permitAll()
                .antMatchers("/drives/see").permitAll()
                .antMatchers("/monitor/add").permitAll()
                .antMatchers("/monitor/change").permitAll()
                .antMatchers("/monitor/delete").permitAll()
                .antMatchers("/monitor/see").permitAll()
                .antMatchers("/notebook/add").permitAll()
                .antMatchers("/notebook/change").permitAll()
                .antMatchers("/notebook/delete").permitAll()
                .antMatchers("/notebook/see").permitAll();

    }

}
