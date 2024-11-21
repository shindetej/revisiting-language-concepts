package com.tejas.codes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EachStringCountFromList {
	public static void main(String[] args) {
		
		// find count of string
		System.out.println("Find count of each string in list");
		List<String> stringList = Arrays.asList("Tejas", "Raj", "Chen", "Raj"); // Example input
//        findCountOfEachStringInList(stringList);
		findStringCountUsingStreams2(stringList);

	}

	private static void findCountOfEachStringInList(List<String> stringList) {
		Map<String, Integer> stringMap = new HashMap<>();

		for (String s : stringList) {
			stringMap.put(s, stringMap.getOrDefault(s, 0) + 1);
		}

		for (Entry<String, Integer> e : stringMap.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}

	}
	
	
	// USING JAVA 8 
	private static void findStringCountUsingStreams2(List<String> stringList) {
		stringList.stream()
		.collect(
					Collectors.groupingBy(Function.identity(), Collectors.counting()) // this gives grouping by  string and value as count
				)
		.forEach((k, n) -> System.out.println(k + " has count " + n));
	}

	// this is not recommended although it will give result : as map() is to transform each element in collection, we are not doing same
	private static void findStringCountUsingStreams1(List<String> stringList) {
		Map<String, Integer> stringMap = new HashMap<>();
		
		stringList.stream().map(s -> stringMap.put(s, stringMap.getOrDefault(s, 0) + 1)).collect(Collectors.toSet());
		stringMap.forEach((key, value) -> System.out.println(key + " : " + value));

	}

	


}