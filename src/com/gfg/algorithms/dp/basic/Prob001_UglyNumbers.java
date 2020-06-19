package com.gfg.algorithms.dp.basic;

import java.util.Arrays;

public class Prob001_UglyNumbers {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(nextUglyNumer(150)));
	}

	static int[] nextUglyNumer(int n) {
		int[] uglyNumbers = new int[n];
		uglyNumbers[0] = 1;

		int next2 = 2;
		int next3 = 3;
		int next5 = 5;

		int i2 = 0, i3 = 0, i5 = 0;

		for (int i = 1; i < n; i++) {
			int nextUglyNumber = Math.min(next2, Math.min(next3, next5));
			uglyNumbers[i] = nextUglyNumber;

			if (nextUglyNumber == next2) {
				i2++;
				next2 = uglyNumbers[i2] * 2;
			}
			if (nextUglyNumber == next3) {
				i3++;
				next3 = uglyNumbers[i3] * 3;
			}
			if (nextUglyNumber == next5) {
				i5++;
				next5 = uglyNumbers[i5] * 5;

			}

		}
		return uglyNumbers;
	}

}
