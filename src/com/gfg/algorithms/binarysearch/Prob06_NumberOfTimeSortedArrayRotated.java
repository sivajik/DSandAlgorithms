package com.gfg.algorithms.binarysearch;

public class Prob06_NumberOfTimeSortedArrayRotated {
	// num of times rotated === index of smallest number
	public static void main(String[] args) {
		int[] arr = new int[] { 11, 12, 15, 1, 2, 5, 6, 8 };
		System.out.println(numberOftimesRotated(arr));
	}

	public static int numberOftimesRotated(int[] arr) {
		int l = 0;
		int h = arr.length - 1;
		int n = arr.length + 1;
		int pivot = -1;
		while (l <= h) {
			if (arr[l] <= arr[h]) {
				return l;
			}

			int mid = l + (h - l) / 2;
			int prev = (mid + n - 1) % n;
			int next = (mid + 1) % n;

			if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
				pivot = mid;// smaller than both neighbours. so this is THE smallest.
				break; // MUST BREAK here.
			} else if (arr[l] <= arr[mid]) {
				// start to mid is sorted but we need to go "unsorted" path to get min ele.
				// here right array is not sorted
				l = mid + 1;
			} else if (arr[mid] <= arr[h]) {
				// left array is not sorted so go left then..
				h = mid - 1;
			}
		}
		System.out.println(l + " , " + h);
		return pivot;
	}
}
