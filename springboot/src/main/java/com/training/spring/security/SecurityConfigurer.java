package com.training.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer {
	
	@Bean
	public BCryptPasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService createUserDetailsService() {
		return new MyUserDetails();
	}

	@Autowired
	public void initSecurity(AuthenticationManagerBuilder managerBuilder) {
		try {
			BCryptPasswordEncoder enc = PasswordEncoder();
			UserDetailsService createUserDetailsService = createUserDetailsService();
			managerBuilder.userDetailsService(createUserDetailsService).passwordEncoder(enc);
//			managerBuilder.inMemoryAuthentication().passwordEncoder(enc)
//			              .withUser("osman")
//			              .password(enc.encode("1234"))
//			              .roles("ADMIN")
//			              .and()
//			              .withUser("mehmet")
//			              .password(enc.encode("4321"))
//			              .roles("USER");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
