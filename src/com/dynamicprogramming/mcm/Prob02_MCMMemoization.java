package com.dynamicprogramming.mcm;

public class Prob02_MCMMemoization {

	public static void main(String[] args) {
		System.out.println(calcMCMMinCost(new int[] { 40, 20, 30, 10, 30 }));
		System.out.println(calcMCMMinCost(new int[] { 10, 20, 30, 40, 30 }));
		System.out.println(calcMCMMinCost(new int[] { 10, 20, 30 }));
	}

	static int[][] dp ;
	static int calcMCMMinCost(int[] arr) {
		dp = new int[arr.length+1][arr.length+1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = -1;
			}
		}
		
		return solve(arr, 1, arr.length - 1);
	}

	static int solve(int[] arr, int i, int j) {
		if (i >= j) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		
		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int tempAns = solve(arr, i, k) + solve(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
			// System.out.println("temp answer: " + tempAns);
			if (tempAns < min) {
				min = tempAns;
			}
		}
		return (dp[i][j] = min);
	}
}
