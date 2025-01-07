package com.tejas.day054;

public class PairOfSumInSortedArray {

	public static void main(String[] args) {
		
		int[] arr = {1,1,1,1};
//		int[] arr = {-1,1,5,5,7};
		int target = 2;
		System.out.println("Pairs : "+ countPairs(arr, target));
		
	}
	static int countPairs(int arr[], int target) {
        int l = 0;
        int r = arr.length-1;
        
        int resultCnt = 0;
        
        while(l<r){
            int sum  = arr[l] + arr[r];
            
            if(sum < target){
                l++;
            }
            else if(sum > target){
                r--;
            }
            else{
                // when sum matches target
                // handle edge cases of repeatative number
                int e1 = arr[l] ,e2=arr[r];
                int e1Cnt = 0 ,e2Cnt=0;
                
                while(l<=r && e1 == arr[l]){
                    e1Cnt++;
                    l++;
                }
                while(l<=r && e2 == arr[r]){
                    e2Cnt++;
                    r--;
                }
                
                if(e1==e2){
                    resultCnt += e1Cnt*(e1Cnt-1)/2;
                }
                else{
                    resultCnt += e1Cnt*e2Cnt;
                }
            }
            
        }
        return resultCnt;
    }
}
