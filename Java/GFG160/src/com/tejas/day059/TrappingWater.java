package com.tejas.day059;

import java.util.Arrays;

public class TrappingWater {
	public static void main(String[] args) {
		int arr[] = {3,4,5};
		System.out.println("Total water units : "+maxWater(arr));
	}

	/*
	 * Algorithm to find trapping water
	 * trapping water is when for a number its right and left side is greater than that number and
	 * subtraction from lowest among left and right number of that number willbe number of units water trapped
	 * 
	 * hence traverse over arr and store in new arrays leftMax and rightMax each
	 * 
	 * traverse in arr and for each get min of leftMax and rightMax and subtract element at that index from it to get trapping watter
	 * 
	 * */
	public static int maxWater(int arr[]) {
		int n = arr.length;
		
		int[] leftMax = new int[n];
		int[] rightMax = new int[n];
		int waterUnits = 0; 
		
		// find left tallest for each index element
		leftMax[0] = arr[0];
		for(int i = 1;i<n;i++) {
			leftMax[i]=(Math.max(leftMax[i-1], arr[i]));
		}
	
		// find right tallest 
		rightMax[n-1] = arr[n-1];
		for(int i = n-2;i>=0;i--) {
			rightMax[i] = Math.max(rightMax[i+1], arr[i]);
		}
		
		System.out.println("Left max array"+Arrays.toString(leftMax));
		System.out.println("Right max array"+Arrays.toString(rightMax));
		
		// add difference
		
		for(int i = 0;i<n;i++) {
			waterUnits+=Math.min(leftMax[i], rightMax[i]) -arr[i];
			System.out.println("water units sum at index "+i + " is  : " + waterUnits);
		}
		return waterUnits;
	}
	
	   /*
     * Algorithm to find the amount of water trapped between blocks using the two-pointer approach.
     * 
     * Water is trapped when a block has taller blocks on both sides (left and right). 
     * The trapped water above a block is determined by:
     *     min(leftMax, rightMax) - height[i]
     * where leftMax and rightMax are the tallest blocks on the left and right sides of the current block.
     * 
     * Instead of using additional arrays for leftMax and rightMax, this approach uses two pointers 
     * and two variables (leftMax and rightMax) to dynamically calculate the water trapped in O(1) space.
     * 
     * Steps:
     * 1. Initialize two pointers: left (start of array) and right (end of array).
     * 2. Maintain two variables, leftMax and rightMax, to track the maximum heights encountered so far 
     *    from the left and right sides.
     * 3. Move the pointers inward. If the current height at the left pointer is less than or equal to 
     *    the height at the right pointer:
     *    - If the current height is less than leftMax, calculate the water trapped above it.
     *    - Otherwise, update leftMax.
     *    - Increment the left pointer.
     * 4. Similarly, if the height at the right pointer is less than the left pointer:
     *    - If the current height is less than rightMax, calculate the water trapped above it.
     *    - Otherwise, update rightMax.
     *    - Decrement the right pointer.
     * 5. Continue until the two pointers meet.
     */
	public static int maxWaterWithTwoPointers(int arr[]) {
		 int n = arr.length;
	        
	       int leftMax = 0;
	       int rightMax = 0;
	       int left = 0;
	       int right = n-1;
	       
	       int totalUnits = 0;
	       while(left < right){
	           if(arr[left] <= arr[right]){
	              // left side difference
	              if(arr[left] < leftMax){
	                  totalUnits+= leftMax - arr[left];
	              }else{
	                  leftMax=arr[left];
	              }
	              left++;
	           }else{
	               // right side difference
	    
	            if(arr[right] < rightMax){
	                     totalUnits +=rightMax -arr[right];
	                }
	               else{
	                   rightMax =arr[right];
	               }
	              
	               right--;
	           }
	       }
	      return totalUnits;
	}
}
