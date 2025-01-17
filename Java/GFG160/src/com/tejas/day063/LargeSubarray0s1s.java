package com.tejas.day063;

import java.util.HashMap;
import java.util.Map;

public class LargeSubarray0s1s {
	public static void main(String[] args) {
		int[] arr= {1, 0, 1, 1, 1, 0, 0};
		
		System.out.println("Max sub array with equal number of 1s and 0s within range : "+ maxLen(arr));
	}
	
	public static int maxLen(int[]arr) {
		Map<Integer,Integer> map =  new HashMap<>();
        for(int i = 0 ;i<arr.length; i++)
        {
            if(arr[i] == 0){
                arr[i] = -1;
            }
        }
        int maxLen = 0;
        
        int prefixSum = 0;
        
        for(int i = 0 ;i<arr.length;i++){
            prefixSum+=arr[i];
            
            if(prefixSum == 0)
            {
                maxLen = i+1;
            }
            else if(map.containsKey(prefixSum)){
                maxLen = Math.max(maxLen,i-map.get(prefixSum));
            }
            else{
                map.put(prefixSum,i);
            }
        }
        return maxLen;
	}
}
