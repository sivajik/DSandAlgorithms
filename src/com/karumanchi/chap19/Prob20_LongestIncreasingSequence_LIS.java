package com.karumanchi.chap19;

import java.util.Arrays;

public class Prob20_LongestIncreasingSequence_LIS {

	public static void main(String[] args) {
		System.out.println(LIS(new int[] { 5, 6, 2, 3, 4, 1, 9, 9, 8, 9, 5 }));
	}

	static public int LIS(int[] a) {
		int[] lisTable = new int[a.length ];

		Arrays.fill(lisTable, 1);

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && lisTable[i] < lisTable[j] + 1) {
					lisTable[i] = lisTable[j] + 1;
				}
			}
		}

		System.out.println(Arrays.toString(lisTable));
		int max = Integer.MIN_VALUE;
		for (int elem : lisTable) {
			max = Math.max(elem, max);
		}
		return max;
	}
}
