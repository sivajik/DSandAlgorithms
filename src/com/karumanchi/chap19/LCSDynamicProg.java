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

		/*
		 * Recursive Approach is converted to tabular model of DP.
		 */
		/*
		if (m == 0 || n == 0) {
			return "";
		} else if (x.charAt(m - 1) == y.charAt(n - 1)) {
			return LCSRecursiveApproach(x.substring(0, m - 1), y.substring(0, n - 1)) + x.charAt(m - 1);
		} else {
			String p = LCSRecursiveApproach(x.substring(0, m - 1), y);
			String q = LCSRecursiveApproach(x, y.substring(0, n - 1));
			if (p.length() > q.length()) {
				return p;
			} else {
				return q;
			}
		}		 
		 */
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

		StringBuffer sbfr = new StringBuffer();
		for (int X = m, Y = n; X > 0 && Y > 0;) {
			if (table[X][Y] == table[X - 1][Y]) {
				X--;
			} else if (table[X][Y] == table[X][Y - 1]) {
				Y--;
			} else {
				sbfr.append(x.charAt(X - 1));// ][Y]);
				X--;
				Y--;
			}
		}
		System.out.println(sbfr.reverse().toString());
		return "" + table[m][n];/*
								 * ; write theese answers? 234-678= 567+
								 */
	}

	// traditional recursive approach
	static public String LCSRecursiveApproach(String x, String y) {
		int m = x.length();
		int n = y.length();

		if (m == 0 || n == 0) {
			return "";
		} else if (x.charAt(m - 1) == y.charAt(n - 1)) {
			return LCSRecursiveApproach(x.substring(0, m - 1), y.substring(0, n - 1)) + x.charAt(m - 1);
		} else {
			String p = LCSRecursiveApproach(x.substring(0, m - 1), y);
			String q = LCSRecursiveApproach(x, y.substring(0, n - 1));
			if (p.length() > q.length()) {
				return p;
			} else {
				return q;
			}
		}
	}
}
