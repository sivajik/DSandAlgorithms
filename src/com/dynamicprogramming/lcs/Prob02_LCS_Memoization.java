package com.dynamicprogramming.lcs;

public class Prob02_LCS_Memoization {

	public static void main(String[] args) {
		String a = "ABCDGH";
		String b = "AEDFHR";
		int[][] matrix = new int[a.length() + 1][b.length() + 1];
		fill(matrix);
		System.out.println(lengthOfLCS(a, b, a.length(), b.length(), matrix));

		a = "AGGTAB";
		b = "GXTXAYB";
		matrix = new int[a.length() + 1][b.length() + 1];
		fill(matrix);
		System.out.println(lengthOfLCS(a, b, a.length(), b.length(), matrix));
	}

	static int lengthOfLCS(String a, String b, int lenOfA, int lenOfB, int[][] matrix) {
		if (lenOfA == 0 || lenOfB == 0) {
			return 0;
		}

		if (matrix[lenOfA][lenOfA] != -1) {
			return matrix[lenOfA][lenOfA];
		}
		if (a.charAt(lenOfA - 1) == b.charAt(lenOfB - 1)) {
			return (matrix[lenOfA][lenOfB] = 1 + lengthOfLCS(a, b, lenOfA - 1, lenOfB - 1, matrix));
		} else {
			int p = lengthOfLCS(a, b, lenOfA - 1, lenOfB, matrix);
			int q = lengthOfLCS(a, b, lenOfA, lenOfB - 1, matrix);
			return (matrix[lenOfA][lenOfB] = Math.max(p, q));
		}
	}

	public static void fill(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (i == 0 || j == 0) {
					m[i][j] = 0;
				} else {
					m[i][j] = -1;
				}
			}
		}
	}
}
