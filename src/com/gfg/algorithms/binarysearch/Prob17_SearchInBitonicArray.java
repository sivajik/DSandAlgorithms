package com.gfg.algorithms.binarysearch;

import java.util.Arrays;

public class Prob17_SearchInBitonicArray {
	// Bitonic == gradually increassing and gradually decreasing
	// no two adj elements are same

	// get the max element index. then do eitehr LEFT array BS or
	// right array BS.
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 8, 12, 4, 2 };
		System.out.println(bsInfi(arr, 4));
	}

	public static int bsInfi(int[] arr, int ele) {
		int l = 0;
		int h = arr.length - 1;
		int indexOfPeakElem = -1;
		while (l <= h) {
			int mid = l + (h - l) / 2;

			if (mid > 0 && mid < arr.length - 1) {
				if (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1]) {
					indexOfPeakElem = mid;
					break;
				} else if (arr[mid] < arr[mid - 1]) {
					h = mid - 1;
				} else {
					l = mid + 1;
				}
			} else { // edge case of first element, since it has no left jst check with arr[1]
				if (mid == 0) {
					// edge case of first element, since it has no left jst check with arr[1]
					if (arr[mid] > arr[mid + 1]) {
						indexOfPeakElem = mid;
						break;
					}
				} else if (mid == arr.length - 1) {
					// edge case of last element, since it has no right jst check with arr[mid-1]
					if (arr[mid] > arr[mid - 1]) {
						indexOfPeakElem = mid;
						break;
					}
				}
			}
		}

		int[] la = Arrays.copyOfRange(arr, 0, indexOfPeakElem);
		int leftFound = Arrays.binarySearch(la, ele);
		
		int[] ra = Arrays.copyOfRange(arr, 1 + indexOfPeakElem, arr.length);
		/*
		 * here ra[] needs to be reversed for correct answer
		 * as its going down in descending order so Array.binarySearch cant be used 
		 */
		int rightFound = Arrays.binarySearch(ra, ele);

		if (leftFound >= 0) {
			return arr[leftFound];
		} else if (rightFound >= 0) {
			return arr[rightFound + 1 + indexOfPeakElem];
		} else {
			return -1;
		}
	}
}
