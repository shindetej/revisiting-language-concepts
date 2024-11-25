package com.dp.withPattern;

import com.dp.withPattern.strategy.DrivingStrategy;
import com.dp.withPattern.strategy.NormalDrivingStrategy;

public class GoodsVehicle extends Vehicle {

	public GoodsVehicle() {
		super(new NormalDrivingStrategy());
	}
	
	
}
