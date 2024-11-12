package com.tejas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//@ComponentScan
//@Configuration
//@AutoConfiguration
public class SpringBeanLifeCycleDemo implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBeanLifeCycleDemo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hello Spring Boot!!");
		Rectangle rect1 = (Rectangle) context.getBean("rect1");
		System.out.println(rect1.calcArea());
		Rectangle rect2 = (Rectangle) context.getBean("rect2");
		System.out.println(rect2.calcArea());
	}
	
	

}
