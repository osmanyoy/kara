package com.training.spring.kkb.postprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

// @Component
public class BeanPostProcess implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean,
	                                              String beanName)
	        throws BeansException {
		System.out.println(beanName);
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean,
		                                                               beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean,
	                                             String beanName)
	        throws BeansException {
		return BeanPostProcessor.super.postProcessAfterInitialization(bean,
		                                                              beanName);
	}
}
