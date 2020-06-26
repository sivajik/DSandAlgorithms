package com.gfg.algorithms.dp.intermediate;

public class Prob104_MaxSubSquareWithAllEqualElements {
	public static void main(String[] args) {
		int[][] a = { 
				{ 2, 2, 3, 3, 4, 4 }, 
				{ 5, 5, 7, 7, 7, 4 }, 
				{ 1, 2, 7, 7, 7, 4 }, 
				{ 4, 4, 7, 7, 7, 4 },
				{ 5, 5, 5, 1, 2, 7 }, 
				{ 8, 7, 9, 4, 4, 4 } };

		System.out.println(largestKSubmatrix(a));
	}

	private static int largestKSubmatrix(int[][] a) {
		int[][] dp = new int[a.length][a[0].length];
		int result = Integer.MIN_VALUE;
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 1;
				} else {
					if (a[i - 1][j - 1] == a[i - 1][j] && a[i - 1][j] == a[i][j - 1]) {
						dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
					} else {
						dp[i][j] = 1;
					}
				}
				result = Math.max(result, dp[i][j]);
			}
		}
		return result;
	}
}
