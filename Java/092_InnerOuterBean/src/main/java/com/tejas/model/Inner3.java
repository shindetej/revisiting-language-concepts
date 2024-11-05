package com.tejas.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Scope("prototype")
public class Inner3 {
	
	@PostConstruct
	public void init() {
		System.out.println("Inner3 bean post construct called !!!");
		
	}
	
	
}
