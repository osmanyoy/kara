package com.training.spring.kkb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void conf(AuthenticationManagerBuilder managerBuilder,MyUserDetails myUserDetails) {
		try {
			BCryptPasswordEncoder passwordEncoder = passwordEncoder();
			managerBuilder.userDetailsService(myUserDetails)
			              .passwordEncoder(passwordEncoder);
		} catch (Exception e) {
		}
	}

//	@Autowired
//	public void conf(AuthenticationManagerBuilder managerBuilder) {
//		try {
//			BCryptPasswordEncoder passwordEncoder = passwordEncoder();
//			managerBuilder.inMemoryAuthentication()
//			              .passwordEncoder(passwordEncoder)
//			              .withUser("osman")
//			              .password(passwordEncoder.encode("1234"))
//			              .authorities("yetkili")
//			              .and()
//			              .withUser("ali")
//			              .password(passwordEncoder.encode("123456"))
//			              .authorities("normal");
//		} catch (Exception e) {
//		}
//	}

}
