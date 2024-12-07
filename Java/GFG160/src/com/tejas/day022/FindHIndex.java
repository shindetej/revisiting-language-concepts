package com.tejas.day022;

import java.util.Arrays;

public class FindHIndex {
	public static void main(String[] args) {
		int[] citations = { 5, 1, 2, 4, 1};

		System.out.println(hIndex(citations));
	}

	public static int hIndex(int[] citations) {
		int n = citations.length;
		int[] freq = new int[n + 1];

		for (int i = 0; i < n; i++) {
			if (citations[i] >= n)
				freq[n] += 1;
			else {
				freq[citations[i]] += 1;
			}
		}
		System.out.println(Arrays.toString(freq));

		int index = n;

		int s = freq[n];

		while (s < index) {
			index--;
			s += freq[index];
		}

		return index;
	}
}
