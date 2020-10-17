package com.gfg.algorithms.binarysearch;

public class Prob12_FindElementInInfiniteSortedArray {
	// infinite does nt mean to scare us
	// let l = 0, h = 1 while key is greater than h keep h as h * 2 and l = old end.
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 };
		System.out.println(bsInfi(arr, 7));
	}

	private static int bsInfi(int[] arr, int elem) {
		int l = 0;
		int h = 1;
		while (elem >= arr[h]) {
			l = h;
			h = h * 2;
		}
		return bs(arr, elem, l, h);
	}

	public static int bs(int[] arr, int ele, int l, int h) {
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
