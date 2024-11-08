package com.tms.demos.one;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 *
Write a Java program that reads a list of students (name, age, and grade) and performs the following:

	- Sort the list by grade in descending order.
	- Filter out students whose grade is below a certain threshold.
	- Use Java Streams API to perform these tasks efficiently.
*/
public class DemoMainOne {
	
	public static void main(String [] args) {
		System.out.print("Demo of comparator starts");
		
		List<Student> studentList =  StudentUtils.getList();
		System.out.println("Before sorting : "+studentList );
//		Collections.sort( studentList,(s1,s2)-> s1.getName().compareTo(s2.getName()));
//		System.out.println("------------ -------------- ---------");
//		System.out.println("After sorting : "+studentList );
		
		// Descending order 
		Collections.sort( studentList,(s1,s2)-> s2.getName().compareTo(s1.getName()));
		System.out.println("------------ -------------- ---------");
		System.out.println("After descending sorting : "+studentList );
		
		List<Student> listOfFirstClass =  studentList.stream().filter(student -> Integer.parseInt(student.getGrade())>= 60).toList();
		
//		listOfFirstClass.forEach(s -> System.out.println(s));
		System.out.println("\n------------ -------------- ---------");
		System.out.println("Student with first class : "+listOfFirstClass );
		
		List<String> nameOfStudents =  studentList.stream().map(Student::getName).collect(Collectors.toList());
		
		System.out.println("\n------------ -------------- ---------");
		System.out.println("Names List : "+nameOfStudents);
	}
}
