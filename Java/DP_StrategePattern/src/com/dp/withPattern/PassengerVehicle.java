package com.dp.withPattern;

import com.dp.withPattern.strategy.NormalDrivingStrategy;

public class PassengerVehicle extends Vehicle {

	public PassengerVehicle() {
		super(new NormalDrivingStrategy());
		
	}
	
	
}
