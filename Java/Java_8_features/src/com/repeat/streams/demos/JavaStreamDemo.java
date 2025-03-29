package com.repeat.streams.demos;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class JavaStreamDemo {
	public static void main(String[] args) {
		List<Employee> empList = Employee.getEmployeeTestList();
		System.out.println(empList);
		getEmployeeOlderThanAge(empList, 20);
		getTotalSalaryCost(empList);
		pringAllNames(empList);
		getNthHighestSalary(empList, 2);
		
	}

	// Filter employees older than 35
	private static void getEmployeeOlderThanAge(List<Employee> emps, int age) {
		List<Employee> empList = emps.stream().filter(s -> s.getAge() > age).toList();
		System.out.println("***** Employee List With Age More Than " + age + " *****\n" + empList);
	}

	// Extract a list of employee names
	private static void pringAllNames(List<Employee> emps) {
		List<String> empList = emps.stream()
								.map(Employee::getName)
								.toList();
		System.out.println("***** Employee Name List *****\n" + empList);
	}

	// Find the sum of all employee salaries
	private static void getTotalSalaryCost(List<Employee> emps) {
		Optional<Double> salaryCost= emps.stream()
								.map(Employee::getSalary).reduce(Double::sum);
		System.out.println("***** Total Salary Cost On Employees Using Reduce : "+salaryCost.get());
		Double salaryCost1= emps.stream()
				.mapToDouble(Employee::getSalary).sum();
		System.out.println("***** Total Salary Cost On Employees Using mapToDouble().sum() : "+salaryCost1);
	}

	// Find the second-highest salary given by the organization
	private static void getNthHighestSalary(List<Employee> emps, int nth) {
		Double nthSalary= emps.stream()
							.map(Employee::getSalary)
							.distinct()
							.sorted(Comparator.reverseOrder())
							.skip(nth-1)
							.findFirst().orElse((double) 0);
		System.out.println("***** "+nth + "th highest salary is :" +nthSalary);					
	}
}
