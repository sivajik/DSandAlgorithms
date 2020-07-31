package com.dailycodingproblem.easy;

import java.util.Arrays;

public class Prob001_TwoNumbersAddtoSum {

	public static void main(String[] args) {
		System.out.println(doesAddToSum(new int[] { 10, 15, 3, 10 }, 20));
		System.out.println(doesAddToSum(new int[] { 10, 15, 3, 10 }, 120));
		System.out.println(doesAddToSum(new int[] { 10, 15, 3, 10 }, 18));
		System.out.println(doesAddToSum(new int[] { 10, 15, 3, 7 }, 17));
		System.out.println(doesAddToSum(new int[] { 1, 1}, 2));
	}

	public static boolean doesAddToSum(int[] nums, int sum) {
		System.out.println();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int loc = Arrays.binarySearch(nums, 0, nums.length - 1, sum - nums[i]);
			if (loc >= 0 && loc != i) {
				System.out.println(nums[i] + " , " + (sum - nums[i]));
				return true;
			}
		}
		return false;
	}
}
