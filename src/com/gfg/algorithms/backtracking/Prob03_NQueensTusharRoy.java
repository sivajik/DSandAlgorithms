package com.gfg.algorithms.backtracking;

import java.util.Arrays;

public class Prob03_NQueensTusharRoy {

	public static void main(String[] args) {
		Prob03_NQueensTusharRoy Queen = new Prob03_NQueensTusharRoy();
		Queen.solveNQ();
	}

	private void solveNQ() {
		int[][] board = new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		Position[] positions = new Position[board.length];

		solve(board, 0, positions);
	}

	private boolean solve(int[][] board, int row, Position[] positions) {
		if (row == board.length) {
			Arrays.stream(positions).forEach(position -> {
				System.out.println(position);
			});
			System.out.println("==========");
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
