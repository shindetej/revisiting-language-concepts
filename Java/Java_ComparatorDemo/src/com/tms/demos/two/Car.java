package com.tms.demos.two;

public class Car implements Comparable<Car> {
	String model;
	Owner owner;
	public Car(String model, Owner owner) {
		super();
		this.model = model;
		this.owner = owner;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	
	@Override
	public String toString() {
		return "Car [model=" + model + ", owner=" + owner + "]";
	}
	
	@Override
	public int compareTo(Car o) {
		return this.model.compareTo(o.model);
		
	}
	
	
	
}
