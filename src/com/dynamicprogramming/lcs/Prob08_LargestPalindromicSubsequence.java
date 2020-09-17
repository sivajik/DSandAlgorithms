package com.dynamicprogramming.lcs;

public class Prob08_LargestPalindromicSubsequence {

	public static void main(String[] args) {
		String a = "AGBCBA";
		String b = new StringBuffer(a).reverse().toString();// "ABCDHR";
		int[][] matrix = new int[a.length() + 1][b.length() + 1];
		System.out.println(largerstPalindromicSubseq(a, b, a.length(), b.length(), matrix));
	}

	/*
	 * Largest palindromic subseq = LCS of given string, and its reverse.
	 */
	static String largerstPalindromicSubseq(String a, String b, int lenOfA, int lenOfB, int[][] matrix) {
		lcs(a, b, lenOfA, lenOfB, matrix);
		System.out.println("Len: " + matrix[lenOfA][lenOfB]);
		String op = "";

		int i = lenOfA;
		int j = lenOfB;

		while (i >= 1 && j >= 1) {
			if (a.charAt(i - 1) == b.charAt(j - 1)) {
				// matching case;
				op = a.charAt(i - 1) + op;
				i = i - 1;
				j = j - 1;
			} else {
				if (matrix[i][j] == matrix[i - 1][j]) {
					i = i - 1;
				} else {
					j = j - 1;
				}
			}
		}
		return op;
	}

	private static void lcs(String a, String b, int lenOfA, int lenOfB, int[][] matrix) {
		if (lenOfA == 0 || lenOfB == 0) {
			return;
		}

		for (int i = 0; i <= lenOfA; i++) {
			for (int j = 0; j <= lenOfB; j++) {
				if (i == 0 || j == 0) {
					matrix[i][j] = 0;
				} else if (a.charAt(i - 1) == b.charAt(j - 1)) {
					matrix[i][j] = 1 + matrix[i - 1][j - 1];
				} else {
					int p = matrix[i - 1][j];// lengthOfLCS(a, b, lenOfA - 1, lenOfB, matrix);
					int q = matrix[i][j - 1];// lengthOfLCS(a, b, lenOfA, lenOfB - 1, matrix);
					matrix[i][j] = Math.max(p, q);
				}
			}
		}
	}
}
