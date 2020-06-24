package com.gfg.algorithms.dp.basic;

public class Prob32_LCS {

	public static void main(String[] args) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " + lcs(X, Y, m, n));
		System.out.println("Length of LCS is" + " " + lcsDP(X, Y, m, n));
	}

	private static int lcs(char[] x, char[] y, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}

		if (x[m - 1] == y[n - 1]) {
			return 1 + lcs(x, y, m - 1, n - 1);
		} else {
			return Math.max(lcs(x, y, m - 1, n), lcs(x, y, m, n - 1));
		}
	}

	private static int lcsDP(char[] x, char[] y, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (x[i - 1] == y[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}

			}
		}
		return dp[m][n];
	}
}
