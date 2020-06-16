package com.karumanchi.chap19;

import java.util.Arrays;

public class LCSDynamicProg {

	public static void main(String[] args) {
		System.out.println(LCSDynamicProg("ABCBDAB", "BDCABA"));
	}

	static public String LCSDynamicProg(String x, String y) {
		int m = x.length();
		int n = y.length();
		int[][] table = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					table[i][j] = 0;
				} else if (x.charAt(i - 1) == y.charAt(j - 1)) {
					table[i][j] = table[i - 1][j - 1] + 1;
				} else {
					table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
				}
			}
		}

		System.out.println();

		for (int i = 0; i < m + 1; i++) {
			System.out.println(Arrays.toString(table[i]));
		}

		return "" + table[m][n];/*
								 * ; write theese answers? 234-678= 567+
								 */
	}
}
