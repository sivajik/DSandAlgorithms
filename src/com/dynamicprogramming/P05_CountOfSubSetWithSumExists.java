package com.dynamicprogramming;

import java.util.Arrays;

public class P05_CountOfSubSetWithSumExists {

	public static void main(String[] args) {
		System.out.println(countOfSubsetWithGivenSum(new int[] { 2, 3, 5, 6, 8, 10 }, 10));
	}

	static int countOfSubsetWithGivenSum(int[] arr, int givenSum) {
		int[][] dp = new int[arr.length + 1][givenSum + 1];

		Arrays.fill(dp[0], 0);
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		print(dp);

		for (int i = 1; i <= arr.length; i++) {
			for (int j = 1; j <= givenSum; j++) {
				if (arr[i - 1] <= j) {
					// include
					dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		print(dp);
		return dp[arr.length][givenSum];
	}

	private static void print(int[][] dp) {
		System.out.println("====================");
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

/*
	1 0 0 0 0 0 0 0 0 0 0 
2	1 0 1 0 0 0 0 0 0 0 0 
3	1 0 1 1 0 1 0 0 0 0 0 
5	1 0 1 1 0 2 0 1 1 0 1 
6	1 0 1 1 0 2 1 1 2 1 1 
8	1 0 1 1 0 2 1 1 3 1 2 
t	1 0 1 1 0 2 1 1 3 1 3 

*/