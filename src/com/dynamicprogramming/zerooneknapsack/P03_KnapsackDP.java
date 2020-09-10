package com.dynamicprogramming.zerooneknapsack;

public class P03_KnapsackDP {
	static int[][] dp;

	public static void main(String[] args) {
		int W = 50;
		int N = 3;

		dp = new int[1 + N][1 + W];

		int[] wt = new int[] { 10, 20, 30 };
		int[] val = new int[] { 60, 100, 120 };

		// maxProfit(new int[] { 1, 3, 4, 5 }, new int[] { 1, 4, 5, 7 }, W, N);
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= W; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0; // base case
				} else if (wt[i - 1] <= j) {
					dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[N][W]);
	}

}
