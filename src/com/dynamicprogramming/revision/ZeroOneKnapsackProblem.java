package com.dynamicprogramming.revision;

public class ZeroOneKnapsackProblem {

	public static void main(String[] args) {
		int W = 50;
		int N = 3;

		int[][] dp = new int[1 + N][1 + W];

		int[] wt = new int[] { 10, 20, 30 };
		int[] val = new int[] { 60, 100, 120 };
		
		// i : N
		// j: Weights
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < W + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else {
					if (wt[i - 1] <= j) {
						// val[n-1] + knapsack(vals, wt, W-wt[n-1], n-1)
						dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
					} else {
						// knapsack(wt, val, W, n-1);
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
		}
		System.out.println(dp[N][W]);
	}
}
