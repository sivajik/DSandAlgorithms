package com.gfg.algorithms.binarysearch;

public class Prob07_FindElementInSortedArray {
	// num of times rotated === index of smallest number
	public static void main(String[] args) {
		int[] arr = new int[] { 11, 12, 15, 1, 2, 5, 6, 8 };
		int minIndex = (numberOftimesRotated(arr));
		for (int i = 0; i < arr.length; i++) {// int elem : arr) { // int elem = 15;
			if (i < minIndex) {
				System.out.println(bs(arr, 0, minIndex - 1, arr[i]));
			} else if (i >= minIndex) {
				System.out.println(bs(arr, minIndex, arr.length - 1, arr[i]));
			}
		}
	}

	public static int numberOftimesRotated(int[] arr) {
		int l = 0;
		int h = arr.length - 1;
		int n = arr.length + 1;
		while (l <= h) {
			if (arr[l] <= arr[h]) {
				return l;
			}

			int mid = l + (h - l) / 2;
			int prev = (mid + n - 1) % n;
			int next = (mid + 1) % n;

			if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
				return mid;// smaller than both neighbours. so this is THE smallest.
			} else if (arr[l] <= arr[mid]) {
				// start to mid is sorted but we need to go "unsorted" path to get min ele.
				// here right array is not sorted
				l = mid + 1;
			} else if (arr[mid] <= arr[h]) {
				// left array is not sorted so go left then..
				h = mid - 1;
			}
		}
		return -1;
	}

	public static int bs(int[] arr, int l, int h, int ele) {
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
