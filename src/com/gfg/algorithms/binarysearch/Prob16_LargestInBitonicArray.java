package com.gfg.algorithms.binarysearch;

public class Prob16_LargestInBitonicArray {
	// Bitonic == gradually increassing and gradually decreasing
	// no two adj elements are same
	
	// max element in bitonic == same as peak element in the array.
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 8, 0, 4, 2 };
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
