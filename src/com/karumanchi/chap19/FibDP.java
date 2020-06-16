package com.karumanchi.chap19;

public class FibDP {

	public static void main(String[] args) {
		System.out.println(fibBottomsUp(n)); // 0 1 1 2 3 5 8 13 21
		System.out.println(fibTopDown(n));
	}

	static int fibBottomsUp(int n) {
		int[] fibNumbers = new int[n + 1];
		fibNumbers[0] = 0;
		fibNumbers[1] = 1;

		for (int i = 2; i <= n; i++) {
			fibNumbers[i] = fibNumbers[i - 1] + fibNumbers[i - 2];
		}
		return fibNumbers[n];
	}

	static int n = 7;
	static int[] fff = new int[n + 1];

	static int fibTopDown(int val) {
		if (val == 1 || val == 2) {
			return 1;
		}

		if (fff[val] != 0) {
			return fff[val];
		}
		fff[val] = fibTopDown(val - 1) + fibTopDown(val - 2);
		return fff[val];
	}
}
