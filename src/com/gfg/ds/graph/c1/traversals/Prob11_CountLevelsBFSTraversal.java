package com.gfg.ds.graph.c1.traversals;

import java.util.LinkedList;
import java.util.Queue;

public class Prob11_CountLevelsBFSTraversal {

	public static void main(String[] args) {
		Graph g = new Graph(7);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(1, 5);
		g.addEdge(2, 6);

		g.countLevels();
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

		public void countLevels() {
			int c = 0;

			Queue<Vertex> q = new LinkedList<>();

			Vertex source = vertexList[0];
			source.visited = true;

			q.add(source);
			c++;
			while (!q.isEmpty()) {
				Vertex vert = q.poll();
				int adjVert = -1;
				boolean levelCompl = false;
				while ((adjVert = getAdjUnVisitedVertext(vert.id)) != -1) {
					System.out.println("Visiting: " + adjVert);
					vertexList[adjVert].visited = true;
					q.add(vertexList[adjVert]);
					levelCompl = true;
				}
				if (levelCompl) {
					c++;
				}
			}

			System.out.println("total levels: " + (c - 1));
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
