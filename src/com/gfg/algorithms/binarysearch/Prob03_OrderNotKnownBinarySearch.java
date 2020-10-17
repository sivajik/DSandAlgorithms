package com.gfg.algorithms.binarysearch;

public class Prob03_OrderNotKnownBinarySearch {

	public static void main(String[] args) {
		int[] arr = new int[] { 89, 78, 67, 55, 45, 34, 23, 12, 1 };
		for (int ele : arr) {
			System.out.println(bs(arr, ele));
		}
		System.out.println();
		arr = new int[] { 1, 12, 23, 34, 45, 56, 67, 78, 89 };
		for (int ele : arr) {
			System.out.println(bs(arr, ele));
		}

	}

	public static int bs(int[] arr, int ele) {
		boolean asc = arr[0] < arr[1];

		int l = 0;
		int h = arr.length - 1;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			if (arr[mid] == ele) {
				return mid;
			} else if (asc) {
				if (ele < arr[mid]) {
					h = mid - 1;
				} else {
					l = mid + 1;
				}
			} else if (!asc) {
				if (ele < arr[mid]) {
					l = mid + 1;
				} else {
					h = mid - 1;
				}
			}
		}
		return -1;
	}

}
