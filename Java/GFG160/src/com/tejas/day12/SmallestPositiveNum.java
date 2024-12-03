package com.tejas.day12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveNum {

	public static void main(String[] args) {
		int[] arr = { 1,2,3,4,5};
		int[] arr2 = { 1,2,3,4,5 };

		System.out.println("USING ARRAY MARKING");
		System.out.println(missingNumber(arr));
		System.out.println("USING HASH SET");
		System.out.println(missingNumberUsingHashSet(arr2));
	}

	public static int missingNumber(int[] arr) {
		int len = arr.length;
		int positiveMissedNum = 1;
		Set<Integer> set = new HashSet<>();
		int j = 0;
		for (int i = 0; i < len; i++) {
			if (arr[i] <= 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
		}

		// mark it with negation for all values present in range j to n
		for (int i = j; i < len; i++) {
			// AS we are marking values at pos val as negative 1st we take abs value
			int val = Math.abs(arr[i]);
			if (1 <= val && val <= (len - j)) {
				// below condition fails only when value present more than once and already
				// marked as negative
				if (arr[j + val - 1] > 0) {
					arr[j + val - 1] = -1 * arr[j + val - 1];
				}
			}
		}

		for (int i = j; i < len; i++) {
			if (arr[i] > 0)
				return i - j + 1;
		}
		return len - j + 1;
	}

	public static int missingNumberUsingHashSet(int[] arr) {
		Set<Integer> set = new HashSet<>();

		for (int i : arr) {
			if (i > 0 && i < arr.length+1)
				set.add(i);
		}
		int smallestMissing = 1;
		while (set.contains(smallestMissing)) {
			smallestMissing++;
		}
		return smallestMissing;
	}
}
