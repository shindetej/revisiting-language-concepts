package com.dp.withPattern;

import com.dp.withPattern.strategy.SportsDrivingStrategy;

public class OffroadVehicle extends Vehicle {

	public OffroadVehicle() {
		super(new SportsDrivingStrategy());
		
	}
	
	
}
