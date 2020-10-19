package com.gfg.algorithms.binarysearch;

public class Prob19_AllocatePagesOfBooks {
	// https://www.youtube.com/watch?v=2JSQIhPcHQg&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=21
	public static void main(String[] args) {
		int[] arr = new int[] { 10, 20, 30, 40 };
		System.out.println(allocatePagesOfBooks(arr, 2));

	}

	public static int allocatePagesOfBooks(int[] arr, int studCount) {
		int left = max(arr);
		int right = sum(arr);
		int result = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (isValid(arr, arr.length, studCount, mid)) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return result;
	}

	private static boolean isValid(int[] arr, int length, int studCount, int mx) {
		int stu = 1;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum > mx) {
				stu++;
				sum = arr[i];
			}
			if (stu > studCount) {
				return false;
			}
		}
		return true;
	}

	private static int max(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int e : arr) {
			max = Math.max(max, e);
		}
		return max;
	}

	private static int sum(int[] arr) {
		int sum = 0;
		for (int e : arr) {
			sum += e;
		}
		return sum;
	}
}
