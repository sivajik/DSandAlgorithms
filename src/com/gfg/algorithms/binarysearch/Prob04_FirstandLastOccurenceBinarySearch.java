package com.gfg.algorithms.binarysearch;

public class Prob04_FirstandLastOccurenceBinarySearch {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 4, 10, 10, 10, 18, 20 };
		System.out.println(firstPos(arr, 10));
		System.out.println(lastPos(arr, 10));
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
