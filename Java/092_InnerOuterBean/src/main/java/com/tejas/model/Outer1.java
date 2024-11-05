package com.tejas.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Scope("singleton")
public class Outer1 {
	
	@Autowired
	Inner1 inner;
	
	@PostConstruct
	public void init() {
		System.out.println("Outer1 bean post construct called !!!");
	}

	public Inner1 getInner() {
		return inner;
	}

	public void setInner(Inner1 inner) {
		this.inner = inner;
	}
	
	
}
