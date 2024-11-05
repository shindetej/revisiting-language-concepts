package com.tejas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tejas.model.Inner3;
import com.tejas.model.Outer3;

@SpringBootApplication
public class InnerOuterBeanScopeDemo implements CommandLineRunner {
	@Autowired
	ApplicationContext ctx ;
	public static void main(String[] args) {
		System.out.println("Hello main()");
		SpringApplication.run(InnerOuterBeanScopeDemo.class, args);
	}

	public void run(String...args){
		System.out.println("Demo for different conditions of singleton and prototype beans as inner and outer bean");
//		Outer1 outerObj1 = ctx.getBean(Outer1.class);
//		Inner1 inner1 = outerObj1.getInner();	
//		Inner1 inner2 = outerObj1.getInner();	
//		System.out.println("Outer bean is singleton and inner is prototype then ...");
//		System.out.println("inner1 object & inner2 object of Inner1 class are same [inner1 == inner2]? "+ (inner1 == inner2));

		// Using app context
//		Outer2 outerObj2 = ctx.getBean(Outer2.class);
//		Inner2 inner1 = outerObj2.getInner();	
//		Inner2 inner2 = outerObj2.getInner();	
//		System.out.println("Outer bean is singleton & used application context aware to get prototype inner bean and inner is prototype then ...");
//		System.out.println("inner1 object & inner2 object of Inner2 class are same [inner1 == inner2]? "+ (inner1 == inner2));
		
		// Using @Lookup
		Outer3 outerObj3 = ctx.getBean(Outer3.class);
		Inner3 inner1 = outerObj3.getInner();	
		Inner3 inner2 = outerObj3.getInner();	
		System.out.println("Outer bean is singleton & used application context aware to get prototype inner bean and inner is prototype then ...");
		System.out.println("inner1 object & inner2 object of Inner3 class are same [inner1 == inner2]? "+ (inner1 == inner2));
	}
}
