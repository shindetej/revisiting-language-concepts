package com.dp.withPattern;

import com.dp.withPattern.strategy.DrivingStrategy;

public class Vehicle {
	DrivingStrategy drivingStrategy;

	public Vehicle(DrivingStrategy drivingStrategy) {
		this.drivingStrategy = drivingStrategy;
	}
	
	public void drive() {
		drivingStrategy.drive();
	}
}
