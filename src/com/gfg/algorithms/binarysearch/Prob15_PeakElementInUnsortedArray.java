package com.gfg.algorithms.binarysearch;

public class Prob15_PeakElementInUnsortedArray {
	// Peak elem == element greater than both of its side elements
	public static void main(String[] args) {
		int[] arr = new int[] { 5, 10, 20, 15 };
		System.out.println(bsInfi(arr));
	}

	public static int bsInfi(int[] arr) {
		int l = 0;
		int h = arr.length - 1;
		while (l <= h) {
			int mid = l + (h - l) / 2;

			if (mid > 0 && mid < arr.length - 1) {
				if (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1]) {
					return arr[mid];
				} else if (arr[mid] < arr[mid - 1]) {
					h = mid - 1;
				} else {
					l = mid + 1;
				}
			} else { //edge case of first element, since it has no left jst check with arr[1]
				if (mid == 0) {
					//edge case of first element, since it has no left jst check with arr[1]
					if (arr[mid] > arr[mid + 1]) {
						return arr[mid];
					}
				} else if (mid == arr.length - 1) {
					//edge case of last element, since it has no right jst check with arr[mid-1]
					if (arr[mid] > arr[mid - 1]) {
						return arr[mid];
					}
				}
			}

		}
		return -1;
	}
}
