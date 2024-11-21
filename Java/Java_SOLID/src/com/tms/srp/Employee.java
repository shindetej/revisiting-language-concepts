package com.tejas.srp;

// Employee handles only employee-related data.
public class Employee {
	private String name;
	private String department;

	public Employee(String name, String department) {
		this.name = name;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

}
