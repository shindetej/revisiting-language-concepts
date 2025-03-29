package com.repeat.streams.demos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDupsInStream {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,1,5,4,6,7,3,7);
		Set<Integer> unique = new HashSet<>();
		// Hint : add() method in Set returns false if it is duplicate i.e already exist in Set.
		Set<Integer> dups = list.stream()
			.filter(n->!unique.add(n))
			.collect(Collectors.toSet());
		
		System.out.println(dups);
	}
}
