package com.practice.stream;

import java.util.List;
import java.util.function.Function;

public class DemoMap {

	public static void main(String[] args) {
		List<Employee> list = Employee.getEmployeeList();
	
		//map() API USE : Transforms each element of the stream into another form, typically used to extract fields or convert data types.
		
		System.out.println("-----\n");
		System.out.println("USE OF MAP : GIVE NAME OF EMPLOYEES");
		// A Function<T,R> in Java is a functional interface  that takes an argument of type T and returns a result of type R.
		Function<Employee,String> func =  new Function<Employee,String>(){
			 public String apply(Employee e) { 
				 return e.getName();
			 }
		};
		list.stream().map(func).forEach(n->System.out.println(n));
		
		System.out.println("-----\n");
		System.out.println("USE OF MAP : GIVE SALARIES WITH 10% rise OF EMPLOYEES");
		
		Function<Employee,Employee> func1 =  e-> {e.setSalary(Math.round(e.getSalary()*1.10)/1.0); return e;};
		list.stream().map(func1).forEach(n->System.out.println(n));
		
		System.out.println("-----\n");
		System.out.println("USE OF MAP : USE METHOD REFERNCE TO GET NAMES");
		list.stream().map(Employee::getName).forEach(n->System.out.println(n));
		
		
	}

}
