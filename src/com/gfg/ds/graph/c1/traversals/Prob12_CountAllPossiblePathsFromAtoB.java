package com.gfg.ds.graph.c1.traversals;

import java.util.Iterator;
import java.util.LinkedList;

public class Prob12_CountAllPossiblePathsFromAtoB {

	public static void main(String[] args) {
		Graph g = new Graph(5, "dir");
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 4);

		int s = 0, d = 3;
		System.out.println(g.countPaths(s, d));
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
		LinkedList<Integer> adj[];
		private Vertex[] vertexList;

		public Graph(int totalCount, String dirOrUndi) {
			this.vertexList = new Vertex[totalCount];
			this.vertexCount = totalCount;
			for (int i = 0; i < totalCount; i++) {
				vertexList[i] = new Vertex(i);
			}
			this.adj = new LinkedList[totalCount];
			for (int i = 0; i < totalCount; ++i) {
				adj[i] = new LinkedList<>();
			}
			this.dirOrUndi = dirOrUndi;
		}

		public void addVertex(char c) {
			vertexList[vertexCount++] = new Vertex(c);
		}

		public void addEdge(int v, int w) {
			if ("dir".equalsIgnoreCase(dirOrUndi)) {
				adj[v].add(w);
			} else {
				// this.adjMatrix[start][end] = 1;
				// this.adjMatrix[end][start] = 1;
			}
		}

		int countPathsUtil(int u, int d, int pathCount) {
			if (u == d) {
				pathCount++;
			} else {
				Iterator<Integer> i = adj[u].listIterator();
				while (i.hasNext()) {
					int n = i.next();
					pathCount = countPathsUtil(n, d, pathCount);
				}
			}
			return pathCount;
		}

		int countPaths(int s, int d) {
			int pathCount = 0;
			pathCount = countPathsUtil(s, d, pathCount);
			return pathCount;
		}
	}
}
