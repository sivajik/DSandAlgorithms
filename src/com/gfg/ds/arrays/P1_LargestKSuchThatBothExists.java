package com.gfg.ds.arrays;

import java.util.Arrays;

public class P1_LargestKSuchThatBothExists {

	public static void main(String[] args) {
		System.out.println(bothK(new int[] { 3, 2, -2, 5, -3 }));
		System.out.println(bothK(new int[] { 1, 2, 3, -4 }));
	}

	static public int bothK(int[] arr) {
		Arrays.sort(arr);
		int left = 0;
		int rite = arr.length - 1;

		while (left < rite) {
			if (arr[left] == -1 * arr[rite]) {
				return Math.abs(arr[left]);
			} else if (arr[left] < arr[rite]) {
				// -3 5
				rite--;
			} else {
				left++;
			}
		}
		return -1;
	}
}
