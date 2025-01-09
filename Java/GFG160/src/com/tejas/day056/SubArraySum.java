package com.tejas.day056;

import java.util.ArrayList;

public class SubArraySum {
	public static void main(String[] args) {
		int[] arr = { 19, 23, 15, 6, 6, 2, 28, 2 };
		int target = 2;

		System.out.println(subarraySum(arr, target));
	}

	static ArrayList<Integer> subarraySum(int[] arr, int target) {
		int s = 0,e = 0;
        int sum = 0;
       
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int j = 0;j<arr.length;j++){
            sum += arr[j];
            
            if(sum >= target){
                e = j;
                while(sum > target){
                    sum-=arr[s];
                    ++s;
                }
                if(sum == target){
                    list.add(s+1);
                    list.add(e+1);
                    return list;
                }
            }
                
            }
        	list.add(-1);
            return list;
	}

}
