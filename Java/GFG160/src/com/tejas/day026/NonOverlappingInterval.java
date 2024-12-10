package com.tejas.day026;

import java.util.Arrays;
import java.util.List;

public class NonOverlappingInterval {
	public static void main(String[] args) {
		int[][] intervals = { { 1, 2 }, { 2,3 }, { 3, 4 }, { 1, 3 }};

		int result = minRemoval(intervals);
		System.out.println(result);

	}
	
	static int minRemoval(int intervals[][]) {
		Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
		int count = 0;
		int end = intervals[0][1];
		for(int i = 1;i < intervals.length;i++) {
			
			if(intervals[i][0] < end ) {
				count++;
				end = Math.min(end, intervals[i][1]);
			}
			else {
				end = intervals[i][1];
			}
		}
		return count;
	}
}
