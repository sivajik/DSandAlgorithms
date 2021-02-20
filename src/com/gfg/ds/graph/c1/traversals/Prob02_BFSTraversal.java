package com.gfg.ds.graph.c1.traversals;

import java.util.LinkedList;
import java.util.Queue;

public class Prob02_BFSTraversal {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addVertex('F');
		g.addVertex('G');
		g.addVertex('H');

		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 5);
		g.addEdge(3, 6);
		g.addEdge(4, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);

		g.bfs();
	}

	static class Vertex {
		char label;
		boolean visited;

		Vertex(char label) {
			this.label = label;
			this.visited = false;
		}
	}

	static class Graph {
		private int vertexCount = 0;
		private final int maxVertices = 20;
		private Queue<Integer> queue;
		private int[][] adjMatrix;
		private Vertex[] vertexList;

		public Graph() {
			vertexList = new Vertex[maxVertices];
			adjMatrix = new int[maxVertices][maxVertices];
			for (int i = 0; i < maxVertices; i++) {
				for (int j = 0; j < maxVertices; j++) {
					adjMatrix[i][j] = 0;
				}
			}
			queue = new LinkedList<Integer>();
		}

		public void addVertex(char c) {
			vertexList[vertexCount++] = new Vertex(c);
		}

		public void addEdge(int start, int end) {
			this.adjMatrix[start][end] = 1;
			this.adjMatrix[end][start] = 1;
		}

		public void bfs() {
			vertexList[0].visited = true;
			System.out.print(vertexList[0].label + " -> ");
			queue.add(0);

			while (!queue.isEmpty()) {
				int v1 = queue.poll();
				int v2;
				while ((v2 = getAdjUnVisitedVertext(v1)) != -1) {
					vertexList[v2].visited = true;
					System.out.print(vertexList[v2].label + " -> ");
					queue.add(v2);
				}
			}
			for (int i = 0; i < vertexCount; i++) {
				vertexList[i].visited = false;
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
