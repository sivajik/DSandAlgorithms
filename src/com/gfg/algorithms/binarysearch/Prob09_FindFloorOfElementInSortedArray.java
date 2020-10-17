package com.gfg.algorithms.binarysearch;

public class Prob09_FindFloorOfElementInSortedArray {
	// floor is always keep a note on when you go forward (mid+1)
	// ceil is always keep a note on when you go backward (mid-1)
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 8, 10, 10, 12, 19 };
		System.out.println(bs(arr, 5));
	}

	public static int bs(int[] arr, int ele) {
		int ceil = -1;
		int floor = -1;
		int l = 0;
		int h = arr.length - 1;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			if (arr[mid] == ele) {
				return mid;
			} else if (ele < arr[mid]) {
				ceil = arr[mid];
				h = mid - 1;
			} else {
				floor = arr[mid];
				l = mid + 1;
			}
		}
		System.out.println(floor + " -> " + ele + " -> " + ceil);
		return -1;
	}
}
