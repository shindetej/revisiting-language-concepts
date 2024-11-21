package com.practice.stream;

import java.util.List;
import java.util.function.Predicate;

public class DemoFilter {

	public static void main(String[] args) {
		List<Employee> list = Employee.getEmployeeList();
		
		
		//filter() API USE : Used to filter elements based on a condition (predicate).
		System.out.println("USE OF PREDICATE TO GET EMPLOYEE : WHOSE SALARY LESS THAN 50k");
		// A Predicate in Java is a functional interface that represents a single argument function that returns a boolean value.
		Predicate<Employee> salaryCondition = new Predicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				// TODO Auto-generated method stub
				return t.getSalary() < 50000;
			}
		};
		list.stream().filter(salaryCondition).forEach(n-> System.out.println(n));
		
		System.out.println("\nUSE OF LAMBDA IN PREDICATE :  Name starts with K");
		Predicate<Employee> sc =  emp -> emp.getName().startsWith("K");
		list.stream().filter(sc).forEach(n-> System.out.println(n));
		
		
		System.out.println("\nUSE OF LAMBDA IN FILTER  :  SALARY GREATER THAN 80k");
		list.stream().filter(e->e.getSalary() > 80000 ).forEach(n-> System.out.println(n));
		
		
	}

}
