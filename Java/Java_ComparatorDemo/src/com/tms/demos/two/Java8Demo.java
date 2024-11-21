package com.tms.demos.two;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8Demo {
	public static void main(String[] args) {
		List<Car> carList = Arrays.asList(
					new Car("Indica", new Owner(23,"Raigad","Rajesh Tope")),
					new Car("Mercedez", new Owner(43,"Pune","Vijay Chavan")),
					new Car("Kia", new Owner(33,"Nashik","Abhi Kale"))
				);
		
		Collections.sort(carList);
		System.out.println("SORTING BASED ON MODEL -------");
		System.out.println(carList);
		
		
//		carList.sort(Comparator.comparing(c -> c.getOwner()));
		carList.sort(Comparator.comparing(Car::getOwner).reversed());
		System.out.println("SORTING BASED ON OWNER DESCENDING -------");
		System.out.println(carList);
	
	}
}
