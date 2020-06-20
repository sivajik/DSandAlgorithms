package com.gfg.algorithms.dp.basic;

public class Prob008_GoldMining {

	public static void main(String[] args) {
		System.out.println(calcGoldMine(new int[][] { { 1, 3, 3 }, { 2, 1, 4 }, { 0, 6, 4 } }));
		System.out
				.println(calcGoldMine(new int[][] { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0, 6, 1, 2 } }));
		System.out.println(
				calcGoldMine(new int[][] { { 10, 33, 13, 15 }, { 22, 21, 04, 1 }, { 5, 0, 2, 3 }, { 0, 6, 14, 2 } }));

	}

	private static int calcGoldMine(int[][] mat) {
		int max = -1;

		int totalRows = mat.length, totalCols = mat[0].length;

		for (int col = totalCols - 1; col >= 0; col--) {
			for (int row = 0; row < totalRows; row++) {
				int rightValue = col == totalCols - 1 ? 0 : mat[row][col + 1];
				int rightUpValue = col == totalCols - 1 || row == 0 ? 0 : mat[row - 1][col + 1];
				int rightDownValue = col == totalCols - 1 || row == totalRows - 1 ? 0 : mat[row + 1][col + 1];

				int maxOfThree = Math.max(rightValue, Math.max(rightUpValue, rightDownValue));
				mat[row][col] = mat[row][col] + maxOfThree;
			}
		}

		for (int i = 0; i < totalRows; i++) {
			max = Math.max(max, mat[i][0]);
		}

		return max;
	}

}
