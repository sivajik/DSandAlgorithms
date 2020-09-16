package com.dynamicprogramming.lcs;

public class Prob04_LCSubString_BottomUP {

	public static void main(String[] args) {
		String a = "ABCDGH";
		String b = "ABCXDH";
		int[][] matrix = new int[a.length() + 1][b.length() + 1];
		System.out.println(lenOfLCSubstring(a, b, a.length(), b.length(), matrix));
	}

	static int lenOfLCSubstring(String a, String b, int lenOfA, int lenOfB, int[][] matrix) {
		if (lenOfA == 0 || lenOfB == 0) {
			return 0;
		}

		for (int i = 0; i <= lenOfA; i++) {
			for (int j = 0; j <= lenOfB; j++) {
				if (i == 0 || j == 0) {
					matrix[i][j] = 0;
				} else if (a.charAt(i - 1) == b.charAt(j - 1)) {
					matrix[i][j] = 1 + matrix[i - 1][j - 1];
				} else {
					/*
					 * in case of mismatch if you just stick to old value, then a match found after
					 * few mismatches will do cumulative sum and leads to LCS again.
					 */
					matrix[i][j] = 0;
				}
			}
		}
		return max(matrix);
	}

	private static int max(int[][] matrix) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] > max) {
					max = matrix[i][j];
				}
			}
		}
		return max;
	}
}
