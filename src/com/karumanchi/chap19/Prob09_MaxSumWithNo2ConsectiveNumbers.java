package com.karumanchi.chap19;

public class Prob09_MaxSumWithNo2ConsectiveNumbers {

	public static void main(String[] args) {
		System.out.println(maxSumWithNoTwoConsecutiveNumbers(new int[] { 1, 2, 3, 4, 5 }));

	}

	static public int maxSumWithNoTwoConsecutiveNumbers(int[] a) {
		int[] m = new int[a.length + 1];

		m[0] = a[0];
		m[1] = Math.max(a[0], a[1]);
		for (int i = 2; i < a.length; i++) {
			if (a[i] + m[i - 2] > m[i - 1]) {
				m[i] = a[i] + m[i - 2];
			} else {
				m[i] = m[i - 1];
			}
		}
		return m[a.length - 1];
	}
}
