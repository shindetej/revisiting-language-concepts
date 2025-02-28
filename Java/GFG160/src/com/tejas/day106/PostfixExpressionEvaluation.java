package com.tejas.day106;

import java.util.Stack;

public class PostfixExpressionEvaluation {
	
	public static void main(String[] args) {
		  String[] arr = {"2", "3", "1", "*", "+", "9", "-"};
	        System.out.println(evaluate(arr)); 
	}

	
	public static int evaluate(String[] arr) {
        Stack<Integer> stack =  new Stack<>();
        
        for(String s :  arr)
        {
            if(s.matches("-?\\d+"))
            {
                stack.push(Integer.parseInt(s));
            }else{
                int n1 = stack.pop();
                int n2= stack.pop();
                
                switch(s)
                {
                    case "+": 
                        stack.push(n1+n2);
                        break;
                        
                    case "-": 
                        stack.push(n2-n1);
                        break;
                        
                    case "*": 
                        stack.push(n2*n1);
                        break;
                        
                    case "/": 
                        stack.push(n2/n1);
                        break;
                }
            }
        }
        return stack.pop();
        
    }
}
