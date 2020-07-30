package com.gfg.algorithms.backtracking;

import java.util.Arrays;

public class Prob03_NQueensTusharRoyNQueens {

	public static void main(String[] args) {
		Prob03_NQueensTusharRoyNQueens Queen = new Prob03_NQueensTusharRoyNQueens();
		Queen.solveNQ();
	}

	private void solveNQ() {
		int[][] board = new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		Position[] positions = new Position[board.length];

		if (solve(board, 0, positions) == false) {
			System.out.println("Unfortunately there is no solution exists..");
		} else {
			// Arrays.stream(positions).forEach(position -> System.out.println(position.row
			// + " " + position.col));
			Arrays.stream(positions).forEach(position -> {
				board[position.row][position.col] = 1;
			});

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	private boolean solve(int[][] board, int row, Position[] positions) {
		if (row >= board.length) {
			return true;
		}

		for (int col = 0; col < board.length; col++) {
			boolean foundSafe = true;

			for (int queen = 0; queen < row; queen++) {
				if (positions[queen].col == col || positions[queen].row - positions[queen].col == row - col
						|| positions[queen].row + positions[queen].col == row + col) {
					foundSafe = false;
					break;
				}
			}

			if (foundSafe) {
				positions[row] = new Position(row, col);
				if (solve(board, row + 1, positions)) {
					return true;
				}
			}
		}
		return false;
	}

	static class Position {
		int row, col;

		Position(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "{" + row + "," + col + "}";
		}
	}
}
