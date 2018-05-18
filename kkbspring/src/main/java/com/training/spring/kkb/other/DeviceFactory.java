package com.training.spring.kkb.other;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

@Component
public class DeviceFactory implements BeanFactory{

	@Override
	public Object getBean(String name) throws BeansException {
		return new Device();
	}

	@Override
	public <T> T getBean(String name,
	                     Class<T> requiredType)
	        throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getBean(String name,
	                      Object... args)
	        throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getBean(Class<T> requiredType) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getBean(Class<T> requiredType,
	                     Object... args)
	        throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsBean(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
		return true;
	}

	@Override
	public boolean isPrototype(String name) throws NoSuchBeanDefinitionException {
		return false;
	}

	@Override
	public boolean isTypeMatch(String name,
	                           ResolvableType typeToMatch)
	        throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTypeMatch(String name,
	                           Class<?> typeToMatch)
	        throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Class<?> getType(String name) throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getAliases(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
