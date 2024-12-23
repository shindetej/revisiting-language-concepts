package com.tejas.day033;

import java.util.Arrays;

public class AggressiveCowsBS {
	public static void main(String[] args) {
		int[] stalls = {2, 12, 11, 3, 26, 7};
		int k = 3;
		
		System.out.println("aggressive cows to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible \nAnswer k = "+ aggressiveCows(stalls,k));
	}

	private static int aggressiveCows(int[] stalls, int k) {
		Arrays.sort(stalls);
		System.out.println(Arrays.toString(stalls));
		int low = 0;
		int high = stalls[stalls.length-1] - stalls[0];
		while(low <= high) {
			int mid = (high+low)/2;
			if(canplaced(stalls,mid,k)) {
				low=mid+1;
			}else {
				high = mid-1;
			}
		}
		return high;
	}

	private static boolean canplaced(int[] stalls, int distance, int cows) {
		int cntCows=1; 
		int prevStall = stalls[0];
		
		for(int i =1;i<stalls.length;i++) {
			if(stalls[i]-prevStall >= distance ) {
				cntCows++;
				prevStall = stalls[i];
			}
			
			if(cntCows >= cows) {
				return true;
			}
		}
		return false;
	}
}
