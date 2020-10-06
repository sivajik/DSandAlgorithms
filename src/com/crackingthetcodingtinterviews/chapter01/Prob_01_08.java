package com.crackingthetcodingtinterviews.chapter01;

import java.util.Arrays;

public class Prob_01_08 {

	public static void main(String[] args) {
		zeroMatrix(new int[][] { { 1, 2, 3, 4 }, { 5, 0, 7, 8 }, { 9, 3, 2, 1 }, { 8, 6, 3, 0 } });
	}

	private static void zeroMatrix(int[][] m) {
		printMatrix(m);

		boolean[] rows = new boolean[m.length];
		boolean[] cols = new boolean[m[0].length];

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}

		for (int i = 0; i < rows.length; i++) {
			if (rows[i] == true) {
				nullifyRow(m, i);
			}
		}

		for (int i = 0; i < cols.length; i++) {
			if (cols[i] == true) {
				nullifyCol(m, i);
			}
		}

		printMatrix(m);
	}

	private static void nullifyCol(int[][] m, int col) {
		for (int i = 0; i < m.length; i++) {
			m[i][col] = 0;
		}

	}

	private static void nullifyRow(int[][] m, int i) {
		for (int col = 0; col < m[i].length; col++) {
			m[i][col] = 0;
		}
	}

	private static void printMatrix(int[][] t) {
		System.out.println();
		for (int i = 0; i < t.length; i++) {
			System.out.println(Arrays.toString(t[i]));
		}
		System.out.println();
	}
}
