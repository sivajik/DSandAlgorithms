package com.gfg.algorithms.binarysearch;

public class Prob14_MinDifferenceElementInSortedArray {
	// Abs diff between key and each elem should be as min as possible
	// return that number
	// if given elem EXISTS then zero would be diff and return that num
	// or else return ceil, floor of that number and see min diff between them.
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 6, 10, 12, 15 };
		System.out.println(bsInfi(arr, 9));
	}

	private static int bsInfi(int[] arr, int elem) {
		int found = bs(arr, elem, 0, arr.length - 1);
		if (found != -1) {
			return arr[found];
		} else {
			int ceil = ceil(arr, elem);
			int flr = floor(arr, elem);
			if (Math.abs(elem - ceil) < Math.abs(elem - flr)) {
				return ceil;
			} else {
				return flr;
			}
		}
	}

	// 1, 3, 8, 9, 10, 12, 15 ; 11
	private static int floor(int[] arr, int elem) {
		int l = 0, h = arr.length - 1;
		int flr = -1;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			// we knew that ele did nt exists in the array
			/*
			 * if (arr[mid] == elem) { return mid; } else
			 */ if (elem < arr[mid]) {
				h = mid - 1;
			} else {
				flr = arr[mid];
				l = mid + 1;
			}
		}
		return flr;

	}

	private static int ceil(int[] arr, int elem) {
		int l = 0, h = arr.length - 1;
		int ceil = -1;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			// we knew that ele did nt exists in the array
			/*
			 * if (arr[mid] == ele) { return mid; } else
			 */ if (elem < arr[mid]) {
				ceil = arr[mid];
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return ceil;

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
