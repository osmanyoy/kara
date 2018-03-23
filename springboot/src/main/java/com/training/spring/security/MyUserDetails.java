package com.training.spring.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetails implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(MyUserDetails.class);

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			UserObject userObject = userRepo.findByUsername(username);
			if (userObject != null) {
				if (logger.isDebugEnabled()) {
					logger.debug("[MyUserDetails][loadUserByUsername] : I have got Username : " + username + " Roles : " + userObject.getRoles());
				}
				List<RoleObject> roles = userObject.getRoles();
				List<GrantedAuthority> authorities = new ArrayList<>();
				for (RoleObject roleObject : roles) {
					authorities.add( new SimpleGrantedAuthority(roleObject.getRolename()));
				}
				return new User(username, userObject.getPassword() , authorities);
			}
		} catch (Exception e) {
			logger.error("Error : " + e.getMessage(),
			             e);
		}
		throw new UsernameNotFoundException("User : " + username + " is not valid");
	}

}






