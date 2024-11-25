package com.dp.withPattern;

import com.dp.withPattern.strategy.NormalDrivingStrategy;

public class DemoMain {
	public static void main(String[] args) {
		Vehicle v = new OffroadVehicle();
		v.drive();
		
		v = new PassengerVehicle();
		v.drive();
		
		v = new SportsVehicle();
		v.drive();
		
		v = new GoodsVehicle();
		v.drive();
		
	
	}
}
