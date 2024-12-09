package com.tejas.day025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddInterval {

	public static void main(String[] args) {
		int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int[] newInterval = { 4,9 };

		List<int[]> result = insertInterval(intervals, newInterval);

		result.forEach(n -> System.out.println(n[0] + " " + n[1]));
	}

	static ArrayList<int[]> insertInterval(int[][] inputIntervals, int[] newInterval) {
		ArrayList<int[]> resultList = new ArrayList<>();
        int[][] intervals = new int[inputIntervals.length+1][];
		for (int i = 0; i < inputIntervals.length; i++) {
            intervals[i] = inputIntervals[i];
        }

		intervals[inputIntervals.length] = newInterval;


		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		resultList.add(intervals[0]);
		int n = intervals.length;
		int UPPER = 1;
		int LOWER = 0;

		for (int i = 1; i < n; i++) {
			int[] lastArrayFromList = resultList.get(resultList.size() - 1);
			int[] current = intervals[i]; // start from 1th index

			if (lastArrayFromList[UPPER] >= current[LOWER]) // check if list's last interval can be overlapped with current?
			{
				// set new max in upper bound among current or last
				lastArrayFromList[UPPER] = Math.max(current[UPPER], lastArrayFromList[UPPER]);
			}else {
				//push back to list of array as no overlap possible
				resultList.add(current);
			}
		}

		return resultList;
	}
}
