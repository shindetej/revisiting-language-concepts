package com.dp.Main;

import com.dp.DecoratorPattern.BasePizza;
import com.dp.DecoratorPattern.CheeseToppings;
import com.dp.DecoratorPattern.Margherita;
import com.dp.DecoratorPattern.MashroomToppings;

public class DecoratorMain {
	public static void main(String[] args) {
		
		// create base pizza
		BasePizza margherita = new Margherita();
		
		// add extra cheese
		CheeseToppings margheritaWithCheese =  new CheeseToppings(margherita);
		// add extra mashroom
		MashroomToppings mashroomOnMargheritaCheesePizza =  new MashroomToppings(margheritaWithCheese);
		
		
		
		// get cost of it
		System.out.println("Pizza cost for Margherita Pizza With Extra Cheese And Mashroom Toppings : INR "+mashroomOnMargheritaCheesePizza.getCost());

	}
}
