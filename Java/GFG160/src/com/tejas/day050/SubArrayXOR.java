package com.tejas.day050;

import java.util.HashMap;
import java.util.Map;

public class SubArrayXOR {
	public static void main(String[] args) {
		int[] arr = {4, 2, 2, 6, 4};
		int k = 6;
		
		System.out.println("COUNT OF SUB ARRAYS WITH SUM "+ k +"  :  " +subarrayXor(arr, k));
	}

	public static long subarrayXor(int arr[], int k) {
        int result =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int pXOR=0;
        
        for(int val: arr){
            pXOR ^= val;
            
            result +=map.getOrDefault(pXOR^k,0);
            if(pXOR==k){
                result++;
            }
            map.put(pXOR,map.getOrDefault(pXOR,0)+1);
        }
        return result;
    }
}