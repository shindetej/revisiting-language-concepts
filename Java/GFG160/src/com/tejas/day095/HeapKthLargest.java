package com.tejas.day095;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeapKthLargest {
	public static void main(String[] args) {
		int[] arr =  new int[] {12, 5, 787, 1, 23};
		int k = 2;
		
		System.out.println(kLargest(arr, k));
	}

	public static ArrayList<Integer> kLargest(int[] arr, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < k; i++) {
			minHeap.add(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {
			if (arr[i] > minHeap.peek()) {
				minHeap.poll();
				minHeap.add(arr[i]);

			}

		}
		ArrayList<Integer> result = new ArrayList<>();

		while (!minHeap.isEmpty()) {
			result.add(minHeap.poll());
		}

		Collections.reverse(result);
		return result;
	}
}
