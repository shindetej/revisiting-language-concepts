package com.dp.DecoratorPattern;

public class CheeseToppings implements ToppingsDecorator{

	// HAS-A
	BasePizza basePizza;
	
	public CheeseToppings(BasePizza base) {
		this.basePizza =base;
	}
	
	@Override
	public int getCost() {
		return basePizza.getCost()+10;
	}

}
