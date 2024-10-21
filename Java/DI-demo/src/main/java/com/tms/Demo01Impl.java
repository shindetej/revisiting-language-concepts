package com.tms;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo01Impl {
	public static void main(String[] args) {
		
		// Dependency Injected Demo
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		// rect 2 is created is using property i.e setter based DI (refer beans.xml
		Rectangle rect1 = (Rectangle) context.getBean("rect1");
		System.out.println(rect1.calcArea());
		
		
		// rect 2 is created is using contructor-arg i.e constructor based DI
		Rectangle rect2 = (Rectangle) context.getBean("rect2");
		System.out.println(rect2.calcArea());
		
		context.close();
	}
}

/*
In  Rectangle()
In  setLength(int)
In  setBreadth(int)
In  Rectangle(int,int)
In  calcArea()
50
In  calcArea()
200
*/
