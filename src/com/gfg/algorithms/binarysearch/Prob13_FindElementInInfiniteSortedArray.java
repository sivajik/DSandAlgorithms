package com.gfg.algorithms.binarysearch;

public class Prob13_FindElementInInfiniteSortedArray {
	// infinite does nt mean to scare us
	// let l = 0, h = 1 while key is greater than h keep h as h * 2 and l = old end.
	// in such array find "FIRST" occurrence of digit 1.
	public static void main(String[] args) {
		int[] arr = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };
		System.out.println(bsInfi(arr, 1));
	}

	private static int bsInfi(int[] arr, int elem) {
		int l = 0;
		int h = 1;
		while (h < arr.length && elem >= arr[h]) { // if its infinite array we dont need "h < arr.length" check
			l = h;
			h = h * 2;
		}
		// found possible indexes where 1 could come.
		return bs(arr, elem, l, h);
	}

	public static int bs(int[] arr, int ele, int l, int h) {
		int found = -1;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			if (arr[mid] == ele) {
				found = mid;
				h = mid - 1;
			} else if (ele < arr[mid]) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return found;
	}
}
