package com.training.spring.kkb.security;

import java.util.Collection;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAOP {

	@Around("@within(org.springframework.web.bind.annotation.RestController) && @annotation(sec)")
	public Object around(ProceedingJoinPoint pjp,
	                     MySecurity sec) {
		try {
			Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext()
			                                                                          .getAuthentication()
			                                                                          .getAuthorities();
			boolean proceed = false;
			for (GrantedAuthority grantedAuthority : authorities) {
				if (grantedAuthority.getAuthority()
				                    .equals(sec.authority())) {
					proceed = true;
				}
			}
			if (proceed) {
				return pjp.proceed();
			}
			return null;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
