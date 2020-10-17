package com.gfg.algorithms.binarysearch;

public class Prob05_CountOfElementInSortedArray {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 4, 10, 10, 10, 18, 20 };
		int ele = 10;
		int fir = firstPos(arr, ele);
		int las = lastPos(arr, ele);
		if (fir != -1 && las != -1) {
			System.out.println("total occurences: " + (las - fir + 1));
		} else {
			System.out.println("total occurences: " + 0);
		}
	}

	public static int firstPos(int[] arr, int ele) {
		int l = 0;
		int h = arr.length - 1;
		int lastFoundPos = -1;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			if (arr[mid] == ele) {
				lastFoundPos = mid;
				h = mid - 1;
			} else if (ele < arr[mid]) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return lastFoundPos;
	}

	public static int lastPos(int[] arr, int ele) {
		int l = 0;
		int h = arr.length - 1;
		int lastFoundPos = -1;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			if (arr[mid] == ele) {
				lastFoundPos = mid;
				l = mid + 1;
			} else if (ele < arr[mid]) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return lastFoundPos;
	}
}
