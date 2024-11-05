package com.tejas.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Scope("singleton")
public class Outer2 implements ApplicationContextAware {
	
	@Autowired
	Inner2 inner;
	
	ApplicationContext context;
	
	@PostConstruct
	public void init() {
		System.out.println("Outer2 bean post construct called !!!");
	}
	
	public Inner2 getInner() {
		return this.context.getBean(Inner2.class);
	}

	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
		
	}
	
}
