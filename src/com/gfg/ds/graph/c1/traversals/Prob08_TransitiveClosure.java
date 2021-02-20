package com.gfg.ds.graph.c1.traversals;

import java.util.Arrays;
import java.util.Stack;

public class Prob08_TransitiveClosure {

	public static void main(String[] args) {
		Graph g = new Graph(4, "dir");
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		// g.addEdge(2, 0);
		g.addEdge(2, 3);

		g.prepareTrasClosure();
	}

	static class Vertex {
		int id;
		boolean visited;

		Vertex(int label) {
			this.id = label;
			this.visited = false;
		}
	}

	static class Graph {
		private String dirOrUndi;
		private int vertexCount = 0;
		private int[][] adjMatrix;
		private Vertex[] vertexList;

		public Graph(int totalCount, String dirOrUndi) {
			this.vertexList = new Vertex[totalCount];
			this.vertexCount = totalCount;
			for (int i = 0; i < totalCount; i++) {
				vertexList[i] = new Vertex(i);
			}
			adjMatrix = new int[vertexCount][vertexCount];
			for (int i = 0; i < vertexCount; i++) {
				for (int j = 0; j < vertexCount; j++) {
					adjMatrix[i][j] = 0;
				}
			}
			this.dirOrUndi = dirOrUndi;
		}

		public void addEdge(int start, int end) {
			if ("dir".equalsIgnoreCase(dirOrUndi)) {
				this.adjMatrix[start][end] = 1;
			} else {
				this.adjMatrix[start][end] = 1;
				this.adjMatrix[end][start] = 1;
			}
		}

		public void prepareTrasClosure() {
			int[][] op = new int[vertexCount][vertexCount];

			for (int i = 0; i < vertexCount; i++) {
				op[i][i] = 1;

				Stack<Vertex> stack = new Stack<>();
				stack.push(vertexList[i]);
				vertexList[i].visited = true;

				while (!stack.isEmpty()) {
					Vertex ver = stack.peek();
					int v = getAdjUnVisitedVertext(ver.id);
					if (v == -1) {
						stack.pop();
					} else {
						op[i][v] = 1;
						vertexList[v].visited = true;
						stack.push(vertexList[v]);
					}
				}

				for (int j = 0; j < vertexCount; j++) {
					vertexList[j].visited = false;
				}

			}
			// print op
			for (int[] row : op) {
				System.out.println(Arrays.toString(row));
			}
		}

		private int getAdjUnVisitedVertext(int vertex) {
			for (int i = 0; i < vertexCount; i++) {
				if (i != vertex && adjMatrix[vertex][i] == 1 && vertexList[i].visited == false) {
					return i;
				}
			}
			return -1;
		}

	}
}
