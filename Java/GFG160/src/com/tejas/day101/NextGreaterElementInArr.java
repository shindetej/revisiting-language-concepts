package com.tejas.day101;

import java.util.ArrayList;
import java.util.Stack;

// STACK UTILITY DEMO
public class NextGreaterElementInArr {
	public static void main(String[] args) {
		
		int[] arr = {6, 8, 0, 1, 3};
		
		System.out.println("List of NGE : "+ new NextGreaterElementInArr().nextLargerElement(arr));
	}

	public ArrayList<Integer> nextLargerElement(int[] arr) {
		ArrayList<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		int n = arr.length;

		// fill result with -1
		for (int i = 0; i < n; i++) {
			result.add(-1);
		}

		// iterate from last
		for (int i = n - 1; i >= 0; i--) {

			while (!stack.isEmpty() && arr[i] >= stack.peek()) {
				stack.pop();
			}

			// if stack is not empty and current array ele is less than stack top
			if (!stack.isEmpty()) {
				// add to list
				result.set(i, stack.peek());
			}

			stack.push(arr[i]);
		}
		return result;
	}
}
