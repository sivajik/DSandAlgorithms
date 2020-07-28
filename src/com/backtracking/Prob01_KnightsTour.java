package com.backtracking;

public class Prob01_KnightsTour {

	public static void main(String[] args) {
		int n = 8;
		int[][] board = new int[8][8];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = -1;
			}
		}

		int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		int counter = 0;
		board[0][0] = counter++;
		if (solve(board, 0, 0, counter, xMove, yMove)) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.printf("%2d  ", board[i][j]);
				}
				System.out.println();
			}
		}
	}

	private static boolean solve(int[][] board, int i, int j, int counter, int[] xMove, int[] yMove) {
		if (counter == 64) {
			return true;
		}
		for (int c = 0; c < 8; c++) {
			int nextI = i + xMove[c];
			int nextJ = j + yMove[c];
			if (isSafe(nextI, nextJ, board)) {
				board[nextI][nextJ] = counter;
				if (solve(board, nextI, nextJ, counter+1, xMove, yMove)) {
					return true;
				} else {
					board[nextI][nextJ] = -1;
				}
			}
		}
		return false;
	}

	private static boolean isSafe(int i, int j, int[][] board) {
		return i >= 0 && i < 8 && j >= 0 && j < 8 && board[i][j] == -1;
	}

}
