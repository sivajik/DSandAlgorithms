package com.dynamicprogramming.lcs;

public class Prob01_LCS_Recusion {

	public static void main(String[] args) {
		String a = "ABCDGH";
		String b = "AEDFHR";
		System.out.println(lengthOfLCS(a, b, a.length(), b.length()));

		a = "AGGTAB";
		b = "GXTXAYB";
		System.out.println(lengthOfLCS(a, b, a.length(), b.length()));
	}

	static int lengthOfLCS(String a, String b, int lenOfA, int lenOfB) {
		if (lenOfA == 0 || lenOfB == 0) {
			return 0;
		}

		if (a.charAt(lenOfA - 1) == b.charAt(lenOfB - 1)) {
			return 1 + lengthOfLCS(a, b, lenOfA - 1, lenOfB - 1);
		} else {
			return Math.max(lengthOfLCS(a, b, lenOfA - 1, lenOfB), lengthOfLCS(a, b, lenOfA, lenOfB - 1));
		}
	}
}
