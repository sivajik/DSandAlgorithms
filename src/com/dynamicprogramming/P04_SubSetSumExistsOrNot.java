package com.dynamicprogramming;

import java.util.Arrays;

public class P04_SubSetSumExistsOrNot {

	public static void main(String[] args) {
		System.out.println(subsetSumExistsOrNot(new int[] { 2, 3, 7, 8, 10 }, 11));
	}

	static boolean subsetSumExistsOrNot(int[] arr, int givenSum) {
		boolean[][] dp = new boolean[arr.length + 1][givenSum + 1];

		Arrays.fill(dp[0], false);
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = true;
		}
		print(dp);

		for (int i = 1; i <= arr.length; i++) {
			for (int j = 1; j <= givenSum; j++) {
				if (arr[i-1] <= j) {
					// include
					dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		print(dp);
		return dp[arr.length][givenSum];
	}

	private static void print(boolean[][] dp) {
		System.out.println("====================");
		for (int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[i].length; j++) {
				System.out.print( (dp[i][j] ? "T" : "F") + " ");
			}
			System.out.println();
		}
	}
}
