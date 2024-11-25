package com.dp.withPattern.strategy;

public class SportsDrivingStrategy implements DrivingStrategy {

	@Override
	public void drive() {
		System.out.println("Sports Driving Strategy");
	}

}
