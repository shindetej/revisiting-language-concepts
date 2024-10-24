package com.tejas;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class RectangleBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		if (bean instanceof QuadShape)
			System.out.println("In BeanPostProcessor.postProcessAfterInitialization()");
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof QuadShape)    
			System.out.println("In BeanPostProcessor.postProcessBeforeInitialization()");
		return bean;
	}
}
