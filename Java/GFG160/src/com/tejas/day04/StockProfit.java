package com.tejas.day04;

public class StockProfit {

	public static void main(String[] args) {
		int[] price = { 7, 1, 5 ,3 ,6, 4};
//		int[] price = { 10, 20, 30, 40, 20, 55, 30, 75, 60 };
		System.out.println("MAX PROFIT AFTER BUY SELL : " + maximumTotalProfit(price));
		System.out.println("MAX PROFIT AFTER BUY SELL : " + maximumProfitUsingBitwiseMasking(price));
	}

	public static int maximumTotalProfit(int prices[]) {
		int maxProfit = 0;
		int n = prices.length;

		for (int i = 0; i < n - 1; i++) {
			if (prices[i + 1] > prices[i]) {
				maxProfit += prices[i + 1] - prices[i];
			}
		}

		return maxProfit;
	}

	public static int maximumProfitUsingBitwiseMasking(int prices[]) {
		int maxProfit = 0;
		int n = prices.length;

		for (int i = 0; i < n - 1; i++) {

			// Shifing 31 bit to the right gives us 0 (if positive diff) and -1 if negative
			// difference
			// XOR with -1 again will give inverts of all the results means if 0 i.e
			// positive converts to -1 and -1(negative) converts to 0
			// at last doing bitwise & operation on difference & xor result gives you
			// difference if positive or 0 if negative
			maxProfit += (prices[i + 1] - prices[i]) & ((prices[i + 1] - prices[i]) >> 31 ^ -1);
		}

		return maxProfit;
	}

}
