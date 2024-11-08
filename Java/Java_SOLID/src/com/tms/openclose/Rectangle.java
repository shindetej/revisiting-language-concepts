package com.tms.openclose;

public class Rectangle extends Shape {
    private int length;   
    private int breadth;
    
    public Rectangle(int length,int breadth) {
    	this.breadth=breadth;
    	this.length= length;
    }
	
	public void calculateArea() {
		System.out.println("Area :"+ (this.length*this.breadth));
	}
}
