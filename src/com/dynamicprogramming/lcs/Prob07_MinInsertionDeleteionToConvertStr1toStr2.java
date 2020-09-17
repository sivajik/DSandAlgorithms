package com.dynamicprogramming.lcs;

public class Prob07_MinInsertionDeleteionToConvertStr1toStr2 {

	public static void main(String[] args) {
		String a = "HEAP";
		String b = "PEA";
		int[][] matrix = new int[a.length() + 1][b.length() + 1];
		countMinNumOfInsertionsDeletions(a, b, a.length(), b.length(), matrix);
		System.out.println();
		a = "PEA";
		b = "HEAP";
		matrix = new int[a.length() + 1][b.length() + 1];
		countMinNumOfInsertionsDeletions(a, b, a.length(), b.length(), matrix);

	}

	/*
	 * first find LCS then you get "EA" to convert "HEAP" to "EA" we remove "H" and
	 * "P" -> means 2 deletions to convert "EA" to "PEA" we add "P" i.e 1
	 * insertions.
	 */
	static void countMinNumOfInsertionsDeletions(String a, String b, int lenOfA, int lenOfB, int[][] dp) {
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
		int lenOfCommSub = dp[lenOfA][lenOfB];
		System.out.println("Deletions " + (lenOfA - lenOfCommSub));
		System.out.println("Insertion " + (lenOfB - lenOfCommSub));
	}
}