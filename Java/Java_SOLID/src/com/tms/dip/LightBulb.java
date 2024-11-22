package com.tms.dip;

public class LightBulb implements Switchable {

	@Override
	public void turnOn() {
		System.out.println("LightBulb Turn ON");

	}

	@Override
	public void turnOff() {
		System.out.println("LightBulb Turn OFF");

	}

}
