package com.training.spring.kkb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetails implements UserDetailsService {

	@Autowired
	private BCryptPasswordEncoder cpe;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username.equals("osman")) {
			return User.builder()
			           .username("osman")
			           .password(cpe.encode("1234"))
			           .authorities("yetkili")
			           .build();
		} else if (username.equals("ali")) {
			return User.builder()
			           .username("ali")
			           .password(cpe.encode("1234"))
			           .authorities("normal")
			           .build();
			
		}
		throw new UsernameNotFoundException("user yok");
	}

}
