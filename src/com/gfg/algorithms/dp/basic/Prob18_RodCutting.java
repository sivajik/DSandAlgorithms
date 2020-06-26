package com.gfg.algorithms.dp.basic;

public class Prob18_RodCutting {

	public static void main(String[] args) {
		System.out.println("Maximum Obtainable Value is " + cutRod(new int[] { 1, 5, 8, 9, 10, 17, 17, 20 }));
		System.out.println("Maximum Obtainable Value is " + cutRod(new int[] { 3, 5, 8, 9, 10, 17, 17, 20 }));

	}

	private static int cutRod(int[] arr) {
		int max = Integer.MIN_VALUE;
		int[] dp = new int[arr.length + 1];

		for (int i = 1; i <= arr.length; i++) {
			for (int j = 0; j < i; j++) {
				max = Math.max(max, arr[j] + dp[i - j - 1]);
			}
			dp[i] = max;
		}
		// TODO Auto-generated method stub
		return dp[arr.length];
	}

}
