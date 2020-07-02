package com.gfg.algorithms.dp.basic;

import java.util.Arrays;

public class Prob34_LongestIncreasingSubsequence_LIS {

	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;
		System.out.println("Length of lis is " + lis(arr, n) + "\n");
	}

	private static int lis(int[] a, int n) {
		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		int max = Integer.MIN_VALUE;
		for (int ele : dp) {
			max = Math.max(ele, max);
		}
		int tempMax = max;
		for (int j = a.length - 1; j >= 0; j--) {
			if (dp[j] == max) {
				System.out.print(a[j] + ", ");
				max--;
			}
		}
		System.out.println();
		return tempMax;
	}

}
