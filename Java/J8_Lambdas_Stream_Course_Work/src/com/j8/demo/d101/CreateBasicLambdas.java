package com.j8.demo.d101;

public class CreateBasicLambdas {
	interface Greeting{
		public String greet(String s);  
	}
	
	public static void main(String[] args) {
			
		testGreet("Tatya ", (String s)-> "नमस्कार "+ s);
		testGreet("जय शिवराय", s->"Jai Jijau "+ s);
		testGreet("",s-> !s.isEmpty()?"Hola "+s:"String not passed or empty!!");
	}
	
	// 2nd parameter is passing behaviour as a data (functional progrmming)
	public static void testGreet(String name , Greeting greeting)
	{
		String result = greeting.greet(name);
		System.out.println("RESULT :- "+result);
	}
}
