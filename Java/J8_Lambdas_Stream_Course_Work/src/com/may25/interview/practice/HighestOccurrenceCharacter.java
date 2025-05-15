package com.may25.interview.practice;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HighestOccurrenceCharacter {

	public static void main(String[] args) {
		String input = "Tejas Mahendra Shinde";
		
		// Max occurred character
		input.toLowerCase().chars()
			.mapToObj(c->(char)c)
			.filter(n-> n!= ' ') // removing spaces
			.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
			.entrySet()
			.stream()
			.peek(d -> System.out.println(d))
			.max(Map.Entry.comparingByValue())
			.ifPresentOrElse(mo-> System.out.println("Max occurred character :"+mo), ()->System.out.println("Not found!!!"));

		
		// 2. Find the N-th lowest occurrence character in a string
		
		NthHighestOccurrenceCharacter(input,2);
		NthLowestOccurrenceCharacter(input,2);
	}

	private static void NthLowestOccurrenceCharacter(String input, int n) {
		input.toLowerCase()
		.chars()
		.mapToObj(m-> (char) m)
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet()
		.stream() 
		.sorted(Map.Entry.comparingByValue()) // Ascending order
		.skip(n-1).findFirst().ifPresentOrElse(mo-> System.out.println(n+ "th Min occurred character :"+mo.getKey()), ()->System.out.println("Not found!!!"));
		
	}

	private static void NthHighestOccurrenceCharacter(String input, int n) {
		input.toLowerCase()
		.chars()
		.mapToObj(m-> (char) m)
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet()
		.stream() 
		.sorted(Map.Entry.<Character,Long>comparingByValue().reversed()) // Ascending order
		.skip(n-1).findFirst().ifPresentOrElse(mo-> System.out.println(n+ "th Max occurred character :"+mo.getKey()), ()->System.out.println("Not found!!!"));

		
	}	
}
