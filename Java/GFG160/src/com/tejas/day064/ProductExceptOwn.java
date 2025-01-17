package com.tejas.day064;

import java.util.Arrays;

public class ProductExceptOwn {
	public static void main(String[] args) {
		
		int[] arr = {10,5,2,3,8};
		int[] arrZ = {10,5,0,3,8};
		int[] arr2Z = {0,5,0,3,8};
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arrZ));
		System.out.println(Arrays.toString(arr2Z));
		System.out.println("Array of products except index ith value skipped");
		System.out.println(Arrays.toString(productExceptSelf(arr)));
		System.out.println(Arrays.toString(productExceptSelf(arrZ)));
		System.out.println(Arrays.toString(productExceptSelf(arr2Z)));
		
		System.out.println("My Approach with same complexity but division issue");
		System.out.println(Arrays.toString(productExceptSelf1(arr)));
		System.out.println(Arrays.toString(productExceptSelf1(arrZ)));
		System.out.println(Arrays.toString(productExceptSelf1(arr2Z)));
	}
	
	
	// Expected solution is 
	public static int[] productExceptSelf(int arr[]) {
        int n = arr.length;
        int[] result = new int[n];
        
        int prefix =1;
        int suffix = 1;
        for(int i = 0;i<n ;i++){
            result[i] = prefix;
            prefix*=arr[i];
        }
        
        for(int j = n-1;j>=0 ;j--){
            result[j]*=suffix;
            suffix *= arr[j];
        }
        
        return result;
    }
	
	
	// My Solution of adjustments and division is problematic here
	 public static int[] productExceptSelf1(int arr[]) {
	        int n = arr.length;
	        int[] result = new int[n];
	        
	        int totalProduct = 1;
	        boolean isZeroContain = false;
	        for(int i = 0;i<n ;i++){
	            if(arr[i] == 0 && (!isZeroContain)){
	                isZeroContain = true;
	            }else{
	                totalProduct*=arr[i];
	            }
	                
	        }
	        
	        for(int j = 0;j<n ;j++){
	            if(!isZeroContain)
	                result[j] = totalProduct/ arr[j];
	            else{
	              if(arr[j] != 0){
	                result[j] = 0;
	              }
	              else{
	                result[j] = totalProduct;
	              }
	                  
	             }
	        }
	        
	        return result;
	    }
}
