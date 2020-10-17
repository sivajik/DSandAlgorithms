package com.gfg.algorithms.binarysearch;

public class Prob11_FindNextAlphabet {
	// floor is always keep a note on when you go forward (mid+1)
	// ceil is always keep a note on when you go backward (mid-1)
	public static void main(String[] args) {
		char[] arr = new char[] { 'a', 'c', 'f', 'h' };
		System.out.println(bs(arr, 'b'));
		System.out.println(bs(arr, 'd'));
		System.out.println(bs(arr, 'e'));
		System.out.println(bs(arr, 'g'));
	}

	public static char bs(char[] arr, char ele) {
		char ceil = ' ';
		// char floor = ' ';
		int l = 0;
		int h = arr.length - 1;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			/*if (arr[mid] == ele) {
				return arr[mid];
			} else*/ if (ele < arr[mid]) {
				ceil = arr[mid];
				h = mid - 1;
			} else {
				// floor = arr[mid];
				l = mid + 1;
			}
		}
		System.out.println(/*floor + " -> " + */ ele + " -> " + ceil);
		return ' ';
	}
}
