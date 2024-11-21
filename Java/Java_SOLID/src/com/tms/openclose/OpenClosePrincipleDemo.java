package com.tms.openclose;

public class OpenClosePrincipleDemo {
	public static void main(String[] args) {
		Shape r = new Rectangle(10,20);	
		Shape t = new Triangle(10,20);	
		Shape c = new Circle(20);
		
		r.calculateArea();
		c.calculateArea();
		t.calculateArea();
	}
}
