package com.dynamicprogramming.lcs;

public class Prob03_LCS_BottomUP {

	public static void main(String[] args) {
		String a = "ABCDGH";
		String b = "AEDFHR";
		int[][] matrix = new int[a.length() + 1][b.length() + 1];
		System.out.println(lengthOfLCS(a, b, a.length(), b.length(), matrix));

		a = "AGGTAB";
		b = "GXTXAYB";
		matrix = new int[a.length() + 1][b.length() + 1];
		System.out.println(lengthOfLCS(a, b, a.length(), b.length(), matrix));
	}

	static int lengthOfLCS(String a, String b, int lenOfA, int lenOfB, int[][] matrix) {
		if (lenOfA == 0 || lenOfB == 0) {
			return 0;
		}

		fill(matrix);

		for (int i = 1; i <= lenOfA; i++) {
			for (int j = 1; j <= lenOfB; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					matrix[i][j] = 1 + matrix[i - 1][j - 1];
				} else {
					int p = matrix[i - 1][j];// lengthOfLCS(a, b, lenOfA - 1, lenOfB, matrix);
					int q = matrix[i][j - 1];// lengthOfLCS(a, b, lenOfA, lenOfB - 1, matrix);
					matrix[i][j] = Math.max(p, q);
				}
			}
		}
		return matrix[lenOfA][lenOfB];
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
