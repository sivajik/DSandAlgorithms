package com.gfg.algorithms.binarysearch;

public class Prob01_BinarySearch {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 12, 23, 34, 45, 56, 67, 78, 89 };
		for (int ele : arr) {
			System.out.println(bs(arr, ele));
		}
	}

	public static int bs(int[] arr, int ele) {
		int l = 0;
		int h = arr.length - 1;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			if (arr[mid] == ele) {
				return mid;
			} else if (ele < arr[mid]) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}
}
