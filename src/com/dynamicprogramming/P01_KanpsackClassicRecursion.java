package com.dynamicprogramming;

public class P01_KanpsackClassicRecursion {

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 1, 3, 4, 5 }, new int[] { 1, 4, 5, 7 }, 10, 4));
	}

	public static int maxProfit(int[] wt, int[] val, int W, int n) {
		if (W == 0 || n == 0) {
			return 0;
		}

		if (wt[n - 1] <= W) {
			int includeThisWeight = val[n - 1] + maxProfit(wt, val, W - wt[n - 1], n - 1);
			int excludeThisWeight = maxProfit(wt, val, W - wt[n - 1], n - 1);
			return Math.max(includeThisWeight, excludeThisWeight);
		} else {
			return maxProfit(wt, val, W - wt[n - 1], n - 1);
		}
	}
}