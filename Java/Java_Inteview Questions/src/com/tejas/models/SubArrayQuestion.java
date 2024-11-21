package com.tejas.models;

import java.util.ArrayList;
import java.util.List;

public class SubArrayQuestion {
	public static void main(String[] args) {
		int[] arr = { 3, 1, 5, 7, 15, 20, 9, 8 };
		long sum = 28;

		List<Integer> list = subArrayWithGivenSum(arr, sum);
		System.out.println("Index "+ list);
		for(int i = list.get(0);i <= list.get(1);i++) {
			System.out.println(i+ "  : "+arr[i]);
		}
	}

	private static List<Integer> subArrayWithGivenSum(int[] arr, long sum) {
		List<Integer> list = new ArrayList<>();

		int start = 0, end = 0;

		long current = 0;

		// LOGIC :
		/*
		 * Iterate from starting and do add(summation) it current value for each iteration
		 * after adding check if current is exceeding desired sum or less
		 * if current exceeding required sum means given iterated values has sub array which can match sum
		 * so assign ith index to end (which is end of sub array)
		 * Iterate until current less than eq to sum and start less than end
		 * reduce start indexed value from current and check if we get current == sum
		 *  if yes add start and both index to list and return 
		 *  else increment ith index repeat procedure from start
		 * */
		for (int i = 0; i < arr.length; i++) {
			current += arr[i];
			if(current >= sum) {
				end = i;
				
			
				while(current > sum & start < end) {
					current-=arr[start];
					start++; // decrementing start by each step
				}
				
				if(current == sum) {
					list.add(start);
					list.add(end);
					return list;
				}
			}
		}

		return null;
	}
}
