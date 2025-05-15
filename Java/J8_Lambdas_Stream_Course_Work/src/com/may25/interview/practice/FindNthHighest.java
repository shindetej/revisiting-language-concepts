package com.may25.interview.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindNthHighest{
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(4,2,5,8,5,6,9);
		
		findNthHighest(list , 2);
		findNthHighest(list , 3);
		findNthHighest(list , 4);
		findNthHighest(list , 5);
	}
	
	public static void findNthHighest(List<Integer> list, int nth)
	{
		list.stream()
			.distinct()
			.sorted(Comparator.reverseOrder())
			.skip(nth-1)
			.findFirst()
			.ifPresentOrElse(
					num->System.out.println(nth+ " th largest number is : "+num), ()-> System.out.println("Number not exist for condition"));
			// Note : ifPresentOrElse() introduced in Java 9 ,In Java 8 we need to handle it through Optional.
	}
}
