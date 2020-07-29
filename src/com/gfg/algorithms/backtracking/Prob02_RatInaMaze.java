package com.gfg.algorithms.backtracking;

public class Prob02_RatInaMaze {

	public static void main(String[] args) {
		Prob02_RatInaMaze rat = new Prob02_RatInaMaze();
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		rat.solveMaze(maze);
	}

	private void solveMaze(int[][] maze) {
		int[][] solution = new int[maze.length][maze[0].length];
		int i = 0;
		int j = 0;
		if (solved(maze, i, j, solution)) {
			print(solution);
		}
	}

	private boolean solved(int[][] maze, int i, int j, int[][] solution) {
		if (i == solution.length -1 && j == solution[0].length - 1 && maze[i][j] == 1) {
			solution[i][j] = 1;
			return true;
		}
		
		if (isSafe(maze, i, j)) {
			solution[i][j] = 1;
			if (solved(maze, i+1, j, solution)) {
				return true;
			}
			if (solved(maze, i, j+1, solution)) {
				return true; 
			}
			solution[i][j] = 0;
			return false;
		}
		return false;
	}

	private boolean isSafe(int[][] maze, int i, int j) {
		if ( i >= maze.length || j >= maze.length || maze[i][j] == 0) {
			return false;
		}
		return true;
	}

	private void print(int[][] solution) {
		System.out.println("Solution::");
		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution[i].length; j++) {
				System.out.print(solution[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
