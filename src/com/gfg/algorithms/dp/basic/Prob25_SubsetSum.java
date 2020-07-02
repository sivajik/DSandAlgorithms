package com.gfg.algorithms.dp.basic;

public class Prob25_SubsetSum {

	public static void main(String[] args) {
		int set[] = { 2, 3, 7, 8 };
		int sum = 11;

		System.out.println(isSubsetSum(set, sum));
	}

	private static boolean isSubsetSum(int[] set, int sum) {
		boolean[][] dp = new boolean[set.length + 1][sum + 1];

		for (int i = 0; i <= set.length; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= set.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j - set[i - 1] >= 0) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[set.length][sum];
	}
}
