package com.tejas.day102;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpanProblem {

	public static void main(String[] args) {
		System.out.println("STOCK SPAN PROBLEM RESULT :\n"
				+ new StockSpanProblem().calculateSpan(new int[] { 10, 4, 5, 90, 120, 80 }));
	}

	public ArrayList<Integer> calculateSpan(int[] arr) {
		int n = arr.length;
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> span = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				span.add(i + 1);
			} else {
				span.add(i - stack.peek());
			}
			stack.push(i);
		}
		return span;
	}

}
