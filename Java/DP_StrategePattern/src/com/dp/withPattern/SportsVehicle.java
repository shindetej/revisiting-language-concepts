package com.dp.withPattern;

import com.dp.withPattern.strategy.DrivingStrategy;
import com.dp.withPattern.strategy.SportsDrivingStrategy;

public class SportsVehicle extends Vehicle {

	public SportsVehicle() {
		super(new SportsDrivingStrategy());
	}
	
	
}
