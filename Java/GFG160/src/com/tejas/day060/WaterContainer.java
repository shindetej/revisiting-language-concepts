package com.tejas.day060;

public class WaterContainer {
	public static void main(String[] args) {
		int[] arr= {1,5,4,3};
		
		System.out.println("MAX WATER :"+ maxWater(arr));

	}

	static public int maxWater(int arr[]) {
        int left = 0;
        int right = arr.length-1;
        int maxWater = 0;
        
        
        while(left<right){
            int height = Math.min(arr[left],arr[right]);
            int width = right-left;
            maxWater = Math.max(maxWater,height * width);
            
            if (arr[left]<arr[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
    }
}
