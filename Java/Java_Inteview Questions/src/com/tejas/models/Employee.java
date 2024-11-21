package com.tejas.models;

public class Employee {
	int empid;
	double salary;
	String name;
	public Employee(int empid, double salary, String name) {
		super();
		this.empid = empid;
		this.salary = salary;
		this.name = name;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", salary=" + salary + ", name=" + name + "]";
	}
	
	
	
	
}
