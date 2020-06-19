package com.gfg.algorithms.dp.basic;

public class Prob003_NthCatalanNumber {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.print(catalanDP(i) + " ");
		}
	}

	static int catalanDP(int n) {
		int[] catalanNumbers = new int[n + 2];
		catalanNumbers[0] = 1;
		catalanNumbers[1] = 1;
		for (int i = 2; i <= n; i++) {
			catalanNumbers[i] = 0;
			for (int j = 0; j < i; j++) {
				catalanNumbers[i] += catalanNumbers[j] * catalanNumbers[i - j - 1];
			}
		}

		return catalanNumbers[n];
	}
}
