package com.gfg.algorithms.dp.intermediate;

public class Prob64_MinNumOfCoinsForGivenChange {

	public static void main(String[] args) {
		int coins[] = { 9, 6, 5, 1 };
		int m = coins.length;
		int V = 11;
		System.out.println("Minimum coins required is " + minCoins(coins, m, V));
	}

	private static int minCoins(int[] coins, int m, int v) {
		int[][] dp = new int[m + 1][v + 1];

		for (int row = 0; row < m + 1; row++) {
			dp[row][0] = 0;
		}

		for (int col = 0; col < v + 1; col++) {
			dp[0][col] = Integer.MAX_VALUE;
		}

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < v + 1; j++) {
				if (j >= coins[i - 1] && dp[i][j - coins[i - 1]] != Integer.MAX_VALUE) {
					dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[m][v];
	}

}
