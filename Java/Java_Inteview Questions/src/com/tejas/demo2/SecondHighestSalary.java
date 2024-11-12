package com.tejas.demo2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SecondHighestSalary {

	public static void main(String[] args) {
		List<Employee> empList = Arrays.asList(new Employee(1, 12000, "Tejas"), new Employee(2, 90000, "Abhinav"),
				new Employee(1, 50000, "Shantanu"), new Employee(1, 90000, "Kaustubh"), new Employee(1, 78000, "Raj"),
				new Employee(1, 47000, "Rajendra"), new Employee(1, 78000, "Kiran"));

		getNthHighestSalary(empList, 2);
		getCountOfEmployeesGroupBySalaries(empList);
	}
	
	
	
	/*
	 * 1. Get distinct salary in using SET
	 * 2. Sort it to descending(high 1st) using revered
	 * */
	public static void getNthHighestSalary(List<Employee> empList, Integer nth) {
		Set<Double> setOfUniqueSalaries = empList.stream().map(emp -> emp.getSalary()) // 1. get salary from employee
																						// object
				.collect(Collectors.toSet()); // 2. add it to the set (unique salaries)

		double nthHighestSalary = setOfUniqueSalaries.stream() // created new stream to make list from set (to get indexed based access)
				.sorted(Comparator.reverseOrder()) // descending sorting order
//				.sorted((n1,n2)-> n2.compareTo(n1)) // descending sorting order
				.collect(Collectors.toList()) // to list
				.get(nth - 1); // get n- 1 salary

		empList.stream().filter(emp -> emp.getSalary() == nthHighestSalary).collect(Collectors.toList())
				.forEach(n -> System.out.println(n.getName()));
		System.out.println("--------------\n" + nth + "th highest  salary given is :" + nthHighestSalary);

	}

	public static void getCountOfEmployeesGroupBySalaries(List<Employee> list) {
		System.out.println("\n\nCounting Number Of Employees For Each Salary Offered : ");
		list.stream().collect(Collectors.groupingBy((Employee k) -> k.getSalary(), Collectors.counting()))
				.forEach((K, V) -> System.out.println(K + " : " + V));
	}

}
