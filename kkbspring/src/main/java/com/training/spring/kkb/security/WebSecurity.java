package com.training.spring.kkb.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		    .antMatchers("/servlet/**")
		    .hasAuthority("yetkili")
		    .antMatchers("/**")
		    .authenticated()
		    .and()
		    .httpBasic();
	}
}
