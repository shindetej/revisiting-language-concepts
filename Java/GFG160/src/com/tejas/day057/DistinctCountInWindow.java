package com.tejas.day057;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DistinctCountInWindow {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 3, 4, 2, 3 };
		int k = 4;

		System.out.println(countDistinct(arr, k));
	}

	static ArrayList<Integer> countDistinct(int arr[], int k) {
		ArrayList<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		int n = arr.length;

		// 1st Iterate to k for adding map key
		for (int i = 0; i < k; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		result.add(map.size());

		// sliding window from k onwards
		for (int i = k; i < n; i++) {
			// reduce element count at start at start
			int out = arr[i-k];
			map.put(out, map.get(out)-1);
			if(map.get(out) == 0) {
				map.remove(out);
			}
		
			// increase element count at end
			int in = arr[i];
			map.put(in, map.getOrDefault(in, 0)+1);
			
			// add list size
			result.add(map.size());
		}
		return result;
	}
}
