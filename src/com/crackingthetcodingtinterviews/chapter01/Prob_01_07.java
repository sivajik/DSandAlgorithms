package com.crackingthetcodingtinterviews.chapter01;

import java.util.Arrays;

public class Prob_01_07 {

	public static void main(String[] args) {
		rotateBy90(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 0, 2, 1 }, { 8, 6, 3, 9 } });
	}

	private static void rotateBy90(int[][] m) {
		int[][] t = new int[m.length][m.length];

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				t[i][j] = m[j][i];
			}
		}

		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length / 2; j++) {
				int temp = t[i][j];
				t[i][j] = t[i][t.length - j-1];
				t[i][t.length - j-1] = temp;
			}
		}

		for (int i = 0; i < t.length; i++) {
			System.out.println(Arrays.toString(t[i]));
		}
	}
}
