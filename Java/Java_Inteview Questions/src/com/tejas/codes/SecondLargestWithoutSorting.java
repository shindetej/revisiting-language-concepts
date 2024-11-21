package com.tejas.codes;

import java.util.Arrays;
import java.util.List;

public class SecondLargestWithoutSorting {
	public static void main(String[] args) {
		int[] arr =  {30,20,50,75,70,80,80,78};
		
		int highest = arr[0];
		int secondHighest = -1;
		
		for(int i = 1;i<arr.length;++i) {
			if(arr[i] > highest ) {
				System.out.println(arr[i]  +" > highest "+highest);
				secondHighest=highest;
				highest = arr[i];
			}else if(arr[i] != highest && arr[i] > secondHighest) {
				System.out.println(arr[i]  +" > second highest "+secondHighest);
				secondHighest = arr[i];
			}
		}
		
		System.out.println("Second highest is : "+ secondHighest);
	}
}
