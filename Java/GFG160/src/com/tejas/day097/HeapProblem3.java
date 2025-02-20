package com.tejas.day097;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeapProblem3 {

	public static void main(String[] args) {
		int[] arr = {5, 15, 1, 3, 2, 8};
		
		System.out.println(getMedian(arr).toString());
		
	}
	public static ArrayList<Double> getMedian(int[] arr) {
		ArrayList<Double> result = new ArrayList<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int num : arr) {
			addNum(num, maxHeap, minHeap);
			result.add(findMedian(maxHeap, minHeap));
		}

		return result;
	}

	static void addNum(int num, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
			maxHeap.add(num);
		} else {
			minHeap.add(num);
		}

		if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.add(maxHeap.poll());
		} else if (minHeap.size() > maxHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}

	static double findMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
		if (maxHeap.size() > minHeap.size()) {
			return maxHeap.peek();
		} else {
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		}
	}
}
