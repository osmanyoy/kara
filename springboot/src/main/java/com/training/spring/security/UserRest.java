package com.training.spring.security;

import java.util.Arrays;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class UserRest {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private BCryptPasswordEncoder enc;
	
	@RequestMapping("/create/{username}/{password}/{role}")
	public String createUser(@NotNull @PathVariable("username") String username,
	                         @NotNull @PathVariable("password") String password,
	                         @NotNull @PathVariable("role")String role) {
		RoleObject findByRolename = roleRepo.findByRolename(role);
		if (findByRolename == null) {
			findByRolename = new RoleObject();
			findByRolename.setRolename(role);
			findByRolename = roleRepo.save(findByRolename);
		}
		UserObject findByUsername = userRepo.findByUsername(username);
		if (findByUsername != null) {
			return "User already in DB";
		}
		UserObject userObject = new UserObject();
		userObject.setUsername(username);
		userObject.setPassword(enc.encode(password));
		userObject.setRoles(Arrays.asList(findByRolename));
		UserObject save = userRepo.save(userObject);
		return "OK";
	}
	
	@RequestMapping("/test")
	public String test1() {
		return "OK";
	}
	
}
