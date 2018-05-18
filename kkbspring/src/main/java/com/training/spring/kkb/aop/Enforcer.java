package com.training.spring.kkb.aop;

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
public class Enforcer {

	@Pointcut("execution(* com.training.spring.kkb.aop.Callee.hello(..)) && args(str)")
	public void method(String str) {

	}

	@Before("method(str)")
	public void once(JoinPoint jp,
	                 String str) {
		System.out.println("Önce Çalıştı : " + str + " jp : " + jp.toLongString());
	}

	@After("method(str)")
	public void sonra(JoinPoint jp,
	                  String str) {
		System.out.println("Sonra Çalıştı : " + str + " jp : " + jp.toLongString());
	}

	@AfterReturning(value = "method(str)", returning = "retVal")
	public void sonra2(JoinPoint jp,
	                   String str,
	                   String retVal) {
		System.out.println("Sonra Çalıştı : " + str + " retVal : " + retVal + " jp : " + jp.toLongString());
	}

	@AfterThrowing(value = "method(str)", throwing = "exp")
	public void sonra3(JoinPoint jp,
	                   String str,
	                   Exception exp) {
		System.out.println("Sonra Çalıştı : " + str + " exp : " + exp + " jp : " + jp.toLongString());
	}

	@Around("method(str)")
	public Object sonra4(ProceedingJoinPoint jp,
	                     String str) {

		try {
			Object[] args = jp.getArgs();
			if (args.length == 1) {
				System.out.println(args);
				args[0] = "mehmet";
			}

			Object proceed = jp.proceed(args);
			if (proceed instanceof String) {
				String string = (String) proceed;
				string += ".AOP";
				return string;
			}
			return proceed;
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	private Logger logger = LoggerFactory.getLogger(Enforcer.class);

	@Around("within(com.training.spring.kkb.aop.*) && @annotation(ml)")
	public Object sonra5(ProceedingJoinPoint jp,
	                     MyLog ml) {
		try {
			String msg = "Entering : " + jp.toLongString();
			writeLog(ml,
			         msg);
			Object proceed = jp.proceed();
			msg = "Exciting : " + jp.toLongString();
			writeLog(ml,
			         msg);

			return proceed;
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	private void writeLog(MyLog ml,
	                      String msg) {
		switch (ml.logType()) {
		case DEBUG: {
			logger.debug(msg);
			break;
		}
		case INFO: {
			logger.info(msg);
			break;
		}

		default:
			break;
		}
	}
}