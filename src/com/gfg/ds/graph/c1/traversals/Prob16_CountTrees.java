package com.gfg.ds.graph.c1.traversals;

import java.util.LinkedList;

public class Prob16_CountTrees {

	public static void main(String[] args) {
		Graph g = new Graph(5, "dir");
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(3, 4);

		g.countForest();
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

		public void addEdge(int v, int w) {
			if ("dir".equalsIgnoreCase(dirOrUndi)) {
				adj[v].add(w);
			} else {
				// this.adjMatrix[start][end] = 1;
				// this.adjMatrix[end][start] = 1;
			}
		}

		void countForest() {
			boolean[] visited = new boolean[vertexCount];
			int count = 0;
			for (int i = 0; i < vertexCount; i++) {
				if (visited[i] == false) {
					DFSUtil(i, visited);
					count++;
				}
			}
			System.out.println("Total forests: " + count);
		}

		private void DFSUtil(int i, boolean[] visited) {

			visited[i] = true;
			System.out.println(i + " -> ");
			for (Integer adj : adj[i]) {
				if (!visited[adj]) {
					DFSUtil(adj, visited);
				}
			}
		}
	}
}
