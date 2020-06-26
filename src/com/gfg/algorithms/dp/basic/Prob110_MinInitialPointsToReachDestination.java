package com.gfg.algorithms.dp.basic;

public class Prob110_MinInitialPointsToReachDestination {

	public static void main(String args[]) {
		int points[][] = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		int R = 3, C = 3;
		System.out.println("Minimum Initial Points Required: " + minInitialPoints(points, R, C));
	}

	static int minInitialPoints(int points[][], int m, int n) {
		int[][] dp = new int[m][n];

		if (points[m - 1][n - 1] < 0) {
			dp[m - 1][n - 1] = 1 + Math.abs(points[m - 1][n - 1]);
		} else {
			dp[m - 1][n - 1] = 1;
		}

		// Last ROW
		for (int i = n - 2; i >= 0; i--) {
			dp[m - 1][i] = Math.max(dp[m - 1][i + 1] - points[m - 1][i], 1);
		}
		// Last Column
		for (int i = m - 2; i >= 0; i--) {
			dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - points[i][n - 1], 1);
		}

		// Rest if baby work
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - points[i][j], 1);
			}
		}

		return dp[0][0];
	}

}
