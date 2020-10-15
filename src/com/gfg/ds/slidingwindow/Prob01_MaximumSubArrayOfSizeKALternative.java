package com.gfg.ds.slidingwindow;

public class Prob01_MaximumSubArrayOfSizeKALternative {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 5, 1, 8, 2, 9, 1 };
		int k = 3;

		int sum = 0;
		int result = Integer.MIN_VALUE;
		int i = 0, j = 0;
		while (j < arr.length) {
			sum += arr[j];

			if (j - i + 1 < k) {
				// sliding window not yet reached
				j++;
			} else if (j - i + 1 == k) {
				// window reached now.
				result = Math.max(result, sum);
				sum = sum - arr[i];
				i++;
				j++;
			}
		}
		System.out.println(result);
	}

}
