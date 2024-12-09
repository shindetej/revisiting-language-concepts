package com.tejas.day024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergedIntervals {

	public static void main(String[] args) {
		int[][] arr = { { 1, 3 }, { 2, 4 }, { 6, 8 }, { 9, 10 } };
		List<int[]> res = mergeOverlap(arr);

		for (int[] a : res) {
			System.out.println(a[0] + " " + a[1]);
		}
	}

	public static List<int[]> mergeOverlap(int[][] arr) {
		int n = arr.length;

		Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

		List<int[]> intArrayList = new ArrayList<>();
		intArrayList.add(new int[] { arr[0][0], arr[0][1] });
		// iterate 1 -> n
		for (int i = 1; i < n; i++) {
			int[] last = intArrayList.get(intArrayList.size() - 1);
			int[] current = arr[i];

			if (current[0] <= last[1]) {
				last[1] = Math.max(current[1],last[1]);
			}else {
				intArrayList.add(current);
			}
		}
		
		return intArrayList;
	}
}
