package com.tejas;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


public class Rectangle implements QuadShape,InitializingBean,DisposableBean,BeanNameAware{
	private int length;
	private int breadth;
	private String name;
	
	public Rectangle() {
		System.out.println("In  Rectangle()");
	}
	
	public Rectangle(int length, int breadth) {
		System.out.println("In  Rectangle(int,int)");
		this.length = length;
		this.breadth = breadth;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		System.out.println("In  setLength(int)");
		this.length = length;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		System.out.println("In  setBreadth(int)");
		this.breadth = breadth;
	}
	public int calcArea() {
		System.out.println("In "+this.name+".calcArea()");
		return this.length*this.breadth;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("In "+this.name+".DisposableBean.destroy()");
		
	}

	
	@PostConstruct
	public void rectangleInit() {
		System.out.println("In rectangleInit() using @PostConstruct Annotation");
	}
	
	@PreDestroy
	public void rectangleDestroy() {
		System.out.println("In rectangleDestroy() using @PreDestroy Annotation");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("In "+this.name+".InitializingBean.afterPropertiesSet()");
	}
	
	@Override
	public void setBeanName(String name) {
		this.name = name;
		System.out.println("In "+this.name+".BeanNameAware.setBeanName()");
		
	}
	
	

}
