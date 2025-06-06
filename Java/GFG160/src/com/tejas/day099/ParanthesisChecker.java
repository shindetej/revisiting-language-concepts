package com.tejas.day099;

import java.util.Stack;

public class ParanthesisChecker {
	public static void main(String[] args) {
		System.out.println("IS BALANCED : "+ isBalanced("{[]}"));
		System.out.println("IS BALANCED : "+ isBalanced("{[][}"));
		System.out.println("IS BALANCED : "+ isBalanced("{()[]}"));
	}

	static boolean isBalanced(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty())
					return false;

				char top = stack.pop();

				if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
					return false;
				}
			}

		}
		return stack.isEmpty();
	}
}
