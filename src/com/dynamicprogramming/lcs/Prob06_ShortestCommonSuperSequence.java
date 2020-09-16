package com.dynamicprogramming.lcs;

public class Prob06_ShortestCommonSuperSequence {

	public static void main(String[] args) {
		String a = "AGGTAB";
		String b = "GXTXAYB";
		int[][] matrix = new int[a.length() + 1][b.length() + 1];
		System.out.println(shortestCommSupSeqLen(a, b, a.length(), b.length(), matrix));
	}

	/*
	 * shortest super common sub sequnece = worst case of concatenated string minus
	 * their LCS. AGGTAB + GXTXAYA => len 13 but it has G(2) T(2) A(2) B(2) coming
	 * so why pick twice
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
		return lenOfA + lenOfB - dp[lenOfA][lenOfB];
	}
}