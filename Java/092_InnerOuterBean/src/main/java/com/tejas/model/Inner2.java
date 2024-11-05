package com.tejas.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Scope("prototype")
public class Inner2 {
	
	@PostConstruct
	public void init() {
		System.out.println("Inner2 bean post construct called !!!");
		
	}
	
	
}
