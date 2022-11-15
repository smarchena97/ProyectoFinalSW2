package com.uniquindio.app.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SeguridadAppConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserBuilder users = User.withDefaultPasswordEncoder();	
		
		auth.inMemoryAuthentication()
		.withUser(users.username("juan").password("123").roles("admin"))
		.withUser(users.username("pedro").password("111").roles("user"))
		.withUser(users.username("maria").password("222").roles("admin"))
		.withUser(users.username("laura").password("333").roles("user"));
	}

}
