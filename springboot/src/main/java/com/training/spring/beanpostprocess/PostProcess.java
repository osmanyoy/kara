package com.training.spring.beanpostprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

//@Component
public class PostProcess implements BeanPostProcessor{
	@Override
	public Object postProcessAfterInitialization(Object bean,
	                                             String beanName)
	        throws BeansException {
		
		System.out.println(beanName + " : "+  bean);
		return bean;
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean,
	                                              String beanName)
	        throws BeansException {
		System.out.println(beanName + " : "+  bean);
		return bean;
	}
}	
