package com.practice.stream;

import java.util.Arrays;
import java.util.List;

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
	
	public static List<Employee> getEmployeeList() {
		List<Employee> empList = Arrays.asList(new Employee(1, 12000, "Tejas"), new Employee(2, 90000, "Abhinav"),
				new Employee(1, 50000, "Shantanu"), new Employee(1, 90000, "Kaustubh"), new Employee(1, 78000, "Raj"),
				new Employee(1, 47000, "Rajendra"), new Employee(1, 78000, "Kiran"));
		
		return empList;
	}
	
	
}
