package com.dp.withPattern.strategy;

public class NormalDrivingStrategy implements DrivingStrategy {

	@Override
	public void drive() {
		System.out.println("Normal Driving Strategy");
	}

}
