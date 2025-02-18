package com.tejas.day096;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthClosestToOrigin {
	public static void main(String[] args) {
		int[][] arr = { { 1, 3 }, { 3, 4 }, { 2, -2 }, { 0, 1 } };
		int k = 2;

		int[][] result  = kClosest(arr, k);
		
		for(int[] ar :result) {
			System.out.println(Arrays.toString(ar));
		}
	}

	static int sqDistance(int[] pt) {
		return (pt[0] * pt[0]) + (pt[1] * pt[1]);
	}

	public static int[][] kClosest(int[][] points, int k) {

		PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> sqDistance(b) - sqDistance(a));

		// fill the heap ds
		for (int[] pt : points) {
			if (maxHeap.size() < k) {
				maxHeap.offer(pt);
			} else {
				if (sqDistance(pt) < sqDistance(maxHeap.peek())) {
					maxHeap.poll();
					maxHeap.offer(pt);
				}
			}
		}

		// check for min two shortest distance
		int[][] result = new int[k][2]; // k row 2 col
		int index = 0;
		while (!maxHeap.isEmpty()) {
			int[] pt = maxHeap.poll();
			result[index][0] = pt[0];
			result[index][1] = pt[1];
			index++;
		}
		return result;
	}
}
