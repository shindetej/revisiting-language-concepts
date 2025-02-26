package com.tejas.day105;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MaxOfMinWindowSize {

	public static void main(String[] args) {
		System.out.println("Maximum of minimum for every window size :");
		System.out.println(maxOfMins(new int[] {10, 20, 30, 50, 10, 70, 30}));
		System.out.println(maxOfMins(new int[] {10, 20, 30}));
	}

	public static ArrayList<Integer> maxOfMins(int[] arr) {
		int n = arr.length;
		ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));

		Stack<Integer> stack = new Stack<>();

		ArrayList<Integer> lenArr = new ArrayList<>(Collections.nCopies(n, 0));

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				int top = stack.pop();
				int windowSize = stack.isEmpty() ? i : i - stack.peek() - 1;
				lenArr.set(top, windowSize);
			}

			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int top = stack.pop();
			int windowSize = stack.isEmpty() ? n : n - stack.peek() - 1;
			lenArr.set(top, windowSize);
		}

		for (int i = 0; i < n; i++) {
			int windowSize = lenArr.get(i) - 1;
			result.set(windowSize, Math.max(result.get(windowSize), arr[i]));
		}

		for (int i = n - 2; i >= 0; i--) {
			result.set(i, Math.max(result.get(i), result.get(i + 1)));
		}

		return result;
	}
}
