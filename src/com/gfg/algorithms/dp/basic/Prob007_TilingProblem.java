package com.gfg.algorithms.dp.basic;

public class Prob007_TilingProblem {

	public static void main(String[] args) {
		System.out.println(getTotalWaysToTile(1));
		System.out.println(getTotalWaysToTile(2));
		System.out.println(getTotalWaysToTile(3));
		System.out.println(getTotalWaysToTile(4));
	}

	static public int getTotalWaysToTile(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 2;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n - 1];
	}
}
