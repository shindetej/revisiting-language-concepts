package com.tms.dip;

public class Switch {
	private final Switchable device;

	public Switch(Switchable device) {
		this.device = device; // Dependency injected
	}

	public void toggleSwitch(boolean isOn) {
		if (isOn) {
			device.turnOn();
		} else {
			device.turnOff();
		}
	}
}
