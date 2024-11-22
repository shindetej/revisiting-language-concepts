package com.tejas.day4;

public class SingleMaxProfit {

	public static void main(String[] args) {
//		int[] price = { 7, 1, 5, 3, 6, 4 };
		int[] price = { 10, 20, 30, 40, 20, 55, 30, 75, 60 };
		System.out.println("Max One Transaction : " + maximumSingleProfit(price));
	}

	public static int maximumSingleProfit(int prices[]) {
		int n = prices.length;
		if (n < 2)
			return 0;

		int maxSingleProfit = 0; // to cap this to positive
		int minPrice = prices[0];

		// ITERATE FROM 1 to N
		for (int i = 1; i < n; i++) {
			// PROFIT =  CURRENT PRICE - MIN PRICE
			int profit = prices[i] - minPrice;

			// IF PROFIT IS MAX SET PROFIT AS MAX PROFIT
			if (profit > maxSingleProfit)
				maxSingleProfit = profit;

			// IF CURRENT PRICE LESS THAN MIN SET tO MIN PRICE
			if (prices[i] < minPrice)
				minPrice = prices[i];
		}
		
		return maxSingleProfit;

	}

	
}
