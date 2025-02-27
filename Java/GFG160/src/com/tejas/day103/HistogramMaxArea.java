package com.tejas.day103;

import java.util.ArrayList;
import java.util.Stack;

public class HistogramMaxArea {

	public static void main(String[] args) {
		System.out.println("Max area of histogram rectangle :\n"
				+ getMaxArea(new int[] {60, 20, 50, 40, 10, 50, 60}));
	}

	static int[] prevSmaller(int[] arr)
    {
        int n=arr.length;
        
        int[] prevS=new int[n];
        
        for(int i = 0;i < n;i++){
            prevS[i] =-1;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && arr[i]<arr[stack.peek()])
            {
                stack.pop();
            }
            if(!stack.isEmpty())
            {
                prevS[i] = stack.peek();
            }
            
            stack.push(i);
            
        }
        return prevS;
    }
    
    
    static int[] nextSmaller(int[] arr)
    {
        int n=arr.length;
        
        int[] nextS=new int[n];
        
         for(int i = 0;i < n;i++){
            nextS[i] = n;
        }
        
         Stack<Integer> stack = new Stack<>();
        
        for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && arr[i]<arr[stack.peek()])
                nextS[stack.pop()] = i;
            
            stack.push(i);
            
        }
        return nextS;
    }
    
    
    public static int getMaxArea(int arr[]) {
        int[] prevS = prevSmaller(arr);
        int[] nextS = nextSmaller(arr);
        
        int maxArea = 0;
        
        for(int i = 0;i<arr.length;i++)
        {
            int width = nextS[i] - prevS[i] -1;
            int area = arr[i] *width;
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }

}
