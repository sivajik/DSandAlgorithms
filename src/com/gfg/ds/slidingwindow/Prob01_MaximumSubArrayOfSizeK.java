package com.gfg.ds.slidingwindow;

public class Prob01_MaximumSubArrayOfSizeK {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 5, 1, 8, 2, 9, 1 };
		int k = 3;

		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}

		int result = sum;
		for (int i = 1; i <= arr.length - k; i++) {
			int newSum = sum + arr[i + k - 1] - arr[i - 1];
			result = Math.max(result, newSum);
			sum = newSum;
		}
		System.out.println(result);
	}

}
