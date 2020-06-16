package com.karumanchi.chap19;

public class Prob06_LongestSum {

	public static void main(String[] args) {
		System.out.println(maxSum(new int[] { -200, 11, -4, 13, -5, 2 }));
	}

// -4 -3 10
	static public int maxSum(int[] nums) {
		int maxSum = nums[0];
		int maxSumSoFar = 0;
		for (int i = 0; i < nums.length; i++) {
			maxSumSoFar = Math.max(maxSumSoFar + nums[i], nums[i]);
			if (maxSumSoFar > maxSum) {
				maxSum = maxSumSoFar;
			}
		}
		return maxSum;
	}
}
