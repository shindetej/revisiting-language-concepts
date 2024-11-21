package com.tms.openclose;

public class Triangle extends Shape {

	int base;
	int height;
	
	
	public Triangle(int base, int height) {
		this.base = base;
		this.height = height;
	}


	@Override
	void calculateArea() {
		System.out.println("Area :"+ (0.5*this.base*this.height));
		
	}
	
}
