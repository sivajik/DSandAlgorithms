package com.dynamicprogramming.lcs;

public class Prob09a_MiniNumInsertionsToMakePalindrome {

	public static void main(String[] args) {
		String a = "AGBCBA";
		String b = new StringBuffer(a).reverse().toString();
		int[][] matrix = new int[a.length() + 1][b.length() + 1];
		minNumOfDelToMakePalindrome(a, b, a.length(), b.length(), matrix);
	}

	/*
	 * minNumOf"Insertions"ToMakePalindrome = 
	 * 	find largest palindrome and chop it off from main string.
	 * 
	 * 
	 * THIS IS SAME AS DELETIONS. FOR EACH PAIR NOT MATCHING JUST INSERT THEM BACK.
	 */
	static void minNumOfDelToMakePalindrome(String a, String b, int lenOfA, int lenOfB, int[][] matrix) {
		lcs(a, b, lenOfA, lenOfB, matrix);
		System.out.println("Len: " + matrix[lenOfA][lenOfB]);
		System.out.println("Min Del to make palidrome: " + (lenOfA - matrix[lenOfA][lenOfB]));
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
