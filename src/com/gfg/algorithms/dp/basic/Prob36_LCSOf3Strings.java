package com.gfg.algorithms.dp.basic;

public class Prob36_LCSOf3Strings {

	public static void main(String[] args) {
		String s1 = "geeks";
		String s2 = "geeksfor";
		String s3 = "geeksforgeeks";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		char[] Z = s3.toCharArray();

		int m = X.length;
		int n = Y.length;
		int o = Z.length;

		System.out.println("Length of LCS is" + " " + lcsDP(X, Y, Z, m, n, o));
	}

	private static int lcsDP(char[] x, char[] y, char[] z, int m, int n, int o) {
		int[][][] dp = new int[m + 1][n + 1][o + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				for (int k = 0; k <= o; k++) {
					if (i == 0 || j == 0 || k == 0) {
						dp[i][j][k] = 0;
					} else if (x[i - 1] == y[j - 1] && y[i - 1] == z[k - 1] && x[i - 1] == z[k - 1]) {
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					} else {
						dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
					}
				}
			}
		}
		return dp[m][n][o];
	}
}
