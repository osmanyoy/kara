package com.training.spring.aop;

import static org.hamcrest.CoreMatchers.nullValue;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPEnforcer {

	@Pointcut("execution(* com.training.spring.aop.Callee.hello(..)) && args(str)")
	public void method(String str) {

	}

	@Before("method(str)")
	public void beforeCallerMethod(JoinPoint jp,
	                               String str) {
		System.out.println("jp : " + jp.toLongString());
		System.out.println("Before çağrıldı .Input : " + str);
	}

	@After("method(str)")
	public void afterCallerMethod(JoinPoint jp,
	                              String str) {
		System.out.println("jp : " + jp.toLongString());
		System.out.println("After çağrıldı");
	}

	@AfterReturning(pointcut = "method(str)", returning = "retStr")
	public void afterReturningMethod(JoinPoint jp,
	                                 String str,
	                                 String retStr) {
		System.out.println("jp : " + jp.toLongString());
		System.out.println("After Returning çağrıldı : " + retStr);
	}

	@AfterThrowing(pointcut = "method(str)", throwing = "ex")
	public void afterExceptionMethod(JoinPoint jp,
	                                 String str,
	                                 Exception ex) {
		System.out.println("jp : " + jp.toLongString());
		System.out.println("After Throwing çağrıldı : " + ex);
	}
	
	@Around("method(str)")
	public Object aroundInv(ProceedingJoinPoint joinPoint,String str) {
		try {
			Object[] args = joinPoint.getArgs();
			String string = (String)args[0];
			string +=  "test";
			args[0] = string;
			
			Object proceed = joinPoint.proceed(args);
			String strRet = (String) proceed;
			strRet = "Around ek : " + strRet;
			return strRet;
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(AOPEnforcer.class);
	
	@Around("within(com.training.spring.aop.Callee) && @annotation(log)")
	public Object aroundInv(ProceedingJoinPoint joinPoint,LogAt log) {
		try {
			Object[] args = joinPoint.getArgs();
			String string = (String)args[0];
			string +=  "test";
			args[0] = string;
			
			logger.info("join point : " + joinPoint.toLongString() + " extra : " + log.extraData());
			
			Object proceed = joinPoint.proceed(args);
			String strRet = (String) proceed;
			strRet = "Around ek : " + strRet;
			return strRet;
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
	

}








