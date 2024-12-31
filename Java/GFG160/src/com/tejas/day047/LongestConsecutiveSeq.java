package com.tejas.day047;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {
	public static void main(String[] args) {
		int[] arr = { 15, 13, 12, 14, 11, 10, 9 };

		System.out.println("Count of longest consecutive sequence : " + longestConsecutiveBySort(arr));
	}

	public static int longestConsecutive(int[] arr) {
		int count = 0;
		Set<Integer> set = new HashSet<>();

		for (int num : arr) {
			set.add(num);
		}

		for (int num : arr) {
			// initial value
			int tempCnt = 0;
			if (set.contains(num) && !set.contains(num - 1)) {
				for (int i = num; set.contains(i); i++) {
					set.remove(i);
					tempCnt++;
				}
				count = Math.max(count, tempCnt);
			}
		}
		return count;
	}

	public static int longestConsecutiveBySort(int[] arr) {

		int count = 0;
		Arrays.sort(arr);
		Set<Integer> set = new HashSet<>();
		int tempCnt = 1;
		for (int i = 1; i < arr.length; i++) {
			// initial value

			if (arr[i] == arr[i - 1]) // similar element
			{
				continue;
			}
			if (arr[i] == arr[i - 1] + 1) {
				tempCnt++;
			} else {
				tempCnt = 1;
			}
			count = Math.max(count, tempCnt);
		}
		return count;
	}

}
