package com.practice.sorting;

import java.util.Comparator;

public class EmployeeComparators {

	// way 1
	public static Comparator<Employee> byEmpId = Comparator.comparing(Employee::getEmpId);

	// other way to solve
	public static Comparator<Employee> byName = Comparator.comparing(Employee::getName);

	public static Comparator<Employee> bySalary = (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary());
	public static Comparator<Employee> byDate = Comparator.comparing(Employee::getDateOfJoining);

}
