package com.dp.DecoratorPattern;

public class MashroomToppings implements ToppingsDecorator {
	BasePizza basePizza;

	public MashroomToppings(BasePizza base) {
		this.basePizza =base;
	}
	@Override
	public int getCost() {
		return basePizza.getCost() + 15;
	}

}
