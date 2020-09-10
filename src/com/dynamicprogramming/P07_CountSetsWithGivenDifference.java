package com.dynamicprogramming;

import java.util.Arrays;

public class P07_CountSetsWithGivenDifference {

	public static void main(String[] args) {
		System.out.println(countSubSetsWithGivenDiff(new int[] { 1, 1, 2, 3 }, 1));
	}

	static int countSubSetsWithGivenDiff(int[] arr, int diff) {
		int sum = 0;
		for (int elem : arr) {
			sum += elem;
		}

		if ((sum + diff) % 2 != 0) {
			return 0; // odd number
		}

		return countOfSubsetWithGivenSum(arr, (sum + diff) / 2);
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

	private static void print(boolean[][] dp) {
		System.out.println("====================");
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				System.out.print((dp[i][j] ? "T" : "F") + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
