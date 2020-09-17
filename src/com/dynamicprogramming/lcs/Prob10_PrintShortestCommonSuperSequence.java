package com.dynamicprogramming.lcs;

public class Prob10_PrintShortestCommonSuperSequence {

	public static void main(String[] args) {
		String a = "AGGTAB";
		String b = "GXTXAYB";
		int[][] matrix = new int[a.length() + 1][b.length() + 1];
		System.out.println(shortestCommSupSeqLen(a, b, a.length(), b.length(), matrix));
	}

	/*
	 * shortest super common sub sequence = worst case of concatenated string minus
	 * their LCS. AGGTAB + GXTXAYA => len 13 but it has G(2) T(2) A(2) B(2) coming
	 * so why pick twice
	 * 
	 * to print, when match, print
	 * when mismatch, take maximum side char and move that side.
	 */
	static int shortestCommSupSeqLen(String a, String b, int lenOfA, int lenOfB, int[][] dp) {
		for (int i = 0; i <= lenOfA; i++) {
			for (int j = 0; j <= lenOfB; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		// by now LCS is calcualted.
		int i = lenOfA;
		int j = lenOfB;
		String op = "";
		while (i > 0 && j > 0) {
			if (a.charAt(i - 1) == b.charAt(j - 1)) {
				op = a.charAt(i - 1) + op;
				i--;
				j--;
			} else {
				if (dp[i][j - 1] > dp[i-1][j]) { // before col > above row -> x direction -> means b String
					op = b.charAt(j - 1) + op;
					j--;
				} else { // y direction
					op = a.charAt(i - 1) + op;
					i--;
				}
			}
		}

		while (i > 0) {
			op = a.charAt(i - 1) + op;
			i--;
		}

		while (j > 0) {
			op = b.charAt(j - 1) + op;
			j--;
		}
		System.out.println(op);
		return lenOfA + lenOfB - dp[lenOfA][lenOfB];
	}
}