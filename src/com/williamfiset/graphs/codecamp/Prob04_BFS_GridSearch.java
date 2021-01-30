package com.williamfiset.graphs.codecamp;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Prob04_BFS_GridSearch {

	public static void main(String[] args) {
		char[][] grid = new char[][] { { '.', '.', '.', 'X', '.', '.', '.' }, { '.', 'X', '.', '.', '.', 'X', '.' },
				{ '.', 'X', '.', '.', '.', '.', '.' }, { '.', '.', 'X', 'X', '.', '.', '.' },
				{ 'X', '.', 'X', '.', '.', 'X', '.' } };
		print(grid, new Point(0, 0), new Point(4, 3));

	}

	private static void print(char[][] grid, Point a, Point b) {
		Map<Point, Point> prev = new HashMap<>();

		int[][] dir = new int[][] { { -1, 0 }, { +1, 0 }, { 0, -1 }, { 0, +1 } };
		Queue<Point> q = new ArrayDeque<>();
		q.add(a);

		boolean[][] visited = new boolean[grid.length][grid[0].length];
		visited[a.x][a.y] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int newR = p.x + dir[i][0];
				int newC = p.y + dir[i][1];

				if (newR < 0 || newC < 0 || newR >= grid.length || newC >= grid[0].length) {
					continue; // as its out of bounds.
				} else if (grid[newR][newC] == 'X') {
					continue;
				} else if (grid[newR][newC] == '.' && visited[newR][newC] == false) {
					Point newPoint = new Point(newR, newC);
					// Imp to add to prev and mark them visited.
					prev.put(newPoint, p);
					visited[newR][newC] = true;

					if (newPoint.equals(b)) {
						break;
					} else {
						q.add(newPoint);
					}
				}
			}
		}

		while (prev.get(b) != null) {
			System.out.println(b);
			b = prev.get(b);
		}
	}

	static class Point {
		int x;
		int y;

		Point(int a, int b) {
			this.x = a;
			this.y = b;
		}

		public String toString() {
			return "[" + x + "," + y + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
}
