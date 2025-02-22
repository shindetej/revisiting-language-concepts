package com.tejas.day100;

import java.util.Stack;

public class LongestValidParanthesis {
		public static void main(String[] args) {
			System.out.println("Longest valid paranthesis count : "+ maxLength(")(()(())"));
		}
	
	   static int maxLength(String s) {
	        Stack<Integer> stack =  new Stack<>();
	        stack.push(-1); // to handle valid substring from start
	        int maxLen = 0;
	        
	        for(int i = 0; i<s.length();i++){
	              if(s.charAt(i) == '('){
	                  stack.push(i);
	              }
	              else{
	                  stack.pop();
	                  if(stack.isEmpty()){
	                      stack.push(i);
	                  }
	                  else{
	                      maxLen = Math.max(maxLen,i-stack.peek());
	                  }
	              }
	        }
	        
	        return maxLen;
	    }

}
