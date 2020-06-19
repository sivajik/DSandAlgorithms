package com.gfg.algorithms.dp.basic;

public class Prob065_MinCostPath {

	public static void main(String[] args) {
		System.out.println(minCost(new int[][] { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } }));
		System.out.println(minCost(new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } }));
	}

	public static int minCost(int[][] cost) {
		int[][] dp = new int[cost.length][cost[0].length];

		dp[0][0] = cost[0][0];
		// first row.
		for (int col = 1; col < cost[0].length; col++) {
			dp[0][col] = dp[0][col - 1] + cost[0][col];
		}

		// first col
		for (int row = 1; row < cost.length; row++) {
			dp[row][0] = dp[row - 1][0] + cost[row][0];
		}

		for (int i = 1; i < cost.length; i++) {
			for (int j = 1; j < cost[i].length; j++) {
				dp[i][j] = cost[i][j] + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}

}
