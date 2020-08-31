package com.dynamicprogramming;

public class P02_KanpsackMemoization {

	public static void main(String[] args) {
		int W = 10;
		int N = 4;

		dp = new int[1 + N][1 + W];

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= W; j++) {
				dp[i][j] = -1;
			}
		}

		maxProfit(new int[] { 1, 3, 4, 5 }, new int[] { 1, 4, 5, 7 }, W, N);
		System.out.println(dp[N][W]);
	}

	static int[][] dp;

	public static int maxProfit(int[] wt, int[] val, int W, int n) {
		if (W < 0 || n < 0) {
			return 0;
		}
		
		if (dp[n][W] != -1) {
			return dp[n][W];
		}

		if (wt[n - 1] <= W) {
			int includeCase = val[n - 1] + maxProfit(wt, val, W - wt[n - 1], n - 1);
			int excludeCase = maxProfit(wt, val, W - wt[n - 1], n - 1);
			dp[n][W] = Math.max(includeCase, excludeCase);
			return dp[n][W];
		} else {
			dp[n][W] = maxProfit(wt, val, W - wt[n - 1], n - 1);
			return dp[n][W];			
		}
	}
}