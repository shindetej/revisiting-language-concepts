package com.tms.openclose;

public class Circle extends Shape {

	int radius;

	public Circle(int radius) {
		this.radius = radius;
	}

	public void calculateArea() {
		System.out.println("Area : "+ (Math.PI*this.radius*this.radius));
	}

}
