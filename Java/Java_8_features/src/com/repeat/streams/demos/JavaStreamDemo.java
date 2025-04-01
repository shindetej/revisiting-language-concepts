package com.repeat.streams.demos;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class JavaStreamDemo {
	public static void main(String[] args) {
		List<Employee> empList = Employee.getEmployeeTestList();
		System.out.println(empList);

		getEmployeeOlderThanAge(empList, 30);

		getTotalSalaryCost(empList);

		pringAllNames(empList);

		getNthHighestSalary(empList, 2);

		getDepartmentWiseEmployeesCount(empList);

		getEmployeeWithHighestSalary(empList);

	}

	// Filter employees older than 35
	private static void getEmployeeOlderThanAge(List<Employee> emps, int age) {
		List<Employee> empList = emps.stream().filter(s -> s.getAge() > age).toList();
		System.out.println("\n***** Employee List With Age More Than " + age + " *****\n" + empList);
	}

	// Extract a list of employee names
	private static void pringAllNames(List<Employee> emps) {
		List<String> empList = emps.stream().map(Employee::getName).toList();
		System.out.println("\n***** Employee Name List *****\n" + empList);
	}

	// Find the sum of all employee salaries
	private static void getTotalSalaryCost(List<Employee> emps) {
		Optional<Double> salaryCost = emps.stream().map(Employee::getSalary).reduce(Double::sum);
		System.out.println("\n***** Total Salary Cost On Employees Using Reduce : " + salaryCost.get());
		Double salaryCost1 = emps.stream().mapToDouble(Employee::getSalary).sum();
		System.out.println("\n***** Total Salary Cost On Employees Using mapToDouble().sum() : " + salaryCost1);
	}

	// Find the second-highest salary given by the organization
	private static void getNthHighestSalary(List<Employee> emps, int nth) {
		Double nthSalary = emps.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder())
				.skip(nth - 1).findFirst().orElse(null);
		System.out.println("\n***** " + nth + "th highest salary is :" + nthSalary);
	}

	// Find department-wise count of employees
	private static void getDepartmentWiseEmployeesCount(List<Employee> employees) {
		Map<String, Long> mapDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("\n***** get department-wise count of employees : \n" + mapDept);
	}

	// Find the employee with the highest salary
	private static void getEmployeeWithHighestSalary(List<Employee> employees) {
		System.out.println("\n*****get employee with highest salary using sort reverse: ");
		employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst()
				.ifPresent(System.out::println);
		System.out.println("\n*****get employee with highest salary using max() efficient approach : ");
		employees.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);
	}

	// Group employees by department and calculate their average salary
	// Get a comma-separated string of all employee names sorted alphabetically
}
