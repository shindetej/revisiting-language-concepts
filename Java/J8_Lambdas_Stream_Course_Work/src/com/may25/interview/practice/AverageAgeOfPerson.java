package com.may25.interview.practice;

import java.util.Arrays;
import java.util.List;

public class AverageAgeOfPerson {
	
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(new Person("Tejas",31),new Person("Hiralal",43),new Person("Sujay",28));
	
		// Average
		persons.stream()
			.mapToInt(p -> p.getAge())
			.average().ifPresentOrElse(avg -> System.out.println("Average age is "+avg), ()->System.out.println("No average age!!"));
		
		
		// max
		persons.stream()
		.mapToInt(p -> p.getAge())
		.max().ifPresentOrElse(m -> System.out.println("Max age is "+m), ()->System.out.println("No max age!!"));
	}
	
}
