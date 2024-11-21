package com.tms.demos.two;

public class Owner implements Comparable<Owner> {
	int age;
	String name;
	String address;

	public Owner(int age, String address, String name) {
		super();
		this.age = age;
		this.name = name;
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Owner [age=" + age + ", name=" + name + ", address=" + address + "]";
	}

	@Override
	public int compareTo(Owner o) {
		// descending order
		return o.getName().compareTo(this.getName());
	}

}
