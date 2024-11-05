package com.tejas.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Scope("singleton")
public class Outer3   {
	
	@Autowired
	Inner3 inner;
	

	@PostConstruct
	public void init() {
		System.out.println("Outer3 bean post construct called !!!");
	}
	
	@Lookup
	public Inner3 getInner() {
		return null;
	}


	
}
