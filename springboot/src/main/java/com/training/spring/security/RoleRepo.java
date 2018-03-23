package com.training.spring.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<RoleObject, Long>{
	RoleObject findByRolename(String roleName);
}
