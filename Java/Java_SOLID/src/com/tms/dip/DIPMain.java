package com.tms.dip;

public class DIPMain {
	public static void main(String[] args) {
		Switchable bulb = new LightBulb();
		Switch bulbSwitch = new Switch(bulb);

		bulbSwitch.toggleSwitch(true);
		bulbSwitch.toggleSwitch(false);
	}
}
