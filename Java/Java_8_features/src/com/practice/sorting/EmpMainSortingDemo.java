package com.practice.sorting;

import java.util.Comparator;
import java.util.List;

public class EmpMainSortingDemo {
	public static void main(String[] args) {
		List<Employee> list = Employee.getEmployeeList();

		/***************** USING CLASS COMPARATORS **************************/
		// Sort by empId
		list.sort(EmployeeComparators.byEmpId);
		System.out.println("Sort Employee By Id : ");
		list.forEach(System.out::println);
		// Sort by empId
		list.sort(EmployeeComparators.byEmpId.reversed());
		System.out.println("\n---\nSort Employee By Id Desc: ");
		list.forEach(System.out::println);

		// Sort by name
		list.sort(EmployeeComparators.byName);
		System.out.println("Sort Employee By Name : ");
		list.forEach(System.out::println);

		// Sort by salary
		list.sort(EmployeeComparators.bySalary.reversed());
		System.out.println("\n---\nSort by salary employees (Descending order)");
		list.forEach(System.out::println);

		// Sort by date
		list.sort(EmployeeComparators.byDate);
		System.out.println("\n---\nSort by joining date in company");
		list.forEach(System.out::println);

		/******************* IN PLACE COMPARATOR USE PREFERED IF NOT ALL SORTING FIELDS REQUIRED *********/

		// Sort by salary
		list.sort(Comparator.comparing(Employee::getSalary));
		System.out.println("\n---\nSort by salary employees (Ascending order)");
		list.forEach(System.out::println);
		
		

	}
}
