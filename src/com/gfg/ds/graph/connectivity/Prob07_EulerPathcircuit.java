package com.gfg.ds.graph.connectivity;

import java.util.LinkedList;

public class Prob07_EulerPathcircuit {
	public static void main(String[] args) {
		// Let us create and test graphs shown in above figures
		Graph g1 = new Graph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		g1.test();

		Graph g2 = new Graph(5);
		g2.addEdge(1, 0);
		g2.addEdge(0, 2);
		g2.addEdge(2, 1);
		g2.addEdge(0, 3);
		g2.addEdge(3, 4);
		g2.addEdge(4, 0);
		g2.test();

		Graph g3 = new Graph(5);
		g3.addEdge(1, 0);
		g3.addEdge(0, 2);
		g3.addEdge(2, 1);
		g3.addEdge(0, 3);
		g3.addEdge(3, 4);
		g3.addEdge(1, 3);
		g3.test();

		// Let us create a graph with 3 vertices
		// connected in the form of cycle
		Graph g4 = new Graph(3);
		g4.addEdge(0, 1);
		g4.addEdge(1, 2);
		g4.addEdge(2, 0);
		g4.test();

		// Let us create a graph with all veritces
		// with zero degree
		Graph g5 = new Graph(3);
		g5.test();
	}

	static class Vertex {
		int id;

		Vertex(int label) {
			this.id = label;
		}
	}

	static class Graph {
		private String dirOrUndi;
		private int vertexCount = 0;
		LinkedList<Integer>[] adj;
		private Vertex[] vertexList;

		public Graph(int totalCount) {
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

		public void DFSUtil(int u, boolean[] visited) {
			visited[u] = true;

			for (int adjVert : adj[u]) {
				if (visited[adjVert] == false) {
					DFSUtil(adjVert, visited);
				}
			}
		}

		public boolean isConnected() {
			boolean[] visited = new boolean[vertexCount];
			int i;

			for (i = 0; i < vertexCount; i++) {
				if (adj[i].size() != 0) {
					break;
				}
			}

			if (i == vertexCount) {
				return true;
			}

			DFSUtil(i, visited);

			for (i = 0; i < vertexCount; i++) {
				if (visited[i] == false && adj[i].size() > 0) {
					return false;
				}
			}
			return true;
		}

		// Function to run test cases
		void test() {
			int res = isEulerian();
			if (res == 0)
				System.out.println("graph is not Eulerian");
			else if (res == 1)
				System.out.println("graph has a Euler path");
			else
				System.out.println("graph has a Euler cycle");
		}

		public int isEulerian() {
			boolean[] visited = new boolean[vertexCount];

			if (!isConnected()) {
				return 0;
			}

			int oddCount = 0;
			int i = 0;

			for (i = 0; i < vertexCount; i++) {
				if (adj[i].size() % 2 != 0) {
					oddCount++;
				}
			}
			if (oddCount > 2) {
				return 0;
			}

			return oddCount == 2 ? 1 : 2;
		}

		public void addEdge(int v, int w) {
			adj[v].add(w);
			adj[w].add(v);
		}
	}
}
