package com.tejas.day044;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindTripletsWithZeroSum {
	public static void main(String[] args) {
		int[] arr = { 0, -1, 2, -3, 1 };
		List<List<Integer>> list = findTriplets(arr);
		// Print the result
		System.out.println("Triplets with sum = 0:");
		for (List<Integer> triplet : list) {
			System.out.println(triplet);
		}
	}

	public static List<List<Integer>> findTriplets(int[] arr) {

		Set<List<Integer>> st = new HashSet<>();
		int n = arr.length;
		Map<Integer, List<Map.Entry<Integer, Integer>>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int sum = arr[i] + arr[j];
				map.putIfAbsent(sum, new ArrayList<>());
				map.get(sum).add(new AbstractMap.SimpleEntry<>(i, j));
			}
		}

		for (int i = 0; i < n; i++) {
			int req = -arr[i]; // The required sum is -arr[i]
			if (map.containsKey(req)) {
				for (Map.Entry<Integer, Integer> entry : map.get(req)) {
					int first = entry.getKey();
					int second = entry.getValue();
					// Check if indices are different to avoid using the same element twice
					if (i != first && i != second) {
						List<Integer> triplet = Arrays.asList(i, first, second);
						Collections.sort(triplet); // Sort to maintain i < j < k order
						st.add(triplet); // Add sorted triplet to the set
					}
				}
			}
		}

		// Convert set to list and return
		return new ArrayList<>(st);
	}
}
