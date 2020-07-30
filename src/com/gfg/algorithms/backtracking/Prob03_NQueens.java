package com.gfg.algorithms.backtracking;

public class Prob03_NQueens {

	public static void main(String[] args) {
		Prob03_NQueens Queen = new Prob03_NQueens();
		Queen.solveNQ();
	}

	private void solveNQ() {
		int[][] board = new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		if (solve(board, 0) == false) {
			System.out.println("Unfortunately there is no solution exists..");
		} else {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

	private boolean solve(int[][] board, int currCol) {
		if (currCol >= board.length) {
			return true;
		}

		for (int i = 0; i < board.length; i++) {
			if (isSafe(board, i, currCol)) {
				board[i][currCol] = 1;
				if (solve(board, currCol + 1)) {
					return true;
				} else {
					board[i][currCol] = 0;
				}
			}
		}
		// TODO Auto-generated method stub
		return false;
	}

	boolean isSafe(int board[][], int row, int col) {
		int i, j;

		/* Check this row on left side */
		for (i = 0; i < col; i++)
			if (board[row][i] == 1)
				return false;

		/* Check upper diagonal on left side */
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		/* Check lower diagonal on left side */
		for (i = row, j = col; j >= 0 && i < board.length; i++, j--)
			if (board[i][j] == 1)
				return false;

		return true;
	}
}
