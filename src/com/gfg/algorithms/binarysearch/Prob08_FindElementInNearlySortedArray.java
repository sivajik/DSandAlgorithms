package com.gfg.algorithms.binarysearch;

public class Prob08_FindElementInNearlySortedArray {
	// search at mid, mid-1, mid+1 as nearly sorted differs by 1 index only
	// once index is do +2 or -2
	public static void main(String[] args) {
		int[] arr = new int[] { 11, 12, 15, 17, 16, 18, 20 };
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
			} else if (mid - 1 >= l && arr[mid - 1] == ele) {
				return mid - 1;
			} else if (mid + 1 <= h && arr[mid + 1] == ele) {
				return mid + 1;
			} else if (ele < arr[mid]) {
				h = mid - 2;
			} else {
				l = mid + 2;
			}
		}
		return -1;
	}
}
