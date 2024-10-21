package com.tejas;

import org.springframework.context.annotation.Configuration;


public class Rectangle {
	private int length;
	private int breadth;
	
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
		System.out.println("In  calcArea()");
		return this.length*this.breadth;
	}
	
	

}
