package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class P06_MinimumSubsetDifference {

	public static void main(String[] args) {
		System.out.println(minimumSubsetDiff(new int[] { 1, 2, 7 }));
		System.out.println(minimumSubsetDiff(new int[] { 1, 6, 11, 5 }));
		System.out.println(minimumSubsetDiff(new int[] { 3, 1, 4, 2, 2, 1}));
	}

	static int minimumSubsetDiff(int[] arr) {
		int sum = 0;
		for (int elem : arr) {
			sum += elem;
		}

		boolean[][] dp = new boolean[arr.length + 1][sum + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		print(dp);

		List<Integer> l = new ArrayList<>();
		for (int j = 0; j <= dp[0].length / 2; j++) {
			if (dp[arr.length][j]) {
				l.add(j);
			}
		}

		int min = Integer.MAX_VALUE;
		for (int eachElem : l) {
			min = Math.min(min, Math.abs(sum - (2 * eachElem)));
		}

		return min;
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
