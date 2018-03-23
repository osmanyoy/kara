package com.training.spring.security;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class UserObject {
	
	@Id
	@GeneratedValue
	private long userId;
	
	@Size(min=6,max=20)
	@NotNull
	@Column(unique=true,nullable=false,length=20)
	private String username;
	
	@NotNull
	@Column(unique=false,nullable=false)
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER,cascade= {CascadeType.DETACH})
	private List<RoleObject> roles;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<RoleObject> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleObject> roles) {
		this.roles = roles;
	}
	
	
}
