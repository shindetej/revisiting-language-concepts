package com.practice.interfaces;

public class TestMain {
	public static void main(String[] args) {
			DupListInterface ci =  new DefaultAndStaticDemo();
			
			ci.existingMethod();
			ci.sort();
			ci.spliterator();
	}
}
