package com.gfg.ds.graph.traversals;

import java.util.Stack;

public class Prob10_DFSIterative {

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 4);

		g.traverseDFS();
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
		private int vertexCount = 0;
		private int[][] adjMatrix;
		private Vertex[] vertexList;

		public Graph(int totalCount) {
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
		}

		public void addEdge(int start, int end) {
			this.adjMatrix[start][end] = 1;
			this.adjMatrix[end][start] = 1;
		}

		public void traverseDFS() {
			Stack<Vertex> stack = new Stack<>();
			Vertex s = vertexList[0];
			s.visited = true;
			
			stack.push(s);
			System.out.print(s.id + " -> ");

			while (!stack.isEmpty()) {
				Vertex v = stack.peek();

				int adj = -1;
				adj = getAdjUnVisitedVertext(v.id);

				if (adj == -1) {
					stack.pop();
				} else {
					vertexList[adj].visited = true;
					stack.push(vertexList[adj]);
					System.out.print(vertexList[adj].id + " -> ");
				}
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
